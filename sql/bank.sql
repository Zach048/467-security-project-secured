#
# TABLE STRUCTURE FOR: customer
#
DROP TABLE IF EXISTS `transactions`;
DROP TABLE IF EXISTS `account`;
DROP TABLE IF EXISTS `customer`;

CREATE TABLE `customer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(1000) COLLATE utf8_unicode_ci DEFAULT NULL,
  `last_name` varchar(1000) COLLATE utf8_unicode_ci DEFAULT NULL,
  `email` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `phone` varchar(11) COLLATE utf8_unicode_ci DEFAULT NULL,
  `password` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `username` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `unique_username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

INSERT INTO `customer` (`id`, `first_name`, `last_name`, `email`, `phone`, `password`, `username`) VALUES (1, 'Cristobal', 'Goyette', 'ullrich.mallory@example.net', '1-234-141-3', 'password', 'lucienne.fadel');
INSERT INTO `customer` (`id`, `first_name`, `last_name`, `email`, `phone`, `password`, `username`) VALUES (2, 'Rachelle', 'Kessler', 'hfeeney@example.net', '+60(3)61285', '123456', 'ykiehn');
INSERT INTO `customer` (`id`, `first_name`, `last_name`, `email`, `phone`, `password`, `username`) VALUES (3, 'Gilbert', 'Casper', 'macy.bruen@example.org', '+03(0)61135', 'blueberry', 'pgottlieb');
INSERT INTO `customer` (`id`, `first_name`, `last_name`, `email`, `phone`, `password`, `username`) VALUES (4, 'Florencio', 'Kuhlman', 'haley.d' 'amore@example.com', '793-834-504', 'HangOver', 'hazle.kshlerin');
INSERT INTO `customer` (`id`, `first_name`, `last_name`, `email`, `phone`, `password`, `username`) VALUES (5, 'Cali', 'Batz', 'fmitchell@example.org', '(876)745-31', 'Patriots', 'bo29');
INSERT INTO `customer` (`id`, `first_name`, `last_name`, `email`, `phone`, `password`, `username`) VALUES (6, 'Brook', 'Kuvalis', 'ellen64@example.net', '+93(8)55223', 'Steelers', 'roderick.connelly');
INSERT INTO `customer` (`id`, `first_name`, `last_name`, `email`, `phone`, `password`, `username`) VALUES (7, 'Antwon', 'Kiehn', 'juvenal.waters@example.org', '1-476-534-3', 'Reds', 'llemke');
INSERT INTO `customer` (`id`, `first_name`, `last_name`, `email`, `phone`, `password`, `username`) VALUES (8, 'Vivien', 'VonRueden', 'lucienne.torp@example.org', '(842)847-58', 'buckeyes', 'vsenger');
INSERT INTO `customer` (`id`, `first_name`, `last_name`, `email`, `phone`, `password`, `username`) VALUES (9, 'Bria', 'Turner', 'ewell22@example.org', '+25(0)39634', 'tombrady12', 'orval.mills');
INSERT INTO `customer` (`id`, `first_name`, `last_name`, `email`, `phone`, `password`, `username`) VALUES (10, 'Emely', 'Bradtke', 'turner.mireille@example.com', '(240)012-43', 'john', 'dexter.krajcik');
INSERT INTO `customer` (`id`, `first_name`, `last_name`, `email`, `phone`, `password`, `username`) VALUES (11, 'Maxwell', 'Nader', 'payton32@example.org', '(731)804-11', 'September24', 'cole.reichert');
INSERT INTO `customer` (`id`, `first_name`, `last_name`, `email`, `phone`, `password`, `username`) VALUES (12, 'Deshaun', 'Hills', 'anabel.willms@example.com', '00202439340', 'Scarface', 'ismith');
INSERT INTO `customer` (`id`, `first_name`, `last_name`, `email`, `phone`, `password`, `username`) VALUES (13, 'Arjun', 'Hahn', 'blanda.ulises@example.org', '(906)106-92', 'chicagobulls23', 'lkovacek');
INSERT INTO `customer` (`id`, `first_name`, `last_name`, `email`, `phone`, `password`, `username`) VALUES (14, 'Enrique', 'Lang', 'kevon98@example.net', '286-925-839', 'password123', 'moen.kailee');
INSERT INTO `customer` (`id`, `first_name`, `last_name`, `email`, `phone`, `password`, `username`) VALUES (15, 'Wilburn', 'Franecki', 'hyatt.noemie@example.com', '662.358.683', 'penguins', 'fwindler');
INSERT INTO `customer` (`id`, `first_name`, `last_name`, `email`, `phone`, `password`, `username`) VALUES (16, 'Curtis', 'Powlowski', 'barton.kira@example.com', '299.097.700', 'kingjames23', 'abernathy.merle');
INSERT INTO `customer` (`id`, `first_name`, `last_name`, `email`, `phone`, `password`, `username`) VALUES (17, 'Ray', 'Rutherford', 'ruthe84@example.net', '483-971-735', 'kobebryant', 'd\'amore.jadon');
INSERT INTO `customer` (`id`, `first_name`, `last_name`, `email`, `phone`, `password`, `username`) VALUES (18, 'Jennyfer', 'Mitchell', 'colleen05@example.com', '396.623.387', 'ferrari', 'emilia.mosciski');
INSERT INTO `customer` (`id`, `first_name`, `last_name`, `email`, `phone`, `password`, `username`) VALUES (19, 'Jed', 'Mohr', 'tania58@example.com', '1-891-515-6', 'zachary', 'beatty.coby');
INSERT INTO `customer` (`id`, `first_name`, `last_name`, `email`, `phone`, `password`, `username`) VALUES (20, 'Wilbert', 'Crona', 'xkshlerin@example.net', '476-007-657', 'NinjaTurtles', 'koch.camron');
INSERT INTO `customer` (`id`, `first_name`, `last_name`, `email`, `phone`, `password`, `username`) VALUES (21, 'Greta', 'Pagac', 'ruthie54@example.org', '893-332-845', 'therock34', 'nbernhard');
INSERT INTO `customer` (`id`, `first_name`, `last_name`, `email`, `phone`, `password`, `username`) VALUES (22, 'Ethelyn', 'Kunze', 'haley.esperanza@example.net', '04654134880', 'iamtoocool', 'cathrine41');
INSERT INTO `customer` (`id`, `first_name`, `last_name`, `email`, `phone`, `password`, `username`) VALUES (23, 'Magdalena', 'Okuneva', 'ahand@example.org', '08289344167', 'pizza', 'hertha81');
INSERT INTO `customer` (`id`, `first_name`, `last_name`, `email`, `phone`, `password`, `username`) VALUES (24, 'Jarrett', 'Crona', 'yrempel@example.org', '1-945-369-1', 'apple', 'erenner');
INSERT INTO `customer` (`id`, `first_name`, `last_name`, `email`, `phone`, `password`, `username`) VALUES (25, 'Shemar', 'Turner', 'anderson61@example.org', '369.900.567', 'dolphins13', 'tyrese68');


#
# TABLE STRUCTURE FOR: account
#

CREATE TABLE `account` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `checking_account` varchar(9) COLLATE utf8_unicode_ci DEFAULT NULL,
  `credit_card` varchar(16) COLLATE utf8_unicode_ci DEFAULT NULL,
  `checking_balance` decimal(15,2) DEFAULT NULL,
  `credit_card_balance` decimal(15,2) DEFAULT NULL,
  `customer_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_customer` (`customer_id`),
  CONSTRAINT `fk_customer` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

INSERT INTO `account` (`id`, `checking_account`, `credit_card`, `checking_balance`, `credit_card_balance`, `customer_id`) VALUES (1, '833432104', '5409260775961432', '93.97', '77.05', 1);
INSERT INTO `account` (`id`, `checking_account`, `credit_card`, `checking_balance`, `credit_card_balance`, `customer_id`) VALUES (2, '212952457', '5374329778806412', '87400.27', '83582.00', 2);
INSERT INTO `account` (`id`, `checking_account`, `credit_card`, `checking_balance`, `credit_card_balance`, `customer_id`) VALUES (3, '663059504', '5533384397927947', '50187041.99', '15332.15', 3);
INSERT INTO `account` (`id`, `checking_account`, `credit_card`, `checking_balance`, `credit_card_balance`, `customer_id`) VALUES (4, '908392509', '4716600120073335', '219.42', '9825.10', 4);
INSERT INTO `account` (`id`, `checking_account`, `credit_card`, `checking_balance`, `credit_card_balance`, `customer_id`) VALUES (5, '351241862', '4929858510901', '231.56', '2959.93', 5);
INSERT INTO `account` (`id`, `checking_account`, `credit_card`, `checking_balance`, `credit_card_balance`, `customer_id`) VALUES (6, '920712325', '5298910076295334', '95.50', '92.89', 6);
INSERT INTO `account` (`id`, `checking_account`, `credit_card`, `checking_balance`, `credit_card_balance`, `customer_id`) VALUES (7, '270261686', '6011273581443085', '86.00', '1967.21', 7);
INSERT INTO `account` (`id`, `checking_account`, `credit_card`, `checking_balance`, `credit_card_balance`, `customer_id`) VALUES (8, '166785774', '4916753951387', '11764.97', '3942.68', 8);
INSERT INTO `account` (`id`, `checking_account`, `credit_card`, `checking_balance`, `credit_card_balance`, `customer_id`) VALUES (9, '211023671', '5350711241232040', '21.00', '92.28', 9);
INSERT INTO `account` (`id`, `checking_account`, `credit_card`, `checking_balance`, `credit_card_balance`, `customer_id`) VALUES (10, '501206842', '5559275322956539', '4096.61', '13.75', 10);
INSERT INTO `account` (`id`, `checking_account`, `credit_card`, `checking_balance`, `credit_card_balance`, `customer_id`) VALUES (11, '491073761', '4532546061458', '48.60', '462.67', 11);
INSERT INTO `account` (`id`, `checking_account`, `credit_card`, `checking_balance`, `credit_card_balance`, `customer_id`) VALUES (12, '867294022', '5580264641395116', '42.30', '17238.69', 12);
INSERT INTO `account` (`id`, `checking_account`, `credit_card`, `checking_balance`, `credit_card_balance`, `customer_id`) VALUES (13, '666719717', '6011470361188836', '99.45', '97.51', 13);
INSERT INTO `account` (`id`, `checking_account`, `credit_card`, `checking_balance`, `credit_card_balance`, `customer_id`) VALUES (14, '921983901', '4916231088399211', '27.00', '406.90', 14);
INSERT INTO `account` (`id`, `checking_account`, `credit_card`, `checking_balance`, `credit_card_balance`, `customer_id`) VALUES (15, '747278489', '4556412929500841', '2555.02', '67.78', 15);
INSERT INTO `account` (`id`, `checking_account`, `credit_card`, `checking_balance`, `credit_card_balance`, `customer_id`) VALUES (16, '507198738', '5593146204691255', '93.47', '393.62', 16);
INSERT INTO `account` (`id`, `checking_account`, `credit_card`, `checking_balance`, `credit_card_balance`, `customer_id`) VALUES (17, '744377342', '5437036352203078', '806.19', '99877.43', 17);
INSERT INTO `account` (`id`, `checking_account`, `credit_card`, `checking_balance`, `credit_card_balance`, `customer_id`) VALUES (18, '157568550', '5121787126601862', '14.70', '4529.64', 18);
INSERT INTO `account` (`id`, `checking_account`, `credit_card`, `checking_balance`, `credit_card_balance`, `customer_id`) VALUES (19, '661195068', '4539140567004636', '6.50', '92.79', 19);
INSERT INTO `account` (`id`, `checking_account`, `credit_card`, `checking_balance`, `credit_card_balance`, `customer_id`) VALUES (20, '895328751', '4539877151164', '4129.76', '1196.31', 20);
INSERT INTO `account` (`id`, `checking_account`, `credit_card`, `checking_balance`, `credit_card_balance`, `customer_id`) VALUES (21, '536802807', '5376002861786739', '353.11', '24805.86', 21);
INSERT INTO `account` (`id`, `checking_account`, `credit_card`, `checking_balance`, `credit_card_balance`, `customer_id`) VALUES (22, '257709648', '4532950081276967', '96.46', '26639.80', 22);
INSERT INTO `account` (`id`, `checking_account`, `credit_card`, `checking_balance`, `credit_card_balance`, `customer_id`) VALUES (23, '333892586', '4532816264478', '14053.65', '6033.02', 23);
INSERT INTO `account` (`id`, `checking_account`, `credit_card`, `checking_balance`, `credit_card_balance`, `customer_id`) VALUES (24, '699515972', '4929943298190', '6949.67', '30592.00', 24);
INSERT INTO `account` (`id`, `checking_account`, `credit_card`, `checking_balance`, `credit_card_balance`, `customer_id`) VALUES (25, '402538425', '4024007149656', '3166.85', '7461.76', 25);




#
# TABLE STRUCTURE FOR: transactions
#


CREATE TABLE `transactions` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `vendor_name` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `amount_paid` decimal(15,2) DEFAULT NULL,
  `account_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_account` (`account_id`),
  CONSTRAINT `fk_account` FOREIGN KEY (`account_id`) REFERENCES `account` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=101 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

INSERT INTO `transactions` (`id`, `vendor_name`, `amount_paid`, `account_id`) VALUES (1, 'Heller PLC', '4441019.30', 1);
INSERT INTO `transactions` (`id`, `vendor_name`, `amount_paid`, `account_id`) VALUES (2, 'Volkman and Sons', '5.61', 2);
INSERT INTO `transactions` (`id`, `vendor_name`, `amount_paid`, `account_id`) VALUES (3, 'Lang, Crist and Klein', '71303563.77', 3);
INSERT INTO `transactions` (`id`, `vendor_name`, `amount_paid`, `account_id`) VALUES (4, 'Bartoletti PLC', '2309021.77', 4);
INSERT INTO `transactions` (`id`, `vendor_name`, `amount_paid`, `account_id`) VALUES (5, 'Kunze Ltd', '9.31', 5);
INSERT INTO `transactions` (`id`, `vendor_name`, `amount_paid`, `account_id`) VALUES (6, 'D\'Amore-Kuphal', '1790384.27', 6);
INSERT INTO `transactions` (`id`, `vendor_name`, `amount_paid`, `account_id`) VALUES (7, 'Gutmann-Hagenes', '752.60', 7);
INSERT INTO `transactions` (`id`, `vendor_name`, `amount_paid`, `account_id`) VALUES (8, 'Greenfelder-Lakin', '228.60', 8);
INSERT INTO `transactions` (`id`, `vendor_name`, `amount_paid`, `account_id`) VALUES (9, 'Schuppe Group', '14.88', 9);
INSERT INTO `transactions` (`id`, `vendor_name`, `amount_paid`, `account_id`) VALUES (10, 'Goodwin, Corkery and Anderson', '8601027.61', 10);
INSERT INTO `transactions` (`id`, `vendor_name`, `amount_paid`, `account_id`) VALUES (11, 'Bartell LLC', '9.69', 11);
INSERT INTO `transactions` (`id`, `vendor_name`, `amount_paid`, `account_id`) VALUES (12, 'Zboncak-Schumm', '22275.93', 12);
INSERT INTO `transactions` (`id`, `vendor_name`, `amount_paid`, `account_id`) VALUES (13, 'Robel-Heidenreich', '6127551.87', 13);
INSERT INTO `transactions` (`id`, `vendor_name`, `amount_paid`, `account_id`) VALUES (14, 'Ernser Group', '7.04', 14);
INSERT INTO `transactions` (`id`, `vendor_name`, `amount_paid`, `account_id`) VALUES (15, 'Parisian Ltd', '7.08', 15);
INSERT INTO `transactions` (`id`, `vendor_name`, `amount_paid`, `account_id`) VALUES (16, 'Anderson-Emard', '20812.80', 16);
INSERT INTO `transactions` (`id`, `vendor_name`, `amount_paid`, `account_id`) VALUES (17, 'Lowe-Dibbert', '2.01', 17);
INSERT INTO `transactions` (`id`, `vendor_name`, `amount_paid`, `account_id`) VALUES (18, 'Armstrong Group', '415963.83', 18);
INSERT INTO `transactions` (`id`, `vendor_name`, `amount_paid`, `account_id`) VALUES (19, 'Roob, Runolfsson and Schumm', '80365326.85', 19);
INSERT INTO `transactions` (`id`, `vendor_name`, `amount_paid`, `account_id`) VALUES (20, 'Waelchi Group', '106.40', 20);
INSERT INTO `transactions` (`id`, `vendor_name`, `amount_paid`, `account_id`) VALUES (21, 'Watsica-Gulgowski', '20535.96', 21);
INSERT INTO `transactions` (`id`, `vendor_name`, `amount_paid`, `account_id`) VALUES (22, 'Langosh, Stark and Hickle', '486123.53', 22);
INSERT INTO `transactions` (`id`, `vendor_name`, `amount_paid`, `account_id`) VALUES (23, 'Ryan, Stark and Casper', '113914395.17', 23);
INSERT INTO `transactions` (`id`, `vendor_name`, `amount_paid`, `account_id`) VALUES (24, 'Kreiger, Blanda and Hodkiewicz', '5.93', 24);
INSERT INTO `transactions` (`id`, `vendor_name`, `amount_paid`, `account_id`) VALUES (25, 'Erdman-Raynor', '25999.36', 25);
INSERT INTO `transactions` (`id`, `vendor_name`, `amount_paid`, `account_id`) VALUES (26, 'Stamm Group', '3.00', 1);
INSERT INTO `transactions` (`id`, `vendor_name`, `amount_paid`, `account_id`) VALUES (27, 'Hane-Ortiz', '1872577.51', 2);
INSERT INTO `transactions` (`id`, `vendor_name`, `amount_paid`, `account_id`) VALUES (28, 'Carroll, Skiles and Kutch', '45.00', 3);
INSERT INTO `transactions` (`id`, `vendor_name`, `amount_paid`, `account_id`) VALUES (29, 'Zulauf-Lemke', '14.12', 4);
INSERT INTO `transactions` (`id`, `vendor_name`, `amount_paid`, `account_id`) VALUES (30, 'Dibbert, Hagenes and Thompson', '8028989.50', 5);
INSERT INTO `transactions` (`id`, `vendor_name`, `amount_paid`, `account_id`) VALUES (31, 'Lubowitz, Gaylord and Bayer', '51.80', 6);
INSERT INTO `transactions` (`id`, `vendor_name`, `amount_paid`, `account_id`) VALUES (32, 'Flatley PLC', '331.98', 7);
INSERT INTO `transactions` (`id`, `vendor_name`, `amount_paid`, `account_id`) VALUES (33, 'Considine-Kuhlman', '33.47', 8);
INSERT INTO `transactions` (`id`, `vendor_name`, `amount_paid`, `account_id`) VALUES (34, 'Toy Group', '94.27', 9);
INSERT INTO `transactions` (`id`, `vendor_name`, `amount_paid`, `account_id`) VALUES (35, 'Leannon, Greenholt and Torp', '30.27', 10);
INSERT INTO `transactions` (`id`, `vendor_name`, `amount_paid`, `account_id`) VALUES (36, 'Roob-Wolf', '19090.48', 11);
INSERT INTO `transactions` (`id`, `vendor_name`, `amount_paid`, `account_id`) VALUES (37, 'Windler-Paucek', '11.49', 12);
INSERT INTO `transactions` (`id`, `vendor_name`, `amount_paid`, `account_id`) VALUES (38, 'Erdman, Paucek and Yundt', '60731866.51', 13);
INSERT INTO `transactions` (`id`, `vendor_name`, `amount_paid`, `account_id`) VALUES (39, 'Hudson and Sons', '4500534.00', 14);
INSERT INTO `transactions` (`id`, `vendor_name`, `amount_paid`, `account_id`) VALUES (40, 'Bogan PLC', '1193003.00', 15);
INSERT INTO `transactions` (`id`, `vendor_name`, `amount_paid`, `account_id`) VALUES (41, 'Ernser, Walsh and Stehr', '18959765.35', 16);
INSERT INTO `transactions` (`id`, `vendor_name`, `amount_paid`, `account_id`) VALUES (42, 'Schumm, Jenkins and Kuhlman', '6757.00', 17);
INSERT INTO `transactions` (`id`, `vendor_name`, `amount_paid`, `account_id`) VALUES (43, 'Block-Strosin', '9.34', 18);
INSERT INTO `transactions` (`id`, `vendor_name`, `amount_paid`, `account_id`) VALUES (44, 'Stamm Group', '169289.16', 19);
INSERT INTO `transactions` (`id`, `vendor_name`, `amount_paid`, `account_id`) VALUES (45, 'Lowe-Conroy', '7.44', 20);
INSERT INTO `transactions` (`id`, `vendor_name`, `amount_paid`, `account_id`) VALUES (46, 'Hahn Group', '8.87', 21);
INSERT INTO `transactions` (`id`, `vendor_name`, `amount_paid`, `account_id`) VALUES (47, 'Gutkowski Group', '1.24', 22);
INSERT INTO `transactions` (`id`, `vendor_name`, `amount_paid`, `account_id`) VALUES (48, 'Shields and Sons', '7.00', 23);
INSERT INTO `transactions` (`id`, `vendor_name`, `amount_paid`, `account_id`) VALUES (49, 'Rohan-Bayer', '434993.69', 24);
INSERT INTO `transactions` (`id`, `vendor_name`, `amount_paid`, `account_id`) VALUES (50, 'Borer-Zieme', '464383.53', 25);
INSERT INTO `transactions` (`id`, `vendor_name`, `amount_paid`, `account_id`) VALUES (51, 'Stokes-Heathcote', '9.13', 1);
INSERT INTO `transactions` (`id`, `vendor_name`, `amount_paid`, `account_id`) VALUES (52, 'Boyer, Koepp and Wisoky', '30.76', 2);
INSERT INTO `transactions` (`id`, `vendor_name`, `amount_paid`, `account_id`) VALUES (53, 'Heaney and Sons', '8091.17', 3);
INSERT INTO `transactions` (`id`, `vendor_name`, `amount_paid`, `account_id`) VALUES (54, 'Schimmel Ltd', '4327.13', 4);
INSERT INTO `transactions` (`id`, `vendor_name`, `amount_paid`, `account_id`) VALUES (55, 'Smith-Barrows', '1274.14', 5);
INSERT INTO `transactions` (`id`, `vendor_name`, `amount_paid`, `account_id`) VALUES (56, 'Schaden Group', '121416.00', 6);
INSERT INTO `transactions` (`id`, `vendor_name`, `amount_paid`, `account_id`) VALUES (57, 'Pfeffer Group', '104525.13', 7);
INSERT INTO `transactions` (`id`, `vendor_name`, `amount_paid`, `account_id`) VALUES (58, 'Fay, Kreiger and Hyatt', '109549.92', 8);
INSERT INTO `transactions` (`id`, `vendor_name`, `amount_paid`, `account_id`) VALUES (59, 'Swift Inc', '10.69', 9);
INSERT INTO `transactions` (`id`, `vendor_name`, `amount_paid`, `account_id`) VALUES (60, 'Lowe-Langworth', '9.74', 10);
INSERT INTO `transactions` (`id`, `vendor_name`, `amount_paid`, `account_id`) VALUES (61, 'Strosin PLC', '14565577.90', 11);
INSERT INTO `transactions` (`id`, `vendor_name`, `amount_paid`, `account_id`) VALUES (62, 'Wintheiser-Dietrich', '9.30', 12);
INSERT INTO `transactions` (`id`, `vendor_name`, `amount_paid`, `account_id`) VALUES (63, 'Herman, Deckow and Kiehn', '66372.00', 13);
INSERT INTO `transactions` (`id`, `vendor_name`, `amount_paid`, `account_id`) VALUES (64, 'Hyatt, Metz and Langworth', '5028014.54', 14);
INSERT INTO `transactions` (`id`, `vendor_name`, `amount_paid`, `account_id`) VALUES (65, 'Jenkins, Schultz and Steuber', '18248535.26', 15);
INSERT INTO `transactions` (`id`, `vendor_name`, `amount_paid`, `account_id`) VALUES (66, 'Langosh-Kuhlman', '12.98', 16);
INSERT INTO `transactions` (`id`, `vendor_name`, `amount_paid`, `account_id`) VALUES (67, 'Lueilwitz-Langosh', '7393.48', 17);
INSERT INTO `transactions` (`id`, `vendor_name`, `amount_paid`, `account_id`) VALUES (68, 'Heidenreich, Feeney and Little', '2023513.00', 18);
INSERT INTO `transactions` (`id`, `vendor_name`, `amount_paid`, `account_id`) VALUES (69, 'Gutmann, Breitenberg and Schuster', '230.00', 19);
INSERT INTO `transactions` (`id`, `vendor_name`, `amount_paid`, `account_id`) VALUES (70, 'Boehm and Sons', '15446235.23', 20);
INSERT INTO `transactions` (`id`, `vendor_name`, `amount_paid`, `account_id`) VALUES (71, 'Jenkins LLC', '4085.08', 21);
INSERT INTO `transactions` (`id`, `vendor_name`, `amount_paid`, `account_id`) VALUES (72, 'Krajcik, Koss and Lubowitz', '14.52', 22);
INSERT INTO `transactions` (`id`, `vendor_name`, `amount_paid`, `account_id`) VALUES (73, 'Bartoletti, Brakus and McClure', '86.45', 23);
INSERT INTO `transactions` (`id`, `vendor_name`, `amount_paid`, `account_id`) VALUES (74, 'Mayer, Graham and Quitzon', '30235.76', 24);
INSERT INTO `transactions` (`id`, `vendor_name`, `amount_paid`, `account_id`) VALUES (75, 'Frami LLC', '8.09', 25);
INSERT INTO `transactions` (`id`, `vendor_name`, `amount_paid`, `account_id`) VALUES (76, 'Kling-Cormier', '6.28', 1);
INSERT INTO `transactions` (`id`, `vendor_name`, `amount_paid`, `account_id`) VALUES (77, 'Ondricka and Sons', '330.30', 2);
INSERT INTO `transactions` (`id`, `vendor_name`, `amount_paid`, `account_id`) VALUES (78, 'Champlin-Skiles', '3816528.42', 3);
INSERT INTO `transactions` (`id`, `vendor_name`, `amount_paid`, `account_id`) VALUES (79, 'Kulas-Hessel', '2457425.66', 4);
INSERT INTO `transactions` (`id`, `vendor_name`, `amount_paid`, `account_id`) VALUES (80, 'Ernser-Hand', '1288847.25', 5);
INSERT INTO `transactions` (`id`, `vendor_name`, `amount_paid`, `account_id`) VALUES (81, 'Hilpert-Kihn', '8.57', 6);
INSERT INTO `transactions` (`id`, `vendor_name`, `amount_paid`, `account_id`) VALUES (82, 'Hamill, Reichel and Upton', '2.98', 7);
INSERT INTO `transactions` (`id`, `vendor_name`, `amount_paid`, `account_id`) VALUES (83, 'Kunde, Boyer and Mueller', '91661.23', 8);
INSERT INTO `transactions` (`id`, `vendor_name`, `amount_paid`, `account_id`) VALUES (84, 'Bartell-Schinner', '141227861.96', 9);
INSERT INTO `transactions` (`id`, `vendor_name`, `amount_paid`, `account_id`) VALUES (85, 'Prosacco, Simonis and Crist', '1687106.62', 10);
INSERT INTO `transactions` (`id`, `vendor_name`, `amount_paid`, `account_id`) VALUES (86, 'Miller, Schmeler and Fisher', '235027001.52', 11);
INSERT INTO `transactions` (`id`, `vendor_name`, `amount_paid`, `account_id`) VALUES (87, 'Jacobs PLC', '107.51', 12);
INSERT INTO `transactions` (`id`, `vendor_name`, `amount_paid`, `account_id`) VALUES (88, 'Ankunding Ltd', '169634636.27', 13);
INSERT INTO `transactions` (`id`, `vendor_name`, `amount_paid`, `account_id`) VALUES (89, 'Gerlach-Wyman', '0.45', 14);
INSERT INTO `transactions` (`id`, `vendor_name`, `amount_paid`, `account_id`) VALUES (90, 'Davis, Mueller and Dietrich', '331180.00', 15);
INSERT INTO `transactions` (`id`, `vendor_name`, `amount_paid`, `account_id`) VALUES (91, 'Metz LLC', '620618.00', 16);
INSERT INTO `transactions` (`id`, `vendor_name`, `amount_paid`, `account_id`) VALUES (92, 'Satterfield-Zemlak', '6.00', 17);
INSERT INTO `transactions` (`id`, `vendor_name`, `amount_paid`, `account_id`) VALUES (93, 'Bailey, Sanford and Botsford', '60697.41', 18);
INSERT INTO `transactions` (`id`, `vendor_name`, `amount_paid`, `account_id`) VALUES (94, 'Rath, Dare and Schuppe', '317.97', 19);
INSERT INTO `transactions` (`id`, `vendor_name`, `amount_paid`, `account_id`) VALUES (95, 'Reynolds, Homenick and Padberg', '55399.37', 20);
INSERT INTO `transactions` (`id`, `vendor_name`, `amount_paid`, `account_id`) VALUES (96, 'Graham-Collins', '9.32', 21);
INSERT INTO `transactions` (`id`, `vendor_name`, `amount_paid`, `account_id`) VALUES (97, 'Steuber-Shanahan', '4.17', 22);
INSERT INTO `transactions` (`id`, `vendor_name`, `amount_paid`, `account_id`) VALUES (98, 'O\'Connell Inc', '3448881.00', 23);
INSERT INTO `transactions` (`id`, `vendor_name`, `amount_paid`, `account_id`) VALUES (99, 'Marquardt-Schinner', '339436.43', 24);
INSERT INTO `transactions` (`id`, `vendor_name`, `amount_paid`, `account_id`) VALUES (100, 'Runolfsdottir-Spencer', '16562282.27', 25);