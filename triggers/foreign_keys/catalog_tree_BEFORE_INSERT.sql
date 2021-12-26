DROP TRIGGER IF EXISTS `book_resource`.`catalog_tree_BEFORE_INSERT`;

DELIMITER //
USE `book_resource`//
CREATE DEFINER =`root`@`localhost` TRIGGER `catalog_tree_BEFORE_INSERT`
    BEFORE INSERT
    ON `catalog_tree`
    FOR EACH ROW
BEGIN
    IF NOT new.parent_catalog_id IN (
        SELECT id
        FROM catalog_tree) THEN
        IF NOT new.parent_catalog_id IS NULL THEN
            SIGNAL SQLSTATE '45000'
                SET MESSAGE_TEXT = "Parent catalog NOT FOUND";
        END IF;
    END IF;
END//
DELIMITER ;
