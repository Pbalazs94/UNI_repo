CREATE TABLE MOTOR (
`m_id` INT( 3 ) NOT NULL ,
`szin` VARCHAR( 10 ) NOT NULL ,
`ar` INT( 6 ) NOT NULL ,
`vegseb` INT( 4 ) NOT NULL ,
`tulaj` VARCHAR( 20 ) NOT NULL COMMENT'references TULAJDONOS' ,
PRIMARY KEY ( `m_id` )
);
CREATE TABLE `VEVO` (
`v_id` INT( 3 ) NOT NULL ,
`nev` VARCHAR( 30 ) NOT NULL ,
`varos` VARCHAR( 30 ) NOT NULL ,
`kor` INT( 2 ) NOT NULL ,
`szig.szam` VARCHAR( 8 ) NOT NULL ,
PRIMARY KEY ( `v_id` ) 
);
CREATE TABLE `HIRDETES` ( 
`h_id` INT( 3 ) NOT NULL , 
`peldanyszam` INT( 5 ) NOT NULL ,
`hirdetes tipusa` VARCHAR( 200 ) NOT NULL ,
`ar` INT( 4 ) NOT NULL,
`cimlapon-e` VARCHAR( 20 ) NOT NULL , 
PRIMARY KEY ( `h_id` ) 
);
CREATE TABLE `TULAJDONOS` (
`tulaj_id` INT( 3 ) NOT NULL ,
`nev` VARCHAR( 30 ) NOT NULL ,
`varos` VARCHAR( 30 ) NOT NULL ,
`utca` VARCHAR( 25 ) NULL ,
`hsz` INT( 3 ) NOT NULL ,
`irsz` INT( 4 ) NOT NULL,
PRIMARY KEY ( `tulaj_id` ) 
);
CREATE TABLE `HIRDET` (
`hirdetes` INT( 3 ) NOT NULL COMMENT 'references HIRDETES',
`motor` VARCHAR( 10 ) NOT NULL COMMENT 'references MOTOR',
`idopont` DATE NOT NULL 
);
CREATE TABLE ALKATRESZEK (
`motor` VARCHAR( 10 ) NOT NULL COMMENT 'references MOTOR' ,
`dugatyuu` INT( 20 ) NULL ,
`bovden` VARCHAR( 10 ) NULL ,
`kerek` VARCHAR( 15 ) NULL .
`fohenger` VARCHAR( 20) NULL , 
);
CREATE TABLE VETEL (
`motor` VARCHAR( 10 ) NOT NULL COMMENT 'references MOTOR' ,
`vevo` VARCHAR( 30 ) NOT NULL COMMENT 'references VEVO' ,
`idopont` DATE NOT NULL 
);
CREATE TABLE `KEDVEZMENY` ( 
`kedvezmeny_id` INT( 3 ) NOT NULL , 
`nev` VARCHAR( 20 ) NULL ,
`ervenyes_idoszak` DATE NULL ,
`szazalek` INT( 3 ) NULL, 
PRIMARY KEY ( `kedvezmeny_id` )
); 