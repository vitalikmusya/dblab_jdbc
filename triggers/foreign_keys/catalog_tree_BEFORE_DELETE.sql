DROP TRIGGER IF EXISTS `book_resource`.`catalog_tree_BEFORE_DELETE`;

DELIMITER //
USE `book_resource`//
CREATE DEFINER = CURRENT_USER TRIGGER `book_resource`.`catalog_tree_BEFORE_DELETE`
    BEFORE DELETE
    ON `catalog_tree`
    FOR EACH ROW
BEGIN
    IF (old.id IN (SELECT parent_catalog_id FROM catalog_tree)
        OR old.id IN (SELECT catalog_tree_id FROM book)) THEN
        SIGNAL SQLSTATE '45000'
            SET MESSAGE_TEXT = "FK constraint. catalog_tree is referenced.";
    END IF;
END//
DELIMITER ;
