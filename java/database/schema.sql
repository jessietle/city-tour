BEGIN TRANSACTION;

DROP TABLE IF EXISTS users;

DROP TABLE IF EXISTS attractions;
DROP TABLE IF EXISTS hour_day;
DROP TABLE IF EXISTS itinerary;
DROP TABLE IF EXISTS itinerary_attraction;
DROP TABLE IF EXISTS review;

CREATE TABLE users (
	user_id SERIAL,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

CREATE SEQUENCE seq_id
  INCREMENT BY 1
  START WITH 1001
  NO MAXVALUE;

CREATE TABLE attractions (
    id SERIAL,
    name varchar(100) NOT NULL,
    address varchar ( 100000) NOT NULL,
    description varchar (100000) NOT NULL,
    image varchar (100000),
    rate int,
    type varchar (100000) NOT NULL,
	 CONSTRAINT PK_attractions PRIMARY KEY (id)
);




CREATE TABLE hour_day(
    attraction_id int NOT NULL,
    mon_open varchar (100) NOT NUll,
    mon_close varchar (100) NOT NUll,
    tues_open varchar (100) NOT NUll,
    tues_close varchar (100) NOT NUll,
    wed_open varchar (100) NOT NUll,
    wed_close varchar (100) NOT NUll,
    thurs_open varchar (100) NOT NUll,
    thurs_close varchar (100) NOT NUll,
    fri_open varchar (100) NOT NUll,
    fri_close varchar (100) NOT NUll,
    sat_open varchar (100) NOT NUll,
    sat_close varchar (100) NOT NUll,
    sun_open varchar (100) NOT NUll,
    sun_close varchar (100) NOT NUll,
    CONSTRAINT FK_hour_day_attractions_id  FOREIGN KEY ( attraction_id) REFERENCES attractions(id)
);

CREATE SEQUENCE seq_itinerary_id
  INCREMENT BY 1
  START WITH 2001
  NO MAXVALUE;


CREATE TABLE itinerary (
    itinerary_id SERIAL,
    starting_point int,
    date_of_itinerary varchar (15) NOT NULL,
    user_id int NOT NULL,
    itinerary_name varchar (10000) NOT NULL,
    CONSTRAINT PK_itinerary PRIMARY KEY (itinerary_id),
    CONSTRAINT FK_itinerary_user_id FOREIGN KEY (user_id) REFERENCES users(user_id)

);

CREATE TABLE itinerary_attraction(
    itinerary_id int NOT NULL,
    attraction_id int NOT NULL,
    CONSTRAINT FK_itinerary_attraction_attraction_id  FOREIGN KEY (attraction_id) REFERENCES attractions(id),
    CONSTRAINT FK_itinerary_attraction_itinerary_id FOREIGN KEY (itinerary_id) REFERENCES itinerary(itinerary_id)
);

CREATE TABLE review(
    review_id SERIAL,
    attraction_id int NOT NULL,
    review_note varchar(1000) NOT NULL,
    CONSTRAINT FK_review_attractions_id  FOREIGN KEY ( attraction_id) REFERENCES attractions(id)

);

COMMIT TRANSACTION;
