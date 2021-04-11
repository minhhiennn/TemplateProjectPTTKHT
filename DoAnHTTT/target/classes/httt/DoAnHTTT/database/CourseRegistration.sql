﻿create database CourseRegistration
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
create table USERS(
	ID_User nvarchar(50)  not null,
	--Admin là ad ,student là st,professor là pr
	ID_UserKind nvarchar(2) not null FOREIGN KEY REFERENCES USER_KIND(ID_UserKind),
	email nvarchar(50) not null,
	password nvarchar(50) not null,
	PRIMARY KEY (ID_User)
	)
	
insert into USERS Values(N'18130005','st',N'18130005@st.hcmuaf.edu.vn',N'123456')
insert into USERS Values(N'18130077','st',N'18130077@st.hcmuaf.edu.vn',N'123456')
insert into USERS Values(N'18130001','st',N'18130001@st.hcmuaf.edu.vn',N'123456')
insert into USERS Values(N'18130002','st',N'18130002@st.hcmuaf.edu.vn',N'123456')
insert into USERS Values(N'18130003','st',N'18130003@st.hcmuaf.edu.vn',N'123456')
insert into USERS Values(N'18130004','st',N'18130004@st.hcmuaf.edu.vn',N'123456')
insert into USERS Values(N'18130006','st',N'18130006@st.hcmuaf.edu.vn',N'123456')

insert into USERS Values(N'224','pr',N'224@st.hcmuaf.edu.vn',N'123456')
insert into USERS Values(N'225','pr',N'225@st.hcmuaf.edu.vn',N'123456')
insert into USERS Values(N'226','pr',N'226@st.hcmuaf.edu.vn',N'123456')
insert into USERS Values(N'227','pr',N'227@st.hcmuaf.edu.vn',N'123456')
insert into USERS Values(N'228','pr',N'228@st.hcmuaf.edu.vn',N'123456')
insert into USERS Values(N'229','pr',N'229@st.hcmuaf.edu.vn',N'123456')
insert into USERS Values(N'220','pr',N'220@st.hcmuaf.edu.vn',N'123456')

-- một khoa trong trường
create table Faculty
(
    -- mã khoa (VD DH18DTA thì mã khoa là DT)
	ID_Faculty nvarchar(50) not null,
	Name_Faculty nvarchar(50) not null,
	
	Primary key (ID_Faculty)
)
--dữ liệu bảng Faculty
INSERT INTO Faculty VALUES ('DT', N'Khoa Công Nghệ Thông Tin')
INSERT INTO Faculty VALUES ('TY', N'Khoa Thú Y')
INSERT INTO Faculty VALUES ('NH', N'Khoa Nông Học')
INSERT INTO Faculty VALUES ('CK', N'Khoa Cơ Khí')
INSERT INTO Faculty VALUES ('AV', N'Khoa Ngôn Ngữ Anh')
INSERT INTO Faculty VALUES ('LA', N'Khoa Thiết kế cảnh quan')
INSERT INTO Faculty VALUES ('LN', N'Khoa Lâm nghiệp')
INSERT INTO Faculty VALUES ('BV', N'Khoa Bảo vệ thực vật')
INSERT INTO Faculty VALUES ('QL', N'Khoa Quản lý đất đai')



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
	Class_code nvarchar(50) not null,
	-- Thêm vào số chứng chỉ bắt buộc ra trường
	-- Ngành CNTT thì tao nhớ ko nhầm tích lũy 145 chỉ là dc ra trường
	Cert_number_required SMALLINT not null, -- Tính năng mới
	-- Số chứng chỉ đã tích lũy được
	Cert_number_accumulated smallint not null, -- Tính năng mới
	Primary key (ID_Student)
)
--dữ liệu bảng Student
insert into Student Values(N'18130005',N'Đàm Văn Anh','DT','20/10/2018',N'DH18DTA',136,100)
insert into Student Values(N'18130077',N'Ngô Minh Hiển','DT','22/10/2015',N'DH18DTA',136,70)
insert into Student Values(N'18130001',N'Nguyễn Văn A','DT','20/10/2018',N'DH18DTA',136,80)
insert into Student Values(N'18130002',N'Nguyễn Văn B','DT','20/10/2018',N'DH18DTA',136,40)
insert into Student Values(N'18130003',N'Nguyễn Văn C','DT','20/10/2018',N'DH18DTA',136,90)
insert into Student Values(N'18130004',N'Nguyễn Văn D','DT','20/10/2018',N'DH18DTA',136,110)
insert into Student Values(N'18130006',N'Nguyễn Văn E','DT','20/10/2018',N'DH18DTA',136,120)



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
	Degree varchar(50),
	
	
	Primary key (ID_Professor)
)
insert into Professor Values(N'224',N'A','DT','20/10/2000','Tiến Sĩ')
insert into Professor Values(N'225',N'B','DT','20/10/2000','Thạc Sĩ')
insert into Professor Values(N'226',N'C','DT','20/10/2000','thạc Sĩ')
insert into Professor Values(N'227',N'D','DT','20/10/2000','Phó Giáo sư')
insert into Professor Values(N'228',N'E','DT','20/10/2000','Tiến Sĩ')
insert into Professor Values(N'229',N'F','DT','20/10/2000','Tiến Sĩ')
insert into Professor Values(N'220',N'G','DT','20/10/2000','Tiến Sĩ')

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

insert into Semester Values(N'1_2021','20/10/2021','20/1/2022',2021,1)
insert into Semester Values(N'2_2021','20/11/2021','20/2/2022',2021,2)
insert into Semester Values(N'3_2021','20/2/2022','20/5/2022',2021,3)
insert into Semester Values(N'1_2022','20/10/2021','20/1/2022',2022,1)
insert into Semester Values(N'2_2022','20/10/2021','20/1/2022',2022,2)
insert into Semester Values(N'3_2022','20/10/2021','20/1/2022',2022,3)


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
insert into Course Values(N'2142','DT','máy học',4,3,1)
insert into Course Values(N'2122','DT','chồng rau',2,3,2)
insert into Course Values(N'3222','DT','khoa học máy tính',3,3,1)
insert into Course Values(N'4111','DT','tình yêu và cuộc sống',4,3,1)
insert into Course Values(N'5333','DT','tiếng anh',4,3,1)
insert into Course Values(N'6444','DT','tiếng pháp ',4,3,1)
insert into Course Values(N'7444','DT','tiếng tàu',4,3,1)

-- một lớp được mở cụ thể trong danh sách đăng ký môn học 	
create table Course_Offering
(
	ID_Course_Offering nvarchar(50)  not null,
	ID_Course nvarchar(50) not null FOREIGN KEY REFERENCES Course(ID_Course),
	-- mã lớp (VD DH18DTA)
	Class_code nvarchar(50) not null,
	-- tinyint max value là 255 (từ 0 đến 255)
	-- max size là số sinh viên tối đa của lớp
	Max_Size tinyint not null,
	-- current size là số sinh viên đang hiện có của lớp
	Current_Size tinyint not null,
	-- lịch học thì sẽ có ngày bắt đầu và ngày kết thúc 
	-- ngày bắt đầu
	


	Primary key (ID_Course_Offering)
)
insert into Course_Offering Values(N'1',N'2142','DH18DTA',80,60)
insert into Course_Offering Values(N'2',N'5333','DH18DTA',80,70)
insert into Course_Offering Values(N'3',N'6444','DH18DTA',80,40)
insert into Course_Offering Values(N'4',N'4111','DH18DTA',80,50)
insert into Course_Offering Values(N'5',N'6444','DH18DTA',80,30)
insert into Course_Offering Values(N'6',N'6444','DH18DTA',80,70)
insert into Course_Offering Values(N'7',N'6444','DH18DTA',80,60)
-- mới sửa lại Schedule
-- môn học có thể là thực hành hành hoặc lý thuyết 
-- thực hành lý thuyết khác ngày khác tiết và có ngày bắt đầu với kết thúc là khác nhau

create table Schedule
(
	ID_Schedule nvarchar(50) not null,
	ID_Course_Offering nvarchar(50) not null FOREIGN KEY REFERENCES Course_Offering(ID_Course_Offering),	
	-- Mã giáo viên
	Id_Profeesor nvarchar(50)  not null FOREIGN KEY REFERENCES Professor(ID_Professor),
	-- thứ dạy học
	Theoretical varchar(2) not null,
	Teaching_Day smallint not null,
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
insert into Schedule values(N'1',N'1',N'224','TH',4,'20/10/2021','20/11/2021',N'Rạng Đông',1,4)
insert into Schedule values(N'2',N'2',N'226','LT',5,'20/10/2021','20/11/2021',N'Cẩm Tú',1,4)
insert into Schedule values(N'3',N'1',N'225','LT',6,'20/10/2021','20/11/2021',N'Rạng Đông',1,4)
insert into Schedule values(N'4',N'3',N'224','LT',7,'20/10/2021','20/11/2021',N'Rạng Đông',1,4)
insert into Schedule values(N'5',N'4',N'224','LT',8,'20/10/2021','20/11/2021',N'Rạng Đông',1,4)
insert into Schedule values(N'6',N'2',N'224','LT',9,'20/10/2021','20/11/2021',N'Rạng Đông',1,4)
-- mon hoc tung hoc vien dang ky
create table Student_Schedule
(
    ID_Semester nvarchar(50) not null FOREIGN KEY REFERENCES Semester(ID_Semester),
    ID_Schedule nvarchar(50) not null FOREIGN KEY REFERENCES Schedule(ID_Schedule),
	ID_Student nvarchar(50)  not null FOREIGN KEY REFERENCES Student(ID_Student),
	Primary key (ID_Student,ID_Semester,ID_Schedule)
)
insert into Student_Schedule values('1_2021',N'1',N'18130005')
insert into Student_Schedule values('2_2021',N'2',N'18130077')
insert into Student_Schedule values('1_2022',N'3',N'18130002')
insert into Student_Schedule values('3_2022',N'2',N'18130003')
insert into Student_Schedule values('2_2021',N'1',N'18130004')
insert into Student_Schedule values('2_2022',N'3',N'18130005')
insert into Student_Schedule values('1_2021',N'1',N'18130006')
create table front_Sub
(
	ID_CourseB nvarchar(50),
	ID_Course nvarchar(50) not null FOREIGN KEY REFERENCES Course(ID_Course),
	Primary key (ID_Course)
)
insert into front_Sub values(N'2141',N'2142')
insert into front_Sub values(N'3121',N'3222')
insert into front_Sub values(N'4000',N'4111')
insert into front_Sub values(N'4001',N'5333')
insert into front_Sub values(N'4002',N'6444')
insert into front_Sub values(N'2001',N'7444')




--insert into USER_KIND values (12,12,'student','10@gmail.com','sa');
--select * from USER_KIND

-- Mon hoc da qua
-- Tao đã chia bảng này thành 2 bảng trên kia
create table Sub_Pass
-- sub pass ko co id mon hoc la vi id mon hoc trong schedule /thay hoi sai =))
(
    -- Học kỳ
    ID_Semester nvarchar(50) not null FOREIGN KEY REFERENCES Semester(ID_Semester),
    ID_Course nvarchar(50) not null FOREIGN KEY REFERENCES Course(ID_Course),
	ID_Student nvarchar(50) not null FOREIGN KEY REFERENCES Student(ID_Student),
	-- Điểm	
	Score float not null,
	-- Đánh giá học lực
	Rated nvarchar(10) not null,
	Primary key (ID_Student,ID_Course,ID_Semester)
)
insert into Sub_Pass values('1_2021',N'2142',N'18130005',7.5,N'Khá')
insert into Sub_Pass values('2_2021',N'2122',N'18130003',7.5,N'Khá')
insert into Sub_Pass values('3_2021',N'3222',N'18130002',8.5,N'giỏi')
insert into Sub_Pass values('1_2022',N'4111',N'18130001',2.5,N'Trung Bình')
insert into Sub_Pass values('2_2022',N'2142',N'18130006',7.5,N'khá')
insert into Sub_Pass values('1_2022',N'2122',N'18130005',5.5,N'Trung bình')
insert into Sub_Pass values('3_2022',N'4111',N'18130004',7.5,N'Khá')
insert into Sub_Pass values('2_2021',N'2142',N'18130005',7.5,N'Khá')
-- ket qua theo tung hoc ki
create table semester_Result
(
	ID_Semester nvarchar(50) not null FOREIGN KEY REFERENCES Semester(ID_Semester),
	--
	ID_Student nvarchar(50) not null FOREIGN KEY REFERENCES Student(ID_Student),
	--diem trung binh trong ki nay
	gradeAv float,
	creditGet smallint,
	Primary key (ID_Semester,ID_Student))
	insert into semester_Result values('1_2021',N'18130005',5.6,20)
	insert into semester_Result values('1_2022',N'18130002',5.6,20)
	insert into semester_Result values('2_2022',N'18130003',7.6,16)
	insert into semester_Result values('3_2022',N'18130006',8.6,18)
	insert into semester_Result values('2_2021',N'18130005',2.6,17)
	insert into semester_Result values('3_2021',N'18130002',6.6,12)
create table Final_Result
(
	ID_Student nvarchar(50) not null FOREIGN KEY REFERENCES Student(ID_Student),
	gradeAv	float,
	creditGet smallint,
	Primary key (ID_Student)
)
	insert into Final_Result values(N'18130005',6.6,72)
	insert into Final_Result values(N'18130006',5.6,72)
	insert into Final_Result values(N'18130002',7.6,70)
	insert into Final_Result values(N'18130003',4.6,67)
	insert into Final_Result values(N'18130004',9.6,40)
	insert into Final_Result values(N'18130001',10,30)
	
go
-- thời khóa biểu có học sinh , thời khóa biểu của giáo viên chỉ cần gọi schdule
CREATE FUNCTION TimeTableSt (@ID_User varchar(50))
RETURNS TABLE 
as
RETURN  
select co.*,sd.Id_Profeesor from Schedule sd join Course_Offering co on sd.ID_Course_Offering = co.ID_Course_Offering
									 join Student_Schedule stc on stc.ID_Schedule = sd.ID_Schedule 
			where stc.ID_Student = @ID_User and stc.ID_Semester in (select ID_Semester from Semester where GETDATE() between startDate and endDate )


go

-- những môn sẽ hiển thị khi nhấn đăng ký môn học
--những môn có thể đăng ký của giáo viên thì chọn những môn nào trong bảng schedule có chỗ id pr là null
CREATE FUNCTION SubAvailableST (@ID_User varchar(50))
RETURNS TABLE
as
RETURN  
select sc.* from Course_Offering co join Course c on c.ID_Course = co.ID_Course
													 join front_Sub fs on fs.ID_Course = c.ID_Course
													 join Schedule sc on sc.ID_Course_Offering = co.ID_Course_Offering
													 
where co.Current_Size < co.Max_Size and 
c.ID_Faculty =  case when c.ID_Faculty is null then  c.ID_Faculty else (select ID_Faculty from Student where ID_Student = @ID_User)  end and
c.years <=  case when c.years is null then  c.years else (select (YEAR(GETDATE())-YEAR(Create_date)) from Student where ID_Student = @ID_User)  end and
c.numberS =  case when c.numberS is null then  c.numberS else (select numberS from Semester where ID_Semester in  (select ID_Semester from Semester where GETDATE() between startDate and endDate ))  end and 
fs.ID_CourseB =  case when fs.ID_CourseB is null then  fs.ID_CourseB else (select ID_Course from Sub_Pass where ID_Student = @ID_User and Score >= 4)  end

go
--bảng này là bảng check khi nhấn vào ô chọn môn học nếu trùng giờ trùng ngày , trùng môn nếu rỗng thì ko đk được
create FUNCTION checkDayST (@ID_Schedule nvarchar(50),@ID_User varchar(50))
RETURNS TABLE 
as
RETURN  
select sc.ID_Schedule from Schedule sc join Student_Schedule  stc on sc.ID_Schedule = stc.ID_Schedule
						  join Course_Offering co on co.ID_Course_Offering = sc.ID_Course_Offering
where (sc.Teaching_Day not in (select Teaching_Day from Schedule where ID_Schedule = @ID_Schedule) and sc.Start_Slot  not in (select Start_Slot from Schedule where ID_Schedule = @ID_Schedule) ) 
and stc.ID_Semester in  (select ID_Semester from Semester where GETDATE() between startDate and endDate) 
and co.ID_Course not in (select c1.ID_Course from Schedule sc1 join Course_Offering co1 on sc1.ID_Course_Offering = co1.ID_Course_Offering 
															   join Course c1 on c1.ID_Course = co1.ID_Course
															   where sc1.ID_Schedule = @ID_Schedule)