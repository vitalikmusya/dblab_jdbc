USE `book_resource`;
DROP procedure IF EXISTS `insert_into_link`;

DELIMITER //
USE `book_resource`//
CREATE PROCEDURE `insert_into_link`(
    IN in_book_email_address VARCHAR(45),
    IN in_book_id INT)
BEGIN
    INSERT INTO `book_resource`.`link` (`book_email_address`,
                                        `book_id`)
    VALUES (in_book_email_address,
            in_book_id);
END//

DELIMITER ;
