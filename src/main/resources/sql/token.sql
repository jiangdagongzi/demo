 DROP TABLE IF EXISTS `Token`;
 CREATE TABLE `Token`  (
 `id` int(11) NOT NULL AUTO_INCREMENT,
 `token` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
 `ownerId` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
 `ownerName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
 `createTime` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
 PRIMARY KEY (`id`) USING BTREE,
 INDEX `id`(`id`) USING BTREE
 ) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci;