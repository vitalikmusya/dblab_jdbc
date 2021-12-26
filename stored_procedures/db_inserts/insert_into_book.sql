USE `book_resource`;
DROP procedure IF EXISTS `insert_into_book`;

USE `book_resource`;
DROP procedure IF EXISTS `book_resource`.`insert_into_book`;

DELIMITER //
USE `book_resource`//
CREATE
    DEFINER = `root`@`localhost` PROCEDURE `insert_into_book`(
    IN in_name VARCHAR(45),
    IN in_authors VARCHAR(45),
    IN in_rating DECIMAL(4, 2),
    IN in_udk VARCHAR(45),
    IN in_catalog_tree_id INT)
BEGIN
    INSERT INTO `book_resource`.`book` (`name`,
                                        `authors`,
                                        `rating`,
                                        `udk`,
                                        `catalog_tree_id`)
    VALUES (in_name,
            in_authors,
            in_rating,
            in_udk,
            in_catalog_tree_id);
END//

DELIMITER ;
;

