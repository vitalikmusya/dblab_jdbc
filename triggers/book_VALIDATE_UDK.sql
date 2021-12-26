DROP TRIGGER IF EXISTS `book_resource`.`book_VALIDATE_UDK`;

DELIMITER //
USE `book_resource`//
CREATE DEFINER = `root`@`localhost` TRIGGER `book_resource`.`book_VALIDATE_UDK`
    BEFORE INSERT
    ON `book`
    FOR EACH ROW FOLLOWS `book_BEFORE_INSERT`
BEGIN
    IF (new.udk NOT REGEXP '^[A-Za-z]{2}.[0-9]{3}$') THEN
        SIGNAL SQLSTATE '45000'
            SET MESSAGE_TEXT = "UDK must be in format: 2 letters + \".\" + 3 digits.";
    END IF;
END//
DELIMITER ;
