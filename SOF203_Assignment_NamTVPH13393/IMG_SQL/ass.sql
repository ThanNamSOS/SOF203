CREATE DATABASE FPT_DaoTao
GO 
USE FPT_DaoTao

IF OBJECT_ID('USERS')IS NOT NULL
DROP TABLE USERS
CREATE TABLE USERS
(	
	USERS_NAME	NVARCHAR(50) PRIMARY KEY,
	PASS_WORD	NVARCHAR(50),
	ROLEE		NVARCHAR(50)
)
go
IF OBJECT_ID('STUDENT')IS NOT NULL
DROP TABLE STUDENT
CREATE TABLE STUDENT
(	
	MASV		VARCHAR(10) PRIMARY KEY,
	HOTEN		NVARCHAR(50),
	NGAYSINH	DATE,
	EMAIL		NVARCHAR(50),
	SDT			NVARCHAR(15),
	GIOITINH	BIT,
	DIACHI		NVARCHAR(50),
	HINH		NVARCHAR(50)
)

go
IF OBJECT_ID('GRADE')IS NOT NULL
DROP TABLE GRADE
CREATE TABLE GRADE
(	
	ID			INT IDENTITY PRIMARY KEY,
	MASV		VARCHAR(10),
	TIENGANH	float,
	TINHOC		float,
	GDTC		float
	CONSTRAINT FK_GRADE_STUDENT FOREIGN KEY (MASV) REFERENCES STUDENT
)
DELETE FROM USERS
SELECT * FROM USERS
SELECT * FROM STUDENT
 DELETE FROM STUDENT
INSERT INTO USERS(USERS_NAME,PASS_WORD,ROLEE) VALUES(N'sa',N'513223',N'ADMIN'),
(N'user1',N'513223',N'GIAOVIEN'),
(N'user2',N'513223',N'PHONGDAOTAO')

DELETE FROM GRADE
DBCC CHECKIDENT (GRADE, reseed, 0);---câu lệnh set id về 1
INSERT INTO GRADE(MASV,TIENGANH,TINHOC,GDTC) VALUES('SV001','8','8.6','9'),
('SV002','8','8.6','9')


SELECT * FROM STUDENT WHERE MASV = 'SV005'

SELECT * FROM GRADE

SELECT GRADE.MASV,HOTEN,TIENGANH,TINHOC,GDTC,(SUM(TIENGANH+TINHOC+GDTC)/3) AS DIEMTB 
FROM GRADE
join STUDENT ON GRADE.MASV = STUDENT.MASV
GROUP BY GRADE.MASV,HOTEN,TIENGANH,TINHOC,GDTC


DELETE from STUDENT
DBCC CHECKIDENT (STUDENT, reseed, 0);---câu lệnh set id về 1


INSERT INTO STUDENT VALUES('SV001',N'THAN VAN NAM','1-1-2001',N'NAMTV@gmalcom',N'+099999999',1,N'BAC GIANG',N'1.png')
INSERT INTO STUDENT VALUES('SV002',N'LONGTT','1-2-2002',N'LONGTT@gmal.com',N'+011111222',1,N'HÀ NỘI',N'2.png')

SELECT *  from STUDENT 
=====================================
DROP PROCEDURE DELETE_MASV
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE DELETE_MASV
	@MASV VARCHAR(10)
AS
BEGIN
DELETE FROM GRADE 
    WHERE MASV =@MASV
	DELETE FROM STUDENT
    WHERE MASV =@MASV
END
GO
exec DELETE_MASV 'SV001'


====== ========================================
DROP PROCEDURE select_theoMaSV
CREATE PROCEDURE select_theoMaSV
	@MASV VARCHAR(10)
AS
BEGIN
select HOTEN,TIENGANH,TINHOC,GDTC from GRADE
Join STUDENT on STUDENT.MASV = GRADE.MASV
where STUDENT.MASV = @MASV
END

exec select_theoMaSV  'SV009'
====== ========================================
select * from GRADE
select top 3 * from GRADE WHERE 
SELECT 
==============TOP3SV============

	select top 3  ID,GRADE.MASV,TIENGANH,TINHOC,GDTC,(TIENGANH+TINHOC+GDTC)/3 AS TBM
from GRADE inner join STUDENT on STUDENT.MASV=GRADE.MASV
order by TBM desc

SELECT * FROM GRADE
SELECT * FROM STUDENT