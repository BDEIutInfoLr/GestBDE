-- ============================================================================
-- Fichier : jeuDeTest1.sql
-- Auteur  : Steeve SINIGAGLIA
-- Date    : 11/09/2014
-- Role    : Insertion de n-uplets dans la base de donnees "GestBDE"
-- ============================================================================

-- ============================================================================
-- Nettoyage des Tables                             
-- ============================================================================

DELETE FROM ADMIN;
DELETE FROM ELEVE;
DELETE FROM PRODUIT;
DELETE FROM VENTE;
DELETE FROM DETAIL_VENTE;
DELETE FROM DETTE;

-- ============================================================================
-- Insertion dans la Table ADMIN                             
-- ============================================================================
insert into ADMIN(LOGIN, MDP) 
values ('bdeinfo', 'bdeinfo');
-- ============================================================================
-- Insertion dans la Table ELEVE                             
-- ============================================================================
insert into ELEVE(ID_ELEVE, NOM, PRENOM)
values (1,'Acquier', 'Nicolas');

insert into ELEVE(ID_ELEVE, NOM, PRENOM)
values (2,'Queiros', 'Antoine');

insert into ELEVE(ID_ELEVE, NOM, PRENOM)
values (3,'Sinigaglia', 'Steeve');

-- ============================================================================
-- Insertion dans la Table PRODUIT                              
-- ============================================================================

--BOISSON 1 : STOCK OK
insert into PRODUIT(ID_PRODUIT, NOM_PRODUIT, PRIX_VENTE, PRIX_ACHAT, CATEGORIE, STOCK)
values (1, 'Coca-Cola', 0.60, 0.42, 'BOISSON', 50);

--BOISSON 2 : STOCK OK
insert into PRODUIT(ID_PRODUIT, NOM_PRODUIT, PRIX_VENTE, PRIX_ACHAT, CATEGORIE, STOCK)
values (2, 'Orangina',  0.60, 0.42, 'BOISSON', 100);

--BOISSON 3 : STOCK NUL
insert into PRODUIT(ID_PRODUIT, NOM_PRODUIT, PRIX_VENTE, PRIX_ACHAT, CATEGORIE, STOCK)
values (3, 'Oasis', 0.60, 0.42, 'BOISSON', 0);

--BOISSON 4 : STOCK = 1
insert into PRODUIT(ID_PRODUIT, NOM_PRODUIT, PRIX_VENTE, PRIX_ACHAT, CATEGORIE, STOCK)
values (7, 'MinuteMaid', 0.60, 0.42, 'BOISSON', 1);


--CONFISERIE 1 : STOCK OK
insert into PRODUIT(ID_PRODUIT, NOM_PRODUIT, PRIX_VENTE, PRIX_ACHAT, CATEGORIE, STOCK)
values (4, 'Bueno white', 0.50, 0.58, 'CONFISERIE', 50);

--CONFISERIE 2 : STOCK OK
insert into PRODUIT(ID_PRODUIT, NOM_PRODUIT, PRIX_VENTE, PRIX_ACHAT, CATEGORIE, STOCK)
values (5, 'Lion', 0.50, 0.42, 'CONFISERIE', 50);

--CONFISERIE 3 : STOCK NUL
insert into PRODUIT(ID_PRODUIT, NOM_PRODUIT, PRIX_VENTE, PRIX_ACHAT, CATEGORIE, STOCK)
values (6, 'Mars', 0.60, 0.42, 'CONFISERIE', 0);

-- CONFISERIE 4 : STOCK = 1
insert into PRODUIT(ID_PRODUIT, NOM_PRODUIT, PRIX_VENTE, PRIX_ACHAT, CATEGORIE, STOCK)
values (8, 'Bounty', 0.60, 0.42, 'CONFISERIE', 1);


-- ============================================================================
-- Insertion dans la Table VENTE                          
-- ============================================================================

insert into VENTE(ID_VENTE, DATE_VENTE, MONTANT)
values (1, '11/09/2014', 1.5);

insert into VENTE(ID_VENTE, DATE_VENTE, MONTANT)
values (2, '11/09/2014', 1);

insert into VENTE(ID_VENTE, DATE_VENTE, MONTANT)
values (3, '11/09/2014', 0.5);

insert into VENTE(ID_VENTE, DATE_VENTE, MONTANT)
values (4, '11/09/2014', 0.6);

-- ============================================================================
-- Insertion dans la Table DETAIL_VENTE                          
-- ============================================================================

-- une vente1 composé d'un coca + bueno + lion
insert into DETAIL_VENTE(ID_DETAIL_VENTE, ID_VENTE, ID_PRODUIT)
values (1, 1, 1);
 
insert into DETAIL_VENTE(ID_DETAIL_VENTE, ID_VENTE, ID_PRODUIT)
values (2, 1, 4);

insert into DETAIL_VENTE(ID_DETAIL_VENTE, ID_VENTE, ID_PRODUIT)
values (3, 1, 5);

-- une vente2 composé d'un coca + bueno
insert into DETAIL_VENTE(ID_DETAIL_VENTE, ID_VENTE, ID_PRODUIT)
values (4, 2, 1);

insert into DETAIL_VENTE(ID_DETAIL_VENTE, ID_VENTE, ID_PRODUIT)
values (5, 2, 4);

-- une vente 3 composé d'un bounty (du coup bounty après vente =0)
insert into DETAIL_VENTE(ID_DETAIL_VENTE, ID_VENTE, ID_PRODUIT)
values (6, 3, 8);

-- une vente 4 composé d'un minutemaid (du coup stock minuteMaid = 0 après vente)
insert into DETAIL_VENTE(ID_DETAIL_VENTE, ID_VENTE, ID_PRODUIT)
values (7, 4, 7);

-- ============================================================================
-- Insertion dans la Table DETTE                     
-- ============================================================================
insert into DETTE(ID_ELEVE_DETTE, ID_VENTE, CREANCE)
values (1, 1, 1.5);

UPDATE DETTE
SET CREANCE = CREANCE+2.5
WHERE ID_ELEVE_DETTE = 1;


insert into DETTE(ID_ELEVE_DETTE, ID_VENTE, CREANCE)
values (3, 3, 0.5);


