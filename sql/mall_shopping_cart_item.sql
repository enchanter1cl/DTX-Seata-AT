CREATE DATABASE `test_distribution_carts_db`;
USE `test_distribution_carts_db`;


SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_newbee_mall_shopping_cart_item
-- ----------------------------
DROP TABLE IF EXISTS `mall_shopping_cart_item`;
CREATE TABLE `mall_shopping_cart_item`  (
  `cart_item_id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '购物项主键id',
  `user_id` bigint(0) NOT NULL COMMENT '用户主键id',
  `goods_id` bigint(0) NOT NULL DEFAULT 0 COMMENT '关联商品id',
  `goods_count` int(0) NOT NULL DEFAULT 1 COMMENT '数量(最大为5)',
  `is_deleted` tinyint(0) NOT NULL DEFAULT 0 COMMENT '删除标识字段(0-未删除 1-已删除)',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '最新修改时间',
  PRIMARY KEY (`cart_item_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
