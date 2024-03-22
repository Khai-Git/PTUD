USE MASTER
GO

DROP DATABASE KARAOKE_Nice
GO

CREATE DATABASE KARAOKE_Nice
GO

use KARAOKE_Nice
GO

-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

DROP TABLE HoaDonDatPhong
GO
DROP TABLE HoaDonSanPham
GO
DROP TABLE PhieuDatPhong
GO
DROP TABLE ChiTietHoaDonDatPhong
GO
DROP TABLE ChiTietHoaDonSanPham
GO
DROP TABLE ChiTietPhieuDatPhong
GO
DROP TABLE KhachHang
GO
DROP TABLE NhanVien
GO
DROP TABLE Phong
GO
DROP TABLE SanPham
GO
DROP TABLE TaiKhoan
GO

-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

CREATE FUNCTION AUTO_IDNV()
RETURNS VARCHAR(10)
AS
BEGIN
	DECLARE @ID VARCHAR(10)
	IF (SELECT COUNT(maNv) FROM NhanVien) = 0
		SET @ID = N'0'
	ELSE
		SELECT @ID = MAX(RIGHT(maNv, 3)) FROM NhanVien
		SELECT @ID = CASE
			WHEN @ID >= 0 AND @ID < 9 THEN N'NV00' + CONVERT(CHAR, CONVERT(INT, @ID) + 1)
			WHEN @ID >= 9 THEN N'NV0' + CONVERT(CHAR, CONVERT(INT, @ID) + 1)
		END
	RETURN @ID
END

-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

CREATE TABLE Phong(
   maPhong  VARCHAR (10) PRIMARY KEY,
   tenPhong NVARCHAR (30) NOT NULL,     
   trangThai NVARCHAR (30) NOT NULL,     
   sucChua INT NOT NULL, 
   tenLoai NVARCHAR (30) NOT NULL,
	donGia INT NOT NULL
);
GO

INSERT INTO Phong (maPhong, tenPhong, trangThai, sucChua, tenLoai, donGia) VALUES (N'PT001', N'Phòng 2.01', N'Trống', 10,N'Thuong',150000)
GO
INSERT INTO Phong (maPhong, tenPhong, trangThai, sucChua, tenLoai, donGia) VALUES (N'PT002', N'Phòng 2.02', N'Trống', 15,N'Thuong',150000)
GO
INSERT INTO Phong (maPhong, tenPhong, trangThai, sucChua, tenLoai, donGia) VALUES (N'PT003', N'Phòng 2.03', N'Đang sử dụng', 15,N'Thuong',150000)
GO
INSERT INTO Phong (maPhong, tenPhong, trangThai, sucChua, tenLoai, donGia) VALUES (N'PT004', N'Phòng 2.04', N'Đang sử dụng', 10,N'Thuong',150000)
GO
INSERT INTO Phong (maPhong, tenPhong, trangThai, sucChua, tenLoai, donGia) VALUES (N'PT005', N'Phòng 3.03', N'Đang sử dụng', 25,N'Thuong',150000)
GO
INSERT INTO Phong (maPhong, tenPhong, trangThai, sucChua, tenLoai, donGia) VALUES (N'PT006', N'Phòng 3.04', N'Trống', 25,N'Thuong',150000)
GO
INSERT INTO Phong (maPhong, tenPhong, trangThai, sucChua, tenLoai, donGia) VALUES (N'PT008', N'Phòng 3.08', N'Trống', 30,N'Thuong',150000)
GO
INSERT INTO Phong (maPhong, tenPhong, trangThai, sucChua, tenLoai, donGia) VALUES (N'PT009', N'Phòng 3.09', N'Trống', 30,N'Thuong',150000)
GO
INSERT INTO Phong (maPhong, tenPhong, trangThai, sucChua, tenLoai, donGia) VALUES (N'PT010', N'Phòng 3.10', N'Trống', 30,N'Thuong',150000)
GO
INSERT INTO Phong (maPhong, tenPhong, trangThai, sucChua, tenLoai, donGia) VALUES (N'PT011', N'Phòng 3.11', N'Trống', 30,N'Thuong',150000)
GO
INSERT INTO Phong (maPhong, tenPhong, trangThai, sucChua, tenLoai, donGia) VALUES (N'PT012', N'Phòng 3.12', N'Trống', 30,N'Thuong',150000)
GO
INSERT INTO Phong (maPhong, tenPhong, trangThai, sucChua, tenLoai, donGia) VALUES (N'PT013', N'Phòng 3.13', N'Trống', 30,N'Thuong',150000)
GO
INSERT INTO Phong (maPhong, tenPhong, trangThai, sucChua, tenLoai, donGia) VALUES (N'PT014', N'Phòng 3.14', N'Trống', 30,N'Thuong',150000)
GO
INSERT INTO Phong (maPhong, tenPhong, trangThai, sucChua, tenLoai, donGia) VALUES (N'PT015', N'Phòng 3.15', N'Trống', 30,N'Thuong',150000)
GO
INSERT INTO Phong (maPhong, tenPhong, trangThai, sucChua, tenLoai, donGia) VALUES (N'PT016', N'Phòng 3.16', N'Trống', 30,N'Thuong',150000)
GO
INSERT INTO Phong (maPhong, tenPhong, trangThai, sucChua, tenLoai, donGia) VALUES (N'PT008', N'Phòng 3.05', N'Đang sử dụng', 30,N'Thường',150000)
GO
INSERT INTO Phong (maPhong, tenPhong, trangThai, sucChua, tenLoai, donGia) VALUES (N'PV001', N'Phòng 2.05', N'Đang sử dụng', 20,N'Vip',300000)
GO
INSERT INTO Phong (maPhong, tenPhong, trangThai, sucChua, tenLoai, donGia) VALUES (N'PV002', N'Phòng 2.06', N'Trống', 20,N'Vip',300000)
GO
INSERT INTO Phong (maPhong, tenPhong, trangThai, sucChua, tenLoai, donGia) VALUES (N'PV003', N'Phòng 2.07', N'Trống', 20,N'Vip',300000)
GO
INSERT INTO Phong (maPhong, tenPhong, trangThai, sucChua, tenLoai, donGia) VALUES (N'PV004', N'Phòng 2.08', N'Đang sử dụng', 25,N'Vip',300000)
GO
INSERT INTO Phong (maPhong, tenPhong, trangThai, sucChua, tenLoai, donGia) VALUES (N'PV005', N'Phòng 2.09', N'Trống', 25,N'Vip',300000)
GO
INSERT INTO Phong (maPhong, tenPhong, trangThai, sucChua, tenLoai, donGia) VALUES (N'PV006', N'Phòng 2.10', N'Trống', 30,N'Vip',300000)
GO
INSERT INTO Phong (maPhong, tenPhong, trangThai, sucChua, tenLoai, donGia) VALUES (N'PV007', N'Phòng 3.01', N'Đang sử dụng', 20,N'Vip',300000)
GO
INSERT INTO Phong (maPhong, tenPhong, trangThai, sucChua, tenLoai, donGia) VALUES (N'PV008', N'Phòng 3.02', N'Đang sử dụng', 20,N'Vip',300000)
GO
INSERT INTO Phong (maPhong, tenPhong, trangThai, sucChua, tenLoai, donGia) VALUES (N'PV009', N'Phòng 3.09', N'Đang sử dụng', 20,N'Vip',300000)
GO
INSERT INTO Phong (maPhong, tenPhong, trangThai, sucChua, tenLoai, donGia) VALUES (N'PV010', N'Phòng 3.10', N'Đang sử dụng', 20,N'Vip',300000)
GO
INSERT INTO Phong (maPhong, tenPhong, trangThai, sucChua, tenLoai, donGia) VALUES (N'PV011', N'Phòng 3.11', N'Đang sử dụng', 20,N'Vip',300000)
GO
INSERT INTO Phong (maPhong, tenPhong, trangThai, sucChua, tenLoai, donGia) VALUES (N'PV012', N'Phòng 3.12', N'Trống', 30,N'Vip',150000)
GO

CREATE TABLE KhachHang(
   maKH  VARCHAR (10) PRIMARY KEY,
   tenKH NVARCHAR (40) NOT NULL,     
   sdt NVARCHAR (30) NOT NULL,     
   diaChi NVARCHAR (50) NOT NULL, 
   cmnd VARCHAR (30) NOT NULL,
);
GO

INSERT INTO KhachHang (maKH,tenKH, sdt, diaChi, cmnd) VALUES (N'KH001', N'Nguyen Van A', N'0123465679', N'47A, Phạm Văn Đồng, TP HCM', N'08726236232')
GO
INSERT INTO KhachHang (maKH,tenKH, sdt, diaChi, cmnd) VALUES (N'KH002', N'Nguyen Van B', N'7392387724', N'48A, Phạm Ngũ Lão, TP HCM', N'018092830127')
GO
INSERT INTO KhachHang (maKH,tenKH, sdt, diaChi, cmnd) VALUES (N'KH003', N'Nguyen Van C', N'2543253425', N'42A, Võ Văn Kiệt , TP HCM', N'525617635267')
GO
INSERT INTO KhachHang (maKH,tenKH, sdt, diaChi, cmnd) VALUES (N'KH004', N'Nguyen Van D', N'3245322352', N'50A, Nguyễn Văn Linh, TP HCM', N'21683612789')
GO
INSERT INTO KhachHang (maKH,tenKH, sdt, diaChi, cmnd) VALUES (N'KH005', N'Nguyen Van E', N'0980213712', N'55A, Lê Văn Duyệt, TP HCM', N'09089287911')
GO
INSERT INTO KhachHang (maKH,tenKH, sdt, diaChi, cmnd) VALUES (N'KH006', N'Nguyen Van F', N'0102372121', N'52A, Nguyễn Trãi, TP HCM', N'78297108311')
GO
INSERT INTO KhachHang (maKH,tenKH, sdt, diaChi, cmnd) VALUES (N'KH007', N'Nguyen Van G', N'7392387724', N'48A, Phạm Ngũ Lão, TP HCM', N'018092830127')
GO
INSERT INTO KhachHang (maKH,tenKH, sdt, diaChi, cmnd) VALUES (N'KH008', N'Nguyen Van H', N'2543253425', N'42A, Võ Văn Kiệt , TP HCM', N'525617635267')
GO
INSERT INTO KhachHang (maKH,tenKH, sdt, diaChi, cmnd) VALUES (N'KH009', N'Nguyen Van M', N'3245322352', N'50A, Nguyễn Văn Linh, TP HCM', N'21683612789')
GO
INSERT INTO KhachHang (maKH,tenKH, sdt, diaChi, cmnd) VALUES (N'KH0011', N'Nguyen Van N', N'0980213712', N'55A, Lê Văn Duyệt, TP HCM', N'09089287911')
GO
INSERT INTO KhachHang (maKH,tenKH, sdt, diaChi, cmnd) VALUES (N'KH0012', N'Nguyen Van S', N'0102372121', N'52A, Nguyễn Trãi, TP HCM', N'78297108311')
GO
INSERT INTO KhachHang (maKH,tenKH, sdt, diaChi, cmnd) VALUES (N'KH0016', N'Nguyen Van T', N'0852135641', N'52A, Nguyễn Trãi, TP HCM', N'85621458741')
GO

GO

CREATE TABLE TaiKhoan(
	taiKhoan NVARCHAR (40) PRIMARY KEY,
	matKhau NVARCHAR (30) NOT NULL,
);
GO

INSERT INTO TaiKhoan (taiKhoan, matKhau) VALUES (N'letanhoangnam', N'nolehoangnam')
GO
INSERT INTO TaiKhoan (taiKhoan, matKhau) VALUES (N'letanthienkhai', N'letanlontuoi')
GO
INSERT INTO TaiKhoan (taiKhoan, matKhau) VALUES (N'letanhaunghia', N'letanluoibieng')
GO
INSERT INTO TaiKhoan (taiKhoan, matKhau) VALUES (N'quanlihuunha', N'quanlideptrai')
GO

GO

CREATE TABLE NhanVien(
   maNv  VARCHAR (10) PRIMARY KEY CONSTRAINT IDNV DEFAULT DBO.AUTO_IDNV(),
   tenNV NVARCHAR (40) NOT NULL,     
   sdt NVARCHAR (30) NOT NULL,
   gioiTinh  NVARCHAR (30) NOT NULL,
   chucVu NVARCHAR (30) NOT NULL,
   taiKhoan NVARCHAR (40) NOT NULL, 
   CONSTRAINT df_NV_TK FOREIGN KEY(taiKhoan) REFERENCES TaiKhoan(taiKhoan),
);
GO

INSERT INTO NhanVien (maNv,tenNV,sdt,gioiTinh,chucVu,taiKhoan) VALUES (N'NV001', N'Trần Nguyễn Hoàng Nam', N'0367345322', N'Nam', N'Lễ tân', N'letanhoangnam');
GO
INSERT INTO NhanVien (maNv,tenNV,sdt,gioiTinh,chucVu,taiKhoan) VALUES (N'NV002', N'Đặng Phạm Thiên Khải', N'0982628272', N'Nam', N'Lễ tân', N'letanthienkhai');
GO
INSERT INTO NhanVien (maNv,tenNV,sdt,gioiTinh,chucVu,taiKhoan) VALUES (N'NV003', N'Đinh Lê Hậu Nghĩa', N'0987226261', N'Nam', N'Lễ tân', N'letanhaunghia');
GO
INSERT INTO NhanVien (maNv,tenNV,sdt,gioiTinh,chucVu,taiKhoan) VALUES (N'NV004', N'Trần Hữu Nhã', N'0936343821', N'Nam', N'Quản lí', N'quanlihuunha');
GO

CREATE TABLE SanPham(
	maSP VARCHAR (10) PRIMARY KEY,
	tenSP NVARCHAR (40) NOT NULL,
	soLuong INT NOT NULL,
	donGia INT NOT NULL,
);
GO

INSERT INTO SanPham (maSP,tenSP,soLuong,donGia) VALUES (N'SP001', N'Nước suối', 500, 15000);
GO
INSERT INTO SanPham (maSP,tenSP,soLuong,donGia) VALUES (N'SP002', N'Sting đỏ', 300, 22000);
GO
INSERT INTO SanPham (maSP,tenSP,soLuong,donGia) VALUES (N'SP003', N'CoCaCoLa', 400, 22000);
GO
INSERT INTO SanPham (maSP,tenSP,soLuong,donGia) VALUES (N'SP004', N'Pepsi', 400, 22000);
GO
INSERT INTO SanPham (maSP,tenSP,soLuong,donGia) VALUES (N'SP005', N'Bia Heiniken', 500, 25000);
GO
INSERT INTO SanPham (maSP,tenSP,soLuong,donGia) VALUES (N'SP006', N'Bia Tiger', 500, 22000);
GO
INSERT INTO SanPham (maSP,tenSP,soLuong,donGia) VALUES (N'SP007', N'Bia Budweiser', 500, 30000);
GO
INSERT INTO SanPham (maSP,tenSP,soLuong,donGia) VALUES (N'SP008', N'Bia Corona', 500, 30000);
GO
INSERT INTO SanPham (maSP,tenSP,soLuong,donGia) VALUES (N'SP009', N'Ruou Soju', 200, 50000);
GO
INSERT INTO SanPham (maSP,tenSP,soLuong,donGia) VALUES (N'SP010', N'Dia trai cay', 100, 60000);
GO
INSERT INTO SanPham (maSP,tenSP,soLuong,donGia) VALUES (N'SP011', N'Sun ga rang muoi', 30, 140000);
GO
INSERT INTO SanPham (maSP,tenSP,soLuong,donGia) VALUES (N'SP012', N'Xuc xich nuong tieu', 30, 100000);
GO
INSERT INTO SanPham (maSP,tenSP,soLuong,donGia) VALUES (N'SP013', N'Dau hu xao toi', 30, 70000);
GO
INSERT INTO SanPham (maSP,tenSP,soLuong,donGia) VALUES (N'SP014', N'Ba roi gion da', 30, 120000);
GO
INSERT INTO SanPham (maSP,tenSP,soLuong,donGia) VALUES (N'SP015', N'Bo luc lac', 30, 180000);
GO
INSERT INTO SanPham (maSP,tenSP,soLuong,donGia) VALUES (N'SP016', N'Khoai tay chien', 30, 150000);
GO
INSERT INTO SanPham (maSP,tenSP,soLuong,donGia) VALUES (N'SP017', N'Bo cuon nam', 30, 150000);
GO

GO

CREATE TABLE ChiTietHoaDonDatPhong (
	maCTHDDP VARCHAR (10) PRIMARY KEY,
	maPhong  VARCHAR (10) NOT NULL,
	soLuong INT NULL,
	donGia INT NOT NULL,
   CONSTRAINT df_CTHDDP_Phong FOREIGN KEY(maPhong) REFERENCES Phong(maPhong),
);
GO

INSERT INTO ChiTietHoaDonDatPhong (maCTHDDP,maPhong,soLuong,donGia) VALUES (N'CTHD001', N'PT003', 1, 150000)
GO
INSERT INTO ChiTietHoaDonDatPhong (maCTHDDP,maPhong,soLuong,donGia) VALUES (N'CTHD002', N'PT013', 1, 150000)
GO
INSERT INTO ChiTietHoaDonDatPhong (maCTHDDP,maPhong,soLuong,donGia) VALUES (N'CTHD003', N'PV008', 1, 300000)
GO
INSERT INTO ChiTietHoaDonDatPhong (maCTHDDP,maPhong,soLuong,donGia) VALUES (N'CTHD005', N'PV012', 1, 300000)
GO
INSERT INTO ChiTietHoaDonDatPhong (maCTHDDP,maPhong,soLuong,donGia) VALUES (N'CTHD006', N'PT016', 5, 150000)
GO
INSERT INTO ChiTietHoaDonDatPhong (maCTHDDP,maPhong,soLuong,donGia) VALUES (N'CTHD007', N'PT017', 5, 150000)
GO

GO
 
CREATE TABLE ChiTietHoaDonSanPham (
	maCTHDSP  VARCHAR (10) PRIMARY KEY,
	phong VARCHAR (10) NOT NULL,
	khachHang VARCHAR (10) NOT NULL,
	ngayLap Date not null,
	Constraint df_HDSP_KH Foreign key(khachHang) references KhachHang(maKH),
	CONSTRAINT df_CTHDSP_Phong FOREIGN KEY(phong) REFERENCES Phong(maPhong),
);
GO

INSERT INTO ChiTietHoaDonSanPham (maCTHDSP,phong,khachHang,ngayLap) 
VALUES ('HD001', 'PV008', 'KH001','2022-12-30')
GO

INSERT INTO ChiTietHoaDonSanPham (maCTHDSP,phong,khachHang,ngayLap) 
VALUES ('HD002', 'PV011', 'KH002','2022-12-30')
GO

INSERT INTO ChiTietHoaDonSanPham (maCTHDSP,phong,khachHang,ngayLap) 
VALUES ('HD003', 'PV005', 'KH003','2022-12-30')
GO

INSERT INTO ChiTietHoaDonSanPham (maCTHDSP,phong,khachHang,ngayLap) 
VALUES ('HD004', 'PT004', 'KH004','2022-12-30')
GO

INSERT INTO ChiTietHoaDonSanPham (maCTHDSP,phong,khachHang,ngayLap) 
VALUES ('HD005', 'PT003', 'KH005','2022-12-30')
GO

GO

CREATE TABLE ChiTietPhieuDatPhong (
	maCTPDP VARCHAR (10) PRIMARY KEY,
	phong VARCHAR (10) NOT NULL,
	ngayHen Date NOT NULL,
	gioHen Datetime NOT NULL,
	CONSTRAINT df_CTPDP_Phong FOREIGN KEY(phong) REFERENCES Phong(maPhong),
);

INSERT INTO ChiTietPhieuDatPhong (maCTPDP,phong,ngayHen,gioHen)
VALUES (N'CTHDDP001', N'PT001', N'2022-10-18', N'19:00:00')
GO

INSERT INTO ChiTietPhieuDatPhong (maCTPDP,phong,ngayHen,gioHen)
VALUES (N'CTHDDP002', N'PV007', N'2022-10-19', N'20:00:00')
GO

INSERT INTO ChiTietPhieuDatPhong (maCTPDP,phong,ngayHen,gioHen)
VALUES (N'CTHDDP003', N'PT016', N'2022-10-19', N'20:00:00')
GO
GO

CREATE TABLE HoaDonDatPhong (
	maHD VARCHAR (10) PRIMARY KEY,
	nhanVien VARCHAR (10) NOT NULL,
	khachHang VARCHAR (10) NOT NULL,
	chiTietHoaDonDatPhong VARCHAR (10) NOT NULL,
	ngayDat Date NOT NULL,
	gioVao time NOT NULL,
	gioRa time ,
	tongGioDatPhong INT NOT NULL,
	tongTien INT NOT NULL,
   CONSTRAINT df_HDDP_NV FOREIGN KEY(nhanVien) REFERENCES NhanVien(maNV),
   CONSTRAINT df_HDDP_KH FOREIGN KEY(khachHang) REFERENCES KhachHang(maKH),
   CONSTRAINT df_HDDP_CTHDDP  FOREIGN KEY(chiTietHoaDonDatPhong) REFERENCES ChiTietHoaDonDatPhong(maCTHDDP),
);
GO

INSERT INTO HoaDonDatPhong (maHD,nhanVien,khachHang,chiTietHoaDonDatPhong,ngayDat, gioVao, gioRa, tongGioDatPhong, tongTien) 
VALUES (N'HD001', N'NV001', N'KH001', N'CTHD001', N'2022-3-21', N'9:00:00', '',2, 300000)
GO
INSERT INTO HoaDonDatPhong (maHD,nhanVien,khachHang,chiTietHoaDonDatPhong,ngayDat, gioVao, gioRa, tongGioDatPhong, tongTien) 
VALUES (N'HD002', N'NV001', N'KH002', N'CTHD002', N'2022-3-21', N'9:00:00', '',2, 300000)
GO
INSERT INTO HoaDonDatPhong (maHD,nhanVien,khachHang,chiTietHoaDonDatPhong,ngayDat, gioVao, gioRa, tongGioDatPhong, tongTien) 
VALUES (N'HD003', N'NV002', N'KH003', N'CTHD003', N'2022-3-21', N'9:00:00', '',2, 600000)
GO
INSERT INTO HoaDonDatPhong (maHD,nhanVien,khachHang,chiTietHoaDonDatPhong,ngayDat, gioVao, gioRa, tongGioDatPhong, tongTien) 
VALUES (N'HD005', N'NV002', N'KH005', N'CTHD005', N'2022-3-21', N'9:00:00', '',2, 600000)
GO

GO

CREATE TABLE HoaDonSanPham (
	chiTietHoaDonSanPham VARCHAR (10) NOT NULL,
	nhanVien VARCHAR (10) NOT NULL,
	sanPham VARCHAR (10) NOT NULL,
	soLuong INT NOT NULL,
	donGia INT NOT NULL,
	tongTien int not null,
	Constraint df_HDSP_CTHDSP Foreign key(chiTietHoaDonSanPham) references ChiTietHoaDonSanPham(maCTHDSP),
	Constraint df_HDSP_NV Foreign key(nhanVien) references NhanVien(maNV),	
	CONSTRAINT df_CTHDSP_SanPham FOREIGN KEY(sanPham) REFERENCES SanPham(maSP),
);
GO

INSERT INTO HoaDonSanPham (chiTietHoaDonSanPham,nhanVien,sanPham,soLuong,donGia,tongTien) 
VALUES (N'HD001', N'NV001', N'SP001', 10, 240000, 123)
GO

INSERT INTO HoaDonSanPham (chiTietHoaDonSanPham,nhanVien,sanPham,soLuong,donGia,tongTien) 
VALUES (N'HD001', N'NV001', N'SP002', 10, 240000, 123)
GO

INSERT INTO HoaDonSanPham (chiTietHoaDonSanPham,nhanVien,sanPham,soLuong,donGia,tongTien) 
VALUES (N'HD002', N'NV001', N'SP004', 10, 240000, 123)
GO

INSERT INTO HoaDonSanPham (chiTietHoaDonSanPham,nhanVien,sanPham,soLuong,donGia,tongTien) 
VALUES (N'HD002', N'NV001', N'SP007', 10, 240000, 123)
GO

INSERT INTO HoaDonSanPham (chiTietHoaDonSanPham,nhanVien,sanPham,soLuong,donGia,tongTien) 
VALUES (N'HD003', N'NV001', N'SP003', 10, 240000, 123)
GO

INSERT INTO HoaDonSanPham (chiTietHoaDonSanPham,nhanVien,sanPham,soLuong,donGia,tongTien) 
VALUES (N'HD003', N'NV001', N'SP009', 10, 240000, 123)
GO

INSERT INTO HoaDonSanPham (chiTietHoaDonSanPham,nhanVien,sanPham,soLuong,donGia,tongTien) 
VALUES (N'HD004', N'NV001', N'SP005', 10, 240000, 123)
GO

INSERT INTO HoaDonSanPham (chiTietHoaDonSanPham,nhanVien,sanPham,soLuong,donGia,tongTien) 
VALUES (N'HD004', N'NV001', N'SP011', 10, 240000, 123)
GO

GO

CREATE TABLE PhieuDatPhong (
	maPhieuDat VARCHAR (10) NOT NULL,
	khachHang VARCHAR (10) NOT NULL,
	chiTietPhieuDatPhong VARCHAR (10) NOT NULL,
	CONSTRAINT df_PDP_KH FOREIGN KEY(khachHang) REFERENCES KhachHang(maKH),
	CONSTRAINT df_PDP_CTPDP FOREIGN KEY(chiTietPhieuDatPhong) REFERENCES ChiTietPhieuDatPhong(maCTPDP),
);
GO

INSERT INTO PhieuDatPhong (maPhieuDat,khachHang,chiTietPhieuDatPhong) 
VALUES (N'PD001', N'KH006', N'CTHDDP002')
GO

INSERT INTO PhieuDatPhong (maPhieuDat,khachHang,chiTietPhieuDatPhong) 
VALUES (N'PD002', N'KH0016', N'CTHDDP003')
GO

GO

-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
SELECT TOP (1000) [maCTHDDP]
      ,[maPhong]
      ,[soLuong]
      ,[donGia]
  FROM [KARAOKE_Nice].[dbo].[ChiTietHoaDonDatPhong]

GO

SELECT TOP (1000) [maCTHDSP]
      ,[phong]
      ,[khachHang]
      ,[ngayLap]
  FROM [KARAOKE_Nice].[dbo].[ChiTietHoaDonSanPham]

GO

SELECT TOP (1000) [maCTPDP]
      ,[phong]
      ,[ngayHen]
      ,[gioHen]
  FROM [KARAOKE_Nice].[dbo].[ChiTietPhieuDatPhong]

GO

SELECT TOP (1000) [maHD]
      ,[nhanVien]
      ,[khachHang]
      ,[chiTietHoaDonDatPhong]
      ,[ngayDat]
      ,[gioVao]
      ,[gioRa]
      ,[tongGioDatPhong]
      ,[tongTien]
  FROM [KARAOKE_Nice].[dbo].[HoaDonDatPhong]

GO

SELECT TOP (1000) [chiTietHoaDonSanPham]
      ,[nhanVien]
      ,[sanPham]
      ,[soLuong]
      ,[donGia]
      ,[tongTien]
  FROM [KARAOKE_Nice].[dbo].[HoaDonSanPham]

GO

SELECT TOP (1000) [maKH]
      ,[tenKH]
      ,[sdt]
      ,[diaChi]
      ,[cmnd]
  FROM [KARAOKE_Nice].[dbo].[KhachHang]

GO

SELECT TOP (1000) [maNv]
      ,[tenNV]
      ,[sdt]
      ,[gioiTinh]
      ,[chucVu]
      ,[taiKhoan]
  FROM [KARAOKE_Nice].[dbo].[NhanVien]

GO

SELECT TOP (1000) [maPhieuDat]
      ,[khachHang]
      ,[chiTietPhieuDatPhong]
  FROM [KARAOKE_Nice].[dbo].[PhieuDatPhong]

GO

SELECT TOP (1000) [maPhong]
      ,[tenPhong]
      ,[trangThai]
      ,[sucChua]
      ,[tenLoai]
      ,[donGia]
  FROM [KARAOKE_Nice].[dbo].[Phong]

GO

SELECT TOP (1000) [maSP]
      ,[tenSP]
      ,[soLuong]
      ,[donGia]
  FROM [KARAOKE_Nice].[dbo].[SanPham]

GO

SELECT TOP (1000) [taiKhoan]
      ,[matKhau]
  FROM [KARAOKE_Nice].[dbo].[TaiKhoan]

GO

-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

delete from PhieuDatPhong where maPhieuDat = 'PD002'
GO

GO
ALTER TABLE [dbo].[NhanVien] DROP CONSTRAINT [df_NV_TK]
GO

UPDATE Phong SET tenPhong = N'Phòng 3.16' WHERE maPhong = 'PT016'
GO

ALTER TABLE NhanVien NOCHECK CONSTRAINT df_NV_TK
UPDATE TaiKhoan set matKhau = N'matkhautesst' WHERE taiKhoan = N'barcelona'
UPDATE NhanVien set tenNV = N'cr7', sdt = N'123123', gioiTinh = N'Nữ', chucVu = N'dự bị', taiKhoan = N'' WHERE maNV = N'NV005'
ALTER TABLE NhanVien CHECK CONSTRAINT df_NV_TK

GO

ALTER TABLE HoaDonDatPhong NOCHECK CONSTRAINT df_HDDP_NV, df_HDDP_KH, df_HDDP_CTHDDP
UPDATE HoaDonDatPhong set gioRa = N'11:00' WHERE maHD = N'HD001'
ALTER TABLE HoaDonDatPhong CHECK CONSTRAINT df_HDDP_NV, df_HDDP_KH, df_HDDP_CTHDDP
GO

SELECT  NhanVien.maNv, NhanVien.tenNV, NhanVien.sdt, NhanVien.gioiTinh, NhanVien.chucVu, NhanVien.taiKhoan , TaiKhoan.taiKhoan, TaiKhoan.matKhau FROM NhanVien, TaiKhoan WHERE NhanVien.taiKhoan=TaiKhoan.taiKhoan
GO

SELECT * FROM TaiKhoan tk, NhanVien nv WHERE tk.taiKhoan LIKE N'%letanthienkhai%' AND nv.taiKhoan LIKE N'%letanthienkhai%' AND nv.chucVu LIKE N'%Lễ tân%'
GO

SELECT * FROM TaiKhoan tk, NhanVien nv WHERE tk.taiKhoan LIKE N'%quanlihuunha%' AND nv.taiKhoan LIKE N'%quanlihuunha%'
GO

SELECT nv.maNv, nv.tenNV, nv.sdt, nv.gioiTinh, nv.chucVu, nv.taiKhoan, tk.matKhau FROM TaiKhoan tk, NhanVien nv WHERE nv.sdt like N'%0987226261%' and tk.taiKhoan like nv.taiKhoan
GO

SELECT * FROM NhanVien nv WHERE nv.chucVu LIKE N'%Quản lí%'
GO

SELECT HoaDonDatPhong.maHD, KhachHang.sdt, KhachHang.tenKH, Phong.tenPhong,HoaDonDatPhong.ngayDat, HoaDonDatPhong.gioVao, HoaDonDatPhong.gioRa, HoaDonDatPhong.tongGioDatPhong, HoaDonDatPhong.tongTien, NhanVien.tenNV, Phong.tenLoai  
FROM HoaDonDatPhong 
JOIN ChiTietHoaDonDatPhong ON HoaDonDatPhong.chiTietHoaDonDatPhong = ChiTietHoaDonDatPhong.maCTHDDP
JOIN NhanVien ON HoaDonDatPhong.nhanVien = NhanVien.maNv 
JOIN Phong ON ChiTietHoaDonDatPhong.maPhong = Phong.maPhong
LEFT JOIN KhachHang ON HoaDonDatPhong.khachHang = KhachHang.maKH WHERE HoaDonDatPhong.maHD = N'HD001'
GO

SELECT ChiTietHoaDonSanPham.maCTHDSP, ChiTietHoaDonSanPham.soLuong, ChiTietHoaDonSanPham.donGia, ChiTietHoaDonSanPham.ngayLap,
SanPham.maSP, SanPham.tenSP, SanPham.donGia, Phong.maPhong, Phong.tenPhong, KhachHang.maKH, KhachHang.tenKH, KhachHang.sdt,
NhanVien.maNv, NhanVien.tenNV, HoaDonSanPham.maHDSP, HoaDonSanPham.tongTien
FROM HoaDonSanPham 
JOIN ChiTietHoaDonSanPham ON HoaDonSanPham.chiTietHoaDonSanPham = ChiTietHoaDonSanPham.maCTHDSP
JOIN NhanVien ON HoaDonSanPham.nhanVien = NhanVien.maNv 
JOIN SanPham ON ChiTietHoaDonSanPham.sanPham = SanPham.maSP
JOIN KhachHang ON HoaDonSanPham.khachHang = KhachHang.maKH  
LEFT JOIN Phong ON ChiTietHoaDonSanPham.phong = Phong.maPhong where Phong.tenPhong = N'Phòng 2.08'
GO

SELECT ChiTietHoaDonSanPham.maCTHDSP, HoaDonSanPham.maHDSP
FROM HoaDonSanPham 
JOIN NhanVien ON HoaDonSanPham.nhanVien = NhanVien.maNv 
JOIN ChiTietHoaDonSanPham ON HoaDonSanPham.chiTietHoaDonSanPham = ChiTietHoaDonSanPham.maCTHDSP
JOIN SanPham ON ChiTietHoaDonSanPham.sanPham = SanPham.maSP
JOIN Phong ON ChiTietHoaDonSanPham.phong = Phong.maPhong
LEFT JOIN KhachHang ON HoaDonSanPham.khachHang = KhachHang.maKH  where HoaDonSanPham.maHDSP = N'HDSP004'
GO

SELECT HoaDonDatPhong.maHD, KhachHang.sdt, KhachHang.tenKH, Phong.tenPhong,HoaDonDatPhong.ngayDat, HoaDonDatPhong.gioVao, HoaDonDatPhong.gioRa, HoaDonDatPhong.tongGioDatPhong, HoaDonDatPhong.tongTien, NhanVien.tenNV, Phong.tenLoai  
FROM HoaDonDatPhong 
JOIN ChiTietHoaDonDatPhong ON HoaDonDatPhong.chiTietHoaDonDatPhong = ChiTietHoaDonDatPhong.maCTHDDP
JOIN NhanVien ON HoaDonDatPhong.nhanVien = NhanVien.maNv 
JOIN KhachHang ON HoaDonDatPhong.khachHang = KhachHang.maKH
LEFT JOIN Phong ON ChiTietHoaDonDatPhong.maPhong = Phong.maPhong where Phong.tenPhong = N'Phòng 2.05'
GO

SELECT HoaDonDatPhong.maHD, KhachHang.sdt, KhachHang.tenKH, Phong.tenPhong,HoaDonDatPhong.ngayDat, HoaDonDatPhong.gioVao,
HoaDonDatPhong.gioRa, HoaDonDatPhong.tongGioDatPhong, HoaDonDatPhong.tongTien, NhanVien.tenNV, Phong.tenLoai, Phong.maPhong   
FROM HoaDonDatPhong 
JOIN ChiTietHoaDonDatPhong ON HoaDonDatPhong.chiTietHoaDonDatPhong = ChiTietHoaDonDatPhong.maCTHDDP
JOIN NhanVien ON HoaDonDatPhong.nhanVien = NhanVien.maNv 
JOIN KhachHang ON HoaDonDatPhong.khachHang = KhachHang.maKH
LEFT JOIN Phong ON ChiTietHoaDonDatPhong.maPhong = Phong.maPhong where ChiTietHoaDonDatPhong.maPhong = N'PT003'
GO
-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------