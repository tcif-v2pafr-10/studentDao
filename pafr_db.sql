CREATE TABLE IF NOT EXISTS `student` (
  `id` int(11) NOT NULL,
  `number` varchar(10) NOT NULL,
  `name` varchar(40) NOT NULL,
  `email` varchar(40) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

