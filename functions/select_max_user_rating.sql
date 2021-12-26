USE book_resource;

DROP FUNCTION IF EXISTS select_max_user_rating;
DELIMITER //
CREATE FUNCTION select_max_user_rating()
    RETURNS DECIMAL(3, 2)
    DETERMINISTIC
BEGIN
    return (SELECT MAX(rating) FROM `user`);
END;
SELECT *
FROM `user`
WHERE rating = select_max_user_rating()//
DELIMITER ;