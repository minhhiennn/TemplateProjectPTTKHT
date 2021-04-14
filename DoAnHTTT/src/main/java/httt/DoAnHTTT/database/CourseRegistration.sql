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
	Name_Faculty nvarchar(50) not null,
	
	Primary key (ID_Faculty)
)
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
	Class_code nvarchar(50) not null,
	-- Thêm vào số chứng chỉ bắt buộc ra trường
	-- Ngành CNTT thì tao nhớ ko nhầm tích lũy 145 chỉ là dc ra trường
	Cert_number_required SMALLINT not null, -- Tính năng mới
	-- Số chứng chỉ đã tích lũy được
	Cert_number_accumulated smallint not null, -- Tính năng mới
	Primary key (ID_Student)
)
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
	Id_Profeesor nvarchar(50)  not null FOREIGN KEY REFERENCES Professor(ID_Professor),
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
	Score float not null check (Score < 10 and Score > 0),
	-- Đánh giá học lực
	Rated nvarchar(10) not null,
	Primary key (ID_Student,ID_Course,ID_Semester)
)
-- ket qua theo tung hoc ki
create table semester_Result
(
	ID_Semester nvarchar(50) not null FOREIGN KEY REFERENCES Semester(ID_Semester),
	--
	ID_Student nvarchar(50) not null FOREIGN KEY REFERENCES Student(ID_Student),
	--diem trung binh trong ki nay
	gradeAv float,
	creditGet smallint,
	Primary key (ID_Semester,ID_Student)
)
create table Final_Result
(
	ID_Student nvarchar(50) not null FOREIGN KEY REFERENCES Student(ID_Student),
	gradeAv	float,
	creditGet smallint,
	Primary key (ID_Student)
)
-- insert into users
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

--dữ liệu bảng Student
insert into Student Values(N'18130005',N'Đàm Văn Anh','DT','20/10/2018',N'DH18DTA',136,0)
insert into Student Values(N'18130077',N'Ngô Minh Hiển','DT','22/10/2018',N'DH18DTA',136,0)
insert into Student Values(N'18130001',N'Nguyễn Văn A','DT','20/10/2018',N'DH18DTA',136,0)
insert into Student Values(N'18130002',N'Nguyễn Văn B','DT','20/10/2018',N'DH18DTA',136,0)
insert into Student Values(N'18130003',N'Nguyễn Văn C','DT','20/10/2018',N'DH18DTA',136,0)
insert into Student Values(N'18130004',N'Nguyễn Văn D','DT','20/10/2018',N'DH18DTA',136,0)
insert into Student Values(N'18130006',N'Nguyễn Văn E','DT','20/10/2018',N'DH18DTA',136,0)

-- insert into Professor
insert into Professor Values(N'224',N'A','DT','20/10/2000',N'Tiến Sĩ')
insert into Professor Values(N'225',N'B','DT','20/10/2000',N'Thạc Sĩ')
insert into Professor Values(N'226',N'C','DT','20/10/2000',N'thạc Sĩ')
insert into Professor Values(N'227',N'D','DT','20/10/2000',N'Phó Giáo sư')
insert into Professor Values(N'228',N'E','DT','20/10/2000',N'Tiến Sĩ')
insert into Professor Values(N'229',N'F','DT','20/10/2000',N'Tiến Sĩ')
insert into Professor Values(N'220',N'G','DT','20/10/2000',N'Tiến Sĩ')

-- insert into Semester
insert into Semester Values(N'1_2018','1/9/2018','31/1/2019',2021,1)
insert into Semester Values(N'2_2018','1/3/2019','30/6/2019',2021,2)
insert into Semester Values(N'1_2019','1/9/2019','31/1/2020',2022,1)
insert into Semester Values(N'2_2019','1/3/2020','30/6/2020',2022,2)
insert into Semester Values(N'1_2020','1/9/2020','31/1/2021',2022,1)
insert into Semester Values(N'2_2020','1/3/2021','30/6/2021',2022,2)
insert into Semester Values(N'1_2021','1/9/2021','31/1/2022',2022,1)
insert into Semester Values(N'2_2021','1/3/2022','30/6/2022',2022,2)

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

-- insert into Schedule
-- lười chèn vc
insert into Schedule values(N'1',N'1',N'224','LT',4,'20/10/2021','20/11/2021',N'Rạng Đông',1,4)
insert into Schedule values(N'1a',N'1',N'224','LT',4,'20/10/2021','20/11/2021',N'Rạng Đông',1,4)
insert into Schedule values(N'1c',N'1',N'224','LT',4,'20/10/2021','20/11/2021',N'Rạng Đông',1,4)
insert into Schedule values(N'1b',N'20',N'224','LT',4,'20/10/2021','20/11/2021',N'Rạng Đông',1,4)
insert into Schedule values(N'2',N'2',N'225','LT',8,'20/10/2021','20/11/2021',N'Cẩm Tú',1,4)
insert into Schedule values(N'3',N'3',N'226','LT',5,'20/10/2021','20/11/2021',N'Cẩm Tú',1,4)
insert into Schedule values(N'4',N'4',N'227','LT',7,'20/10/2021','20/11/2021',N'Rạng Đông',1,4)
insert into Schedule values(N'5',N'5',N'228','LT',5,'20/10/2021','20/11/2021',N'Rạng Đông',1,4)
insert into Schedule values(N'6',N'5',N'229','TH',3,'20/10/2021','20/11/2021',N'Rạng Đông',1,4)
insert into Schedule values(N'7',N'6',N'224','LT',4,'20/10/2021','20/11/2021',N'Rạng Đông',1,4)
insert into Schedule values(N'8',N'7',N'225','LT',8,'20/10/2021','20/11/2021',N'Cẩm Tú',1,4)
insert into Schedule values(N'9',N'8',N'226','LT',5,'20/10/2021','20/11/2021',N'Cẩm Tú',1,4)
insert into Schedule values(N'10',N'9',N'227','LT',7,'20/10/2021','20/11/2021',N'Rạng Đông',1,4)
insert into Schedule values(N'11',N'10',N'228','LT',5,'20/10/2021','20/11/2021',N'Rạng Đông',1,4)
insert into Schedule values(N'12',N'11',N'229','TH',3,'20/10/2021','20/11/2021',N'Rạng Đông',1,4)
insert into Schedule values(N'13',N'12',N'224','LT',4,'20/10/2021','20/11/2021',N'Rạng Đông',1,4)
insert into Schedule values(N'14',N'13',N'225','LT',8,'20/10/2021','20/11/2021',N'Cẩm Tú',1,4)
insert into Schedule values(N'15',N'13',N'226','TH',5,'20/10/2021','20/11/2021',N'Cẩm Tú',1,4)
insert into Schedule values(N'16',N'15',N'227','LT',7,'20/10/2021','20/11/2021',N'Rạng Đông',1,4)
insert into Schedule values(N'17',N'16',N'228','LT',5,'20/10/2021','20/11/2021',N'Rạng Đông',1,4)
insert into Schedule values(N'18',N'17',N'229','TH',3,'20/10/2021','20/11/2021',N'Rạng Đông',1,4)
insert into Schedule values(N'19',N'19',N'228','LT',5,'20/10/2021','20/11/2021',N'Rạng Đông',1,4)
insert into Schedule values(N'20',N'19',N'229','TH',3,'20/10/2021','20/11/2021',N'Rạng Đông',1,4)

-- insert into Student_Schedule
-- 
--insert into Student_Schedule values('1_2021',N'1',N'18130005')
--insert into Student_Schedule values('2_2021',N'2',N'18130077')
--insert into Student_Schedule values('1_2022',N'3',N'18130002')
--insert into Student_Schedule values('3_2022',N'2',N'18130003')
--insert into Student_Schedule values('2_2021',N'1',N'18130004')
--insert into Student_Schedule values('2_2022',N'3',N'18130005')
--insert into Student_Schedule values('1_2021',N'1',N'18130006')
insert into Student_Schedule values('2_2020',N'1',N'18130005')
insert into Student_Schedule values('2_2020',N'2',N'18130005')
insert into Student_Schedule values('2_2020',N'3',N'18130005')
insert into Student_Schedule values('2_2020',N'4',N'18130005')


-- insert into front_Sub
insert into front_Sub values(N'214331',N'214321')

insert into front_Sub values(N'214441',N'214331')

-- insert into Sub_Pass

insert into Sub_Pass values('2_2018',N'213603',N'18130005',7.5,N'Khá')
insert into Sub_Pass values('2_2018',N'214321',N'18130003',7.5,N'Khá')
--insert into Sub_Pass values('3_2021',N'3222',N'18130002',8.5,N'giỏi')
--insert into Sub_Pass values('1_2022',N'4111',N'18130001',2.5,N'Trung Bình')
--insert into Sub_Pass values('2_2022',N'2142',N'18130006',7.5,N'khá')
--insert into Sub_Pass values('1_2022',N'2122',N'18130005',5.5,N'Trung bình')
--insert into Sub_Pass values('3_2022',N'4111',N'18130004',7.5,N'Khá')
--insert into Sub_Pass values('2_2021',N'2142',N'18130005',7.5,N'Khá')

-- insert into semester_Result
-- như cc
--insert into semester_Result values('1_2021',N'18130005',5.6,20)
--insert into semester_Result values('1_2022',N'18130002',5.6,20)
--insert into semester_Result values('2_2022',N'18130003',7.6,16)
--insert into semester_Result values('3_2022',N'18130006',8.6,18)
--insert into semester_Result values('2_2021',N'18130005',2.6,17)
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
alter FUNCTION SubAvailableST (@ID_User varchar(50))
RETURNS TABLE
as
RETURN  
select sc.ID_Schedule from Course_Offering co join Course c on c.ID_Course = co.ID_Course
													 join Schedule sc on sc.ID_Course_Offering = co.ID_Course_Offering
													 
where co.Current_Size < co.Max_Size and 
c.ID_Faculty =  case when c.ID_Faculty is null then  c.ID_Faculty else (select ID_Faculty from Student where ID_Student = @ID_User)  end and
c.years <=  case when c.years is null then  c.years else (select (YEAR(GETDATE())-YEAR(Create_date)) from Student where ID_Student = @ID_User) end and
c.numberS =  case when c.numberS is null then  c.numberS else (select numberS from Semester where ID_Semester in  (select ID_Semester from Semester where GETDATE() between startDate and endDate ))  end and
c.ID_Course = case when (select ID_CourseB from front_Sub where ID_CourseB = c.ID_Course) is null then  c.ID_Course
when [dbo].subPassed (c.ID_Course,@ID_User)  is null then null else [dbo].subPassed (c.ID_Course,@ID_User)  end

go
select * from SubAvailableST('18130005');

go
-- bảng này là bảng check khi nhấn vào ô chọn môn học nếu trùng giờ trùng ngày , trùng môn nếu rỗng thì ko đk được


create FUNCTION checkTeachDay (@ID_User varchar(50))
RETURNS TABLE 
as
RETURN  
select sc.Teaching_Day from Schedule sc join Student_Schedule stc on sc.ID_Schedule = stc.ID_Schedule
					   where stc.ID_Student = @ID_User and stc.ID_Semester in  (select ID_Semester from Semester where GETDATE() between startDate and endDate)
go
create FUNCTION checkStart_Slot (@ID_User varchar(50))
RETURNS TABLE 
as
RETURN  
select sc.Start_Slot from Schedule sc join Student_Schedule stc on sc.ID_Schedule = stc.ID_Schedule
					   where stc.ID_Student = @ID_User and stc.ID_Semester in  (select ID_Semester from Semester where GETDATE() between startDate and endDate)
go

create FUNCTION checkSubExist (@ID_User varchar(50))
RETURNS TABLE 
as
RETURN  
select c.ID_Course from Schedule sc join Student_Schedule stc on sc.ID_Schedule = stc.ID_Schedule
						join Course_Offering co on co.ID_Course_Offering = sc.ID_Course_Offering
						join Course c on c.ID_Course = co.ID_Course
						where stc.ID_Student  = @ID_User and stc.ID_Semester in  (select ID_Semester from Semester where GETDATE() between startDate and endDate)
go

alter FUNCTION checkDayST (@ID_Schedule nvarchar(50),@ID_User varchar(50))
RETURNS TABLE 
as
RETURN  
select sc.ID_Schedule from Schedule sc  join Course_Offering co on co.ID_Course_Offering = sc.ID_Course_Offering
						  
where  ((sc.Teaching_Day   in (select Teaching_Day from checkTeachDay(@ID_User)) and sc.Start_Slot   in (select Start_Slot from checkStart_Slot(@ID_User)))
 or co.ID_Course   in (select ID_Course from checkSubExist(@ID_User)))
 and sc.ID_Schedule = @ID_Schedule
 go
 -- a là y chang nên ko được
 -- b là khác môn nhưng trùng giờ
 -- 20 là được

--insert into Schedule values(N'1',N'1',N'224','LT',4,'20/10/2021','20/11/2021',N'Rạng Đông',1,4)
--insert into Schedule values(N'1a',N'1',N'224','LT',4,'20/10/2021','20/11/2021',N'Rạng Đông',1,4)
--insert into Schedule values(N'1c',N'1',N'224','LT',4,'20/10/2021','20/11/2021',N'Rạng Đông',1,4)
--insert into Schedule values(N'1b',N'20',N'224','LT',4,'20/10/2021','20/11/2021',N'Rạng Đông',1,4)
--insert into Schedule values(N'20',N'19',N'229','TH',3,'20/10/2021','20/11/2021',N'Rạng Đông',1,4)

--insert into Student_Schedule values('2_2020',N'1',N'18130005')
--insert into Student_Schedule values('2_2020',N'2',N'18130005')
--insert into Student_Schedule values('2_2020',N'3',N'18130005')
--insert into Student_Schedule values('2_2020',N'4',N'18130005')

 select * from checkDayST(N'1a','18130005');
 select * from checkDayST(N'1b','18130005');
 select * from checkDayST(N'1c','18130005');
 select * from checkDayST(N'20','18130005');
 select * from Student_Schedule
go

-- tạo trigger cho phần kiểm tra nhập điểm giáo viên