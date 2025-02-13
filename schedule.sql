CREATE TABLE `Users` (  -- 'User' 대신 'Users'로 변경
                         `id` INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
                         `userName` VARCHAR(50) NOT NULL,
                         `email` VARCHAR(50) NOT NULL UNIQUE,  -- 이메일 중복 방지
                         `createdAt` DATETIME DEFAULT CURRENT_TIMESTAMP,
                         `updatedAt` DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                         `password` VARCHAR(60) NOT NULL  -- 비밀번호 해시를 고려하여 길이 조정
);

CREATE TABLE `Schedule` (
                            `id` INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
                            `userId` INT NULL,  -- ON DELETE SET NULL 적용
                            `title` VARCHAR(50) NOT NULL,
                            `content` VARCHAR(500) NOT NULL,  -- 최대 길이 확장
                            `createdAt` DATETIME DEFAULT CURRENT_TIMESTAMP,
                            `updatedAt` DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                            FOREIGN KEY (`userId`) REFERENCES `Users`(`id`) ON DELETE SET NULL  -- 삭제 시 NULL 처리
);


