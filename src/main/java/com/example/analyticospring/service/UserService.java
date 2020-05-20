package com.example.analyticospring.service;

import com.example.analyticospring.entity.User;
import com.example.analyticospring.repository.UserRepository;
import com.example.analyticospring.service.implementation.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

@Service
@Slf4j
public class UserService implements UserServiceImpl {
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);
    private UserRepository userRepository;

    private static byte[] getSaltPassword() {
        try {
            SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
            byte[] salt = new byte[16];
            secureRandom.nextBytes(salt);
            return salt;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static String getSecurePassword(String password, byte[] salt) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(salt);
            byte[] password_bytes = messageDigest.digest(password.getBytes());
            StringBuilder stringBuilder = new StringBuilder();
            for (byte password_byte : password_bytes) {
                stringBuilder.append(Integer.toString((password_byte & 0xff) + 0x100, 16).substring(1));
            }
            return stringBuilder.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User signup(String first_name, String last_name, String email, String password) {
        User user = new User();
        user.setFirstName(first_name);
        user.setLastName(last_name);
        user.setEmailId(email);
        byte[] salt = getSaltPassword();
        if (salt == null) {
            logger.debug("{} couldn't generate the salt for password", user.getEmailId());
            return null;
        }
        user.setSalt(salt);

        String secure_password = getSecurePassword(password, salt);
        if (secure_password == null) {
            logger.debug("{} couldn't generate the secure password", user.getEmailId());
            return null;
        }
        user.setPassword(secure_password);
        try {
            user = userRepository.save(user);
            logger.info("{} successfully saved in to database", user.getEmailId());
            return user;
        } catch (DataAccessException error) {
            logger.error("Error while saving the user {} {}", user.getEmailId(), error.getLocalizedMessage());
        }
        return null;
    }

    public User signin(String email, String password) {
        User user = getByEmailId(email);
        if (user == null) {
            logger.debug("{} not found in the database", email);
            return null;
        }

        String secure_password = getSecurePassword(password, user.getSalt());
        if (secure_password == null) {
            logger.debug("{} couldn't generate the secure password", user.getEmailId());
            return null;
        }
        if (secure_password.equals(user.getPassword())) {
            return user;
        }
        logger.debug("{} entered the wrong password", user.getEmailId());
        return null;
    }

    public User getByEmailId(String email) {
        return userRepository.getByEmailId(email);
    }

    public User getById(Integer id) {
        return userRepository.findById(id).orElse(null);
    }


}
