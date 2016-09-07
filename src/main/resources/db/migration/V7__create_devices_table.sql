CREATE TABLE `fitness`.`devices` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `version` INT NULL,
  `serialnumber` VARCHAR(25) NULL,
  `product` ENUM('FITBIT', 'SURGE', 'UP3') NULL,
  `category` ENUM('swim', 'run', 'bike', 'lift') NULL,
  `user_id` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_user_idx` (`user_id` ASC),
  CONSTRAINT `fk_user_v7`
    FOREIGN KEY (`user_id`)
    REFERENCES `fitness`.`users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);