USE Polypro
CREATE PROCEDURE SELECT_MANV_FROM_NGUOIHOC
	@MaNV NVARCHAR(10)
AS
BEGIN
	select top 1 NguoiHoc.MaNV, NhanVien.HoTen FROM NguoiHoc 
	JOIN NhanVien on NhanVien.MaNV = NguoiHoc.MaNV
	WHERE NguoiHoc.MaNV = @MaNV
END
GO
EXEC SELECT_MANV_FROM_NGUOIHOC 'TeoNV'

CREATE PROCEDURE delete_NguoiHoc 
	@MaNguoiHoc nvarchar(10)
AS
BEGIN
	DELETE FROM HocVien WHERE MaNH = @MaNguoiHoc
	DELETE FROM NguoiHoc where MaNH = @MaNguoiHoc
END
GO

exec delete_NguoiHoc PS02979

drop PROCEDURE delete_ChuyenDe 
go
CREATE PROCEDURE delete_ChuyenDe 
	@MaCD nvarchar(10)
AS
BEGIN
	DELETE FROM HocVien WHERE MaKH = (SELECT MaKH FROM KhoaHoc where MaCD = 'JAV01')
	DELETE FROM KhoaHoc WHERE MaCD =  @MaCD
	DELETE FROM ChuyenDe WHERE MaCD = 'JAV01'
END
GO
EXEC delete_ChuyenDe 'JAV03'

drop PROCEDURE update_ChuyenDe 
go
CREATE PROCEDURE update_ChuyenDe 

	@TenCD nvarchar(50),
	@HocPhi float,
	@ThoiLuong int,
	@MoTa nvarchar(225),
	@anh nvarchar(225),
	@MaCD nvarchar(10)
AS
BEGIN
	UPDATE ChuyenDe SET TenCD = @TenCD,HocPhi =@HocPhi ,ThoiLuong = @ThoiLuong,hinh = @anh,mota =@MoTa WHERE MaCD = @MaCD
END
GO
EXEC update_ChuyenDe  'NAMtv',23000,60,'JAV03 - Lập trình mạng với Java','JAV03'
select [MaCD], [TenCD], [HocPhi], [ThoiLuong], [MoTa] from ChuyenDe WHERE MaCD = ?
select * from NguoiHoc
select COUNT(MaNH) AS SONH from NguoiHoc

-- TÍNH SỐ LƯỢNG NGƯỜI HỌC MỖI NĂM
SELECT YEAR(NgayDK)as nam, COUNT(  MaNH) AS Soluong,min(NgayDK) as ngaydauten, MAX(NgayDK)as ngaycuoi
  FROM NguoiHoc
  GROUP BY YEAR(NgayDK);
  -- Thống kê bảng điểm
  select NguoiHoc.MaNH,HoTen,Diem from NguoiHoc
  join HocVien on HocVien.MaNH = NguoiHoc.MaNH
  -- 
  CREATE PROCEDURE SELECT_MAkh
	@MaKH nvarchar(10)
AS
BEGIN
	  select NguoiHoc.MaNH,HoTen,Diem from NguoiHoc
  join HocVien on HocVien.MaNH = NguoiHoc.MaNH
  where HocVien.MaKH = @MaKH
END
GO
exec SELECT_MAkh 1
--thống kê tổng hợp điểm tenCD,SokhoaHoc,SoHocVien,DiemMax,DiemMin,DiemTB
SELECT * FROM ChuyenDe
SELECT * FROM KhoaHoc
SELECT * FROM HocVien

 CREATE PROCEDURE SELECT_TongHopDiem
AS
BEGIN
	 SELECT ChuyenDe.TenCD, COUNT(HocVien.MaHV) AS SoHV,MAX(HocVien.Diem) as DiemMax,
Min(HocVien.Diem) as DiemMin,AVG(HocVien.Diem) as DIEMTB FROM KhoaHoc
JOIN ChuyenDe ON KhoaHoc.MaCD = ChuyenDe.MaCD
jOIN HocVien on HocVien.MaKH = KhoaHoc.MaKH
GROUP BY ChuyenDe.TenCD
END
GO

exec SELECT_TongHopDiem
--thống kê tổng hợp doanh thu tenCD,SokhoaHoc,SoHocVien,HocPhiMax,HocPhiMin,HocPhiTB
select * from ChuyenDe
select * from KhoaHoc
select * from HocVien
select * from NguoiHoc

drop PROCEDURE sp_ThongKeDoanhThu
go
CREATE PROCEDURE sp_ThongKeDoanhThu
@Year int 
as
BEGIN
SELECT
TenCD ,YEAR(NgayKG) as yeaar,
COUNT(DISTINCT kh.MaKH)as SoKH,
COUNT(hv.MaHV) as SoHV,
SUM(kh.HocPhi)as DoanhThu,
MIN(kh.HocPhi)as ThapNhat,
MAX(kh.HocPhi)as CaoNhat,
AVG(kh.HocPhi) asTrungBinh
FROM KhoaHoc kh
JOIN HocVien hv ON kh.MaKH=hv.MaKH
JOIN ChuyenDe cd ON cd.MaCD=kh.MaCD
--WHERE YEAR(NgayKG) = @Year
GROUP BY TenCD,YEAR(NgayKG);
END;

exec sp_ThongKeDoanhThu 2018
exec sp_ThongKeDoanhThu 2021
select distinct YEAR(NgayKG) from KhoaHoc
select * from KhoaHoc
select * from NhanVien


CREATE PROCEDURE SELECT_TK_DoanhThu
AS
BEGIN
SELECT
TenCD ,YEAR(NgayKG) as yeaar,
COUNT(DISTINCT kh.MaKH)as SoKH,
COUNT(hv.MaHV) as SoHV,
SUM(kh.HocPhi)as DoanhThu,
MIN(kh.HocPhi)as ThapNhat,
MAX(kh.HocPhi)as CaoNhat,
AVG(kh.HocPhi) asTrungBinh
FROM KhoaHoc kh
JOIN HocVien hv ON kh.MaKH=hv.MaKH
JOIN ChuyenDe cd ON cd.MaCD=kh.MaCD
--WHERE YEAR(NgayKG) = @Year
GROUP BY TenCD,YEAR(NgayKG)
END
GO

exec SELECT_TK_DoanhThu

select * from NhanVien
select * from NguoiHoc
SELECT MaNV FROM NhanVien WHERE MaNV = ?

CREATE PROCEDURE DELETE_NHANVIEN
	@MANV	NVARCHAR(10)
AS
BEGIN
	DELETE FROM KhoaHoc WHERE MaNV = @MANV
	DELETE FROM NguoiHoc WHERE MaNV = @MANV
	DELETE FROM NhanVien WHERE MaNV = @MANV
END
GO

exec DELETE_NHANVIEN 

SELECT MaNH FROM NguoiHoc WHERE MaNH = ?