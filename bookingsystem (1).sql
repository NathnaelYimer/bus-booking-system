

DROP TABLE IF EXISTS `booking`;
CREATE TABLE IF NOT EXISTS `booking` (
  `bookingId` int(11) NOT NULL AUTO_INCREMENT,
  `customerUserName` varchar(10) DEFAULT NULL,
  `seatNo` int(2) DEFAULT NULL,
  `busNo` varchar(3) DEFAULT NULL,
  `date` varchar(10) DEFAULT NULL,
  `startingg` int(11) NOT NULL,
  `destination` int(11) NOT NULL,
  PRIMARY KEY (`bookingId`),
  KEY `customerUserName` (`customerUserName`),
  KEY `busNo` (`busNo`),
  KEY `startingg` (`startingg`),
  KEY `destination` (`destination`)
) ENGINE=MyISAM AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `booking`
--

INSERT INTO `booking` (`bookingId`, `customerUserName`, `seatNo`, `busNo`, `date`, `startingg`, `destination`) VALUES
(1, 'a', 2, 'H01', '2022-09-10', 1, 2),
(2, 'ama2', 1, 'H01', '2022-08-21', 2, 5),
(3, 'ama2', 2, 'H01', '2022-08-24', 5, 2),
(4, 'ama2', 2, 'H01', '2022-08-15', 5, 1),
(5, 'ama2', 2, 'H01', '2022-08-31', 2, 1),
(6, 'ama2', 1, 'H01', '2022-08-12', 2, 4),
(7, 'ama2', 1, 'A01', '2022-08-12', 2, 4),
(8, 'ama2', 1, 'H01', '2022-08-25', 7, 4);

-- --------------------------------------------------------

--
-- Table structure for table `bus`
--

DROP TABLE IF EXISTS `bus`;
CREATE TABLE IF NOT EXISTS `bus` (
  `busNo` varchar(3) NOT NULL,
  `busName` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`busNo`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `bus`
--

INSERT INTO `bus` (`busNo`, `busName`) VALUES
('H01', 'HabeshaBus'),
('H02', 'HabeshaBus'),
('A01', 'AbayBus'),
('O01', 'ODABus'),
('S01', 'SelamBus'),
('E01', 'EthioBus');

-- --------------------------------------------------------

--
-- Table structure for table `location`
--

DROP TABLE IF EXISTS `location`;
CREATE TABLE IF NOT EXISTS `location` (
  `locationId` int(11) NOT NULL,
  `lName` varchar(20) NOT NULL,
  PRIMARY KEY (`locationId`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;


INSERT INTO `location` (`locationId`, `lName`) VALUES
(1, 'Addis Ababa'),
(2, 'Bahir Dar'),
(3, 'Hawassa'),
(4, 'ArbamInch'),
(5, 'Gondar'),
(6, 'Mekele'),
(7, 'Jimma');

-- --------------------------------------------------------



DROP TABLE IF EXISTS `usertable`;
CREATE TABLE IF NOT EXISTS `usertable` (
  `userName` varchar(10) NOT NULL,
  `name` varchar(15) DEFAULT NULL,
  `password` varchar(10) DEFAULT NULL,
  `phoneNo` int(10) DEFAULT NULL,
  `userType` enum('admin','user') DEFAULT 'user',
  PRIMARY KEY (`userName`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;



INSERT INTO `usertable` (`userName`, `name`, `password`, `phoneNo`, `userType`) VALUES
('aman01', 'Amanuel', 'strongpass', 93632, 'admin'),
('nati2040', 'Natinael', 'natispass', 92040, 'user'),
('joya10a', 'Yohannes', 'joyapass', 92050, 'user'),
('Rio33210', 'Surafel', 'riopass', 92158, 'user'),
('agent4777', 'Abdi', 'abdipass', 90926, 'user'),
('YD', 'Doju', 'pass', 96541, 'user'),
('bigdiq', 'Ananiya', 'idkbro', 98765, 'user'),
('a', 'a', '11', 9, 'user'),
('HM', 'Mike', '1234', 23305, 'user'),
('jn', 'mk', 'm', 6354, 'user'),
('natii', 'nati', 'asdf', 9654, 'user'),
('jhjhjh', 'natii', 'ghj', 466, 'user'),
('natipp', 'lkkklkl', 'kjfd', 466, 'user'),
('rio111', 'surafel', 'pass', 9123, 'user'),
('ama1', 'ama', '12', 123, 'user'),
('ama2', 'ama', '1', 123, 'user');

