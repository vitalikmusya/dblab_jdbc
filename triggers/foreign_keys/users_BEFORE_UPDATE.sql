DROP TRIGGER IF EXISTS `book_resource`.`user_BEFORE_UPDATE`;

DELIMITER //
USE `book_resource`//
CREATE DEFINER = CURRENT_USER TRIGGER `book_resource`.`user_BEFORE_UPDATE`
    BEFORE UPDATE
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
