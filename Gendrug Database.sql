-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 28, 2019 at 12:51 PM
-- Server version: 10.1.36-MariaDB
-- PHP Version: 7.2.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `gendrug`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `Admin_id` int(10) NOT NULL,
  `Admin_uname` varchar(20) NOT NULL,
  `Admin_pass` varchar(100) NOT NULL,
  `Admin_email` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`Admin_id`, `Admin_uname`, `Admin_pass`, `Admin_email`) VALUES
(1, 'vrajesh', '9409288425', 'trivedi.vrajesh008@gmail.com'),
(2, 'atul', '2329', 'atuljose123@gmail.com'),
(3, 'moxita', '1912', 'moxitashah19@gmail.com');

-- --------------------------------------------------------

--
-- Table structure for table `areadetails`
--

CREATE TABLE `areadetails` (
  `Area_id` int(6) NOT NULL,
  `Area_name` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `branddetails`
--

CREATE TABLE `branddetails` (
  `Brand_id` int(6) NOT NULL,
  `Brand_name` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `categorydetails`
--

CREATE TABLE `categorydetails` (
  `Categ_id` int(6) NOT NULL,
  `Categ_name` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `categorydetails`
--

INSERT INTO `categorydetails` (`Categ_id`, `Categ_name`) VALUES
(1, 'Injection'),
(2, 'Capsules'),
(3, 'Syrup'),
(4, 'Tablets'),
(5, 'Lozenges'),
(6, 'Cream');

-- --------------------------------------------------------

--
-- Table structure for table `deliverymandetails`
--

CREATE TABLE `deliverymandetails` (
  `Deliveryman_id` int(6) NOT NULL,
  `Deliveryman_name` text NOT NULL,
  `Deliveryman_address` varchar(160) NOT NULL,
  `Deliveryman_phnum` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `feedback`
--

CREATE TABLE `feedback` (
  `Feedback_id` int(6) NOT NULL,
  `Feedback` varchar(160) NOT NULL,
  `Feedback_date` date NOT NULL,
  `Feedback_status` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `medicinedetails`
--

CREATE TABLE `medicinedetails` (
  `P_id` int(6) NOT NULL,
  `P_name` varchar(100) NOT NULL,
  `P_details` varchar(2000) NOT NULL,
  `P_category` varchar(20) NOT NULL,
  `P_price` int(10) NOT NULL,
  `P_stock` int(10) NOT NULL,
  `P_photo` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `medicinedetails`
--

INSERT INTO `medicinedetails` (`P_id`, `P_name`, `P_details`, `P_category`, `P_price`, `P_stock`, `P_photo`) VALUES
(1, 'Humstard 3', '\r\nInsulin is a naturally occurring hormone made by the pancreas that helps our body use or store blood glucose (sugar) it gets from food. For people with diabetes, either the pancreas does not make enough insulin to meet the body\'s requirements, or the body cannot properly use the insulin that is made. As a result, glucose cannot be used or stored properly and accumulates in the bloodstream. Insulin injected under the skin helps to lower blood glucose levels.', 'Injection', 110, 40, 'upload/humstard.jpg'),
(2, 'AL TOTAL ', '1 AL Total Syrup is an antihistamine which works by blocking the action of histamine in the body. It is used for relieving symptoms of sinus pressure, sinus congestion, runny nose, itching of the throat and nose, watery eyes, and sneezing due to upper respiratory infections, hay fever and allergies.', 'Syrup', 45, 150, 'upload/1-Al-Total-syrup-1.png'),
(3, 'FERCEE TR ', 'Fercee Tr Capsule is used for Iron deficiency anaemia, Anaemia, Spina bifida in an unborn fetus, Treatment of anemias of nutritional origin, Pregnancy, Infancy, Or childhood, Iron deficiency anemia, Treatment of megaloblastic anemias due to a deficiency of folic acid, Diarrhea, Wilson\'s disease, Acne, Age related vision loss and other conditions. Fercee Tr Capsule may also be used for purposes not listed in this medication guide.', 'Tablets', 14, 50, 'upload/fercee-tr-capsules-500x500.jpg'),
(4, 'TUSQ DX CO', 'Tusq Dx Syrup is an antihistamine which works by blocking the action of histamine in the body. It is used for relieving symptoms of sinus pressure, sinus congestion, runny nose, itching of the throat and nose, watery eyes, and sneezing due to upper respiratory infections, hay fever and allergies.\r\n\r\n', 'Syrup', 70, 50, 'upload/tusq-dx-liq-100ml-250x250.jpg'),
(5, 'AMLIP 2.5MG', 'Amlip 2.5 MG Tablet is used to treat high blood pressure and other heart complications. The medicine should be taken in conjunction with a proper diet and regular exercise. It is also used in managing chest pain.\r\n', 'Tablets', 7, 45, 'upload/050217-172838_AMLIP 2.5MG TABLET-Genericwala.com.jpg'),
(6, 'GEOFIT MEN', '\r\nGeofit Capsule is used for Leg pain due to blocked arteries, Chest pain, High blood pressure, Tissue repairing, Rapid weight loss, Heart attack, Biotin deficiency, Skin and hair growth, Weak nails, Healthy nervous system and bone marrow maintenance and other conditions. Geofit Capsule may also be used for purposes not listed in this medication guide', 'Capsules', 45, 75, 'upload/050217-163306_Geofit-Men12.jpg'),
(7, 'MECOFOL PL', '\r\nMecofol Plus Nf Capsule is used for Pain in extremities, Adjunct therapy in severe muscle tightness, Diabetic polyneuropathy, Decrease in muscle mass, Weight loss, High cholesterol, Eye diseases, Low haemoglobin, Loss of sensation, Clogged arteries and other conditions. Mecofol Plus Nf Capsule may also be used for purposes not listed in this medication guide.', 'Capsules', 48, 110, 'upload/yjftmwlb5zhz56tqy3fi.webp'),
(8, 'OKACET 10MG', '\r\nOkacet 10 MG Tablet is a very effective and potent medication to treat allergic symptoms associated with Rhinitis and Utricaria. Allergies such as runny nose, watery eyes, sneezing, skin itching and hives can be effectively treated with this medicine.\r\n', 'Tablets', 5, 150, 'upload/304016.jpg'),
(9, 'ACEBROBID ', 'Acebrobid 100 MG Capsule is an effective bronchodilator medicine used to treat blockage, swelling, and irritation associated with bronchial asthma and chronic obstructive pulmonary disease (COPD) in adults.', 'Capsules', 66, 45, 'upload/xvp9f4dhxaxyhmzew224.webp'),
(10, ' Acebrobid', 'Bayace 100 MG Capsule is an effective bronchodilator medicine used to treat blockage, swelling, and irritation associated with bronchial asthma and chronic obstructive pulmonary disease (COPD) in adults.', 'Capsules', 107, 47, 'upload/5222fdde02f60b40cbdb7bb8f1e9469e63dc68ef1.JPG'),
(11, 'ALKOF 100M', 'Alkof Junior Syrup is used for Temporarily relief of cough caused by common cold, Flu, Or other conditions, Runny nose, Painful cough, Hay fever, Dry cough, Nasal decongestant, Common cold, Colds, Sneezing i itching, Chill and other conditions. Alkof Junior Syrup may also be used for purposes not listed in this medication guide.', 'Syrup', 37, 120, 'upload/alkof-junior-1406057056-10007587.JPG'),
(12, ' ALLERCET ', 'Allercet 10 MG Tablet is a very effective and potent medication to treat allergic symptoms associated with Rhinitis and Utricaria. Allergies such as runny nose, watery eyes, sneezing, skin itching and hives can be effectively treated with this medicine.', 'Tablets', 14, 55, 'upload/4cc58b7c61f9e66cec6b6f34022dd8c48fb4a30d1.JPG'),
(13, 'APETIZ-4MG', '\r\nApetiz 4Mg Tablet is an antihistamine used to relieve allergy symptoms caused by seasonal allergies, food or blood such as watery eyes, sneezing, runny nose or itching eyes or nose. It works by blocking natural substances like serotonin and histamine that your body makes during an allergic reaction. It also treats mild, uncomplicated hives.', 'Tablets', 9, 75, 'upload/khtbivv8ob1qmm98kg9q.webp'),
(14, 'BENADRYL 1', '\r\nBenadryl DR Syrup is used to relieve the cough caused by common cold. This medicine is not recommended for use in children less than 4 years of age. Consumption of alcohol is not advised while receiving this medicine due to an increase in the risk of drowsiness. It is not used to relieve a cough which is caused by smoking and asthma.', 'Syrup', 85, 150, 'upload/13778.jpg'),
(15, ' BIOCHEMDR', '\r\nIt is essentially an organic compound that can be used as an additive in many drugs to relieve excessive coughing and sore throat. It is known to be a muscle relaxant, has cooling properties and helps to reduce spasms. Additionally, it is also used as an analgesic to treat problems like headaches, sprains and other such minor pains.', 'Syrup', 21, 55, 'upload/images.jpg'),
(16, ' BIODEXONE', '\r\nBiodexone Injection is used for Allergic conditions, Dermatologic diseases, Gastrointestinal diseases, Endocrine disorders, Hematologic disorders, Neoplastic diseases, Ophthalmic diseases, Renal diseases, Respiratory diseases, Rheumatic disorders and other conditions. Biodexone Injection may also be used for purposes not listed in this medication guide', 'Injection', 6, 60, 'upload/dexamethasone-acetate-injection-500x500.jpg'),
(17, 'BREATHWELL', 'Easi Breathe Capsule is used for Warts, Asthma, Blockage in nasal passages, Cough, Back pain, Pain and other conditions. Easi Breathe Capsule may also be used for purposes not listed in this medication guide. ... Affecting the signals in the brain that trigger cough reflex.', 'Capsules', 6, 150, 'upload/easi-breathe-softgel-capsules-500x500.png'),
(18, 'CHESTON CO', 'An antihistamine, Cheston Cold Syrup is a medication that can be used for treating allergic symptoms like itching, sneezing, runny nose and watery eyes. It is also effective to treat swelling or itching that is caused by hives. The chemical known as histamine is the reason for the allergic symptoms that you suffer from. Being an antihistamine, Cheston Cold Syrup reduces or blocks this chemical in your body, thus reliving you from the symptoms. This medicine can reduce your symptoms, but not prevent it. You can take this medicine in the form of tablets, capsule or syrup. You can take this medicine along with your food or without it.', 'Syrup', 27, 150, 'upload/det58z3eopuockdo5up0.webp'),
(20, 'FEXODER 12', 'This medication is an antihistamine, prescribed for seasonal allergic reactions such as runny nose, sneezing, red, itchy, or watery eyes; itching. It blocks histamines action, which reduces allergy symptoms. Fexofenadine lowers or stops the bodys reaction to the allergen.', 'Tablets', 46, 150, 'upload/image.jpg'),
(21, 'MUCOLITE-S', 'Mucolite 75 mg Capsule SR is a mucolytic agent which reduces the thickness of the sputum. It is used to treat conditions with abnormal mucus secretion, allowing the patient to breathe freely and deeply. It should be used with caution in patients with a known history of gastric ulcers.', 'Capsules', 68, 50, 'upload/e3d8e49d7bd6066ba81e39b446fcba61a8a15b721.JPG'),
(22, 'TRICORT 40', 'Tricort 40 mg Injection is a corticosteroid which is used to relieve symptoms such as swelling and pain in various conditions such as arthritis, skin disorders, and allergic disorders. The topical form of this medicine is used to treat symptoms such as redness, itching and swelling associated with various skin disorders such as eczema and dermatitis. This medicine should be used with caution in patients with diabetes and liver and kidney diseases.', 'Injection', 88, 150, 'upload/1be033f8325ad5881373cf3597c3dd59ceea5a561.jpg'),
(23, 'TUSQ D ORA', 'Tusq-D Cough Lozenges Honey Lemon is an antiseptic used in the treatment of infections of the mouth and throat such as throat infection, throat discomfort, mouth infection and other related conditions. It is an active pharmaceutical ingredient in Strepsils, CÄ“pacol, Gorpils and Lorsept throat lozenges. It works by killing the bacteria that affects or grows during mouth and throat infections. Before taking this medication talk to your doctor about all the medication you are on as well as your medical history and all your allergies you have.', 'Lozenges', 35, 150, 'upload/398254.jpg'),
(24, ' ACAMPROL ', '\r\nAcamprol 333mg Tablet is used with proper counseling for people dealing with alcoholism. It helps reduce alcohol dependency of people. It works by repairing the chemical balance in the brain. It is advised to not use this medication while still drinking alcohol.', 'Tablets', 54, 55, 'upload/acemprol-tablet-250x250.jpg'),
(25, 'AFENAK 100', 'Afenak 100 MG Tablet is used to relieve pain in the conditions like Osteoarthritis, Rheumatoid Arthritis, and Ankylosing Spondylitis. Do not take this medicine if you have any bleeding disorder, asthma or have a known allergy.', 'Tablets', 11, 55, 'upload/050217-172838_AMLIP 2.5MG TABLET-Genericwala.com.jpg'),
(26, 'DEXASONE 4', 'Dexona 4 MG Injection is similar to the steroidal hormone produced by the adrenal glands. It is used to treat internal and external swelling associated with diseases like asthma, colitis, arthritis, severe skin allergies etc. It is also used for other conditions like adrenal hormonal insufficiency, certain types of anemia, cerebral edema etc.', 'Injection', 5, 50, 'upload/143542f0c70debbfeda6665087453d9d4f76fdd61.JPG'),
(27, 'DOLO 650MG', 'Dolo 650 MG Tablet is used to temporarily relieve fever and mild to moderate pain such as muscle ache, headache, toothache, arthritis, and backache. This medicine should be used with caution in patients with liver diseases due to the increased risk of severe adverse effects.', 'Tablets', 26, 250, 'upload/94d778789dcce4f52ebcb561ae0c496b1e2303c51.jpg'),
(28, 'Hifenac 10', '\r\nHifenac 100 MG Tablet is used to relieve pain in the conditions like Osteoarthritis, Rheumatoid Arthritis, and Ankylosing Spondylitis. Do not take this medicine if you have any bleeding disorder, asthma or have a known allergy.', 'Tablets', 33, 150, 'upload/khtbivv8ob1qmm98kg9q.webp'),
(29, 'MOX 500 MG', 'Mox 500 MG Capsule is an antibiotic that is used for treating a wide variety of bacterial infections of the lungs and airways, middle ear, sinuses, skin, urinary tract, etc. This medicine is not recommended for treating a common cold, flu, or other viral infections since it is not effective in treating these infections.', 'Capsules', 87, 50, 'upload/ea43bdc1c1c605634630733b9e388442cbaf54f61.JPG'),
(30, 'MUCINAC 60', 'Mucinac 600 mg Tablet is a mucolytic agent which reduces the thickness of the sputum. It is used to relieve chest congestion caused by thick or abnormal mucous secretion in patients with lung diseases such as bronchitis, asthma, emphysema, etc. It is also used as an antidote for paracetamol poisoning.', 'Tablets', 198, 50, 'upload/mucinac-1406055567-10001782.jpg'),
(31, 'RECOPRESS', 'Recopress 500 mg Tablet is used to treat chronic alcoholism. It discourages the use of alcohol even in small amounts by causing unpleasant effects such as flushing of the face, vomiting, breathing difficulty, sweating, choking, and anxiety. These effects may start 10 minutes after consumption of alcohol and last for about 1 hour. This medicine only discourages drinking alcohol and is not a cure for alcoholism.', 'Tablets', 39, 50, 'upload/disulfiram-500-mg-tab-500x500.jpg'),
(32, 'NICOFAX-3MG TABLET', 'ppet from the web\r\nAcenocoumarol (also called nicoumalone) is used to prevent and treat harmful blood clots, reducing the risk of a stroke or heart attack. This medication helps to keep blood flowing smoothly in your body by decreasing the amount of clotting proteins in the blood.\r\n', 'Tablets', 62, 50, 'upload/acecouramol-4-mg-500x500.jpg'),
(33, ' REVLAMER 800 MG TABLET', 'Revlamer 800 MG Tablet is used to lower the elevated phosphate levels in the blood by preventing its absorption in the intestine. It is used in severe kidney disease patients. Do not take this medicine if you have any gastrointestinal diseases.', 'Tablets', 114, 50, 'upload/revlamer-800mg-tablet-500x500.jpg'),
(34, 'GABA-N TABLET', 'gaba N Tablet is a prescriptive drug primarily used to prevent seizures. It belongs to a class of drugs called anticonvulsants. Aside from seizures, Biggaba N Tablet is also used to cure hot flashes, restless legs syndrome (RLS) and postherpetic neuralgia. It treats nerve pain in adults by affecting the chemicals and nerve responsible for these pains and seizures. Biggaba N Tablet is found in capsule, tablet or solution form and can be used in combination with other drugs. Another brand of this medicine is Neurontin which can be given to both adults and children (at least three years of age). Although the same kind, do not substitute one for the other, only use the brand that has been specified by your doctor.', 'Tablets', 66, 50, 'upload/123.jpg'),
(35, 'DEBIFALL TABLET', 'Gliclazide + Metformin is a combination of two antidiabetic medicines: Gliclazide + Metformin1 and Gliclazide + Metformin2. Gliclazide + Metformin1 is a sulfonylurea which works by increasing the amount of insulin released by the pancreas in order to lower the blood glucose. Gliclazide + Metformin2 is a biguanide which works by lowering glucose production in the liver, delaying glucose absorption from intestines and increasing the body\'s sensitivity to insulin.', 'Tablets', 41, 50, 'upload/1234.png'),
(36, 'AQUAZIDE-12.5MG TABLET', 'Aquazide 12.5 mg Tablet is a diuretic, which is used to control high blood pressure and edema. It should be used with caution in patients with severe kidney disease. Frequent monitoring of blood pressure and electrolytes level is necessary while taking this medicine.', 'Tablets', 9, 50, 'upload/12345.jpg'),
(37, 'COVERSYL PLUS TABLET', 'Coversyl Plus Tablet is an ACE inhibitor, which is used for treating high blood pressure. It is also used for treatment of heart failure and heart attacks. High blood pressure if not treated can be fatal and can cause serious medical issues like heart attack, heart failure, stroke, kidney failure, loss of vision and even damage to the brain. Coversyl Plus Tablet tablet is generally taken once or twice a day, but consult your doctor regarding the right dosage.', 'Tablets', 144, 50, 'upload/23.jpg'),
(38, 'ACUTRET 10MG TABLET', 'Acutret 10 MG Capsule is a naturally occurring derivative of vitamin A and is used for the treatment of severe acne (nodular) non-responsive to other therapies.', 'Tablets', 145, 50, 'upload/24.jpg'),
(39, 'ELOSONE HT 15GM CREAM', 'This medicine is used to treat a skin condition called melasma. (dark spots on facial skin, especially on the cheeks and forehead).This condition usually happens with hormone changes) & to treat dermatitis which is a condition brought on by the skin reacting to other agents e.g. detergents, causing the skin to become red and itchy.', 'Cream', 107, 50, 'upload/25.jpeg'),
(40, 'Malarone Tablets', 'This medication contains 2 medicines: atovaquone and proguanil. It is used to prevent and treat malaria caused by mosquito bites in countries where malaria is common. Malaria parasites can enter the body through these mosquito bites, and then live in body tissues such as red blood cells or the liver. This medication is used to kill the malaria parasites living inside red blood cells and other tissues. In some cases, you may need to take a different medication (such as primaquine) to complete your treatment. Both medications may be needed for a complete cure and to prevent the return of infection (relapse). Atovaquone/proguanil belongs to a class of drugs known as antimalarials.', 'Tablets', 360, 150, 'upload/40.jpg');

-- --------------------------------------------------------

--
-- Table structure for table `orderdetails`
--

CREATE TABLE `orderdetails` (
  `Order_id` int(6) NOT NULL,
  `Order_quantity` int(10) NOT NULL,
  `Order_amount` int(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `prescriptiondetails`
--

CREATE TABLE `prescriptiondetails` (
  `Pres_id` int(6) NOT NULL,
  `Pres_bname` varchar(200) NOT NULL,
  `Pres_gname` varchar(200) NOT NULL,
  `Pres_details` varchar(200) NOT NULL,
  `Pres_price` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `prescriptiondetails`
--

INSERT INTO `prescriptiondetails` (`Pres_id`, `Pres_bname`, `Pres_gname`, `Pres_details`, `Pres_price`) VALUES
(1, 'Fosamax', 'alendronate', 'Alendronate is used to prevent and treat certain types of bone loss (osteoporosis) in adults. Osteoporosis causes bones to become thinner and break more easily.', 104),
(2, 'Glucophage', 'metformin', 'Metformin is used with a proper diet and exercise program and possibly with other medications to control high blood sugar. It is used in patients with type 2 diabetes. Controlling high blood sugar hel', 105);

-- --------------------------------------------------------

--
-- Table structure for table `prescriptioninsert`
--

CREATE TABLE `prescriptioninsert` (
  `Pinsert_id` int(11) NOT NULL,
  `Pinsert_name` varchar(200) NOT NULL,
  `Pinsert_photo` varchar(200) NOT NULL,
  `Pinsert_email` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `shippingstatus`
--

CREATE TABLE `shippingstatus` (
  `Shipping_id` int(6) NOT NULL,
  `Shipping_status` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `supplierdetails`
--

CREATE TABLE `supplierdetails` (
  `Supp_id` int(6) NOT NULL,
  `Supp_name` text NOT NULL,
  `Supp_add` varchar(160) NOT NULL,
  `Supp_phnum` varchar(20) NOT NULL,
  `Supp_stock` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `symptomdetails`
--

CREATE TABLE `symptomdetails` (
  `Symp_id` int(6) NOT NULL,
  `Symp_name` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `userregistration`
--

CREATE TABLE `userregistration` (
  `U_id` int(6) NOT NULL,
  `U_name` text NOT NULL,
  `Gender` text NOT NULL,
  `DOB` varchar(20) NOT NULL,
  `Phonenum` varchar(20) NOT NULL,
  `Email` varchar(30) NOT NULL,
  `Password` varchar(30) NOT NULL,
  `Conpassword` varchar(30) NOT NULL,
  `Address` varchar(160) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `userregistration`
--

INSERT INTO `userregistration` (`U_id`, `U_name`, `Gender`, `DOB`, `Phonenum`, `Email`, `Password`, `Conpassword`, `Address`) VALUES
(1, 'Vrajesh Trivedi', 'Male', '1997-08-25', '9409288425', 'trivedi.vrajesh007@gmail.com', '9409288425', '9409288425', '15, Government servant society, Opposite Municipal Market, C.G road.'),
(2, 'Atul Jose', 'male', '29/01/1998', '9537914451', 'atuljose123@gmail.com', '2329', '123456789', 'Sabarmati');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`Admin_id`);

--
-- Indexes for table `areadetails`
--
ALTER TABLE `areadetails`
  ADD PRIMARY KEY (`Area_id`);

--
-- Indexes for table `branddetails`
--
ALTER TABLE `branddetails`
  ADD PRIMARY KEY (`Brand_id`);

--
-- Indexes for table `categorydetails`
--
ALTER TABLE `categorydetails`
  ADD PRIMARY KEY (`Categ_id`);

--
-- Indexes for table `deliverymandetails`
--
ALTER TABLE `deliverymandetails`
  ADD PRIMARY KEY (`Deliveryman_id`);

--
-- Indexes for table `feedback`
--
ALTER TABLE `feedback`
  ADD PRIMARY KEY (`Feedback_id`);

--
-- Indexes for table `medicinedetails`
--
ALTER TABLE `medicinedetails`
  ADD PRIMARY KEY (`P_id`);

--
-- Indexes for table `orderdetails`
--
ALTER TABLE `orderdetails`
  ADD PRIMARY KEY (`Order_id`);

--
-- Indexes for table `prescriptiondetails`
--
ALTER TABLE `prescriptiondetails`
  ADD PRIMARY KEY (`Pres_id`);

--
-- Indexes for table `prescriptioninsert`
--
ALTER TABLE `prescriptioninsert`
  ADD PRIMARY KEY (`Pinsert_id`);

--
-- Indexes for table `shippingstatus`
--
ALTER TABLE `shippingstatus`
  ADD PRIMARY KEY (`Shipping_id`);

--
-- Indexes for table `supplierdetails`
--
ALTER TABLE `supplierdetails`
  ADD PRIMARY KEY (`Supp_id`);

--
-- Indexes for table `symptomdetails`
--
ALTER TABLE `symptomdetails`
  ADD PRIMARY KEY (`Symp_id`);

--
-- Indexes for table `userregistration`
--
ALTER TABLE `userregistration`
  ADD PRIMARY KEY (`U_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admin`
--
ALTER TABLE `admin`
  MODIFY `Admin_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `areadetails`
--
ALTER TABLE `areadetails`
  MODIFY `Area_id` int(6) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `branddetails`
--
ALTER TABLE `branddetails`
  MODIFY `Brand_id` int(6) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `categorydetails`
--
ALTER TABLE `categorydetails`
  MODIFY `Categ_id` int(6) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `deliverymandetails`
--
ALTER TABLE `deliverymandetails`
  MODIFY `Deliveryman_id` int(6) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `feedback`
--
ALTER TABLE `feedback`
  MODIFY `Feedback_id` int(6) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `medicinedetails`
--
ALTER TABLE `medicinedetails`
  MODIFY `P_id` int(6) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=41;

--
-- AUTO_INCREMENT for table `orderdetails`
--
ALTER TABLE `orderdetails`
  MODIFY `Order_id` int(6) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `prescriptiondetails`
--
ALTER TABLE `prescriptiondetails`
  MODIFY `Pres_id` int(6) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `prescriptioninsert`
--
ALTER TABLE `prescriptioninsert`
  MODIFY `Pinsert_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `shippingstatus`
--
ALTER TABLE `shippingstatus`
  MODIFY `Shipping_id` int(6) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `supplierdetails`
--
ALTER TABLE `supplierdetails`
  MODIFY `Supp_id` int(6) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `symptomdetails`
--
ALTER TABLE `symptomdetails`
  MODIFY `Symp_id` int(6) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `userregistration`
--
ALTER TABLE `userregistration`
  MODIFY `U_id` int(6) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
