CREATE TABLE `User` (
                        `id` INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
                        `userName` VARCHAR(15) NOT NULL,
                        `email` VARCHAR(30) NOT NULL,
                        `createdAt` DATETIME NULL,
                        `updatedAt` DATETIME NULL,
                        `password` VARCHAR(15) NOT NULL
);

CREATE TABLE `Schedule` (
                            `id` INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
                            `userId` INT NOT NULL,
                            `title` VARCHAR(30) NOT NULL,
                            `content` VARCHAR(200) NOT NULL,
                            `createdAt` DATETIME NULL,
                            `updatedAt` DATETIME NULL,
                            FOREIGN KEY (`userId`) REFERENCES `User`(`id`) ON DELETE CASCADE
);


