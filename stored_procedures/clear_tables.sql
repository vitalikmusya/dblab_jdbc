USE `book_resource`;
DROP procedure IF EXISTS `book_resource`.`clear_tables`;

DELIMITER //
USE `book_resource`//
CREATE
    DEFINER = `root`@`localhost` PROCEDURE `clear_tables`()
BEGIN
    DELETE FROM bookmark;
    DELETE FROM user;
    DELETE FROM link;
    DELETE FROM book;
    DELETE FROM catalog_tree ORDER BY id DESC;

    ALTER TABLE user
        AUTO_INCREMENT = 1;
    ALTER TABLE link
        AUTO_INCREMENT = 1;
    ALTER TABLE book
        AUTO_INCREMENT = 1;
    ALTER TABLE catalog_tree
        AUTO_INCREMENT = 1;
END//

DELIMITER ;
