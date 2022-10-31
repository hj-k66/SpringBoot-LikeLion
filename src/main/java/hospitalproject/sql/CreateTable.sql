CREATE TABLE `likelion-db`.`national_hospitals` (
   `id` INT NOT NULL,
   `open_service_name` VARCHAR(10) NULL COMMENT '개방서비스명',
   `open_local_government_code` INT NOT NULL COMMENT '개방자치단체코드',
   `management_number` VARCHAR(40) NULL COMMENT '관리번호',
   `license_date` DATETIME NULL COMMENT '인허가일자',
   `business_status` TINYINT(2) NULL COMMENT '영업상태구분(boolean)\n1: 영업/정상\n2: 휴업\n3: 폐업\n4: 취소/말소',
   `business_status_code` TINYINT(2) NULL COMMENT '영업상태코드\n2: 휴업\n3: 폐업\n13: 영업중',
   `phone` VARCHAR(20) NULL COMMENT '소재지전화',
   `full_address` VARCHAR(200) NULL COMMENT '소재지전체주소',
   `road_name_address` VARCHAR(200) NULL COMMENT '도로명전체주소',
   `hospital_name` VARCHAR(20) NULL COMMENT '사업장명',
   `business_type_name` VARCHAR(10) NULL COMMENT '업태구분명',
   `healthcare_provider_count` TINYINT(2) NULL,
   `patient_room_count` TINYINT(2) NULL COMMENT '입원실수',
   `total_number_of_beds` TINYINT(2) NULL COMMENT '병상수',
   `total_area_size` FLOAT NULL COMMENT '총면적',
   PRIMARY KEY (`id`),
   UNIQUE INDEX `management_number_UNIQUE` (`management_number` ASC) VISIBLE);