CREATE TABLE course
(
    id          INT AUTO_INCREMENT NOT NULL,
    course_name VARCHAR(255)       NULL,
    course_code VARCHAR(255)       NULL,
    CONSTRAINT pk_course PRIMARY KEY (id)
);
INSERT INTO course (course_name, course_code) VALUES
('计算机科学导论', 'CS101'),
('算法设计与分析', 'CS202'),
('数据库系统原理', 'CS303'),
('软件工程', 'CS404'),
('操作系统', 'CS505'),
('计算机网络', 'CS606'),
('人工智能基础', 'AI101'),
('机器学习', 'AI202'),
('数据结构', 'DS101'),
('统计学', 'STAT101');
CREATE TABLE course_teacher
(
    id         INT UNSIGNED AUTO_INCREMENT NOT NULL,
    course_code  VARCHAR(255) NULL,
    teacher_code VARCHAR(255) NULL,
    CONSTRAINT pk_course_teacher PRIMARY KEY (id)
);
INSERT INTO course_teacher (course_code, teacher_code) VALUES
('CS101', 'T001'),
('CS202', 'T002'),
('CS303', 'T003'),
('CS404', 'T004'),
('CS505', 'T005'),
('CS606', 'T006'),
('AI101', 'T007'),
('AI202', 'T008'),
('DS101', 'T009'),
('STAT101', 'T010'),
('CS101', 'T011');
CREATE TABLE student
(
    id         INT UNSIGNED AUTO_INCREMENT NOT NULL,
    student_no    VARCHAR(64)                          NULL,
    name       VARCHAR(64)                 NULL,
    email      VARCHAR(64)                 NULL,
    age        INT                         NULL,
    CONSTRAINT pk_student PRIMARY KEY (id)
);
INSERT INTO student (student_no, name, email, age) VALUES
('S001', '张三', 'zhangsan@example.com', 20),
('S002', '李四', 'lisi@example.com', 21),
('S003', '王五', 'wangwu@example.com', 22),
('S004', '赵六', 'zhaoliu@example.com', 23),
('S005', '陈七', 'chenqi@example.com', 20),
('S006', '周八', 'zhouba@example.com', 21),
('S007', '吴九', 'wujiu@example.com', 22),
('S008', '郑十', 'zhengshi@example.com', 23),
('S009', '孙十一', 'sunshiyi@example.com', 20),
('S010', '钱十二', 'qianshier@example.com', 21);
CREATE TABLE teacher
(
    id         INT UNSIGNED AUTO_INCREMENT NOT NULL,
    teacher_no    VARCHAR(64)                         NULL,
    name       VARCHAR(64)                 NULL,
    email      VARCHAR(64)                 NULL,
    age        INT                         NULL,
    CONSTRAINT pk_student PRIMARY KEY (id)
);
INSERT INTO teacher (teacher_no, name, email, age) VALUES
('T001', '林老师', 'teacherlin@example.com', 35),
('TOO2', '黄老师', 'teacherhuang@example.com', 36),
('TOO3', '周老师', 'teacherzhou@example.com', 37),
('TOO4', '吴老师', 'teacherwu@example.com', 38),
('TOO5', '郑老师', 'teacherzheng@example.com', 35),
('TOO6', '王老师', 'teacherwang@example.com', 36),
('TOO7', '赵老师', 'teacherzhao@example.com', 37),
('TOO8', '孙老师', 'teachersun@example.com', 38),
('TOO9', '陈老师', 'teacherchen@example.com', 35),
('TO10', '李老师', 'teacherli@example.com', 36);
CREATE TABLE user
(
    id       INT UNSIGNED AUTO_INCREMENT NOT NULL,
    username VARCHAR(64)                 NULL,
    password VARCHAR(255)                NULL,
    CONSTRAINT pk_user PRIMARY KEY (id)
);
INSERT INTO user (id, username, password) VALUES
(1, 'S001', 'password1'),
(2, 'S002', 'password2'),
(3, 'S003', 'password3'),
(4, 'S004', 'password4'),
(5, 'S005', 'password5'),
(6, 'S006', 'password6'),
(7, 'S007', 'password7'),
(8, 'S008', 'password8'),
(9, 'S009', 'password9'),
(10, 'S010', 'password10'),
(101, 'T001', 'securepass1'),
(102, 'T002', 'securepass2'),
(103, 'T003', 'securepass3'),
(104, 'T004', 'securepass4'),
(105, 'T005', 'securepass5'),
(106, 'T006', 'securepass6'),
(107, 'T007', 'securepass7'),
(108, 'T008', 'securepass8'),
(109, 'T009', 'securepass9'),
(110, 'T010', 'securepass10');

