-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Gép: 127.0.0.1
-- Létrehozás ideje: 2022. Okt 18. 11:27
-- Kiszolgáló verziója: 10.4.25-MariaDB
-- PHP verzió: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Adatbázis: `fo71m2_2`
--

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `alkatresz`
--

CREATE TABLE `alkatresz` (
  `AKOD` int(11) NOT NULL,
  `NEV` char(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `egysegek`
--

CREATE TABLE `egysegek` (
  `ARU` int(11) DEFAULT NULL,
  `DB` int(11) DEFAULT NULL CHECK (`DB` > 0)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `gyarto`
--

CREATE TABLE `gyarto` (
  `ADOSZAM` int(11) NOT NULL,
  `NEV` char(30) DEFAULT NULL,
  `TELEPHELY` varchar(30) DEFAULT NULL,
  `IRSZAM` char(4) DEFAULT NULL,
  `VAROS` char(40) DEFAULT NULL,
  `UTCA` char(100) DEFAULT NULL,
  `DESCRIPTION` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `komponens`
--

CREATE TABLE `komponens` (
  `TERMEK` int(11) DEFAULT NULL,
  `ALKATRESZ` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `termek`
--

CREATE TABLE `termek` (
  `TKOD` int(11) NOT NULL,
  `NEV` char(50) DEFAULT NULL,
  `EAR` int(11) DEFAULT NULL CHECK (`EAR` > 0),
  `GYARTO` int(11) DEFAULT NULL,
  `DESCRIPTION` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Indexek a kiírt táblákhoz
--

--
-- A tábla indexei `alkatresz`
--
ALTER TABLE `alkatresz`
  ADD PRIMARY KEY (`AKOD`);

--
-- A tábla indexei `egysegek`
--
ALTER TABLE `egysegek`
  ADD KEY `ARU` (`ARU`);

--
-- A tábla indexei `gyarto`
--
ALTER TABLE `gyarto`
  ADD PRIMARY KEY (`ADOSZAM`);

--
-- A tábla indexei `komponens`
--
ALTER TABLE `komponens`
  ADD KEY `TERMEK` (`TERMEK`),
  ADD KEY `ALKATRESZ` (`ALKATRESZ`);

--
-- A tábla indexei `termek`
--
ALTER TABLE `termek`
  ADD PRIMARY KEY (`TKOD`),
  ADD KEY `GYARTO` (`GYARTO`);

--
-- Megkötések a kiírt táblákhoz
--

--
-- Megkötések a táblához `egysegek`
--
ALTER TABLE `egysegek`
  ADD CONSTRAINT `egysegek_ibfk_1` FOREIGN KEY (`ARU`) REFERENCES `termek` (`TKOD`);

--
-- Megkötések a táblához `komponens`
--
ALTER TABLE `komponens`
  ADD CONSTRAINT `komponens_ibfk_1` FOREIGN KEY (`TERMEK`) REFERENCES `termek` (`TKOD`),
  ADD CONSTRAINT `komponens_ibfk_2` FOREIGN KEY (`ALKATRESZ`) REFERENCES `alkatresz` (`AKOD`);

--
-- Megkötések a táblához `termek`
--
ALTER TABLE `termek`
  ADD CONSTRAINT `termek_ibfk_1` FOREIGN KEY (`GYARTO`) REFERENCES `gyarto` (`ADOSZAM`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
