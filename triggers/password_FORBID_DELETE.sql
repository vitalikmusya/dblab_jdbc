DROP TRIGGER IF EXISTS `book_resource`.`password_FORBID_DELETE`;

DELIMITER //
USE `book_resource`//
CREATE DEFINER =`root`@`localhost` TRIGGER `password_FORBID_DELETE`
    BEFORE DELETE
    ON `password`
    FOR EACH ROW
BEGIN
    SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = "You cannot delete passwords.";
END//
DELIMITER ;
