-- Redis配置表
DROP TABLE redis_config;
CREATE TABLE redis_config (
    url      CHAR(250) NOT NULL,
    port     INT       NOT NULL,
    username CHAR(64)  NOT NULL,
    password CHAR(250) NOT NULL
);

-- Redis群体地址
INSERT INTO redis_config (url, port, username, password) VALUES ('192.168.241.150', '7110', 'username', 'password');
INSERT INTO redis_config (url, port, username, password) VALUES ('192.168.241.150', '7111', 'username', 'password');
INSERT INTO redis_config (url, port, username, password) VALUES ('192.168.241.150', '7112', 'username', 'password');
INSERT INTO redis_config (url, port, username, password) VALUES ('192.168.241.150', '7113', 'username', 'password');
INSERT INTO redis_config (url, port, username, password) VALUES ('192.168.241.150', '7114', 'username', 'password');
INSERT INTO redis_config (url, port, username, password) VALUES ('192.168.241.150', '7115', 'username', 'password');
INSERT INTO redis_config (url, port, username, password) VALUES ('192.168.241.150', '7116', 'username', 'password');
INSERT INTO redis_config (url, port, username, password) VALUES ('192.168.241.150', '7117', 'username', 'password');
INSERT INTO redis_config (url, port, username, password) VALUES ('192.168.241.150', '7118', 'username', 'password');
INSERT INTO redis_config (url, port, username, password) VALUES ('192.168.241.150', '7119', 'username', 'password');

-- 测试表
DROP TABLE person;
CREATE TABLE person (
    id      INT       NOT NULL PRIMARY KEY  AUTO_INCREMENT,
    name    CHAR(64)  NOT NULL,
    age     INT       NOT NULL,
    address CHAR(250) NOT NULL
);

