DROP TRIGGER IF EXISTS `book_resource`.`bookmark_BEFORE_INSERT`;

DELIMITER //
USE `book_resource`//
CREATE DEFINER = CURRENT_USER TRIGGER `book_resource`.`bookmark_BEFORE_INSERT`
    BEFORE INSERT
    ON `bookmark`
    FOR EACH ROW
BEGIN
    IF NOT new.user_id IN (
        SELECT id
        FROM user) THEN
        SIGNAL SQLSTATE '45000'
            SET MESSAGE_TEXT = "FK constraint. Referenced user NOT FOUND.";
    END IF;
    IF NOT new.book_id IN (
        SELECT id
        FROM book) THEN
        SIGNAL SQLSTATE '45000'
            SET MESSAGE_TEXT = "FK constraint. Referenced book NOT FOUND.";
    END IF;
END//
DELIMITER ;
