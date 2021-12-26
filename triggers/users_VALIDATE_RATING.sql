DROP TRIGGER IF EXISTS `book_resource`.`user_VALIDATE_RATING`;

DELIMITER //
USE `book_resource`//
CREATE DEFINER = `root`@`localhost` TRIGGER `book_resource`.`user_VALIDATE_RATING`
    BEFORE INSERT
    ON `user`
    FOR EACH ROW
BEGIN
    IF NOT new.rating BETWEEN 1 AND 5 THEN
        SIGNAL SQLSTATE '45000'
            SET MESSAGE_TEXT = "Rating must be between 1 and 5";
    END IF;
END//
DELIMITER ;
