SET SQL_SAFE_UPDATES=0;
delete from raw_materials where (curdate() - raw_materials.Date) > 3;
