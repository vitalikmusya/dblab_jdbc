USE `book_resource`;
DROP procedure IF EXISTS `insert_into_bookmark`;

DELIMITER //
USE `book_resource`//
CREATE PROCEDURE `insert_into_bookmark`(
    IN in_user_id INT,
    IN in_book_id INT)
BEGIN
    INSERT INTO `book_resource`.`bookmark` (`user_id`,
                                            `book_id`)
    VALUES (in_user_id,
            in_book_id);
END//

DELIMITER ;
