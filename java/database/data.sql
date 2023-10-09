BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');


INSERT INTO attractions (name, address, description, image, type)
VALUES ('National Gallery of Art ', 'Constitution Ave. NW, Washington, DC 20565 ',
'The National Gallery of Art, and its attached Sculpture Garden, is a national art museum in Washington, D.C., United States, located on the National Mall, between 3rd and 9th Streets, at Constitution Avenue NW.',
'https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcQEzfvN0a5h2kRsyhpJSIw9eSqB13fYogK3dBN0hZNikc17k-1q', 'Museum'),

('Smithsonian National Museum of Natural History', '10th St. & Constitution Ave. NW, Washington, DC 20560', 'The National Museum of Natural History is a natural history museum administered by the Smithsonian Institution, located on the National Mall in Washington, D.C., United States. It has free admission and is open 364 days a year. In 2022, with 3.9 million visitors, it was the most-visited museum in the United States.',
 'https://t1.gstatic.com/images?q=tbn:ANd9GcRc1umdEPTXUzw3bKF4m4ZJgLmxGC7zKz__UcPtKBdM1uebBj0i', 'Museum'),

 ('National Air and Space Museum', '600 Independence Ave SW, Washington, DC 20560', 'The National Air and Space Museum of the Smithsonian Institution, is a museum in Washington, D.C., in the United States dedicated to human flight and space exploration. Established in 1946 as the National Air Museum, its main building opened on the National Mall near L''Enfant Plaza in 1976.',
 'https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcRM7rHKDn4KhbnAfv2otT-knCvYfzqfSA8GdO5eWkSMHRbdWS0z', 'Museum'),

('United States Holocaust Memorial Museum', '100 Raoul Wallenberg Pl SW, Washington, DC 20024', 'The United States Holocaust Memorial Museum is the United States'' official memorial to the Holocaust. Adjacent to the National Mall in Washington, D.C., the USHMM provides for the documentation, study, and interpretation of Holocaust history.',
 'https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcTYd6QSJ3mz8QUely6JXDS1FJEHHsPlW0oYxYqGne2BJ6tQMmY2', 'Museum'),

('National Museum of African American History and Culture', '1400 Constitution Ave. NW, Washington, DC 20560', 'The National Museum of African American History and Culture, colloquially known as the Blacksonian, is a Smithsonian Institution museum located on the National Mall in Washington, D.C., in the United States. It was established in 2003 and opened its permanent home in 2016 with a ceremony led by President Barack Obama.',
 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSrySwROCfPjhp5RHlPBRv_bii5VFNbfOFYT37tSh29cb-uu3dd', 'Museum'),

('National Portrait Gallery', '8th St NW & G St NW, Washington, DC 20001', 'The National Portrait Gallery is a historic art museum between 7th, 9th, F, and G Streets NW in Washington, D.C., in the United States. Founded in 1962 and opened to the public in 1968, it is part of the Smithsonian Institution. Its collections focus on images of famous Americans.',
'https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcSSkzqH4yxcf8qCg1T_18p6MNopz0hG_S6IqDQcx0_oWnq6T633', 'Museum'),

('The National Archives Museum', '701 Constitution Ave. NW, Washington, DC 20408', 'The museum wing of the National Archives, the National Archives Museum is the home of the Declaration of Independence, Constitution, and Bill of Rights.',
 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTBXhuaTmuNZEv5x2ESA95pkGIGpURA2Z0XVKpmg6sm_HzhhMML', 'Museum'),

('International Spy Museum', ' 700 L''Enfant Plaza SW, Washington, DC 20024', 'The International Spy Museum is an independent non-profit history museum which documents the tradecraft, history, and contemporary role of espionage. It holds the largest collection of international espionage artifacts on public display.',
 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQYW1-K48mazzSpQLGg4Il24GrP0wx8M0tAceMwZioiR_REyfUW', 'Museum'),

('Amerigo Vespucci Memorial', '1756-1700 C St NW, Washington, DC 20006', 'Statue of Amerigo Vespucci - an Italian explorer from whose name the term America is derived',
 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSgx7N4GI9aYymYf8ku8kOqATkoOmgYzwzZBI4DSDX7w-oxxizd', 'Monument'),

('Jefferson Memorial', '16 E Basin Dr SW, Washington, DC 20242', 'The Jefferson Memorial is a presidential memorial built in Washington, D.C., between 1939 and 1943 in honor of Thomas Jefferson, the principal author of the United States Declaration of Independence.',
 'https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcRNMxhs60y1ruXngKYKz86lBIQLKGKuWuS3LqfpP2tLP0NLpv2I', 'Monument'),

('Korean War Memorial', '900 Ohio Dr SW, Washington, DC 20024', 'The Korean War Veterans Memorial is located in Washington, D.C.''s West Potomac Park, southeast of the Lincoln Memorial and just south of the Reflecting Pool on the National Mall. It memorializes those who served in the Korean War. The national memorial was dedicated in 1995',
 'https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcRiMT0mGIad1ogUkyiaKyxAqvs9TsHBuZQG1zY0wVwhmXpYDbBT', 'Monument'),


 ('Lincoln Memorial', ' 2 Lincoln Memorial Circle, NW, Washington, D.C.', ' The Lincoln Memorial is a U.S. national memorial that honors the 16th president of the United States, Abraham Lincoln. Built in the form of a neoclassical temple, it is at the western end of the National Mall in Washington, D.C.',
 'https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcQkzdE2NsfeeWauMDPkOAEj02_-5MnCAqDBmC1yvsXMgpRAxYwW', 'Monument'),


('Martin Luther King Jr. Memorial', '1964 Independence Ave SW, Washington, DC 20004', 'The Martin Luther King, Jr. Memorial is a national memorial located in West Potomac Park next to the National Mall in Washington, D.C., United States. It covers four acres and includes the Stone of Hope, a granite statue of Civil Rights Movement leader Martin Luther King Jr. carved by sculptor Lei Yixin. ',
 'https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcQz7_sbCkgOI3i6rkhhG6b3Cv_ccUpDRu0uIeOYsZjo2-2TiCnM', 'Monument'),


 ('Titanic Memorial', '41 1st Ave, Southwest Washington, DC 20319', 'Memorial for those who risked their lives to save those on the Titanic.',
 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTtZCvJbQ9gZMkzwSfvwSNQUzKqwO_on-t_kgkq2MAKZLM-RSi4', 'Monument'),


('Tomb of the Unknown Soldier', '1 Wilson Ave, Fort Myer, VA 22211', 'Prominent marble monument in Arlington National Cemetery marking an unknown WWI solider''s grave.',
 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQtzdzsKor8W-0hGcueJKqrAAIaJJ5lXp5CeUFI0hzJDo3KJ3ma', 'Monument'),

 ('Vietnam Veterans Memorial', '5 Henry Bacon Dr NW, Washington, DC 20002', 'Monument to Vietnam War service, featuring a wall with over 58,000 names of dead & missing soldiers.',
 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ-zS5CVi53IHHXVrdqvk4Hm98nfyvG9QQOvAtQiB7AHeizxBwA', 'Monument'),

('Washington Monument', '2 15th St NW, Washington, DC 20024', ' Landmark obelisk rising from the National Mall that honors America''s first president.',
 'https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcTmRIP-Bb-iwRiCiS0iLTop2ewVqEVN5ev0ZBlv17jDW_zAXwxR', 'Monument'),

('World War II Memorial', '1750 Independence Ave SW, Washington, DC 20024', 'Iconic outdoor memorial honoring the 16 million Americans who served during World War II.',
 'https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcRWMwnHRD2fIR7wRaEUEGhtv57N9G9JHbHDq29fXUE85n0Uz9ts', 'Monument');


INSERT INTO hour_day (attraction_id, mon_open, tues_open, wed_open, thurs_open, fri_open, sat_open, sun_open, mon_close, tues_close, wed_close, thurs_close, fri_close, sat_close, sun_close )
VALUES
(1,
'10:00 AM','10:00 AM','10:00 AM','10:00 AM','10:00 AM','10:00 AM','10:00 AM',
'5:00 PM', '5:00 PM','5:00 PM','5:00 PM','5:00 PM','5:00 PM','5:00 PM' ),

(2,
'10:00 AM',	'10:00 AM',	'10:00 AM',	'10:00 AM',	'10:00 AM',	'10:00 AM',	'10:00 AM',
'5:30 PM',	'5:30 PM',	'5:30 PM',	'5:30 PM',	'5:30 PM',	'5:30 PM',	'5:30 PM'),

(3,
'10:00 AM',	'10:00 AM',	'10:00 AM',	'10:00 AM',	'10:00 AM',	'10:00 AM',	'10:00 AM',
'5:30 PM',	'5:30 PM',	'5:30 PM',	'5:30 PM',	'5:30 PM',	'5:30 PM',	'5:30 PM'),

(4,
'10:00 AM',	'10:00 AM',	'10:00 AM',	'10:00 AM',	'10:00 AM',	'10:00 AM',	'10:00 AM',
'5:30 PM',	'5:30 PM',	'5:30 PM',	'5:30 PM',	'5:30 PM',	'5:30 PM',	'5:30 PM'),

(5,
'12:00 PM',	'10:00 AM',	'10:00 AM',	'10:00 AM',	'10:00 AM',	'10:00 AM',	'10:00 AM',
'5:30 PM',	'5:30 PM',	'5:30 PM',	'5:30 PM',	'5:30 PM',	'5:30 PM',	'5:30 PM'),

(6,
'11:30 AM','11:30 AM',	'11:30 AM',	'11:30 AM',	'11:30 AM',	'11:30 AM',	'11:30 AM',
'7:00 PM',	'7:00 PM', '7:00 PM',	'7:00 PM',	'7:00 PM',	'7:00 PM',	'7:00 PM' ),


(7,
'10:00 AM',	'10:00 AM',	'10:00 AM',	'10:00 AM',	'10:00 AM',	'10:00 AM',	'10:00 AM',
'5:30 PM',	'5:30 PM',	'5:30 PM',	'5:30 PM',	'5:30 PM',	'5:30 PM',	'5:30 PM' ),


(8,
'10:00 AM',	'10:00 AM',	'10:00 AM',	'10:00 AM',	'10:00 AM',	'9:00 AM',	'9:00 AM',
'6:00 PM',	'6:00 PM',	'6:00 PM',	'6:00 PM',	'6:00 PM',	'7:00 PM',	'6:00 PM'),


(9,
'OPEN 24 HOURS','OPEN 24 HOURS','OPEN 24 HOURS','OPEN 24 HOURS','OPEN 24 HOURS','OPEN 24 HOURS','OPEN 24 HOURS',
'OPEN 24 HOURS','OPEN 24 HOURS','OPEN 24 HOURS','OPEN 24 HOURS','OPEN 24 HOURS','OPEN 24 HOURS','OPEN 24 HOURS'),


(10,
'OPEN 24 HOURS','OPEN 24 HOURS','OPEN 24 HOURS','OPEN 24 HOURS','OPEN 24 HOURS','OPEN 24 HOURS','OPEN 24 HOURS',
'OPEN 24 HOURS','OPEN 24 HOURS','OPEN 24 HOURS','OPEN 24 HOURS','OPEN 24 HOURS','OPEN 24 HOURS','OPEN 24 HOURS'),

(11,
'OPEN 24 HOURS','OPEN 24 HOURS','OPEN 24 HOURS','OPEN 24 HOURS','OPEN 24 HOURS','OPEN 24 HOURS','OPEN 24 HOURS',
'OPEN 24 HOURS','OPEN 24 HOURS','OPEN 24 HOURS','OPEN 24 HOURS','OPEN 24 HOURS','OPEN 24 HOURS','OPEN 24 HOURS'),


(12,
'OPEN 24 HOURS','OPEN 24 HOURS','OPEN 24 HOURS','OPEN 24 HOURS','OPEN 24 HOURS','OPEN 24 HOURS','OPEN 24 HOURS',
'OPEN 24 HOURS','OPEN 24 HOURS','OPEN 24 HOURS','OPEN 24 HOURS','OPEN 24 HOURS','OPEN 24 HOURS','OPEN 24 HOURS'),


(13,
'OPEN 24 HOURS','OPEN 24 HOURS','OPEN 24 HOURS','OPEN 24 HOURS','OPEN 24 HOURS','OPEN 24 HOURS','OPEN 24 HOURS',
'OPEN 24 HOURS','OPEN 24 HOURS','OPEN 24 HOURS','OPEN 24 HOURS','OPEN 24 HOURS','OPEN 24 HOURS','OPEN 24 HOURS'),


(14,
'OPEN 24 HOURS','OPEN 24 HOURS','OPEN 24 HOURS','OPEN 24 HOURS','OPEN 24 HOURS','OPEN 24 HOURS','OPEN 24 HOURS',
'OPEN 24 HOURS','OPEN 24 HOURS','OPEN 24 HOURS','OPEN 24 HOURS','OPEN 24 HOURS','OPEN 24 HOURS','OPEN 24 HOURS'),


(15,
'8:00 AM', '8:00 AM', '8:00 AM', '8:00 AM', '8:00 AM', '8:00 AM', '8:00 AM',
'5:00 PM', '5:00 PM', '5:00 PM', '5:00 PM', '5:00 PM', '5:00 PM', '5:00 PM'),


(16,
'OPEN 24 HOURS','OPEN 24 HOURS','OPEN 24 HOURS','OPEN 24 HOURS','OPEN 24 HOURS','OPEN 24 HOURS','OPEN 24 HOURS',
'OPEN 24 HOURS','OPEN 24 HOURS','OPEN 24 HOURS','OPEN 24 HOURS','OPEN 24 HOURS','OPEN 24 HOURS','OPEN 24 HOURS'),


(17,
'9:00 AM', '9:00 AM', '9:00 AM', '9:00 AM', '9:00 AM', '9:00 AM', '9:00 AM',
'5:00 PM', '5:00 PM', '5:00 PM', '5:00 PM', '5:00 PM', '5:00 PM', '5:00 PM'),


(18,
'OPEN 24 HOURS','OPEN 24 HOURS','OPEN 24 HOURS','OPEN 24 HOURS','OPEN 24 HOURS','OPEN 24 HOURS','OPEN 24 HOURS',
'OPEN 24 HOURS','OPEN 24 HOURS','OPEN 24 HOURS','OPEN 24 HOURS','OPEN 24 HOURS','OPEN 24 HOURS','OPEN 24 HOURS');


INSERT INTO review(attraction_id,review_note)
VALUES (1,'As I love arts, I really enjoyed this visit. It has two wings and both with are entertaining. You can go from one wing to another either from outside or indoor ( there’s like a tunnel that connects the two) please see pic.. there’s shop for souvenirs and snack outlet. They also have an interactive drawing area to show your skills which is fun.'),
(1,'An outstanding display of art, this gallery is a must visit for those visiting Washington DC. Very well organised, ideally one needs a full day to do justice to this venue.'),
(2,'A museum filled with lots of information from all sorts of categories where life evolves and it’s existence. The museum delivers information either thru reading or visual presentation. One particular show was the evolution of technology were I found a lot of stuffs that I had used when I was a kid to teen to young adulthood. It just bring me lots of great memories. The museum also have shops inside. There are clean toilets. It’s only open until half 5.'),
(2,'Lots of interesting exhibits, air con throughout the building was a great plus after walking around Washington  National Mall on a very hot day. This was our second visit here but it was just as interesting as our first visit in 2002'),
(3,'Lots to see!! Loved the Wright Brothers exhibit and the space experience. Even with a portion of the museum closed for renovation, still plenty to take in and enjoy! Highly recommended!!'),
(3,'Very informative- lots of updates from last visit. Lots of good gift options. Appropriate for all ages.');

COMMIT TRANSACTION;
