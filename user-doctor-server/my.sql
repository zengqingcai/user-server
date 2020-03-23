CREATE TABLE `t_bu_doctor_detail` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `doctor_info_id` bigint(20) NOT NULL,
  `graduated` varchar(100) DEFAULT NULL COMMENT '毕业院校',
  `id_card` varchar(50) DEFAULT NULL COMMENT '身份证号码',
  `ct` datetime DEFAULT NULL,
  `cid` int(11) DEFAULT NULL,
  `ut` datetime DEFAULT CURRENT_TIMESTAMP,
  `uid` int(11) DEFAULT NULL,
  `status` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='医生详细信息'


CREATE TABLE `t_bu_doctor_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) CHARACTER SET latin1 NOT NULL COMMENT '姓名',
  `phone` varchar(50) NOT NULL,
  `sex` tinyint(4) DEFAULT '0' COMMENT '0 男 1 女',
  `age` tinyint(4) DEFAULT NULL,
  `type` tinyint(4) DEFAULT '0' COMMENT '0 外科',
  `ct` datetime NOT NULL,
  `cid` int(11) NOT NULL DEFAULT '0' COMMENT '0代表本人',
  `ut` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `uid` int(11) NOT NULL DEFAULT '0' COMMENT '0代表本人',
  `status` tinyint(4) NOT NULL DEFAULT '1' COMMENT '0无效1有效',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4