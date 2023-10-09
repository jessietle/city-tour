BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role) VALUES ('user1','user1','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('user2','user2','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('user3','user3','ROLE_USER');

INSERT INTO attractions (name, address, description, image, type)
VALUES ('National Gallery of Art', 'Constitution Ave. NW, Washington, DC 20565',
'The National Gallery of Art, and its attached Sculpture Garden, is a national art museum in Washington, D.C., United States, located on the National Mall, between 3rd and 9th Streets, at Constitution Avenue NW.',
'https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcQEzfvN0a5h2kRsyhpJSIw9eSqB13fYogK3dBN0hZNikc17k-1q', 'Museum'),

('Smithsonian National Museum of Natural History', '10th St. & Constitution Ave. NW, Washington, DC 20560', 'The National Museum of Natural History is a natural history museum administered by the Smithsonian Institution, located on the National Mall in Washington, D.C., United States. It has free admission and is open 364 days a year. In 2022, with 3.9 million visitors, it was the most-visited museum in the United States.',
 'https://t1.gstatic.com/images?q=tbn:ANd9GcRc1umdEPTXUzw3bKF4m4ZJgLmxGC7zKz__UcPtKBdM1uebBj0i', 'Museum'),

 ('National Air and Space Museum', '600 Independence Ave SW, Washington, DC 20560', 'The National Air and Space Museum of the Smithsonian Institution, is a museum in Washington, D.C., in the United States dedicated to human flight and space exploration. Established in 1946 as the National Air Museum, its main building opened on the National Mall near L''Enfant Plaza in 1976.',
 'https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcRM7rHKDn4KhbnAfv2otT-knCvYfzqfSA8GdO5eWkSMHRbdWS0z', 'Museum'),

('United States Holocaust Memorial Museum', '100 Raoul Wallenberg Pl SW, Washington, DC 20024', 'The United States Holocaust Memorial Museum is the United States'' official memorial to the Holocaust. Adjacent to the National Mall in Washington, D.C., the USHMM provides for the documentation, study, and interpretation of Holocaust history.',
 'https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcTYd6QSJ3mz8QUely6JXDS1FJEHHsPlW0oYxYqGne2BJ6tQMmY2', 'Museum'),

 ('Jefferson Memorial', '16 E Basin Dr SW, Washington, DC 20242', 'The Jefferson Memorial is a presidential memorial built in Washington, D.C., between 1939 and 1943 in honor of Thomas Jefferson, the principal author of the United States Declaration of Independence.',
  'https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcRNMxhs60y1ruXngKYKz86lBIQLKGKuWuS3LqfpP2tLP0NLpv2I', 'Monument'),

 ('Korean War Memorial', '900 Ohio Dr SW, Washington, DC 20024', 'The Korean War Veterans Memorial is located in Washington, D.C.''s West Potomac Park, southeast of the Lincoln Memorial and just south of the Reflecting Pool on the National Mall. It memorializes those who served in the Korean War. The national memorial was dedicated in 1995',
  'https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcRiMT0mGIad1ogUkyiaKyxAqvs9TsHBuZQG1zY0wVwhmXpYDbBT', 'Monument');

COMMIT TRANSACTION;
