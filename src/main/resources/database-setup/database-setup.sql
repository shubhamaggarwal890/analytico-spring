SET GLOBAL validate_password.length = 4;
SET GLOBAL validate_password_length = 4;
SET GLOBAL validate_password.number_count=0;
SET GLOBAL validate_password_number_count=0;
SET GLOBAL validate_password.mixed_case_count=0;
SET GLOBAL validate_password_mixed_case_count=0;
SET GLOBAL validate_password.special_char_count=0;
SET GLOBAL validate_password_special_char_count=0;
CREATE USER 'analytico'@'localhost' IDENTIFIED BY '1677';
create database analytico;
GRANT ALL PRIVILEGES ON analytico.* TO 'analytico'@'localhost';
FLUSH PRIVILEGES;