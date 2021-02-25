DROP TABLE IF EXISTS `orders`;
DROP TABLE IF EXISTS `customers`;
DROP TABLE IF EXISTS `items`;

CREATE TABLE IF NOT EXISTS `items`(
	`item_id` INT (11) NOT NULL AUTO_INCREMENT,
	`item_name` VARCHAR (40) DEFAULT NULL,
	`item_value` DOUBLE (11) DEFAULT NULL,
	PRIMARY KEY (`item_id`)
);

CREATE TABLE IF NOT EXISTS `customers`(
	`id` INT (11) NOT NULL AUTO_INCREMENT,
	`first_name` VARCHAR (40) DEFAULT NULL,
	`surname` VARCHAR (40) DEFAULT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `orders` (
    `order_id` INT(11) NOT NULL AUTO_INCREMENT,
    `id` int,
    `order_date` DATE NOT NULL,
    PRIMARY KEY (`order_id`),
	FOREIGN KEY (`id`) REFERENCES customers(`id`) ON DELETE CASCADE
);