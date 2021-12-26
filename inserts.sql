SET SQL_SAFE_UPDATES = 0;
USE book_resource;

CALL clear_tables();

CALL insert_into_password('1234');
CALL insert_into_password('9876');
CALL insert_into_password('qwer');
CALL insert_into_password('asdf');
CALL insert_into_password('1111');
CALL insert_into_password('0000');
CALL insert_into_password('4321');


CALL insert_into_user('rtyie', 'Denys', 'Brovenko', 'Maryanovych', '2000.12.12',
                      'Lviv', 'Lviv', 'Composer', 1.35, 1);
CALL insert_into_user('masnd', 'Roman', 'Hrynyak', 'Viktorovych', '1999.12.23',
                      'Lviv', 'Lviv', 'philosoph', 2.78, 2);
CALL insert_into_user('peofeir', 'Dmytro', 'Yushchenko', 'Olegovych', '2000.12.12',
                      'Lviv', 'Lviv', 'artist', 4.99, 3);
CALL insert_into_user('akjhsdajk', 'Viktor', 'Poroshenko', 'Andriyovych', '2000.12.12',
                      'Lviv', 'Lviv', 'dancer', 5.00, 4);
CALL insert_into_user('aajaaj', 'Andrii', 'Zelenskyy', 'Grygorovych', '2000.12.12',
                      'Lviv', 'Lviv', 'sportsman', 3.20, 5);
CALL insert_into_user('ikrie', 'Eugene', 'Yanukovych', 'Oleksandrovych', '2000.12.12',
                      'Lviv', 'Lviv', 'swimmer', 3.26, 6);
CALL insert_into_user('flvknl', 'Ararat', 'Kuchma', 'Petrovych', '2000.12.12',
                      'Lviv', 'Lviv', 'reader', 1.99, 7);

CALL insert_into_catalog_tree('fantasy', null);
CALL insert_into_catalog_tree('ramance', 1);
CALL insert_into_catalog_tree('novel', 2);
CALL insert_into_catalog_tree('virsh', 3);
CALL insert_into_catalog_tree('kobzar', 4);
CALL insert_into_catalog_tree('duma', 5);
CALL insert_into_catalog_tree('polske', 6);
CALL insert_into_catalog_tree('nashe', 7);

/*CALL insert_into_book('Harry Potter and the Deathly Hallows', 'Rowling J.K.', 9.1, 1);*/
CALL insert_into_book('Kobzar', 'Shevchenko', 4.37, 'sa.233', 1);
CALL insert_into_book('Kobzar', 'Shevchenko', 1.35, 'ar.292', 2);
CALL insert_into_book('Kobzar', 'Shevchenko', 3.17, 'er.242', 1);
CALL insert_into_book('Kobzar', 'Shevchenko', 3.12, 'ae.222', 3);
CALL insert_into_book('Kobzar', 'Shevchenko', 2.14, 'vr.892', 2);
CALL insert_into_book('Kobzar', 'Shevchenko', 2.95, 'vm.378', 3);
CALL insert_into_book('Kobzar', 'Shevchenko', 2.92, 'lz.272', 1);
CALL insert_into_book('Kobzar', 'Shevchenko', 3.78, 'ap.142', 3);
CALL insert_into_book('Kobzar', 'Shevchenko', 4.12, 'sm.162', 3);
CALL insert_into_book('Kobzar', 'Shevchenko', 7.09, 'ja.292', 1);


CALL insert_into_link('www.kobzar.com', 1);
CALL insert_into_link('www.kobzar.com', 2);
CALL insert_into_link('www.kobzar.com', 3);
CALL insert_into_link('www.kobzar.com', 4);
CALL insert_into_link('www.kobzar.com', 5);
CALL insert_into_link('www.kobzar.com', 6);
CALL insert_into_link('www.kobzar.com', 7);
CALL insert_into_link('www.kobzar.com', 8);
CALL insert_into_link('www.kobzar.com', 9);
CALL insert_into_link('www.kobzar.com', 10);
CALL insert_into_link('www.kobzar.com', 1);
CALL insert_into_link('www.kobzar.com', 3);
CALL insert_into_link('www.kobzar.com', 4);
CALL insert_into_link('www.kobzar.com', 7);
CALL insert_into_link('www.kobzar.com', 8);


CALL insert_into_bookmark(1, 1);
CALL insert_into_bookmark(2, 3);
CALL insert_into_bookmark(3, 3);
CALL insert_into_bookmark(4, 6);
CALL insert_into_bookmark(5, 8);
CALL insert_into_bookmark(6, 3);
CALL insert_into_bookmark(7, 9);
CALL insert_into_bookmark(1, 2);
CALL insert_into_bookmark(3, 8);
CALL insert_into_bookmark(4, 3);
CALL insert_into_bookmark(6, 10);
CALL insert_into_bookmark(4, 4);
CALL insert_into_bookmark(7, 9);

