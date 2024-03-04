1.A motorokk árainak és tulajdonosainak nevei
SELECT `ar`, `nev` FROM MOTOR inner join TULAJDONOS on MOTOR.TULAJDONOS=TULAJDONOS.tulaj_id GROUP BY `ar`,`nev`;

2. A motorok és azok alkatrészeik
SELECT `m_id`, `dugattyu`, `bovden`, `kerek`, `fohenger`  FROM MOTOR inner join ALKATRESZEK on MOTOR.m_id=ALKATRESZEK.motor GROUP BY `m_id`,`dugattyu`, `bovden`, `kerek`, `fohenger`;

3. A 2009.09.13 elõtt feladott hirdetések és azok  tipusai,árai
SELECT `hirdetes tipusa`, `ar` FROM HIRDETES inner join HIRDET on HIRDETES.h_id=HIRDET.hirdetes WHERE idopont< '2009.09.13' GROUP BY `hirdetes tipusa`, `ar`;


4.Azok az példanyszamok amelyek nem címlapos hirdetesek.
SELECT `peldanyszam` FROM HIRDETES WHERE `cimlapon-e`='Nem' GROUP BY `peldanyszam`;

5.Mennyi hirdetés van amelyek példányszáma az átlagpéldányszám felett van?
SELECT count(*) FROM HIRDETES WHERE peldanyszam > (SELECT AVG(peldanyszam) FROM HIRDETES); 

6.Azon vevõk adatai akik 2022.09.20 elõtt vásároltak motort
SELECT `nev`, `varos`, `kor`, `szig.szam` FROM VEVO inner join VETEL on VEVO.v_id=VETEL.VEVO WHERE idopont< '2022.09.20' GROUP BY `nev`, `varos`, `kor`, `szig.szam`;

7. Azon tulajdonosok adatai akik 500as és 120ezer forintnál nagyobb értékû motorral rendelkeznek
SELECT `nev`, `varos`, `utca`, `hsz`, `irsz` FROM TULAJDONOS inner join MOTOR on TULAJDONOS.tulaj_id=MOTOR.TULAJDONOS WHERE vegseb='500'and ar > '120000' GROUP BY`nev`, `varos`, `utca`, `hsz`, `irsz`;

8.Azok az példanyszamok amelyek címlapos hirdetesek.
SELECT `peldanyszam` FROM HIRDETES WHERE `cimlapon-e`='Igen' GROUP BY `peldanyszam`;

9.Számoljuk meg hogy a 2009.10.13 elõtt 80000 peldanyszamnal kisebb feladott hirdetések árát?
SELECT sum(ar) FROM HIRDETES inner join HIRDET on HIRDETES.h_id=HIRDET.hirdetes WHERE idopont < '2009.10.13' and peldanyszam < '80000';


10.Azon vevõk adatai akik 2022.03.11 után vásároltak motort
SELECT `nev`, `varos`, `kor`, `szig.szam` FROM VEVO inner join VETEL on VEVO.v_id=VETEL.VEVO WHERE idopont> '2022.03.11' GROUP BY `nev`, `varos`, `kor`, `szig.szam`;