<!DOCTYPE html>
<html>
	<body>
		<?php
			$servername = "mysql.hostinger.in";
			$username = "u584225544_priya";
			$password = "priyameet";
			$dbname = "u584225544_ieee";
			$i=0;
			$choice=0;
			$row;
			$roll;
			$inivote;
			$max_name;
			$max_vote;
			$max = 0;
			
			// Create connection
			$conn = new mysqli($servername, $username, $password, $dbname);
			// Check connection
			
			if ($conn->connect_error) 
			{
				die("Connection failed: " . $conn->connect_error);
			} 

			$sql = "SELECT Name, Votes, Commitee FROM first_ict";
			$result = $conn->query($sql);

			if ($result->num_rows > 0) 
			{
				// output data of each row
				while($row = $result->fetch_assoc()) 
				{                
					if($row["Commitee"]=="Festival")
					{ 
						echo "Name: " . $row["Name"]; 
						echo "Votes: " . $row["Votes"]; 
						$max_vote = $row["Votes"];  
					}
					if($max_vote > $max)
					{
                        $max = $max_vote;
                        $max_name = $row["Name"];
					}
				}

				echo "<br / >" . $max;
				echo " " . $max_name;
			} 
			else 
			{
				echo "0 results";
			}
		?>
	</body>
</html>								