-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: clinicdb
-- ------------------------------------------------------
-- Server version	8.0.35

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `appointment`
--
CREATE DATABASE clinicdb;
USE clinicdb;
DROP TABLE IF EXISTS appointment;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE appointment (
  id int NOT NULL AUTO_INCREMENT,
  patient_id int NOT NULL,
  doctor_id int NOT NULL,
  appointment_date date NOT NULL,
  reason text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  created_time datetime NOT NULL,
  shift varchar(45) COLLATE utf8mb4_unicode_ci NOT NULL,
  `status` varchar(45) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  confirm_time datetime DEFAULT NULL,
  email_sent tinyint DEFAULT NULL,
  PRIMARY KEY (id),
  KEY fk_appointment_doctor_idx (doctor_id),
  KEY fk_appointment_patient_idx (patient_id),
  CONSTRAINT fk_appointment_doctor FOREIGN KEY (doctor_id) REFERENCES doctor (id),
  CONSTRAINT fk_appointment_patient FOREIGN KEY (patient_id) REFERENCES patient (id) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `appointment`
--

LOCK TABLES appointment WRITE;
/*!40000 ALTER TABLE appointment DISABLE KEYS */;
INSERT INTO appointment VALUES (1,1,8,'2024-06-16','Đau họng','2024-06-15 11:06:48','Sáng','Đã xác nhận','2024-06-15 12:10:03',1),(2,1,8,'2024-06-17','Nhức tai','2024-06-15 16:06:41','Chiều','Chờ xác nhận',NULL,0),(7,1,4,'2024-06-17','Nhức đầu','2024-06-15 16:15:32','Sáng','Chờ xác nhận',NULL,0);
/*!40000 ALTER TABLE appointment ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS category;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE category (
  id int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES category WRITE;
/*!40000 ALTER TABLE category DISABLE KEYS */;
INSERT INTO category VALUES (1,'Kháng sinh'),(2,'Kháng viêm'),(3,'Giảm đau'),(4,'Dị ứng'),(5,'Hạ sốt'),(6,'Tim mạch'),(7,'Tiêu hóa'),(8,'Sát trùng');
/*!40000 ALTER TABLE category ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `doctor`
--

DROP TABLE IF EXISTS doctor;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE doctor (
  id int NOT NULL AUTO_INCREMENT,
  speciality_id int DEFAULT NULL,
  `name` varchar(45) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci NOT NULL,
  gender varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci NOT NULL,
  birthday date NOT NULL,
  phone_number varchar(45) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci NOT NULL,
  email varchar(45) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci NOT NULL,
  user_id int DEFAULT NULL,
  avatar varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci DEFAULT NULL,
  PRIMARY KEY (id),
  UNIQUE KEY user_id_UNIQUE (user_id),
  KEY fk_doctor_speciality_idx (speciality_id),
  KEY fk_user_id_idx (user_id),
  CONSTRAINT fk_doctor_speciality FOREIGN KEY (speciality_id) REFERENCES speciality (id),
  CONSTRAINT fk_user_id FOREIGN KEY (user_id) REFERENCES `user` (id) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `doctor`
--

LOCK TABLES doctor WRITE;
/*!40000 ALTER TABLE doctor DISABLE KEYS */;
INSERT INTO doctor VALUES (4,3,'Nguyễn Thanh Thái','Nam','1983-05-20','0926781294','thanhthai@gmail.com',NULL,'https://res.cloudinary.com/dzktw4gfy/image/upload/v1719102476/male-doctor-avatar_ycecow.jpg'),(8,4,'Tran Minh Ngoc','Nu','1995-12-30','0354218642','minhngoc@gmail.com',NULL,'https://res.cloudinary.com/dzktw4gfy/image/upload/v1719102926/female-doctor-avatar_bo2gcm.jpg'),(11,7,'Vu Ngoc Anh','Nu','1985-09-03','0352315529','ngocanh@gmail.com',NULL,'https://res.cloudinary.com/dzktw4gfy/image/upload/v1719122202/phgiokxdk508xcnwlr17.jpg');
/*!40000 ALTER TABLE doctor ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `medicine`
--

DROP TABLE IF EXISTS medicine;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE medicine (
  id int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `description` varchar(225) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  unit varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  price double NOT NULL,
  quantity int DEFAULT NULL,
  category_id int NOT NULL,
  PRIMARY KEY (id),
  KEY fk_medicine_category_idx (category_id),
  CONSTRAINT fk_medicine_category FOREIGN KEY (category_id) REFERENCES category (id)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medicine`
--

LOCK TABLES medicine WRITE;
/*!40000 ALTER TABLE medicine DISABLE KEYS */;
INSERT INTO medicine VALUES (1,'Ardineclav','Thuốc ArdineClav 500/125 (viên) gồm thành phần Amoxicillin và Acid clavulanic được chỉ định điều trị nhiễm khuẩn hô hấp, da - mô mềm, sinh dục - tiết niệu','gói',12000,11838,1),(2,'Nizastric','Thuốc Nizastric là thuốc điều trị bệnh đường tiêu hóa. Khi sử dụng thuốc Nizastric cần tham khảo tư vấn bác sĩ về tình trạng bệnh và khả năng tương thích với thuốc Nizastric','viên',2499,11831,7),(4,'Amedolfen','Amedolfen có thành phần chính là Flurbiprofen, thuộc nhóm thuốc hạ sốt, giảm đau, chống viêm không steroid (NSAIDs). Thuốc được bào chế dưới dạng viên nén bao phim được sử dụng để điều trị giảm đau, giảm viêm','Viên',4893,44655,3),(5,'Diclofenac','Diclofenac hay diclofenac sodium thường được điều trị viêm khớp mãn tính với tác dụng chính là giảm sưng, giảm viêm. ','Viên',1000,44655,2);
/*!40000 ALTER TABLE medicine ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `medicines_in_prescription`
--

DROP TABLE IF EXISTS medicines_in_prescription;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE medicines_in_prescription (
  id int NOT NULL AUTO_INCREMENT,
  medicine_id int NOT NULL,
  quantity int DEFAULT NULL,
  dosage varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  prescription_id int NOT NULL,
  note varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (id),
  KEY fk_medicines_medicine_idx (medicine_id),
  KEY fk_medicines_prescription_idx (prescription_id),
  CONSTRAINT fk_medicines_medicine FOREIGN KEY (medicine_id) REFERENCES medicine (id),
  CONSTRAINT fk_medicines_prescription FOREIGN KEY (prescription_id) REFERENCES prescription (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medicines_in_prescription`
--

LOCK TABLES medicines_in_prescription WRITE;
/*!40000 ALTER TABLE medicines_in_prescription DISABLE KEYS */;
/*!40000 ALTER TABLE medicines_in_prescription ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nurse`
--

DROP TABLE IF EXISTS nurse;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE nurse (
  id int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci NOT NULL,
  gender varchar(45) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci NOT NULL,
  birthday date NOT NULL,
  phone_number varchar(45) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci NOT NULL,
  email varchar(45) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci NOT NULL,
  user_id int DEFAULT NULL,
  avatar varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci DEFAULT NULL,
  PRIMARY KEY (id),
  UNIQUE KEY user_id_UNIQUE (user_id),
  KEY fk_user_id_idx (user_id),
  CONSTRAINT fk_user_nurse FOREIGN KEY (user_id) REFERENCES `user` (id) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nurse`
--

LOCK TABLES nurse WRITE;
/*!40000 ALTER TABLE nurse DISABLE KEYS */;
INSERT INTO nurse VALUES (1,'Trần Ngọc Trang','Nữ','1993-03-05','0982716592','ngoctrang@gmail.com',5,'https://res.cloudinary.com/dzktw4gfy/image/upload/v1719102926/female-doctor-avatar_bo2gcm.jpg'),(3,'Nguyen Le Xuan','Nu','1998-06-18','0982355216','lexuan@gmail.com',NULL,'https://res.cloudinary.com/dzktw4gfy/image/upload/v1719192766/vexj2ebf5o2bzuwi4egm.jpg'),(4,'Dang Hung Dung','Nam','1995-07-26','0912446275','hungdung@gmail.com',NULL,'https://res.cloudinary.com/dzktw4gfy/image/upload/v1719192851/msmy7taqghwj1rbuyufa.jpg');
/*!40000 ALTER TABLE nurse ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `patient`
--

DROP TABLE IF EXISTS patient;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE patient (
  id int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci NOT NULL,
  gender varchar(45) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci NOT NULL,
  birthday date NOT NULL,
  phone_number varchar(45) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci NOT NULL,
  email varchar(45) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci NOT NULL,
  user_id int DEFAULT NULL,
  avatar varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci DEFAULT NULL,
  PRIMARY KEY (id),
  UNIQUE KEY user_id_UNIQUE (user_id),
  KEY fk_user_patient_idx (user_id),
  CONSTRAINT fk_user_patient FOREIGN KEY (user_id) REFERENCES `user` (id) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patient`
--

LOCK TABLES patient WRITE;
/*!40000 ALTER TABLE patient DISABLE KEYS */;
INSERT INTO patient VALUES (1,'Bùi Quang Lan','Nữ','1975-08-15','0372183291','quanglan@gmail.com',6,NULL);
/*!40000 ALTER TABLE patient ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `payment_method`
--

DROP TABLE IF EXISTS payment_method;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE payment_method (
  id int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payment_method`
--

LOCK TABLES payment_method WRITE;
/*!40000 ALTER TABLE payment_method DISABLE KEYS */;
INSERT INTO payment_method VALUES (1,'Tiền mặt'),(2,'Momo'),(3,'Zalo Pay');
/*!40000 ALTER TABLE payment_method ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `prescription`
--

DROP TABLE IF EXISTS prescription;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE prescription (
  id int NOT NULL AUTO_INCREMENT,
  symptoms varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  diagnosis varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  appointment_id int NOT NULL,
  note varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  created_date datetime NOT NULL,
  PRIMARY KEY (id),
  KEY fk_prescription_appointment_idx (appointment_id),
  CONSTRAINT fk_prescription_appointment FOREIGN KEY (appointment_id) REFERENCES appointment (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prescription`
--

LOCK TABLES prescription WRITE;
/*!40000 ALTER TABLE prescription DISABLE KEYS */;
/*!40000 ALTER TABLE prescription ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `receipt`
--

DROP TABLE IF EXISTS receipt;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE receipt (
  id int NOT NULL AUTO_INCREMENT,
  appointment_id int NOT NULL,
  medical_cost double DEFAULT NULL,
  medicine_cost double DEFAULT NULL,
  payment_method_id int DEFAULT NULL,
  payment_time datetime DEFAULT NULL,
  nurse_id int NOT NULL,
  PRIMARY KEY (id),
  KEY fk_receipt_appointment_idx (appointment_id),
  KEY fk_receipt_payment_method_idx (payment_method_id),
  KEY fk_receipt_nurse_idx (nurse_id),
  CONSTRAINT fk_receipt_appointment FOREIGN KEY (appointment_id) REFERENCES appointment (id),
  CONSTRAINT fk_receipt_nurse FOREIGN KEY (nurse_id) REFERENCES nurse (id) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT fk_receipt_payment_method FOREIGN KEY (payment_method_id) REFERENCES payment_method (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `receipt`
--

LOCK TABLES receipt WRITE;
/*!40000 ALTER TABLE receipt DISABLE KEYS */;
/*!40000 ALTER TABLE receipt ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `schedule`
--

DROP TABLE IF EXISTS schedule;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `schedule` (
  id int NOT NULL AUTO_INCREMENT,
  work_date date NOT NULL,
  shift varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  note varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `schedule`
--

LOCK TABLES schedule WRITE;
/*!40000 ALTER TABLE schedule DISABLE KEYS */;
/*!40000 ALTER TABLE schedule ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `schedule_doctor`
--

DROP TABLE IF EXISTS schedule_doctor;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE schedule_doctor (
  id int NOT NULL AUTO_INCREMENT,
  schedule_id int NOT NULL,
  doctor_id int NOT NULL,
  PRIMARY KEY (id),
  KEY fk_schedule_idx (schedule_id),
  KEY fk_doctor_idx (doctor_id),
  CONSTRAINT fk_doctor FOREIGN KEY (doctor_id) REFERENCES doctor (id),
  CONSTRAINT fk_schedule_doctor FOREIGN KEY (schedule_id) REFERENCES `schedule` (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `schedule_doctor`
--

LOCK TABLES schedule_doctor WRITE;
/*!40000 ALTER TABLE schedule_doctor DISABLE KEYS */;
/*!40000 ALTER TABLE schedule_doctor ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `schedule_nurse`
--

DROP TABLE IF EXISTS schedule_nurse;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE schedule_nurse (
  id int NOT NULL AUTO_INCREMENT,
  schedule_id int NOT NULL,
  nurse_id int NOT NULL,
  PRIMARY KEY (id),
  KEY fk_schedule_idx (schedule_id),
  KEY fk_nurse_idx (nurse_id),
  CONSTRAINT fk_nurse FOREIGN KEY (nurse_id) REFERENCES nurse (id) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT fk_schedule_nurse FOREIGN KEY (schedule_id) REFERENCES `schedule` (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `schedule_nurse`
--

LOCK TABLES schedule_nurse WRITE;
/*!40000 ALTER TABLE schedule_nurse DISABLE KEYS */;
/*!40000 ALTER TABLE schedule_nurse ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `speciality`
--

DROP TABLE IF EXISTS speciality;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE speciality (
  id int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci NOT NULL,
  `description` text CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci,
  image varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `speciality`
--

LOCK TABLES speciality WRITE;
/*!40000 ALTER TABLE speciality DISABLE KEYS */;
INSERT INTO speciality VALUES (1,'Tim mạch','Chuyên khoa Tim mạch tập trung vào việc chẩn đoán và điều trị các bệnh liên quan đến tim và hệ tuần hoàn. Các bác sĩ tim mạch điều trị các tình trạng như bệnh mạch vành, suy tim, loạn nhịp tim, và tăng huyết áp. Các phương pháp chẩn đoán thường sử dụng bao gồm điện tâm đồ (ECG), siêu âm tim và chụp mạch vành.','https://res.cloudinary.com/dgcezbyyd/image/upload/v1719334129/tim-mach_zja4la.jpg'),(2,'Hô hấp','Chuyên khoa Hô hấp chuyên về các bệnh liên quan đến hệ hô hấp, bao gồm phổi và đường hô hấp. Các bác sĩ chuyên khoa này điều trị các bệnh như viêm phổi, hen suyễn, bệnh phổi tắc nghẽn mãn tính (COPD), và lao phổi. Các phương pháp chẩn đoán bao gồm đo chức năng hô hấp, X-quang phổi, và CT scan phổi.','https://res.cloudinary.com/dgcezbyyd/image/upload/v1719334128/noi-ho-hap-1031x800-1_jdo0pw.jpg'),(3,'Thần kinh','Chuyên khoa Thần kinh tập trung vào việc chẩn đoán và điều trị các bệnh liên quan đến hệ thần kinh, bao gồm não, tủy sống, và các dây thần kinh ngoại biên. Các bác sĩ thần kinh điều trị các tình trạng như đột quỵ, động kinh, Parkinson, đau đầu, và bệnh Alzheimer. Các phương pháp chẩn đoán thường sử dụng bao gồm MRI, CT scan, và điện não đồ (EEG).','https://res.cloudinary.com/dgcezbyyd/image/upload/v1719334128/noi-than-kinh-mobile_wvquzv.jpg'),(4,'Tai mũi họng','Chuyên khoa Tai Mũi Họng chuyên về các bệnh và rối loạn liên quan đến tai, mũi, họng, cũng như các cấu trúc liên quan ở đầu và cổ. Các bác sĩ tai mũi họng điều trị các bệnh như viêm tai giữa, viêm xoang, viêm họng, và các vấn đề về giọng nói. Các phương pháp chẩn đoán thường sử dụng bao gồm nội soi, đo thính lực và chụp CT.','https://res.cloudinary.com/dgcezbyyd/image/upload/v1719334127/benh-tai-mui-hong-1-1711337446518_f759yn.jpg'),(5,'Ung bướu','Chuyên khoa ung bướu chuyên nghiên cứu, chẩn đoán và điều trị các loại ung thư. Các bác sĩ trong lĩnh vực này xác định loại và giai đoạn ung thư, sau đó đề xuất phác đồ điều trị như phẫu thuật, hóa trị, và xạ trị. Ngoài ra, chuyên khoa còn tập trung vào việc nâng cao chất lượng cuộc sống cho bệnh nhân và nghiên cứu các phương pháp điều trị mới.','https://res.cloudinary.com/dgcezbyyd/image/upload/v1719450882/ung_thu_tuyen_giap_the_nhu_la_gi_phuong_phap_phong_va_dieu_tri_benh_1_78c960e99d_f8iv8n.webp'),(6,'Tiêu hóa','Chuyên khoa Tiêu hóa chuyên về các bệnh lý liên quan đến hệ tiêu hóa, bao gồm dạ dày, ruột, gan, và tụy. Các bác sĩ tiêu hóa điều trị các bệnh như viêm loét dạ dày, hội chứng ruột kích thích, viêm gan, và bệnh Crohn. Các phương pháp chẩn đoán thường sử dụng bao gồm nội soi dạ dày, nội soi đại tràng và siêu âm bụng.','https://res.cloudinary.com/dgcezbyyd/image/upload/v1719334129/tieu-hoa_kfpfnd.jpg'),(7,'Thận','Chuyên khoa Thận tập trung vào việc chẩn đoán và điều trị các bệnh lý liên quan đến thận và hệ tiết niệu. Các bác sĩ thận điều trị các bệnh như suy thận, viêm cầu thận, sỏi thận và tăng huyết áp liên quan đến thận. Các phương pháp chẩn đoán bao gồm xét nghiệm máu, xét nghiệm nước tiểu, siêu âm thận và sinh thiết thận.','https://res.cloudinary.com/dgcezbyyd/image/upload/v1719334128/than_osv1ru.jpg'),(8,'Nội tiết','Chuyên khoa Nội tiết chuyên về các bệnh lý liên quan đến hệ thống nội tiết và các tuyến hormone, như tuyến giáp, tuyến thượng thận, tuyến tụy và tuyến yên. Các bác sĩ nội tiết điều trị các bệnh như tiểu đường, suy giáp, cường giáp, và các rối loạn hormone khác. Các phương pháp chẩn đoán bao gồm xét nghiệm máu, siêu âm tuyến giáp và các xét nghiệm chức năng hormone.\n\n\n\n\n\n\n','https://res.cloudinary.com/dgcezbyyd/image/upload/v1719334128/noi-tiet_hdohbt.jpg');
/*!40000 ALTER TABLE speciality ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS user;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  id int NOT NULL AUTO_INCREMENT,
  username varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `password` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  user_role varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES user WRITE;
/*!40000 ALTER TABLE user DISABLE KEYS */;
INSERT INTO user VALUES (3,'admin','$2a$10$5X9k5N1sTc1/CjVH5XJoje3QMYijH3ETpgkox00R0MdPaJPPrf7wO','ROLE_ADMIN'),(4,'doctor1','$2a$10$5X9k5N1sTc1/CjVH5XJoje3QMYijH3ETpgkox00R0MdPaJPPrf7wO','ROLE_DOCTOR'),(5,'nurse1','$2a$10$5X9k5N1sTc1/CjVH5XJoje3QMYijH3ETpgkox00R0MdPaJPPrf7wO','ROLE_NURSE'),(6,'patient1','$2a$10$5X9k5N1sTc1/CjVH5XJoje3QMYijH3ETpgkox00R0MdPaJPPrf7wO','ROLE_PATIENT');
/*!40000 ALTER TABLE user ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-06-27 12:09:36
