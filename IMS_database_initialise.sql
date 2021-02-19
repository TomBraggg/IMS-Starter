USE `ims` ;

CREATE TABLE IF NOT EXISTS `ims`.`customers` (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `first_name` varchar(40) NOT NULL,
    `surname` varchar(40) NOT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `ims`.`orders` (
    `order_id` INT(11) NOT NULL AUTO_INCREMENT,
    `id` int,
    `order_date` DATE NOT NULL,
    PRIMARY KEY (`order_id`),
	FOREIGN KEY (`id`) REFERENCES customers(`id`)
);

CREATE TABLE IF NOT EXISTS `ims`.`items` (
    `item_id` INT(11) NOT NULL AUTO_INCREMENT,
    `order_id` int,
    item_name varchar(40),
    item_value float(10, 2),
    PRIMARY KEY (`item_id`),
	FOREIGN KEY (`order_id`) REFERENCES customers(`id`)
);

CREATE TABLE IF NOT EXISTS `ims`.`orderlines` (
    `orderline_id` INT(11) NOT NULL AUTO_INCREMENT,
    `order_id` int,
    `item_id` int,
    `quantity` int(5) NOT NULL,
    `order_price` float(10, 2),
    PRIMARY KEY (`orderline_id`),
	FOREIGN KEY (`order_id`) REFERENCES orders(`order_id`),
    FOREIGN KEY (`item_id`) REFERENCES items(`item_id`)
);

