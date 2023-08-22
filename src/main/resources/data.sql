INSERT INTO category_model (name, description) VALUES ('Motoryzacja', 'Samochody/motocykle/maszyny rolnicze');
INSERT INTO category_model (name, description) VALUES ('Sport', 'Areobik/sporty wodne/jogging');
INSERT INTO category_model (name, description) VALUES ('Elektronika', 'Komputery/telefony/tablety');
INSERT INTO category_model (name, description) VALUES ('Wyposażenie domu', 'Meble/łóżka/stoły');
INSERT INTO category_model (name, description) VALUES ('AGD', 'Kuchenki/zmywarki/piekarniki');



INSERT INTO users (email, password, account_name, voievodeship, city, address, account_creation_date, account_status) VALUES ('jacek@o2.pl', 'password', 'Jacula', 'małopolskie', 'Katowice', 'ul. Pianki', '2023-05-01 12:15', 'INACTIVE');
INSERT INTO users (email, password, account_name, voievodeship, city, address, account_creation_date, account_status) VALUES ('bartek@o2.pl', 'password2', 'Grzmot', 'zachodniopomorskie', 'Szczecin', 'ul. Witelona', '2022-08-23 17:15', 'ACTIVE');


INSERT INTO auction_model (name, description, min_value, buy_now_value, is_promoted, start_date, end_date, views, auction_status,category_model_id) VALUES ('Passatejro', 'Sprzedam Passata. Nie bity, jeżdżone tylko do kościoła', '1500', '1400', 'true', '2022-08-05', '2022-08-23', '4','ACTIVE','1');
INSERT INTO auction_model (name, description, min_value, buy_now_value, is_promoted, start_date, end_date, views, auction_status,category_model_id) VALUES ('Romet for life', 'Sprzedam rower. Wigry 3 w super stanie', '450', '400', 'false', '2023-01-12', '2023-01-26', '12','ACTIVE','2');



