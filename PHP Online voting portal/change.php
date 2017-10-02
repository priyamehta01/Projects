<!DOCTYPE>
<html>
	<head>
		<title>
			Project
		</title>
	</head>
	
	<body>
		<?php
			$servername = "mysql.hostinger.in";
			$username = "u584225544_priya";
			$password = "priyameet";
			$dbname = "u584225544_ieee";

			// Create connection
			$conn = mysqli_connect($servername, $username, $password, $dbname);
			
			// Check connection
			if (!$conn) 
			{
				die("Connection failed: " . $conn->connect_error);
			} 

			$sql = "INSERT INTO Jaymeen (firstname, lastname, email) VALUES ('John Snow', 'hjhj', 'john@example.com')";

			if (mysqli_query($conn,$sql)) 
			{
				echo "New record created successfully";
			} 
			else 
			{
				echo "Error: " . $sql . "<br>" . $conn->error;
			}
			
			mysqli_close($conn);
		?>
	</body>
</html>