USE `book_resource`;
DROP procedure IF EXISTS `insert_into_user`;

DELIMITER //
USE `book_resource`//
CREATE PROCEDURE `insert_into_user`(
    IN in_login VARCHAR(45),
    IN in_first_name VARCHAR(45),
    IN in_last_name VARCHAR(45),
    IN in_middle_name VARCHAR(45),
    IN in_date_of_birth DATE,
    IN in_address_of_birth VARCHAR(45),
    IN in_residence_address VARCHAR(45),
    IN in_note TEXT(100),
    IN in_rating DECIMAL(4, 2),
    IN in_password_id INT)
BEGIN
    INSERT INTO `book_resource`.`user` (`login`,
                                        `first_name`,
                                        `second_name`,
                                        `middle_name`,
                                        `date_of_birth`,
                                        `address_of_birth`,
                                        `residence_address`,
                                        `note`,
                                        `rating`,
                                        `password_id`)
    VALUES (in_login,
            in_first_name,
            in_last_name,
            in_middle_name,
            in_date_of_birth,
            in_address_of_birth,
            in_residence_address,
            in_note,
            in_rating,
            in_password_id);
END//

DELIMITER ;
