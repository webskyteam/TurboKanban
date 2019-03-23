DROP TABLE IF EXISTS `task`;
CREATE TABLE `task` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `process_status` varchar(45) NOT NULL DEFAULT 'todo',
  `task_name` varchar(45) DEFAULT NULL,
  `description` varchar(4000),
  PRIMARY KEY (`id`)
);

INSERT INTO `task` VALUES
	  (1, 'todo', 'Gathering informations', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.'),
    (2, 'todo', 'Need more info', 'Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.'),
    (3, 'doing', 'Processing informations', 'Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.'),
    (4, 'doing', 'Adding stuff', 'Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.'),
    (5, 'done', 'Presentation of results', 'sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,'),
    (6, 'archive', 'completed', 'uggkjg g hkjg sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,');
    
    

