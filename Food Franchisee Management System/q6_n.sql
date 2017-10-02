select  y.RawMaterial_Id, y.Raw_Material_Name, max(y.Qty) as MaxUsed from (select RawMaterial_ID, Raw_Material_Name, sum(Quantity) as Qty from raw_materials group by RawMaterial_ID)y;

