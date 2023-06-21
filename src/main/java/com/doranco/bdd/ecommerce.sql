-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : mer. 21 juin 2023 à 16:51
-- Version du serveur : 10.4.27-MariaDB
-- Version de PHP : 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `ecommerce`
--

-- --------------------------------------------------------

--
-- Structure de la table `adresse`
--

CREATE TABLE `adresse` (
  `id` int(11) NOT NULL,
  `numero` varchar(10) DEFAULT NULL,
  `rue` varchar(100) DEFAULT NULL,
  `ville` varchar(50) DEFAULT NULL,
  `codePostal` varchar(10) DEFAULT NULL,
  `utilisateurId` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Déchargement des données de la table `adresse`
--

INSERT INTO `adresse` (`id`, `numero`, `rue`, `ville`, `codePostal`, `utilisateurId`) VALUES
(1, '123', 'Rue de l\'Adresse', 'Villeville', '12345', 2),
(2, '456', 'Avenue de la Liberté', 'Libreville', '67890', 1),
(3, '789', 'Rue des Champs', 'Paris', '75001', 3),
(4, '456', 'Avenue des Fleurs', 'Lyon', '69001', 4),
(5, '789', 'Rue de la Plage', 'Nice', '06000', 5),
(6, '123', 'Boulevard des Étoiles', 'Marseille', '13001', 6),
(7, '456', 'Avenue du Soleil', 'Cannes', '06400', 7),
(8, '789', 'Rue de la Liberté', 'Paris', '75001', 8),
(9, '1011', 'Avenue du Château', 'Bordeaux', '33000', 9),
(10, '1213', 'Rue de la Paix', 'Toulouse', '31000', 10);

-- --------------------------------------------------------

--
-- Structure de la table `article`
--

CREATE TABLE `article` (
  `id` int(11) NOT NULL,
  `nom` varchar(100) DEFAULT NULL,
  `prix` decimal(10,2) DEFAULT NULL,
  `vendu` tinyint(1) DEFAULT NULL,
  `photo` varchar(100) DEFAULT NULL,
  `description` text DEFAULT NULL,
  `commentaire` text DEFAULT NULL,
  `remise` decimal(5,2) DEFAULT NULL,
  `stock` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Déchargement des données de la table `article`
--

INSERT INTO `article` (`id`, `nom`, `prix`, `vendu`, `photo`, `description`, `commentaire`, `remise`, `stock`) VALUES
(1, 'Figurine dinosaure T-rex', '49.99', 0, 'https://images.king-jouet.com/6/gu728058_6.jpg', 'Plongez dans le monde fascinant des dinosaures avec la figurines T-rex Invincible Heroes.', 'Bon produit dommage pas de télécommande', '0.20', 10),
(2, 'Barbie sa Licorne Magiques', '69.90', 1, 'https://m.media-amazon.com/images/I/71+K6N2e09L.jpg', 'Barbie - Dreamtopia Barbie et sa Licorne Lumières Magiques - 32 cm - Poupée Mannequin - Dès 3 ans', 'Top ! Ma fille adore', '0.20', 15),
(3, 'Nounours viking', '19.90', 0, 'https://boutique.puydufou.com/media/catalog/product/p/e/peluche-ours-viking-2_1.png', 'Ce petit ours Viking vous protègera contre les attaques de barbares !', 'J\'adore', '0.20', 2),
(4, 'T-shirt noir', '6.99', 1, 'https://www.wordans.fr/files/models/2022/6/28/518244/518244_big.jpg', '', '', '0.20', 45),
(5, 'Short vert femme', '14.99', 1, 'https://asset.promod.com/product/156747-su-1678705456.jpg', 'Du XS au XXL', '', '0.20', 38),
(6, 'Costume Tournesol', '36.98', 1, 'https://m.media-amazon.com/images/I/513Xz39+FmL._AC_UY1100_.jpg', 'Du S au XL', '', '0.20', 12),
(7, 'Lait', '2.99', 1, 'https://im.qccdn.fr/node/guide-d-achat-lait-9393/inline-104344.jpg', 'Demi écrémé', '', '0.20', 185),
(8, 'Cereal Chocapic', '4.99', 1, 'https://ibdsoluciones.com/wp-content/uploads/2022/10/12499212.png', '540 grammes', '', '0.20', 120),
(9, 'Poulet roti', '9.99', 1, 'https://www.undejeunerdesoleil.com/wp-content/uploads/2023/01/Reussir_poulet_roti_secret_recette.jpg', 'au barbecue', '', '0.20', 10);

-- --------------------------------------------------------

--
-- Structure de la table `articlepanier`
--

CREATE TABLE `articlepanier` (
  `id` int(11) NOT NULL,
  `articleId` int(11) DEFAULT NULL,
  `quantite` int(11) DEFAULT NULL,
  `utilisateurId` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Déchargement des données de la table `articlepanier`
--

INSERT INTO `articlepanier` (`id`, `articleId`, `quantite`, `utilisateurId`) VALUES
(1, 1, 2, 1),
(2, 5, 3, 7),
(3, 9, 2, 4),
(4, 7, 1, 2),
(5, 3, 7, 8);

-- --------------------------------------------------------

--
-- Structure de la table `cartepaiement`
--

CREATE TABLE `cartepaiement` (
  `id` int(11) NOT NULL,
  `nomProprietaire` varchar(50) DEFAULT NULL,
  `prenomProprietaire` varchar(50) DEFAULT NULL,
  `numero` varchar(100) DEFAULT NULL,
  `dateFinValidite` date DEFAULT NULL,
  `cryptogramme` varchar(100) DEFAULT NULL,
  `utilisateurId` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Déchargement des données de la table `cartepaiement`
--

INSERT INTO `cartepaiement` (`id`, `nomProprietaire`, `prenomProprietaire`, `numero`, `dateFinValidite`, `cryptogramme`, `utilisateurId`) VALUES
(1, 'Dupont', 'Jean', 'iH6WsbPSK36h6R6PEmi9zi2waTyrHR3XZ+N6lcyqBOU=', '3925-12-14', '7kzJ5Puiw5jDIn8LkMld9g==', 1),
(2, 'Martin', 'Sophie', '9cHHkzH+vD7G3rLhgFB8j4kiEEJsbm9TBV+kPfxSqeE=', '3925-07-02', '+nMehTcxpgoG5+83zZOUWg==', 2),
(3, 'Dubois', 'Alice', '0xyOnw78pzovjX7/n4oSnokiEEJsbm9TBV+kPfxSqeE=', '3924-02-20', 'R94iM+GTO82JDMzZb8dPIw==', 3),
(4, 'De Villier', 'Sophiane', 'fRUPI2ztNAnSYbEl1AA+Xi2waTyrHR3XZ+N6lcyqBOU=', '3924-01-20', 'xA9VtIqCwFED4Pjp95EhBA==', 4),
(5, 'Lefebvre', 'Camille', 'g7oeEGJRFvXyoOQ2NsjmHS2waTyrHR3XZ+N6lcyqBOU=', '3923-09-02', 't7xH7c0W7EtpqjgPpvUOjQ==', 5),
(6, 'Martine', 'Anne', 'y29OWftmJS1hPiKHySjTly2waTyrHR3XZ+N6lcyqBOU=', '3924-03-01', '8p6KT+zL8boAna7MbhXC+w==', 6);

-- --------------------------------------------------------

--
-- Structure de la table `categorie`
--

CREATE TABLE `categorie` (
  `id` int(11) NOT NULL,
  `nom` varchar(100) DEFAULT NULL,
  `remise` decimal(5,2) DEFAULT NULL,
  `isRemiseCumulable` tinyint(1) DEFAULT NULL,
  `photo` varchar(100) DEFAULT NULL,
  `articleId` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Déchargement des données de la table `categorie`
--

INSERT INTO `categorie` (`id`, `nom`, `remise`, `isRemiseCumulable`, `photo`, `articleId`) VALUES
(1, 'Jouets', '0.10', 1, 'https://im.qccdn.fr/node/guide-d-achat-jouets-2731/original-19531.jpg', NULL),
(2, 'Vetements', '0.00', 1, 'https://media1.ledevoir.com/images_galerie/nwd_702982_544636/image.jpg', NULL),
(3, 'Nouriture', '0.00', 1, 'https://www.aquaportail.com/pictures2112/phones/nourriture.jpg', NULL);

-- --------------------------------------------------------

--
-- Structure de la table `categorie_article`
--

CREATE TABLE `categorie_article` (
  `categorieId` int(11) NOT NULL,
  `articleId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Déchargement des données de la table `categorie_article`
--

INSERT INTO `categorie_article` (`categorieId`, `articleId`) VALUES
(1, 1),
(1, 2),
(1, 3),
(2, 4),
(2, 5),
(2, 6),
(3, 9),
(3, 7),
(3, 8);

-- --------------------------------------------------------

--
-- Structure de la table `commande`
--

CREATE TABLE `commande` (
  `id` int(11) NOT NULL,
  `numero` varchar(50) DEFAULT NULL,
  `dateCreation` varchar(10) DEFAULT NULL,
  `dateLivraison` varchar(10) DEFAULT NULL,
  `totaleRemise` decimal(10,2) DEFAULT NULL,
  `fraisExpedition` decimal(10,2) DEFAULT NULL,
  `totalGeneral` decimal(10,2) DEFAULT NULL,
  `adresseFacturationId` int(11) DEFAULT NULL,
  `adresseLivraisonId` int(11) DEFAULT NULL,
  `cartePaiementDefautId` int(11) DEFAULT NULL,
  `utilisateurId` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Déchargement des données de la table `commande`
--

INSERT INTO `commande` (`id`, `numero`, `dateCreation`, `dateLivraison`, `totaleRemise`, `fraisExpedition`, `totalGeneral`, `adresseFacturationId`, `adresseLivraisonId`, `cartePaiementDefautId`, `utilisateurId`) VALUES
(1, 'CMD001', '21.06.2023', '30.06.2023', '10.00', '5.00', '100.00', 2, 2, 4, 4),
(2, 'CMD002', '21.06.2023', '01.07.2023', '12.00', '5.00', '94.00', 5, 5, 5, 5),
(3, 'CMD003', '21.06.2023', '06.07.2023', '12.00', '3.40', '19.00', 6, 6, 6, 6);

-- --------------------------------------------------------

--
-- Structure de la table `commentaire`
--

CREATE TABLE `commentaire` (
  `id` int(11) NOT NULL,
  `texte` varchar(255) DEFAULT NULL,
  `note` int(11) DEFAULT NULL,
  `articleId` int(11) DEFAULT NULL,
  `utilisateurId` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Déchargement des données de la table `commentaire`
--

INSERT INTO `commentaire` (`id`, `texte`, `note`, `articleId`, `utilisateurId`) VALUES
(1, 'Ceci est un commentaire.', 5, 2, 3),
(2, 'Toppppp !!!!', 4, 1, 7),
(3, 'Vraiment pas ouf !!!!', 1, 3, 5),
(4, 'Vraiment incroyable !', 4, 6, 1);

-- --------------------------------------------------------

--
-- Structure de la table `lignedecommande`
--

CREATE TABLE `lignedecommande` (
  `id` int(11) NOT NULL,
  `quantite` int(11) DEFAULT NULL,
  `prixUnitaire` decimal(10,2) DEFAULT NULL,
  `remiseArticle` decimal(10,2) DEFAULT NULL,
  `commandeId` int(11) DEFAULT NULL,
  `articleId` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Déchargement des données de la table `lignedecommande`
--

INSERT INTO `lignedecommande` (`id`, `quantite`, `prixUnitaire`, `remiseArticle`, `commandeId`, `articleId`) VALUES
(1, 2, '10.00', '2.00', 1, 1),
(2, 1, '12.00', '0.00', 2, 3),
(3, 2, '8.00', '0.00', 3, 4);

-- --------------------------------------------------------

--
-- Structure de la table `params`
--

CREATE TABLE `params` (
  `id` int(11) NOT NULL,
  `cleCryptagePwd` varchar(100) DEFAULT NULL,
  `cleCryptageCp` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `utilisateur`
--

CREATE TABLE `utilisateur` (
  `id` int(11) NOT NULL,
  `nom` varchar(50) DEFAULT NULL,
  `prenom` varchar(50) DEFAULT NULL,
  `dateNaissance` date DEFAULT NULL,
  `actif` tinyint(1) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `motDePasse` varchar(100) DEFAULT NULL,
  `numeroTelephone` varchar(20) DEFAULT NULL,
  `adresseId` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Déchargement des données de la table `utilisateur`
--

INSERT INTO `utilisateur` (`id`, `nom`, `prenom`, `dateNaissance`, `actif`, `email`, `motDePasse`, `numeroTelephone`, `adresseId`) VALUES
(1, 'Dupont', 'Jean', '1990-04-01', 1, 'jean.dupont@example.com', '$2a$10$nZ3ghhQrC0Y53R3UzpCbhOBV.zelkKP0wwDmCiF2K1ksK3F95b1ha', '1234567890', 2),
(2, 'Martin', 'Sophie', '1995-08-15', 1, 'sophie.martin@example.com', '$2a$10$rc2AzjMwfC70dTs0Vw32R.kZzADPwwjL28PCToQFbixvQ9i7GZBKa', '9876543210', 1),
(3, 'Dubois', 'Alice', '1992-12-10', 1, 'alice.dubois@example.com', '$2a$10$6ViVOMt1U5Q1i4EnlR6fhO0CrNzjN1DnZ2xKzzW9sfUnTYWM4w8W.', '5551234567', 3),
(4, 'De Villier', 'Sophiane', '1995-06-15', 0, 'm.devillier@example.com', '$2a$10$MkEznHDkz8OeSMdFOziYce6pb3wPVRl7Hb6yb/4cug/gdKkvH9XIO', '9876543210', 4),
(5, 'Lefebvre', 'Camille', '1992-09-10', 1, 'camille.lefebvre@example.com', '$2a$10$vGZlY6iu/s6ux5rAnPfZEOzhpfhRKovX503WSJXokY.qIZfUk/wGa', '5555555555', 5),
(6, 'Martine', 'Anne', '1989-06-20', 1, 'anne.m@example.com', '$2a$10$mEtWLHGgYaEwOke5alJAGeFyA7v00sb6xmiph5OBEEiLLSDYVLAw2', '9876543210', 6),
(7, 'Lefebvre', 'Marie', '1992-09-15', 1, 'marie.lefebvre@example.com', '$2a$10$Ux4TR/kjaoPetkFy1DCPzOu6IvgPB0mimGrrXA0NFjnHhOTW8ZV5S', '5678901234', 7),
(8, 'Morine', 'Claire', '1995-06-10', 1, 'claire.morine@example.com', '$2a$10$Q0l774rnA2YNmdRuizBUougRLDLcEocs/M68OV1Jv8ovEvvpJMWIu', '9876543210', 8),
(9, 'Garcia', 'Pablo', '1988-10-22', 1, 'pablo.garcia@example.com', '$2a$10$peR4o333qzb7PbGOjuoKYez/VVURGHiOKkn5WyFbQIhYjskjdUSaK', '1234509876', 9),
(10, 'Dubois', 'Emma', '1993-02-05', 0, 'emma.dubois@example.com', '$2a$10$0cpTb1NMIIhqpWPxj8yKZ.GUF1rom5qf8vzeZBPsluWFFx/YCHLjC', '5432109876', 10);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `adresse`
--
ALTER TABLE `adresse`
  ADD PRIMARY KEY (`id`),
  ADD KEY `utilisateurId` (`utilisateurId`);

--
-- Index pour la table `article`
--
ALTER TABLE `article`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `articlepanier`
--
ALTER TABLE `articlepanier`
  ADD PRIMARY KEY (`id`),
  ADD KEY `articleId` (`articleId`),
  ADD KEY `utilisateurId` (`utilisateurId`);

--
-- Index pour la table `cartepaiement`
--
ALTER TABLE `cartepaiement`
  ADD PRIMARY KEY (`id`),
  ADD KEY `utilisateurId` (`utilisateurId`);

--
-- Index pour la table `categorie`
--
ALTER TABLE `categorie`
  ADD PRIMARY KEY (`id`),
  ADD KEY `articleId` (`articleId`);

--
-- Index pour la table `commande`
--
ALTER TABLE `commande`
  ADD PRIMARY KEY (`id`),
  ADD KEY `adresseFacturationId` (`adresseFacturationId`),
  ADD KEY `adresseLivraisonId` (`adresseLivraisonId`),
  ADD KEY `cartePaiementDefautId` (`cartePaiementDefautId`),
  ADD KEY `utilisateurId` (`utilisateurId`);

--
-- Index pour la table `commentaire`
--
ALTER TABLE `commentaire`
  ADD PRIMARY KEY (`id`),
  ADD KEY `articleId` (`articleId`),
  ADD KEY `utilisateurId` (`utilisateurId`);

--
-- Index pour la table `lignedecommande`
--
ALTER TABLE `lignedecommande`
  ADD PRIMARY KEY (`id`),
  ADD KEY `commandeId` (`commandeId`),
  ADD KEY `articleId` (`articleId`);

--
-- Index pour la table `params`
--
ALTER TABLE `params`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `id` (`id`),
  ADD KEY `adresseId` (`adresseId`);

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `adresse`
--
ALTER TABLE `adresse`
  ADD CONSTRAINT `adresse_ibfk_1` FOREIGN KEY (`utilisateurId`) REFERENCES `utilisateur` (`id`);

--
-- Contraintes pour la table `articlepanier`
--
ALTER TABLE `articlepanier`
  ADD CONSTRAINT `articlepanier_ibfk_1` FOREIGN KEY (`articleId`) REFERENCES `article` (`id`),
  ADD CONSTRAINT `articlepanier_ibfk_2` FOREIGN KEY (`utilisateurId`) REFERENCES `utilisateur` (`id`);

--
-- Contraintes pour la table `cartepaiement`
--
ALTER TABLE `cartepaiement`
  ADD CONSTRAINT `cartepaiement_ibfk_1` FOREIGN KEY (`utilisateurId`) REFERENCES `utilisateur` (`id`);

--
-- Contraintes pour la table `categorie`
--
ALTER TABLE `categorie`
  ADD CONSTRAINT `categorie_ibfk_1` FOREIGN KEY (`articleId`) REFERENCES `article` (`id`);

--
-- Contraintes pour la table `commande`
--
ALTER TABLE `commande`
  ADD CONSTRAINT `commande_ibfk_1` FOREIGN KEY (`adresseFacturationId`) REFERENCES `adresse` (`id`),
  ADD CONSTRAINT `commande_ibfk_2` FOREIGN KEY (`adresseLivraisonId`) REFERENCES `adresse` (`id`),
  ADD CONSTRAINT `commande_ibfk_3` FOREIGN KEY (`cartePaiementDefautId`) REFERENCES `cartepaiement` (`id`),
  ADD CONSTRAINT `commande_ibfk_4` FOREIGN KEY (`utilisateurId`) REFERENCES `utilisateur` (`id`);

--
-- Contraintes pour la table `commentaire`
--
ALTER TABLE `commentaire`
  ADD CONSTRAINT `commentaire_ibfk_1` FOREIGN KEY (`articleId`) REFERENCES `article` (`id`),
  ADD CONSTRAINT `commentaire_ibfk_2` FOREIGN KEY (`utilisateurId`) REFERENCES `utilisateur` (`id`);

--
-- Contraintes pour la table `lignedecommande`
--
ALTER TABLE `lignedecommande`
  ADD CONSTRAINT `lignedecommande_ibfk_1` FOREIGN KEY (`commandeId`) REFERENCES `commande` (`id`),
  ADD CONSTRAINT `lignedecommande_ibfk_2` FOREIGN KEY (`articleId`) REFERENCES `article` (`id`);

--
-- Contraintes pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
  ADD CONSTRAINT `utilisateur_ibfk_1` FOREIGN KEY (`adresseId`) REFERENCES `adresse` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
