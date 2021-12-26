DROP TRIGGER IF EXISTS `book_resource`.`password_BEFORE_DELETE`;

DELIMITER //
USE `book_resource`//
CREATE DEFINER =`root`@`localhost` TRIGGER `password_BEFORE_DELETE`
    BEFORE DELETE
    ON `password`
    FOR EACH ROW
BEGIN
    IF old.id IN (
        SELECT password_id
        FROM user) THEN
        SIGNAL SQLSTATE '45000'
            SET MESSAGE_TEXT = "FK constraint. Password is referenced.";
    END IF;
END//
DELIMITER ;
