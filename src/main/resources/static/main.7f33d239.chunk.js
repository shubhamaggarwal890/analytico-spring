(this["webpackJsonpanalytico-react"] = this["webpackJsonpanalytico-react"] || []).push([[0], {
    315: function (e, t, a) {
        e.exports = a(455)
    }, 455: function (e, t, a) {
        "use strict";
        a.r(t);
        var n = a(0), r = a.n(n), l = a(14), o = a.n(l), s = a(29), i = a(30), c = a(31), m = a(33), u = a(21),
            d = a(536), h = a(35), g = a(308), p = a(6), E = "#FFFFFF", f = {
                black: "#000000",
                white: E,
                primary: {contrastText: E, dark: p.a.indigo[900], main: p.a.indigo[500], light: p.a.indigo[100]},
                secondary: {contrastText: E, dark: p.a.blue[900], main: p.a.blue.A400, light: p.a.blue.A400},
                success: {contrastText: E, dark: p.a.green[900], main: p.a.green[600], light: p.a.green[400]},
                info: {contrastText: E, dark: p.a.blue[900], main: p.a.blue[600], light: p.a.blue[400]},
                warning: {contrastText: E, dark: p.a.orange[900], main: p.a.orange[600], light: p.a.orange[400]},
                error: {contrastText: E, dark: p.a.red[900], main: p.a.red[600], light: p.a.red[400]},
                text: {primary: p.a.blueGrey[900], secondary: p.a.blueGrey[600], link: p.a.blue[600]},
                background: {default: "#F4F6F8", paper: E},
                icon: p.a.blueGrey[600],
                divider: p.a.grey[200]
            }, b = {
                h1: {
                    color: f.text.primary,
                    fontWeight: 500,
                    fontSize: "35px",
                    letterSpacing: "-0.24px",
                    lineHeight: "40px"
                },
                h2: {
                    color: f.text.primary,
                    fontWeight: 500,
                    fontSize: "29px",
                    letterSpacing: "-0.24px",
                    lineHeight: "32px"
                },
                h3: {
                    color: f.text.primary,
                    fontWeight: 500,
                    fontSize: "24px",
                    letterSpacing: "-0.06px",
                    lineHeight: "28px"
                },
                h4: {
                    color: f.text.primary,
                    fontWeight: 500,
                    fontSize: "20px",
                    letterSpacing: "-0.06px",
                    lineHeight: "24px"
                },
                h5: {
                    color: f.text.primary,
                    fontWeight: 500,
                    fontSize: "16px",
                    letterSpacing: "-0.05px",
                    lineHeight: "20px"
                },
                h6: {
                    color: f.text.primary,
                    fontWeight: 500,
                    fontSize: "14px",
                    letterSpacing: "-0.05px",
                    lineHeight: "20px"
                },
                subtitle1: {color: f.text.primary, fontSize: "16px", letterSpacing: "-0.05px", lineHeight: "25px"},
                subtitle2: {
                    color: f.text.secondary,
                    fontWeight: 400,
                    fontSize: "14px",
                    letterSpacing: "-0.05px",
                    lineHeight: "21px"
                },
                body1: {color: f.text.primary, fontSize: "14px", letterSpacing: "-0.05px", lineHeight: "21px"},
                body2: {color: f.text.secondary, fontSize: "12px", letterSpacing: "-0.04px", lineHeight: "18px"},
                button: {color: f.text.primary, fontSize: "14px"},
                caption: {color: f.text.secondary, fontSize: "11px", letterSpacing: "0.33px", lineHeight: "13px"},
                overline: {
                    color: f.text.secondary,
                    fontSize: "11px",
                    fontWeight: 500,
                    letterSpacing: "0.33px",
                    lineHeight: "13px",
                    textTransform: "uppercase"
                }
            }, y = {root: {color: f.icon, "&:hover": {backgroundColor: "rgba(0, 0, 0, 0.03)"}}}, v = a(11), x = {
                MuiButton: {
                    contained: {
                        boxShadow: "0 1px 1px 0 rgba(0,0,0,0.14), 0 2px 1px -1px rgba(0,0,0,0.12), 0 1px 3px 0 rgba(0,0,0,0.20)",
                        backgroundColor: "#FFFFFF"
                    }
                },
                MuiIconButton: y,
                MuiPaper: {elevation1: {boxShadow: "0 0 0 1px rgba(63,63,68,0.05), 0 1px 3px 0 rgba(63,63,68,0.15)"}},
                MuiTableCell: {root: Object(v.a)({}, b.body1, {borderBottom: "1px solid ".concat(f.divider)})},
                MuiTableHead: {root: {backgroundColor: p.a.grey[50]}},
                MuiTypography: {gutterBottom: {marginBottom: 8}}
            }, _ = Object(g.a)({palette: f, typography: b, overrides: x, zIndex: {appBar: 1200, drawer: 1100}}), k = a(8),
            C = a(2), O = a(461), w = a(82), j = (a(158), a(275), Object(O.a)((function (e) {
                return {
                    root: {
                        borderRadius: "4px",
                        alignItems: "center",
                        padding: e.spacing(1),
                        display: "flex",
                        flexBasis: 420
                    },
                    icon: {marginRight: e.spacing(1), color: e.palette.text.secondary},
                    input: {flexGrow: 1, fontSize: "14px", lineHeight: "16px", letterSpacing: "-0.05px"}
                }
            })), a(17)), N = Object(O.a)((function (e) {
                return {
                    root: {display: "inline-block", borderRadius: "50%", flexGrow: 0, flexShrink: 0},
                    sm: {height: e.spacing(1), width: e.spacing(1)},
                    md: {height: e.spacing(2), width: e.spacing(2)},
                    lg: {height: e.spacing(3), width: e.spacing(3)},
                    neutral: {backgroundColor: e.palette.neutral},
                    primary: {backgroundColor: e.palette.primary.main},
                    info: {backgroundColor: e.palette.info.main},
                    warning: {backgroundColor: e.palette.warning.main},
                    danger: {backgroundColor: e.palette.error.main},
                    success: {backgroundColor: e.palette.success.main}
                }
            })), S = function (e) {
                var t, a = e.className, n = e.size, l = e.color, o = Object(k.a)(e, ["className", "size", "color"]),
                    s = N();
                return r.a.createElement("span", Object.assign({}, o, {className: Object(C.a)((t = {}, Object(j.a)(t, s.root, !0), Object(j.a)(t, s[n], n), Object(j.a)(t, s[l], l), t), a)}))
            };
        S.defaultProps = {size: "md", color: "default"};
        var q = function (e) {
                var t = e.layout, a = e.component, n = Object(k.a)(e, ["layout", "component"]);
                return r.a.createElement(u.b, Object.assign({}, n, {
                    render: function (e) {
                        return r.a.createElement(t, null, r.a.createElement(a, e))
                    }
                }))
            }, B = a(13), T = a(165), A = a(285), F = a(65), I = a(325), z = Object(O.a)((function (e) {
                return {root: {padding: e.spacing(4)}}
            })), W = function (e) {
                var t = e.className, a = Object(k.a)(e, ["className"]), n = z();
                return r.a.createElement("div", Object.assign({}, a, {className: Object(C.a)(n.root, t)}), r.a.createElement(F.a, {variant: "body1"}, "\xa9", " ", r.a.createElement(I.a, {
                    component: "a",
                    href: "https://www.iiitb.ac.in/",
                    target: "_blank"
                }, "Analytico"), ". 2020"), r.a.createElement(F.a, {variant: "caption"}, "Analysis for everyone!"))
            }, R = a(329), D = a(331), L = a(279), P = a.n(L), H = a(280), M = a.n(H), U = a(119), G = a.n(U), Q = a(281),
            V = a.n(Q), Y = a(28), $ = a(459), J = a(247), Z = a(19), K = Object(O.a)((function (e) {
                return {
                    root: {display: "flex", flexDirection: "column", alignItems: "center", minHeight: "fit-content"},
                    avatar: {width: 60, height: 60},
                    name: {marginTop: e.spacing(1)},
                    purple: {color: e.palette.getContrastText(J.a[500]), backgroundColor: J.a[500]}
                }
            })), X = Object(Z.b)((function (e) {
                return {id: e.user.id, name: e.user.name}
            }))((function (e) {
                var t = e.className, a = Object(k.a)(e, ["className"]), n = K(),
                    l = {name: e.name, avatar: "images/avatars/avatar_11.png", bio: "Analyzer"};
                return r.a.createElement("div", Object.assign({}, a, {className: Object(C.a)(n.root, t)}), r.a.createElement($.a, {
                    alt: "Person",
                    className: n.purple,
                    component: Y.a,
                    src: l.avatar,
                    to: "/settings"
                }, "S"), r.a.createElement(F.a, {
                    className: n.name,
                    variant: "h4"
                }, l.name), r.a.createElement(F.a, {variant: "body2"}, l.bio))
            })), ee = a(278), te = a(327), ae = a(328), ne = Object(O.a)((function (e) {
                return {
                    root: {},
                    item: {display: "flex", paddingTop: 0, paddingBottom: 0},
                    button: {
                        color: p.a.blueGrey[800],
                        padding: "10px 8px",
                        justifyContent: "flex-start",
                        textTransform: "none",
                        letterSpacing: 0,
                        width: "100%",
                        fontWeight: e.typography.fontWeightMedium
                    },
                    icon: {
                        color: e.palette.icon,
                        width: 24,
                        height: 24,
                        display: "flex",
                        alignItems: "center",
                        marginRight: e.spacing(1)
                    },
                    active: {
                        color: e.palette.primary.main,
                        fontWeight: e.typography.fontWeightMedium,
                        "& $icon": {color: e.palette.primary.main}
                    }
                }
            })), re = Object(n.forwardRef)((function (e, t) {
                return r.a.createElement("div", {ref: t, style: {flexGrow: 1}}, r.a.createElement(Y.b, e))
            })), le = function (e) {
                var t = e.pages, a = e.className, n = Object(k.a)(e, ["pages", "className"]), l = ne();
                return r.a.createElement(ee.a, Object.assign({}, n, {className: Object(C.a)(l.root, a)}), t.map((function (e) {
                    return r.a.createElement(te.a, {
                        className: l.item,
                        disableGutters: !0,
                        key: e.title
                    }, r.a.createElement(ae.a, {
                        activeClassName: l.active,
                        className: l.button,
                        component: re,
                        to: e.href
                    }, r.a.createElement("div", {className: l.icon}, e.icon), e.title))
                })))
            }, oe = Object(O.a)((function (e) {
                return {
                    drawer: Object(j.a)({width: 230}, e.breakpoints.up("lg"), {
                        marginTop: 64,
                        height: "calc(100% - 64px)"
                    }),
                    root: {
                        backgroundColor: e.palette.white,
                        display: "flex",
                        flexDirection: "column",
                        height: "100%",
                        padding: e.spacing(2)
                    },
                    divider: {margin: e.spacing(2, 0)},
                    nav: {marginBottom: e.spacing(2)}
                }
            })), se = function (e) {
                var t = e.open, a = e.variant, n = e.onClose, l = e.className,
                    o = Object(k.a)(e, ["open", "variant", "onClose", "className"]), s = oe(),
                    i = [{title: "Dashboard", href: "/dashboard", icon: r.a.createElement(P.a, null)}, {
                        title: "Facebook",
                        href: "/facebook",
                        icon: r.a.createElement(M.a, null)
                    }, {title: "Twitter", href: "/twitter", icon: r.a.createElement(G.a, null)}, {
                        title: "Reddit",
                        href: "/reddit",
                        icon: r.a.createElement(V.a, null)
                    }, {
                        title: "Quora",
                        href: "/quora",
                        icon: r.a.createElement("img", {alt: "Logo", src: "images/logos/1quora.svg"})
                    }];
                return r.a.createElement(R.a, {
                    anchor: "left",
                    classes: {paper: s.drawer},
                    onClose: n,
                    open: t,
                    variant: a
                }, r.a.createElement("div", Object.assign({}, o, {className: Object(C.a)(s.root, l)}), r.a.createElement(X, null), r.a.createElement(D.a, {className: s.divider}), r.a.createElement(le, {
                    className: s.nav,
                    pages: i
                })))
            }, ie = a(332), ce = a(333), me = a(458), ue = a(335), de = a(287), he = a.n(de), ge = a(286), pe = a.n(ge),
            Ee = Object(O.a)((function (e) {
                return {root: {boxShadow: "none"}, flexGrow: {flexGrow: 1}, signOutButton: {marginLeft: e.spacing(1)}}
            })), fe = function (e) {
                var t = e.className, a = e.onSidebarOpen, n = Object(k.a)(e, ["className", "onSidebarOpen"]), l = Ee(),
                    o = Object(u.g)();
                return r.a.createElement(ie.a, Object.assign({}, n, {className: Object(C.a)(l.root, t)}), r.a.createElement(ce.a, null, r.a.createElement(Y.a, {to: "/"}, r.a.createElement("img", {
                    alt: "Logo",
                    src: "images/logos/logo--white.svg"
                })), r.a.createElement("h4", null, "Analytico"), r.a.createElement("div", {className: l.flexGrow}), r.a.createElement(me.a, {mdDown: !0}, r.a.createElement(ue.a, {
                    className: l.signOutButton,
                    color: "inherit",
                    onClick: function () {
                        o.push("/")
                    }
                }, r.a.createElement(pe.a, null))), r.a.createElement(me.a, {lgUp: !0}, r.a.createElement(ue.a, {
                    color: "inherit",
                    onClick: a
                }, r.a.createElement(he.a, null)))))
            }, be = Object(O.a)((function (e) {
                return {
                    root: Object(j.a)({paddingTop: 56, height: "100%"}, e.breakpoints.up("sm"), {paddingTop: 64}),
                    shiftContent: {paddingLeft: 240},
                    content: {height: "100%"}
                }
            })), ye = function (e) {
                var t, a = e.children, l = be(), o = Object(T.a)(),
                    s = Object(A.a)(o.breakpoints.up("lg"), {defaultMatches: !0}), i = Object(n.useState)(!1),
                    c = Object(B.a)(i, 2), m = c[0], u = c[1], d = !!s || m;
                return r.a.createElement("div", {className: Object(C.a)((t = {}, Object(j.a)(t, l.root, !0), Object(j.a)(t, l.shiftContent, s), t))}, r.a.createElement(fe, {
                    onSidebarOpen: function () {
                        u(!0)
                    }
                }), r.a.createElement(se, {
                    onClose: function () {
                        u(!1)
                    }, open: d, variant: s ? "persistent" : "temporary"
                }), r.a.createElement("main", {className: l.content}, a, r.a.createElement(W, null)))
            }, ve = Object(O.a)((function () {
                return {root: {boxShadow: "none"}}
            })), xe = function (e) {
                var t = e.className, a = Object(k.a)(e, ["className"]), n = ve();
                return r.a.createElement(ie.a, Object.assign({}, a, {
                    className: Object(C.a)(n.root, t),
                    color: "primary",
                    position: "fixed"
                }), r.a.createElement(ce.a, null, r.a.createElement(Y.a, {to: "/"}, r.a.createElement("img", {
                    alt: "Logo",
                    src: "images/logos/logo--white.svg"
                }))))
            }, _e = Object(O.a)((function () {
                return {root: {paddingTop: 64, height: "100%"}, content: {height: "100%"}}
            })), ke = function (e) {
                var t = e.children, a = _e();
                return r.a.createElement("div", {className: a.root}, r.a.createElement(xe, null), r.a.createElement("main", {className: a.content}, t))
            }, Ce = a(339), Oe = a(336), we = a(337), je = a(338), Ne = a(340), Se = a(341),
            qe = (Object(O.a)((function () {
                return {root: {}}
            })), a(342), Object(O.a)((function (e) {
                return {
                    root: {},
                    details: {display: "flex"},
                    avatar: {marginLeft: "auto", height: 110, width: 100, flexShrink: 0, flexGrow: 0},
                    progress: {marginTop: e.spacing(2)},
                    uploadButton: {marginRight: e.spacing(2)}
                }
            })), Object(O.a)((function (e) {
                return {root: {padding: e.spacing(4)}}
            })), Object(O.a)((function (e) {
                return {
                    root: {},
                    row: {height: "42px", display: "flex", alignItems: "center", marginTop: e.spacing(1)},
                    spacer: {flexGrow: 1},
                    importButton: {marginRight: e.spacing(1)}
                }
            }))), Be = function (e) {
                var t = e.className, a = Object(k.a)(e, ["className"]), n = qe();
                return r.a.createElement("div", Object.assign({}, a, {className: Object(C.a)(n.root, t)}), r.a.createElement("div", {className: n.row}, r.a.createElement("span", {className: n.spacer}), "twitter" === e.target ? r.a.createElement(ae.a, {
                    className: n.importButton,
                    color: "primary",
                    onClick: function () {
                        return e.handleReportClick("twitter")
                    }
                }, "Twitter") : r.a.createElement(ae.a, {
                    className: n.importButton, onClick: function () {
                        return e.handleReportClick("twitter")
                    }
                }, "Twitter"), "facebook" === e.target ? r.a.createElement(ae.a, {
                    className: n.importButton,
                    color: "primary",
                    onClick: function () {
                        return e.handleReportClick("facebook")
                    }
                }, "Facebook") : r.a.createElement(ae.a, {
                    className: n.importButton, onClick: function () {
                        return e.handleReportClick("facebook")
                    }
                }, "Facebook"), "reddit" === e.target ? r.a.createElement(ae.a, {
                    className: n.importButton,
                    color: "primary",
                    onClick: function () {
                        return e.handleReportClick("reddit")
                    }
                }, "Reddit") : r.a.createElement(ae.a, {
                    className: n.importButton, onClick: function () {
                        return e.handleReportClick("reddit")
                    }
                }, "Reddit"), "quora" === e.target ? r.a.createElement(ae.a, {
                    className: n.importButton,
                    color: "primary",
                    onClick: function () {
                        return e.handleReportClick("quora")
                    }
                }, "Quora") : r.a.createElement(ae.a, {
                    className: n.importButton, onClick: function () {
                        return e.handleReportClick("quora")
                    }
                }, "Quora")))
            }, Te = a(295), Ae = a.n(Te), Fe = Object(O.a)((function (e) {
                return {
                    root: {height: "100%"},
                    content: {alignItems: "center", display: "flex"},
                    title: {fontWeight: 700},
                    avatar: {backgroundColor: e.palette.error.main, height: 56, width: 56},
                    icon: {height: 32, width: 32},
                    difference: {marginTop: e.spacing(2), display: "flex", alignItems: "center"},
                    differenceIcon: {color: e.palette.error.dark},
                    differenceValue: {color: e.palette.error.dark, marginRight: e.spacing(1)}
                }
            })), Ie = function (e) {
                var t = e.className, a = Object(k.a)(e, ["className"]), n = Fe();
                return r.a.createElement(Oe.a, Object.assign({}, a, {className: Object(C.a)(n.root, t)}), r.a.createElement(je.a, null, r.a.createElement(Ce.a, {
                    container: !0,
                    justify: "space-between"
                }, r.a.createElement(Ce.a, {item: !0}, r.a.createElement(F.a, {
                    className: n.title,
                    color: "textSecondary",
                    gutterBottom: !0,
                    variant: "body2"
                }, "FOLLOWERS"), r.a.createElement(F.a, {variant: "h3"}, e.followers)), r.a.createElement(Ce.a, {item: !0}, r.a.createElement($.a, {className: n.avatar}, r.a.createElement(Ae.a, {className: n.icon}))))))
            }, ze = a(296), We = a.n(ze), Re = Object(O.a)((function (e) {
                return {
                    root: {height: "100%"},
                    content: {alignItems: "center", display: "flex"},
                    title: {fontWeight: 700},
                    avatar: {backgroundColor: e.palette.success.main, height: 56, width: 56},
                    icon: {height: 32, width: 32},
                    difference: {marginTop: e.spacing(2), display: "flex", alignItems: "center"},
                    differenceIcon: {color: e.palette.error.dark},
                    differenceValue: {color: e.palette.error.dark, marginRight: e.spacing(1)}
                }
            })), De = function (e) {
                var t = e.className, a = Object(k.a)(e, ["className"]), n = Re();
                return r.a.createElement(Oe.a, Object.assign({}, a, {className: Object(C.a)(n.root, t)}), r.a.createElement(je.a, null, r.a.createElement(Ce.a, {
                    container: !0,
                    justify: "space-between"
                }, r.a.createElement(Ce.a, {item: !0}, r.a.createElement(F.a, {
                    className: n.title,
                    color: "textSecondary",
                    gutterBottom: !0,
                    variant: "body2"
                }, e.friends_following), r.a.createElement(F.a, {variant: "h3"}, e.friends)), r.a.createElement(Ce.a, {item: !0}, r.a.createElement($.a, {className: n.avatar}, r.a.createElement(We.a, {className: n.icon}))))))
            }, Le = a(297), Pe = a.n(Le), He = Object(O.a)((function (e) {
                return {
                    root: {height: "100%"},
                    content: {alignItems: "center", display: "flex"},
                    title: {fontWeight: 700},
                    avatar: {backgroundColor: e.palette.info.main, height: 56, width: 56},
                    icon: {height: 32, width: 32},
                    difference: {marginTop: e.spacing(2), display: "flex", alignItems: "center"},
                    differenceIcon: {color: e.palette.error.dark},
                    differenceValue: {color: e.palette.error.dark, marginRight: e.spacing(1)}
                }
            })), Me = function (e) {
                var t = e.className, a = Object(k.a)(e, ["className"]), n = He();
                return r.a.createElement(Oe.a, Object.assign({}, a, {className: Object(C.a)(n.root, t)}), r.a.createElement(je.a, null, r.a.createElement(Ce.a, {
                    container: !0,
                    justify: "space-between"
                }, r.a.createElement(Ce.a, {item: !0}, r.a.createElement(F.a, {
                    className: n.title,
                    color: "textSecondary",
                    gutterBottom: !0,
                    variant: "body2"
                }, "HASHTAGS"), r.a.createElement(F.a, {variant: "h3"}, e.hashtags)), r.a.createElement(Ce.a, {item: !0}, r.a.createElement($.a, {className: n.avatar}, r.a.createElement(Pe.a, {className: n.icon}))))))
            }, Ue = Object(O.a)((function (e) {
                return {
                    root: {height: "100%"},
                    content: {alignItems: "center", display: "flex"},
                    title: {fontWeight: 700},
                    avatar: {backgroundColor: e.palette.primary.main, height: 56, width: 56},
                    icon: {height: 32, width: 32},
                    difference: {marginTop: e.spacing(2), display: "flex", alignItems: "center"},
                    differenceIcon: {color: e.palette.error.dark},
                    differenceValue: {color: e.palette.error.dark, marginRight: e.spacing(1)}
                }
            })), Ge = function (e) {
                var t = e.className, a = Object(k.a)(e, ["className"]), n = Ue();
                return r.a.createElement(Oe.a, Object.assign({}, a, {className: Object(C.a)(n.root, t)}), r.a.createElement(je.a, null, r.a.createElement(Ce.a, {
                    container: !0,
                    justify: "space-between"
                }, r.a.createElement(Ce.a, {item: !0}, r.a.createElement(F.a, {
                    className: n.title,
                    color: "textSecondary",
                    gutterBottom: !0,
                    variant: "body2"
                }, "TWEETS"), r.a.createElement(F.a, {variant: "h3"}, e.tweets)), r.a.createElement(Ce.a, {item: !0}, r.a.createElement($.a, {className: n.avatar}, r.a.createElement(G.a, {className: n.icon}))))))
            }, Qe = a(76), Ve = Object(O.a)((function () {
                return {
                    root: {},
                    chartContainer: {height: 400, position: "relative"},
                    actions: {justifyContent: "flex-end"}
                }
            })), Ye = function (e) {
                var t = e.className, a = Object(k.a)(e, ["className"]), n = {
                    labels: e.labels,
                    datasets: [{label: e.label_title, backgroundColor: f.primary.main, data: e.frequency}]
                }, l = {
                    responsive: !0,
                    maintainAspectRatio: !1,
                    animation: !1,
                    legend: {display: !1},
                    cornerRadius: 20,
                    tooltips: {
                        enabled: !0,
                        mode: "index",
                        intersect: !1,
                        borderWidth: 1,
                        borderColor: f.divider,
                        backgroundColor: f.white,
                        titleFontColor: f.text.primary,
                        bodyFontColor: f.text.secondary,
                        footerFontColor: f.text.secondary
                    },
                    layout: {padding: 0},
                    scales: {
                        xAxes: [{
                            barThickness: 12,
                            maxBarThickness: 10,
                            barPercentage: .5,
                            categoryPercentage: .5,
                            ticks: {fontColor: f.text.secondary},
                            gridLines: {display: !1, drawBorder: !1}
                        }],
                        yAxes: [{
                            ticks: {fontColor: f.text.secondary, beginAtZero: !0, min: 0},
                            gridLines: {
                                borderDash: [2],
                                borderDashOffset: [2],
                                color: f.divider,
                                drawBorder: !1,
                                zeroLineBorderDash: [2],
                                zeroLineBorderDashOffset: [2],
                                zeroLineColor: f.divider
                            }
                        }]
                    }
                }, o = Ve();
                return r.a.createElement(Oe.a, Object.assign({}, a, {className: Object(C.a)(o.root, t)}), r.a.createElement(we.a, {title: e.title}), r.a.createElement(D.a, null), r.a.createElement(je.a, null, r.a.createElement("div", {className: o.chartContainer}, r.a.createElement(Qe.a, {
                    data: n,
                    options: l
                }))), r.a.createElement(D.a, null))
            }, $e = a(299), Je = a.n($e), Ze = a(300), Ke = a.n(Ze), Xe = a(301), et = a.n(Xe),
            tt = Object(O.a)((function (e) {
                return {
                    root: {height: "100%"},
                    chartContainer: {position: "relative", height: "300px"},
                    stats: {marginTop: e.spacing(2), display: "flex", justifyContent: "center"},
                    device: {textAlign: "center", padding: e.spacing(1)},
                    deviceIcon: {color: e.palette.icon}
                }
            })), at = function (e) {
                var t = e.className, a = Object(k.a)(e, ["className"]), n = tt(), l = Object(T.a)(), o = {
                    datasets: [{
                        data: e.value,
                        backgroundColor: [l.palette.primary.main, l.palette.warning.main, l.palette.error.main],
                        borderWidth: 8,
                        borderColor: l.palette.white,
                        hoverBorderColor: l.palette.white
                    }], labels: ["Positive", "Neutral", "Negative"]
                }, s = {
                    legend: {display: !1},
                    responsive: !0,
                    maintainAspectRatio: !1,
                    animation: !1,
                    cutoutPercentage: 80,
                    layout: {padding: 0},
                    tooltips: {
                        enabled: !0,
                        mode: "index",
                        intersect: !1,
                        borderWidth: 1,
                        borderColor: l.palette.divider,
                        backgroundColor: l.palette.white,
                        titleFontColor: l.palette.text.primary,
                        bodyFontColor: l.palette.text.secondary,
                        footerFontColor: l.palette.text.secondary
                    }
                }, i = [{
                    title: "Positive",
                    value: e.value[0],
                    icon: r.a.createElement(Je.a, null),
                    color: l.palette.primary.main
                }, {
                    title: "Neutral",
                    value: e.value[1],
                    icon: r.a.createElement(Ke.a, null),
                    color: l.palette.warning.main
                }, {
                    title: "Negative",
                    value: e.value[2],
                    icon: r.a.createElement(et.a, null),
                    color: l.palette.error.main
                }];
                return r.a.createElement(Oe.a, Object.assign({}, a, {className: Object(C.a)(n.root, t)}), r.a.createElement(we.a, {title: e.title}), r.a.createElement(D.a, null), r.a.createElement(je.a, null, r.a.createElement("div", {className: n.chartContainer}, r.a.createElement(Qe.b, {
                    data: o,
                    options: s
                })), r.a.createElement("div", {className: n.stats}, i.map((function (e) {
                    return r.a.createElement("div", {
                        className: n.device,
                        key: e.title
                    }, r.a.createElement("span", {className: n.deviceIcon}, e.icon), r.a.createElement(F.a, {variant: "body1"}, e.title), r.a.createElement(F.a, {
                        style: {color: e.color},
                        variant: "h2"
                    }, e.value, "%"))
                })))))
            }, nt = Object(O.a)((function (e) {
                return {
                    root: {height: "100%"},
                    chartContainer: {position: "relative", height: "300px"},
                    stats: {marginTop: e.spacing(2), display: "flex", justifyContent: "center"},
                    device: {textAlign: "center", padding: e.spacing(1)},
                    deviceIcon: {color: e.palette.icon}
                }
            })), rt = function (e) {
                var t = e.className, a = Object(k.a)(e, ["className"]), n = nt(), l = Object(T.a)(), o = {
                    datasets: [{
                        data: e.value,
                        backgroundColor: [l.palette.primary.main, l.palette.error.main],
                        borderWidth: 8,
                        borderColor: l.palette.white,
                        hoverBorderColor: l.palette.white
                    }], labels: ["True", "False"]
                }, s = {
                    legend: {display: !1},
                    responsive: !0,
                    maintainAspectRatio: !1,
                    animation: !1,
                    cutoutPercentage: 80,
                    layout: {padding: 0},
                    tooltips: {
                        enabled: !0,
                        mode: "index",
                        intersect: !1,
                        borderWidth: 1,
                        borderColor: l.palette.divider,
                        backgroundColor: l.palette.white,
                        titleFontColor: l.palette.text.primary,
                        bodyFontColor: l.palette.text.secondary,
                        footerFontColor: l.palette.text.secondary
                    }
                }, i = [{title: "True", value: e.value[0], color: l.palette.primary.main}, {
                    title: "False",
                    value: e.value[1],
                    color: l.palette.error.main
                }];
                return r.a.createElement(Oe.a, Object.assign({}, a, {className: Object(C.a)(n.root, t)}), r.a.createElement(we.a, {title: e.title}), r.a.createElement(D.a, null), r.a.createElement(je.a, null, r.a.createElement("div", {className: n.chartContainer}, r.a.createElement(Qe.b, {
                    data: o,
                    options: s
                })), r.a.createElement("div", {className: n.stats}, i.map((function (e) {
                    return r.a.createElement("div", {
                        className: n.device,
                        key: e.title
                    }, r.a.createElement("span", {className: n.deviceIcon}, e.icon), r.a.createElement(F.a, {variant: "body1"}, e.title), r.a.createElement(F.a, {
                        style: {color: e.color},
                        variant: "h2"
                    }, e.value, "%"))
                })))))
            }, lt = a(534), ot = a(456), st = a(450), it = a(537), ct = a(18), mt = a.n(ct);

        function ut(e) {
            return r.a.createElement(it.a, Object.assign({elevation: 6, variant: "filled"}, e))
        }

        var dt = function (e) {
            Object(m.a)(a, e);
            var t = Object(c.a)(a);

            function a() {
                var e;
                Object(s.a)(this, a);
                for (var n = arguments.length, r = new Array(n), l = 0; l < n; l++) r[l] = arguments[l];
                return (e = t.call.apply(t, [this].concat(r))).state = {
                    progress: !0,
                    error_snackbar: !1,
                    message: null,
                    following: null,
                    followers: null,
                    tweets_count: null,
                    hashtags_count: null,
                    labels: [],
                    frequency: [],
                    sentiment: [],
                    news: [],
                    question: [],
                    h_sentiment: [],
                    h_news: [],
                    h_question: [],
                    h_name: null
                }, e.handleCloseSnackBar = function () {
                    e.setState(Object(v.a)({}, e.state, {error_snackbar: !1}))
                }, e
            }

            return Object(i.a)(a, [{
                key: "componentDidMount", value: function () {
                    var e = this;
                    mt.a.post("/get_twitter_analysis", {user_id: this.props.id}).then((function (t) {
                        if (t.data.message && e.setState({
                            message: t.data.message,
                            error_snackbar: !0
                        }), t.data.following) {
                            var a = [], n = [], r = [], l = [], o = [], s = [], i = [], c = [];
                            t.data.hashtags && t.data.hashtags.forEach((function (e) {
                                a.push(e.name), n.push(e.number)
                            })), 0 === t.data.s_positive && 0 === t.data.s_negative && 0 === t.data.s_neutral || (r.push(t.data.s_positive), r.push(t.data.s_neutral), r.push(t.data.s_negative)), 0 === t.data.q_true && 0 === t.data.q_false || (o.push(t.data.q_true), o.push(t.data.q_false)), 0 === t.data.n_true && 0 === t.data.n_fake || (l.push(t.data.n_true), l.push(t.data.n_fake)), null !== t.data.h_model && (e.setState({h_name: t.data.h_model.name}), 0 === t.data.h_model.s_positive && 0 === t.data.h_model.s_negative && 0 === t.data.h_model.s_neutral || (s.push(t.data.h_model.s_positive), s.push(t.data.h_model.s_neutral), s.push(t.data.h_model.s_negative)), 0 === t.data.h_model.q_true && 0 === t.data.h_model.q_false || (c.push(t.data.h_model.q_true), c.push(t.data.h_model.q_false)), 0 === t.data.h_model.n_true && 0 === t.data.h_model.n_fake || (i.push(t.data.h_model.n_true), i.push(t.data.h_model.n_fake))), e.setState({
                                following: t.data.following,
                                followers: t.data.followers,
                                screen_name: t.data.screen_name,
                                tweets_count: t.data.tweets_count,
                                hashtags_count: t.data.hashtags_count,
                                progress: !1,
                                labels: a,
                                frequency: n,
                                sentiment: r,
                                news: l,
                                question: o,
                                h_sentiment: s,
                                h_news: i,
                                h_question: c
                            })
                        }
                    })).catch((function (t) {
                        e.setState({
                            error_snackbar: !0,
                            message: "Oh No, You shouldn't have seen this. Some error occurred please try again."
                        })
                    }))
                }
            }, {
                key: "render", value: function () {
                    return r.a.createElement("div", {style: {marginTop: "20px"}}, r.a.createElement(Ce.a, {
                        container: !0,
                        spacing: 4
                    }, r.a.createElement(Ce.a, {
                        item: !0,
                        lg: 3,
                        sm: 6,
                        xl: 3,
                        xs: 12
                    }, this.state.progress ? r.a.createElement(ot.a, {pt: .5}, r.a.createElement(lt.a, {
                        variant: "rect",
                        height: 60,
                        style: {backgroundColor: "#d3d3d3"}
                    }), r.a.createElement(lt.a, {
                        style: {backgroundColor: "#d3d3d3"},
                        animation: "wave"
                    }), r.a.createElement(lt.a, {
                        width: "60%",
                        style: {backgroundColor: "#d3d3d3"}
                    })) : r.a.createElement(Ie, {followers: this.state.followers})), r.a.createElement(Ce.a, {
                        item: !0,
                        lg: 3,
                        sm: 6,
                        xl: 3,
                        xs: 12
                    }, this.state.progress ? r.a.createElement(ot.a, {pt: .5}, r.a.createElement(lt.a, {
                        variant: "rect",
                        height: 60,
                        style: {backgroundColor: "#d3d3d3"}
                    }), r.a.createElement(lt.a, {
                        style: {backgroundColor: "#d3d3d3"},
                        animation: "wave"
                    }), r.a.createElement(lt.a, {
                        width: "60%",
                        style: {backgroundColor: "#d3d3d3"}
                    })) : r.a.createElement(De, {
                        friends_following: "FOLLOWING",
                        friends: this.state.following
                    })), r.a.createElement(Ce.a, {
                        item: !0,
                        lg: 3,
                        sm: 6,
                        xl: 3,
                        xs: 12
                    }, this.state.progress ? r.a.createElement(ot.a, {pt: .5}, r.a.createElement(lt.a, {
                        variant: "rect",
                        height: 60,
                        style: {backgroundColor: "#d3d3d3"}
                    }), r.a.createElement(lt.a, {
                        style: {backgroundColor: "#d3d3d3"},
                        animation: "wave"
                    }), r.a.createElement(lt.a, {
                        width: "60%",
                        style: {backgroundColor: "#d3d3d3"}
                    })) : r.a.createElement(Ge, {tweets: this.state.tweets_count})), r.a.createElement(Ce.a, {
                        item: !0,
                        lg: 3,
                        sm: 6,
                        xl: 3,
                        xs: 12
                    }, this.state.progress ? r.a.createElement(ot.a, {pt: .5}, r.a.createElement(lt.a, {
                        variant: "rect",
                        height: 60,
                        style: {backgroundColor: "#d3d3d3"}
                    }), r.a.createElement(lt.a, {
                        style: {backgroundColor: "#d3d3d3"},
                        animation: "wave"
                    }), r.a.createElement(lt.a, {
                        width: "60%",
                        style: {backgroundColor: "#d3d3d3"}
                    })) : r.a.createElement(Me, {hashtags: this.state.hashtags_count})), this.state.progress ? null : r.a.createElement(r.a.Fragment, null, this.state.labels.length > 0 && this.state.frequency.length > 0 ? r.a.createElement(Ce.a, {
                        item: !0,
                        lg: 8,
                        md: 12,
                        xl: 9,
                        xs: 12
                    }, r.a.createElement(Ye, {
                        labels: this.state.labels,
                        frequency: this.state.frequency,
                        label_title: "Hashtag Frequency",
                        title: "Frequency of HashTags"
                    })) : null, 0 !== this.state.sentiment.length ? r.a.createElement(Ce.a, {
                        item: !0,
                        lg: 4,
                        md: 6,
                        xl: 3,
                        xs: 12
                    }, r.a.createElement(at, {
                        value: this.state.sentiment,
                        title: "Sentiments on " + this.state.screen_name + " timeline"
                    })) : null, 0 !== this.state.news.length ? r.a.createElement(Ce.a, {
                        item: !0,
                        lg: 4,
                        md: 6,
                        xl: 3,
                        xs: 12
                    }, r.a.createElement(rt, {
                        value: this.state.news,
                        title: "Fact Check on " + this.state.screen_name + " timeline"
                    })) : null, 0 !== this.state.question.length ? r.a.createElement(Ce.a, {
                        item: !0,
                        lg: 4,
                        md: 6,
                        xl: 3,
                        xs: 12
                    }, r.a.createElement(rt, {
                        value: this.state.question,
                        title: "Questions on " + this.state.screen_name + " timeline"
                    })) : null, 0 !== this.state.h_news.length ? r.a.createElement(Ce.a, {
                        item: !0,
                        lg: 4,
                        md: 6,
                        xl: 3,
                        xs: 12
                    }, r.a.createElement(rt, {
                        value: this.state.h_news,
                        title: "Fact Check on hashtag " + this.state.h_name
                    })) : null, 0 !== this.state.h_sentiment.length ? r.a.createElement(Ce.a, {
                        item: !0,
                        lg: 4,
                        md: 6,
                        xl: 3,
                        xs: 12
                    }, r.a.createElement(at, {
                        value: this.state.h_sentiment,
                        title: "Sentiments on hashtag " + this.state.h_name
                    })) : null, 0 !== this.state.h_question.length ? r.a.createElement(Ce.a, {
                        item: !0,
                        lg: 4,
                        md: 6,
                        xl: 3,
                        xs: 12
                    }, r.a.createElement(rt, {
                        value: this.state.h_question,
                        title: "Questions on hashtag " + this.state.h_name
                    })) : null)), r.a.createElement(st.a, {
                        open: this.state.error_snackbar,
                        autoHideDuration: 3e3,
                        onClose: this.handleCloseSnackBar
                    }, r.a.createElement(ut, {
                        onClose: this.handleCloseSnackBar,
                        severity: "error"
                    }, this.state.message)))
                }
            }]), a
        }(n.Component), ht = Object(Z.b)((function (e) {
            return {id: e.user.id}
        }))(dt), gt = a(304), pt = a.n(gt), Et = Object(O.a)((function (e) {
            return {
                root: {height: "100%"},
                content: {alignItems: "center", display: "flex"},
                title: {fontWeight: 700},
                avatar: {backgroundColor: e.palette.primary.main, height: 56, width: 56},
                icon: {height: 32, width: 32},
                difference: {marginTop: e.spacing(2), display: "flex", alignItems: "center"},
                differenceIcon: {color: e.palette.error.dark},
                differenceValue: {color: e.palette.error.dark, marginRight: e.spacing(1)}
            }
        })), ft = function (e) {
            var t = e.className, a = Object(k.a)(e, ["className"]), n = Et();
            return r.a.createElement(Oe.a, Object.assign({}, a, {className: Object(C.a)(n.root, t)}), r.a.createElement(je.a, null, r.a.createElement(Ce.a, {
                container: !0,
                justify: "space-between"
            }, r.a.createElement(Ce.a, {item: !0}, r.a.createElement(F.a, {
                className: n.title,
                color: "textSecondary",
                gutterBottom: !0,
                variant: "body2"
            }, "POSTS"), r.a.createElement(F.a, {variant: "h3"}, e.posts)), r.a.createElement(Ce.a, {item: !0}, r.a.createElement($.a, {className: n.avatar}, r.a.createElement(pt.a, {className: n.icon}))))))
        };

        function bt(e) {
            return r.a.createElement(it.a, Object.assign({elevation: 6, variant: "filled"}, e))
        }

        var yt = function (e) {
            Object(m.a)(a, e);
            var t = Object(c.a)(a);

            function a() {
                var e;
                Object(s.a)(this, a);
                for (var n = arguments.length, r = new Array(n), l = 0; l < n; l++) r[l] = arguments[l];
                return (e = t.call.apply(t, [this].concat(r))).state = {
                    progress: !0,
                    error_snackbar: !1,
                    message: null,
                    friends: null,
                    posts_count: null,
                    hashtags_count: null,
                    user_name: null,
                    page_name: null,
                    labels: [],
                    frequency: [],
                    u_sentiment: [],
                    u_question: [],
                    p_sentiment: [],
                    p_question: []
                }, e.handleCloseSnackBar = function () {
                    e.setState(Object(v.a)({}, e.state, {error_snackbar: !1}))
                }, e
            }

            return Object(i.a)(a, [{
                key: "componentDidMount", value: function () {
                    var e = this;
                    mt.a.post("/get_facebook_analysis", {user_id: this.props.id}).then((function (t) {
                        t.data.message && e.setState({
                            message: t.data.message,
                            error_snackbar: !0
                        }), e.setState({
                            friends: t.data.friends,
                            posts_count: null == t.data.post_count ? 0 : t.data.post_count,
                            hashtags_count: null == t.data.hashtags_count ? 0 : t.data.hashtags_count,
                            user_name: t.data.user
                        });
                        var a = [], n = [], r = [], l = [], o = [], s = [];
                        t.data.hashtags.forEach((function (e) {
                            a.push(e.name), l.push(e.number)
                        })), 0 === t.data.s_positive && 0 === t.data.s_negative && 0 === t.data.s_neutral || (n.push(t.data.s_positive), n.push(t.data.s_neutral), n.push(t.data.s_negative)), 0 === t.data.q_true && 0 === t.data.q_false || (r.push(t.data.q_true), r.push(t.data.q_false)), null !== t.data.h_model && (0 === t.data.h_model.s_positive && 0 === t.data.h_model.s_negative && 0 === t.data.h_model.s_neutral || (o.push(t.data.h_model.s_positive), o.push(t.data.h_model.s_neutral), o.push(t.data.h_model.s_negative)), 0 === t.data.h_model.q_true && 0 === t.data.h_model.q_false || (s.push(t.data.h_model.q_true), s.push(t.data.h_model.q_false)), e.setState(Object(v.a)({}, e.state, {page_name: t.data.h_model.name}))), e.setState({
                            labels: a,
                            frequency: l,
                            u_sentiment: n,
                            u_question: r,
                            p_sentiment: o,
                            p_question: s
                        }), null != t.data.friends && e.setState({progress: !1})
                    })).catch((function (t) {
                        e.setState({
                            error_snackbar: !0,
                            message: "Oh No, You shouldn't have seen this. Some error occurred please try again."
                        })
                    }))
                }
            }, {
                key: "render", value: function () {
                    return r.a.createElement("div", {style: {marginTop: "20px"}}, r.a.createElement(Ce.a, {
                        container: !0,
                        spacing: 4
                    }, r.a.createElement(Ce.a, {
                        item: !0,
                        lg: 3,
                        sm: 6,
                        xl: 3,
                        xs: 12
                    }, this.state.progress ? r.a.createElement(ot.a, {pt: .5}, r.a.createElement(lt.a, {
                        variant: "rect",
                        height: 60,
                        style: {backgroundColor: "#d3d3d3"}
                    }), r.a.createElement(lt.a, {
                        style: {backgroundColor: "#d3d3d3"},
                        animation: "wave"
                    }), r.a.createElement(lt.a, {
                        width: "60%",
                        style: {backgroundColor: "#d3d3d3"}
                    })) : r.a.createElement(De, {
                        friends_following: "FRIENDS",
                        friends: this.state.friends
                    })), r.a.createElement(Ce.a, {
                        item: !0,
                        lg: 3,
                        sm: 6,
                        xl: 3,
                        xs: 12
                    }, this.state.progress ? r.a.createElement(ot.a, {pt: .5}, r.a.createElement(lt.a, {
                        variant: "rect",
                        height: 60,
                        style: {backgroundColor: "#d3d3d3"}
                    }), r.a.createElement(lt.a, {
                        style: {backgroundColor: "#d3d3d3"},
                        animation: "wave"
                    }), r.a.createElement(lt.a, {
                        width: "60%",
                        style: {backgroundColor: "#d3d3d3"}
                    })) : r.a.createElement(ft, {posts: this.state.posts_count})), r.a.createElement(Ce.a, {
                        item: !0,
                        lg: 3,
                        sm: 6,
                        xl: 3,
                        xs: 12
                    }, this.state.progress ? r.a.createElement(ot.a, {pt: .5}, r.a.createElement(lt.a, {
                        variant: "rect",
                        height: 60,
                        style: {backgroundColor: "#d3d3d3"}
                    }), r.a.createElement(lt.a, {
                        style: {backgroundColor: "#d3d3d3"},
                        animation: "wave"
                    }), r.a.createElement(lt.a, {
                        width: "60%",
                        style: {backgroundColor: "#d3d3d3"}
                    })) : r.a.createElement(Me, {hashtags: this.state.hashtags_count})), this.state.progress ? null : r.a.createElement(r.a.Fragment, null, this.state.labels.length > 0 && this.state.frequency.length > 0 ? r.a.createElement(Ce.a, {
                        item: !0,
                        lg: 8,
                        md: 12,
                        xl: 9,
                        xs: 12
                    }, r.a.createElement(Ye, {
                        labels: this.state.labels,
                        frequency: this.state.frequency,
                        label_title: "Hashtag Frequency",
                        title: "Frequency of HashTags"
                    })) : null, 0 !== this.state.u_sentiment.length ? r.a.createElement(Ce.a, {
                        item: !0,
                        lg: 4,
                        md: 6,
                        xl: 3,
                        xs: 12
                    }, r.a.createElement(at, {
                        value: this.state.u_sentiment,
                        title: "Sentiments on your timeline - " + this.state.user_name
                    })) : null, 0 !== this.state.u_question.length ? r.a.createElement(Ce.a, {
                        item: !0,
                        lg: 4,
                        md: 6,
                        xl: 3,
                        xs: 12
                    }, r.a.createElement(rt, {
                        value: this.state.u_question,
                        title: "Questions on your timeline - " + this.state.user_name
                    })) : null, 0 !== this.state.p_sentiment.length ? r.a.createElement(Ce.a, {
                        item: !0,
                        lg: 4,
                        md: 6,
                        xl: 3,
                        xs: 12
                    }, r.a.createElement(at, {
                        value: this.state.p_sentiment,
                        title: "Sentiments on your page - " + this.state.page_name
                    })) : null, 0 !== this.state.p_question.length ? r.a.createElement(Ce.a, {
                        item: !0,
                        lg: 4,
                        md: 6,
                        xl: 3,
                        xs: 12
                    }, r.a.createElement(rt, {
                        value: this.state.p_question,
                        title: "Questions on your page - " + this.state.page_name
                    })) : null)), r.a.createElement(st.a, {
                        open: this.state.error_snackbar,
                        autoHideDuration: 3e3,
                        onClose: this.handleCloseSnackBar
                    }, r.a.createElement(bt, {
                        onClose: this.handleCloseSnackBar,
                        severity: "error"
                    }, this.state.message)))
                }
            }]), a
        }(n.Component), vt = Object(Z.b)((function (e) {
            return {id: e.user.id}
        }))(yt), xt = a(305), _t = a.n(xt), kt = Object(O.a)((function (e) {
            return {
                root: {height: "100%"},
                content: {alignItems: "center", display: "flex"},
                title: {fontWeight: 700},
                avatar: {backgroundColor: e.palette.success.main, height: 56, width: 56},
                icon: {height: 32, width: 32},
                difference: {marginTop: e.spacing(2), display: "flex", alignItems: "center"},
                differenceIcon: {color: e.palette.error.dark},
                differenceValue: {color: e.palette.error.dark, marginRight: e.spacing(1)}
            }
        })), Ct = function (e) {
            var t = e.className, a = Object(k.a)(e, ["className"]), n = kt();
            return r.a.createElement(Oe.a, Object.assign({}, a, {className: Object(C.a)(n.root, t)}), r.a.createElement(je.a, null, r.a.createElement(Ce.a, {
                container: !0,
                justify: "space-between"
            }, r.a.createElement(Ce.a, {item: !0}, r.a.createElement(F.a, {
                className: n.title,
                color: "textSecondary",
                gutterBottom: !0,
                variant: "body2"
            }, "COMMENTS"), r.a.createElement(F.a, {variant: "h3"}, e.comments)), r.a.createElement(Ce.a, {item: !0}, r.a.createElement($.a, {className: n.avatar}, r.a.createElement(_t.a, {className: n.icon}))))))
        }, Ot = a(306), wt = a.n(Ot), jt = Object(O.a)((function (e) {
            return {
                root: {height: "100%"},
                content: {alignItems: "center", display: "flex"},
                title: {fontWeight: 700},
                avatar: {backgroundColor: e.palette.primary.main, height: 56, width: 56},
                icon: {height: 32, width: 32},
                difference: {marginTop: e.spacing(2), display: "flex", alignItems: "center"},
                differenceIcon: {color: e.palette.error.dark},
                differenceValue: {color: e.palette.error.dark, marginRight: e.spacing(1)}
            }
        })), Nt = function (e) {
            var t = e.className, a = Object(k.a)(e, ["className"]), n = jt();
            return r.a.createElement(Oe.a, Object.assign({}, a, {className: Object(C.a)(n.root, t)}), r.a.createElement(je.a, null, r.a.createElement(Ce.a, {
                container: !0,
                justify: "space-between"
            }, r.a.createElement(Ce.a, {item: !0}, r.a.createElement(F.a, {
                className: n.title,
                color: "textSecondary",
                gutterBottom: !0,
                variant: "body2"
            }, "UPDOWNS"), r.a.createElement(F.a, {variant: "h3"}, e.updown)), r.a.createElement(Ce.a, {item: !0}, r.a.createElement($.a, {className: n.avatar}, r.a.createElement(wt.a, {className: n.icon}))))))
        };

        function St(e) {
            return r.a.createElement(it.a, Object.assign({elevation: 6, variant: "filled"}, e))
        }

        var qt = function (e) {
            Object(m.a)(a, e);
            var t = Object(c.a)(a);

            function a() {
                var e;
                Object(s.a)(this, a);
                for (var n = arguments.length, r = new Array(n), l = 0; l < n; l++) r[l] = arguments[l];
                return (e = t.call.apply(t, [this].concat(r))).state = {
                    progress: !0,
                    error_snackbar: !1,
                    message: null,
                    subreddit: null,
                    posts_count: null,
                    updown_counts: null,
                    comments_count: null,
                    p_labels: [],
                    p_frequency: [],
                    c_labels: [],
                    c_frequency: [],
                    p_sentiment: [],
                    c_sentiment: [],
                    c_controversy: []
                }, e.handleCloseSnackBar = function () {
                    e.setState(Object(v.a)({}, e.state, {error_snackbar: !1}))
                }, e
            }

            return Object(i.a)(a, [{
                key: "componentDidMount", value: function () {
                    var e = this;
                    mt.a.post("/get_reddit_analysis", {user_id: this.props.id}).then((function (t) {
                        t.data.message && e.setState({
                            message: t.data.message,
                            error_snackbar: !0
                        }), e.setState({
                            updown_counts: null == t.data.updowns ? 0 : t.data.updowns,
                            posts_count: null == t.data.post_count ? 0 : t.data.post_count,
                            comments_count: null == t.data.comments_count ? 0 : t.data.comments_count,
                            subreddit: t.data.subreddit
                        });
                        var a = [], n = [], r = [], l = [], o = [], s = [], i = [];
                        t.data.ups.forEach((function (e) {
                            a.push(e.name), n.push(e.number)
                        })), t.data.comments && (t.data.comments.ups.forEach((function (e) {
                            r.push(e.name), l.push(e.number)
                        })), 0 === t.data.comments.s_positive && 0 === t.data.comments.s_negative && 0 === t.data.comments.s_neutral || (s.push(t.data.comments.s_positive), s.push(t.data.comments.s_neutral), s.push(t.data.comments.s_negative)), 0 === t.data.comments.c_positive && 0 === t.data.comments.c_negative || (i.push(t.data.comments.c_positive), i.push(t.data.comments.c_negative))), 0 === t.data.s_positive && 0 === t.data.s_negative && 0 === t.data.s_neutral || (o.push(t.data.s_positive), o.push(t.data.s_neutral), o.push(t.data.s_negative)), e.setState({
                            p_labels: a,
                            p_frequency: n,
                            c_labels: r,
                            c_frequency: l,
                            p_sentiment: o,
                            c_sentiment: s,
                            c_controversy: i
                        }), null != t.data.post_count && e.setState({progress: !1})
                    })).catch((function (t) {
                        e.setState({
                            error_snackbar: !0,
                            message: "Oh No, You shouldn't have seen this. Some error occurred please try again."
                        })
                    }))
                }
            }, {
                key: "render", value: function () {
                    return r.a.createElement("div", {style: {marginTop: "20px"}}, r.a.createElement(Ce.a, {
                        container: !0,
                        spacing: 4
                    }, r.a.createElement(Ce.a, {
                        item: !0,
                        lg: 3,
                        sm: 6,
                        xl: 3,
                        xs: 12
                    }, this.state.progress ? r.a.createElement(ot.a, {pt: .5}, r.a.createElement(lt.a, {
                        variant: "rect",
                        height: 60,
                        style: {backgroundColor: "#d3d3d3"}
                    }), r.a.createElement(lt.a, {
                        style: {backgroundColor: "#d3d3d3"},
                        animation: "wave"
                    }), r.a.createElement(lt.a, {
                        width: "60%",
                        style: {backgroundColor: "#d3d3d3"}
                    })) : r.a.createElement(ft, {posts: this.state.posts_count})), r.a.createElement(Ce.a, {
                        item: !0,
                        lg: 3,
                        sm: 6,
                        xl: 3,
                        xs: 12
                    }, this.state.progress ? r.a.createElement(ot.a, {pt: .5}, r.a.createElement(lt.a, {
                        variant: "rect",
                        height: 60,
                        style: {backgroundColor: "#d3d3d3"}
                    }), r.a.createElement(lt.a, {
                        style: {backgroundColor: "#d3d3d3"},
                        animation: "wave"
                    }), r.a.createElement(lt.a, {
                        width: "60%",
                        style: {backgroundColor: "#d3d3d3"}
                    })) : r.a.createElement(Ct, {comments: this.state.comments_count})), r.a.createElement(Ce.a, {
                        item: !0,
                        lg: 3,
                        sm: 6,
                        xl: 3,
                        xs: 12
                    }, this.state.progress ? r.a.createElement(ot.a, {pt: .5}, r.a.createElement(lt.a, {
                        variant: "rect",
                        height: 60,
                        style: {backgroundColor: "#d3d3d3"}
                    }), r.a.createElement(lt.a, {
                        style: {backgroundColor: "#d3d3d3"},
                        animation: "wave"
                    }), r.a.createElement(lt.a, {
                        width: "60%",
                        style: {backgroundColor: "#d3d3d3"}
                    })) : r.a.createElement(Nt, {updown: this.state.updown_counts})), r.a.createElement(Ce.a, {
                        item: !0,
                        lg: 3,
                        sm: 6,
                        xl: 3,
                        xs: 12
                    }), this.state.progress ? null : r.a.createElement(r.a.Fragment, null, this.state.p_labels.length > 0 && this.state.p_frequency.length > 0 ? r.a.createElement(Ce.a, {
                        item: !0,
                        lg: 8,
                        md: 12,
                        xl: 9,
                        xs: 12
                    }, r.a.createElement(Ye, {
                        labels: this.state.p_labels,
                        frequency: this.state.p_frequency,
                        label_title: "Ups Frequency",
                        title: "Updown frequency on '" + this.state.subreddit + "' posts"
                    })) : null, 0 !== this.state.p_sentiment.length ? r.a.createElement(Ce.a, {
                        item: !0,
                        lg: 4,
                        md: 6,
                        xl: 3,
                        xs: 12
                    }, r.a.createElement(at, {
                        value: this.state.p_sentiment,
                        title: "Sentiments on your subreddit '" + this.state.subreddit + "' posts "
                    })) : null, this.state.c_labels.length > 0 && this.state.c_frequency.length > 0 ? r.a.createElement(Ce.a, {
                        item: !0,
                        lg: 8,
                        md: 12,
                        xl: 9,
                        xs: 12
                    }, r.a.createElement(Ye, {
                        labels: this.state.c_labels,
                        frequency: this.state.c_frequency,
                        label_title: "Ups Frequency",
                        title: "Updown frequency on '" + this.state.subreddit + "' posts comments"
                    })) : null, 0 !== this.state.c_sentiment.length ? r.a.createElement(Ce.a, {
                        item: !0,
                        lg: 4,
                        md: 6,
                        xl: 3,
                        xs: 12
                    }, r.a.createElement(at, {
                        value: this.state.c_sentiment,
                        title: "Sentiments on your subreddit '" + this.state.subreddit + "' posts comments"
                    })) : null)), r.a.createElement(st.a, {
                        open: this.state.error_snackbar,
                        autoHideDuration: 3e3,
                        onClose: this.handleCloseSnackBar
                    }, r.a.createElement(St, {
                        onClose: this.handleCloseSnackBar,
                        severity: "error"
                    }, this.state.message)))
                }
            }]), a
        }(n.Component), Bt = Object(Z.b)((function (e) {
            return {id: e.user.id}
        }))(qt), Tt = a(307), At = a.n(Tt), Ft = Object(O.a)((function (e) {
            return {
                root: {height: "100%"},
                content: {alignItems: "center", display: "flex"},
                title: {fontWeight: 700},
                avatar: {backgroundColor: e.palette.error.main, height: 56, width: 56},
                icon: {height: 32, width: 32},
                difference: {marginTop: e.spacing(2), display: "flex", alignItems: "center"},
                differenceIcon: {color: e.palette.error.dark},
                differenceValue: {color: e.palette.error.dark, marginRight: e.spacing(1)}
            }
        })), It = function (e) {
            var t = e.className, a = Object(k.a)(e, ["className"]), n = Ft();
            return r.a.createElement(Oe.a, Object.assign({}, a, {className: Object(C.a)(n.root, t)}), r.a.createElement(je.a, null, r.a.createElement(Ce.a, {
                container: !0,
                justify: "space-between"
            }, r.a.createElement(Ce.a, {item: !0}, r.a.createElement(F.a, {
                className: n.title,
                color: "textSecondary",
                gutterBottom: !0,
                variant: "body2"
            }, e.question_answer), r.a.createElement(F.a, {variant: "h3"}, e.questions)), r.a.createElement(Ce.a, {item: !0}, r.a.createElement($.a, {className: n.avatar}, r.a.createElement(At.a, {className: n.icon}))))))
        };

        function zt(e) {
            return r.a.createElement(it.a, Object.assign({elevation: 6, variant: "filled"}, e))
        }

        var Wt = function (e) {
            Object(m.a)(a, e);
            var t = Object(c.a)(a);

            function a() {
                var e;
                Object(s.a)(this, a);
                for (var n = arguments.length, r = new Array(n), l = 0; l < n; l++) r[l] = arguments[l];
                return (e = t.call.apply(t, [this].concat(r))).state = {
                    progress: !0,
                    error_snackbar: !1,
                    message: null,
                    query: null,
                    question: null,
                    questions_count: null,
                    answers_count: null,
                    labels: [],
                    frequency: [],
                    q_sentiment: [],
                    qu_sentiment: []
                }, e.handleCloseSnackBar = function () {
                    e.setState(Object(v.a)({}, e.state, {error_snackbar: !1}))
                }, e
            }

            return Object(i.a)(a, [{
                key: "componentDidMount", value: function () {
                    var e = this;
                    mt.a.post("/get_quora_analysis", {user_id: this.props.id}).then((function (t) {
                        t.data.message && e.setState({
                            message: t.data.message,
                            error_snackbar: !0
                        }), e.setState({
                            query: t.data.query,
                            questions_count: null == t.data.question_count ? 0 : t.data.question_count,
                            answers_count: null == t.data.answer_count ? 0 : t.data.answer_count,
                            question: t.data.question
                        });
                        var a = [], n = [], r = [], l = [];
                        t.data.answers.forEach((function (e) {
                            a.push(e.name), n.push(e.number)
                        })), 0 === t.data.s_positive && 0 === t.data.s_negative && 0 === t.data.s_neutral || (r.push(t.data.s_positive), r.push(t.data.s_neutral), r.push(t.data.s_negative)), 0 === t.data.q_s_positive && 0 === t.data.q_s_negative && 0 === t.data.q_s_neutral || (l.push(t.data.q_s_positive), l.push(t.data.q_s_neutral), l.push(t.data.q_s_negative)), e.setState({
                            labels: a,
                            frequency: n,
                            q_sentiment: r,
                            qu_sentiment: l
                        }), null != t.data.question_count && e.setState({progress: !1})
                    })).catch((function (t) {
                        e.setState({
                            error_snackbar: !0,
                            message: "Oh No, You shouldn't have seen this. Some error occurred please try again."
                        })
                    }))
                }
            }, {
                key: "render", value: function () {
                    return r.a.createElement("div", {style: {marginTop: "20px"}}, r.a.createElement(Ce.a, {
                        container: !0,
                        spacing: 4
                    }, r.a.createElement(Ce.a, {
                        item: !0,
                        lg: 3,
                        sm: 6,
                        xl: 3,
                        xs: 12
                    }, this.state.progress ? r.a.createElement(ot.a, {pt: .5}, r.a.createElement(lt.a, {
                        variant: "rect",
                        height: 60,
                        style: {backgroundColor: "#d3d3d3"}
                    }), r.a.createElement(lt.a, {
                        style: {backgroundColor: "#d3d3d3"},
                        animation: "wave"
                    }), r.a.createElement(lt.a, {
                        width: "60%",
                        style: {backgroundColor: "#d3d3d3"}
                    })) : r.a.createElement(It, {
                        question_answer: "QUESTIONS",
                        questions: this.state.questions_count
                    })), r.a.createElement(Ce.a, {
                        item: !0,
                        lg: 3,
                        sm: 6,
                        xl: 3,
                        xs: 12
                    }), r.a.createElement(Ce.a, {
                        item: !0,
                        lg: 3,
                        sm: 6,
                        xl: 3,
                        xs: 12
                    }, this.state.progress ? r.a.createElement(ot.a, {pt: .5}, r.a.createElement(lt.a, {
                        variant: "rect",
                        height: 60,
                        style: {backgroundColor: "#d3d3d3"}
                    }), r.a.createElement(lt.a, {
                        style: {backgroundColor: "#d3d3d3"},
                        animation: "wave"
                    }), r.a.createElement(lt.a, {
                        width: "60%",
                        style: {backgroundColor: "#d3d3d3"}
                    })) : r.a.createElement(It, {
                        question_answer: "ANSWERS",
                        questions: this.state.answers_count
                    })), r.a.createElement(Ce.a, {
                        item: !0,
                        lg: 3,
                        sm: 6,
                        xl: 3,
                        xs: 12
                    }), this.state.progress ? null : r.a.createElement(r.a.Fragment, null, this.state.labels.length > 0 && this.state.frequency.length > 0 ? r.a.createElement(Ce.a, {
                        item: !0,
                        lg: 8,
                        md: 12,
                        xl: 9,
                        xs: 12
                    }, r.a.createElement(Ye, {
                        labels: this.state.labels,
                        frequency: this.state.frequency,
                        label_title: "Answer Frequency",
                        title: "Answer frequency to questions"
                    })) : null, 0 !== this.state.q_sentiment.length ? r.a.createElement(Ce.a, {
                        item: !0,
                        lg: 4,
                        md: 6,
                        xl: 3,
                        xs: 12
                    }, r.a.createElement(at, {
                        value: this.state.q_sentiment,
                        title: "Sentiments on answer to query"
                    })) : null, 0 !== this.state.qu_sentiment.length ? r.a.createElement(Ce.a, {
                        item: !0,
                        lg: 4,
                        md: 6,
                        xl: 3,
                        xs: 12
                    }, r.a.createElement(at, {
                        value: this.state.qu_sentiment,
                        title: "Sentiments on answer to question"
                    })) : null)), r.a.createElement(st.a, {
                        open: this.state.error_snackbar,
                        autoHideDuration: 3e3,
                        onClose: this.handleCloseSnackBar
                    }, r.a.createElement(zt, {
                        onClose: this.handleCloseSnackBar,
                        severity: "error"
                    }, this.state.message)))
                }
            }]), a
        }(n.Component), Rt = Object(Z.b)((function (e) {
            return {id: e.user.id}
        }))(Wt), Dt = function (e) {
            Object(m.a)(a, e);
            var t = Object(c.a)(a);

            function a() {
                var e;
                Object(s.a)(this, a);
                for (var n = arguments.length, r = new Array(n), l = 0; l < n; l++) r[l] = arguments[l];
                return (e = t.call.apply(t, [this].concat(r))).state = {target: "twitter"}, e.handleReportClick = function (t) {
                    e.setState(Object(v.a)({}, e.state, {target: t}))
                }, e
            }

            return Object(i.a)(a, [{
                key: "render", value: function () {
                    return r.a.createElement("div", {style: {padding: "20px"}}, r.a.createElement(Ce.a, {
                        container: !0,
                        spacing: 4
                    }, r.a.createElement(Be, {
                        handleReportClick: this.handleReportClick,
                        target: this.state.target
                    })), "twitter" === this.state.target ? r.a.createElement(ht, null) : null, "facebook" === this.state.target ? r.a.createElement(vt, null) : null, "quora" === this.state.target ? r.a.createElement(Rt, null) : null, "reddit" === this.state.target ? r.a.createElement(Bt, null) : null)
                }
            }]), a
        }(n.Component), Lt = Object(O.a)((function (e) {
            return {
                root: {padding: e.spacing(4)},
                content: {paddingTop: 150, textAlign: "center"},
                image: {marginTop: 50, display: "inline-block", maxWidth: "100%", width: 560}
            }
        })), Pt = function () {
            var e = Lt();
            return r.a.createElement("div", {className: e.root}, r.a.createElement(Ce.a, {
                container: !0,
                justify: "center",
                spacing: 4
            }, r.a.createElement(Ce.a, {
                item: !0,
                lg: 6,
                xs: 12
            }, r.a.createElement("div", {className: e.content}, r.a.createElement(F.a, {variant: "h1"}, "404: The page you are looking for isn\u2019t here"), r.a.createElement(F.a, {variant: "subtitle2"}, "You either tried some shady route or you came here by mistake. Whichever it is, try using the navigation"), r.a.createElement("img", {
                alt: "Under development",
                className: e.image,
                src: "images/undraw_page_not_found_su7k.svg"
            })))))
        }, Ht = a(451), Mt = a(457), Ut = Object(O.a)((function () {
            return {root: {}, item: {display: "flex", flexDirection: "column"}}
        })), Gt = function (e) {
            var t = e.className, a = Object(k.a)(e, ["className"]), n = Ut();
            return r.a.createElement(Oe.a, Object.assign({}, a, {className: Object(C.a)(n.root, t)}), r.a.createElement("form", null, r.a.createElement(we.a, {
                subheader: "Manage the notifications",
                title: "Notifications"
            }), r.a.createElement(D.a, null), r.a.createElement(je.a, null, r.a.createElement(Ce.a, {
                container: !0,
                spacing: 6,
                wrap: "wrap"
            }, r.a.createElement(Ce.a, {
                className: n.item,
                item: !0,
                md: 4,
                sm: 6,
                xs: 12
            }, r.a.createElement(F.a, {
                gutterBottom: !0,
                variant: "h6"
            }, "Notifications"), r.a.createElement(Ht.a, {
                control: r.a.createElement(Mt.a, {
                    color: "primary",
                    defaultChecked: !0
                }), label: "Email"
            }), r.a.createElement(Ht.a, {
                control: r.a.createElement(Mt.a, {color: "primary", defaultChecked: !0}),
                label: "Push Notifications"
            }), r.a.createElement(Ht.a, {
                control: r.a.createElement(Mt.a, {color: "primary"}),
                label: "Text Messages"
            }), r.a.createElement(Ht.a, {
                control: r.a.createElement(Mt.a, {color: "primary", defaultChecked: !0}),
                label: "Phone calls"
            })), r.a.createElement(Ce.a, {
                className: n.item,
                item: !0,
                md: 4,
                sm: 6,
                xs: 12
            }, r.a.createElement(F.a, {
                gutterBottom: !0,
                variant: "h6"
            }, "Messages"), r.a.createElement(Ht.a, {
                control: r.a.createElement(Mt.a, {
                    color: "primary",
                    defaultChecked: !0
                }), label: "Email"
            }), r.a.createElement(Ht.a, {
                control: r.a.createElement(Mt.a, {color: "primary"}),
                label: "Push Notifications"
            }), r.a.createElement(Ht.a, {
                control: r.a.createElement(Mt.a, {color: "primary", defaultChecked: !0}),
                label: "Phone calls"
            })))), r.a.createElement(D.a, null), r.a.createElement(Se.a, null, r.a.createElement(ae.a, {
                color: "primary",
                variant: "outlined"
            }, "Save"))))
        }, Qt = Object(O.a)((function () {
            return {root: {}}
        })), Vt = function (e) {
            var t = e.className, a = Object(k.a)(e, ["className"]), l = Qt(),
                o = Object(n.useState)({password: "", confirm: ""}), s = Object(B.a)(o, 2), i = s[0], c = s[1],
                m = function (e) {
                    c(Object(v.a)({}, i, Object(j.a)({}, e.target.name, e.target.value)))
                };
            return r.a.createElement(Oe.a, Object.assign({}, a, {className: Object(C.a)(l.root, t)}), r.a.createElement("form", null, r.a.createElement(we.a, {
                subheader: "Update password",
                title: "Password"
            }), r.a.createElement(D.a, null), r.a.createElement(je.a, null, r.a.createElement(Ne.a, {
                fullWidth: !0,
                label: "Password",
                name: "password",
                onChange: m,
                type: "password",
                value: i.password,
                variant: "outlined"
            }), r.a.createElement(Ne.a, {
                fullWidth: !0,
                label: "Confirm password",
                name: "confirm",
                onChange: m,
                style: {marginTop: "1rem"},
                type: "password",
                value: i.confirm,
                variant: "outlined"
            })), r.a.createElement(D.a, null), r.a.createElement(Se.a, null, r.a.createElement(ae.a, {
                color: "primary",
                variant: "outlined"
            }, "Update"))))
        }, Yt = Object(O.a)((function (e) {
            return {root: {padding: e.spacing(4)}}
        })), $t = function () {
            var e = Yt();
            return r.a.createElement("div", {className: e.root}, r.a.createElement(Ce.a, {
                container: !0,
                spacing: 4
            }, r.a.createElement(Ce.a, {
                item: !0,
                md: 7,
                xs: 12
            }, r.a.createElement(Gt, null)), r.a.createElement(Ce.a, {
                item: !0,
                md: 5,
                xs: 12
            }, r.a.createElement(Vt, null))))
        }, Jt = a(453), Zt = a(125), Kt = a.n(Zt), Xt = a(535), ea = a(452);

        function ta(e) {
            return r.a.createElement(it.a, Object.assign({elevation: 6, variant: "filled"}, e))
        }

        var aa = Object(Xt.a)((function (e) {
            return {
                paper: {marginTop: e.spacing(8), display: "flex", flexDirection: "column", alignItems: "center"},
                avatar: {margin: e.spacing(1), backgroundColor: e.palette.secondary.main},
                form: {width: "100%", marginTop: e.spacing(3)},
                submit: {margin: e.spacing(3, 0, 2)}
            }
        }));

        function na(e) {
            var t = this, a = aa(), n = r.a.useState(""), l = Object(B.a)(n, 2), o = l[0], s = l[1],
                i = r.a.useState(""), c = Object(B.a)(i, 2), m = c[0], u = c[1], d = r.a.useState(""),
                h = Object(B.a)(d, 2), g = h[0], p = h[1], E = r.a.useState(""), f = Object(B.a)(E, 2), b = f[0],
                y = f[1], v = r.a.useState(null), x = Object(B.a)(v, 2), _ = x[0], k = x[1], C = r.a.useState(!1),
                O = Object(B.a)(C, 2), w = O[0], j = O[1], N = function () {
                    j(!1), setTimeout(function () {
                        e.history.replace("/")
                    }.bind(t, 2e3))
                };
            return r.a.createElement(ea.a, {
                component: "main",
                maxWidth: "xs"
            }, r.a.createElement(Jt.a, null), r.a.createElement("div", {className: a.paper}, r.a.createElement($.a, {className: a.avatar}, r.a.createElement(Kt.a, null)), r.a.createElement(F.a, {
                component: "h1",
                variant: "h4"
            }, "Sign up"), r.a.createElement("div", {style: {marginTop: "20px"}}, r.a.createElement(Ce.a, {
                container: !0,
                spacing: 2
            }, r.a.createElement(Ce.a, {item: !0, xs: 12, sm: 6}, r.a.createElement(Ne.a, {
                autoComplete: "fname",
                name: "firstName",
                variant: "outlined",
                required: !0,
                fullWidth: !0,
                value: o,
                id: "firstName",
                label: "First Name",
                onChange: function (e) {
                    s(e.target.value), k(null)
                },
                autoFocus: !0
            })), r.a.createElement(Ce.a, {item: !0, xs: 12, sm: 6}, r.a.createElement(Ne.a, {
                variant: "outlined",
                required: !0,
                fullWidth: !0,
                id: "lastName",
                value: m,
                label: "Last Name",
                name: "lastName",
                onChange: function (e) {
                    u(e.target.value), k(null)
                },
                autoComplete: "lname"
            })), r.a.createElement(Ce.a, {item: !0, xs: 12}, r.a.createElement(Ne.a, {
                variant: "outlined",
                required: !0,
                fullWidth: !0,
                id: "email",
                value: g,
                label: "Email Address",
                name: "email",
                onChange: function (e) {
                    p(e.target.value), k(null)
                },
                autoComplete: "email"
            })), r.a.createElement(Ce.a, {item: !0, xs: 12}, r.a.createElement(Ne.a, {
                variant: "outlined",
                required: !0,
                fullWidth: !0,
                name: "password",
                label: "Password",
                value: b,
                type: "password",
                id: "password",
                onChange: function (e) {
                    y(e.target.value), k(null)
                },
                autoComplete: "current-password"
            })), r.a.createElement(Ce.a, {
                item: !0,
                xs: 12
            }, _ ? r.a.createElement(it.a, {severity: "error"}, _) : null)), r.a.createElement(ae.a, {
                type: "button",
                fullWidth: !0,
                variant: "contained",
                color: "primary",
                className: a.submit,
                onClick: function () {
                    k(null), o.length && m.length && g.length && b.length ? /^\w+([.-]?\w+)*@\w+([.-]?\w+)*(\.\w{2,3})+$/.test(g) ? mt.a.post("/signup", {
                        firstName: o,
                        lastName: m,
                        emailId: g,
                        password: b
                    }).then((function (e) {
                        j(!0)
                    })).catch((function (e) {
                        console.log(e), k("Oh, looks like you have already registered with this Email Address. Please sign in")
                    })) : k("Doesn't look like an email address to us!") : k("Important fields missing!")
                }
            }, "Sign Up"), r.a.createElement(Ce.a, {
                container: !0,
                justify: "flex-end"
            }, r.a.createElement(Ce.a, {item: !0}, r.a.createElement(I.a, {
                href: "/",
                variant: "body2"
            }, "Already have an account? Sign in"))), r.a.createElement(st.a, {
                open: w,
                autoHideDuration: 3e3,
                onClose: N
            }, r.a.createElement(ta, {
                onClose: N,
                severity: "success"
            }, "Sign Up successful. Email Address registered. Redirecting to sign in page!")))))
        }

        var ra = Object(Xt.a)((function (e) {
            return {
                root: {height: "100vh"},
                image: {
                    backgroundImage: "url(https://source.unsplash.com/1600x900/?nature)",
                    backgroundRepeat: "no-repeat",
                    backgroundColor: "light" === e.palette.type ? e.palette.grey[50] : e.palette.grey[900],
                    backgroundSize: "cover",
                    backgroundPosition: "center"
                },
                paper: {margin: e.spacing(8, 4), display: "flex", flexDirection: "column", alignItems: "center"},
                avatar: {margin: e.spacing(1), backgroundColor: e.palette.secondary.main},
                form: {width: "100%", marginTop: e.spacing(1)},
                submit: {margin: e.spacing(3, 0, 2)}
            }
        })), la = Object(Z.b)(null, (function (e) {
            return {
                saveUser: function (t, a) {
                    return e({type: "saveuser", name: t, id: a})
                }
            }
        }))((function (e) {
            var t = ra(), a = Object(u.g)(), n = r.a.useState(""), l = Object(B.a)(n, 2), o = l[0], s = l[1],
                i = r.a.useState(""), c = Object(B.a)(i, 2), m = c[0], d = c[1], h = r.a.useState(null),
                g = Object(B.a)(h, 2), p = g[0], E = g[1];
            return r.a.createElement(Ce.a, {
                container: !0,
                component: "main",
                className: t.root
            }, r.a.createElement(Jt.a, null), r.a.createElement(Ce.a, {
                item: !0,
                xs: !1,
                sm: 4,
                md: 7,
                className: t.image
            }), r.a.createElement(Ce.a, {
                item: !0,
                xs: 12,
                sm: 8,
                md: 5,
                component: w.a,
                elevation: 6,
                square: !0
            }, r.a.createElement("div", {className: t.paper}, r.a.createElement($.a, {className: t.avatar}, r.a.createElement(Kt.a, null)), r.a.createElement(F.a, {
                component: "h1",
                variant: "h5"
            }, "Sign in"), r.a.createElement(r.a.Fragment, null, r.a.createElement(Ne.a, {
                variant: "outlined",
                margin: "normal",
                required: !0,
                fullWidth: !0,
                id: "email",
                label: "Email Address",
                name: "email",
                value: o,
                onChange: function (e) {
                    s(e.target.value)
                }
            }), r.a.createElement(Ne.a, {
                variant: "outlined",
                margin: "normal",
                required: !0,
                fullWidth: !0,
                name: "password",
                label: "Password",
                type: "password",
                id: "password",
                value: m,
                onChange: function (e) {
                    d(e.target.value)
                }
            }), p ? r.a.createElement(it.a, {severity: "error"}, p) : null, r.a.createElement(ae.a, {
                type: "button",
                fullWidth: !0,
                variant: "contained",
                color: "primary",
                className: t.submit,
                onClick: function () {
                    0 !== o.length && 0 !== m.length ? mt.a.post("/login", {
                        emailId: o,
                        password: m
                    }).then((function (t) {
                        console.log(t), e.saveUser(t.data.firstName + " " + t.data.lastName, t.data.id), a.push("/dashboard")
                    })).catch((function (e) {
                        console.log(e), E("Sign in failed. Incorrect Email Address and Password.")
                    })) : E("Please enter the required fields")
                },
                autoFocus: !0
            }, "Sign In")), r.a.createElement(Ce.a, {container: !0}, r.a.createElement(Ce.a, {
                item: !0,
                xs: !0
            }), r.a.createElement(Ce.a, {item: !0}, r.a.createElement(I.a, {
                href: "/sign-up",
                variant: "body2"
            }, "Don't have an account? Sign Up"))))))
        })), oa = Object(O.a)((function () {
            return {root: {}, item: {display: "flex", flexDirection: "column"}}
        })), sa = function (e) {
            var t = oa();
            return r.a.createElement(Oe.a, null, r.a.createElement("form", null, r.a.createElement(we.a, {
                subheader: "Analyze twitter data",
                title: "Twitter"
            }), r.a.createElement(D.a, null), r.a.createElement(je.a, null, r.a.createElement(Ce.a, {
                container: !0,
                spacing: 6,
                wrap: "wrap"
            }, r.a.createElement(Ce.a, {
                className: t.item,
                item: !0,
                md: 6,
                sm: 6,
                xs: 12
            }, r.a.createElement(F.a, {
                gutterBottom: !0,
                variant: "h6"
            }, "Analysis Model"), r.a.createElement(Ht.a, {
                control: r.a.createElement(Mt.a, {
                    color: "primary",
                    defaultChecked: !0,
                    name: "sentimental",
                    onChange: e.handleCheckBoxChange
                }), label: "Sentiments"
            }), r.a.createElement(Ht.a, {
                control: r.a.createElement(Mt.a, {
                    color: "primary",
                    name: "question",
                    onChange: e.handleCheckBoxChange
                }), label: "Question Detection"
            }), r.a.createElement(Ht.a, {
                control: r.a.createElement(Mt.a, {
                    color: "primary",
                    defaultChecked: !0,
                    name: "news",
                    onChange: e.handleCheckBoxChange
                }), label: "Fact Check"
            })))), r.a.createElement(D.a, null), r.a.createElement(Se.a, null, e.analyze ? r.a.createElement(ae.a, {
                color: "primary",
                variant: "outlined",
                onClick: e.saveTwitterAnalysis
            }, "Analyze") : r.a.createElement(ae.a, {color: "primary", variant: "outlined", disabled: !0}, "Analyze"))))
        }, ia = function (e) {
            return r.a.createElement(Oe.a, null, r.a.createElement("form", null, r.a.createElement(we.a, {
                subheader: "Twitter user information",
                title: "Information"
            }), r.a.createElement(D.a, null), r.a.createElement(je.a, null, r.a.createElement(Ne.a, {
                fullWidth: !0,
                label: "Screen Name",
                name: "name",
                onChange: e.handleTextChange,
                value: e.screen_name,
                variant: "outlined"
            }), r.a.createElement(Ne.a, {
                fullWidth: !0,
                label: "Hashtags",
                name: "hashtag",
                onChange: e.handleTextChange,
                style: {marginTop: "1rem"},
                value: e.hashtag_data,
                variant: "outlined"
            })), r.a.createElement(D.a, null)))
        }, ca = a(454), ma = a(283), ua = Object(O.a)((function (e) {
            return {root: {padding: e.spacing(4)}}
        }));

        function da(e) {
            return r.a.createElement(it.a, Object.assign({elevation: 6, variant: "filled"}, e))
        }

        var ha = Object(Z.b)((function (e) {
            return {id: e.user.id}
        }))((function (e) {
            var t = ua(), a = Object(n.useState)(""), l = Object(B.a)(a, 2), o = l[0], s = l[1],
                i = Object(n.useState)(""), c = Object(B.a)(i, 2), m = c[0], u = c[1],
                d = Object(n.useState)({sentimental: !0, question: !1, news: !0, hashtag: !1}), h = Object(B.a)(d, 2),
                g = h[0], p = h[1], E = Object(n.useState)(!1), f = Object(B.a)(E, 2), b = f[0], y = f[1],
                x = Object(n.useState)({success: !1, error: !1}), _ = Object(B.a)(x, 2), k = _[0], C = _[1],
                O = function () {
                    C((function (e) {
                        return {success: !1, error: !1}
                    }))
                };
            return r.a.createElement("div", {className: t.root}, r.a.createElement(Ce.a, {
                container: !0,
                spacing: 4
            }, r.a.createElement(Ce.a, {
                item: !0,
                md: 5,
                xs: 12
            }, r.a.createElement(ia, {
                handleTextChange: function (e) {
                    "hashtag" === e.target.name ? u(e.target.value) : s(e.target.value)
                }, screen_name: o, hashtag_data: m
            })), r.a.createElement(Ce.a, {
                item: !0,
                md: 7,
                xs: 12
            }, r.a.createElement(sa, {
                handleCheckBoxChange: function (e) {
                    p(Object(v.a)({}, g, Object(j.a)({}, e.target.name, e.target.checked)))
                },
                analyze: (g.question || g.sentimental || g.hashtag || g.news) && (o.length > 0 || m.length > 0),
                saveTwitterAnalysis: function () {
                    y(!0);
                    var t = [];
                    m.length > 0 && m.split(",").forEach((function (e) {
                        t.push({name: e})
                    })), mt.a.post("/twitter_analysis", {
                        user_id: e.id,
                        screen_name: o.length > 0 ? o : null,
                        hashtags: t,
                        analyzer: {
                            sentimental: g.sentimental,
                            question: g.question,
                            hashtags: !0,
                            followers: !0,
                            news: g.news
                        }
                    }).then((function (e) {
                        console.log(e), C((function (e) {
                            return Object(v.a)({}, e, {success: !0})
                        })), p((function (e) {
                            return {sentimental: !0, question: !1, news: !0, hashtag: !1}
                        })), s(""), u(""), y(!1)
                    })).catch((function (e) {
                        console.log(e), C((function (e) {
                            return Object(v.a)({}, e, {error: !0})
                        })), y(!1)
                    }))
                }
            }))), r.a.createElement(ma.a, {
                style: {zIndex: "300"},
                open: b
            }, r.a.createElement(ca.a, {color: "inherit"})), r.a.createElement(st.a, {
                open: k.success,
                autoHideDuration: 3e3,
                onClose: O
            }, r.a.createElement(da, {
                onClose: O,
                severity: "success"
            }, "Data successfully stored, we'll start with analysis on your twitter data")), r.a.createElement(st.a, {
                open: k.error,
                autoHideDuration: 3e3,
                onClose: O
            }, r.a.createElement(da, {
                onClose: O,
                severity: "error"
            }, "Oh No, You shouldn't have seen this, analysis couldn't start, Please try again.")))
        })), ga = a(51), pa = a(91);

        function Ea(e) {
            return r.a.createElement(pa.a, e, r.a.createElement("path", {d: "M9.53144612,22.005 L9.53144612,13.0552149 L6.44166667,13.0552149 L6.44166667,9.49875 L9.53144612,9.49875 L9.53144612,6.68484375 C9.53144612,5.19972656 9.95946769,4.04680661 10.8155103,3.22608401 C11.6715529,2.4053613 12.808485,1.995 14.2263057,1.995 C15.3766134,1.995 16.3129099,2.04710915 17.0351961,2.15132812 L17.0351961,5.3169726 L15.1090998,5.3169726 C14.3868137,5.3169726 13.8919142,5.47330073 13.6244006,5.78595698 C13.4103902,6.04650407 13.3033846,6.46337874 13.3033846,7.03658198 L13.3033846,9.49875 L16.71418,9.49875 L16.2326559,13.0552149 L13.3033846,13.0552149 L13.3033846,22.005 L9.53144612,22.005 Z"}))
        }

        var fa = function (e) {
            return r.a.createElement(Oe.a, null, r.a.createElement("form", null, r.a.createElement(we.a, {
                subheader: "Page Name",
                title: "Facebook Information"
            }), r.a.createElement(D.a, null), r.a.createElement(je.a, null, r.a.createElement(Ne.a, {
                fullWidth: !0,
                label: "Page Name",
                name: "page_name",
                onChange: e.handlePageChange,
                value: e.page_name,
                variant: "outlined"
            })), r.a.createElement(D.a, null)))
        }, ba = Object(O.a)((function () {
            return {root: {}, item: {display: "flex", flexDirection: "column"}}
        })), ya = function (e) {
            var t = ba();
            return r.a.createElement(Oe.a, null, r.a.createElement("form", null, r.a.createElement(we.a, {
                subheader: "Analyze facebook data",
                title: "Facebook"
            }), r.a.createElement(D.a, null), r.a.createElement(je.a, null, r.a.createElement(Ce.a, {
                container: !0,
                spacing: 6,
                wrap: "wrap"
            }, r.a.createElement(Ce.a, {
                className: t.item,
                item: !0,
                md: 4,
                sm: 6,
                xs: 12
            }, r.a.createElement(F.a, {
                gutterBottom: !0,
                variant: "h6"
            }, "Analysis Model"), r.a.createElement(Ht.a, {
                control: r.a.createElement(Mt.a, {
                    color: "primary",
                    defaultChecked: !0,
                    name: "sentimental",
                    onChange: e.handleCheckBoxChange
                }), label: "Sentiments"
            }), r.a.createElement(Ht.a, {
                control: r.a.createElement(Mt.a, {color: "primary"}),
                label: "Question Detection",
                name: "question",
                onChange: e.handleCheckBoxChange
            })))), r.a.createElement(D.a, null), r.a.createElement(Se.a, null, e.analyze ? r.a.createElement(ae.a, {
                color: "primary",
                variant: "outlined",
                onClick: e.saveFacebookAnalysis
            }, "Analyze") : r.a.createElement(ae.a, {
                color: "primary",
                variant: "outlined",
                onClick: e.saveFacebookAnalysis,
                disabled: !0
            }, "Analyze"))))
        };

        function va(e) {
            return r.a.createElement(it.a, Object.assign({elevation: 6, variant: "filled"}, e))
        }

        var xa = function (e) {
            Object(m.a)(a, e);
            var t = Object(c.a)(a);

            function a(e) {
                var n;
                return Object(s.a)(this, a), (n = t.call(this, e)).state = {
                    page_name: "",
                    name: "",
                    email: "",
                    sentimental: !0,
                    question: !1,
                    hashtag: !0,
                    token: null,
                    snackbar: !1,
                    error_snackbar: !1,
                    progress: !1
                }, n.testAPI = function () {
                    window.FB.api("/me", "GET", {fields: "name,email"}, function (e) {
                        document.getElementById("status").innerHTML = "Thanks for logging in, " + e.name + "!", this.setState({
                            name: e.name,
                            email: e.email
                        })
                    }.bind(Object(ga.a)(n)))
                }, n.statusChangeCallback = function (e) {
                    "connected" === e.status ? n.testAPI() : "not_authorized" === e.status ? document.getElementById("status").innerHTML = "Please log into this app." : document.getElementById("status").innerHTML = "Please log into Facebook."
                }, n.checkLoginState = function () {
                    window.FB.getLoginStatus(function (e) {
                        this.statusChangeCallback(e), e.authResponse && this.setState({token: e.authResponse.accessToken})
                    }.bind(Object(ga.a)(n)))
                }, n.handleClick = function () {
                    window.FB ? window.FB.login(n.checkLoginState()) : document.getElementById("status").innerHTML = "We do not entertain request in incognito."
                }, n.handlePageChange = function (e) {
                    n.setState(Object(v.a)({}, n.state, {page_name: e.target.value}))
                }, n.handleCheckBoxChange = function (e) {
                    n.setState(Object(j.a)({}, e.target.name, e.target.checked))
                }, n.handleCloseSnackBar = function () {
                    n.setState(Object(v.a)({}, n.state, {snackbar: !1, error_snackbar: !1}))
                }, n.saveFacebookAnalysis = function () {
                    n.setState({progress: !0}), console.log({
                        user_id: n.props.id,
                        token: n.state.token,
                        email: n.state.email,
                        name: n.state.name,
                        page: n.state.page_name.length > 0 ? n.state.page_name : null,
                        analyzer: {
                            sentimental: n.state.sentimental,
                            question: n.state.question,
                            hashtags: n.state.hashtag,
                            followers: !0
                        }
                    }), mt.a.post("/facebook_analysis", {
                        user_id: n.props.id,
                        token: n.state.token,
                        email: n.state.email,
                        name: n.state.name,
                        page: n.state.page_name.length > 0 ? n.state.page_name : null,
                        analyzer: {
                            sentimental: n.state.sentimental,
                            question: n.state.question,
                            hashtags: !0,
                            followers: !0
                        }
                    }).then((function (e) {
                        console.log(e), n.setState({
                            page_name: "",
                            name: "",
                            email: "",
                            sentimental: !0,
                            question: !1,
                            hashtag: !0,
                            token: null,
                            snackbar: !0,
                            error_snackbar: !1,
                            progress: !1
                        })
                    })).catch((function (e) {
                        n.setState({error_snackbar: !0, progress: !1})
                    }))
                }, n.checkLoginState = n.checkLoginState.bind(Object(ga.a)(n)), n.handleClick = n.handleClick.bind(Object(ga.a)(n)), n.testAPI = n.testAPI.bind(Object(ga.a)(n)), n.statusChangeCallback = n.statusChangeCallback.bind(Object(ga.a)(n)), n
            }

            return Object(i.a)(a, [{
                key: "componentDidMount", value: function () {
                    window.fbAsyncInit = function () {
                        window.FB.init({
                            appId: "862008614311891",
                            cookie: !0,
                            xfbml: !0,
                            version: "v3.1"
                        }), window.FB.AppEvents.logPageView(), window.FB.Event.subscribe("auth.statusChange", function (e) {
                            e.authResponse && this.checkLoginState()
                        }.bind(this))
                    }.bind(this), function (e, t, a) {
                        var n, r = e.getElementsByTagName(t)[0];
                        e.getElementById(a) || ((n = e.createElement(t)).id = a, n.src = "//connect.facebook.net/en_US/sdk.js", r.parentNode.insertBefore(n, r))
                    }(document, "script", "facebook-jssdk")
                }
            }, {
                key: "render", value: function () {
                    return r.a.createElement("div", null, r.a.createElement(Ce.a, {
                        container: !0,
                        style: {height: "100%"}
                    }, r.a.createElement(Ce.a, {
                        item: !0,
                        lg: 7,
                        xs: 12,
                        style: {height: "100%", display: "flex", flexDirection: "column"}
                    }, r.a.createElement("div", {
                        style: {
                            height: "100%",
                            display: "flex",
                            flexDirection: "column"
                        }
                    }, r.a.createElement("div", {
                        style: {
                            flexGrow: "1",
                            display: "flex",
                            alignItems: "center"
                        }
                    }, r.a.createElement("form", {
                        style: {
                            paddingLeft: 35,
                            paddingRight: 35,
                            paddingBottom: 20,
                            flexBasis: 700
                        }
                    }, r.a.createElement(F.a, {
                        variant: "h2",
                        style: {marginTop: "20px"}
                    }, "Sign in"), r.a.createElement(F.a, {
                        color: "textSecondary",
                        gutterBottom: !0
                    }, "Analyze your posts"), r.a.createElement(Ce.a, {
                        container: !0,
                        spacing: 2,
                        style: {marginTop: "10px"}
                    }, r.a.createElement(Ce.a, {item: !0}, r.a.createElement(ae.a, {
                        color: "primary",
                        size: "large",
                        variant: "contained",
                        onClick: this.handleClick
                    }, r.a.createElement(Ea, null), "Login with Facebook")), r.a.createElement(Ce.a, {item: !0}, r.a.createElement("div", {id: "status"})))))))), r.a.createElement(Ce.a, {
                        container: !0,
                        spacing: 4
                    }, r.a.createElement(Ce.a, {
                        item: !0,
                        md: 5,
                        xs: 12
                    }, r.a.createElement(fa, {
                        handlePageChange: this.handlePageChange,
                        page_name: this.state.page_name
                    })), r.a.createElement(Ce.a, {
                        item: !0,
                        md: 7,
                        xs: 12
                    }, r.a.createElement(ya, {
                        handleCheckBoxChange: this.handleCheckBoxChange,
                        analyze: (this.state.sentimental || this.state.hastag || this.state.question) && null != this.state.token,
                        saveFacebookAnalysis: this.saveFacebookAnalysis
                    }))), r.a.createElement(ma.a, {
                        style: {zIndex: "300"},
                        open: this.state.progress
                    }, r.a.createElement(ca.a, {color: "inherit"})), r.a.createElement(st.a, {
                        open: this.state.snackbar,
                        autoHideDuration: 3e3,
                        onClose: this.handleCloseSnackBar
                    }, r.a.createElement(va, {
                        onClose: this.handleCloseSnackBar,
                        severity: "success"
                    }, "Data successfully stored, we'll start with analysis on your facebook data")), r.a.createElement(st.a, {
                        open: this.state.error_snackbar,
                        autoHideDuration: 3e3,
                        onClose: this.handleCloseSnackBar
                    }, r.a.createElement(va, {
                        onClose: this.handleCloseSnackBar,
                        severity: "error"
                    }, "Oh No, You shouldn't have seen this, analysis couldn't start, Please try again.")))
                }
            }]), a
        }(r.a.Component), _a = Object(Z.b)((function (e) {
            return {id: e.user.id}
        }))(Object(u.h)(xa)), ka = function (e) {
            return r.a.createElement(Oe.a, null, r.a.createElement("form", null, r.a.createElement(we.a, {
                subheader: "Quora user information",
                title: "Information"
            }), r.a.createElement(D.a, null), r.a.createElement(je.a, null, r.a.createElement(Ne.a, {
                fullWidth: !0,
                label: "Search Query/User Name",
                name: "name",
                onChange: e.handleTextChange,
                value: e.query,
                variant: "outlined"
            }), r.a.createElement(Ne.a, {
                fullWidth: !0,
                label: "Question",
                name: "question",
                onChange: e.handleTextChange,
                multiline: !0,
                style: {marginTop: "1rem"},
                value: e.question,
                variant: "outlined"
            })), r.a.createElement(D.a, null)))
        }, Ca = Object(O.a)((function () {
            return {root: {}, item: {display: "flex", flexDirection: "column"}}
        })), Oa = function (e) {
            var t = e.className, a = Object(k.a)(e, ["className"]), n = Ca();
            return r.a.createElement(Oe.a, Object.assign({}, a, {className: Object(C.a)(n.root, t)}), r.a.createElement("form", null, r.a.createElement(we.a, {
                subheader: "Analyze quora data",
                title: "Quora"
            }), r.a.createElement(D.a, null), r.a.createElement(je.a, null, r.a.createElement(Ce.a, {
                container: !0,
                spacing: 6,
                wrap: "wrap"
            }, r.a.createElement(Ce.a, {
                className: n.item,
                item: !0,
                md: 4,
                sm: 6,
                xs: 12
            }, r.a.createElement(F.a, {
                gutterBottom: !0,
                variant: "h6"
            }, "Analysis Model"), r.a.createElement(Ht.a, {
                control: r.a.createElement(Mt.a, {
                    color: "primary",
                    defaultChecked: !0,
                    name: "sentimental",
                    onChange: e.handleCheckBoxChange
                }), label: "Sentiments"
            })))), r.a.createElement(D.a, null), r.a.createElement(Se.a, null, e.analyze ? r.a.createElement(ae.a, {
                color: "primary",
                variant: "outlined",
                onClick: e.saveQuoraAnalysis
            }, "Analyze") : r.a.createElement(ae.a, {color: "primary", variant: "outlined", disabled: !0}, "Analyze"))))
        }, wa = Object(O.a)((function (e) {
            return {root: {padding: e.spacing(4)}}
        }));

        function ja(e) {
            return r.a.createElement(it.a, Object.assign({elevation: 6, variant: "filled"}, e))
        }

        var Na = Object(Z.b)((function (e) {
            return {id: e.user.id}
        }))((function (e) {
            var t = wa(), a = Object(n.useState)({name: "", question: ""}), l = Object(B.a)(a, 2), o = l[0], s = l[1],
                i = Object(n.useState)({sentimental: !0, question: !1, news: !1, hashtag: !1, comments: !1}),
                c = Object(B.a)(i, 2), m = c[0], u = c[1], d = Object(n.useState)(!1), h = Object(B.a)(d, 2), g = h[0],
                p = h[1], E = Object(n.useState)({success: !1, error: !1}), f = Object(B.a)(E, 2), b = f[0], y = f[1],
                x = function () {
                    y((function (e) {
                        return {success: !1, error: !1}
                    }))
                };
            return r.a.createElement("div", {className: t.root}, r.a.createElement(Ce.a, {
                container: !0,
                spacing: 4
            }, r.a.createElement(Ce.a, {
                item: !0,
                md: 5,
                xs: 12
            }, r.a.createElement(ka, {
                handleTextChange: function (e) {
                    s(Object(v.a)({}, o, Object(j.a)({}, e.target.name, e.target.value)))
                }, query: o.name, question: o.question
            })), r.a.createElement(Ce.a, {
                item: !0,
                md: 7,
                xs: 12
            }, r.a.createElement(Oa, {
                handleCheckBoxChange: function (e) {
                    u(Object(v.a)({}, m, Object(j.a)({}, e.target.name, e.target.checked)))
                },
                analyze: m.sentimental && (o.name.length > 0 || o.question.length > 0),
                saveQuoraAnalysis: function () {
                    p(!0), mt.a.post("/quora_analysis", {
                        user_id: e.id,
                        query: o.name,
                        question: o.question,
                        analyzer: {
                            sentimental: m.sentimental,
                            question: !1,
                            hashtags: !1,
                            followers: !1,
                            news: !1,
                            comments: !1
                        }
                    }).then((function (e) {
                        y((function (e) {
                            return Object(v.a)({}, e, {success: !0})
                        })), u((function (e) {
                            return {sentimental: !0, question: !1, news: !1, hashtag: !1, comment: !1}
                        })), s((function (e) {
                            return {name: "", question: ""}
                        }))
                    })).catch((function (e) {
                        y((function (e) {
                            return Object(v.a)({}, e, {error: !0})
                        }))
                    })), p(!1)
                }
            }))), r.a.createElement(ma.a, {
                style: {zIndex: "300"},
                open: g
            }, r.a.createElement(ca.a, {color: "inherit"})), r.a.createElement(st.a, {
                open: b.success,
                autoHideDuration: 3e3,
                onClose: x
            }, r.a.createElement(ja, {
                onClose: x,
                severity: "success"
            }, "Data successfully stored, we'll start with analysis on your quora data")), r.a.createElement(st.a, {
                open: b.error,
                autoHideDuration: 3e3,
                onClose: x
            }, r.a.createElement(ja, {
                onClose: x,
                severity: "error"
            }, "Oh No, You shouldn't have seen this, analysis couldn't start, Please try again.")))
        })), Sa = Object(O.a)((function () {
            return {root: {}, item: {display: "flex", flexDirection: "column"}}
        })), qa = function (e) {
            var t = Sa();
            return r.a.createElement(Oe.a, null, r.a.createElement("form", null, r.a.createElement(we.a, {
                subheader: "Analyze reddit data",
                title: "Reddit"
            }), r.a.createElement(D.a, null), r.a.createElement(je.a, null, r.a.createElement(Ce.a, {
                container: !0,
                spacing: 6,
                wrap: "wrap"
            }, r.a.createElement(Ce.a, {
                className: t.item,
                item: !0,
                md: 6,
                sm: 6,
                xs: 12
            }, r.a.createElement(F.a, {
                gutterBottom: !0,
                variant: "h6"
            }, "Analysis Model"), r.a.createElement(Ht.a, {
                control: r.a.createElement(Mt.a, {
                    color: "primary",
                    defaultChecked: !0,
                    name: "sentimental",
                    onChange: e.handleCheckBoxChange
                }), label: "Sentiments"
            }), r.a.createElement(Ht.a, {
                control: r.a.createElement(Mt.a, {
                    color: "primary",
                    name: "question",
                    onChange: e.handleCheckBoxChange
                }), label: "Question Detection"
            })))), r.a.createElement(D.a, null), r.a.createElement(Se.a, null, e.analyze ? r.a.createElement(ae.a, {
                color: "primary",
                variant: "outlined",
                onClick: e.saveRedditAnalysis
            }, "Analyze") : r.a.createElement(ae.a, {color: "primary", variant: "outlined", disabled: !0}, "Analyze"))))
        }, Ba = function (e) {
            return r.a.createElement(Oe.a, null, r.a.createElement("form", null, r.a.createElement(we.a, {
                subheader: "Reddit information",
                title: "Information"
            }), r.a.createElement(D.a, null), r.a.createElement(je.a, null, r.a.createElement(Ne.a, {
                fullWidth: !0,
                label: "SubReddit - MachineLearning/Python etc..",
                name: "name",
                onChange: e.handleTextChange,
                value: e.subreddit,
                variant: "outlined"
            })), r.a.createElement(D.a, null)))
        }, Ta = Object(O.a)((function (e) {
            return {root: {padding: e.spacing(4)}}
        }));

        function Aa(e) {
            return r.a.createElement(it.a, Object.assign({elevation: 6, variant: "filled"}, e))
        }

        var Fa = Object(Z.b)((function (e) {
            return {id: e.user.id}
        }))((function (e) {
            var t = Ta(), a = Object(n.useState)(""), l = Object(B.a)(a, 2), o = l[0], s = l[1],
                i = Object(n.useState)({sentimental: !0, question: !1, news: !1, hashtag: !1, comments: !0}),
                c = Object(B.a)(i, 2), m = c[0], u = c[1], d = Object(n.useState)(!1), h = Object(B.a)(d, 2), g = h[0],
                p = h[1], E = Object(n.useState)({success: !1, error: !1}), f = Object(B.a)(E, 2), b = f[0], y = f[1],
                x = function () {
                    y((function (e) {
                        return {success: !1, error: !1}
                    }))
                };
            return r.a.createElement("div", {className: t.root}, r.a.createElement(Ce.a, {
                container: !0,
                spacing: 4
            }, r.a.createElement(Ce.a, {
                item: !0,
                md: 5,
                xs: 12
            }, r.a.createElement(Ba, {
                handleTextChange: function (e) {
                    s(e.target.value)
                }, subreddit: o
            })), r.a.createElement(Ce.a, {
                item: !0,
                md: 7,
                xs: 12
            }, r.a.createElement(qa, {
                handleCheckBoxChange: function (e) {
                    u(Object(v.a)({}, m, Object(j.a)({}, e.target.name, e.target.checked)))
                },
                analyze: (m.question || m.sentimental || m.hashtag || m.news || m.comment) && o.length > 0,
                saveRedditAnalysis: function () {
                    p(!0), console.log({
                        user_id: e.id,
                        subreddit: o,
                        analyzer: {
                            sentimental: m.sentimental,
                            question: m.question,
                            hashtags: !1,
                            followers: !1,
                            news: !1,
                            comments: !0
                        }
                    }), mt.a.post("/reddit_analysis", {
                        user_id: e.id,
                        subreddit: o,
                        analyzer: {
                            sentimental: m.sentimental,
                            question: m.question,
                            hashtags: !1,
                            followers: !1,
                            news: !1,
                            comments: !0
                        }
                    }).then((function (e) {
                        y((function (e) {
                            return Object(v.a)({}, e, {success: !0})
                        })), u((function (e) {
                            return {sentimental: !0, question: !1, news: !1, hashtag: !1, comment: !0}
                        })), s("")
                    })).catch((function (e) {
                        y((function (e) {
                            return Object(v.a)({}, e, {error: !0})
                        }))
                    })), p(!1)
                }
            }))), r.a.createElement(ma.a, {
                style: {zIndex: "300"},
                open: g
            }, r.a.createElement(ca.a, {color: "inherit"})), r.a.createElement(st.a, {
                open: b.success,
                autoHideDuration: 3e3,
                onClose: x
            }, r.a.createElement(Aa, {
                onClose: x,
                severity: "success"
            }, "Data successfully stored, we'll start with analysis on your reddit data")), r.a.createElement(st.a, {
                open: b.error,
                autoHideDuration: 3e3,
                onClose: x
            }, r.a.createElement(Aa, {
                onClose: x,
                severity: "error"
            }, "Oh No, You shouldn't have seen this, analysis couldn't start, Please try again.")))
        })), Ia = function () {
            return r.a.createElement(u.d, null, r.a.createElement(u.a, {
                exact: !0,
                from: "/",
                to: "/signin"
            }), r.a.createElement(q, {
                component: la,
                exact: !0,
                layout: ke,
                path: "/signin"
            }), r.a.createElement(q, {
                component: Dt,
                exact: !0,
                layout: ye,
                path: "/dashboard"
            }), r.a.createElement(q, {
                component: _a,
                exact: !0,
                layout: ye,
                path: "/facebook"
            }), r.a.createElement(q, {
                component: ha,
                exact: !0,
                layout: ye,
                path: "/twitter"
            }), r.a.createElement(q, {
                component: Fa,
                exact: !0,
                layout: ye,
                path: "/reddit"
            }), r.a.createElement(q, {
                component: Na,
                exact: !0,
                layout: ye,
                path: "/quora"
            }), r.a.createElement(q, {
                component: $t,
                exact: !0,
                layout: ye,
                path: "/settings"
            }), r.a.createElement(q, {
                component: na,
                exact: !0,
                layout: ke,
                path: "/sign-up"
            }), r.a.createElement(q, {
                component: Pt,
                exact: !0,
                layout: ke,
                path: "/not-found"
            }), r.a.createElement(u.a, {to: "/not-found"}))
        }, za = Object(h.a)(), Wa = function (e) {
            Object(m.a)(a, e);
            var t = Object(c.a)(a);

            function a() {
                return Object(s.a)(this, a), t.apply(this, arguments)
            }

            return Object(i.a)(a, [{
                key: "render", value: function () {
                    return r.a.createElement(d.a, {theme: _}, r.a.createElement(u.c, {history: za}, r.a.createElement(Ia, null)))
                }
            }]), a
        }(n.Component);
        Boolean("localhost" === window.location.hostname || "[::1]" === window.location.hostname || window.location.hostname.match(/^127(?:\.(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)){3}$/));
        var Ra = a(118), Da = {user: {name: "Shubham Aggarwal", id: 1}}, La = function () {
            var e = arguments.length > 0 && void 0 !== arguments[0] ? arguments[0] : Da,
                t = arguments.length > 1 ? arguments[1] : void 0;
            return "saveuser" === t.type ? Object(v.a)({}, e, {user: {name: t.name, id: t.id}}) : e
        };
        mt.a.defaults.baseURL = "http://localhost:8085";
        var Pa = Object(Ra.b)(La);
        o.a.render(r.a.createElement(Z.a, {store: Pa}, r.a.createElement(r.a.StrictMode, null, r.a.createElement(Wa, null))), document.getElementById("root")), "serviceWorker" in navigator && navigator.serviceWorker.ready.then((function (e) {
            e.unregister()
        })).catch((function (e) {
            console.error(e.message)
        }))
    }
}, [[315, 1, 2]]]);
//# sourceMappingURL=main.7f33d239.chunk.js.map