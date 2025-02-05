
CREATE DATABASE [virtualSpaces-1]

create table Role(
	RoleID int not null primary key,
	RoleCode varchar(50)
)
 
CREATE TABLE [dbo].[Fortune](
	[FortuneID] [int] IDENTITY(1,1) NOT NULL PRIMARY KEY,
	[FortuneContent] [nvarchar](max) NULL
)

CREATE TABLE [dbo].[users](
	[id] [nvarchar](255) NOT NULL PRIMARY KEY,
	[email] [nvarchar](255) NULL,
	[name] [nvarchar](255) NULL,
	[given_name] [nvarchar](255) NULL,
	[family_name] [nvarchar](255) NULL,
	[picture] [nvarchar](255) NULL,
	RoleID int not null,
    CONSTRAINT FK_Role_Users FOREIGN KEY (RoleID) REFERENCES Role(RoleID)
)

CREATE TABLE [dbo].[Video](
	[VideoID] [int] IDENTITY(1,1) NOT NULL PRIMARY KEY,
	[VideoType] [nvarchar](max) NULL,
	[VideoURL] [nvarchar](max) NULL
)

CREATE TABLE [dbo].[VideoType](
	[TypeID] [int] IDENTITY(1,1) NOT NULL PRIMARY KEY,
	[TypeName] [nvarchar](max) NULL,
	[TypeIMG] [nvarchar](max) NULL
)

CREATE TABLE Task (
    taskID INT PRIMARY KEY IDENTITY(1,1),
    taskName NVARCHAR(255),
    taskDescription NVARCHAR(MAX),
    [date] DATE,
    timeStart time,
    timeEnd time,
    userId NVARCHAR(255),
    CONSTRAINT FK_Users_Task FOREIGN KEY (userId) REFERENCES users(id)
);

CREATE TABLE Media (
    mediaId INT PRIMARY KEY IDENTITY(1,1),
    mediaUrl NVARCHAR(255),
    userId NVARCHAR(255),
    CONSTRAINT FK_Users_Media FOREIGN KEY (userId) REFERENCES Users(id)
);

CREATE TABLE [dbo].[Sound](
	[SoundID] INT PRIMARY KEY IDENTITY(1,1),
	[SoundName] [nvarchar](max) NULL,
	[SoundURL] [nvarchar](max) NULL
)

CREATE TABLE STATS(
	STATSID INT PRIMARY KEY IDENTITY(1,1),
	DAYS INT,
	HOURS float,
	DateLoginLastest date,
	userId NVARCHAR(255),
    CONSTRAINT FK_Users_STATS FOREIGN KEY (userId) REFERENCES Users(id)
)

INSERT INTO ROLE VALUES
(1, 'ADMIN'),
(2, 'USER');

INSERT INTO Sound VALUES
 ('Street', 'https://od.lk/s/NzRfMzMyMTk1OTdf/street.wav'),
 ('Sea', 'https://od.lk/s/NzRfMzMyOTAyNDBf/sea.wav'),
 ('Library', 'https://od.lk/s/NzRfMzMyOTAxOTdf/library.wav'),
 ('Heavy rain', 'https://od.lk/s/NzRfMzMyOTAyMzRf/heavy-rain.wav');


	
-- Inserting values into the Fortune table without specifying the FortuneID column
INSERT [dbo].[Fortune] ([FortuneContent]) VALUES (N'“One day, all your hard work will pay off.”')
INSERT [dbo].[Fortune] ([FortuneContent]) VALUES (N'“The earlier you start working on something, the earlier you will see results.”')
INSERT [dbo].[Fortune] ([FortuneContent]) VALUES (N'“Life is short. Live it. Fear is natural. Face it. Memory is powerful. Use it.”')
INSERT [dbo].[Fortune] ([FortuneContent]) VALUES (N'“Do what is right, not what is easy.”')
INSERT [dbo].[Fortune] ([FortuneContent]) VALUES (N'“We generate fears while we do nothing. We overcome these fears by taking action.”')
INSERT [dbo].[Fortune] ([FortuneContent]) VALUES (N'“If we wait until we’re ready, we’ll be waiting for the rest of our lives.”')
INSERT [dbo].[Fortune] ([FortuneContent]) VALUES (N'“It’s never too late to be what you might have been.”')
INSERT [dbo].[Fortune] ([FortuneContent]) VALUES (N'“You don’t have to be great to start. But you have to start to be great.”')
INSERT [dbo].[Fortune] ([FortuneContent]) VALUES (N'“Every morning you have two choices: continue to sleep with your dreams, or wake up and chase them.”')
INSERT [dbo].[Fortune] ([FortuneContent]) VALUES (N'“Nobody can go back and start a new beginning, but anyone can start today and make a new ending.”')

-- Inserting values into the Video table without specifying the VideoID column
INSERT [dbo].[Video] ([VideoType], [VideoURL]) VALUES (N'Nature', N'gnMajPQgkiA')
INSERT [dbo].[Video] ([VideoType], [VideoURL]) VALUES (N'Nature', N'5sRGvsbRW44')
INSERT [dbo].[Video] ([VideoType], [VideoURL]) VALUES (N'Nature', N'mPZkdNFkNps')
INSERT [dbo].[Video] ([VideoType], [VideoURL]) VALUES (N'Nature', N'SnUBb-FAlCY')
INSERT [dbo].[Video] ([VideoType], [VideoURL]) VALUES (N'Anime', N'cu959m5z07Q')
INSERT [dbo].[Video] ([VideoType], [VideoURL]) VALUES (N'Anime', N'oT_8yN5RVow')
INSERT [dbo].[Video] ([VideoType], [VideoURL]) VALUES (N'Anime', N'z2nkdhZD1Kc')
INSERT [dbo].[Video] ([VideoType], [VideoURL]) VALUES (N'Anime', N'CeItO4-ARfk')
INSERT [dbo].[Video] ([VideoType], [VideoURL]) VALUES (N'City', N'VmeDcSR6qwk')
INSERT [dbo].[Video] ([VideoType], [VideoURL]) VALUES (N'City', N'KXkkKm4AwBg')
INSERT [dbo].[Video] ([VideoType], [VideoURL]) VALUES (N'City', N'0x1VDO6mDAg')
INSERT [dbo].[Video] ([VideoType], [VideoURL]) VALUES (N'City', N'YTis5Rm5kE8')
INSERT [dbo].[Video] ([VideoType], [VideoURL]) VALUES (N'Academic', N'4vIQON2fDWM')
INSERT [dbo].[Video] ([VideoType], [VideoURL]) VALUES (N'Academic', N'_Z5LZW2mmp8')
INSERT [dbo].[Video] ([VideoType], [VideoURL]) VALUES (N'Academic', N'R-bI0AhSyU0')
INSERT [dbo].[Video] ([VideoType], [VideoURL]) VALUES (N'Academic', N'FXR6hEyf5Q4')
INSERT [dbo].[Video] ([VideoType], [VideoURL]) VALUES (N'Nature', N'B9VRvOKKwfs')
INSERT [dbo].[Video] ([VideoType], [VideoURL]) VALUES (N'Nature', N'cqbomS1STFY')
INSERT [dbo].[Video] ([VideoType], [VideoURL]) VALUES (N'Nature', N'UV0mhY2Dxr0')
INSERT [dbo].[Video] ([VideoType], [VideoURL]) VALUES (N'Academic', N'BQrxsyGTztM')
INSERT [dbo].[Video] ([VideoType], [VideoURL]) VALUES (N'Spaces', N'rWnCk_86KVE')
INSERT [dbo].[Video] ([VideoType], [VideoURL]) VALUES (N'Spaces', N'5TA4keTOmVE')
INSERT [dbo].[Video] ([VideoType], [VideoURL]) VALUES (N'Spaces', N'tkgCnTvM5wI')
INSERT [dbo].[Video] ([VideoType], [VideoURL]) VALUES (N'Spaces', N'SIkbsFJUzBY')
INSERT [dbo].[Video] ([VideoType], [VideoURL]) VALUES (N'Nature', N'VNu15Qqomt8')

-- Inserting values into the VideoType table without specifying the TypeID column
INSERT [dbo].[VideoType] ([TypeName], [TypeIMG]) VALUES (N'Anime', N'https://i.pinimg.com/564x/25/5a/8b/255a8bcab3da16c62d3cbc1f119dbbcd.jpg')
INSERT [dbo].[VideoType] ([TypeName], [TypeIMG]) VALUES (N'Nature', N'https://i.pinimg.com/564x/fe/da/5a/feda5a00a13e5d2dbb5b17af5d149062.jpg')
INSERT [dbo].[VideoType] ([TypeName], [TypeIMG]) VALUES (N'City', N'https://i.pinimg.com/564x/fe/76/02/fe76021a101f7ae6103d72e65cda437e.jpg')
INSERT [dbo].[VideoType] ([TypeName], [TypeIMG]) VALUES (N'Academic', N'https://i.pinimg.com/564x/36/7d/f5/367df5b580196a8bc8b9aaf036296367.jpg')
INSERT [dbo].[VideoType] ([TypeName], [TypeIMG]) VALUES (N'Spaces', N'https://media.istockphoto.com/id/1346113573/vector/asteroids-and-gas-giant.jpg?s=612x612&w=0&k=20&c=yzZSu9-NS3muuT-CZqzR3lpJi_TL_DzSfD2l0utwaS0=')
