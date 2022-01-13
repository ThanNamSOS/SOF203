use Polypro

select * from NhanVien
INSERT INTO NhanVien (MaNV, MatKhau, HoTen, VaiTro) VALUES (?, ?, ?, ?)
UPDATE NhanVien SET MatKhau=?, HoTen=?, VaiTro=? WHERE MaNV=?
DELETE FROM NhanVien WHERE MaNV=?
SELECT * FROM NhanVien
SELECT * FROM NhanVien WHERE MaNV=?

select * from HocVien
INSERT INTO HocVien (MaKH, MaNH, Diem) VALUES (?, ?, ?)
UPDATE HocVien SET MaKH=?, MaNH=?, Diem=? WHERE MaHV=?
DELETE FROM HocVien WHERE MaHV=?
SELECT * FROM HocVien
SELECT * FROM HocVien WHERE MaHV=?select * from KhoaHocINSERT INTO KhoaHoc (MaCD, HocPhi, ThoiLuong, NgayKG, GhiChu, MaNV, NgayTao)
VALUES (?, ?, ?, ?, ?, ?, ?)
UPDATE KhoaHoc SET MaCD=?, HocPhi=?, ThoiLuong=?, NgayKG=?, GhiChu=?, MaNV=?,
WHERE MaKH=?
DELETE FROM KhoaHoc WHERE MaKH=?
 SELECT * FROM KhoaHoc
 SELECT * FROM KhoaHoc WHERE MaKH=? select * from NguoiHoc INSERT INTO NguoiHoc (MaNH, HoTen, NgaySinh, GioiTinh, DienThoai, Email,GhiChu, MaNV, NgayDK) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)
UPDATE NguoiHoc SET HoTen=?, NgaySinh=?, GioiTinh=?, DienThoai=?, Email=?,GhiChu=?, MaNV=?, NgayDK=? WHERE MaNH=?
DELETE FROM NguoiHoc WHERE MaNH=?
SELECT * FROM NguoiHoc
SELECT * FROM NguoiHoc WHERE MaNH=? select * from ChuyenDeINSERT INTO ChuyenDe (MaCD, TenCD, HocPhi, ThoiLuong, Hinh, MoTa) VALUES (?, ?,
?, ?, ?, ?)
UPDATE ChuyenDe SET TenCD=?, HocPhi=?, ThoiLuong=?, Hinh=?, MoTa=? WHERE MaCD=?
DELETE FROM ChuyenDe WHERE MaCD=?
 SELECT * FROM ChuyenDe
 SELECT * FROM ChuyenDe WHERE MaCD=?