DROP TRIGGER IF EXISTS `book_resource`.`user_BEFORE_DELETE`;

DELIMITER //
USE `book_resource`//
CREATE DEFINER = CURRENT_USER TRIGGER `book_resource`.`user_BEFORE_DELETE`
    BEFORE DELETE
    ON `user`
    FOR EACH ROW
BEGIN
    IF old.id IN (SELECT user_id FROM bookmark) THEN
        SIGNAL SQLSTATE '45000'
            SET MESSAGE_TEXT = "FK constraint. User is referenced.";
    END IF;
END//
DELIMITER ;
