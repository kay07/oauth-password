DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `id` int(11) DEFAULT NULL,
  `user_name` varchar(50) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `role` varchar(50) DEFAULT NULL,
  `authorize` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table oauth.user: ~1 rows (大约)
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
/*插入一条测试数据，其中password明文为admin123*/
/*这里将用户，角色，权限都写在了一个表里，只是测试用。
生产环境建议使用五个表：用户表，角色表，权限表，用户角色关系表，角色权限管理表*/
INSERT INTO `user` (`id`, `user_name`, `password`, `role`, `authorize`) VALUES
	(1, 'admin', '$2a$10$mNvcGlWjNlz2clzH6EI70OU//bLNCXGnh3Qcy1IsfWmIP6vBwosuK', '管理员', '增删改查');