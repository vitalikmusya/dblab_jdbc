DROP TRIGGER IF EXISTS `book_resource`.`link_BEFORE_UPDATE`;

DELIMITER //
USE `book_resource`//
CREATE DEFINER = CURRENT_USER TRIGGER `book_resource`.`link_BEFORE_UPDATE`
    BEFORE UPDATE
    ON `link`
    FOR EACH ROW
BEGIN
    IF NOT new.book_id IN (
        SELECT id
        FROM book) THEN
        SIGNAL SQLSTATE '45000'
            SET MESSAGE_TEXT = "FK constraint. Referenced book NOT FOUND.";
    END IF;
END//
DELIMITER ;
