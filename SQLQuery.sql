USE [QLKHO]
GO

/****** Object:  Table [dbo].[NhaCungCap]    Script Date: 18/04/2022 10:54:18 CH ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[NhaCungCap](
	[MaNCC] [int] IDENTITY(1,1) NOT NULL,
	[TenNhaCC] [nvarchar](50) NULL,
	[SDT] [nchar](12) NULL,
	[DiaChi] [nvarchar](50) NULL,
	[Email] [nvarchar](50) NULL,
 CONSTRAINT [PK_NhaCungCap] PRIMARY KEY CLUSTERED 
(
	[MaNCC] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO

USE [QLKHO]
GO

/****** Object:  Table [dbo].[HangHoa]    Script Date: 18/04/2022 10:54:24 CH ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[HangHoa](
	[MaHang] [int] IDENTITY(1,1) NOT NULL,
	[TenHang] [nvarchar](50) NULL,
	[LoaiHang] [nvarchar](50) NULL,
	[MaNCC] [int] NULL,
	[SoLuong] [int] NULL,
	[Gia] [int] NULL,
 CONSTRAINT [PK_HangHoa] PRIMARY KEY CLUSTERED 
(
	[MaHang] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO

ALTER TABLE [dbo].[HangHoa]  WITH CHECK ADD  CONSTRAINT [FK_HangHoa_NhaCungCap] FOREIGN KEY([MaNCC])
REFERENCES [dbo].[NhaCungCap] ([MaNCC])
GO

ALTER TABLE [dbo].[HangHoa] CHECK CONSTRAINT [FK_HangHoa_NhaCungCap]
GO

USE [QLKHO]
GO

/****** Object:  Table [dbo].[KhachHang]    Script Date: 18/04/2022 10:54:33 CH ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[KhachHang](
	[MaKH] [int] IDENTITY(1,1) NOT NULL,
	[TenKH] [nvarchar](50) NULL,
	[SDT] [nchar](12) NULL,
	[DiaChi] [nvarchar](50) NULL,
	[Email] [nvarchar](50) NULL,
 CONSTRAINT [PK_KhachHang] PRIMARY KEY CLUSTERED 
(
	[MaKH] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO

USE [QLKHO]
GO

/****** Object:  Table [dbo].[NhapKho]    Script Date: 18/04/2022 10:54:42 CH ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[NhapKho](
	[MaNK] [int] IDENTITY(1,1) NOT NULL,
	[NgayNhap] [date] NULL,
	[TongTien] [int] NULL,
 CONSTRAINT [PK_NhapKho] PRIMARY KEY CLUSTERED 
(
	[MaNK] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO

USE [QLKHO]
GO

/****** Object:  Table [dbo].[NhapKhoCT]    Script Date: 18/04/2022 10:54:49 CH ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[NhapKhoCT](
	[MaNKCT] [int] IDENTITY(1,1) NOT NULL,
	[MaNK] [int] NULL,
	[MaHang] [int] NULL,
	[SoLuong] [int] NULL,
	[Tien] [int] NULL,
 CONSTRAINT [PK_NhapKhoCT] PRIMARY KEY CLUSTERED 
(
	[MaNKCT] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO

ALTER TABLE [dbo].[NhapKhoCT]  WITH CHECK ADD  CONSTRAINT [FK_NhapKhoCT_HangHoa] FOREIGN KEY([MaHang])
REFERENCES [dbo].[HangHoa] ([MaHang])
GO

ALTER TABLE [dbo].[NhapKhoCT] CHECK CONSTRAINT [FK_NhapKhoCT_HangHoa]
GO

ALTER TABLE [dbo].[NhapKhoCT]  WITH CHECK ADD  CONSTRAINT [FK_NhapKhoCT_NhapKho] FOREIGN KEY([MaNK])
REFERENCES [dbo].[NhapKho] ([MaNK])
GO

ALTER TABLE [dbo].[NhapKhoCT] CHECK CONSTRAINT [FK_NhapKhoCT_NhapKho]
GO

USE [QLKHO]
GO

/****** Object:  Table [dbo].[XuatKho]    Script Date: 18/04/2022 10:54:56 CH ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[XuatKho](
	[MaXK] [int] IDENTITY(1,1) NOT NULL,
	[NgayXuat] [date] NULL,
	[TongTien] [int] NULL,
	[MaKH] [int] NULL,
 CONSTRAINT [PK_XuatKho] PRIMARY KEY CLUSTERED 
(
	[MaXK] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO

ALTER TABLE [dbo].[XuatKho]  WITH CHECK ADD  CONSTRAINT [FK_XuatKho_KhachHang] FOREIGN KEY([MaKH])
REFERENCES [dbo].[KhachHang] ([MaKH])
GO

ALTER TABLE [dbo].[XuatKho] CHECK CONSTRAINT [FK_XuatKho_KhachHang]
GO

USE [QLKHO]
GO

/****** Object:  Table [dbo].[XuatKhoCT]    Script Date: 18/04/2022 10:55:01 CH ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[XuatKhoCT](
	[MaXKCT] [int] IDENTITY(1,1) NOT NULL,
	[MaXK] [int] NULL,
	[MaHang] [int] NULL,
	[SoLuong] [int] NULL,
	[Tien] [int] NULL,
 CONSTRAINT [PK_XuatKhoCT] PRIMARY KEY CLUSTERED 
(
	[MaXKCT] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO

ALTER TABLE [dbo].[XuatKhoCT]  WITH CHECK ADD  CONSTRAINT [FK_XuatKhoCT_HangHoa] FOREIGN KEY([MaHang])
REFERENCES [dbo].[HangHoa] ([MaHang])
GO

ALTER TABLE [dbo].[XuatKhoCT] CHECK CONSTRAINT [FK_XuatKhoCT_HangHoa]
GO

ALTER TABLE [dbo].[XuatKhoCT]  WITH CHECK ADD  CONSTRAINT [FK_XuatKhoCT_XuatKho] FOREIGN KEY([MaXK])
REFERENCES [dbo].[XuatKho] ([MaXK])
GO

ALTER TABLE [dbo].[XuatKhoCT] CHECK CONSTRAINT [FK_XuatKhoCT_XuatKho]
GO


use QLKHO

insert into NhaCungCap(TenNhaCC, SDT, DiaChi, Email)
values
(N'Công Ty Bia', '0807300293', N'40 An Dương Vương', 'Bia@gmail.com'),
(N'Công Ty Bánh', '0770213323', N'56 An Dương Vương', 'Banh@gmail.com'),
(N'Công Ty Nước Ngọt', '09330293523', N'41 An Dương Vương', 'Nuoc@gmail.com')

insert into HangHoa(TenHang, LoaiHang, MaNCC, Gia, SoLuong)
values
(N'Bia Tiger', N'Bia', '1', '15000', '0'),
(N'Bánh khoai tây', N'Bánh', '2', '7000', '0'),
('Siting', N'Nước Ngọt', '3', '10000', '0')

insert into KhachHang(TenKH, SDT, DiaChi, Email)
values
(N'Nguyễn Văn A', '0238590234', N'23 Bạch Đằng', 'A@gmail.com'),
(N'Bạch Thái B', '0982239746', N'677 Nguyễn Tri Phương', 'B@gmail.com'),
(N'Chạnh Nhu C', '0797229384', N'40 Nguyễn Văn Cừ', 'C@gmail.com')

