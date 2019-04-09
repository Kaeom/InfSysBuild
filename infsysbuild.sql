-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Gép: 127.0.0.1
-- Létrehozás ideje: 2019. Ápr 06. 20:56
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
('Timár Gyala', '06-96-478-37-16', '123598AD', '9343 Vica Wesselényi u. 51.', 1, 1),
('Sebestyén Firenze', '06-01-109-45-00', '564787FG', '1118 Budapest Csabai kapu 18.', 2, 1),
('Baán Pázmán', '06-20-465-45-63', '345786LA', '3813 Kupa Baross tér 66.', 3, 1),
('Asztalos Lehel', '06-70-719-03-70', '234785UI', '8960 Bárszentmihályfa Nyár utca 59.', 4, 1),
('Makay Vázsony', '06-69-414-56-46', '546784HU', '7661 Erzsébet Kossuth Lajos u. 96.', 5, 1),
('Lengyel Alexandra', '06-36-123-45-13', '234624KH', '3516 Miskolc Dózsa György út 14.', 6, 1),
('Illyés Petra', '06-70-456-73-45', '235462JH', '7981 Kistamási Teréz krt. 37.', 7, 1);

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
(7, 'Cim1', '2019-01-01', '011', 'DVD', 'Available'),
(8, 'Cim2', '2018-01-01', '012', 'DVD', 'Available'),
(10, 'Cim10', '2019-04-01', '012', 'DVD', 'Rented');

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
-- A tábla adatainak kiíratása `renting`
--

INSERT INTO `renting` (`Id`, `ClientId`, `MoviesId`, `Kezdes`, `Lejarat`) VALUES
(21, 1, 10, '2019-04-01', '2019-04-02');

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
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT a táblához `movies`
--
ALTER TABLE `movies`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT a táblához `renting`
--
ALTER TABLE `renting`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

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
