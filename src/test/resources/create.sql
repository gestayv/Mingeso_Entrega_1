DROP TABLE IF EXISTS `alumno`;
CREATE TABLE `alumno` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `rut` int(11) NOT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `carrera` varchar(255) DEFAULT NULL,
  `ingreso` int(4) DEFAULT NULL,
  `password` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) DEFAULT CHARSET=utf8;