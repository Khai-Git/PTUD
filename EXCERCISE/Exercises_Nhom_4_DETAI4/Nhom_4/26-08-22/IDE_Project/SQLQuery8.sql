create database QLSP8
on primary
( 
  name = QLSP_data8,
  filename='D:\PTUD\QLSP8_data.mdf',
  size=10,
  maxsize=40,
  filegrowth=1
)
log on
( 
  name= QLSP8_Log,
  filename='D:\PTUD\QLSP8.ldf',
  size=6,
  maxsize=8,
  filegrowth=1
)
use QLSP8
CREATE TABLE NhanVien
(
        maNV char(5) NOT NULL PRIMARY KEY ,
		tenNV char(50) not null ,
        sdtNV nvarchar(10) not null ,
		diaChi nvarchar(50) not null ,
		ngaySinh datetime ,
		hocVan nvarchar(20) not null,
		Email nvarchar(50) not null,
		gioiTinh nvarchar(3)	
)
drop TABLE NhanVien
CREATE TABLE KhachHang
(
        maKH char(5) NOT NULL PRIMARY KEY ,
		tenKH char(50) not null ,
		diaChiKH nvarchar(50) not null,
        sdtKH nvarchar(10) not null,
		EmailKH nvarchar(50) not null
)
drop TABLE KhachHang
CREATE TABLE TaiKhoan
(
        maNV char(5) NOT NULL foreign key (maNV) references NhanVien(maNV),
		taiKhoan char(15) ,
        matKhau char(15) ,
		roles  char(1)
)
drop TABLE TaiKhoan
CREATE TABLE SanPham
(
        maSP char(5) NOT NULL PRIMARY KEY ,
		tenSP nvarchar(20)not null ,
        soLuongSP int not null,
		kichCo nvarchar(6) ,
		mauSac nvarchar(7),
		donGia float not null,
		moTaSP nvarchar(max)
)
drop TABLE SanPham
CREATE TABLE HoaDon
(
		maHD char(6) NOT NULL PRIMARY KEY ,
		ngayLapHD datetime,
		maNV char(5) not null foreign key (maNV) references NhanVien(maNV),
		tenNV char(50) not null,
		maKH char(5) not null foreign key (maKH) references KhachHang(maKH),
		VAT float not null ,
        tongTien  float not null,
		tienNhan float not null,
		tienThua float not null		
)
drop TABLE HoaDon
CREATE TABLE ChiTietHoaDon
(
        maHD char(6) not null foreign key (maHD) references HoaDon(maHD),
		maSP char(5) not null foreign key (maSP) references SanPham(maSP),
		tenSP VARCHAR(100) NOT NULL,
		soLuong INT NOT NULL,
		donGia FLOAT NOT NULL,
		thanhTien FLOAT NOT NULL
)
drop TABLE ChiTietHoaDon
CREATE TABLE LoaiSanPham
(       
        maSP char(5) not null,
        LoaiSP char(30),
        chatLieu char(30) ,
		noiSanXuat char(30),
		gioiTinh char (10),
		foreign key (maSP) references SanPham(maSP)
)
drop TABLE LoaiSanPham

insert into NhanVien values('NV001','Nguyen Thanh Khoa','0911231234','HCM','2002-01-01','Dai Hoc','thanhkhoa@gmail.com','Nam')
insert into NhanVien values('NV002','Nguyen Thanh Bao Long','0785678432','Tien Giang','2001-06-19','Dai Hoc','baolong@gmail.com','Nam')
insert into NhanVien values('NV003','Tran Nguyen Minh Khoi','0874576543','Dong Nai','2002-04-24','Dai Hoc','minhkhoa@gmail.com','Nam')
insert into NhanVien values('NV004','Nguyen Thanh Son','0764563780','HCM','2002-09-08','Dai Hoc','thanhson@gmail.com','Nam')
insert into NhanVien values('NV005','Pham Van Hau','0978889991','Phu Yen','2002-09-11','Dai Hoc','vanhau@gmail.com','Nam')

insert into NhanVien values('NV006','Nguyen Thanh Hung','0976231764','HCM','2002-05-01','Dai Hoc','thanhhung@gmail.com','Nam')
insert into NhanVien values('NV007','Nguyen Thanh Long','0775778452','Long An','2001-09-22','Dai Hoc','thanhlong@gmail.com','Nam')
insert into NhanVien values('NV008','Tran Nguyen Hoàng Son ','0764976783','Dong Nai','2002-08-25','Dai Hoc','hoangson@gmail.com','Nam')
insert into NhanVien values('NV009','Nguyen Thanh Tuan','0794273880','HCM','2001-09-19','Dai Hoc','thanhtuan@gmail.com','Nam')
insert into NhanVien values('NV010','Pham Huu Tai','0978889991','Binh Dương','2001-07-12','Dai Hoc','huutai@gmail.com','Nam')

insert into NhanVien values('NV011','Nguyen Thanh Ngan','0986216761','HCM','2003-04-09','Dai Hoc','thanhngan@gmail.com','Nu')
insert into NhanVien values('NV012','Nguyen Bao Ngoc','0778918652','HCM','2001-08-23','Dai Hoc','baongoc@gmail.com','Nu')
insert into NhanVien values('NV013','Tran Nguyen Ngọc Dung','0895967793','Tien Giang','2002-12-20','Dai Hoc','ngocdung@gmail.com','Nu')
insert into NhanVien values('NV014','Nguyen Hoang Mai','0869273890','HCM','2001-09-02','Dai Hoc','hoangmai@gmail.com','Nu')
insert into NhanVien values('NV015','Pham Thuy Trang','0795789223','Long An','2001-11-29','Dai Hoc','thuytrang@gmail.com','Nu')

select *from NhanVien


insert into TaiKhoan values('NV001','TK001','123456','1')
insert into TaiKhoan values('NV002','TK002','123456','2')
insert into TaiKhoan values('NV003','TK003','123456','2')
insert into TaiKhoan values('NV004','TK004','123456','2')
insert into TaiKhoan values('NV005','TK005','123456','2')

insert into TaiKhoan values('NV006','TK006','123456','2')
insert into TaiKhoan values('NV007','TK007','123456','2')
insert into TaiKhoan values('NV008','TK008','123456','2')	
insert into TaiKhoan values('NV009','TK009','123456','2')
insert into TaiKhoan values('NV010','TK010','123456','2')
insert into TaiKhoan values('NV011','TK011','123456','2')	
insert into TaiKhoan values('NV012','TK012','123456','2')
insert into TaiKhoan values('NV013','TK013','123456','2')
insert into TaiKhoan values('NV014','TK014','123456','2')	
insert into TaiKhoan values('NV015','TK015','123456','2')

select *from TaiKhoan

insert into KhachHang values('KH001','Nguyen Tuan Hung','Dong Nai','0911231256','tuanhung@gmail.com')
insert into KhachHang values('KH002','Duong The Vinh','HCM','0876549811','thevinh@gmail.com')
insert into KhachHang values('KH003','Tran Nguyen Hoang Nam','HCM','0786785698','hoangnam@gmail.com')
insert into KhachHang values('KH004','Nguyen Duc Long','HCM','0791453867','duclong@gmail.com')
insert into KhachHang values('KH006','Nguyen Ngoc Tuan','Binh Dinh','0875768997','ngoctuan@gmail.com')
insert into KhachHang values('KH007','Nguyen Quang Toan','HCM','0887756932','toanquang@gmail.com')
insert into KhachHang values('KH008','Nguyen Thanh Khoi','Dong Nai','0875687656','thanhkhoi@gmail.com')
insert into KhachHang values('KH009','Nguyen Tuan Dung','HCM','0784357587','tuandung@gmail.com')
insert into KhachHang values('KH010','Nguyen Hoang Long','HCM','0792358769','hoanglong@gmail.com')

insert into KhachHang values('KH005','Le Trong Nghĩa','HCM','0797628990','nghiale@gmail.com')

insert into KhachHang values('KH011','Nguyen Tuan Dung','Long An','0781521898','tuandung@gmail.com')
insert into KhachHang values('KH012','Dang Hoang Vinh','HCM','0975547841','hoangvinh@gmail.com')
insert into KhachHang values('KH013','Tran Hoang Phuc','HCM','0386985928','hoangphuc@gmail.com')
insert into KhachHang values('KH014','Nguyen Duc Nghia','HCM','0781983847','ducnghia@gmail.com')
insert into KhachHang values('KH015','Le Hoang Luong','HCM','0371442797','hoangluong@gmail.com')

insert into KhachHang values('KH016','Nguyen Ngoc Thanh Sang','Binh Dinh','0775977997','thanhsang@gmail.com')
insert into KhachHang values('KH017','Nguyen Thanh Duy','Tien Giang','0375677952','duynguyen@gmail.com')
insert into KhachHang values('KH018','Nguyen Tan Sang ','Dong Nai','0976589776','tansang@gmail.com')
insert into KhachHang values('KH019','Nguyen Dang Thanh Tu','HCM','0794535787','thanhtu@gmail.com')
insert into KhachHang values('KH020','Nguyen Hoang Tuan','HCM','0793285779','hoangtuan@gmail.com')

select *from KhachHang

insert into SanPham values('SP001','Ao So Mi','20','XL','Den','300000', 'Ao so mi nam tay dai Den LONG SLEEVE')
insert into SanPham values('SP002','Ao So Mi','20','L','Den','300000','Ao so mi nam tay dai Den LONG SLEEVE')
insert into SanPham values('SP003','Ao So Mi','20','M','Den','300000','Ao so mi nam tay dai Den LONG SLEEVE')
insert into SanPham values('SP004','Ao So Mi','25','XL','Trang','300000','Ao so mi nam tay dai Trang LONG SLEEVE')
insert into SanPham values('SP005','Ao So Mi','25','L','Trang','300000','Ao so mi nam tay dai Trang LONG SLEEVE')
insert into SanPham values('SP006','Ao So Mi','25','M','Trang','300000','Ao so mi nam tay dai Trang LONG SLEEVE')
insert into SanPham values('SP007','Quan Tay','30','XL','Den','500000','Quan Tay Nam Han Quoc Ong Con Cao Cấp')
insert into SanPham values('SP008','Quan Tay','30','L','Den','500000','Quan Tay Nam Han Quoc Ong Con Cao Cấp')
insert into SanPham values('SP009','Quan Tay','30','M','Den','500000','Quan Tay Nam Han Quoc Ong Con Cao Cấp')
insert into SanPham values('SP010','Quan Tay','25','XL','Nau','500000','Quan Tay Nam Han Quoc Ong Con Cao Cấp')
insert into SanPham values('SP011','Quan Tay','25','L','Nau','500000','Quan Tay Nam Han Quoc Ong Con Cao Cấp')
insert into SanPham values('SP012','Quan Tay','30','M','Nau','500000','Quan Tay Nam Han Quoc Ong Con Cao Cấp')
insert into SanPham values('SP013','Ao Thun','50','XL','Den','200000','Ao thun cotton bigsize nam nữ in hinh khung long')
insert into SanPham values('SP014','Ao Thun','50','L','Den','200000','Ao thun cotton bigsize nam nữ in hinh khung long')
insert into SanPham values('SP015','Ao Thun','50','M','Den','200000','Ao thun cotton bigsize nam nữ in hinh khung long')
insert into SanPham values('SP016','Ao Thun','60','XL','Trang','200000','Ao thun cotton bigsize nam nữ in hinh khung long')
insert into SanPham values('SP017','Ao Thun','60','L','Trang','200000','Ao thun cotton bigsize nam nữ in hinh khung long')
insert into SanPham values('SP018','Ao Thun','60','M','Trang','200000','Ao thun cotton bigsize nam nữ in hinh khung long')
insert into SanPham values('SP019','Ao PoLo','40','XL','Nau','250000','Ao Polo Basic unisex tron thun nam cotton cao cap')
insert into SanPham values('SP020','Ao PoLo','40','L','Nau','250000','Ao Polo Basic unisex tron thun nam cotton cao cap')
insert into SanPham values('SP021','Ao PoLo','40','M','Nau','250000','Ao Polo Basic unisex tron thun nam cotton cao cap')
insert into SanPham values('SP022','Ao PoLo','40','XL','Xanh','250000','Ao Polo Basic unisex tron thun nam cotton cao cap')
insert into SanPham values('SP023','Ao PoLo','40','L','Xanh','250000','Ao Polo Basic unisex tron thun nam cotton cao cap')
insert into SanPham values('SP024','Ao PoLo','40','M','Xanh','250000','Ao Polo Basic unisex tron thun nam cotton cao cap')

insert into SanPham values('SP025','Ao PoLo tron','30','XL','Hong','250000','Ao Polo Basic unisex tron thun nam cotton cao cap')
insert into SanPham values('SP026','Ao PoLo tron','30','L','Hong','250000','Ao Polo Basic unisex tron thun nam cotton cao cap')
insert into SanPham values('SP027','Ao PoLo tron','30','M','Hong','250000','Ao Polo Basic unisex tron thun nam cotton cao cap')
insert into SanPham values('SP028','Ao PoLo tron','30','XL','Luc','250000','Ao Polo Basic unisex tron thun nam cotton cao cap')
insert into SanPham values('SP029','Ao PoLo tron','30','L','Luc','250000','Ao Polo Basic unisex tron thun nam cotton cao cap')
insert into SanPham values('SP030','Ao PoLo tron','30','M','Luc','250000','Ao Polo Basic unisex tron thun nam cotton cao cap')

insert into SanPham values('SP031','Quan Jean  Baggy Nam','35','XL','Den','600000','Quan Jeans Baggy Nam ong Rong Dang Suong')
insert into SanPham values('SP032','Quan Jean  Baggy Nam','35','L','Den','600000','Quan Jeans Baggy Nam ong Rong Dang Suong')
insert into SanPham values('SP033','Quan Jean  Baggy Nam','35','M','Den','600000','Quan Jeans Baggy Nam ong Rong Dang Suong')
insert into SanPham values('SP034','Quan Jean  Baggy Nam','25','XL','Xanh','600000','Quan Jeans Baggy Nam ong Rong Dang Suong')
insert into SanPham values('SP035','Quan Jean  Baggy Nam','25','L','Xanh','600000','Quan Jeans Baggy Nam ong Rong Dang Suong')
insert into SanPham values('SP036','Quan Jean  Baggy Nam','30','M','Xanh','600000','Quan Jeans Baggy Nam ong Rong Dang Suong')
insert into SanPham values('SP037','Quan Jean  Baggy Nam','45','XL','Xam','600000','Quan Jeans Baggy Nam ong Rong Dang Suong')
insert into SanPham values('SP038','Quan Jean  Baggy Nam','35','L','Xam','600000','Quan Jeans Baggy Nam ong Rong Dang Suong')
insert into SanPham values('SP039','Quan Jean  Baggy Nam','30','M','Xam','600000','Quan Jeans Baggy Nam ong Rong Dang Suong')

insert into SanPham values('SP040','Non luoi trai','45','XL','Den','150000','Non luoi trai Everest unisex vai thoi trang nhieu mau')
insert into SanPham values('SP041','Non luoi trai','35','XL','Xam','150000','Non luoi trai Everest unisex vai thoi trang nhieu mau')
insert into SanPham values('SP042','Non luoi trai','30','XL','Hong','150000','Non luoi trai Everest unisex vai thoi trang nhieu mau')

select *from SanPham

insert into LoaiSanPham values('SP001','Ao','Cotton lua','HCM','Nam')
insert into LoaiSanPham values('SP002','Ao','Cotton lua','HCM','Nam')
insert into LoaiSanPham values('SP003','Ao','Cotton lua','HCM','Nam')
insert into LoaiSanPham values('SP004','Ao','Cotton lua','HCM','Nam')
insert into LoaiSanPham values('SP005','Ao','Cotton lua','HCM','Nam')
insert into LoaiSanPham values('SP006','Ao','Cotton lua','HCM','Nam')
insert into LoaiSanPham values('SP007','Quan','Vai Tuyet Han','HCM','Nam')
insert into LoaiSanPham values('SP008','Quan','Vai Tuyet Han','HCM','Nam')
insert into LoaiSanPham values('SP009','Quan','Vai Tuyet Han','HCM','Nam')
insert into LoaiSanPham values('SP010','Quan','Vai Tuyet Han','HCM','Nam')
insert into LoaiSanPham values('SP011','Quan','Vai Tuyet Han','HCM','Nam')
insert into LoaiSanPham values('SP012','Quan','Vai Tuyet Han','HCM','Nam')
insert into LoaiSanPham values('SP013','Ao','Cotton','HCM','unisex')
insert into LoaiSanPham values('SP014','Ao','Cotton','HCM','unisex')
insert into LoaiSanPham values('SP015','Ao','Cotton','HCM','unisex')
insert into LoaiSanPham values('SP016','Ao','Cotton','HCM','unisex')
insert into LoaiSanPham values('SP017','Ao','Cotton','HCM','unisex')
insert into LoaiSanPham values('SP018','Ao','Cotton','HCM','unisex')
insert into LoaiSanPham values('SP019','Ao','Thun Ca Sau 4 Chieu','HCM','unisex')
insert into LoaiSanPham values('SP020','Ao','Thun Ca Sau 4 Chieu','HCM','unisex')
insert into LoaiSanPham values('SP021','Ao','Thun Ca Sau 4 Chieu','HCM','unisex')
insert into LoaiSanPham values('SP022','Ao','Thun Ca Sau 4 Chieu','HCM','unisex')
insert into LoaiSanPham values('SP023','Ao','Thun Ca Sau 4 Chieu','HCM','unisex')
insert into LoaiSanPham values('SP024','Ao','Thun Ca Sau 4 Chieu','HCM','unisex')

insert into LoaiSanPham values('SP025','Ao','Thun Ca Sau 4 Chieu','HCM','unisex')
insert into LoaiSanPham values('SP026','Ao','Thun Ca Sau 4 Chieu','HCM','unisex')
insert into LoaiSanPham values('SP027','Ao','Thun Ca Sau 4 Chieu','HCM','unisex')
insert into LoaiSanPham values('SP028','Ao','Thun Ca Sau 4 Chieu','HCM','unisex')
insert into LoaiSanPham values('SP029','Ao','Thun Ca Sau 4 Chieu','HCM','unisex')
insert into LoaiSanPham values('SP030','Ao','Thun Ca Sau 4 Chieu','HCM','unisex')
 
insert into LoaiSanPham values('SP031','Quan','Vai Denim','HCM','Nam')
insert into LoaiSanPham values('SP032','Quan','Vai Denim','HCM','Nam')
insert into LoaiSanPham values('SP033','Quan','Vai Denim','HCM','Nam')
insert into LoaiSanPham values('SP034','Quan','Vai Denim','HCM','Nam')
insert into LoaiSanPham values('SP035','Quan','Vai Denim','HCM','Nam')
insert into LoaiSanPham values('SP036','Quan','Vai Denim','HCM','Nam')
insert into LoaiSanPham values('SP037','Quan','Vai Denim','HCM','Nam')
insert into LoaiSanPham values('SP038','Quan','Vai Denim','HCM','Nam')
insert into LoaiSanPham values('SP039','Quan','Vai Denim','HCM','Nam')

insert into LoaiSanPham values('SP040','Non','Vai kaki','HCM','unisex')
insert into LoaiSanPham values('SP041','Non','Vai kaki','HCM','unisex')
insert into LoaiSanPham values('SP042','Non','Vai kaki','HCM','unisex')
select *from LoaiSanPham



select *from HoaDon

insert into HoaDon values('HD0001','2022-10-10','NV001','Nguyen Thanh Khoa','KH001','100000','1100000','1100000','0')
insert into HoaDon values('HD0002','2022-10-11','NV001','Nguyen Thanh Khoa','KH002','120000','1320000','1500000','180000')
insert into HoaDon values('HD0003','2022-10-11','NV002','Nguyen Thanh Bao Long','KH003','80000','880000','1000000','120000')
insert into HoaDon values('HD0004','2022-10-12','NV002','Nguyen Thanh Bao Long','KH004','140000','1540000','1600000','60000')
insert into HoaDon values('HD0005','2022-10-09','NV003','Tran Nguyen Minh Khoi','KH005','90000','990000','1000000','10000')
insert into HoaDon values('HD0006','2022-10-10','NV003','Tran Nguyen Minh Khoi','KH006','110000','1210000','1300000','90000')
insert into HoaDon values('HD0007','2022-10-10','NV004','Nguyen Thanh Son','KH007','100000','1100000','1200000','100000')
insert into HoaDon values('HD0008','2022-10-11','NV004','Nguyen Thanh Son','KH008','120000','1320000','1500000','180000')
insert into HoaDon values('HD0009','2022-10-09','NV005','Pham Van Hau','KH009','70000','770000','800000','30000')
insert into HoaDon values('HD0010','2022-10-11','NV005','Pham Van Hau','KH010','100000','1100000','1500000','400000')

insert into HoaDon values('HD0011','2022-10-25','NV006','Nguyen Thanh Hung','KH011','125000','1375000','1500000','125000')
insert into HoaDon values('HD0012','2022-10-26','NV006','Nguyen Thanh Hung','KH012','50000','500000','500000','0')
insert into HoaDon values('HD0013','2022-10-25','NV007','Nguyen Thanh Long','KH013','85000','935000','1000000','65000')
insert into HoaDon values('HD0014','2022-10-26','NV007','Nguyen Thanh Long','KH014','130000','1430000','1500000','70000')
insert into HoaDon values('HD0015','2022-10-27','NV008','Tran Nguyen Hoàng Son','KH015','100000','1100000','1200000','100000')
insert into HoaDon values('HD0016','2022-10-28','NV008','Tran Nguyen Hoàng Son','KH016','25000','275000','300000','25000')
insert into HoaDon values('HD0017','2022-10-28','NV009','Nguyen Thanh Tuan','KH017','40000','440000','500000','60000')
insert into HoaDon values('HD0018','2022-10-28','NV009','Nguyen Thanh Tuan','KH018','75000','825000','900000','75000')
insert into HoaDon values('HD0019','2022-10-29','NV010','Pham Huu Tai','KH019','55000','605000','700000','95000')
insert into HoaDon values('HD0020','2022-10-30','NV010','Pham Huu Tai','KH020','20000','220000','250000','30000')


insert into HoaDon values('HD0021','2022-11-01','NV011','Nguyen Thanh Ngan','KH011','80000','880000','1000000','120000')
insert into HoaDon values('HD0022','2022-11-01','NV011','Nguyen Thanh Ngan','KH012','65000','715000','1000000','285000')
insert into HoaDon values('HD0023','2022-11-01','NV012','Nguyen Bao Ngoc','KH013','120000','1320000','1500000','180000')
insert into HoaDon values('HD0024','2022-11-01','NV012','Nguyen Bao Ngoc','KH014','45000','495000','500000','5000')
insert into HoaDon values('HD0025','2022-11-01','NV013','Tran Nguyen Ngọc Dung','KH015','85000','935000','950000','15000')
insert into HoaDon values('HD0026','2022-11-01','NV013','Tran Nguyen Ngọc Dung','KH016','55000','605000','605000','0')
insert into HoaDon values('HD0027','2022-11-01','NV014','Nguyen Hoang Mai','KH017','95000','1045000','1100000','55000')
insert into HoaDon values('HD0028','2022-11-01','NV014','Nguyen Hoang Mai','KH018','60000','660000','700000','40000')
insert into HoaDon values('HD0029','2022-11-01','NV015','Pham Thuy Trang','KH019','55000','605000','705000','100000')
insert into HoaDon values('HD0030','2022-11-01','NV015','Pham Thuy Trang','KH020','25000','275000','300000','25000')

insert into HoaDon values('HD0031','2022-11-02','NV001','Nguyen Thanh Khoa','KH001','60000','660000','700000','40000')
insert into HoaDon values('HD0032','2022-11-02','NV001','Nguyen Thanh Khoa','KH002','120000','1320000','1500000','180000')
insert into HoaDon values('HD0033','2022-11-02','NV002','Nguyen Thanh Bao Long','KH003','85000','885000','1000000','115000')
insert into HoaDon values('HD0034','2022-11-02','NV002','Nguyen Thanh Bao Long','KH004','90000','990000','1000000','10000')
insert into HoaDon values('HD0035','2022-11-02','NV003','Tran Nguyen Minh Khoi','KH005','75000','825000','1000000','175000')
insert into HoaDon values('HD0036','2022-11-02','NV003','Tran Nguyen Minh Khoi','KH006','30000','330000','400000','70000')
insert into HoaDon values('HD0037','2022-11-02','NV004','Nguyen Thanh Son','KH007','160000','1760000','2000000','240000')
insert into HoaDon values('HD038','2022-11-02','NV004','Nguyen Thanh Son','KH008','105000','1155000','1200000','45000')
insert into HoaDon values('HD0039','2022-11-02','NV005','Pham Van Hau','KH009','80000','880000','900000','20000')
insert into HoaDon values('HD0040','2022-11-02','NV005','Pham Van Hau','KH010','45000','495000','500000','5000')


select *from ChiTietHoaDon
insert into ChiTietHoaDon values('HD0001','SP001','Ao So Mi Tay Dai','1','300000','300000')
insert into ChiTietHoaDon values('HD0001','SP007','Quan Tay Han Quoc','1','500000','500000')
insert into ChiTietHoaDon  values('HD0001','SP014','Ao Thun in','1','200000','200000')

insert into ChiTietHoaDon values('HD0002','SP010','Quan Tay Han Quoc','2','500000','1000000')
insert into ChiTietHoaDon values('HD0002','SP016','Ao Thun in','1','200000','200000')


insert into ChiTietHoaDon values('HD0003','SP008','Quan Tay Han Quoc','1','500000','500000')
insert into ChiTietHoaDon values('HD0003','SP005','Ao So Mi Tay Dai','1','300000','300000')


insert into ChiTietHoaDon values('HD0004','SP022','Ao PoLo tron','1','250000','250000')
insert into ChiTietHoaDon values('HD0004','SP001','Ao So Mi Tay Dai','1','300000','300000')
insert into ChiTietHoaDon values('HD0004','SP017','Ao Thun in','2','200000','400000')


insert into ChiTietHoaDon values('HD0005','SP011','Quan Tay Han Quoc','1','500000','500000')
insert into ChiTietHoaDon values('HD0005','SP013','Ao Thun in','1','200000','200000')
insert into ChiTietHoaDon values('HD0005','SP014','Ao Thun in','1','200000','200000')

insert into ChiTietHoaDon values('HD0006','SP005','Ao So Mi Tay Dai','2','300000','600000')
insert into ChiTietHoaDon values('HD0006','SP011','Quan Tay Han Quoc','1','500000','500000')


insert into ChiTietHoaDon values('HD0007','SP020','Ao PoLo tron','1','250000','250000')
insert into ChiTietHoaDon values('HD0007','SP023','Ao PoLo tron','1','250000','250000')
insert into ChiTietHoaDon values('HD0007','SP007','Quan Tay Han Quoc','1','500000','500000')


insert into ChiTietHoaDon values('HD0008','SP008','Quan Tay Han Quoc','1','500000','500000')
insert into ChiTietHoaDon values('HD0008','SP019','Ao PoLo tron','2','250000','500000')
insert into ChiTietHoaDon values('HD0008','SP018','Ao PoLo tron','2','250000','500000')

insert into ChiTietHoaDon values('HD0009','SP019','Ao PoLo tron','1','250000','250000')
insert into ChiTietHoaDon values('HD0009','SP022','Ao PoLo tron','1','250000','250000')
insert into ChiTietHoaDon values('HD0009','SP017','Ao Thun in','1','200000','200000')

insert into ChiTietHoaDon values('HD0010','SP007','Quan Tay Han Quoc','1','500000','500000')
insert into ChiTietHoaDon values('HD0010','SP010','Quan Tay Han Quoc','1','500000','500000')



insert into ChiTietHoaDon values('HD0011','SP007','Quan Tay Han Quoc','1','500000','500000')
insert into ChiTietHoaDon values('HD0011','SP028','Ao PoLo tron','2','250000','500000')
insert into ChiTietHoaDon values('HD0011','SP010','Quan Tay Han Quoc','1','500000','500000')

insert into ChiTietHoaDon values('HD0012','SP025','Ao PoLo tron','2','250000','500000')


insert into ChiTietHoaDon values('HD0013','SP001','Ao So Mi Tay Dai','1','300000','300000')
insert into ChiTietHoaDon values('HD0013','SP004','Ao So Mi Tay Dai','1','300000','300000')
insert into ChiTietHoaDon values('HD0013','SP017','Ao Thun in','1','200000','200000')


insert into ChiTietHoaDon values('HD0014','SP008','Quan Tay Han Quoc','1','500000','500000')
insert into ChiTietHoaDon values('HD0014','SP011','Quan Tay Han Quoc','1','500000','500000')
insert into ChiTietHoaDon values('HD0014','SP001','Ao So Mi Tay Dai','1','300000','300000')


insert into ChiTietHoaDon values('HD0015','SP007','Quan Tay Han Quoc','1','500000','500000')
insert into ChiTietHoaDon values('HD0015','SP002','Ao So Mi Tay Dai','1','300000','300000')
insert into ChiTietHoaDon values('HD0015','SP015','Ao Thun in','1','200000','200000')


insert into ChiTietHoaDon values('HD0016','SP029','Ao PoLo tron','1','250000','250000')


insert into ChiTietHoaDon values('HD0017','SP014','Ao Thun in','1','200000','200000')
insert into ChiTietHoaDon values('HD0017','SP017','Ao Thun in','1','200000','200000')



insert into ChiTietHoaDon values('HD0018','SP007','Quan Tay Han Quoc','1','500000','500000')
insert into ChiTietHoaDon values('HD0018','SP021','Ao PoLo tron','1','250000','250000')

insert into ChiTietHoaDon values('HD0019','SP004','Ao So Mi Tay Dai','1','300000','300000')
insert into ChiTietHoaDon values('HD0019','SP025','Ao PoLo tron','1','250000','250000')

insert into ChiTietHoaDon values('HD0020','SP016','Ao Thun in','1','200000','200000')




insert into ChiTietHoaDon values('HD0021','SP007','Ao So Mi Tay Dai','1','300000','300000')
insert into ChiTietHoaDon values('HD0021','SP028','Ao PoLo tron','2','250000','500000')


insert into ChiTietHoaDon values('HD0022','SP017','Ao Thun in','3','200000','600000')


insert into ChiTietHoaDon values('HD0023','SP002','Ao So Mi Tay Dai','1','300000','300000')
insert into ChiTietHoaDon values('HD0023','SP005','Ao So Mi Tay Dai','1','300000','300000')
insert into ChiTietHoaDon values('HD0023','SP018','Ao Thun in','3','200000','600000')


insert into ChiTietHoaDon values('HD0024','SP017','Ao Thun in','1','200000','200000')
insert into ChiTietHoaDon values('HD0024','SP029','Ao PoLo tron','2','250000','500000')


insert into ChiTietHoaDon values('HD0025','SP002','Ao So Mi Tay Dai','2','300000','600000')
insert into ChiTietHoaDon values('HD0025','SP028','Ao PoLo tron','1','250000','250000')


insert into ChiTietHoaDon values('HD0026','SP029','Ao PoLo tron','1','250000','250000')
insert into ChiTietHoaDon values('HD0026','SP001','Ao So Mi Tay Dai','1','300000','300000')


insert into ChiTietHoaDon values('HD0027','SP029','Ao PoLo tron','1','250000','250000')
insert into ChiTietHoaDon values('HD0027','SP017','Ao Thun in','1','200000','200000')
insert into ChiTietHoaDon values('HD0027','SP007','Quan Tay Han Quoc','1','500000','500000')



insert into ChiTietHoaDon values('HD0028','SP004','Ao So Mi Tay Dai','2','300000','300000')


insert into ChiTietHoaDon values('HD0029','SP001','Ao So Mi Tay Dai','1','300000','300000')
insert into ChiTietHoaDon values('HD0029','SP027','Ao PoLo tron','1','250000','250000')

insert into ChiTietHoaDon values('HD0030','SP030','Ao PoLo tron','1','250000','250000')

insert into ChiTietHoaDon values('HD0031','SP031','Quan Jean  Baggy Nam','1','600000','600000')


insert into ChiTietHoaDon values('HD0032','SP034','Quan Jean  Baggy Nam','2','600000','1200000')

insert into ChiTietHoaDon values('HD0033','SP032','Quan Jean  Baggy Nam','1','600000','600000')
insert into ChiTietHoaDon values('HD0033','SP027','Ao PoLo tron','1','250000','250000')

insert into ChiTietHoaDon values('HD0034','SP035','Quan Jean  Baggy Nam','1','600000','600000')
insert into ChiTietHoaDon values('HD0034','SP001','Ao So Mi Tay Dai','1','300000','300000')

insert into ChiTietHoaDon values('HD0035','SP035','Quan Jean  Baggy Nam','1','600000','600000')
insert into ChiTietHoaDon values('HD0035','SP041','Non luoi trai','1','150000','150000')

insert into ChiTietHoaDon values('HD0036','SP040','Non luoi trai','2','150000','300000')


insert into ChiTietHoaDon values('HD0037','SP029','Ao PoLo tron','2','250000','500000')
insert into ChiTietHoaDon values('HD0037','SP035','Quan Jean  Baggy Nam','1','600000','600000')
insert into ChiTietHoaDon values('HD0037','SP007','Quan Tay Han Quoc','1','500000','500000')


insert into ChiTietHoaDon values('HD0038','SP001','Ao So Mi Tay Dai','1','300000','300000')
insert into ChiTietHoaDon values('HD0038','SP035','Quan Jean  Baggy Nam','1','600000','600000')
insert into ChiTietHoaDon values('HD0038','SP041','Non luoi trai','1','150000','150000')

insert into ChiTietHoaDon values('HD0039','SP029','Ao PoLo tron','2','250000','500000')
insert into ChiTietHoaDon values('HD0039','SP042','Non luoi trai','2','150000','300000')

insert into ChiTietHoaDon values('HD0040','SP004','Ao So Mi Tay Dai','1','300000','300000')
insert into ChiTietHoaDon values('HD0040','SP040','Non luoi trai','1','150000','150000')

 join SanPham on ChiTietHoaDon.tenSP= SanPham.tenSP