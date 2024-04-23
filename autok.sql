-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Gép: 127.0.0.1
-- Létrehozás ideje: 2024. Ápr 23. 17:23
-- Kiszolgáló verziója: 10.4.28-MariaDB
-- PHP verzió: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Adatbázis: `autok`
--

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `auto`
--

CREATE TABLE `auto` (
  `id` int(20) NOT NULL,
  `rendszam` varchar(30) NOT NULL,
  `marka` varchar(100) NOT NULL,
  `model` varchar(100) NOT NULL,
  `tipusjel` varchar(50) NOT NULL,
  `evjarat` int(30) NOT NULL,
  `uzemanyag` varchar(40) NOT NULL,
  `hengerurtartalom` int(50) NOT NULL,
  `teljesitmeny` int(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- A tábla adatainak kiíratása `auto`
--

INSERT INTO `auto` (`id`, `rendszam`, `marka`, `model`, `tipusjel`, `evjarat`, `uzemanyag`, `hengerurtartalom`, `teljesitmeny`) VALUES
(1, 'JSN901', 'Fiat', 'punto', 'mk1', 2003, 'benzin', 1253, 75),
(2, 'KGH701', 'Fiat', 'panda', 'b03', 2005, 'dizel', 1352, 65),
(3, 'HSG762', 'Opel', 'astra', 'h', 2008, 'benzin', 1422, 91),
(4, 'JHH534', 'Renault', 'thalia', 'c21', 2006, 'benzin', 1421, 92);

--
-- Indexek a kiírt táblákhoz
--

--
-- A tábla indexei `auto`
--
ALTER TABLE `auto`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `rendszam` (`rendszam`);

--
-- A kiírt táblák AUTO_INCREMENT értéke
--

--
-- AUTO_INCREMENT a táblához `auto`
--
ALTER TABLE `auto`
  MODIFY `id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
