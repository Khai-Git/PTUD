USE [CuaHangQA]
GO
ALTER TABLE [dbo].[PhanCongCaLam] DROP CONSTRAINT [FK_PhanCongCaLam_NhanVien]
GO
ALTER TABLE [dbo].[PhanCongCaLam] DROP CONSTRAINT [FK_PhanCongCaLam_CaLam]
GO
ALTER TABLE [dbo].[NhanVien] DROP CONSTRAINT [FK_NhanVien_TaiKhoan]
GO
ALTER TABLE [dbo].[HoaDonNhapHang] DROP CONSTRAINT [FK_HoaDonNhapHang_NhanVien]
GO
ALTER TABLE [dbo].[HoaDonNhapHang] DROP CONSTRAINT [FK_HoaDonNhapHang_NhaCungCap]
GO
ALTER TABLE [dbo].[HoaDonBanHang] DROP CONSTRAINT [FK_HoaDonBanHang_NhanVien]
GO
ALTER TABLE [dbo].[HoaDonBanHang] DROP CONSTRAINT [FK_HoaDonBanHang_KhachHang]
GO
ALTER TABLE [dbo].[ChiTieTHoaDonNH] DROP CONSTRAINT [FK_ChiTieTHoaDonNH_SanPham]
GO
ALTER TABLE [dbo].[ChiTieTHoaDonNH] DROP CONSTRAINT [FK_ChiTieTHoaDonNH_HoaDonNhapHang]
GO
ALTER TABLE [dbo].[ChiTietHoaDonBH] DROP CONSTRAINT [FK_ChiTietHoaDonBH_SanPham]
GO
ALTER TABLE [dbo].[ChiTietHoaDonBH] DROP CONSTRAINT [FK_ChiTietHoaDonBH_HoaDonBanHang]
GO
/****** Object:  Table [dbo].[TaiKhoan]    Script Date: 12/22/2021 12:25:02 AM ******/
DROP TABLE [dbo].[TaiKhoan]
GO
/****** Object:  Table [dbo].[SanPham]    Script Date: 12/22/2021 12:25:02 AM ******/
DROP TABLE [dbo].[SanPham]
GO
/****** Object:  Table [dbo].[PhanCongCaLam]    Script Date: 12/22/2021 12:25:02 AM ******/
DROP TABLE [dbo].[PhanCongCaLam]
GO
/****** Object:  Table [dbo].[NhanVien]    Script Date: 12/22/2021 12:25:02 AM ******/
DROP TABLE [dbo].[NhanVien]
GO
/****** Object:  Table [dbo].[NhaCungCap]    Script Date: 12/22/2021 12:25:02 AM ******/
DROP TABLE [dbo].[NhaCungCap]
GO
/****** Object:  Table [dbo].[KhachHang]    Script Date: 12/22/2021 12:25:02 AM ******/
DROP TABLE [dbo].[KhachHang]
GO
/****** Object:  Table [dbo].[HoaDonNhapHang]    Script Date: 12/22/2021 12:25:02 AM ******/
DROP TABLE [dbo].[HoaDonNhapHang]
GO
/****** Object:  Table [dbo].[HoaDonBanHang]    Script Date: 12/22/2021 12:25:02 AM ******/
DROP TABLE [dbo].[HoaDonBanHang]
GO
/****** Object:  Table [dbo].[ChiTieTHoaDonNH]    Script Date: 12/22/2021 12:25:02 AM ******/
DROP TABLE [dbo].[ChiTieTHoaDonNH]
GO
/****** Object:  Table [dbo].[ChiTietHoaDonBH]    Script Date: 12/22/2021 12:25:02 AM ******/
DROP TABLE [dbo].[ChiTietHoaDonBH]
GO
/****** Object:  Table [dbo].[CaLam]    Script Date: 12/22/2021 12:25:02 AM ******/
DROP TABLE [dbo].[CaLam]
GO
USE [master]
GO
/****** Object:  Database [CuaHangQA]    Script Date: 12/22/2021 12:25:02 AM ******/
DROP DATABASE [CuaHangQA]
GO
/****** Object:  Database [CuaHangQA]    Script Date: 12/22/2021 12:25:02 AM ******/
CREATE DATABASE [CuaHangQA]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'CuaHangQA', FILENAME = N'D:\STUDY\(22-23) HOC KY 1\PHAT TRIEN UNG DUNG\Project\VinhPr\Nhom9_DeTai1_DHKTPM15BTT_PTUD\data\CuaHangQA.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'CuaHangQA_log', FILENAME = N'D:\STUDY\(22-23) HOC KY 1\PHAT TRIEN UNG DUNG\Project\VinhPr\Nhom9_DeTai1_DHKTPM15BTT_PTUD\data\CuaHangQA_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [CuaHangQA].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [CuaHangQA] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [CuaHangQA] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [CuaHangQA] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [CuaHangQA] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [CuaHangQA] SET ARITHABORT OFF 
GO
ALTER DATABASE [CuaHangQA] SET AUTO_CLOSE ON 
GO
ALTER DATABASE [CuaHangQA] SET AUTO_CREATE_STATISTICS ON 
GO
ALTER DATABASE [CuaHangQA] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [CuaHangQA] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [CuaHangQA] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [CuaHangQA] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [CuaHangQA] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [CuaHangQA] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [CuaHangQA] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [CuaHangQA] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [CuaHangQA] SET  ENABLE_BROKER 
GO
ALTER DATABASE [CuaHangQA] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [CuaHangQA] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [CuaHangQA] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [CuaHangQA] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [CuaHangQA] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [CuaHangQA] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [CuaHangQA] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [CuaHangQA] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [CuaHangQA] SET  MULTI_USER 
GO
ALTER DATABASE [CuaHangQA] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [CuaHangQA] SET DB_CHAINING OFF 
GO
ALTER DATABASE [CuaHangQA] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [CuaHangQA] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
USE [CuaHangQA]
GO
/****** Object:  Table [dbo].[CaLam]    Script Date: 12/22/2021 12:25:02 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[CaLam](
	[MaCaLam] [varchar](50) NOT NULL,
	[TenCaLam] [nvarchar](50) NULL,
	[ThoiGianBatDau] [nvarchar](50) NULL,
	[ThoiGianKetThuc] [nvarchar](50) NULL,
 CONSTRAINT [PK_CaLam] PRIMARY KEY CLUSTERED 
(
	[MaCaLam] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ChiTietHoaDonBH]    Script Date: 12/22/2021 12:25:02 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ChiTietHoaDonBH](
	[MaHoaDon] [varchar](50) NOT NULL,
	[MaSanPham] [varchar](50) NOT NULL,
	[SoLuong] [int] NULL,
	[ThanhTien] [money] NULL,
 CONSTRAINT [PK_ChiTietHoaDonBH] PRIMARY KEY CLUSTERED 
(
	[MaHoaDon] ASC,
	[MaSanPham] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ChiTieTHoaDonNH]    Script Date: 12/22/2021 12:25:02 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ChiTieTHoaDonNH](
	[MaHoaDon] [varchar](50) NOT NULL,
	[MaSanPham] [varchar](50) NOT NULL,
	[SoLuong] [int] NULL,
	[LoHang] [varchar](50) NULL,
	[ThanhTien] [money] NULL,
 CONSTRAINT [PK_ChiTieTHoaDonNH] PRIMARY KEY CLUSTERED 
(
	[MaHoaDon] ASC,
	[MaSanPham] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[HoaDonBanHang]    Script Date: 12/22/2021 12:25:02 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[HoaDonBanHang](
	[MaHoaDon] [varchar](50) NOT NULL,
	[NgayLap] [datetime] NULL,
	[MaKhachHang] [varchar](50) NULL,
	[MaNhanVien] [varchar](50) NULL,
 CONSTRAINT [PK_HoaDonBanHang] PRIMARY KEY CLUSTERED 
(
	[MaHoaDon] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[HoaDonNhapHang]    Script Date: 12/22/2021 12:25:02 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[HoaDonNhapHang](
	[MaHoaDon] [varchar](50) NOT NULL,
	[NgayLap] [datetime] NULL,
	[MaNhaCungCap] [varchar](50) NULL,
	[MaNhanVien] [varchar](50) NULL,
 CONSTRAINT [PK_HoaDonNhapHang] PRIMARY KEY CLUSTERED 
(
	[MaHoaDon] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[KhachHang]    Script Date: 12/22/2021 12:25:02 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[KhachHang](
	[MaKhachHang] [varchar](50) NOT NULL,
	[TenKhachHang] [nvarchar](50) NULL,
	[NgaySinh] [datetime] NULL,
	[GioiTinh] [varchar](50) NULL,
	[SoDienThoai] [varchar](50) NULL,
	[DiaChi] [nvarchar](50) NULL,
 CONSTRAINT [PK_KhachHang] PRIMARY KEY CLUSTERED 
(
	[MaKhachHang] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[NhaCungCap]    Script Date: 12/22/2021 12:25:02 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[NhaCungCap](
	[MaNhaCungCap] [varchar](50) NOT NULL,
	[TenNhaCungCap] [nvarchar](50) NULL,
	[Email] [nvarchar](50) NULL,
	[SoDienThoai] [varchar](50) NULL,
	[DiaChi] [nvarchar](50) NULL,
 CONSTRAINT [PK_NhaCungCap] PRIMARY KEY CLUSTERED 
(
	[MaNhaCungCap] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[NhanVien]    Script Date: 12/22/2021 12:25:02 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[NhanVien](
	[MaNhanVien] [varchar](50) NOT NULL,
	[TenNhanVien] [nvarchar](50) NULL,
	[GioiTinh] [varchar](50) NULL,
	[NgaySinh] [datetime] NULL,
	[NgayVaoLam] [datetime] NULL,
	[SCMND] [varchar](50) NULL,
	[DiaChi] [nvarchar](50) NULL,
	[SoDienThoai] [varchar](50) NULL,
	[TinhTrang] [nvarchar](10) NULL,
 CONSTRAINT [PK_NhanVien] PRIMARY KEY CLUSTERED 
(
	[MaNhanVien] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[PhanCongCaLam]    Script Date: 12/22/2021 12:25:02 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[PhanCongCaLam](
	[NgayLam] [datetime] NULL,
	[NgayPhan] [datetime] NULL,
	[MaCaLam] [varchar](50) NOT NULL,
	[MaNhanVien] [varchar](50) NOT NULL,
 CONSTRAINT [PK_PhanCongCaLam] PRIMARY KEY CLUSTERED 
(
	[MaCaLam] ASC,
	[MaNhanVien] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[SanPham]    Script Date: 12/22/2021 12:25:02 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[SanPham](
	[MaSanPham] [varchar](50) NOT NULL,
	[TenSanPham] [nvarchar](50) NULL,
	[Hang] [nvarchar](50) NULL,
	[Loai] [nvarchar](50) NULL,
	[SoLuongTon] [int] NULL,
	[LoHang] [varchar](50) NULL,
	[Size] [varchar](50) NULL,
	[GiaBan] [money] NULL,
	[GiaNhap] [money] NULL,
	[Mau] [nvarchar](50) NULL,
	[NgayNhap] [datetime] NULL,
	[MaNhaCungCap] [varchar](50) NULL,
	[TenNhaCungCap] [nvarchar](50) NULL,
 CONSTRAINT [PK_SanPham] PRIMARY KEY CLUSTERED 
(
	[MaSanPham] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[TaiKhoan]    Script Date: 12/22/2021 12:25:02 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[TaiKhoan](
	[MaNhanVien] [varchar](50) NOT NULL,	
	[ID] [varchar](50) NULL,
	[Pass] [varchar](50) NULL,
 CONSTRAINT [PK_TaiKhoan] PRIMARY KEY CLUSTERED 
(
	[MaNhanVien] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
INSERT [dbo].[ChiTietHoaDonBH] ([MaHoaDon], [MaSanPham], [SoLuong], [ThanhTien]) VALUES (N'HDBH001', N'SP003', 2, 260000.0000)
INSERT [dbo].[ChiTietHoaDonBH] ([MaHoaDon], [MaSanPham], [SoLuong], [ThanhTien]) VALUES (N'HDBH001', N'SP005', 4, 800000.0000)
INSERT [dbo].[ChiTietHoaDonBH] ([MaHoaDon], [MaSanPham], [SoLuong], [ThanhTien]) VALUES (N'HDBH002', N'SP005', 3, 600000.0000)
INSERT [dbo].[ChiTietHoaDonBH] ([MaHoaDon], [MaSanPham], [SoLuong], [ThanhTien]) VALUES (N'HDBH003', N'SP003', 2, 260000.0000)
INSERT [dbo].[ChiTietHoaDonBH] ([MaHoaDon], [MaSanPham], [SoLuong], [ThanhTien]) VALUES (N'HDBH004', N'SP003', 3, 390000.0000)
INSERT [dbo].[ChiTietHoaDonBH] ([MaHoaDon], [MaSanPham], [SoLuong], [ThanhTien]) VALUES (N'HDBH005', N'SP002', 3, 450000.0000)
INSERT [dbo].[ChiTietHoaDonBH] ([MaHoaDon], [MaSanPham], [SoLuong], [ThanhTien]) VALUES (N'HDBH005', N'SP006', 2, 200000.0000)
INSERT [dbo].[ChiTietHoaDonBH] ([MaHoaDon], [MaSanPham], [SoLuong], [ThanhTien]) VALUES (N'HDBH006', N'SP003', 3, 390000.0000)
INSERT [dbo].[ChiTietHoaDonBH] ([MaHoaDon], [MaSanPham], [SoLuong], [ThanhTien]) VALUES (N'HDBH006', N'SP004', 3, 750000.0000)
INSERT [dbo].[ChiTietHoaDonBH] ([MaHoaDon], [MaSanPham], [SoLuong], [ThanhTien]) VALUES (N'HDBH007', N'SP003', 2, 260000.0000)
INSERT [dbo].[ChiTietHoaDonBH] ([MaHoaDon], [MaSanPham], [SoLuong], [ThanhTien]) VALUES (N'HDBH007', N'SP004', 1, 250000.0000)
INSERT [dbo].[ChiTietHoaDonBH] ([MaHoaDon], [MaSanPham], [SoLuong], [ThanhTien]) VALUES (N'HDBH008', N'SP002', 1, 150000.0000)
INSERT [dbo].[ChiTietHoaDonBH] ([MaHoaDon], [MaSanPham], [SoLuong], [ThanhTien]) VALUES (N'HDBH008', N'SP005', 2, 400000.0000)
INSERT [dbo].[ChiTietHoaDonBH] ([MaHoaDon], [MaSanPham], [SoLuong], [ThanhTien]) VALUES (N'HDBH009', N'SP002', 2, 300000.0000)
INSERT [dbo].[ChiTietHoaDonBH] ([MaHoaDon], [MaSanPham], [SoLuong], [ThanhTien]) VALUES (N'HDBH009', N'SP006', 1, 100000.0000)
INSERT [dbo].[ChiTietHoaDonBH] ([MaHoaDon], [MaSanPham], [SoLuong], [ThanhTien]) VALUES (N'HDBH010', N'SP006', 2, 200000.0000)
INSERT [dbo].[ChiTietHoaDonBH] ([MaHoaDon], [MaSanPham], [SoLuong], [ThanhTien]) VALUES (N'HDBH010', N'SP007', 1, 150000.0000)
INSERT [dbo].[ChiTietHoaDonBH] ([MaHoaDon], [MaSanPham], [SoLuong], [ThanhTien]) VALUES (N'HDBH011', N'SP002', 2, 300000.0000)
INSERT [dbo].[ChiTietHoaDonBH] ([MaHoaDon], [MaSanPham], [SoLuong], [ThanhTien]) VALUES (N'HDBH011', N'SP003', 1, 130000.0000)
INSERT [dbo].[ChiTietHoaDonBH] ([MaHoaDon], [MaSanPham], [SoLuong], [ThanhTien]) VALUES (N'HDBH011', N'SP004', 1, 250000.0000)
INSERT [dbo].[ChiTietHoaDonBH] ([MaHoaDon], [MaSanPham], [SoLuong], [ThanhTien]) VALUES (N'HDBH011', N'SP007', 2, 300000.0000)
INSERT [dbo].[ChiTietHoaDonBH] ([MaHoaDon], [MaSanPham], [SoLuong], [ThanhTien]) VALUES (N'HDBH011', N'SP008', 2, 440000.0000)
INSERT [dbo].[ChiTietHoaDonBH] ([MaHoaDon], [MaSanPham], [SoLuong], [ThanhTien]) VALUES (N'HDBH012', N'SP002', 1, 150000.0000)
INSERT [dbo].[ChiTietHoaDonBH] ([MaHoaDon], [MaSanPham], [SoLuong], [ThanhTien]) VALUES (N'HDBH012', N'SP003', 1, 130000.0000)
INSERT [dbo].[ChiTietHoaDonBH] ([MaHoaDon], [MaSanPham], [SoLuong], [ThanhTien]) VALUES (N'HDBH012', N'SP004', 1, 250000.0000)
INSERT [dbo].[ChiTietHoaDonBH] ([MaHoaDon], [MaSanPham], [SoLuong], [ThanhTien]) VALUES (N'HDBH012', N'SP005', 1, 200000.0000)
INSERT [dbo].[ChiTietHoaDonBH] ([MaHoaDon], [MaSanPham], [SoLuong], [ThanhTien]) VALUES (N'HDBH012', N'SP006', 1, 100000.0000)
INSERT [dbo].[ChiTietHoaDonBH] ([MaHoaDon], [MaSanPham], [SoLuong], [ThanhTien]) VALUES (N'HDBH012', N'SP007', 1, 150000.0000)
INSERT [dbo].[ChiTietHoaDonBH] ([MaHoaDon], [MaSanPham], [SoLuong], [ThanhTien]) VALUES (N'HDBH013', N'SP003', 1, 130000.0000)
INSERT [dbo].[ChiTietHoaDonBH] ([MaHoaDon], [MaSanPham], [SoLuong], [ThanhTien]) VALUES (N'HDBH014', N'SP006', 1, 100000.0000)
INSERT [dbo].[ChiTietHoaDonBH] ([MaHoaDon], [MaSanPham], [SoLuong], [ThanhTien]) VALUES (N'HDBH015', N'SP003', 1, 130000.0000)
INSERT [dbo].[ChiTietHoaDonBH] ([MaHoaDon], [MaSanPham], [SoLuong], [ThanhTien]) VALUES (N'HDBH015', N'SP004', 1, 250000.0000)
INSERT [dbo].[ChiTietHoaDonBH] ([MaHoaDon], [MaSanPham], [SoLuong], [ThanhTien]) VALUES (N'HDBH015', N'SP006', 2, 200000.0000)
INSERT [dbo].[ChiTietHoaDonBH] ([MaHoaDon], [MaSanPham], [SoLuong], [ThanhTien]) VALUES (N'HDBH016', N'SP002', 1, 150000.0000)
INSERT [dbo].[ChiTietHoaDonBH] ([MaHoaDon], [MaSanPham], [SoLuong], [ThanhTien]) VALUES (N'HDBH017', N'SP004', 1, 250000.0000)
INSERT [dbo].[ChiTietHoaDonBH] ([MaHoaDon], [MaSanPham], [SoLuong], [ThanhTien]) VALUES (N'HDBH018', N'SP002', 1, 150000.0000)
INSERT [dbo].[ChiTieTHoaDonNH] ([MaHoaDon], [MaSanPham], [SoLuong], [LoHang], [ThanhTien]) VALUES (N'HDNH019', N'SP009', 30, N'LH023', 1500000.0000)
INSERT [dbo].[ChiTieTHoaDonNH] ([MaHoaDon], [MaSanPham], [SoLuong], [LoHang], [ThanhTien]) VALUES (N'HDNH020', N'SP010', 34, N'hjk', 5100000.0000)
INSERT [dbo].[ChiTieTHoaDonNH] ([MaHoaDon], [MaSanPham], [SoLuong], [LoHang], [ThanhTien]) VALUES (N'HDNH020', N'SP011', 33, N'khlp', 99000.0000)
INSERT [dbo].[ChiTieTHoaDonNH] ([MaHoaDon], [MaSanPham], [SoLuong], [LoHang], [ThanhTien]) VALUES (N'HDNH020', N'SP012', 34, N'LHKIO', 5100000.0000)
INSERT [dbo].[ChiTieTHoaDonNH] ([MaHoaDon], [MaSanPham], [SoLuong], [LoHang], [ThanhTien]) VALUES (N'HDNH020', N'SP013', 38, N'LHKKIO2', 5700000.0000)
INSERT [dbo].[HoaDonBanHang] ([MaHoaDon], [NgayLap], [MaKhachHang], [MaNhanVien]) VALUES (N'HDBH001', CAST(N'2021-12-20 00:00:00.000' AS DateTime), N'KH002', NULL)
INSERT [dbo].[HoaDonBanHang] ([MaHoaDon], [NgayLap], [MaKhachHang], [MaNhanVien]) VALUES (N'HDBH002', CAST(N'2021-12-20 00:00:00.000' AS DateTime), N'KH003', NULL)
INSERT [dbo].[HoaDonBanHang] ([MaHoaDon], [NgayLap], [MaKhachHang], [MaNhanVien]) VALUES (N'HDBH003', CAST(N'2021-12-20 00:00:00.000' AS DateTime), N'KH002', NULL)
INSERT [dbo].[HoaDonBanHang] ([MaHoaDon], [NgayLap], [MaKhachHang], [MaNhanVien]) VALUES (N'HDBH004', CAST(N'2021-12-21 00:00:00.000' AS DateTime), N'KH004', NULL)
INSERT [dbo].[HoaDonBanHang] ([MaHoaDon], [NgayLap], [MaKhachHang], [MaNhanVien]) VALUES (N'HDBH005', CAST(N'2021-12-21 00:00:00.000' AS DateTime), N'KH005', NULL)
INSERT [dbo].[HoaDonBanHang] ([MaHoaDon], [NgayLap], [MaKhachHang], [MaNhanVien]) VALUES (N'HDBH006', CAST(N'2021-12-21 00:00:00.000' AS DateTime), N'KH005', NULL)
INSERT [dbo].[HoaDonBanHang] ([MaHoaDon], [NgayLap], [MaKhachHang], [MaNhanVien]) VALUES (N'HDBH007', CAST(N'2021-12-21 00:00:00.000' AS DateTime), N'KH006', NULL)
INSERT [dbo].[HoaDonBanHang] ([MaHoaDon], [NgayLap], [MaKhachHang], [MaNhanVien]) VALUES (N'HDBH008', CAST(N'2021-12-21 00:00:00.000' AS DateTime), N'KH006', NULL)
INSERT [dbo].[HoaDonBanHang] ([MaHoaDon], [NgayLap], [MaKhachHang], [MaNhanVien]) VALUES (N'HDBH009', CAST(N'2021-12-21 00:00:00.000' AS DateTime), N'KH006', NULL)
INSERT [dbo].[HoaDonBanHang] ([MaHoaDon], [NgayLap], [MaKhachHang], [MaNhanVien]) VALUES (N'HDBH010', CAST(N'2021-12-21 00:00:00.000' AS DateTime), N'KH006', NULL)
INSERT [dbo].[HoaDonBanHang] ([MaHoaDon], [NgayLap], [MaKhachHang], [MaNhanVien]) VALUES (N'HDBH011', CAST(N'2021-12-21 00:00:00.000' AS DateTime), N'KH006', NULL)
INSERT [dbo].[HoaDonBanHang] ([MaHoaDon], [NgayLap], [MaKhachHang], [MaNhanVien]) VALUES (N'HDBH012', CAST(N'2021-12-21 00:00:00.000' AS DateTime), N'KH006', NULL)
INSERT [dbo].[HoaDonBanHang] ([MaHoaDon], [NgayLap], [MaKhachHang], [MaNhanVien]) VALUES (N'HDBH013', CAST(N'2021-12-21 00:00:00.000' AS DateTime), N'KH006', NULL)
INSERT [dbo].[HoaDonBanHang] ([MaHoaDon], [NgayLap], [MaKhachHang], [MaNhanVien]) VALUES (N'HDBH014', CAST(N'2021-12-21 00:00:00.000' AS DateTime), N'KH006', NULL)
INSERT [dbo].[HoaDonBanHang] ([MaHoaDon], [NgayLap], [MaKhachHang], [MaNhanVien]) VALUES (N'HDBH015', CAST(N'2021-12-21 00:00:00.000' AS DateTime), N'KH006', NULL)
INSERT [dbo].[HoaDonBanHang] ([MaHoaDon], [NgayLap], [MaKhachHang], [MaNhanVien]) VALUES (N'HDBH016', CAST(N'2021-12-21 00:00:00.000' AS DateTime), N'KH006', NULL)
INSERT [dbo].[HoaDonBanHang] ([MaHoaDon], [NgayLap], [MaKhachHang], [MaNhanVien]) VALUES (N'HDBH017', CAST(N'2021-12-21 00:00:00.000' AS DateTime), N'KH006', NULL)
INSERT [dbo].[HoaDonBanHang] ([MaHoaDon], [NgayLap], [MaKhachHang], [MaNhanVien]) VALUES (N'HDBH018', CAST(N'2021-12-21 00:00:00.000' AS DateTime), N'KH006', NULL)
INSERT [dbo].[HoaDonNhapHang] ([MaHoaDon], [NgayLap], [MaNhaCungCap], [MaNhanVien]) VALUES (N'HDNH019', CAST(N'2021-12-21 00:00:00.000' AS DateTime), N'NCC007', NULL)
INSERT [dbo].[HoaDonNhapHang] ([MaHoaDon], [NgayLap], [MaNhaCungCap], [MaNhanVien]) VALUES (N'HDNH020', CAST(N'2021-12-21 00:00:00.000' AS DateTime), N'NCC008', NULL)
INSERT [dbo].[KhachHang] ([MaKhachHang], [TenKhachHang], [NgaySinh], [GioiTinh], [SoDienThoai], [DiaChi]) VALUES (N'KH001', N'Nguyễn Thị B', CAST(N'1998-09-04 00:00:00.000' AS DateTime), N'Nu', N'098342344', N'ABC')
INSERT [dbo].[KhachHang] ([MaKhachHang], [TenKhachHang], [NgaySinh], [GioiTinh], [SoDienThoai], [DiaChi]) VALUES (N'KH002', N'Nguyen Thi A', CAST(N'1999-10-08 00:00:00.000' AS DateTime), N'Nu', N'0979318761', N'ABCXYZ')
INSERT [dbo].[KhachHang] ([MaKhachHang], [TenKhachHang], [NgaySinh], [GioiTinh], [SoDienThoai], [DiaChi]) VALUES (N'KH003', N'Nguyễn Thị Kiên', CAST(N'2001-09-18 00:00:00.000' AS DateTime), N'Nu', N'091234567', N'ghjk')
INSERT [dbo].[KhachHang] ([MaKhachHang], [TenKhachHang], [NgaySinh], [GioiTinh], [SoDienThoai], [DiaChi]) VALUES (N'KH004', N'Nguyễn Thị C', CAST(N'2001-09-08 00:00:00.000' AS DateTime), N'Nu', N'056312345', N'CBXZ')
INSERT [dbo].[KhachHang] ([MaKhachHang], [TenKhachHang], [NgaySinh], [GioiTinh], [SoDienThoai], [DiaChi]) VALUES (N'KH005', N'Nguyễn Thị G', CAST(N'1997-07-10 00:00:00.000' AS DateTime), N'Nu', N'098765432', N'HGZK')
INSERT [dbo].[KhachHang] ([MaKhachHang], [TenKhachHang], [NgaySinh], [GioiTinh], [SoDienThoai], [DiaChi]) VALUES (N'KH006', N'Nguyễn Thị Lâm', CAST(N'1998-10-12 00:00:00.000' AS DateTime), N'Nu', N'0987654321', N'GHUJI')
INSERT [dbo].[NhaCungCap] ([MaNhaCungCap], [TenNhaCungCap], [Email], [SoDienThoai], [DiaChi]) VALUES (N'NCC001', N'Cong ty A', N'abc@gmail.com', N'0979318761', N'ABCV')
INSERT [dbo].[NhaCungCap] ([MaNhaCungCap], [TenNhaCungCap], [Email], [SoDienThoai], [DiaChi]) VALUES (N'NCC003', N'Cong ty abc', N'cvm@gmail.com', N'0979318761', N'ucdgh')
INSERT [dbo].[NhaCungCap] ([MaNhaCungCap], [TenNhaCungCap], [Email], [SoDienThoai], [DiaChi]) VALUES (N'NCC004', N'Cong ty xyz', N'xyz@gmail.com', N'0979318761', N'bcd')
INSERT [dbo].[NhaCungCap] ([MaNhaCungCap], [TenNhaCungCap], [Email], [SoDienThoai], [DiaChi]) VALUES (N'NCC005', N'Cong ty kjh', N'kjh@gmail.com', N'0979318761', N'abcxyz')
INSERT [dbo].[NhaCungCap] ([MaNhaCungCap], [TenNhaCungCap], [Email], [SoDienThoai], [DiaChi]) VALUES (N'NCC006', N'Cong ty KL', N'ncc@gmail.com', N'0357867759', N'jklh')
INSERT [dbo].[NhaCungCap] ([MaNhaCungCap], [TenNhaCungCap], [Email], [SoDienThoai], [DiaChi]) VALUES (N'NCC007', N'Công ty abcv', N'abcv@gmail.com', N'0987654567', N'ABCXYZ')
INSERT [dbo].[NhaCungCap] ([MaNhaCungCap], [TenNhaCungCap], [Email], [SoDienThoai], [DiaChi]) VALUES (N'NCC008', N'Cong ty abvc', N'abvc@gmail.com', N'098765432', N'abnch')
INSERT [dbo].[NhaCungCap] ([MaNhaCungCap], [TenNhaCungCap], [Email], [SoDienThoai], [DiaChi]) VALUES (N'NCC009', N'Cong ty bcv', N'bcv@gmail.com', N'098765432', N'acbdh')
INSERT [dbo].[NhaCungCap] ([MaNhaCungCap], [TenNhaCungCap], [Email], [SoDienThoai], [DiaChi]) VALUES (N'NCC010', N'Công ty avbn', N'avbn@gmail.com', N'098765432', N'ABCVN')
INSERT [dbo].[NhanVien] ([MaNhanVien], [TenNhanVien], [GioiTinh], [NgaySinh], [NgayVaoLam], [SCMND], [DiaChi], [SoDienThoai], [TinhTrang]) VALUES (N'NVBH001', N'Nguyễn Thị Tâm', N'Nu', CAST(N'1987-03-02 00:00:00.000' AS DateTime), CAST(N'2020-12-11 00:00:00.000' AS DateTime), N'12344555', N'abcxyz', N'09842222', N'1')
INSERT [dbo].[NhanVien] ([MaNhanVien], [TenNhanVien], [GioiTinh], [NgaySinh], [NgayVaoLam], [SCMND], [DiaChi], [SoDienThoai], [TinhTrang]) VALUES (N'NVBH002', N'Nguyễn Thị An', N'Nu', CAST(N'2001-08-09 00:00:00.000' AS DateTime), CAST(N'2019-10-28 00:00:00.000' AS DateTime), N'123456789', N'abcxyz', N'0987654321', N'1')
INSERT [dbo].[NhanVien] ([MaNhanVien], [TenNhanVien], [GioiTinh], [NgaySinh], [NgayVaoLam], [SCMND], [DiaChi], [SoDienThoai], [TinhTrang]) VALUES (N'NVBH003', N'Nguyễn Thị Thùy Trang', N'Nu', CAST(N'2001-09-10 00:00:00.000' AS DateTime), CAST(N'2019-10-20 00:00:00.000' AS DateTime), N'12312434', N'xyzbcv', N'09453454', N'1')
INSERT [dbo].[NhanVien] ([MaNhanVien], [TenNhanVien], [GioiTinh], [NgaySinh], [NgayVaoLam], [SCMND], [DiaChi], [SoDienThoai], [TinhTrang]) VALUES (N'NVQLTam', N'Nguyễn Thị Tâm', N'Nu', CAST(N'1998-02-04 00:00:00.000' AS DateTime), CAST(N'2019-11-10 00:00:00.000' AS DateTime), N'12345678', N'abcxyz', N'037638901', N'1')
INSERT [dbo].[SanPham] ([MaSanPham], [TenSanPham], [Hang], [Loai], [SoLuongTon], [LoHang], [Size], [GiaBan], [GiaNhap], [Mau], [NgayNhap], [MaNhaCungCap], [TenNhaCungCap]) VALUES (N'SP002', N'Quan Bo', N'abc', N'Quần', 9, N'LH002', N'L', 150000.0000, 130000.0000, N'Xam', CAST(N'2021-12-10 00:00:00.000' AS DateTime), N'NCC001', N'Cong ty A')
INSERT [dbo].[SanPham] ([MaSanPham], [TenSanPham], [Hang], [Loai], [SoLuongTon], [LoHang], [Size], [GiaBan], [GiaNhap], [Mau], [NgayNhap], [MaNhaCungCap], [TenNhaCungCap]) VALUES (N'SP003', N'That Lung', N'ads', N'Phụ kiện', 14, N'LH003', N'X', 130000.0000, 100000.0000, N'Den', CAST(N'2021-12-10 00:00:00.000' AS DateTime), N'NCC003', N'Cong ty abc')
INSERT [dbo].[SanPham] ([MaSanPham], [TenSanPham], [Hang], [Loai], [SoLuongTon], [LoHang], [Size], [GiaBan], [GiaNhap], [Mau], [NgayNhap], [MaNhaCungCap], [TenNhaCungCap]) VALUES (N'SP004', N'Ao khoac', N'adidas', N'Áo', 12, N'LH005', N'XL', 250000.0000, 200000.0000, N'Hong', CAST(N'2021-12-10 00:00:00.000' AS DateTime), N'NCC003', N'Cong ty abc')
INSERT [dbo].[SanPham] ([MaSanPham], [TenSanPham], [Hang], [Loai], [SoLuongTon], [LoHang], [Size], [GiaBan], [GiaNhap], [Mau], [NgayNhap], [MaNhaCungCap], [TenNhaCungCap]) VALUES (N'SP005', N'Áo Thun', N'Nike', N'Áo', 30, N'LH008', N'L', 200000.0000, 150000.0000, N'Trang', CAST(N'2021-12-11 00:00:00.000' AS DateTime), N'NCC004', N'Cong ty xyz')
INSERT [dbo].[SanPham] ([MaSanPham], [TenSanPham], [Hang], [Loai], [SoLuongTon], [LoHang], [Size], [GiaBan], [GiaNhap], [Mau], [NgayNhap], [MaNhaCungCap], [TenNhaCungCap]) VALUES (N'SP006', N'Quần đùi', N'adidas', N'Quần', 21, N'LH009', N'M', 100000.0000, 80000.0000, N'Xanh', CAST(N'2021-12-16 00:00:00.000' AS DateTime), N'NCC005', N'Cong ty kjh')
INSERT [dbo].[SanPham] ([MaSanPham], [TenSanPham], [Hang], [Loai], [SoLuongTon], [LoHang], [Size], [GiaBan], [GiaNhap], [Mau], [NgayNhap], [MaNhaCungCap], [TenNhaCungCap]) VALUES (N'SP007', N'Quan Bo', N'abc', N'Quần', 30, N'LH945', N'L', 150000.0000, 130000.0000, N'Xam', CAST(N'2021-12-16 00:00:00.000' AS DateTime), N'NCC006', N'Cong ty bcs')
INSERT [dbo].[SanPham] ([MaSanPham], [TenSanPham], [Hang], [Loai], [SoLuongTon], [LoHang], [Size], [GiaBan], [GiaNhap], [Mau], [NgayNhap], [MaNhaCungCap], [TenNhaCungCap]) VALUES (N'SP008', N'Áo Khoác', N'adias', N'Áo', 28, N'LH897', N'M', 220000.0000, 180000.0000, N'Xanh', CAST(N'2021-12-17 00:00:00.000' AS DateTime), N'NCC007', N'ABGH')
INSERT [dbo].[SanPham] ([MaSanPham], [TenSanPham], [Hang], [Loai], [SoLuongTon], [LoHang], [Size], [GiaBan], [GiaNhap], [Mau], [NgayNhap], [MaNhaCungCap], [TenNhaCungCap]) VALUES (N'SP009', N'Quan Thun', N'nuke', N'Quần', 23, N'LH045', N'L', 100000.0000, 80000.0000, N'Xam', CAST(N'2021-12-17 00:00:00.000' AS DateTime), N'NCC008', N'OCWG')
INSERT [dbo].[SanPham] ([MaSanPham], [TenSanPham], [Hang], [Loai], [SoLuongTon], [LoHang], [Size], [GiaBan], [GiaNhap], [Mau], [NgayNhap], [MaNhaCungCap], [TenNhaCungCap]) VALUES (N'SP010', N'Áo Thun', N'Nike', N'Áo', 34, N'hjk', N'L', 200000.0000, 150000.0000, N'Trang', CAST(N'2021-12-21 00:00:00.000' AS DateTime), N'NCC008', N'Cong ty abvc')
INSERT [dbo].[SanPham] ([MaSanPham], [TenSanPham], [Hang], [Loai], [SoLuongTon], [LoHang], [Size], [GiaBan], [GiaNhap], [Mau], [NgayNhap], [MaNhaCungCap], [TenNhaCungCap]) VALUES (N'SP011', N'dep le', N'abv', N'Phụ kiện', 33, N'khlp', N'21', 6000.0000, 3000.0000, N'vang', CAST(N'2021-12-21 00:00:00.000' AS DateTime), N'NCC009', N'Cong ty bcv')
INSERT [dbo].[SanPham] ([MaSanPham], [TenSanPham], [Hang], [Loai], [SoLuongTon], [LoHang], [Size], [GiaBan], [GiaNhap], [Mau], [NgayNhap], [MaNhaCungCap], [TenNhaCungCap]) VALUES (N'SP012', N'Áo Thun', N'Nike', N'Áo', 34, N'LHKIO', N'L', 200000.0000, 150000.0000, N'Vàng', CAST(N'2021-12-21 00:00:00.000' AS DateTime), N'NCC010', N'Công ty avbn')
INSERT [dbo].[SanPham] ([MaSanPham], [TenSanPham], [Hang], [Loai], [SoLuongTon], [LoHang], [Size], [GiaBan], [GiaNhap], [Mau], [NgayNhap], [MaNhaCungCap], [TenNhaCungCap]) VALUES (N'SP013', N'Áo Thun', N'Nike', N'Áo', 38, N'LHKKIO2', N'XL', 200000.0000, 150000.0000, N'Vàng', CAST(N'2021-12-21 00:00:00.000' AS DateTime), N'NCC010', N'Công ty avbn')
INSERT [dbo].[TaiKhoan] ([MaNhanVien], [ID], [Pass]) VALUES (N'NVBH001', N'NVBH001', N'NVBH001')
INSERT [dbo].[TaiKhoan] ([MaNhanVien], [ID], [Pass]) VALUES (N'NVBH002', N'NVBH002', N'NVBH002')
INSERT [dbo].[TaiKhoan] ([MaNhanVien], [ID], [Pass]) VALUES (N'NVBH003', N'NVBH003', N'NVBH003')
INSERT [dbo].[TaiKhoan] ([MaNhanVien], [ID], [Pass]) VALUES (N'NVQLTam', N'NVQLTam', N'NVQLTam')
ALTER TABLE [dbo].[ChiTietHoaDonBH]  WITH CHECK ADD  CONSTRAINT [FK_ChiTietHoaDonBH_HoaDonBanHang] FOREIGN KEY([MaHoaDon])
REFERENCES [dbo].[HoaDonBanHang] ([MaHoaDon])
GO
ALTER TABLE [dbo].[ChiTietHoaDonBH] CHECK CONSTRAINT [FK_ChiTietHoaDonBH_HoaDonBanHang]
GO
ALTER TABLE [dbo].[ChiTietHoaDonBH]  WITH CHECK ADD  CONSTRAINT [FK_ChiTietHoaDonBH_SanPham] FOREIGN KEY([MaSanPham])
REFERENCES [dbo].[SanPham] ([MaSanPham])
GO
ALTER TABLE [dbo].[ChiTietHoaDonBH] CHECK CONSTRAINT [FK_ChiTietHoaDonBH_SanPham]
GO
ALTER TABLE [dbo].[ChiTieTHoaDonNH]  WITH CHECK ADD  CONSTRAINT [FK_ChiTieTHoaDonNH_HoaDonNhapHang] FOREIGN KEY([MaHoaDon])
REFERENCES [dbo].[HoaDonNhapHang] ([MaHoaDon])
GO
ALTER TABLE [dbo].[ChiTieTHoaDonNH] CHECK CONSTRAINT [FK_ChiTieTHoaDonNH_HoaDonNhapHang]
GO
ALTER TABLE [dbo].[ChiTieTHoaDonNH]  WITH CHECK ADD  CONSTRAINT [FK_ChiTieTHoaDonNH_SanPham] FOREIGN KEY([MaSanPham])
REFERENCES [dbo].[SanPham] ([MaSanPham])
GO
ALTER TABLE [dbo].[ChiTieTHoaDonNH] CHECK CONSTRAINT [FK_ChiTieTHoaDonNH_SanPham]
GO
ALTER TABLE [dbo].[HoaDonBanHang]  WITH CHECK ADD  CONSTRAINT [FK_HoaDonBanHang_KhachHang] FOREIGN KEY([MaKhachHang])
REFERENCES [dbo].[KhachHang] ([MaKhachHang])
GO
ALTER TABLE [dbo].[HoaDonBanHang] CHECK CONSTRAINT [FK_HoaDonBanHang_KhachHang]
GO
ALTER TABLE [dbo].[HoaDonBanHang]  WITH CHECK ADD  CONSTRAINT [FK_HoaDonBanHang_NhanVien] FOREIGN KEY([MaNhanVien])
REFERENCES [dbo].[NhanVien] ([MaNhanVien])
GO
ALTER TABLE [dbo].[HoaDonBanHang] CHECK CONSTRAINT [FK_HoaDonBanHang_NhanVien]
GO
ALTER TABLE [dbo].[HoaDonNhapHang]  WITH CHECK ADD  CONSTRAINT [FK_HoaDonNhapHang_NhaCungCap] FOREIGN KEY([MaNhaCungCap])
REFERENCES [dbo].[NhaCungCap] ([MaNhaCungCap])
GO
ALTER TABLE [dbo].[HoaDonNhapHang] CHECK CONSTRAINT [FK_HoaDonNhapHang_NhaCungCap]
GO
ALTER TABLE [dbo].[HoaDonNhapHang]  WITH CHECK ADD  CONSTRAINT [FK_HoaDonNhapHang_NhanVien] FOREIGN KEY([MaNhanVien])
REFERENCES [dbo].[NhanVien] ([MaNhanVien])
GO
ALTER TABLE [dbo].[HoaDonNhapHang] CHECK CONSTRAINT [FK_HoaDonNhapHang_NhanVien]
GO
ALTER TABLE [dbo].[NhanVien]  WITH CHECK ADD  CONSTRAINT [FK_NhanVien_TaiKhoan] FOREIGN KEY([MaNhanVien])
REFERENCES [dbo].[TaiKhoan] ([MaNhanVien])
GO
ALTER TABLE [dbo].[NhanVien] CHECK CONSTRAINT [FK_NhanVien_TaiKhoan]
GO
ALTER TABLE [dbo].[PhanCongCaLam]  WITH CHECK ADD  CONSTRAINT [FK_PhanCongCaLam_CaLam] FOREIGN KEY([MaCaLam])
REFERENCES [dbo].[CaLam] ([MaCaLam])
GO
ALTER TABLE [dbo].[PhanCongCaLam] CHECK CONSTRAINT [FK_PhanCongCaLam_CaLam]
GO
ALTER TABLE [dbo].[PhanCongCaLam]  WITH CHECK ADD  CONSTRAINT [FK_PhanCongCaLam_NhanVien] FOREIGN KEY([MaNhanVien])
REFERENCES [dbo].[NhanVien] ([MaNhanVien])
GO
ALTER TABLE [dbo].[PhanCongCaLam] CHECK CONSTRAINT [FK_PhanCongCaLam_NhanVien]
GO
USE [master]
GO
ALTER DATABASE [CuaHangQA] SET  READ_WRITE 
GO
