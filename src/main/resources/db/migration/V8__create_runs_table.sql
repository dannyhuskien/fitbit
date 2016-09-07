CREATE TABLE `fitness`.`runs` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `version` INT NULL,
  `starttime` TIMESTAMP NOT NULL DEFAULT NOW(),
  `stoptime` TIMESTAMP NULL DEFAULT NULL,
  `device_id` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_device_idx` (`device_id` ASC),
  CONSTRAINT `fk_device_v8`
    FOREIGN KEY (`device_id`)
    REFERENCES `fitness`.`devices` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);