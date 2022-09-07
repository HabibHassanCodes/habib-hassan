BEGIN TRANSACTION;
DROP TABLE IF EXISTS users, brewery, brewery_hours, beer, reviews, brewery_speciality_beers, brewery_specialty_beers CASCADE;

CREATE TABLE users (
	user_id SERIAL,
	username varchar(50) NOT NULL UNIQUE,
	brewery_id int,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

CREATE TABLE reviews (
        review_id serial,
        beer_id int NOT NULL,
        review_text varchar(1000) NOT NULL,
        star_rating int NOT NULL,
        CONSTRAINT PK_reviews PRIMARY KEY (review_id)
);
<<<<<<< HEAD

=======
>>>>>>> b2718dca88629461708d91fb16cfe82c93bca82f
CREATE TABLE brewery (
	brewery_id serial,
	review_id int,
	brewery_name varchar(50) NOT NULL,
	description varchar(1000) NOT NULL,
	street_name varchar(75) NOT NULL,
	zip_code varchar(75) NOT NULL,
	phone_number varchar(12) NOT NULL,
	website_url varchar(100) NOT NULL,
	CONSTRAINT PK_brewery PRIMARY KEY (brewery_id),
	CONSTRAINT FK_brewery_reviews FOREIGN KEY (review_id) REFERENCES reviews(review_id)
);
CREATE TABLE beer (
        beer_id serial,
        brewery_id int,
        beer_name varchar(50) NOT NULL,
        review_id int,
        description varchar(1000) NOT NULL,
        beer_prices int NOT NULL,
        beer_type varchar(20) NOT NULL,
        CONSTRAINT PK_beer PRIMARY KEY (beer_id),
        CONSTRAINT FK_beer_brewery FOREIGN KEY (brewery_id) REFERENCES brewery(brewery_id),
        CONSTRAINT FK_beer_reviews FOREIGN KEY (review_id) REFERENCES reviews(review_id)
);
CREATE TABLE brewery_hours (
	day_id serial,
	day_name varchar(20) NOT NULL,
	brewery_id int NOT NULL,
	opening_time varchar(20) NOT NULL,
	closing_time varchar(20) NOT NULL,
	CONSTRAINT PK_brewery_hours PRIMARY KEY (day_id),
	CONSTRAINT FK_brewery_hours_brewery FOREIGN KEY (brewery_id) REFERENCES brewery(brewery_id)
);
CREATE TABLE brewery_specialty_beers (
	brewery_id int NOT NULL,
	beer_id int NOT NULL,
	CONSTRAINT PK_brewery_specialty_beers PRIMARY KEY (brewery_id, beer_id),
	CONSTRAINT FK_brewery_specialty_beers_brewery FOREIGN KEY (brewery_id) REFERENCES brewery(brewery_id),
	CONSTRAINT FK_brewery_specialty_beers_beer FOREIGN KEY (beer_id) REFERENCES beer(beer_id)
);
INSERT INTO reviews (beer_id, review_text, star_rating)
VALUES (1, 'This place is poppin!', 5);
INSERT INTO reviews (beer_id, review_text, star_rating)
VALUES (1, 'Meh.. was not the funnest thing but not bad', 3);
INSERT INTO reviews (beer_id, review_text, star_rating)
VALUES (2, 'Why does this make me feel funny?', 1);

INSERT INTO reviews (beer_id, review_text, star_rating)
VALUES (3, 'This brewery provided exquisite flavors and an exquisite view.', 5);
INSERT INTO brewery (review_id, brewery_name, description, street_name, zip_code, phone_number, website_url)
VALUES (1, 'Bobby Brewery', 'Enjoy a drink on the beach!', 'P Sherman 42 Wallaby Way', '76108', '678-999-8212', 'PLACEHOLDER URL');
INSERT INTO brewery ( review_id, brewery_name, description, street_name, zip_code, phone_number, website_url)
VALUES (2, 'Enemy of Bobby Brewery', 'Have a drink while youre laughing at people sitting on the beach! Dont visit Bob. Boo.', '742 Evergreen Terrace', '19350', '900-649-2568', 'ANOTHER PLACEHOLDER URL');
INSERT INTO brewery (review_id, brewery_name, description, street_name, zip_code, phone_number, website_url)
VALUES (3, 'The Brewhouse', 'Come enjoy a taste with the Brewsters.', '4 Privet Drive', '84604', '800-588-2300', 'YET ANOTHER PLACEHOLDER URL');


INSERT INTO beer (brewery_id,beer_name, description, beer_prices, beer_type)
VALUES (1,'Bud Light', 'A drink that makes you feel funny', 8, 'Malt');
INSERT INTO beer (brewery_id,beer_name, description, beer_prices, beer_type)
VALUES (2,'Corona', 'A drink to satisfy a thirst.', 6, 'Hop');
INSERT INTO beer (brewery_id,beer_name, description, beer_prices, beer_type)
VALUES (3,'Sam Adams', 'Something to drink up. Yum yum!', 7, 'IPA');


INSERT INTO brewery_hours ( day_name, brewery_id, opening_time, closing_time)
VALUES ('Friday', 1, '3:00PM', '11:00PM');
INSERT INTO brewery_hours ( day_name, brewery_id, opening_time, closing_time)
VALUES ('Thursday', 1, '2:00PM', '11:00PM');
INSERT INTO brewery_hours ( day_name, brewery_id, opening_time, closing_time)
VALUES ('Friday', 2, '6:00PM', '8:00PM');

INSERT INTO brewery_specialty_beers (brewery_id, beer_id)
VALUES (1, 2);
INSERT INTO brewery_specialty_beers (brewery_id, beer_id)
VALUES (1, 3);
INSERT INTO brewery_specialty_beers (brewery_id, beer_id)
VALUES (2, 1);
INSERT INTO brewery_specialty_beers (brewery_id, beer_id)
VALUES (2, 3);

INSERT INTO users (username,password_hash,role) 
VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) 
VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');
INSERT INTO users (username, brewery_id, password_hash,role) 
VALUES ('brewer', 1,'$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_BREWER');

INSERT INTO reviews (beer_id, review_text, star_rating)
VALUES (1, 'This place is poppin!', 5);
INSERT INTO reviews (beer_id, review_text, star_rating)
VALUES (1, 'Meh.. was not the funnest thing but not bad', 3);
INSERT INTO reviews (beer_id, review_text, star_rating)
VALUES (2, 'Why does this make me feel funny?', 1);
INSERT INTO reviews (beer_id, review_text, star_rating)
VALUES (3, 'This brewery provided exquisite flavors and an exquisite view.', 5);

INSERT INTO brewery (review_id, brewery_name, description, street_name, zip_code, phone_number, website_url)
VALUES (1, 'Bobby Brewery', 'Enjoy a drink on the beach!', 'P Sherman 42 Wallaby Way', '76108', '678-999-8212', 'PLACEHOLDER URL');
INSERT INTO brewery ( review_id, brewery_name, description, street_name, zip_code, phone_number, website_url)
VALUES (2, 'Enemy of Bobby Brewery', 'Have a drink while youre laughing at people sitting on the beach! Dont visit Bob. Boo.', '742 Evergreen Terrace', '19350', '900-649-2568', 'ANOTHER PLACEHOLDER URL');
INSERT INTO brewery (review_id, brewery_name, description, street_name, zip_code, phone_number, website_url)
VALUES (3, 'The Brewhouse', 'Come enjoy a taste with the Brewsters.', '4 Privet Drive', '84604', '800-588-2300', 'YET ANOTHER PLACEHOLDER URL');

INSERT INTO beer (brewery_id,beer_name, description, beer_prices, beer_type)
VALUES (1,'Bud Light', 'A drink that makes you feel funny', 8, 'Malt');
INSERT INTO beer (brewery_id,beer_name, description, beer_prices, beer_type)
VALUES (2,'Corona', 'A drink to satisfy a thirst.', 6, 'Hop');
INSERT INTO beer (brewery_id,beer_name, description, beer_prices, beer_type)
VALUES (3,'Sam Adams', 'Something to drink up. Yum yum!', 7, 'IPA');

INSERT INTO brewery_hours ( day_name, brewery_id, opening_time, closing_time)
VALUES ('Friday', 1, '3:00PM', '11:00PM');
INSERT INTO brewery_hours ( day_name, brewery_id, opening_time, closing_time)
VALUES ('Thursday', 1, '2:00PM', '11:00PM');
INSERT INTO brewery_hours ( day_name, brewery_id, opening_time, closing_time)
VALUES ('Friday', 2, '6:00PM', '8:00PM');

INSERT INTO brewery_specialty_beers (brewery_id, beer_id)
VALUES (1, 2);
INSERT INTO brewery_specialty_beers (brewery_id, beer_id)
VALUES (1, 3);
INSERT INTO brewery_specialty_beers (brewery_id, beer_id)
VALUES (2, 1);
INSERT INTO brewery_specialty_beers (brewery_id, beer_id)
VALUES (2, 3);

INSERT INTO users (username,password_hash,role)
VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role)
VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');
INSERT INTO users (username, brewery_id, password_hash,role)
VALUES ('brewer', 1,'$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_BREWER');

COMMIT;
