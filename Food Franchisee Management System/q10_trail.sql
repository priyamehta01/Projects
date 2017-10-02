select y.Franchisee_ID, max(y.TotalProfit) as ProfitEarned from (select Franchisee_ID, sum((Food_Price - Food_Actual_Price) * Quantity) as TotalProfit from customer_record, food_items where customer_record.Food_ID = food_items.Food_ID group by Franchisee_ID) y;
