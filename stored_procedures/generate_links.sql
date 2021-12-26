USE book_resource;
DROP PROCEDURE IF EXISTS `generate_links`;

DELIMITER //
CREATE PROCEDURE `generate_links`()
BEGIN
	DECLARE i INT DEFAULT 1;
	inserting_loop : LOOP
		IF i <= 10 THEN
			INSERT INTO link (`book_email_address`, `book_id`) VALUES (CONCAT("Noname", i), 1);
            SET i = i + 1;
            ITERATE inserting_loop;
		ELSE LEAVE inserting_loop;
        END IF;
	END LOOP inserting_loop;
END //
DELIMITER ;