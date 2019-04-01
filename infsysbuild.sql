-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Gép: 127.0.0.1
-- Létrehozás ideje: 2019. Ápr 01. 20:49
-- Kiszolgáló verziója: 10.1.38-MariaDB
-- PHP verzió: 7.1.27

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Adatbázis: `infsysbuild`
--

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `clients`
--

CREATE TABLE `clients` (
  `Nev` varchar(512) COLLATE utf8_hungarian_ci NOT NULL,
  `Telefon` varchar(512) COLLATE utf8_hungarian_ci NOT NULL,
  `Szig_szam` varchar(512) COLLATE utf8_hungarian_ci NOT NULL,
  `Lakcim` varchar(512) COLLATE utf8_hungarian_ci NOT NULL,
  `Id` int(11) NOT NULL,
  `Aktiv` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_hungarian_ci;

--
-- A tábla adatainak kiíratása `clients`
--

INSERT INTO `clients` (`Nev`, `Telefon`, `Szig_szam`, `Lakcim`, `Id`, `Aktiv`) VALUES
('Java1', 'tel1', 'szigszam1', 'lakcim1', 1, 1),
('Java2', 'tel1', 'szigszam1', 'lakcim1', 2, 1),
('Java3', 'tel1', 'szigszam1', 'lakcim1', 3, 1),
('Java1', 'tel1', 'szigszam1', 'lakcim1', 4, 1),
('Java2', 'tel1', 'szigszam1', 'lakcim1', 5, 1),
('Java3', 'tel1', 'szigszam1', 'lakcim1', 6, 1),
('Java1', 'tel1', 'szigszam1', 'lakcim1', 7, 1),
('Java2', 'tel1', 'szigszam1', 'lakcim1', 8, 1),
('Java3', 'tel1', 'szigszam1', 'lakcim1', 9, 1),
('Nev1', 'Telefon0', 'SzigSzam1', '102', 10, 1);

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `movies`
--

CREATE TABLE `movies` (
  `Id` int(11) NOT NULL,
  `Cim` varchar(512) COLLATE utf8_hungarian_ci NOT NULL,
  `Datum` date NOT NULL,
  `Sorszam` varchar(512) COLLATE utf8_hungarian_ci NOT NULL,
  `Tipus` varchar(512) COLLATE utf8_hungarian_ci NOT NULL,
  `Status` varchar(512) COLLATE utf8_hungarian_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_hungarian_ci;

--
-- A tábla adatainak kiíratása `movies`
--

INSERT INTO `movies` (`Id`, `Cim`, `Datum`, `Sorszam`, `Tipus`, `Status`) VALUES
(1, 'Cim1', '2019-03-28', '001', 'DVD', 'Kölcsönözhető'),
(2, 'qwe', '2019-01-01', '34', 'we', 'qwer');

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `renting`
--

CREATE TABLE `renting` (
  `Id` int(11) NOT NULL,
  `ClientId` int(11) NOT NULL,
  `MoviesId` int(11) NOT NULL,
  `Kezdes` date NOT NULL,
  `Lejarat` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_hungarian_ci;

--
-- Indexek a kiírt táblákhoz
--

--
-- A tábla indexei `clients`
--
ALTER TABLE `clients`
  ADD PRIMARY KEY (`Id`);

--
-- A tábla indexei `movies`
--
ALTER TABLE `movies`
  ADD PRIMARY KEY (`Id`);

--
-- A tábla indexei `renting`
--
ALTER TABLE `renting`
  ADD PRIMARY KEY (`Id`),
  ADD KEY `ClientId` (`ClientId`),
  ADD KEY `MoviesId` (`MoviesId`);

--
-- A kiírt táblák AUTO_INCREMENT értéke
--

--
-- AUTO_INCREMENT a táblához `clients`
--
ALTER TABLE `clients`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT a táblához `movies`
--
ALTER TABLE `movies`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT a táblához `renting`
--
ALTER TABLE `renting`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT;

--
-- Megkötések a kiírt táblákhoz
--

--
-- Megkötések a táblához `renting`
--
ALTER TABLE `renting`
  ADD CONSTRAINT `renting_ibfk_1` FOREIGN KEY (`ClientId`) REFERENCES `clients` (`Id`),
  ADD CONSTRAINT `renting_ibfk_2` FOREIGN KEY (`MoviesId`) REFERENCES `movies` (`Id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
