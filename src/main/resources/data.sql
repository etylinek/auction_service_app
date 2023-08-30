INSERT INTO category_model (name, description) VALUES ('Motoryzacja', 'Samochody/motocykle/maszyny rolnicze');
INSERT INTO category_model (name, description) VALUES ('Sport', 'Areobik/sporty wodne/jogging');
INSERT INTO category_model (name, description) VALUES ('Elektronika', 'Komputery/telefony/tablety');
INSERT INTO category_model (name, description) VALUES ('Wyposażenie domu', 'Meble/łóżka/stoły');
INSERT INTO category_model (name, description) VALUES ('AGD', 'Kuchenki/zmywarki/piekarniki');



INSERT INTO users (email, password, account_name, voievodeship, city, address, account_creation_date, account_status) VALUES ('jacek@o2.pl', '$2a$10$3A0styUycYGDi4MaL/iZvO7OfKhNp3cZHRVOIKJdSSfT1Du8u2GIm', 'Jacula', 'małopolskie', 'Katowice', 'ul. Pianki', '2023-05-01 12:15', 'INACTIVE');
INSERT INTO users (email, password, account_name, voievodeship, city, address, account_creation_date, account_status) VALUES ('bartek@o2.pl', 'password2', 'Grzmot', 'zachodniopomorskie', 'Szczecin', 'ul. Witelona', '2022-08-23 17:15', 'ACTIVE');


INSERT INTO auction_model (name, description, min_value, buy_now_value, is_promoted, start_date, end_date, views, auction_status,category_model_id,	user_model_id) VALUES ('Mikrofala, uszkodzona', 'Sprzedam uszkodzoną mikrofalówkę.', '60', '70', 'false', '2023-08-14 13:19:37', '2023-08-28 13:19:37', '0','ACTIVE','5','1');
INSERT INTO auction_model (name, description, min_value, buy_now_value, is_promoted, start_date, end_date, views, auction_status,category_model_id,	user_model_id) VALUES ('Zmywarka - dobry stan', 'Sprzedam zmywarkę w dobrym stanie, sprawna.', '370', '420', 'false', '2023-08-22 16:26:11', '2023-08-29 16:26:11', '0','ACTIVE','5','2');
INSERT INTO auction_model (name, description, min_value, buy_now_value, is_promoted, start_date, end_date, views, auction_status,category_model_id,	user_model_id) VALUES ('Passeratti 1.9TDI', 'Sprzedam Passata. Nie bity, jeżdżone tylko do kościoła', '8500', '9500', 'true', '2023-08-22 11:15:52', '2023-09-02 11:15:52', '4','ACTIVE','1','1');
INSERT INTO auction_model (name, description, min_value, buy_now_value, is_promoted, start_date, end_date, views, auction_status,category_model_id,	user_model_id) VALUES ('Romet for life', 'Sprzedam rower. Wigry 3 w super stanie', '450', '500', 'false', '2023-08-25 19:44:21', '2023-09-10 19:44:21', '12','ACTIVE','2','2');
INSERT INTO auction_model (name, description, min_value, buy_now_value, is_promoted, start_date, end_date, views, auction_status,category_model_id,	user_model_id) VALUES ('Beta w benzie', 'Sprzedam BMW. Działające kierunkowskazy', '8200', '8700', 'false', '2023-08-25 06:37:32', '2023-09-03 06:37:32', '89','ACTIVE','1','1');
INSERT INTO auction_model (name, description, min_value, buy_now_value, is_promoted, start_date, end_date, views, auction_status,category_model_id,	user_model_id) VALUES ('Iphone - nowy!!!', 'Nowy Iphone w super cenie!', '4700', '5000', 'true', '2023-08-25 22:48:19', '2023-09-09 22:48:19', '14','ACTIVE','3','1');
INSERT INTO auction_model (name, description, min_value, buy_now_value, is_promoted, start_date, end_date, views, auction_status,category_model_id,	user_model_id) VALUES ('VR Playstation 5', 'Nowy, zapraszam', '2600', '3000', 'true', '2023-08-26 17:55:28', '2023-09-10 17:55:28', '46','BLOCKED','3','2');
INSERT INTO auction_model (name, description, min_value, buy_now_value, is_promoted, start_date, end_date, views, auction_status,category_model_id,	user_model_id) VALUES ('Kij zaczepno obronny z Bety', 'Sprzedam kij, drewniany, mało używany.', '30', '35', 'true', '2023-08-27 15:23:59', '2023-09-12 15:23:59', '36','ACTIVE','2','1');
INSERT INTO auction_model (name, description, min_value, buy_now_value, is_promoted, start_date, end_date, views, auction_status,category_model_id,	user_model_id) VALUES ('Kwiatki doniczkowe', 'Storczyki.', '15', '10', 'true', '2023-08-28 13:08:12', '2023-09-13 13:08:12', '36','ACTIVE','4','2');



