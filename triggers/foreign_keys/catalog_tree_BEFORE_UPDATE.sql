DROP TRIGGER IF EXISTS `book_resource`.`catalog_tree_BEFORE_UPDATE`;

DELIMITER //
USE `book_resource`//
CREATE DEFINER =`root`@`localhost` TRIGGER `catalog_tree_BEFORE_UPDATE`
    BEFORE UPDATE
    ON `catalog_tree`
    FOR EACH ROW
BEGIN
    IF NOT new.parent_catalog_id IN (
        SELECT id
        FROM catalog_tree) THEN
        IF NOT new.parent_catalog_id IS NULL THEN
            SIGNAL SQLSTATE '45000'
                SET MESSAGE_TEXT = "FK constraint. catalog_tree NOT FOUND.";
        END IF;
    ELSE
        IF ((old.parent_catalog_id IS NULL
            AND (SELECT COUNT(*)
                 FROM catalog_tree
                 WHERE parent_catalog_id IS NULL) = 1)
            OR new.parent_catalog_id >= old.id) THEN
            SIGNAL SQLSTATE '45000'
                SET MESSAGE_TEXT = "FK constraint. Has to be at least one root catalog and parent_catalog_id < id.";
        END IF;
    END IF;
END//
DELIMITER ;
