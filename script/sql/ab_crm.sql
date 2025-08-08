-- MySQL dump 10.13  Distrib 8.0.38, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: ab_turbo
-- ------------------------------------------------------
-- Server version	8.0.38

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `ab_contract`
--

DROP TABLE IF EXISTS `ab_contract`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ab_contract` (
                               `contract_id` bigint NOT NULL AUTO_INCREMENT,
                               `name` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL COMMENT '合同名称',
                               `contract_no` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL COMMENT '合同文件编号',
                               `tender_id` bigint DEFAULT NULL COMMENT '投标ID',
                               `customer_id` bigint DEFAULT NULL COMMENT '客户ID',
                               `count` varchar(4) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL COMMENT '合同份数',
                               `num` varchar(10) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL COMMENT '文件柜号',
                               `notice` varchar(10) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL COMMENT '是否有入围/中标通知书',
                               `order_date` datetime DEFAULT NULL COMMENT '签订日期',
                               `done_date` datetime DEFAULT NULL COMMENT '终止日期',
                               `end_time` datetime DEFAULT NULL COMMENT '结束时间',
                               `amount` decimal(18,2) DEFAULT NULL COMMENT '合同金额',
                               `payment_type` varchar(10) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL COMMENT '结算方式',
                               `renewal` varchar(10) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL COMMENT '是否续签',
                               `renewal_date` datetime DEFAULT NULL COMMENT '续签日期',
                               `renewal_payment_type` varchar(10) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL COMMENT '续签结算方式',
                               `business_type` varchar(10) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL COMMENT '业务类型标签',
                               `remark` varchar(1024) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '备注',
                               `check_status` int DEFAULT '0' COMMENT '0待审核、1通过、2拒绝、3审核中 4:撤回 5 未提交 6 创建 7 已删除 8 作废',
                               `create_dept` bigint DEFAULT NULL COMMENT '创建部门',
                               `create_by` bigint DEFAULT NULL COMMENT '创建人',
                               `create_time` datetime NOT NULL COMMENT '创建时间',
                               `update_by` bigint DEFAULT NULL COMMENT '更新人',
                               `update_time` datetime DEFAULT NULL COMMENT '更新时间',
                               PRIMARY KEY (`contract_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1900756717485498370 DEFAULT CHARSET=utf8mb3 ROW_FORMAT=DYNAMIC COMMENT='合同表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ab_contract`
--

LOCK TABLES `ab_contract` WRITE;
/*!40000 ALTER TABLE `ab_contract` DISABLE KEYS */;
INSERT INTO `ab_contract` (`contract_id`, `name`, `contract_no`, `tender_id`, `customer_id`, `count`, `num`, `notice`, `order_date`, `done_date`, `end_time`, `amount`, `payment_type`, `renewal`, `renewal_date`, `renewal_payment_type`, `business_type`, `remark`, `check_status`, `create_dept`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (1890623418238865409,'山西太原项目','No1xxxxxx',1889671609447890945,1889666921998594049,'1','2','Y','2025-02-16 12:44:04','2025-02-16 12:44:08','2025-02-21 12:44:11',200000.00,'0','Y','2025-02-28 12:44:23','0','1,2',NULL,0,103,1,'2025-02-15 12:45:24',1,'2025-03-15 11:50:27'),(1900756717485498369,'安徽合肥','No1xxxxxx',NULL,1890293754425360385,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'0,1',NULL,0,103,1,'2025-03-15 11:51:30',1,'2025-03-15 11:51:30');
/*!40000 ALTER TABLE `ab_contract` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ab_contract_invoice_records`
--

DROP TABLE IF EXISTS `ab_contract_invoice_records`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ab_contract_invoice_records` (
                                               `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'ID',
                                               `contract_id` bigint DEFAULT NULL COMMENT '关联的合同ID',
                                               `project_id` bigint DEFAULT NULL COMMENT '关联的项目ID',
                                               `invoice_number` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '发票编号',
                                               `invoice_date` datetime DEFAULT NULL COMMENT '开票日期',
                                               `invoice_amount` decimal(18,2) DEFAULT NULL COMMENT '发票金额',
                                               `tax_rate` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '税率',
                                               `tax_amount` decimal(18,2) DEFAULT NULL COMMENT '税额',
                                               `total_amount` decimal(18,2) DEFAULT NULL COMMENT '总金额（含税）',
                                               `remark` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '备注',
                                               `status` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '发票状态',
                                               `create_dept` bigint DEFAULT NULL COMMENT '创建部门ID',
                                               `create_by` bigint DEFAULT NULL COMMENT '创建人ID',
                                               `update_by` bigint DEFAULT NULL COMMENT '更新人ID',
                                               `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                                               `update_time` datetime DEFAULT NULL COMMENT '更新时间',
                                               PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1891693576902512642 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin ROW_FORMAT=DYNAMIC COMMENT='发票';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ab_contract_invoice_records`
--

LOCK TABLES `ab_contract_invoice_records` WRITE;
/*!40000 ALTER TABLE `ab_contract_invoice_records` DISABLE KEYS */;
INSERT INTO `ab_contract_invoice_records` (`id`, `contract_id`, `project_id`, `invoice_number`, `invoice_date`, `invoice_amount`, `tax_rate`, `tax_amount`, `total_amount`, `remark`, `status`, `create_dept`, `create_by`, `update_by`, `create_time`, `update_time`) VALUES (1891693576902512641,NULL,1889671609447890945,'No123321','2025-02-14 11:33:04',1000000.00,'6',60000.00,940000.00,'test',NULL,103,1,1,'2025-02-18 11:37:49','2025-02-18 11:37:49');
/*!40000 ALTER TABLE `ab_contract_invoice_records` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ab_contract_payment_records`
--

DROP TABLE IF EXISTS `ab_contract_payment_records`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ab_contract_payment_records` (
                                               `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'ID',
                                               `contract_id` bigint DEFAULT NULL COMMENT '关联的合同ID',
                                               `project_id` bigint DEFAULT NULL COMMENT '关联的项目ID',
                                               `payment_type` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '收付款类型',
                                               `payment_date` datetime DEFAULT NULL COMMENT '收付款日期',
                                               `payment_amount` decimal(15,2) DEFAULT NULL COMMENT '收款/付款金额',
                                               `payment_method` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '结算方式',
                                               `remark` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '备注',
                                               `status` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '收付款状态',
                                               `create_dept` bigint DEFAULT NULL COMMENT '创建部门ID',
                                               `create_by` bigint DEFAULT NULL COMMENT '创建人ID',
                                               `update_by` bigint DEFAULT NULL COMMENT '更新人ID',
                                               `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                                               `update_time` datetime DEFAULT NULL COMMENT '更新时间',
                                               PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1891702848671526915 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin ROW_FORMAT=DYNAMIC COMMENT='收付款';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ab_contract_payment_records`
--

LOCK TABLES `ab_contract_payment_records` WRITE;
/*!40000 ALTER TABLE `ab_contract_payment_records` DISABLE KEYS */;
INSERT INTO `ab_contract_payment_records` (`id`, `contract_id`, `project_id`, `payment_type`, `payment_date`, `payment_amount`, `payment_method`, `remark`, `status`, `create_dept`, `create_by`, `update_by`, `create_time`, `update_time`) VALUES (1891702848671526914,NULL,1889671609447890945,'0','2025-02-13 12:14:18',10000.00,'0','test',NULL,103,1,1,'2025-02-18 12:14:40','2025-02-18 12:14:40');
/*!40000 ALTER TABLE `ab_contract_payment_records` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ab_crm_business`
--

DROP TABLE IF EXISTS `ab_crm_business`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ab_crm_business` (
                                   `business_id` bigint NOT NULL AUTO_INCREMENT COMMENT '商机ID',
                                   `business_name` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '商机名称',
                                   `leads_id` bigint DEFAULT NULL COMMENT '线索ID',
                                   `customer_id` bigint DEFAULT NULL COMMENT '客户ID',
                                   `customer` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL COMMENT '客户名称',
                                   `contacts_id` bigint DEFAULT NULL COMMENT '首要联系人ID',
                                   `deal_date` datetime DEFAULT NULL COMMENT '预计成交日期',
                                   `money` decimal(18,2) DEFAULT NULL COMMENT '商机金额',
                                   `evaluation` longblob COMMENT '评价',
                                   `effective_date` datetime DEFAULT NULL COMMENT '生效日期',
                                   `expiration_date` datetime DEFAULT NULL COMMENT '失效日期',
                                   `remark` longblob COMMENT '详情',
                                   `status` int DEFAULT '1' COMMENT '1正常 2  删除',
                                   `create_dept` bigint DEFAULT NULL COMMENT '创建部门',
                                   `create_by` bigint NOT NULL COMMENT '创建人ID',
                                   `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                                   `update_by` bigint DEFAULT NULL COMMENT '修改人ID',
                                   `update_time` datetime DEFAULT NULL COMMENT '更新时间',
                                   PRIMARY KEY (`business_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1899350456500019203 DEFAULT CHARSET=utf8mb3 ROW_FORMAT=DYNAMIC COMMENT='商机表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ab_crm_business`
--

LOCK TABLES `ab_crm_business` WRITE;
/*!40000 ALTER TABLE `ab_crm_business` DISABLE KEYS */;
INSERT INTO `ab_crm_business` (`business_id`, `business_name`, `leads_id`, `customer_id`, `customer`, `contacts_id`, `deal_date`, `money`, `evaluation`, `effective_date`, `expiration_date`, `remark`, `status`, `create_dept`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (1889588475517796354,'测试商机',1890294557009559553,1889524772759937026,NULL,NULL,'2025-02-14 16:10:59',10000.00,NULL,NULL,NULL,_binary '<p><span style=\"font-size: 10pt;\">随着数字化转型的加速，企业在市场营销中面临诸多挑战：</span></p>\n<p><span style=\"font-size: 10pt;\"><strong data-start=\"92\" data-end=\"104\">广告投放ROI低</strong>：传统广告模式难以精准触达目标用户，导致营销成本高企。</span></p>\n<p><span style=\"font-size: 10pt;\"><strong data-start=\"136\" data-end=\"147\">数据分析难度大</strong>：企业获取大量用户数据，但缺乏有效的数据分析和洞察能力。</span></p>\n<p><span style=\"font-size: 10pt;\"><strong data-start=\"180\" data-end=\"191\">用户运营效率低</strong>：传统CRM和营销系统割裂，难以形成闭环，提高用户留存率。</span></p>\n<h4 data-start=\"224\" data-end=\"256\"><span style=\"font-size: 10pt;\"><strong data-start=\"229\" data-end=\"254\">💡 解决方案：AI驱动的智能营销SaaS</strong></span></h4>\n<p><span style=\"font-size: 10pt;\">我们提供一款<strong data-start=\"263\" data-end=\"281\">基于AI算法的营销自动化平台</strong>，帮助企业提升营销效率，降低获客成本，精准触达用户，实现业务增长。</span></p>\n<h4 data-start=\"318\" data-end=\"336\"><span style=\"font-size: 10pt;\"><strong data-start=\"323\" data-end=\"334\">🔑 关键优势</strong></span></h4>\n<p><span style=\"font-size: 10pt;\">✅ <strong data-start=\"339\" data-end=\"349\">AI智能投放</strong>：基于机器学习优化广告投放策略，提高转化率20%以上。</span><br data-start=\"376\" data-end=\"379\"><span style=\"font-size: 10pt;\">✅ <strong data-start=\"381\" data-end=\"392\">全渠道数据分析</strong>：整合社交媒体、搜索广告、电商平台数据，提供深度用户画像。</span><br data-start=\"421\" data-end=\"424\"><span style=\"font-size: 10pt;\">✅ <strong data-start=\"426\" data-end=\"435\">自动化营销</strong>：支持A/B测试、精准推送，提升用户粘性。</span><br data-start=\"456\" data-end=\"459\"><span style=\"font-size: 10pt;\">✅ <strong data-start=\"461\" data-end=\"470\">合规与安全</strong>：符合GDPR等数据保护法规，确保企业数据安全。</span></p>',1,103,1,'2025-02-12 16:12:54',1,'2025-02-18 15:54:58'),(1899135068539486210,'测试商机2',1890294557009559553,NULL,'客户2',NULL,'2025-03-13 00:25:13',2000000.00,_binary '线索有价值，可跟进','2025-03-14 00:25:18','2025-03-16 00:25:22',_binary '<p>xxx</p>',1,103,1,'2025-03-11 00:27:39',1,'2025-03-11 00:27:39'),(1899136421487738881,'测试',1890294557009559553,NULL,'测试',NULL,'2025-03-06 00:32:46',456.00,_binary '测试线索','2025-03-12 00:32:51','2025-03-15 00:32:53',_binary '<p>xxx</p>',1,103,1,'2025-03-11 00:33:02',1,'2025-03-11 00:33:02'),(1899349759205367809,'测试商机2',1890294557009559553,NULL,'中国邮政',NULL,'2025-03-12 14:40:23',1000000.00,_binary '可跟进','2025-03-12 14:40:30','2025-03-15 14:40:32',_binary '<p>测试详情</p>',1,103,1,'2025-03-11 14:40:45',1,'2025-03-11 14:40:45'),(1899350241214783489,'测试商机3',1899120377759129601,NULL,'测试客户',NULL,'2025-03-13 14:42:21',200000.00,_binary '可跟进','2025-03-13 14:42:27','2025-03-15 14:42:30',_binary '<p>新消息</p>',1,103,1,'2025-03-11 14:42:40',1,'2025-03-11 14:42:40'),(1899350456500019202,'测试商机4',1899120377759129601,NULL,'测试客户4',NULL,'2025-03-13 14:43:08',300000.00,_binary '测试线索','2025-03-12 14:43:15','2025-03-15 14:43:17',_binary '<p>测试数据</p>',1,103,1,'2025-03-11 14:43:32',1,'2025-03-11 14:43:32');
/*!40000 ALTER TABLE `ab_crm_business` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ab_crm_communication`
--

DROP TABLE IF EXISTS `ab_crm_communication`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ab_crm_communication` (
                                        `com_id` bigint NOT NULL AUTO_INCREMENT COMMENT '回访id',
                                        `com_topic` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '沟通主题',
                                        `com_content` longblob COMMENT '沟通记录',
                                        `com_type` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '沟通类别 陌拜 回访',
                                        `satisfaction` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '满意度',
                                        `com_time` datetime DEFAULT NULL COMMENT '沟通日期',
                                        `owner_user_id` bigint DEFAULT NULL COMMENT '沟通人id',
                                        `customer_id` bigint DEFAULT NULL COMMENT '客户id',
                                        `contacts_id` bigint DEFAULT NULL COMMENT '联系人id',
                                        `project_id` bigint DEFAULT NULL COMMENT '项目id',
                                        `create_dept` bigint DEFAULT NULL COMMENT '创建部门',
                                        `create_by` bigint NOT NULL COMMENT '创建人id',
                                        `update_by` bigint DEFAULT NULL COMMENT '更新人id',
                                        `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                                        `update_time` datetime DEFAULT NULL COMMENT '更新时间',
                                        PRIMARY KEY (`com_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1890333651815190530 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci ROW_FORMAT=DYNAMIC COMMENT='沟通记录\r\n';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ab_crm_communication`
--

LOCK TABLES `ab_crm_communication` WRITE;
/*!40000 ALTER TABLE `ab_crm_communication` DISABLE KEYS */;
INSERT INTO `ab_crm_communication` (`com_id`, `com_topic`, `com_content`, `com_type`, `satisfaction`, `com_time`, `owner_user_id`, `customer_id`, `contacts_id`, `project_id`, `create_dept`, `create_by`, `update_by`, `create_time`, `update_time`) VALUES (1889593297235169282,'测试沟通记录',_binary '<p data-start=\"179\" data-end=\"191\"><span style=\"font-size: 10pt; font-family: arial, helvetica, sans-serif;\">1. 项目进展：</span><br><span style=\"font-size: 10pt; font-family: arial, helvetica, sans-serif;\"><strong data-start=\"194\" data-end=\"209\">阶段一：需求分析与规划</strong>：已完成对项目需求的详细调研，并与贵方团队进行了多轮讨论，确保所有需求得到充分理解。</span><br><span style=\"font-size: 10pt; font-family: arial, helvetica, sans-serif;\"><strong data-start=\"254\" data-end=\"269\">阶段二：系统设计与开发</strong>：目前已开始系统的初步设计工作，预计在下周完成设计评审，并进入开发阶段。</span><br><span style=\"font-size: 10pt; font-family: arial, helvetica, sans-serif;\"><strong data-start=\"308\" data-end=\"323\">阶段三：进度与风险管理</strong>：我们已经建立了详细的项目进度表，并采取了风险预防措施，确保项目按期交付。</span><br><span style=\"font-size: 10pt; font-family: arial, helvetica, sans-serif;\">2. 下一步计划：</span><br><span style=\"font-size: 10pt; font-family: arial, helvetica, sans-serif;\"><strong data-start=\"378\" data-end=\"386\">开发阶段</strong>：预计将在下周开始开发工作，重点完成系统的核心功能模块开发。</span><br><span style=\"font-size: 10pt; font-family: arial, helvetica, sans-serif;\"><strong data-start=\"419\" data-end=\"427\">测试阶段</strong>：开发完成后，计划进入系统测试阶段，我们将安排专项团队对系统进行严格的功能与性能测试。</span><br><span style=\"font-size: 10pt; font-family: arial, helvetica, sans-serif;\"><strong data-start=\"473\" data-end=\"481\">上线准备</strong>：项目的最终上线时间预定在两个月后，我们会提前与贵方确认上线计划与相关准备事项。</span></p>','0','Y','2025-02-13 16:31:34',1889212276706738177,1889524772759937026,NULL,1889671609447890945,103,1,1,'2025-02-12 16:32:04','2025-02-15 11:09:42'),(1890332536142909441,'测试主题2',_binary '<p data-start=\"523\" data-end=\"584\">我们非常期待与贵方继续保持紧密合作，并共同推动项目顺利实施。如果您对当前进展有任何疑问或需要进一步讨论的事项，请随时告知。</p>\n<p data-start=\"586\" data-end=\"618\">再次感谢贵方的支持与信任。期待我们能够携手共进，取得更大的成功。</p>\n<p data-start=\"620\" data-end=\"627\">祝您工作愉快！</p>','0','Y','2025-02-15 17:29:23',1889213847330979841,1889524772759937026,NULL,1889671609447890945,103,1,1,'2025-02-14 17:29:32','2025-02-14 17:29:42'),(1890333651815190529,'沟通主题3',_binary '<p><span style=\"font-size: 10pt; font-family: arial, helvetica, sans-serif;\">1. 项目进展：</span></p>\n<p><span style=\"font-size: 10pt; font-family: arial, helvetica, sans-serif;\"><strong data-start=\"194\" data-end=\"209\">阶段一：需求分析与规划</strong>：已完成对项目需求的详细调研，并与贵方团队进行了多轮讨论，确保所有需求得到充分理解。</span></p>\n<p><span style=\"font-size: 10pt; font-family: arial, helvetica, sans-serif;\"><strong data-start=\"254\" data-end=\"269\">阶段二：系统设计与开发</strong>：目前已开始系统的初步设计工作，预计在下周完成设计评审，并进入开发阶段。</span></p>\n<p><span style=\"font-size: 10pt; font-family: arial, helvetica, sans-serif;\"><strong data-start=\"308\" data-end=\"323\">阶段三：进度与风险管理</strong>：我们已经建立了详细的项目进度表，并采取了风险预防措施，确保项目按期交付。</span></p>\n<p><span style=\"font-size: 10pt; font-family: arial, helvetica, sans-serif;\">2. 下一步计划：</span></p>\n<p><span style=\"font-size: 10pt; font-family: arial, helvetica, sans-serif;\"><strong data-start=\"378\" data-end=\"386\">开发阶段</strong>：预计将在下周开始开发工作，重点完成系统的核心功能模块开发。</span></p>\n<p><span style=\"font-size: 10pt; font-family: arial, helvetica, sans-serif;\"><strong data-start=\"419\" data-end=\"427\">测试阶段</strong>：开发完成后，计划进入系统测试阶段，我们将安排专项团队对系统进行严格的功能与性能测试。</span></p>\n<p><span style=\"font-size: 10pt; font-family: arial, helvetica, sans-serif;\"><strong data-start=\"473\" data-end=\"481\">上线准备</strong>：项目的最终上线时间预定在两个月后，我们会提前与贵方确认上线计划与相关准备事项。</span></p>','1','Y','2025-02-22 17:33:48',1889212276706738177,1889524772759937026,NULL,1889671609447890945,103,1,1,'2025-02-14 17:33:58','2025-02-15 11:09:57');
/*!40000 ALTER TABLE `ab_crm_communication` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ab_crm_contacts`
--

DROP TABLE IF EXISTS `ab_crm_contacts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ab_crm_contacts` (
                                   `contacts_id` bigint NOT NULL AUTO_INCREMENT COMMENT '联系人ID',
                                   `customer_id` bigint DEFAULT NULL COMMENT '客户ID',
                                   `name` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL COMMENT '联系人名称',
                                   `dept` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL COMMENT '部门',
                                   `gender` varchar(10) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL COMMENT '性别',
                                   `wx_code` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL COMMENT '微信号',
                                   `mobile` varchar(500) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT '' COMMENT '手机',
                                   `telephone` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT '' COMMENT '电话',
                                   `email` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL COMMENT '电子邮箱',
                                   `post` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL COMMENT '职务',
                                   `key_maker` varchar(10) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL COMMENT '关键决策人',
                                   `address` varchar(500) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT '' COMMENT '地址',
                                   `remark` longblob COMMENT '备注',
                                   `owner_user_id` bigint DEFAULT NULL COMMENT '负责人ID',
                                   `create_dept` bigint DEFAULT NULL COMMENT '创建部门',
                                   `create_by` bigint DEFAULT NULL COMMENT '创建人ID',
                                   `update_by` bigint DEFAULT NULL COMMENT '更新人ID',
                                   `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                                   `update_time` datetime DEFAULT NULL COMMENT '更新时间',
                                   PRIMARY KEY (`contacts_id`) USING BTREE,
                                   KEY `owner_user_id` (`owner_user_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1899103985756315650 DEFAULT CHARSET=utf8mb3 ROW_FORMAT=DYNAMIC COMMENT='联系人表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ab_crm_contacts`
--

LOCK TABLES `ab_crm_contacts` WRITE;
/*!40000 ALTER TABLE `ab_crm_contacts` DISABLE KEYS */;
INSERT INTO `ab_crm_contacts` (`contacts_id`, `customer_id`, `name`, `dept`, `gender`, `wx_code`, `mobile`, `telephone`, `email`, `post`, `key_maker`, `address`, `remark`, `owner_user_id`, `create_dept`, `create_by`, `update_by`, `create_time`, `update_time`) VALUES (1889545499932368898,1889524772759937026,'李四',NULL,'0',NULL,'17200000000','17200000000','xxx','主任','Y','山西太原',_binary '测试数据',NULL,103,1,1,'2025-02-12 13:22:08','2025-02-12 22:26:16'),(1899099029227794434,1889524772759937026,'张三','研发部',NULL,'17201981786','','',NULL,'组长',NULL,'',_binary '备注信息',NULL,103,1,1,'2025-03-10 22:04:27','2025-03-10 22:04:27'),(1899100599898173441,1889524772759937026,'张三','研发部',NULL,'17201981786','17201981786,1179810071','',NULL,'组长',NULL,'',_binary '备注信息',NULL,103,1,1,'2025-03-10 22:10:41','2025-03-10 22:10:41'),(1899103985756315649,1889666921998594049,'李四','研发',NULL,'17200000000','17200000000,,17812345678','',NULL,'组员',NULL,'',_binary '备注',NULL,103,1,1,'2025-03-10 22:24:09','2025-03-14 15:01:23');
/*!40000 ALTER TABLE `ab_crm_contacts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ab_crm_customer`
--

DROP TABLE IF EXISTS `ab_crm_customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ab_crm_customer` (
                                   `customer_id` bigint NOT NULL AUTO_INCREMENT,
                                   `customer_name` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin DEFAULT NULL COMMENT '客户名称',
                                   `customer_source` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL COMMENT '客户来源',
                                   `customer_level` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL COMMENT '客户级别',
                                   `customer_tag` varchar(500) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL COMMENT '客户标签',
                                   `registered_capital` decimal(18,2) DEFAULT NULL COMMENT '注册资本',
                                   `business_scope` text CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci COMMENT '经营范围',
                                   `mailing_address` varchar(300) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL COMMENT '通信地址',
                                   `contact_id` bigint DEFAULT NULL COMMENT '首要联系人ID',
                                   `owner` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL COMMENT '法人',
                                   `mobile` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL COMMENT '注册电话',
                                   `telephone` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT '' COMMENT '电话',
                                   `website` varchar(300) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT '' COMMENT '网址',
                                   `email` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL COMMENT '邮箱',
                                   `remark` longblob COMMENT '备注',
                                   `address` varchar(300) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT '' COMMENT '详细地址',
                                   `create_dept` bigint DEFAULT NULL COMMENT '创建部门ID',
                                   `create_by` bigint NOT NULL COMMENT '创建人ID',
                                   `update_by` bigint DEFAULT NULL COMMENT '更新人ID',
                                   `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                                   `update_time` datetime DEFAULT NULL COMMENT '更新时间',
                                   `status` int DEFAULT '1' COMMENT '客户状态 1 正常 2锁定 3删除',
                                   PRIMARY KEY (`customer_id`) USING BTREE,
                                   KEY `update_time` (`update_time`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1892403152635359235 DEFAULT CHARSET=utf8mb3 ROW_FORMAT=DYNAMIC COMMENT='客户表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ab_crm_customer`
--

LOCK TABLES `ab_crm_customer` WRITE;
/*!40000 ALTER TABLE `ab_crm_customer` DISABLE KEYS */;
INSERT INTO `ab_crm_customer` (`customer_id`, `customer_name`, `customer_source`, `customer_level`, `customer_tag`, `registered_capital`, `business_scope`, `mailing_address`, `contact_id`, `owner`, `mobile`, `telephone`, `website`, `email`, `remark`, `address`, `create_dept`, `create_by`, `update_by`, `create_time`, `update_time`, `status`) VALUES (1889524772759937026,'测试客户','0','0','0,1',1000000.00,'经营范围','xxx',NULL,NULL,'17200000000','17200000000','xxx','xxx@qq.com',NULL,'xxx',103,1,1,'2025-02-12 11:59:46','2025-03-12 16:14:12',1),(1889666921998594049,'测试客户2','1','2','2,1',NULL,NULL,NULL,NULL,NULL,'17200000000','17200000000','xxx','xxx',NULL,'xxxxx',103,1,1,'2025-02-12 21:24:37','2025-03-15 11:50:27',1),(1890293754425360385,'测试','1','1','2,0,1',NULL,NULL,NULL,NULL,NULL,NULL,'','',NULL,_binary '[{\"username\":\"admin\",\"currentTime\":\"2025-03-15T02:32:07.517Z\",\"remark\":\"<p>姓名：张伟<br>公司：ABC 科技有限公司<br>职位：产品经理<br>联系电话：138-XXXX-XXXX<br>邮箱：zhangwei@abc-tech.com<br>地址：北京市海淀区中关村大街100号</p>\"},{\"username\":\"admin\",\"currentTime\":\"2025-03-15T02:38:29.812Z\",\"remark\":\"<p>姓名：张伟<br>公司：ABC 科技有限公司<br>职位：产品经理<br>联系电话：138-XXXX-XXXX</p>\"}]','',103,1,1,'2025-02-14 14:55:26','2025-03-15 11:51:31',1),(1891776327722799106,'测试客户-个人权限测试客户-个人权限测试客户个人权限测试客户','3','2','2',NULL,NULL,NULL,NULL,NULL,'17200000000','17200000000','','xxx@qq.com','','江苏省南通市',104,1889213847330979841,1,'2025-02-18 17:06:39','2025-03-15 11:33:41',1),(1892401734004305921,'测试客户-部门权限1','3','0','2',NULL,NULL,NULL,NULL,NULL,'17200000000','17200000000','','xxx@qq.com','','江苏省南通市',104,1889212276706738177,1,'2025-02-20 10:31:47','2025-03-10 15:09:04',1);
/*!40000 ALTER TABLE `ab_crm_customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ab_crm_leads`
--

DROP TABLE IF EXISTS `ab_crm_leads`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ab_crm_leads` (
                                `leads_id` bigint NOT NULL AUTO_INCREMENT,
                                `leads_name` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NOT NULL COMMENT '线索名称',
                                `leads_source` varchar(10) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL COMMENT '线索来源',
                                `source_other` varchar(10) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL COMMENT '其它线索',
                                `customer_id` bigint DEFAULT NULL COMMENT '客户id',
                                `customer` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL COMMENT '客户名称',
                                `owner_company` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL COMMENT '员工单位',
                                `owner_user` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL COMMENT '员工姓名',
                                `telephone` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL COMMENT '员工联系方式',
                                `leads_contacts` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL COMMENT '线索联系人',
                                `mobile` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL COMMENT '线索联系方式',
                                `email` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL COMMENT '邮箱',
                                `effective_date` datetime DEFAULT NULL COMMENT '生效日期',
                                `expiration_date` datetime DEFAULT NULL COMMENT '失效日期',
                                `address` varchar(500) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT '' COMMENT '地址',
                                `remark` longblob COMMENT '线索详情',
                                `status` int DEFAULT '0' COMMENT '转化状态 1已转化 0 未转化',
                                `create_dept` bigint DEFAULT NULL COMMENT '创建部门',
                                `create_by` bigint NOT NULL COMMENT '创建人ID',
                                `update_by` bigint DEFAULT NULL COMMENT '更新人ID',
                                `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                                `update_time` datetime DEFAULT NULL COMMENT '更新时间',
                                PRIMARY KEY (`leads_id`) USING BTREE,
                                KEY `owner_user_id` (`owner_user`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1900725642948292611 DEFAULT CHARSET=utf8mb3 ROW_FORMAT=DYNAMIC COMMENT='线索表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ab_crm_leads`
--

LOCK TABLES `ab_crm_leads` WRITE;
/*!40000 ALTER TABLE `ab_crm_leads` DISABLE KEYS */;
INSERT INTO `ab_crm_leads` (`leads_id`, `leads_name`, `leads_source`, `source_other`, `customer_id`, `customer`, `owner_company`, `owner_user`, `telephone`, `leads_contacts`, `mobile`, `email`, `effective_date`, `expiration_date`, `address`, `remark`, `status`, `create_dept`, `create_by`, `update_by`, `create_time`, `update_time`) VALUES (1890294557009559553,'测试线索','2',NULL,1889524772759937026,'邮政',NULL,'张三','17200000000',NULL,'17200000000','xxx@qq.com','2025-03-13 14:39:18','2025-03-15 14:39:21','xxx',_binary '<p><span style=\"font-size: 10pt; font-family: arial, helvetica, sans-serif;\"><strong data-start=\"311\" data-end=\"319\">发现渠道</strong>：某招聘网站 &amp; 目标客户官网</span></p>\n<p><span style=\"font-size: 10pt; font-family: arial, helvetica, sans-serif;\"><strong data-start=\"339\" data-end=\"347\">线索详情</strong>：</span></p>\n<p><span style=\"font-size: 10pt; font-family: arial, helvetica, sans-serif;\">目标客户公司 <strong data-start=\"360\" data-end=\"367\">X科技</strong> 正在招聘 <strong data-start=\"373\" data-end=\"385\">&ldquo;数字营销经理&rdquo;</strong>，要求熟悉市场投放和数据分析。</span></p>\n<p><span style=\"font-size: 10pt; font-family: arial, helvetica, sans-serif;\">该公司近期有<strong data-start=\"411\" data-end=\"421\">市场扩张计划</strong>，可能需要更好的营销工具。</span></p>\n<p><span style=\"font-size: 10pt; font-family: arial, helvetica, sans-serif;\"><strong data-start=\"437\" data-end=\"443\">分析</strong>：</span></p>\n<p><span style=\"font-size: 10pt; font-family: arial, helvetica, sans-serif;\">该公司可能在寻找新的营销解决方案，与我们的 SaaS 产品高度契合。</span></p>\n<p><span style=\"font-size: 10pt; font-family: arial, helvetica, sans-serif;\">可以联系 HR 或市场负责人，介绍如何帮助他们提高广告投放效率。</span></p>',0,103,1,1,'2025-02-14 14:58:37','2025-03-11 14:39:26'),(1899120377759129601,'测试线索','2',NULL,NULL,'测试客户',NULL,'员工1',NULL,NULL,'17200000000',NULL,'2025-03-14 23:37:23','2025-03-23 23:37:26','xxx',_binary '<p>xxx</p>',0,103,1,1,'2025-03-10 23:29:17','2025-03-10 23:37:33'),(1900725144203603970,'测试线索3','3',NULL,1889666921998594049,NULL,NULL,NULL,NULL,'联系人3','17200000000',NULL,NULL,NULL,'xxx',_binary '<p>xxx</p>',0,103,1,1,'2025-03-15 09:46:03','2025-03-15 09:46:03'),(1900725519014998018,'测试线索4','2',NULL,1889666921998594049,NULL,'员工单位','员工1','17200000000','联系人4','17200000000',NULL,NULL,NULL,'xxx',_binary '<p>xxx</p>',0,103,1,1,'2025-03-15 09:47:32','2025-03-15 09:47:32'),(1900725642948292610,'测试线索5','5','其它',1891776327722799106,NULL,NULL,NULL,NULL,'联系人5','17200000000',NULL,NULL,NULL,'xxx',_binary '<p>xxx</p>',0,103,1,1,'2025-03-15 09:48:02','2025-03-15 09:48:02');
/*!40000 ALTER TABLE `ab_crm_leads` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ab_project`
--

DROP TABLE IF EXISTS `ab_project`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ab_project` (
                              `id` bigint NOT NULL AUTO_INCREMENT,
                              `name` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin DEFAULT NULL COMMENT '项目名称',
                              `contract_id` bigint DEFAULT NULL COMMENT '合同ID',
                              `business_id` bigint DEFAULT NULL COMMENT '商机ID',
                              `project_no` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin DEFAULT NULL COMMENT '文件编号',
                              `customer_id` bigint DEFAULT NULL COMMENT '签约甲方',
                              `party_id` varchar(10) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin DEFAULT NULL COMMENT '签约乙方',
                              `project_type` varchar(10) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin DEFAULT NULL COMMENT '项目类型',
                              `import_export` varchar(10) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin DEFAULT NULL COMMENT '进出口类型',
                              `quantity` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin DEFAULT NULL COMMENT '件量',
                              `sorter_port_count` varchar(10) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin DEFAULT NULL COMMENT '格口数量',
                              `area` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin DEFAULT NULL COMMENT '区域',
                              `delivery_time` datetime DEFAULT NULL COMMENT '交付日期',
                              `status` int DEFAULT NULL COMMENT '项目状态',
                              `deliver_status` varchar(10) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin DEFAULT '0' COMMENT '发货状态',
                              `remark` varchar(3000) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin DEFAULT NULL COMMENT '备注',
                              `amount` decimal(18,2) DEFAULT NULL COMMENT '产品总金额',
                              `invoice_status` varchar(10) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin DEFAULT '0' COMMENT '开票状态',
                              `pay_status` varchar(10) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin DEFAULT NULL COMMENT '付款状态',
                              `create_dept` bigint DEFAULT NULL COMMENT '创建部门',
                              `create_by` bigint DEFAULT NULL COMMENT '创建人',
                              `create_time` datetime DEFAULT NULL COMMENT '创建日期',
                              `update_by` bigint DEFAULT NULL COMMENT '更新人',
                              `update_time` datetime DEFAULT NULL COMMENT '修改日期',
                              PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1889671609447890946 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin ROW_FORMAT=DYNAMIC COMMENT='项目信息';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ab_project`
--

LOCK TABLES `ab_project` WRITE;
/*!40000 ALTER TABLE `ab_project` DISABLE KEYS */;
INSERT INTO `ab_project` (`id`, `name`, `contract_id`, `business_id`, `project_no`, `customer_id`, `party_id`, `project_type`, `import_export`, `quantity`, `sorter_port_count`, `area`, `delivery_time`, `status`, `deliver_status`, `remark`, `amount`, `invoice_status`, `pay_status`, `create_dept`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (1889671609447890945,'山西太原项目',NULL,1889588475517796354,'FileNo1',1889524772759937026,'1','1','2','20000','200','山西太原','2025-02-28 21:42:56',0,'0','测试',2000000.00,'0','0',103,1,'2025-02-12 21:43:15',1,'2025-02-14 17:33:00');
/*!40000 ALTER TABLE `ab_project` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ab_project_competitor_records`
--

DROP TABLE IF EXISTS `ab_project_competitor_records`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ab_project_competitor_records` (
                                                 `competitor_id` bigint NOT NULL AUTO_INCREMENT COMMENT '竞争对手ID',
                                                 `competitor_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '竞争对手名称',
                                                 `competitor_code` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '竞争对手编码',
                                                 `bid_id` bigint DEFAULT NULL COMMENT '所属投标ID',
                                                 `bid_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '投标项目名称',
                                                 `project_id` bigint DEFAULT NULL COMMENT '项目ID',
                                                 `submission_date` date DEFAULT NULL COMMENT '投标提交日期',
                                                 `bid_amount` decimal(18,2) DEFAULT NULL COMMENT '投标金额',
                                                 `bid_status` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '投标状态（如已中标、未中标）',
                                                 `strengths` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci COMMENT '竞争对手的优势',
                                                 `weaknesses` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci COMMENT '竞争对手的劣势',
                                                 `contact_person` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '联系人',
                                                 `contact_phone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '电话',
                                                 `contact_email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '邮箱',
                                                 `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '地址',
                                                 `create_dept` bigint DEFAULT NULL COMMENT '创建部门',
                                                 `create_by` bigint NOT NULL COMMENT '创建人ID',
                                                 `update_by` bigint DEFAULT NULL COMMENT '更新人ID',
                                                 `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                                                 `update_time` datetime DEFAULT NULL COMMENT '更新时间',
                                                 PRIMARY KEY (`competitor_id`) USING BTREE,
                                                 UNIQUE KEY `competitor_code` (`competitor_code`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1889703609353474050 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC COMMENT='竞对记录';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ab_project_competitor_records`
--

LOCK TABLES `ab_project_competitor_records` WRITE;
/*!40000 ALTER TABLE `ab_project_competitor_records` DISABLE KEYS */;
INSERT INTO `ab_project_competitor_records` (`competitor_id`, `competitor_name`, `competitor_code`, `bid_id`, `bid_name`, `project_id`, `submission_date`, `bid_amount`, `bid_status`, `strengths`, `weaknesses`, `contact_person`, `contact_phone`, `contact_email`, `address`, `create_dept`, `create_by`, `update_by`, `create_time`, `update_time`) VALUES (1889703609353474049,'测试竞对','BMXXX',NULL,'测试项目名称',1889671609447890945,'2025-02-14',2000.00,'0','优势1','优势2',NULL,NULL,NULL,NULL,103,1,1,'2025-02-12 23:50:24','2025-02-12 23:50:24');
/*!40000 ALTER TABLE `ab_project_competitor_records` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ab_project_legal_opinion`
--

DROP TABLE IF EXISTS `ab_project_legal_opinion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ab_project_legal_opinion` (
                                            `opinion_id` bigint NOT NULL AUTO_INCREMENT COMMENT '法务意见ID',
                                            `project_id` bigint NOT NULL COMMENT '项目ID',
                                            `legal_opinion` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '法务意见内容',
                                            `opinion_date` date DEFAULT NULL COMMENT '法务意见日期',
                                            `opinion_status` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '法务意见状态（如待审核、已审核）',
                                            `opinion_author` bigint DEFAULT NULL COMMENT '法务意见作者（法务人员姓名）',
                                            `create_dept` bigint DEFAULT NULL COMMENT '创建部门',
                                            `create_by` bigint DEFAULT NULL COMMENT '创建人ID',
                                            `update_by` bigint DEFAULT NULL COMMENT '更新人ID',
                                            `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                                            `update_time` datetime DEFAULT NULL COMMENT '更新时间',
                                            PRIMARY KEY (`opinion_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1889694513086607362 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC COMMENT='法务意见';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ab_project_legal_opinion`
--

LOCK TABLES `ab_project_legal_opinion` WRITE;
/*!40000 ALTER TABLE `ab_project_legal_opinion` DISABLE KEYS */;
INSERT INTO `ab_project_legal_opinion` (`opinion_id`, `project_id`, `legal_opinion`, `opinion_date`, `opinion_status`, `opinion_author`, `create_dept`, `create_by`, `update_by`, `create_time`, `update_time`) VALUES (1889694513086607361,1889671609447890945,'<p><span style=\"font-size: 10pt;\">针对贵方在 Redis 数据存储管理中的数据存取、更新及删除机制，法务团队基于现行法律法规和数据合规要求，提出以下法律合规性分析及建议。</span></p>\n<h3 data-start=\"236\" data-end=\"258\"><span style=\"font-size: 10pt;\"><strong data-start=\"240\" data-end=\"256\">一、数据存储与隐私合规性</strong></span></h3>\n<ol data-start=\"259\" data-end=\"520\">\n<li style=\"font-size: 10pt;\" data-start=\"259\" data-end=\"363\"><span style=\"font-size: 10pt;\"><strong data-start=\"262\" data-end=\"272\">个人信息处理</strong>：如存储的数据涉及用户个人信息（姓名、电话、地址等），需符合《个人信息保护法》（PIPL）、《通用数据保护条例》（GDPR）等相关法规，确保数据存储、处理及删除机制符合合规要求。</span></li>\n<li style=\"font-size: 10pt;\" data-start=\"364\" data-end=\"463\"><span style=\"font-size: 10pt;\"><strong data-start=\"367\" data-end=\"378\">数据最小化原则</strong>：建议仅存储必要信息，并明确数据保留期限。采用 Redis Sorted Set 方式进行数据管理，并定期删除 7 天前数据，符合数据最小化原则，有助于降低合规风险。</span></li>\n<li style=\"font-size: 10pt;\" data-start=\"464\" data-end=\"520\"><span style=\"font-size: 10pt;\"><strong data-start=\"467\" data-end=\"477\">数据安全保障</strong>：建议对存储数据进行适当加密，并采取访问控制策略，防止未经授权的访问、篡改或泄露。</span></li>\n</ol>\n<h3 data-start=\"522\" data-end=\"543\"><span style=\"font-size: 10pt;\"><strong data-start=\"526\" data-end=\"541\">二、数据删除与用户权利</strong></span></h3>\n<ol data-start=\"544\" data-end=\"690\">\n<li style=\"font-size: 10pt;\" data-start=\"544\" data-end=\"606\"><span style=\"font-size: 10pt;\"><strong data-start=\"547\" data-end=\"559\">用户数据删除请求</strong>：如涉及用户数据，需提供删除通道，确保用户有权请求删除其个人数据，并能够立即执行删除操作。</span></li>\n<li style=\"font-size: 10pt;\" data-start=\"607\" data-end=\"690\"><span style=\"font-size: 10pt;\"><strong data-start=\"610\" data-end=\"620\">定期清理机制</strong>：建议明确 Redis 数据删除规则，并通过 <code data-start=\"643\" data-end=\"661\">ZREMRANGEBYSCORE</code> 等命令定期清理过期数据，以符合数据保留期限管理要求。</span></li>\n</ol>\n<h3 data-start=\"692\" data-end=\"711\"><span style=\"font-size: 10pt;\"><strong data-start=\"696\" data-end=\"709\">三、合同及法律风险</strong></span></h3>\n<ol data-start=\"712\" data-end=\"852\">\n<li style=\"font-size: 10pt;\" data-start=\"712\" data-end=\"786\"><span style=\"font-size: 10pt;\"><strong data-start=\"715\" data-end=\"725\">数据存储协议</strong>：如 Redis 数据存储涉及第三方云服务商，应明确数据管理责任，确保云存储协议符合《数据安全法》及其他适用法规要求。</span></li>\n<li style=\"font-size: 10pt;\" data-start=\"787\" data-end=\"852\"><span style=\"font-size: 10pt;\"><strong data-start=\"790\" data-end=\"800\">法律责任分配</strong>：若数据存储由外部供应商提供，应明确数据安全责任归属，并通过合同约定数据泄露或合规性问题的处理机制。</span></li>\n</ol>','2025-02-13',NULL,1889213723628371970,103,1,1,'2025-02-12 23:14:15','2025-02-20 13:29:21');
/*!40000 ALTER TABLE `ab_project_legal_opinion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ab_project_product`
--

DROP TABLE IF EXISTS `ab_project_product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ab_project_product` (
                                      `product_id` bigint NOT NULL AUTO_INCREMENT,
                                      `name` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '产品名称',
                                      `num` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL COMMENT '产品编码',
                                      `unit` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL COMMENT '单位',
                                      `price` decimal(18,2) DEFAULT NULL COMMENT '价格',
                                      `status` varchar(10) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL COMMENT '状态 1 上架 0 下架 3 删除',
                                      `category_id` bigint DEFAULT NULL COMMENT '产品分类ID',
                                      `description` varchar(1000) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL COMMENT '产品描述',
                                      `owner_user_id` bigint DEFAULT NULL COMMENT '负责人ID',
                                      `create_dept` bigint DEFAULT NULL COMMENT '创建部门',
                                      `create_by` bigint NOT NULL COMMENT '创建人ID',
                                      `update_by` bigint DEFAULT NULL COMMENT '更新人ID',
                                      `create_time` datetime NOT NULL COMMENT '创建时间',
                                      `update_time` datetime DEFAULT NULL COMMENT '更新时间',
                                      PRIMARY KEY (`product_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 ROW_FORMAT=DYNAMIC COMMENT='产品表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ab_project_product`
--

LOCK TABLES `ab_project_product` WRITE;
/*!40000 ALTER TABLE `ab_project_product` DISABLE KEYS */;
/*!40000 ALTER TABLE `ab_project_product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ab_project_product_category`
--

DROP TABLE IF EXISTS `ab_project_product_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ab_project_product_category` (
                                               `category_id` bigint NOT NULL AUTO_INCREMENT COMMENT '产品分类ID',
                                               `name` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT '' COMMENT '产品分类名称',
                                               `pid` bigint DEFAULT '0' COMMENT '父ID',
                                               `status` varchar(10) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL COMMENT '状态',
                                               `create_dept` bigint DEFAULT NULL COMMENT '创建部门',
                                               `create_by` bigint DEFAULT NULL,
                                               `update_by` bigint DEFAULT NULL,
                                               `create_time` datetime DEFAULT NULL,
                                               `update_time` datetime DEFAULT NULL,
                                               PRIMARY KEY (`category_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1889696430261137410 DEFAULT CHARSET=utf8mb3 ROW_FORMAT=DYNAMIC COMMENT='产品分类表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ab_project_product_category`
--

LOCK TABLES `ab_project_product_category` WRITE;
/*!40000 ALTER TABLE `ab_project_product_category` DISABLE KEYS */;
INSERT INTO `ab_project_product_category` (`category_id`, `name`, `pid`, `status`, `create_dept`, `create_by`, `update_by`, `create_time`, `update_time`) VALUES (1,'分拣机',0,'0',NULL,NULL,1,NULL,'2025-02-12 23:21:04'),(1889696302590717953,'交叉带分拣机',1,'0',103,1,1,'2025-02-12 23:21:22','2025-02-12 23:21:22'),(1889696352855257090,'直线分拣机',1,'0',103,1,1,'2025-02-12 23:21:34','2025-02-12 23:21:34'),(1889696430261137409,'窄带分拣机',1,'0',103,1,1,'2025-02-12 23:21:52','2025-02-12 23:21:52');
/*!40000 ALTER TABLE `ab_project_product_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ab_project_quote`
--

DROP TABLE IF EXISTS `ab_project_quote`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ab_project_quote` (
                                    `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键ID',
                                    `project_id` bigint NOT NULL COMMENT '项目',
                                    `quote_number` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '报价单号',
                                    `quote_date` date DEFAULT NULL COMMENT '报价日期',
                                    `total_amount` decimal(18,2) DEFAULT NULL COMMENT '总金额',
                                    `status` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT 'pending' COMMENT '报价状态（pending:待确认, approved:已确认, rejected:已拒绝）',
                                    `create_dept` bigint DEFAULT NULL COMMENT '创建部门ID',
                                    `create_by` bigint DEFAULT NULL COMMENT '创建人ID',
                                    `update_by` bigint DEFAULT NULL COMMENT '更新人ID',
                                    `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                                    `update_time` datetime DEFAULT NULL COMMENT '更新时间',
                                    PRIMARY KEY (`id`) USING BTREE,
                                    UNIQUE KEY `quote_number` (`quote_number`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1891408956860420098 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin ROW_FORMAT=DYNAMIC COMMENT='项目报价信息表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ab_project_quote`
--

LOCK TABLES `ab_project_quote` WRITE;
/*!40000 ALTER TABLE `ab_project_quote` DISABLE KEYS */;
INSERT INTO `ab_project_quote` (`id`, `project_id`, `quote_number`, `quote_date`, `total_amount`, `status`, `create_dept`, `create_by`, `update_by`, `create_time`, `update_time`) VALUES (1891408956860420097,1889671609447890945,'xxx','2025-02-21',1000000.00,'pending',103,1,1,'2025-02-17 16:46:51','2025-02-17 16:46:51');
/*!40000 ALTER TABLE `ab_project_quote` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ab_project_site_survey`
--

DROP TABLE IF EXISTS `ab_project_site_survey`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ab_project_site_survey` (
                                          `survey_id` bigint NOT NULL AUTO_INCREMENT COMMENT '踏勘工单ID',
                                          `project_id` bigint DEFAULT NULL COMMENT '项目ID',
                                          `survey_men` bigint DEFAULT NULL COMMENT '踏勘人员',
                                          `import_export` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '进出口类型',
                                          `project_type` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '项目类型',
                                          `project_budget` decimal(18,2) DEFAULT NULL COMMENT '项目预算',
                                          `project_duration` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '项目周期',
                                          `survey_location` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '踏勘地点',
                                          `survey_time` datetime DEFAULT NULL COMMENT '踏勘时间',
                                          `on_site_contact` bigint DEFAULT NULL COMMENT '现场联系人',
                                          `sorter_port_count` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '格口数量',
                                          `is_site_confirmed` varchar(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '是否确定场地',
                                          `drawings_and_plans` varchar(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '图纸与方案',
                                          `ground_condition` varchar(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '地面状态',
                                          `concrete_thickness` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '混凝土厚度(mm)',
                                          `indoor_outdoor_height_difference` varchar(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '室内外是否有高差',
                                          `height_difference` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '高差(mm)',
                                          `platform_width` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '月台宽(mm)',
                                          `has_canopy` varchar(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '四周是否有雨棚',
                                          `canopy_clearance` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '雨棚净空(mm)',
                                          `canopy_width` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '雨棚宽(mm)',
                                          `has_existing_doorway` varchar(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '是否现有门洞',
                                          `doorway_width` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '门洞宽(mm)',
                                          `doorway_height` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '门洞高(mm)',
                                          `surrounding_environment` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci COMMENT '周边环境',
                                          `power_available` varchar(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '现场可提供电力',
                                          `cable_routing` varchar(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '线束走向',
                                          `bridge_capacity` varchar(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '桥架是否有余量',
                                          `capacity_details` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '余量说明',
                                          `has_distribution_cabinet` varchar(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '是否有分线柜',
                                          `has_existing_server_room` varchar(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '是否现有机房',
                                          `fire_safety_modification_required` varchar(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '是否需要进行消防改造',
                                          `average_daily_volume` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '平均袋件/天',
                                          `peak_daily_volume` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '高峰袋件/天',
                                          `work_hours` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '工作时间',
                                          `unloading_port_count` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '卸车口数量',
                                          `direct_loading_ports` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '直连口数量',
                                          `non_direct_loading_ports` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '非直连口数量',
                                          `total_efficiency` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '总效率(袋件/小时)',
                                          `matrix_efficiency` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '矩阵处理效率',
                                          `sorter_efficiency` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '分拣机处理效率',
                                          `special_equipment_required` varchar(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '是否需要异形分拣设备',
                                          `personnel_required` varchar(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '是否需要承接人员',
                                          `create_dept` bigint DEFAULT NULL COMMENT '创建部门',
                                          `create_by` bigint DEFAULT NULL COMMENT '创建人ID',
                                          `update_by` bigint DEFAULT NULL COMMENT '更新人ID',
                                          `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                                          `update_time` datetime DEFAULT NULL COMMENT '更新时间',
                                          PRIMARY KEY (`survey_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1889688561151131651 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC COMMENT='勘探记录';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ab_project_site_survey`
--

LOCK TABLES `ab_project_site_survey` WRITE;
/*!40000 ALTER TABLE `ab_project_site_survey` DISABLE KEYS */;
INSERT INTO `ab_project_site_survey` (`survey_id`, `project_id`, `survey_men`, `import_export`, `project_type`, `project_budget`, `project_duration`, `survey_location`, `survey_time`, `on_site_contact`, `sorter_port_count`, `is_site_confirmed`, `drawings_and_plans`, `ground_condition`, `concrete_thickness`, `indoor_outdoor_height_difference`, `height_difference`, `platform_width`, `has_canopy`, `canopy_clearance`, `canopy_width`, `has_existing_doorway`, `doorway_width`, `doorway_height`, `surrounding_environment`, `power_available`, `cable_routing`, `bridge_capacity`, `capacity_details`, `has_distribution_cabinet`, `has_existing_server_room`, `fire_safety_modification_required`, `average_daily_volume`, `peak_daily_volume`, `work_hours`, `unloading_port_count`, `direct_loading_ports`, `non_direct_loading_ports`, `total_efficiency`, `matrix_efficiency`, `sorter_efficiency`, `special_equipment_required`, `personnel_required`, `create_dept`, `create_by`, `update_by`, `create_time`, `update_time`) VALUES (1889688561151131650,1889671609447890945,1889214017040908289,'0','1',200000.00,'3个月','山西太原','2025-02-21 22:47:26',1,'200','Y','1','0','10','Y','10','10','Y','10','10','Y','10','10','测试环境','Y','0','Y','无余量','Y','N','Y','40000','80000','12小时','10','4','6','2000',NULL,NULL,'Y','N',103,1,1,'2025-02-12 22:50:36','2025-02-12 22:50:36');
/*!40000 ALTER TABLE `ab_project_site_survey` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ab_project_tender_bid_bond`
--

DROP TABLE IF EXISTS `ab_project_tender_bid_bond`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ab_project_tender_bid_bond` (
                                              `bid_id` bigint NOT NULL AUTO_INCREMENT,
                                              `tender_id` bigint NOT NULL COMMENT '投标记录ID',
                                              `bid_bond` decimal(18,2) DEFAULT NULL COMMENT '履约保证金',
                                              `refund_status` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '退还情况',
                                              `refund_date` datetime DEFAULT NULL COMMENT '退还日期',
                                              `remark` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '备注',
                                              `create_dept` bigint DEFAULT NULL COMMENT '创建部门',
                                              `create_by` bigint NOT NULL COMMENT '创建人',
                                              `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                                              `update_by` bigint DEFAULT NULL COMMENT '修改人',
                                              `update_time` datetime DEFAULT NULL COMMENT '修改时间',
                                              PRIMARY KEY (`bid_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1889699620759138307 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC COMMENT='履约保证金记录';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ab_project_tender_bid_bond`
--

LOCK TABLES `ab_project_tender_bid_bond` WRITE;
/*!40000 ALTER TABLE `ab_project_tender_bid_bond` DISABLE KEYS */;
INSERT INTO `ab_project_tender_bid_bond` (`bid_id`, `tender_id`, `bid_bond`, `refund_status`, `refund_date`, `remark`, `create_dept`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (1889699620759138306,1889699620759138306,1000.00,'Y','2025-03-20 14:32:29','xxx',103,1,'2025-02-12 23:34:33',1,'2025-03-11 14:34:12');
/*!40000 ALTER TABLE `ab_project_tender_bid_bond` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ab_project_tender_records`
--

DROP TABLE IF EXISTS `ab_project_tender_records`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ab_project_tender_records` (
                                             `tender_id` bigint NOT NULL AUTO_INCREMENT,
                                             `business_id` bigint NOT NULL COMMENT '商机ID',
                                             `with_equipment` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '是否带设备',
                                             `bidding_method` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '招标方式',
                                             `registration` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '报名单位',
                                             `bid_status` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '中标情况',
                                             `contract_status` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '签约情况',
                                             `tender_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '标书编号',
                                             `tendering_agent` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '招标代理',
                                             `bid_purchase_fee` decimal(18,2) DEFAULT NULL COMMENT '购标费用',
                                             `exploration` bigint DEFAULT NULL COMMENT '勘探人员',
                                             `bid_date` datetime DEFAULT NULL COMMENT '投标时间',
                                             `bid_bond` decimal(18,2) DEFAULT NULL COMMENT '履约保证金',
                                             `refund_status` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '退还情况',
                                             `bid_location` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '投标地点',
                                             `bid_award_notice` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '中标通知方式',
                                             `service_fee` decimal(18,2) DEFAULT NULL COMMENT '服务费',
                                             `remark` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '备注',
                                             `create_dept` bigint DEFAULT NULL COMMENT '创建部门',
                                             `create_by` bigint NOT NULL COMMENT '创建人',
                                             `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                                             `update_by` bigint DEFAULT NULL COMMENT '修改人',
                                             `update_time` datetime DEFAULT NULL COMMENT '修改时间',
                                             PRIMARY KEY (`tender_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1889699620759138307 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC COMMENT='投标记录';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ab_project_tender_records`
--

LOCK TABLES `ab_project_tender_records` WRITE;
/*!40000 ALTER TABLE `ab_project_tender_records` DISABLE KEYS */;
INSERT INTO `ab_project_tender_records` (`tender_id`, `business_id`, `with_equipment`, `bidding_method`, `registration`, `bid_status`, `contract_status`, `tender_name`, `tendering_agent`, `bid_purchase_fee`, `exploration`, `bid_date`, `bid_bond`, `refund_status`, `bid_location`, `bid_award_notice`, `service_fee`, `remark`, `create_dept`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (1889699620759138306,1889671609447890945,'N','1','江苏爱帮','0','Y',NULL,'测试招标代理',2000.00,NULL,'2025-02-13 23:32:46',1000.00,'Y','山西太原','0',1000.00,NULL,103,1,'2025-02-12 23:34:33',1,'2025-02-12 23:34:33');
/*!40000 ALTER TABLE `ab_project_tender_records` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ab_crm_visit`
--

DROP TABLE IF EXISTS `ab_crm_visit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ab_crm_visit` (
                                `visit_id` bigint NOT NULL AUTO_INCREMENT COMMENT '回访id',
                                `visit_topic` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '拜访主题',
                                `visit_content` longblob COMMENT '拜访记录',
                                `visit_type` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '拜访类别 陌拜 回访',
                                `satisfaction` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '满意度',
                                `visit_time` datetime DEFAULT NULL COMMENT '拜访时间',
                                `owner_user_id` bigint DEFAULT NULL COMMENT '拜访人id',
                                `customer_id` bigint DEFAULT NULL COMMENT '客户id',
                                `contacts_id` bigint DEFAULT NULL COMMENT '联系人id',
                                `project_id` bigint DEFAULT NULL COMMENT '项目id',
                                `create_dept` bigint DEFAULT NULL COMMENT '创建部门',
                                `create_by` bigint NOT NULL COMMENT '创建人id',
                                `update_by` bigint DEFAULT NULL COMMENT '更新人id',
                                `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                                `update_time` datetime DEFAULT NULL COMMENT '更新时间',
                                PRIMARY KEY (`visit_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1890333651815190530 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci ROW_FORMAT=DYNAMIC COMMENT='拜访记录\r\n';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ab_crm_visit`
--

LOCK TABLES `ab_crm_visit` WRITE;
/*!40000 ALTER TABLE `ab_crm_visit` DISABLE KEYS */;
INSERT INTO `ab_crm_visit` (`visit_id`, `visit_topic`, `visit_content`, `visit_type`, `satisfaction`, `visit_time`, `owner_user_id`, `customer_id`, `contacts_id`, `project_id`, `create_dept`, `create_by`, `update_by`, `create_time`, `update_time`) VALUES (1889593297235169282,'测试沟通记录',_binary '<p data-start=\"179\" data-end=\"191\"><span style=\"font-size: 10pt; font-family: arial, helvetica, sans-serif;\">1. 项目进展：</span><br><span style=\"font-size: 10pt; font-family: arial, helvetica, sans-serif;\"><strong data-start=\"194\" data-end=\"209\">阶段一：需求分析与规划</strong>：已完成对项目需求的详细调研，并与贵方团队进行了多轮讨论，确保所有需求得到充分理解。</span><br><span style=\"font-size: 10pt; font-family: arial, helvetica, sans-serif;\"><strong data-start=\"254\" data-end=\"269\">阶段二：系统设计与开发</strong>：目前已开始系统的初步设计工作，预计在下周完成设计评审，并进入开发阶段。</span><br><span style=\"font-size: 10pt; font-family: arial, helvetica, sans-serif;\"><strong data-start=\"308\" data-end=\"323\">阶段三：进度与风险管理</strong>：我们已经建立了详细的项目进度表，并采取了风险预防措施，确保项目按期交付。</span><br><span style=\"font-size: 10pt; font-family: arial, helvetica, sans-serif;\">2. 下一步计划：</span><br><span style=\"font-size: 10pt; font-family: arial, helvetica, sans-serif;\"><strong data-start=\"378\" data-end=\"386\">开发阶段</strong>：预计将在下周开始开发工作，重点完成系统的核心功能模块开发。</span><br><span style=\"font-size: 10pt; font-family: arial, helvetica, sans-serif;\"><strong data-start=\"419\" data-end=\"427\">测试阶段</strong>：开发完成后，计划进入系统测试阶段，我们将安排专项团队对系统进行严格的功能与性能测试。</span><br><span style=\"font-size: 10pt; font-family: arial, helvetica, sans-serif;\"><strong data-start=\"473\" data-end=\"481\">上线准备</strong>：项目的最终上线时间预定在两个月后，我们会提前与贵方确认上线计划与相关准备事项。</span></p>','0','Y','2025-02-13 16:31:34',1889212276706738177,1889524772759937026,NULL,1889671609447890945,103,1,1,'2025-02-12 16:32:04','2025-02-15 11:09:42'),(1890332536142909441,'测试主题2',_binary '<p data-start=\"523\" data-end=\"584\">我们非常期待与贵方继续保持紧密合作，并共同推动项目顺利实施。如果您对当前进展有任何疑问或需要进一步讨论的事项，请随时告知。</p>\n<p data-start=\"586\" data-end=\"618\">再次感谢贵方的支持与信任。期待我们能够携手共进，取得更大的成功。</p>\n<p data-start=\"620\" data-end=\"627\">祝您工作愉快！</p>','0','Y','2025-02-15 17:29:23',1889213847330979841,1889524772759937026,NULL,1889671609447890945,103,1,1,'2025-02-14 17:29:32','2025-02-14 17:29:42'),(1890333651815190529,'沟通主题3',_binary '<p><span style=\"font-size: 10pt; font-family: arial, helvetica, sans-serif;\">1. 项目进展：</span></p>\n<p><span style=\"font-size: 10pt; font-family: arial, helvetica, sans-serif;\"><strong data-start=\"194\" data-end=\"209\">阶段一：需求分析与规划</strong>：已完成对项目需求的详细调研，并与贵方团队进行了多轮讨论，确保所有需求得到充分理解。</span></p>\n<p><span style=\"font-size: 10pt; font-family: arial, helvetica, sans-serif;\"><strong data-start=\"254\" data-end=\"269\">阶段二：系统设计与开发</strong>：目前已开始系统的初步设计工作，预计在下周完成设计评审，并进入开发阶段。</span></p>\n<p><span style=\"font-size: 10pt; font-family: arial, helvetica, sans-serif;\"><strong data-start=\"308\" data-end=\"323\">阶段三：进度与风险管理</strong>：我们已经建立了详细的项目进度表，并采取了风险预防措施，确保项目按期交付。</span></p>\n<p><span style=\"font-size: 10pt; font-family: arial, helvetica, sans-serif;\">2. 下一步计划：</span></p>\n<p><span style=\"font-size: 10pt; font-family: arial, helvetica, sans-serif;\"><strong data-start=\"378\" data-end=\"386\">开发阶段</strong>：预计将在下周开始开发工作，重点完成系统的核心功能模块开发。</span></p>\n<p><span style=\"font-size: 10pt; font-family: arial, helvetica, sans-serif;\"><strong data-start=\"419\" data-end=\"427\">测试阶段</strong>：开发完成后，计划进入系统测试阶段，我们将安排专项团队对系统进行严格的功能与性能测试。</span></p>\n<p><span style=\"font-size: 10pt; font-family: arial, helvetica, sans-serif;\"><strong data-start=\"473\" data-end=\"481\">上线准备</strong>：项目的最终上线时间预定在两个月后，我们会提前与贵方确认上线计划与相关准备事项。</span></p>','1','Y','2025-02-22 17:33:48',1889212276706738177,1889524772759937026,NULL,1889671609447890945,103,1,1,'2025-02-14 17:33:58','2025-02-15 11:09:57');
/*!40000 ALTER TABLE `ab_crm_visit` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-08-01 15:23:51
