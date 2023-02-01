INSERT INTO franchise (franchise_name,description) 
VALUES	(CONCAT('Marvel',CHR(39),'s Cinematic Universe'),
		CONCAT('The Marvel Cinematic Universe (MCU) is an American media franchise', 
		'and shared universe centered on a series of superhero films produced by Marvel Studios.',
		'The films are based on characters that appear in American comic books published by Marvel Comics.')
		),
		('The Star Wars Saga',
		CONCAT('Star Wars is an American epic space opera[1] multimedia franchise created by George Lucas,',
		'which began with the eponymous 1977 film[b] and quickly became a worldwide pop culture phenomenon.')
		),
		('Insidious',
		CONCAT('Insidious is a series of American horror films created by Leigh Whannell.',
		'Four films form this franchise—Insidious, Insidious: Chapter 2, ',
		'Insidious: Chapter 3, Insidious: The Last Key')
		);
		
INSERT INTO movie(franchise_id,movie_title,genre,release_year,director,picture,trailer) 
VALUES	(1,'Iron man','Action,Adventure,Sci-fi',2008,'Jon Favreau', 'https://www.imdb.com/title/tt0371746/mediaviewer/rm1544850432/?ref_=tt_ov_i', 'https://www.imdb.com/video/vi447873305/?playlistId=tt0371746?ref_=ext_shr_lnk'),
		(1,'The Incredible Hulk','Action,Adventure,Sci-fi',2008,'Louis Leterrier','https://www.imdb.com/title/tt0800080/mediaviewer/rm2081134080/?ref_=tt_ov_i','https://www.imdb.com/video/vi1726152985/?playlistId=tt0800080?ref_=ext_shr_lnk'),
		(2,'Star Wars: Episode IV - A New Hope','Action,Adventure,Fantasy',1977,'George Lucas', 'https://www.imdb.com/title/tt0076759/mediaviewer/rm164871937/?ref_=tt_ov_i','https://www.imdb.com/video/vi1317709849/?playlistId=tt0076759&ref_=tt_ov_vi'),
		(2,'Star Wars: Episode V - The Empire Strikes Back','Action,Adventure,Fantasy',1980,'Irvin Kershner','https://www.imdb.com/title/tt0080684/mediaviewer/rm3114097664/?ref_=tt_ov_i','https://www.imdb.com/video/vi221753881/?playlistId=tt0080684&ref_=tt_ov_vi'),
		(3,'Insidious','Horror,Mystery,Thriller',2010,'James Wan','https://www.imdb.com/title/tt1591095/mediaviewer/rm638040576/?ref_=tt_ov_i','https://www.imdb.com/video/vi1929288729/?playlistId=tt1591095&ref_=tt_ov_vi'),
		(3,'Insidious: Chapter 2','Horror,Mystery,Thriller',2013,'James Wan','https://www.imdb.com/title/tt2226417/mediaviewer/rm1258412544/?ref_=tt_ov_i','https://www.imdb.com/video/vi4286163225/?playlistId=tt2226417&ref_=tt_ov_vi'),
		(3,'Insidious: Chapter 3','Horror,Mystery,Thriller',2015,'Leigh Whannell','https://www.imdb.com/title/tt3195644/mediaviewer/rm4204064768/?ref_=tt_ov_i','https://www.imdb.com/video/vi4241469209/?playlistId=tt3195644&ref_=tt_ov_vi'),
		(3,'Insidious: The Last Key','Horror,Mystery,Thriller',2018,'Adam Robitel','https://www.imdb.com/title/tt5726086/mediaviewer/rm2946572544/?ref_=tt_ov_i','https://www.imdb.com/video/vi1090959641/?playlistId=tt5726086&ref_=tt_ov_vi');
			
INSERT INTO film_characters(character_full_name,character_alias,gender)
VALUES	('Tony Stark','Iron man','Male'),
		('Obadiah Stanes','Iron Monger','Male'),
		('Betty Ross','Red She-Hulk','Female'),
		('Bruce Banner','Hulk','Male'),
		('Luke Skywalker','Wormie','Male'),
		('Han Solo','Cadet 124-239','Male'),
		('Chewbacca','Chewie','Male'),
		('Josh Lambert','Jos','Male'),
		('Renai Lambert','Ren','Female'),
		('Dalton Lambert','Dal','Male'),
		('Elise Rainier','Liz','Female'),
		('Sean Brenner','Sean','Male'),
		('Quinn Brenner','Quinn','Female'),
		('Tucker','Tucker','Male'),
		('Specs','Specs','Male'),
		('Melissa Rainier','Melissa Rainier','Female');
				  
INSERT INTO movies_characters(movie_id,character_id)
VALUES	(1,1),(1,2),(2,3),(2,4),
		(3,4),(3,5),(3,6),(3,7),
		(4,4),(4,5),(4,6),(4,7),
		(5,14),(5,15),(5,11),
		(6,14),(6,15),(6,11),
		(7,14),(7,15),(7,11),
		(8,14),(8,15),(8,11),
		(5,8),(5,9),(5,10),
		(6,8),(6,9),(6,10),
		(7,12),(7,13),
		(8,16);
		
		
				  