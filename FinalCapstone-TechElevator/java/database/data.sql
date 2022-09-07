BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');


INSERT INTO reviews (review_id, beer_id, review_text, star_rating) 
VALUES (1, 1, 'This place is poppin!', 5);
INSERT INTO reviews (review_id, beer_id, review_text, star_rating) 
VALUES (2, 1, 'Meh.. was not the funnest thing but not bad', 3);
INSERT INTO reviews (review_id, beer_id, review_text, star_rating) 
VALUES (3, 2, 'Why does this make me feel funny?', 1);
INSERT INTO reviews (review_id, beer_id, review_text, star_rating) 
VALUES (4, 3, 'This brewery provided exquisite flavors and an exquisite view.', 5);

INSERT INTO beer (beer_id, beer_name, description, beer_prices, beer_type) 
VALUES (1, 'Bud Light', 'A drink that makes you feel funny', 8, 'Malt');
INSERT INTO beer (beer_id, beer_name, description, beer_prices, beer_type) 
VALUES (2, 'Corona', 'A drink to satisfy a thirst.', 6, 'Hop');
INSERT INTO beer (beer_id, beer_name, description, beer_prices, beer_type) 
VALUES (3, 'Sam Adams', 'Something to drink up. Yum yum!', 7, 'IPA');
       
INSERT INTO brewery (brewery_id, beer_id, review_id, brewery_name, description, street_name, zip_code, phone_number, website_url)
VALUES (1, 1, 1, 'BrewBoys', 'Enjoy a drink on the beach!', 'Wallaby', '76108', '678-999-8212', 'PLACEHOLDER URL');       
INSERT INTO brewery (brewery_id, beer_id, review_id, brewery_name, description, street_name, zip_code, phone_number, website_url)
VALUES (2, 2, 2, 'Enemy of Bobby Brewery', 'Have a drink while youre laughing at people sitting on the beach! Dont visit Bob. Boo.', '742 Evergreen Terrace', '19350', '900-649-2568', 'ANOTHER PLACEHOLDER URL');    
INSERT INTO brewery (brewery_id, beer_id, review_id, brewery_name, description, street_name, zip_code, phone_number, website_url)
VALUES (3, 3, 3, 'The Brewhouse', 'Come enjoy a taste with the Brewsters.', '4 Privet Drive', '84604', '800-588-2300', 'YET ANOTHER PLACEHOLDER URL');       

INSERT INTO brewery_hours (day_id, day_name, brewery_id, opening_time, closing_time)
VALUES (1, 'Friday', 1, '3:00PM', '11:00PM');
INSERT INTO brewery_hours (day_id, day_name, brewery_id, opening_time, closing_time)
VALUES (2, 'Thursday', 1, '2:00PM', '11:00PM');
INSERT INTO brewery_hours (day_id, day_name, brewery_id, opening_time, closing_time)
VALUES (3, 'Friday', 2, '6:00PM', '8:00PM');

INSERT INTO brewery_specialty_beers (brewery_id, beer_id)
VALUES (1, 2);
INSERT INTO brewery_specialty_beers (brewery_id, beer_id)
VALUES (1, 3);
INSERT INTO brewery_specialty_beers (brewery_id, beer_id)
VALUES (2, 1);
INSERT INTO brewery_specialty_beers (brewery_id, beer_id)
VALUES (2, 3);

COMMIT TRANSACTION;
