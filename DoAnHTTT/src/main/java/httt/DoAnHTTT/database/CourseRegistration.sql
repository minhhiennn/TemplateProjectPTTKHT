create database CourseRegistration
go
use CourseRegistration
set dateformat DMY
go


-- User_Kind là bảng nhận dạng(quy ước) về user thôi
-- VD : bảng Student(Sinh Viên) mình quy ước ID_User_Kind là 1
--      bảng Professor(Giảng Viên) mình quy ước ID_User_Kind là 2
-- lúc đó tao quên để bảng student foregin key bảng này
create table USER_KIND
(
	ID_UserKind nvarchar(2) not null,
	Name_UserKind nvarchar(50) not null,
	PRIMARY KEY (ID_UserKind) 
)

--dữ liệu bảng USER_KIND
INSERT INTO USER_KIND VALUES ('st', N'Student')
INSERT INTO USER_KIND VALUES ('pr', N'Professor')



-- Bảng này cần vcl
create table USERS
    (
	ID_User nvarchar(50)  not null,
	--Admin là ad ,student là st,professor là pr
	ID_UserKind nvarchar(2) not null FOREIGN KEY REFERENCES USER_KIND(ID_UserKind),
	email nvarchar(50) not null,
	password nvarchar(50) not null,
	PRIMARY KEY (ID_User)
	)
	----
	select * from USERS;
	----
-- một khoa trong trường
create table Faculty
(
    -- mã khoa (VD DH18DTA thì mã khoa là DT)
	ID_Faculty nvarchar(50) not null,
	ID_FacultyN int not null,
	Name_Faculty nvarchar(50) not null,
	
	Primary key (ID_Faculty)
)
create table Class
(
    -- mã khoa (VD DH18DTA thì mã khoa là DT)
	Class_code nvarchar(50) not null,
	ID_Faculty nvarchar(50) not null,
	Max_Size tinyint not null,
	Current_Size tinyint not null,
	Primary key (Class_code)
)
select * from Class
---
select * from Faculty where ID_Faculty = 'AV';
---
-- một học sinh của trường
create table Student
(
	ID_Student nvarchar(50)  not null FOREIGN KEY REFERENCES USERS(ID_User),
	Student_Name nvarchar(50) not null,
	-- mã khoa
	ID_Faculty nvarchar(50) not null FOREIGN KEY REFERENCES Faculty(ID_Faculty),
	-- Khóa học của trường (VD DH18DTA thì khóa của trường là 18 vì mình nộp hồ sơ năm 2018)
	-- Cách tính khóa học lấy năm nộp hồ sơ (trong đây là năm tạo tài khoản) trừ cho năm mốc (năm 2000)
	Create_date smalldatetime not null,
	-- Class code là mã lớp (VD DH18DTA)
	Class_code nvarchar(50) not null FOREIGN KEY REFERENCES Class(Class_code),
	-- Thêm vào số chứng chỉ bắt buộc ra trường
	-- Ngành CNTT thì tao nhớ ko nhầm tích lũy 145 chỉ là dc ra trường
	Cert_number_required SMALLINT not null, -- Tính năng mới
	-- Số chứng chỉ đã tích lũy được
	Cert_number_accumulated smallint not null, -- Tính năng mới
	Primary key (ID_Student)
)
--
select * from Student
--
-- một giáo sư của trường
create table Professor
(
	ID_Professor nvarchar(50)  not null FOREIGN KEY REFERENCES USERS(ID_User),
	Professor_Name nvarchar(50) not null,
	-- mã khoa
	ID_Faculty nvarchar(50) not null FOREIGN KEY REFERENCES Faculty(ID_Faculty),
	-- Khóa học của trường (VD DH18DTA thì khóa của trường là 18 vì mình nộp hồ sơ năm 2018)
	-- Cách tính khóa học lấy năm nộp hồ sơ (trong đây là năm tạo tài khoản) trừ cho năm mốc (năm 2000)
	Create_date date not null,
	-- Degree là cái vẹo gì
	Degree Nvarchar(50),	
	Primary key (ID_Professor)
)
    ----
	select * from Professor where ID_Professor = '220';
	----
-- Học kỳ
create table Semester
(
	ID_Semester nvarchar(50) not null,
	startDate date not null,
	endDate	date not null,
	years smallint,
	numberS smallint not null
	Primary key (ID_Semester)
)
select * from Semester;
select ID_Semester from Semester where GETDATE() between startDate and endDate
select * from Semester where YEAR(GETDATE()) = years;
-- bảng tính thời gian đăng ký môn học
create table TimeForCourseRegister
(
    ID_Semester nvarchar(50) not null FOREIGN KEY REFERENCES Semester(ID_Semester),
    startDate date not null,
    endDate date not null,
    Primary key(ID_Semester)
)
--
select * from Semester;
select * from TimeForCourseRegister tf join Semester se on tf.ID_Semester = se.ID_Semester where GETDATE() between tf.startDate and tf.endDate;
--
-- mô tả chi tiết học phần
create table Course
(    
    ID_Course nvarchar(50)  not null,
    ID_Faculty nvarchar(50) not null FOREIGN KEY REFERENCES Faculty(ID_Faculty),
    Name_Course nvarchar(50) not null,
    -- số chứng chỉ học phần (cao nhất là 4 nên để tinyint)	
    Course_certificate tinyint not null,
    -- học viên năm bao nhiêu có thể học
    years int not null,
    -- học kì cố định có môn này sẽ mở nếu/ hk sẽ là 1, 2  / nếu ko thì sẽ là 0
    numberS smallint    
    Primary key (ID_Course)    
)
--
Select * from Course;
--
-- một lớp được mở cụ thể trong danh sách đăng ký môn học 	
create table Course_Offering
(
	ID_Course_Offering nvarchar(50)  not null,
	ID_Course nvarchar(50) not null FOREIGN KEY REFERENCES Course(ID_Course),
	-- mã lớp (VD DH18DTA)
	Class_code nvarchar(50) not null FOREIGN KEY REFERENCES Class(Class_code),
	-- tinyint max value là 255 (từ 0 đến 255)
	-- max size là số sinh viên tối đa của lớp
	Max_Size tinyint not null,
	-- current size là số sinh viên đang hiện có của lớp
	Current_Size tinyint not null,
	-- lịch học thì sẽ có ngày bắt đầu và ngày kết thúc 
	-- ngày bắt đầu
	Primary key (ID_Course_Offering)
)
select * from Course_Offering
-- mới sửa lại Schedule
-- môn học có thể là thực hành hành hoặc lý thuyết 
-- thực hành lý thuyết khác ngày khác tiết và có ngày bắt đầu với kết thúc là khác nhau
--
--Select co.* , sc.Start_Day,sc.End_Day,sc.Study_place,sc.Start_Slot,sc.End_Slot,sc.Theoretical,sc.Teaching_Day from Course_Offering co inner join Schedule sc on co.ID_Course_Offering = sc.ID_Course_Offering where co.ID_Course_Offering = '15';
--
create table Schedule
(
	ID_Schedule nvarchar(50) not null,
	ID_Course_Offering nvarchar(50) not null FOREIGN KEY REFERENCES Course_Offering(ID_Course_Offering),	
	-- Mã giáo viên
	-- Sửa lại ID_Professor có thể là null
	Id_Profeesor nvarchar(50) FOREIGN KEY REFERENCES Professor(ID_Professor),
	-- TH là thực hành
	-- LT là lý thuyết
	Theoretical varchar(2) not null,
	-- thứ dạy học
	Teaching_Day smallint not null,
	-- ngày bắt đầu
	Start_Day date not null,
	-- ngày kết thúc
	End_Day date not null,
    -- Địa điểm học
	Study_place nvarchar(50) not null,
	-- tiết bắt đầu
	Start_Slot tinyint not null,
	-- tiết kết thúc
	End_Slot tinyint not null,
	Primary key (ID_Schedule)
)
 -----
 select * from Schedule where ID_Schedule = '1';
 -----
-- mon hoc tung hoc vien dang ky
create table Student_Schedule
(
    ID_Semester nvarchar(50) not null FOREIGN KEY REFERENCES Semester(ID_Semester),
    ID_Schedule nvarchar(50) not null FOREIGN KEY REFERENCES Schedule(ID_Schedule),
	ID_Student nvarchar(50)  not null FOREIGN KEY REFERENCES Student(ID_Student),
	Primary key (ID_Student,ID_Semester,ID_Schedule)
)
create table Student_ScheduleR
(
    ID_Semester nvarchar(50) not null FOREIGN KEY REFERENCES Semester(ID_Semester),
    ID_Schedule nvarchar(50) not null FOREIGN KEY REFERENCES Schedule(ID_Schedule),
	ID_Student nvarchar(50)  not null FOREIGN KEY REFERENCES Student(ID_Student),
	Primary key (ID_Student,ID_Semester,ID_Schedule)
)
create table Professor_Schedule
(
    ID_Semester nvarchar(50) not null FOREIGN KEY REFERENCES Semester(ID_Semester),
    ID_Schedule nvarchar(50) not null FOREIGN KEY REFERENCES Schedule(ID_Schedule),
	ID_Professor nvarchar(50)  not null FOREIGN KEY REFERENCES Professor(ID_Professor),
	Primary key (ID_Professor,ID_Semester,ID_Schedule)
)
select * from Professor_Schedule;
-- mon hoc trước
create table front_Sub
(
	ID_CourseB nvarchar(50),
	ID_Course nvarchar(50) not null FOREIGN KEY REFERENCES Course(ID_Course),
	Primary key (ID_Course)
)

-- Mon hoc da qua
create table Sub_Pass
-- sub pass ko co id mon hoc la vi id mon hoc trong schedule /thay hoi sai =))
(
    -- Học kỳ
    ID_Semester nvarchar(50) not null FOREIGN KEY REFERENCES Semester(ID_Semester),
    ID_Course nvarchar(50) not null FOREIGN KEY REFERENCES Course(ID_Course),
	ID_Student nvarchar(50) not null FOREIGN KEY REFERENCES Student(ID_Student),
	-- Điểm	
	Score float not null check (Score <= 10 and Score >= 0),
	-- Điểm hệ 4
	ScoreSystem4 float not null check (ScoreSystem4 <= 4 and ScoreSystem4 >= 0),
	-- Đánh giá học lực
	Rated nvarchar(10) not null,
	Primary key (ID_Student,ID_Course,ID_Semester)
)
---
update Sub_Pass set Score = 1, ScoreSystem4 = 1,Rated = 'F' where ID_Student = '18130005' and ID_Course = '214282' and ID_Semester = '2020_2'
delete from Sub_Pass;
select * from Sub_Pass;
select * from Student;
update Student set Cert_number_accumulated = 0 where ID_Student = '18130005';
select * from Sub_Pass where ID_Student = '18130003' and ID_Course = '214321' and Score > 4.0;
---
select * from Sub_Pass;
-- ket qua theo tung hoc ki
create table semester_Result
(
	ID_Semester nvarchar(50) not null FOREIGN KEY REFERENCES Semester(ID_Semester),
	--
	ID_Student nvarchar(50) not null FOREIGN KEY REFERENCES Student(ID_Student),
	--diem trung binh trong ki nay 
	gradeAv float,
	--diem trung binh he 4 trong ki nay
	gradeAv4 float,
	creditGet smallint,
	Primary key (ID_Semester,ID_Student)
)
select * from semester_Result;
--insert into Final_Result values(N'18130005',6.6,72)
create table Final_Result
(
ID_Student nvarchar(50) not null FOREIGN KEY REFERENCES Student(ID_Student),
gradeAv float,
gradeAv4 float,
Primary key (ID_Student)
)
select * from Final_Result
go
-- insert into users
insert into USERS Values(N'18130005','st',N'18130005@st.hcmuaf.edu.vn',N'123456')
insert into USERS Values(N'18130077','st',N'18130077@st.hcmuaf.edu.vn',N'123456')
insert into USERS Values(N'18130001','st',N'18130001@st.hcmuaf.edu.vn',N'123456')
insert into USERS Values(N'18130002','st',N'18130002@st.hcmuaf.edu.vn',N'123456')
insert into USERS Values(N'18130003','st',N'18130003@st.hcmuaf.edu.vn',N'123456')
insert into USERS Values(N'18130004','st',N'18130004@st.hcmuaf.edu.vn',N'123456')
insert into USERS Values(N'18130006','st',N'18130006@st.hcmuaf.edu.vn',N'123456')

--
select * from USERS;
delete from USERS where ID_User = '18130009';
--
insert into USERS Values(N'224','pr',N'224@st.hcmuaf.edu.vn',N'123456')
insert into USERS Values(N'225','pr',N'225@st.hcmuaf.edu.vn',N'123456')
insert into USERS Values(N'226','pr',N'226@st.hcmuaf.edu.vn',N'123456')
insert into USERS Values(N'227','pr',N'227@st.hcmuaf.edu.vn',N'123456')
insert into USERS Values(N'228','pr',N'228@st.hcmuaf.edu.vn',N'123456')
insert into USERS Values(N'229','pr',N'229@st.hcmuaf.edu.vn',N'123456')
insert into USERS Values(N'220','pr',N'220@st.hcmuaf.edu.vn',N'123456')
insert into USERS Values(N'300','pr',N'300@st.hcmuaf.edu.vn',N'123456')

--
delete from USERS where ID_User in ('301','302');
--
--dữ liệu bảng Faculty
INSERT INTO Faculty VALUES ('DT', 130,N'Khoa Công Nghệ Thông Tin')
INSERT INTO Faculty VALUES ('TY', 131,N'Khoa Thú Y')
INSERT INTO Faculty VALUES ('NH', 132,N'Khoa Nông Học')
INSERT INTO Faculty VALUES ('CK', 133,N'Khoa Cơ Khí')
INSERT INTO Faculty VALUES ('AV', 134,N'Khoa Ngôn Ngữ Anh')
INSERT INTO Faculty VALUES ('LA', 135,N'Khoa Thiết kế cảnh quan')
INSERT INTO Faculty VALUES ('LN', 136,N'Khoa Lâm nghiệp')
INSERT INTO Faculty VALUES ('BV', 137,N'Khoa Bảo vệ thực vật')
INSERT INTO Faculty VALUES ('QL', 138,N'Khoa Quản lý đất đai')

--
select * from Faculty;
--
insert into Class Values(N'DH18DTA','DT',7,100)
select * from class where SUBSTRING(Class_code,3,2) = '18' and ID_Faculty = 'dt';
--dữ liệu bảng Student
insert into Student Values(N'18130005',N'Đàm Văn Anh','DT','20/10/2018',N'DH18DTA',136,0)
insert into Student Values(N'18130077',N'Ngô Minh Hiển','DT','22/10/2018',N'DH18DTA',136,0)
insert into Student Values(N'18130001',N'Nguyễn Văn A','DT','20/10/2018',N'DH18DTA',136,0)
insert into Student Values(N'18130002',N'Nguyễn Văn B','DT','20/10/2018',N'DH18DTA',136,0)
insert into Student Values(N'18130003',N'Nguyễn Văn C','DT','20/10/2018',N'DH18DTA',136,0)
insert into Student Values(N'18130004',N'Nguyễn Văn D','DT','20/10/2018',N'DH18DTA',136,0)
insert into Student Values(N'18130006',N'Nguyễn Văn E','DT','20/10/2018',N'DH18DTA',136,0)
update Student set Create_date = '20/10/2018' where ID_Student = '18130006';
--
select * from Student;
delete from Student where ID_Student = '18130009';
update Student Set Cert_number_accumulated = 4 where ID_Student = '18130006';
select Cert_number_accumulated from Student where ID_Student = '18130006';
--

-- insert into Professor
insert into Professor Values(N'224',N'A','DT','20/10/2000',N'Tiến Sĩ')
insert into Professor Values(N'225',N'B','DT','20/10/2000',N'Thạc Sĩ')
insert into Professor Values(N'226',N'C','DT','20/10/2000',N'thạc Sĩ')
insert into Professor Values(N'227',N'D','DT','20/10/2000',N'Phó Giáo sư')
insert into Professor Values(N'228',N'E','DT','20/10/2000',N'Tiến Sĩ')
insert into Professor Values(N'229',N'F','DT','20/10/2000',N'Tiến Sĩ')
insert into Professor Values(N'220',N'G','DT','20/10/2000',N'Tiến Sĩ')
insert into Professor Values(N'300',N'Van ANh','NH','20/10/2000',N'Tiến Sĩ');
--
select * from Professor;
delete from Professor where ID_Professor in ('301','302');
select top 1 ID_Professor from Professor order by ID_Professor DESC; 
--
-- insert into Semester
insert into Semester Values(N'2018_1','1/9/2018','31/1/2019',2018,1)
insert into Semester Values(N'2018_2','1/3/2019','30/6/2019',2018,2)
insert into Semester Values(N'2019_1','1/9/2019','31/1/2020',2019,1)
insert into Semester Values(N'2019_2','1/3/2020','30/6/2020',2019,2)
insert into Semester Values(N'2020_1','1/9/2020','31/1/2021',2020,1)
insert into Semester Values(N'2020_2','1/3/2021','30/6/2021',2020,2)
insert into Semester Values(N'2021_1','1/9/2021','31/1/2022',2021,1)
insert into Semester Values(N'2021_2','1/3/2022','30/6/2022',2021,2)

-- insert into TimeForCourseRegister
insert into TimeForCourseRegister Values(N'2018_1','6/1/2019','12/1/2019')
insert into TimeForCourseRegister Values(N'2018_2','3/5/2019','12/5/2019')
insert into TimeForCourseRegister Values(N'2019_1','6/1/2020','6/1/2020')
insert into TimeForCourseRegister Values(N'2019_2','3/5/2020','12/5/2020')
insert into TimeForCourseRegister Values(N'2020_1','6/1/2021','12/1/2021')
insert into TimeForCourseRegister Values(N'2020_2','3/5/2021','12/5/2021')
insert into TimeForCourseRegister Values(N'2021_1','6/1/2022','12/1/2022')
insert into TimeForCourseRegister Values(N'2021_2','3/5/2022','12/5/2022')
update TimeForCourseRegister set startDate='3/5/2021' ,endDate = '04/05/2021' where ID_Semester = '2020_2';
select * from TimeForCourseRegister
-- insert into course
insert into Course Values(N'213603','DT',N'Anh văn 1',4,1,1);
insert into Course Values(N'214201','DT',N'Nhập môn tin học',3,1,1)
insert into Course Values(N'202109','DT',N'Toán cao cấp A2',3,1,1)
insert into Course Values(N'200102','DT',N'Kinh tế chính trị Mác-Lênin',2,1,1)
insert into Course Values(N'214321','DT',N'Lập trình cơ bản',4,1,1)
insert into Course Values(N'202206','DT',N'Vật lý 2',2,1,1)
insert into Course Values(N'202108','DT',N'Toán cao cấp A1',3,1,1)
insert into Course Values(N'202501','DT',N'Giáo dục thể chất 1*',1,1,1)
insert into Course Values(N'200101','DT',N'Triết học Mác Lênin',3,1,1)
insert into Course Values(N'200103','DT',N'Chủ nghĩa xã hội khoa học',2,1,2)
insert into Course Values(N'213604','DT',N'Anh văn 2',3,1,2)
insert into Course Values(N'202110','DT',N'Toán cao cấp A3',3,1,2)
insert into Course Values(N'214331','DT',N'Lập trình nâng cao',4,1,2)
insert into Course Values(N'214231','DT',N'Cấu trúc máy tính',2,1,2)
insert into Course Values(N'214242','DT',N'Nhập môn hệ điều hành',3,1,2)
insert into Course Values(N'208453','DT',N'Marketing căn bản',2,2,1)
insert into Course Values(N'202121','DT',N'Xác suất thống kê',3,2,1)
insert into Course Values(N'214241','DT',N'Mạng máy tính cơ bản',3,2,1)
insert into Course Values(N'214441','DT',N'Cấu trúc dữ liệu',4,2,1)
insert into Course Values(N'202622','DT',N'Pháp luật đại cương',2,2,1)
insert into Course Values(N'202620','DT',N'Kỹ năng giao tiếp',2,2,1)
insert into Course Values(N'214361','DT',N'Giao tiếp người máy',2,2,2)
insert into Course Values(N'214351','DT',N'Lý thuyết đồ thị',2,2,2)
insert into Course Values(N'200105','DT',N'Lịch sử đảng',2,2,2)
insert into Course Values(N'214442','DT',N'Nhập môn cơ sở dữ liệu',2,2,2)
insert into Course Values(N'214352','DT',N'Thiết kế hướng đối tượng',2,2,2)
insert into Course Values(N'214462','DT',N'Lập trình Web',2,3,1)
insert into Course Values(N'214463','DT',N'Nhập môn trí tuệ nhân tạo',2,3,1)
insert into Course Values(N'214372','DT',N'Lập trình.NET',2,3,1)
insert into Course Values(N'214353','DT',N'Đồ họa máy tính',2,3,1)
insert into Course Values(N'214386','DT',N'Lập trình PHP',2,3,1)
insert into Course Values(N'214451','DT',N'Hệ quản trị cơ sở dữ liệu',2,3,1)
insert into Course Values(N'200107','DT',N'Tư tưởng Hồ Chí Minh',2,3,1)
insert into Course Values(N'214252','DT',N'Lập trình mạng',2,3,1)
insert into Course Values(N'214370','DT',N'Nhập môn CN phần mềm',2,3,2)
insert into Course Values(N'214471','DT',N'Hệ thống thông tin quản lý',2,3,4)

insert into Course Values(N'214282','DT',N'Mạng máy tính nâng cao',2,3,2)
insert into Course Values(N'214461','DT',N'Phân tích và thiết kế HTTT',2,3,2)
insert into Course Values(N'214492','DT',N'Máy học',2,3,2)
insert into Course Values(N'214273','DT',N'Lập trình mạng nâng cao',2,3,2)
insert into Course Values(N'214388','DT',N'Lập trình Front End',2,3,2)
insert into Course Values(N'214274','DT',N'Lập trình trên TB di động',2,3,2)

--
select Course_certificate from Course where ID_Course = '213603';
--
-- insert into Course_Offering
insert into Course_Offering Values(N'1',N'213603','DH18DTA',80,0)
insert into Course_Offering Values(N'2',N'214201','DH18DTA',80,0)
insert into Course_Offering Values(N'3',N'202109','DH18DTA',80,0)
insert into Course_Offering Values(N'4',N'200102','DH18DTA',80,0)
insert into Course_Offering Values(N'5',N'214321','DH18DTA',80,0)
insert into Course_Offering Values(N'6',N'202206','DH18DTA',80,0)
insert into Course_Offering Values(N'7',N'202108','DH18DTA',80,0)
insert into Course_Offering Values(N'8',N'202501','DH18DTA',80,0)
insert into Course_Offering Values(N'9',N'200101','DH18DTA',80,0)
insert into Course_Offering Values(N'10',N'200103','DH18DTA',80,0)
insert into Course_Offering Values(N'11',N'213604','DH18DTA',80,0)
insert into Course_Offering Values(N'12',N'202110','DH18DTA',80,0)
insert into Course_Offering Values(N'13',N'214331','DH18DTA',80,0)
insert into Course_Offering Values(N'14',N'214231','DH18DTA',80,0)
insert into Course_Offering Values(N'15',N'214242','DH18DTA',80,0)
insert into Course_Offering Values(N'16',N'208453','DH18DTA',80,0)
insert into Course_Offering Values(N'17',N'202121','DH18DTA',80,0)
insert into Course_Offering Values(N'18',N'214241','DH18DTA',80,0)
insert into Course_Offering Values(N'19',N'214441','DH18DTA',80,0)
insert into Course_Offering Values(N'20',N'202622','DH18DTA',80,0)
insert into Course_Offering Values(N'21',N'202620','DH18DTA',80,0)
insert into Course_Offering Values(N'22',N'214361','DH18DTA',80,0)
insert into Course_Offering Values(N'23',N'214351','DH18DTA',80,0)
insert into Course_Offering Values(N'24',N'200105','DH18DTA',80,0)
insert into Course_Offering Values(N'25',N'214442','DH18DTA',80,0)
insert into Course_Offering Values(N'26',N'214352','DH18DTA',80,0)
insert into Course_Offering Values(N'27',N'214462','DH18DTA',80,0)
insert into Course_Offering Values(N'28',N'214463','DH18DTA',80,0)
insert into Course_Offering Values(N'29',N'214372','DH18DTA',80,0)
insert into Course_Offering Values(N'30',N'214353','DH18DTA',80,0)
insert into Course_Offering Values(N'31',N'214386','DH18DTA',80,0)
insert into Course_Offering Values(N'32',N'214451','DH18DTA',80,0)
insert into Course_Offering Values(N'33',N'200107','DH18DTA',80,0)
insert into Course_Offering Values(N'34',N'214252','DH18DTA',80,0)
insert into Course_Offering Values(N'35',N'214370','DH18DTA',80,0)
insert into Course_Offering Values(N'36',N'214471','DH18DTA',80,0)
insert into Course_Offering Values(N'37',N'214282','DH18DTA',80,0)
insert into Course_Offering Values(N'38',N'214461','DH18DTA',80,0)
insert into Course_Offering Values(N'39',N'214492','DH18DTA',80,0)
insert into Course_Offering Values(N'40',N'214273','DH18DTA',80,0)
insert into Course_Offering Values(N'41',N'214388','DH18DTA',80,0)
insert into Course_Offering Values(N'42',N'214274','DH18DTA',80,0)

select * from Course_Offering co where co.ID_Course = '214274';

--insert into Course_Offering Values(N'21',N'202622','DH18DTA',80,100)
UPDATE dbo.Course_Offering SET ID_Course = '200103', Class_code = 'DH18DTA', Max_Size = 80,Current_Size = 79 WHERE ID_Course_Offering = '10';
-- insert into Schedule
-- lười chèn vc
insert into Schedule values(N'1',N'1',null,'LT',4,'20/10/2021','20/11/2021',N'Rạng Đông',1,4)
insert into Schedule values(N'2',N'2',null,'LT',8,'20/10/2021','20/11/2021',N'Cẩm Tú',1,4)
insert into Schedule values(N'3',N'3',null,'LT',5,'20/10/2021','20/11/2021',N'Cẩm Tú',1,4)
insert into Schedule values(N'4',N'4',null,'LT',7,'20/10/2021','20/11/2021',N'Rạng Đông',1,4)
insert into Schedule values(N'5',N'5',null,'LT',5,'20/10/2021','20/11/2021',N'Rạng Đông',1,4)
insert into Schedule values(N'6',N'5',null,'TH',3,'20/10/2021','20/11/2021',N'Rạng Đông',1,4)
insert into Schedule values(N'7',N'6',null,'LT',4,'20/10/2021','20/11/2021',N'Rạng Đông',1,4)
insert into Schedule values(N'8',N'7',null,'LT',8,'20/10/2021','20/11/2021',N'Cẩm Tú',1,4)
insert into Schedule values(N'9',N'8',null,'LT',5,'20/10/2021','20/11/2021',N'Cẩm Tú',1,4)
insert into Schedule values(N'10',N'9',null,'LT',7,'20/10/2021','20/11/2021',N'Rạng Đông',1,4)
insert into Schedule values(N'11',N'10',null,'LT',5,'20/10/2021','20/11/2021',N'Rạng Đông',1,4)
insert into Schedule values(N'12',N'11',null,'TH',3,'20/10/2021','20/11/2021',N'Rạng Đông',1,4)
insert into Schedule values(N'13',N'12',null,'LT',4,'20/10/2021','20/11/2021',N'Rạng Đông',1,4)
insert into Schedule values(N'14',N'13',null,'LT',8,'20/10/2021','20/11/2021',N'Cẩm Tú',1,4)
insert into Schedule values(N'15',N'13',null,'TH',5,'20/10/2021','20/11/2021',N'Cẩm Tú',1,4)
insert into Schedule values(N'16',N'15',null,'LT',7,'20/10/2021','20/11/2021',N'Rạng Đông',1,4)
insert into Schedule values(N'17',N'16',null,'LT',5,'20/10/2021','20/11/2021',N'Rạng Đông',1,4)
insert into Schedule values(N'18',N'17',null,'TH',3,'20/10/2021','20/11/2021',N'Rạng Đông',1,4)
insert into Schedule values(N'19',N'19',null,'LT',5,'20/10/2021','20/11/2021',N'Rạng Đông',1,4)
insert into Schedule values(N'20',N'19',null,'TH',5,'20/10/2021','20/11/2021',N'Rạng Đông',2,4)
insert into Schedule values(N'21',N'20',null,'LT',3,'20/10/2021','20/11/2021',N'Rạng Đông',4,4)
insert into Schedule values(N'22',N'21',null,'LT',3,'20/10/2021','20/11/2021',N'Rạng Đông',3,4)
insert into Schedule values(N'23',N'22',null,'LT',3,'20/10/2021','20/11/2021',N'Rạng Đông',1,4)
insert into Schedule values(N'24',N'23',null,'LT',4,'20/10/2021','20/11/2021',N'Rạng Đông',1,4)
insert into Schedule values(N'25',N'24',null,'LT',4,'20/10/2021','20/11/2021',N'Rạng Đông',2,4)
insert into Schedule values(N'26',N'25',null,'LT',4,'20/10/2021','20/11/2021',N'Rạng Đông',3,4)
insert into Schedule values(N'27',N'26',null,'LT',5,'20/10/2021','20/11/2021',N'Rạng Đông',1,4)
insert into Schedule values(N'28',N'27',null,'LT',5,'20/10/2021','20/11/2021',N'Rạng Đông',2,4)
insert into Schedule values(N'29',N'28',null,'LT',5,'20/10/2021','20/11/2021',N'Rạng Đông',3,4)
insert into Schedule values(N'30',N'29',null,'LT',6,'20/10/2021','20/11/2021',N'Rạng Đông',1,4)
insert into Schedule values(N'31',N'30',null,'LT',6,'20/10/2021','20/11/2021',N'Rạng Đông',2,4)
insert into Schedule values(N'32',N'31',null,'LT',6,'20/10/2021','20/11/2021',N'Rạng Đông',3,4)
insert into Schedule values(N'33',N'32',null,'LT',7,'20/10/2021','20/11/2021',N'Rạng Đông',1,4)
insert into Schedule values(N'34',N'33',null,'LT',7,'20/10/2021','20/11/2021',N'Rạng Đông',2,4)
insert into Schedule values(N'35',N'34',null,'LT',7,'20/10/2021','20/11/2021',N'Rạng Đông',3,4)
insert into Schedule values(N'36',N'35',null,'LT',2,'20/10/2021','20/11/2021',N'Rạng Đông',4,4)
insert into Schedule values(N'37',N'36',null,'LT',3,'20/10/2021','20/11/2021',N'Rạng Đông',1,4)
insert into Schedule values(N'38',N'37',null,'LT',3,'20/10/2021','20/11/2021',N'Rạng Đông',2,4)
insert into Schedule values(N'39',N'38',null,'LT',3,'20/10/2021','20/11/2021',N'Rạng Đông',3,4)
insert into Schedule values(N'40',N'39',null,'LT',2,'20/10/2021','20/11/2021',N'Rạng Đông',1,4)
insert into Schedule values(N'41',N'40',null,'LT',2,'20/10/2021','20/11/2021',N'Rạng Đông',2,4)
insert into Schedule values(N'42',N'40',null,'TH',2,'20/10/2021','20/11/2021',N'Rạng Đông',2,4)
insert into Schedule values(N'43',N'36',null,'TH',2,'20/10/2021','20/11/2021',N'Rạng Đông',2,4)
insert into Schedule values(N'44',N'38',null,'TH',2,'20/10/2021','20/11/2021',N'Rạng Đông',2,4)
delete from Schedule where ID_Schedule in ('1a','1b','1c');

update Schedule set Id_Profeesor = null where ID_Schedule = '42';
update Schedule set Id_Profeesor = null where ID_Schedule = '1';

select * from Schedule;
-- insert into Student_Schedule
-- 
--
insert into Student_Schedule values('2019_2',N'28',N'18130006')
insert into Student_Schedule values('2019_2',N'29',N'18130006')
insert into Student_Schedule values('2019_2',N'30',N'18130006')
insert into Student_Schedule values('2019_2',N'31',N'18130006')
insert into Student_Schedule values('2019_2',N'32',N'18130006')
--insert into Student_Schedule values('2020_1',N'36',N'18130006')
--insert into Student_Schedule values('2020_1',N'37',N'18130006')
--insert into Student_Schedule values('2020_1',N'38',N'18130006')
--insert into Student_Schedule values('2020_1',N'39',N'18130006')
--insert into Student_Schedule values('2020_1',N'40',N'18130006')
insert into Student_Schedule values('2020_2',N'36',N'18130006')
insert into Student_Schedule values('2020_2',N'37',N'18130006')
insert into Student_Schedule values('2020_2',N'38',N'18130006')
insert into Student_Schedule values('2020_2',N'39',N'18130006')
insert into Student_Schedule values('2020_2',N'40',N'18130006')
insert into Student_Schedule values('2020_2',N'36',N'18130005')
insert into Student_Schedule values('2020_2',N'37',N'18130005')
insert into Student_Schedule values('2020_2',N'38',N'18130005')
insert into Student_Schedule values('2020_2',N'39',N'18130005')
insert into Student_Schedule values('2020_2',N'40',N'18130005')
insert into Student_Schedule values('2021_1',N'40',N'18130005')
insert into Student_Schedule values('2021_1',N'41',N'18130005')
select TOP 1 st.ID_Semester from Student_Schedule st where st.ID_Student = '18130006' group by st.ID_Semester order by st.ID_Semester desc
select TOP 3 st.ID_Semester from Student_Schedule st where st.ID_Student = '18130006' group by st.ID_Semester order by st.ID_Semester desc
select st.* from Student_Schedule st where st.ID_Semester='2020_2' and st.ID_Student='18130006';
delete from Student_Schedule where ID_Semester='2020_2' and ID_Schedule='11' and ID_Student='18130005';
delete from Student_Schedule;
--
insert into Student_ScheduleR values('2020_2',N'36',N'18130006')
insert into Student_ScheduleR values('2020_2',N'37',N'18130006')
insert into Student_ScheduleR values('2020_2',N'38',N'18130006')
insert into Student_ScheduleR values('2020_2',N'39',N'18130006')
insert into Student_ScheduleR values('2020_2',N'40',N'18130006')
insert into Student_ScheduleR values('2020_2',N'36',N'18130005')
insert into Student_ScheduleR values('2020_2',N'37',N'18130005')
insert into Student_ScheduleR values('2020_2',N'38',N'18130005')
insert into Student_ScheduleR values('2020_2',N'39',N'18130005')
insert into Student_ScheduleR values('2020_2',N'41',N'18130005')
insert into Student_ScheduleR values('2020_2',N'42',N'18130005')
select * from Student_ScheduleR;
--
insert into Professor_Schedule values('2019_2',N'28',N'224')
insert into Professor_Schedule values('2019_2',N'29',N'224')
insert into Professor_Schedule values('2019_2',N'30',N'224')
insert into Professor_Schedule values('2019_2',N'31',N'224')
insert into Professor_Schedule values('2019_2',N'32',N'224')
--insert into Professor_Schedule values('2020_1',N'36',N'224')
--insert into Professor_Schedule values('2020_1',N'37',N'224')
--insert into Professor_Schedule values('2020_1',N'38',N'224')
--insert into Professor_Schedule values('2020_1',N'39',N'224')
--insert into Professor_Schedule values('2020_1',N'40',N'224')
insert into Professor_Schedule values('2020_2',N'36',N'224')
insert into Professor_Schedule values('2020_2',N'37',N'224')
insert into Professor_Schedule values('2020_2',N'38',N'224')
insert into Professor_Schedule values('2020_2',N'39',N'224')
insert into Professor_Schedule values('2020_2',N'40',N'224')
select pr.ID_Schedule from Professor_Schedule pr
select COUNT(*) as dem from Professor_Schedule pr where pr.ID_Professor = '224' and pr.ID_Semester = '2020_2';
delete from Professor_Schedule where ID_Semester = '2020_2' and ID_Schedule='1' and ID_Professor='224';
-- insert into front_Sub
insert into front_Sub values(N'214331',N'214321')

insert into front_Sub values(N'214441',N'214331')

-- insert into Sub_Pass
select st.ID_Schedule from Student_Schedule st where st.ID_Semester=N'2020_2' and st.ID_Student='18130005'
delete from Sub_Pass where ID_Student='18130005' and ID_Course='214282';
select * from Sub_Pass;

--insert into Sub_Pass values('2_2022',N'2142',N'18130006',7.5,N'khá')
insert into Sub_Pass values('2021_1',N'214492',N'18130005',6.5,2.5,N'C')
--insert into Sub_Pass values('3_2022',N'4111',N'18130004',7.5,N'Khá')
--insert into Sub_Pass values('2021_2',N'2142',N'18130005',7.5,N'Khá')
select  * from semester_Result ;
delete from semester_Result where ID_Semester='2021_1'
select * from semester_Result sr join Student st on sr.ID_Student=st.ID_Student where st.ID_Student='18130005' and sr.ID_Semester<'2021_1' order by sr.ID_Semester 
-- insert into semester_Result
-- như cc
insert into semester_Result values('2020_2',N'18130005',6.37,2.23,4)
insert into semester_Result values('2021_1',N'18130005',6.0,2.0,4)
insert into semester_Result values('2021_2',N'18130005',7.6,2.5,16)
select se.ID_Semester from semester_Result se where ID_Student='18130005' order by  se.ID_Semester;
--insert into semester_Result values('3_2022',N'18130006',8.6,18)
--insert into semester_Result values('2021_2',N'18130005',2.6,17)
--insert into semester_Result values('3_2021',N'18130002',6.6,12)

-- insert into Final_Result
-- như cc
--insert into Final_Result values(N'18130005',6.6,72)
--insert into Final_Result values(N'18130006',5.6,72)
--insert into Final_Result values(N'18130002',7.6,70)
--insert into Final_Result values(N'18130003',4.6,67)
--insert into Final_Result values(N'18130004',9.6,40)
--insert into Final_Result values(N'18130001',10,30)
	
go
-- thời khóa biểu có học sinh , thời khóa biểu của giáo viên chỉ cần gọi schdule
CREATE FUNCTION TimeTableSt (@ID_User varchar(50))
RETURNS TABLE 
as
RETURN  
select sd.* from Schedule sd join Course_Offering co on sd.ID_Course_Offering = co.ID_Course_Offering
									 join Student_Schedule stc on stc.ID_Schedule = sd.ID_Schedule 
			where stc.ID_Student = @ID_User and stc.ID_Semester in (select ID_Semester from Semester where GETDATE() between startDate and endDate )
go

select * from TimeTableSt('18130005');
DROP FUNCTION TimeTableSt;
go
create FUNCTION subPassed (@ID_CourseB nvarchar(50),@ID_User nvarchar(50))
RETURNS nvarchar(50) 
as
begin
Declare @ID_CourseB1 nvarchar(50)
(select @ID_CourseB1 = fs.ID_CourseB  from front_Sub fs where fs.ID_CourseB = @ID_CourseB and  fs.ID_Course = case
when (select ID_Course  from Sub_Pass where ID_Course = fs.ID_Course  and ID_Student = @ID_User and Score >= 4) is not null then fs.ID_Course
else null end)
RETURN @ID_CourseB1;
end

go


select  [dbo].subPassed (N'214331',N'18130005')
go

-- những môn sẽ hiển thị khi nhấn đăng ký môn học
-- những môn có thể đăng ký của giáo viên thì chọn những môn nào trong bảng schedule có chỗ id pr là null
create FUNCTION SubAvailableST (@ID_User varchar(50))
RETURNS TABLE
as
RETURN  
select sc.ID_Schedule from Course_Offering co join Course c on c.ID_Course = co.ID_Course
													 join Schedule sc on sc.ID_Course_Offering = co.ID_Course_Offering
													 
where  
c.ID_Faculty =  case when c.ID_Faculty is null then  c.ID_Faculty else (select ID_Faculty from Student where ID_Student = @ID_User)  end and
c.years =  case when c.years is null then  c.years else (select (YEAR(GETDATE())-YEAR(Create_date)) from Student where ID_Student = @ID_User) end and
c.numberS =  case when c.numberS is null then  c.numberS else (select numberS from Semester where ID_Semester in  (select ID_Semester from Semester where GETDATE() between startDate and endDate ))  end and
c.ID_Course = case when (select ID_CourseB from front_Sub where ID_CourseB = c.ID_Course) is null then  c.ID_Course
when [dbo].subPassed (c.ID_Course,@ID_User)  is null then null else [dbo].subPassed (c.ID_Course,@ID_User)  end
go
select * from SubAvailableST('18130005');


go
-- bảng này là bảng check khi nhấn vào ô chọn môn học nếu trùng giờ trùng ngày , trùng môn nếu rỗng thì ko đk được



create FUNCTION checkStart_Slot_TeachDay (@ID_User varchar(50),@Start_Slot varchar(50),@Teaching_Day varchar(50))
RETURNS TABLE 
as
RETURN  
select sc.Start_Slot from Schedule sc join Student_Schedule stc on sc.ID_Schedule = stc.ID_Schedule
					   where stc.ID_Student = @ID_User and stc.ID_Semester in  (select ID_Semester from Semester where GETDATE() between startDate and endDate)
					   and stc.ID_Semester in  (select ID_Semester from Semester where GETDATE() between startDate and endDate)
					   and sc.Start_Slot = @Start_Slot and sc.Teaching_Day = @Teaching_Day					   					   					   
go
create FUNCTION checkDayST (@ID_Schedule nvarchar(50),@ID_User varchar(50))
RETURNS TABLE 
as
RETURN  
select sc.ID_Schedule from Schedule sc  join Course_Offering co on co.ID_Course_Offering = sc.ID_Course_Offering						  
where  (sc.Start_Slot in (select Start_Slot from checkStart_Slot_TeachDay(@ID_User,sc.Start_Slot,sc.Teaching_Day))
 or co.ID_Course   in (select ID_Course from checkSubExist(@ID_User))) and (co.Current_Size < co.Max_Size)
 and sc.ID_Schedule = @ID_Schedule
 go
 -- a là y chang nên ko được
 -- b là khác môn nhưng trùng giờ
 -- 20 là được
 --insert into Course_Offering Values(N'37',N'214282','DH18DTA',80,0)
 --insert into Schedule values(N'37',N'36',N'229','LT',3,'20/10/2021','20/11/2021',N'Rạng Đông',1,4)
--insert into Schedule values(N'1',N'1',N'224','LT',4,'20/10/2021','20/11/2021',N'Rạng Đông',1,4)
--insert into Schedule values(N'1a',N'1',N'224','LT',4,'20/10/2021','20/11/2021',N'Rạng Đông',1,4)
--insert into Schedule values(N'1c',N'1',N'224','LT',4,'20/10/2021','20/11/2021',N'Rạng Đông',1,4)
--insert into Schedule values(N'1b',N'20',N'224','LT',4,'20/10/2021','20/11/2021',N'Rạng Đông',1,4)
--insert into Schedule values(N'20',N'19',N'229','TH',3,'20/10/2021','20/11/2021',N'Rạng Đông',1,4)
--select * from Schedule;

--insert into Student_Schedule values('2020_2',N'1',N'18130005')
--insert into Student_Schedule values('2020_2',N'2',N'18130005')
--insert into Student_Schedule values('2020_2',N'3',N'18130005')
--insert into Student_Schedule values('2020_2',N'4',N'18130005')
--select * from Student_Schedule
--
 select * from checkStart_Slot_TeachDay(N'18130006',2,2);
 select * from checkDayST(N'37','18130006');
 select * from Schedule where ID_Schedule = '41'
-- select * from checkDayST(N'1b','18130005');
-- select * from checkDayST(N'1c','18130005');
-- select * from checkDayST(N'20','18130005');
-- select * from Student_Schedule
 go
 --select * from Student_Schedule st join Schedule sch on st.ID_Schedule = sch.ID_Schedule where st.ID_Semester='2020_2' and st.ID_Student='18130006'
 --select * from Schedule where ID_Schedule = '38'
 --select * from course_offering where ID_course_offering = '37'
-- tạo trigger cho course_offering


create FUNCTION checkSubExist (@ID_User varchar(50))
RETURNS TABLE 
as
RETURN  
select c.ID_Course from Schedule sc join Student_Schedule stc on sc.ID_Schedule = stc.ID_Schedule
						join Course_Offering co on co.ID_Course_Offering = sc.ID_Course_Offering
						join Course c on c.ID_Course = co.ID_Course
						where stc.ID_Student  = @ID_User and stc.ID_Semester in  (select ID_Semester from Semester where GETDATE() between startDate and endDate)
go
select * from checkSubExist('18130006');
go
create FUNCTION checkSubExistForProfessor (@ID_User varchar(50))
RETURNS TABLE 
as
RETURN  
select c.ID_Course from Schedule sc join Professor_Schedule prc on sc.ID_Schedule = prc.ID_Schedule
						join Course_Offering co on co.ID_Course_Offering = sc.ID_Course_Offering
						join Course c on c.ID_Course = co.ID_Course
						where prc.ID_Professor  = @ID_User and prc.ID_Semester in  (select ID_Semester from Semester where GETDATE() between startDate and endDate)
go
select * from checkSubExistForProfessor('224');
go
-- Thời khóa biểu cho giáo viên
create FUNCTION TimeTablePr (@ID_Professor varchar(50))
RETURNS TABLE 
as
RETURN  
select sd.* from Schedule sd join Course_Offering co on sd.ID_Course_Offering = co.ID_Course_Offering
									 join Professor_Schedule prc on prc.ID_Schedule = sd.ID_Schedule 
			where prc.ID_Professor = @ID_Professor and prc.ID_Semester in (select ID_Semester from Semester where GETDATE() between startDate and endDate )
go

select * from TimeTablePr('224');
go
--Phương thức check những môn mà giáo viên có thể đk ký
alter function checkSubjectForProfessor(@ID_Professor nvarchar(50))
returns table 
as
return
select sc.ID_Schedule
from Schedule sc join Course_Offering co on sc.ID_Course_Offering = co.ID_Course_Offering
                 join Course c on co.ID_Course = c.ID_Course
where sc.Id_Profeesor is null and (c.ID_Faculty = (select pf.ID_Faculty from Professor pf where pf.ID_Professor = @ID_Professor) or c.ID_Faculty is null );
go
select * from checkSubjectForProfessor('220');
select * from Student
select * from USERS
go
-- Phương thức check có trùng ngày và giờ ko
create FUNCTION checkStart_Slot_TeachDayPR (@ID_Professor varchar(50),@Start_Slot varchar(50),@Teaching_Day varchar(50))
RETURNS TABLE 
as
RETURN  
select sc.Start_Slot from Schedule sc join Professor_Schedule prc on sc.ID_Schedule = prc.ID_Schedule
					   where prc.ID_Professor = @ID_Professor and prc.ID_Semester in  (select ID_Semester from Semester where GETDATE() between startDate and endDate)
					   and prc.ID_Semester in  (select ID_Semester from Semester where GETDATE() between startDate and endDate)
					   and sc.Start_Slot = @Start_Slot and sc.Teaching_Day = @Teaching_Day					   
go
--
select sp.* ,c.Course_certificate from Sub_Pass sp join Course c on sp.ID_Course = c.ID_Course
go

--Phương thức đk cho giáo viên
create FUNCTION checkDayPr (@ID_Schedule nvarchar(50),@ID_Professor varchar(50))
RETURNS TABLE 
as
RETURN  
select sc.ID_Schedule from Schedule sc  join Course_Offering co on co.ID_Course_Offering = sc.ID_Course_Offering						  
where  (sc.Start_Slot in (select Start_Slot from checkStart_Slot_TeachDayPR(@ID_Professor,sc.Start_Slot,sc.Teaching_Day))
 or co.ID_Course   in (select ID_Course from checkSubExistForProfessor(@ID_Professor)))
 and sc.ID_Schedule = @ID_Schedule
 --and (select count(ID_Schedule) from Professor_Schedule where ID_Professor = @ID_Professor) <= 3
 go
 select * from checkDayPr('36','224');
 go
-- tạo function semester_Result
select st.* from Student_Schedule st where st.ID_Semester='2020_2' and st.ID_Student='18130005'
DROP FUNCTION get_Semester_Reuslt;
create function get_Semester_Reuslt(@ID_Student nvarchar(50),@ID_Semester nvarchar(50))
returns table
as
return 
select  c.ID_Course,c.Name_Course,c.Course_certificate,sp.Score,sp.ScoreSystem4,st.* from Sub_Pass sp 
																					join Course c on sp.ID_Course = c.ID_Course
																					join Student_Schedule st on sp.ID_Student=st.ID_Student
where sp.ID_Student = @ID_Student and sp.ID_Semester = @ID_Semester
go
--
select * from get_Semester_Reuslt('18130005','2020_2');
-- tính điểm TB từ semester_Result
select SUM(gr.Score * gr.Course_certificate)/SUM(gr.Course_certificate) Diem_TB from get_Semester_Reuslt('18130005','2_2018') gr;
-- tính điểm TB từ semester_Result(hệ 4)
select SUM(gr.ScoreSystem4 * gr.Course_certificate)/SUM(gr.Course_certificate) Diem_TB_He_4 from get_Semester_Reuslt('18130005','2_2018') gr;
-- lấy tổng tín chỉ đã đạt trong học kỳ(ko lấy môn dưới 4.0)
select SUM(gr.Course_certificate) so_TC from get_Semester_Reuslt('18130005','2_2018') gr where gr.Score > 4.0;
-- tổng tín chỉ đã đăng ký trong học kỳ
select SUM(gr.Course_certificate) so_TC from get_Semester_Reuslt('18130005','2_2018')gr;
--

go
--
-- tạo function Final_Result(éo biết tính như nào)
--
--
select * from class
select * from Student
delete Student where ID_Student like '18135%'
delete class where Class_code like 'DH18TY%'
select * from Course_Offering
UPDATE dbo.Course_Offering SET ID_Course = '213603', Class_code = 'DH18DTA', Max_Size = 80,Current_Size = 0 WHERE ID_Course_Offering = '1'
---
create Trigger checkCourse_Offering
on Course_Offering
for insert,update
as
begin
Declare @CurrentSizeI tinyint = (select I.Current_Size from inserted I);
Declare @MaxSizeI tinyint = (select I.Max_Size from inserted I );
if @CurrentSizeI > @MaxSizeI
begin
RAISERROR(N'lớp đã đầy',11,1)
ROLLBACK TRANSACTION
end
end
go
---
select sa.ID_Schedule from SubAvailableST('18130005') sa join TimeTableSt('18130005') tt on sa.ID_Schedule = tt.ID_Schedule where sa.ID_Schedule = '12';
--- Nhập điểm cho giáo viên
select DISTINCT c.ID_Course,c.Name_Course,pr.ID_Semester from Professor_Schedule pr join Schedule sc on pr.ID_Schedule = sc.ID_Schedule join Course_Offering co on sc.ID_Course_Offering = co.ID_Course_Offering join Course c on co.ID_Course = c.ID_Course
where pr.ID_Semester = (select s.ID_Semester from Semester s where GETDATE() between s.startDate and s.endDate) and pr.ID_Professor = '224';

select st.ID_Student,s.Student_Name from Student_Schedule st join Schedule sc on st.ID_Schedule = sc.ID_Schedule
                                                             join Course_Offering co on sc.ID_Course_Offering = co.ID_Course_Offering
                                                             join Course c on co.ID_Course = c.ID_Course
                                                             join Student s on st.ID_Student = s.ID_Student
where c.ID_Course = '214282' and st.ID_Semester = '2020_2'; 

insert into Sub_Pass values('2020_2','214282','18130005',8.0,3.6,'A');
select sp.Score from Sub_Pass sp where sp.ID_Student = '18130005' and sp.ID_Course = '214282' and sp.ID_Semester = '2020_2';

------ xét nó có trong cơ sỡ dữ liệu hay chưa
delete from Student_ScheduleR;
select strr.* from Student_ScheduleR strr
where strr.ID_Semester = '2020_2' and strr.ID_Student = '18130005' and strr.ID_Schedule = '36'
insert into Student_ScheduleR values('2020_2','36','18130005')
select st.ID_Schedule from Student_Schedule st
where st.ID_Semester = '2020_2' and st.ID_Student = '18130005'

select Count(DISTINCT c.ID_Course) as dem from Student_Schedule st join Schedule sc on st.ID_Schedule = sc.ID_Schedule
                                               join Course_Offering co on sc.ID_Course_Offering = co.ID_Course_Offering
                                               join Course c on co.ID_Course = c.ID_Course
where st.ID_Semester = '2020_2' and st.ID_Student = '18130005'
                                          


  ---test
go
create FUNCTION laytinchi (@ID_User varchar(50),@ID_semeseter varchar(50))
RETURNS TABLE
as
RETURN  
select c.Course_certificate,c.ID_Course,sp.Score from Course_Offering co join Course c on c.ID_Course = co.ID_Course
													 join Schedule sc on sc.ID_Course_Offering = co.ID_Course_Offering
													 join Sub_Pass sp on c.ID_Course=sp.ID_Course
													 
where  
c.ID_Faculty =  case when c.ID_Faculty is null then  c.ID_Faculty else (select ID_Faculty from Student where ID_Student = @ID_User)  end and
c.years =  case when c.years is null then  c.years else (select (YEAR(GETDATE())-YEAR(Create_date)) from Student where ID_Student = @ID_User) end and
c.numberS =  case when c.numberS is null then  c.numberS else (select numberS from Semester where ID_Semester=@ID_semeseter )  end and
c.ID_Course = case when (select ID_CourseB from front_Sub where ID_CourseB = c.ID_Course) is null then  c.ID_Course
when [dbo].subPassed (c.ID_Course,@ID_User)  is null then null else [dbo].subPassed (c.ID_Course,@ID_User)  end

select * from laytinchi('18130005','2020_2');
DROP FUNCTION laytinchi;

