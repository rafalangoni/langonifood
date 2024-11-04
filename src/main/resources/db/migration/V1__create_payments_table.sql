CREATE TABLE payments (
 id bigint(20) NOT NULL AUTO_INCREMENT,
 payment_value decimal(19,2) NOT NULL,
 name varchar(100) DEFAULT NULL,
 cc_number varchar(16) DEFAULT NULL,
 cc_expiration varchar(6) DEFAULT NULL,
 cc_code varchar(3) DEFAULT NULL,
 status varchar(255) NOT NULL,
 payment_method_id bigint(20) NOT NULL,
 order_id bigint(20) NOT NULL,
PRIMARY KEY (id)
);