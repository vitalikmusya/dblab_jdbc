USE book_resource;

DROP FUNCTION IF EXISTS `select_books_by_rubric`;
DELIMITER //
CREATE FUNCTION `select_books_by_rubric`(
    id_to_find INT
)
    RETURNS VARCHAR(45)
    DETERMINISTIC
BEGIN
    return (
        SELECT rubric
        FROM catalog_tree
        WHERE id = (SELECT catalog_tree_id FROM book WHERE catalog_tree_id = id_to_find GROUP BY catalog_tree_id)
    );
END //
DELIMITER ;

SELECT id, name, authors, rating, udk, `select_books_by_rubric`(catalog_tree_id)
FROM book;