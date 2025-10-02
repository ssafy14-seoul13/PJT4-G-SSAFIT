CREATE DATABASE IF NOT EXISTS `ssafit`;
USE ssafit;

CREATE TABLE IF NOT EXISTS `user` (
	`user_id` VARCHAR(20) PRIMARY KEY,
    `password` VARCHAR(20) NOT NULL,
    `name` VARCHAR(20) NOT NULL,
    `email` VARCHAR(100) NOT NULL
)ENGINE=InnoDB;

commit;

INSERT INTO `user`
VALUES
('gaeun', 'gaeun', 'gaeun', 'gaeun@gmail.com' ),
('ysh', 'ysh', 'ysh', 'ysh@gmail.com' );

commit;


SELECT * FROM user;
