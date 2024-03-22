create database test1

use test1

CREATE TABLE TaiKhoan(
	taiKhoan NVARCHAR (40) PRIMARY KEY,
	matKhau NVARCHAR (30) NOT NULL,
);
GO

CREATE TABLE NhanVien(
   maNv  VARCHAR (10) PRIMARY KEY,
   tenNV NVARCHAR (40) NOT NULL,     
   sdt NVARCHAR (30) NOT NULL,
   gioiTinh  NVARCHAR (30) NOT NULL,
   chucVu NVARCHAR (30) NOT NULL,
   taiKhoan NVARCHAR (40) NOT NULL, 
   CONSTRAINT df_NV_TK FOREIGN KEY(taiKhoan) REFERENCES TaiKhoan(taiKhoan),
);
GO

CREATE TABLE Phong(
   maPhong  VARCHAR (10) PRIMARY KEY,
   tenPhong NVARCHAR (30) NOT NULL,     
   trangThai NVARCHAR (30) NOT NULL,     
   sucChua INT NOT NULL, 
   tenLoai NVARCHAR (30) NOT NULL,
	donGia INT NOT NULL
);
GO

CREATE TABLE KhachHang(
   maKH  VARCHAR (10) PRIMARY KEY,
   tenKH NVARCHAR (40) NOT NULL,     
   sdt NVARCHAR (30) NOT NULL,     
   diaChi NVARCHAR (50) NOT NULL, 
   cmnd VARCHAR (30) NOT NULL,
);
GO

CREATE TABLE SanPham(
	maSP VARCHAR (10) PRIMARY KEY,
	tenSP NVARCHAR (40) NOT NULL,
	soLuong INT NOT NULL,
	donGia INT NOT NULL,
);
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




INSERT INTO SanPham (maSP,tenSP,soLuong,donGia) VALUES (N'SP001', N'Nước suối', 500, 15000);
INSERT INTO SanPham (maSP,tenSP,soLuong,donGia) VALUES (N'SP002', N'Sting đỏ', 300, 22000);
INSERT INTO SanPham (maSP,tenSP,soLuong,donGia) VALUES (N'SP003', N'CoCaCoLa', 400, 22000);
INSERT INTO SanPham (maSP,tenSP,soLuong,donGia) VALUES (N'SP004', N'Pepsi', 400, 22000);
INSERT INTO SanPham (maSP,tenSP,soLuong,donGia) VALUES (N'SP005', N'Bia Heiniken', 500, 25000);
INSERT INTO SanPham (maSP,tenSP,soLuong,donGia) VALUES (N'SP006', N'Bia Tiger', 500, 22000);
INSERT INTO SanPham (maSP,tenSP,soLuong,donGia) VALUES (N'SP007', N'Bia Budweiser', 500, 30000);
INSERT INTO SanPham (maSP,tenSP,soLuong,donGia) VALUES (N'SP008', N'Bia Corona', 500, 30000);
INSERT INTO SanPham (maSP,tenSP,soLuong,donGia) VALUES (N'SP009', N'Ruou Soju', 200, 50000);
INSERT INTO SanPham (maSP,tenSP,soLuong,donGia) VALUES (N'SP010', N'Dia trai cay', 100, 60000);
INSERT INTO SanPham (maSP,tenSP,soLuong,donGia) VALUES (N'SP011', N'Sun ga rang muoi', 30, 140000);
INSERT INTO SanPham (maSP,tenSP,soLuong,donGia) VALUES (N'SP012', N'Xuc xich nuong tieu', 30, 100000);
INSERT INTO SanPham (maSP,tenSP,soLuong,donGia) VALUES (N'SP013', N'Dau hu xao toi', 30, 70000);
INSERT INTO SanPham (maSP,tenSP,soLuong,donGia) VALUES (N'SP014', N'Ba roi gion da', 30, 120000);
INSERT INTO SanPham (maSP,tenSP,soLuong,donGia) VALUES (N'SP015', N'Bo luc lac', 30, 180000);
INSERT INTO SanPham (maSP,tenSP,soLuong,donGia) VALUES (N'SP016', N'Khoai tay chien', 30, 150000);
INSERT INTO SanPham (maSP,tenSP,soLuong,donGia) VALUES (N'SP017', N'Bo cuon nam', 30, 150000);

INSERT INTO TaiKhoan (taiKhoan, matKhau) VALUES (N'letanhoangnam', N'nolehoangnam')
INSERT INTO TaiKhoan (taiKhoan, matKhau) VALUES (N'letanthienkhai', N'letanlontuoi')
INSERT INTO TaiKhoan (taiKhoan, matKhau) VALUES (N'letanhaunghia', N'letanluoibieng')
INSERT INTO TaiKhoan (taiKhoan, matKhau) VALUES (N'quanlihuunha', N'quanlideptrai')

INSERT INTO NhanVien (maNv,tenNV,sdt,gioiTinh,chucVu,taiKhoan) VALUES (N'NV001', N'Trần Nguyễn Hoàng Nam', N'0367345322', N'Nam', N'Lễ tân', N'letanhoangnam');
INSERT INTO NhanVien (maNv,tenNV,sdt,gioiTinh,chucVu,taiKhoan) VALUES (N'NV002', N'Đặng Phạm Thiên Khải', N'0982628272', N'Nam', N'Lễ tân', N'letanthienkhai');
INSERT INTO NhanVien (maNv,tenNV,sdt,gioiTinh,chucVu,taiKhoan) VALUES (N'NV003', N'Đinh Lê Hậu Nghĩa', N'0987226261', N'Nam', N'Lễ tân', N'letanhaunghia');
INSERT INTO NhanVien (maNv,tenNV,sdt,gioiTinh,chucVu,taiKhoan) VALUES (N'NV004', N'Trần Hữu Nhã', N'0936343821', N'Nam', N'Quản lí', N'quanlihuunha');

INSERT INTO KhachHang (maKH,tenKH, sdt, diaChi, cmnd) VALUES (N'KH001', N'Nguyen Van A', N'0123465679', N'47A, Phạm Văn Đồng, TP HCM', N'08726236232')
INSERT INTO KhachHang (maKH,tenKH, sdt, diaChi, cmnd) VALUES (N'KH002', N'Nguyen Van B', N'7392387724', N'48A, Phạm Ngũ Lão, TP HCM', N'018092830127')
INSERT INTO KhachHang (maKH,tenKH, sdt, diaChi, cmnd) VALUES (N'KH003', N'Nguyen Van C', N'2543253425', N'42A, Võ Văn Kiệt , TP HCM', N'525617635267')
INSERT INTO KhachHang (maKH,tenKH, sdt, diaChi, cmnd) VALUES (N'KH004', N'Nguyen Van D', N'3245322352', N'50A, Nguyễn Văn Linh, TP HCM', N'21683612789')
INSERT INTO KhachHang (maKH,tenKH, sdt, diaChi, cmnd) VALUES (N'KH005', N'Nguyen Van E', N'0980213712', N'55A, Lê Văn Duyệt, TP HCM', N'09089287911')
INSERT INTO KhachHang (maKH,tenKH, sdt, diaChi, cmnd) VALUES (N'KH006', N'Nguyen Van F', N'0102372121', N'52A, Nguyễn Trãi, TP HCM', N'78297108311')

INSERT INTO KhachHang (maKH,tenKH, sdt, diaChi, cmnd) VALUES (N'KH007', N'Nguyen Van G', N'7392387724', N'48A, Phạm Ngũ Lão, TP HCM', N'018092830127')
INSERT INTO KhachHang (maKH,tenKH, sdt, diaChi, cmnd) VALUES (N'KH008', N'Nguyen Van H', N'2543253425', N'42A, Võ Văn Kiệt , TP HCM', N'525617635267')
INSERT INTO KhachHang (maKH,tenKH, sdt, diaChi, cmnd) VALUES (N'KH009', N'Nguyen Van M', N'3245322352', N'50A, Nguyễn Văn Linh, TP HCM', N'21683612789')
INSERT INTO KhachHang (maKH,tenKH, sdt, diaChi, cmnd) VALUES (N'KH0011', N'Nguyen Van N', N'0980213712', N'55A, Lê Văn Duyệt, TP HCM', N'09089287911')
INSERT INTO KhachHang (maKH,tenKH, sdt, diaChi, cmnd) VALUES (N'KH0012', N'Nguyen Van S', N'0102372121', N'52A, Nguyễn Trãi, TP HCM', N'78297108311')


INSERT INTO Phong (maPhong, tenPhong, trangThai, sucChua, tenLoai, donGia) VALUES (N'PT001', N'Phòng 2.01', N'Trống', 10,N'Thuong',150000)
INSERT INTO Phong (maPhong, tenPhong, trangThai, sucChua, tenLoai, donGia) VALUES (N'PT002', N'Phòng 2.02', N'Trống', 15,N'Thuong',150000)
INSERT INTO Phong (maPhong, tenPhong, trangThai, sucChua, tenLoai, donGia) VALUES (N'PT003', N'Phòng 2.03', N'Đang sử dụng', 15,N'Thuong',150000)
INSERT INTO Phong (maPhong, tenPhong, trangThai, sucChua, tenLoai, donGia) VALUES (N'PT004', N'Phòng 2.04', N'Đang sử dụng', 10,N'Thuong',150000)
INSERT INTO Phong (maPhong, tenPhong, trangThai, sucChua, tenLoai, donGia) VALUES (N'PV005', N'Phòng 2.05', N'Đang sử dụng', 20,N'Vip',300000)
INSERT INTO Phong (maPhong, tenPhong, trangThai, sucChua, tenLoai, donGia) VALUES (N'PV006', N'Phòng 2.06', N'Trống', 20,N'Vip',300000)
INSERT INTO Phong (maPhong, tenPhong, trangThai, sucChua, tenLoai, donGia) VALUES (N'PV007', N'Phòng 2.07', N'Trống', 20,N'Vip',300000)
INSERT INTO Phong (maPhong, tenPhong, trangThai, sucChua, tenLoai, donGia) VALUES (N'PV008', N'Phòng 2.08', N'Đang sử dụng', 25,N'Vip',300000)
INSERT INTO Phong (maPhong, tenPhong, trangThai, sucChua, tenLoai, donGia) VALUES (N'PV009', N'Phòng 2.09', N'Trống', 25,N'Vip',300000)
INSERT INTO Phong (maPhong, tenPhong, trangThai, sucChua, tenLoai, donGia) VALUES (N'PV010', N'Phòng 2.10', N'Trống', 30,N'Vip',300000)

INSERT INTO Phong (maPhong, tenPhong, trangThai, sucChua, tenLoai, donGia) VALUES (N'PV011', N'Phòng 3.01', N'Đang sử dụng', 20,N'Vip',300000)
INSERT INTO Phong (maPhong, tenPhong, trangThai, sucChua, tenLoai, donGia) VALUES (N'PV012', N'Phòng 3.02', N'Đang sử dụng', 20,N'Vip',300000)
INSERT INTO Phong (maPhong, tenPhong, trangThai, sucChua, tenLoai, donGia) VALUES (N'PT013', N'Phòng 3.03', N'Đang sử dụng', 25,N'Thuong',150000)
INSERT INTO Phong (maPhong, tenPhong, trangThai, sucChua, tenLoai, donGia) VALUES (N'PT014', N'Phòng 3.04', N'Trống', 25,N'Thuong',150000)
INSERT INTO Phong (maPhong, tenPhong, trangThai, sucChua, tenLoai, donGia) VALUES (N'PT015', N'Phòng 3.05', N'Trống', 30,N'Thuong',150000)

INSERT INTO ChiTietHoaDonSanPham (maCTHDSP,phong,khachHang,ngayLap) 
VALUES ('HD001', 'PV008', 'KH001','2022-12-30')

INSERT INTO ChiTietHoaDonSanPham (maCTHDSP,phong,khachHang,ngayLap) 
VALUES ('HD002', 'PV011', 'KH002','2022-12-30')

INSERT INTO ChiTietHoaDonSanPham (maCTHDSP,phong,khachHang,ngayLap) 
VALUES ('HD003', 'PV005', 'KH003','2022-12-30')

INSERT INTO ChiTietHoaDonSanPham (maCTHDSP,phong,khachHang,ngayLap) 
VALUES ('HD004', 'PT004', 'KH004','2022-12-30')

INSERT INTO ChiTietHoaDonSanPham (maCTHDSP,phong,khachHang,ngayLap) 
VALUES ('HD005', 'PT003', 'KH005','2022-12-30')

GO

INSERT INTO HoaDonSanPham (chiTietHoaDonSanPham,nhanVien,sanPham,soLuong,donGia,tongTien) 
VALUES (N'HD001', N'NV001', N'SP001', 10, 240000, 123)

INSERT INTO HoaDonSanPham (chiTietHoaDonSanPham,nhanVien,sanPham,soLuong,donGia,tongTien) 
VALUES (N'HD001', N'NV001', N'SP002', 10, 240000, 123)

INSERT INTO HoaDonSanPham (chiTietHoaDonSanPham,nhanVien,sanPham,soLuong,donGia,tongTien) 
VALUES (N'HD002', N'NV001', N'SP004', 10, 240000, 123)

INSERT INTO HoaDonSanPham (chiTietHoaDonSanPham,nhanVien,sanPham,soLuong,donGia,tongTien) 
VALUES (N'HD002', N'NV001', N'SP007', 10, 240000, 123)

INSERT INTO HoaDonSanPham (chiTietHoaDonSanPham,nhanVien,sanPham,soLuong,donGia,tongTien) 
VALUES (N'HD003', N'NV001', N'SP003', 10, 240000, 123)

INSERT INTO HoaDonSanPham (chiTietHoaDonSanPham,nhanVien,sanPham,soLuong,donGia,tongTien) 
VALUES (N'HD003', N'NV001', N'SP009', 10, 240000, 123)

INSERT INTO HoaDonSanPham (chiTietHoaDonSanPham,nhanVien,sanPham,soLuong,donGia,tongTien) 
VALUES (N'HD004', N'NV001', N'SP005', 10, 240000, 123)

INSERT INTO HoaDonSanPham (chiTietHoaDonSanPham,nhanVien,sanPham,soLuong,donGia,tongTien) 
VALUES (N'HD004', N'NV001', N'SP011', 10, 240000, 123)