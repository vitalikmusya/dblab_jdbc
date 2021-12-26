DROP TRIGGER IF EXISTS `book_resource`.`user_BEFORE_INSERT`;

DELIMITER //
USE `book_resource`//
CREATE DEFINER =`root`@`localhost` TRIGGER `user_BEFORE_INSERT`
    BEFORE INSERT
    ON `user`
    FOR EACH ROW
BEGIN
    IF NOT new.password_id IN (
        SELECT id
        FROM password) THEN
        SIGNAL SQLSTATE '45000'
            SET MESSAGE_TEXT = "FK constraint. Referenced password NOT FOUND.";
    END IF;
END//
DELIMITER ;
