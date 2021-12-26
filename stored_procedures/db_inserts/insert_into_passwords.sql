USE `book_resource`;
DROP procedure IF EXISTS `insert_into_password`;

DELIMITER //
USE `book_resource`//
CREATE PROCEDURE `insert_into_password`(
    IN in_password VARCHAR(45))
BEGIN
    INSERT INTO `book_resource`.`password` (`password`)
    VALUES (in_password);
END//

DELIMITER ;
