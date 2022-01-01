CREATE TABLE `app_sample` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `title` varchar(255) NOT NULL,
  `summary` varchar(255) DEFAULT NULL,
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `is_deleted` tinyint NOT NULL DEFAULT '0' COMMENT '未删:0,已删:1',
  PRIMARY KEY (`id`),
  UNIQUE KEY `unq_title` (`title`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;