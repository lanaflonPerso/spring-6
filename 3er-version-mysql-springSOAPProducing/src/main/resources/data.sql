insert into client (nom, prenom, carte_credit) values ('dahdouh', 'karim', '107777839843'), ('darry', 'theirno', '788894334234');


insert into adresse (numero, pays, positiongps, rue, vile) values ('112', 'France', '43.607505, 3.883095', 'rue comédie', 'Paris'), ('45', 'France', '18.443534, 4.654765', 'rue luxemburng', 'lyon');



insert into hotel (nom, nombre_etoiles, nombre_lits, address_id) values ('Hotel A', 5, 90, 2), ('Hotel B', 4, 80, 12);

insert into chambre (disponible, numero, prix, type_lit, hotel_id) values ('yes', 75, 66.99, 'lit simple', 42), ('yes', 37, 90.50, 'lit double', 42), ('no', 20, 84.00, 'lit double', 42), ('no', 54, 40.99, 'lit simple', 52), ('yes', 54, 40.00, 'lit simple', 52), ('ye', 20, 84.00, 'lit double', 52);


insert into agence_voyage (login, password, nom, tarif) values ('karim', 'dahdouh', 'lundi au soleil', 7.50), ('takeyourbreath', 'thekr43', 'take you breath', 5.40);


