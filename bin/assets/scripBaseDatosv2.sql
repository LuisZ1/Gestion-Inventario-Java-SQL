USE [master]
GO
CREATE DATABASE GestionInventario
/*
/****** Object:  Database [GestionInventario]    Script Date: 24/10/2017 12:33:47 ******/
CREATE DATABASE [GestionInventario]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'GestionInventario', FILENAME = N'C:\SQL\MSSQL12.MSSQLSERVER\MSSQL\DATA\GestionInventario.mdf' , SIZE = 4288KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'GestionInventario_log', FILENAME = N'C:\SQL\MSSQL12.MSSQLSERVER\MSSQL\DATA\GestionInventario_log.ldf' , SIZE = 1072KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [GestionInventario] SET COMPATIBILITY_LEVEL = 120
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [GestionInventario].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [GestionInventario] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [GestionInventario] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [GestionInventario] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [GestionInventario] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [GestionInventario] SET ARITHABORT OFF 
GO
ALTER DATABASE [GestionInventario] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [GestionInventario] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [GestionInventario] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [GestionInventario] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [GestionInventario] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [GestionInventario] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [GestionInventario] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [GestionInventario] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [GestionInventario] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [GestionInventario] SET  ENABLE_BROKER 
GO
ALTER DATABASE [GestionInventario] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [GestionInventario] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [GestionInventario] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [GestionInventario] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [GestionInventario] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [GestionInventario] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [GestionInventario] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [GestionInventario] SET RECOVERY FULL 
GO
ALTER DATABASE [GestionInventario] SET  MULTI_USER 
GO
ALTER DATABASE [GestionInventario] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [GestionInventario] SET DB_CHAINING OFF 
GO
ALTER DATABASE [GestionInventario] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [GestionInventario] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
ALTER DATABASE [GestionInventario] SET DELAYED_DURABILITY = DISABLED 
GO
EXEC sys.sp_db_vardecimal_storage_format N'GestionInventario', N'ON'
GO*/
USE [GestionInventario]
GO
/****** Object:  User [pepito]    Script Date: 24/10/2017 12:33:48 ******/
CREATE USER [pepito] FOR LOGIN [pepito] WITH DEFAULT_SCHEMA=[dbo]
GO
/****** Object:  Table [dbo].[Electricidad]    Script Date: 24/10/2017 12:33:48 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Electricidad](
	[ID] [tinyint] IDENTITY(1,1) NOT NULL,
	[color] [varchar](50) NULL,
	[dimensiones] [varchar](50) NULL,
	[ID_Material] [tinyint] NULL,
 CONSTRAINT [PK_Electricidad] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Ferreteria]    Script Date: 24/10/2017 12:33:48 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Ferreteria](
	[ID] [tinyint] IDENTITY(1,1) NOT NULL,
	[tipo] [varchar](50) NULL,
	[dimensiones] [varchar](50) NULL,
	[ID_Material] [tinyint] NULL,
 CONSTRAINT [PK_Ferreteria] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Herramientas]    Script Date: 24/10/2017 12:33:48 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Herramientas](
	[ID] [tinyint] IDENTITY(1,1) NOT NULL,
	[tipo] [varchar](50) NULL,
	[tamañoCm] [int] NULL,
	[ID_Material] [tinyint] NULL,
 CONSTRAINT [PK_Herramientas] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Lugares]    Script Date: 24/10/2017 12:33:48 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Lugares](
	[ID] [tinyint] IDENTITY(1,1) NOT NULL,
	[nombre] [varchar](50) NULL,
 CONSTRAINT [PK_Lugares] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Materiales]    Script Date: 24/10/2017 12:33:48 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Materiales](
	[ID] [tinyint] IDENTITY(1,1) NOT NULL,
	[nombre] [varchar](50) NULL,
	[ID_Lugar] [tinyint] NULL,
 CONSTRAINT [PK_Materiales] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
SET IDENTITY_INSERT [dbo].[Electricidad] ON 

INSERT [dbo].[Electricidad] ([ID], [color], [dimensiones], [ID_Material]) VALUES (1, N'Azul', N'25 m', 13)
INSERT [dbo].[Electricidad] ([ID], [color], [dimensiones], [ID_Material]) VALUES (2, N'Amarillo', N'20 cm', 14)
INSERT [dbo].[Electricidad] ([ID], [color], [dimensiones], [ID_Material]) VALUES (3, N'Blanco', N'5 m', 15)
INSERT [dbo].[Electricidad] ([ID], [color], [dimensiones], [ID_Material]) VALUES (4, N'con interrruptor', NULL, 16)
SET IDENTITY_INSERT [dbo].[Electricidad] OFF
SET IDENTITY_INSERT [dbo].[Ferreteria] ON 

INSERT [dbo].[Ferreteria] ([ID], [tipo], [dimensiones], [ID_Material]) VALUES (1, N'Normal', N'120mm', 7)
INSERT [dbo].[Ferreteria] ([ID], [tipo], [dimensiones], [ID_Material]) VALUES (2, N'Rosca Madera', N'30x15', 8)
INSERT [dbo].[Ferreteria] ([ID], [tipo], [dimensiones], [ID_Material]) VALUES (3, N'Rosca Madera', N'35x15', 9)
INSERT [dbo].[Ferreteria] ([ID], [tipo], [dimensiones], [ID_Material]) VALUES (4, N'Grapadora automática', N'12 mm', 10)
INSERT [dbo].[Ferreteria] ([ID], [tipo], [dimensiones], [ID_Material]) VALUES (5, N'pequeñas', N'60 mm', 11)
INSERT [dbo].[Ferreteria] ([ID], [tipo], [dimensiones], [ID_Material]) VALUES (6, N'acero', N'14 mm', 12)
SET IDENTITY_INSERT [dbo].[Ferreteria] OFF
SET IDENTITY_INSERT [dbo].[Herramientas] ON 

INSERT [dbo].[Herramientas] ([ID], [tipo], [tamañoCm], [ID_Material]) VALUES (1, N'Corte lateral', 20, 1)
INSERT [dbo].[Herramientas] ([ID], [tipo], [tamañoCm], [ID_Material]) VALUES (2, N'Normal', 22, 2)
INSERT [dbo].[Herramientas] ([ID], [tipo], [tamañoCm], [ID_Material]) VALUES (3, N'Philips', 32, 3)
INSERT [dbo].[Herramientas] ([ID], [tipo], [tamañoCm], [ID_Material]) VALUES (4, N'Pala', 12, 4)
INSERT [dbo].[Herramientas] ([ID], [tipo], [tamañoCm], [ID_Material]) VALUES (5, N'Nailon', 20, 5)
INSERT [dbo].[Herramientas] ([ID], [tipo], [tamañoCm], [ID_Material]) VALUES (6, N'Grano fino', 8, 6)
SET IDENTITY_INSERT [dbo].[Herramientas] OFF
SET IDENTITY_INSERT [dbo].[Lugares] ON 

INSERT [dbo].[Lugares] ([ID], [nombre]) VALUES (1, N'Trastero')
INSERT [dbo].[Lugares] ([ID], [nombre]) VALUES (2, N'Armario grande')
INSERT [dbo].[Lugares] ([ID], [nombre]) VALUES (3, N'Altillo')
INSERT [dbo].[Lugares] ([ID], [nombre]) VALUES (4, N'Estantería metálica')
INSERT [dbo].[Lugares] ([ID], [nombre]) VALUES (5, N'Cómoda')
SET IDENTITY_INSERT [dbo].[Lugares] OFF
SET IDENTITY_INSERT [dbo].[Materiales] ON 

INSERT [dbo].[Materiales] ([ID], [nombre], [ID_Lugar]) VALUES (1, N'Alicates', 4)
INSERT [dbo].[Materiales] ([ID], [nombre], [ID_Lugar]) VALUES (2, N'Tenazas', 4)
INSERT [dbo].[Materiales] ([ID], [nombre], [ID_Lugar]) VALUES (3, N'Destornillador', 4)
INSERT [dbo].[Materiales] ([ID], [nombre], [ID_Lugar]) VALUES (4, N'Destornillador', 4)
INSERT [dbo].[Materiales] ([ID], [nombre], [ID_Lugar]) VALUES (5, N'Martillo', 4)
INSERT [dbo].[Materiales] ([ID], [nombre], [ID_Lugar]) VALUES (6, N'Lija', 4)
INSERT [dbo].[Materiales] ([ID], [nombre], [ID_Lugar]) VALUES (7, N'Clavos', 5)
INSERT [dbo].[Materiales] ([ID], [nombre], [ID_Lugar]) VALUES (8, N'Tornillo', 5)
INSERT [dbo].[Materiales] ([ID], [nombre], [ID_Lugar]) VALUES (9, N'Tornillo', 5)
INSERT [dbo].[Materiales] ([ID], [nombre], [ID_Lugar]) VALUES (10, N'Grapas', 5)
INSERT [dbo].[Materiales] ([ID], [nombre], [ID_Lugar]) VALUES (11, N'Cuñas', 2)
INSERT [dbo].[Materiales] ([ID], [nombre], [ID_Lugar]) VALUES (12, N'Tuerca', 2)
INSERT [dbo].[Materiales] ([ID], [nombre], [ID_Lugar]) VALUES (13, N'Alargadera Rosco', 1)
INSERT [dbo].[Materiales] ([ID], [nombre], [ID_Lugar]) VALUES (14, N'Multímetro', 3)
INSERT [dbo].[Materiales] ([ID], [nombre], [ID_Lugar]) VALUES (15, N'Ladrón', 1)
INSERT [dbo].[Materiales] ([ID], [nombre], [ID_Lugar]) VALUES (16, N'Ladrón', 3)
SET IDENTITY_INSERT [dbo].[Materiales] OFF
ALTER TABLE [dbo].[Electricidad]  WITH CHECK ADD  CONSTRAINT [FK_Electricidad_Materiales] FOREIGN KEY([ID_Material])
REFERENCES [dbo].[Materiales] ([ID])  ON DELETE CASCADE ON UPDATE CASCADE
GO
ALTER TABLE [dbo].[Electricidad] CHECK CONSTRAINT [FK_Electricidad_Materiales]
GO
ALTER TABLE [dbo].[Ferreteria]  WITH CHECK ADD  CONSTRAINT [FK_Ferreteria_Materiales] FOREIGN KEY([ID_Material])
REFERENCES [dbo].[Materiales] ([ID]) ON DELETE CASCADE ON UPDATE CASCADE
GO
ALTER TABLE [dbo].[Ferreteria] CHECK CONSTRAINT [FK_Ferreteria_Materiales]
GO
ALTER TABLE [dbo].[Herramientas]  WITH CHECK ADD  CONSTRAINT [FK_Herramientas_Materiales] FOREIGN KEY([ID_Material])
REFERENCES [dbo].[Materiales] ([ID]) ON DELETE CASCADE ON UPDATE CASCADE
GO
ALTER TABLE [dbo].[Herramientas] CHECK CONSTRAINT [FK_Herramientas_Materiales]
GO
ALTER TABLE [dbo].[Materiales]  WITH CHECK ADD  CONSTRAINT [FK_Materiales_Lugares] FOREIGN KEY([ID_Lugar])
REFERENCES [dbo].[Lugares] ([ID]) ON DELETE CASCADE ON UPDATE CASCADE
GO
ALTER TABLE [dbo].[Materiales] CHECK CONSTRAINT [FK_Materiales_Lugares]
GO
ALTER TABLE [dbo].[Herramientas]  WITH CHECK ADD  CONSTRAINT [CK_dimensionesFerreteriaPositivas] CHECK  (([tamañoCm]>(0)))
GO
ALTER TABLE [dbo].[Herramientas] CHECK CONSTRAINT [CK_dimensionesFerreteriaPositivas]
GO
USE [master]
GO
ALTER DATABASE [GestionInventario] SET  READ_WRITE 
GO
