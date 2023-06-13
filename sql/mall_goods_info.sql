CREATE DATABASE `test_distribution_goods_db`;
USE `test_distribution_goods_db`;

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_newbee_mall_goods_info
-- ----------------------------
DROP TABLE IF EXISTS `mall_goods_info`;
CREATE TABLE `mall_goods_info`  (
  `goods_id` bigint(0) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '商品表主键id',
  `goods_name` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL DEFAULT '' COMMENT '商品名',
  `goods_intro` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL DEFAULT '' COMMENT '商品简介',
  `goods_category_id` bigint(0) NOT NULL DEFAULT 0 COMMENT '关联分类id',
  `goods_cover_img` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL DEFAULT '/admin/dist/img/no-img.png' COMMENT '商品主图',
  `goods_carousel` varchar(500) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL DEFAULT '/admin/dist/img/no-img.png' COMMENT '商品轮播图',
  `goods_detail_content` text CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '商品详情',
  `original_price` int(0) NOT NULL DEFAULT 1 COMMENT '商品价格',
  `selling_price` int(0) NOT NULL DEFAULT 1 COMMENT '商品实际售价',
  `stock_num` int(0) UNSIGNED NOT NULL DEFAULT 0 COMMENT '商品库存数量',
  `tag` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL DEFAULT '' COMMENT '商品标签',
  `goods_sell_status` tinyint(0) NOT NULL DEFAULT 0 COMMENT '商品上架状态 1-下架 0-上架',
  `create_user` int(0) NOT NULL DEFAULT 0 COMMENT '添加者主键id',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '商品添加时间',
  `update_user` int(0) NOT NULL DEFAULT 0 COMMENT '修改者主键id',
  `update_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '商品修改时间',
  PRIMARY KEY (`goods_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10930 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;


INSERT INTO `mall_goods_info`(`goods_id`, `goods_name`, `goods_intro`, `goods_category_id`, `goods_cover_img`, `goods_carousel`, `goods_detail_content`, `original_price`, `selling_price`, `stock_num`, `tag`, `goods_sell_status`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (10003, '无印良品 MUJI 基础润肤化妆水', '滋润型 400ml', 0, '/goods-img/87446ec4-e534-4b49-9f7d-9bea34665284.jpg', '/goods-img/87446ec4-e534-4b49-9f7d-9bea34665284.jpg', '<p>商品介绍加载中...</p>', 100, 100, 10000, '', 0, 0, '2019-09-18 13:18:47', 0, '2021-03-15 14:28:56');
INSERT INTO `mall_goods_info`(`goods_id`, `goods_name`, `goods_intro`, `goods_category_id`, `goods_cover_img`, `goods_carousel`, `goods_detail_content`, `original_price`, `selling_price`, `stock_num`, `tag`, `goods_sell_status`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (10004, '无印良品 MUJI 柔和洁面泡沫', '120g', 0, '/goods-img/45854bdd-2ca5-423c-a609-3d336d9322b4.jpg', '/goods-img/45854bdd-2ca5-423c-a609-3d336d9322b4.jpg', '<p>商品介绍加载中...</p>', 45, 45, 10000, '', 0, 0, '2019-09-18 13:18:47', 0, '2019-09-18 13:18:47');

