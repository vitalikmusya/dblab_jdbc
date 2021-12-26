USE book_resource;
DROP PROCEDURE IF EXISTS `insert_users_with_cursor`;

DELIMITER //
CREATE PROCEDURE `insert_users_with_cursor`()
BEGIN
    DECLARE done INT DEFAULT FALSE;
    DECLARE title VARCHAR(45);
    DECLARE num_of_generations INT DEFAULT FLOOR(RAND() * 10);
    DECLARE user_cursor CURSOR FOR SELECT user.first_name FROM user;
    DECLARE CONTINUE HANDLER FOR NOT FOUND
        SET done = TRUE;
    OPEN user_cursor;

    user_loop:
    LOOP
        FETCH user_cursor INTO title;
        IF done = TRUE THEN
            LEAVE user_loop;
        END IF;
        SET @table_count = 1;
        while_loop:
        WHILE @table_count < num_of_generations
            DO
                SET @new_table = CONCAT('CREATE TABLE IF NOT EXISTS ', title, '(id INT, title VARCHAR(45));');
                SELECT @new_table;
                PREPARE myquery FROM @new_table;
                EXECUTE myquery;
                SET @table_count = @table_count + 1;
            END WHILE;
    END LOOP;
    CLOSE user_cursor;
END;
//