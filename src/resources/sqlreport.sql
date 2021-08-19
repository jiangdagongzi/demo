
 DROP TABLE IF EXISTS `Token`;  
 CREATE TABLE `Token`  ( 
 `id` int(11) NOT NULL AUTO_INCREMENT, 
  
 `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL, 
 `token` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL, 
 `ownerId` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL, 
 `ownerName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL, 
 `createTime` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL, 
 PRIMARY KEY (`id`) USING BTREE,
 INDEX `id`(`id`) USING BTREE 
 ) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci;
 DROP TABLE IF EXISTS `User`;  
 CREATE TABLE `User`  ( 
 `id` int(11) NOT NULL AUTO_INCREMENT, 
  
 `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL, 
 `userName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL, 
 `auth` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL, 
 `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL, 
 `createTime` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL, 
 `lastLogin` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL, 
 PRIMARY KEY (`id`) USING BTREE,
 INDEX `id`(`id`) USING BTREE 
 ) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci;
 DROP TABLE IF EXISTS `UserWithoutPassword`;  
 CREATE TABLE `UserWithoutPassword`  ( 
 `id` int(11) NOT NULL AUTO_INCREMENT, 
  
 `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL, 
 `userName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL, 
 `auth` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL, 
 `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL, 
 `createTime` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL, 
 `lastLogin` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL, 
 PRIMARY KEY (`id`) USING BTREE,
 INDEX `id`(`id`) USING BTREE 
 ) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci;