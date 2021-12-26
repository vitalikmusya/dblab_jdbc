USE `book_resource`;
DROP procedure IF EXISTS `insert_into_catalog_tree`;

DELIMITER //
USE `book_resource`//
CREATE PROCEDURE `insert_into_catalog_tree`(
    IN in_rubric VARCHAR(45),
    IN in_parent_catalog_id INT)
BEGIN
    INSERT INTO `book_resource`.`catalog_tree` (`rubric`,
                                                `parent_catalog_id`)
    VALUES (in_rubric,
            in_parent_catalog_id);
END//

DELIMITER ;
