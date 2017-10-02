<!DOCTYPE html>
<html>
	<body>

		<?php
			$name_err = $rollno_err = $year_err = $branch_err = $comm_err = "";
			$name = $rollno = $year = $branch = $comm ="";

			if ($_SERVER["REQUEST_METHOD"] == "POST") 
			{
				if(empty($_POST["name"])) 
				{
					$name_err = "Empty Field";  
				} 
				else
				{
					$name = $_POST["name"];	
				}
				if(empty($_POST["rollno"])) 
				{
					$rollno_err = "Empty Field";  
				} 
				else
				{
					$rollno = $_POST["rollno"];	
				}
				if(empty($_POST["year"])) 
				{
					$year_err = "Empty Field";  
				} 
				else
				{
					$year = $_POST["year"];	
				}
				if(empty($_POST["branch"])) 
				{
					$branch_err = "Empty Field";  
				} 
				else
				{
					$branch = $_POST["branch"];	
				}
				if(empty($_POST["comm"])) 
				{
					$comm_err = "Empty Field";  
				} 
				else
				{
					$comm = $_POST["comm"];	
				}
			}
		?>

		<h2> Registration </h2>

	<form method = "post" action = "<?php echo htmlspecialchars($_SERVER["PHP_SELF"]);?>">

	Name : <input type = "text" name = "name">
	<span class = "error">* <?php echo $name_err; ?> </span> 
	<br><br>
	Roll Number : <input type = "text" name = "rollno">
	<span class = "error">* <?php echo $rollno_err; ?> </span> 
	<br><br>
	Year:
		<input type="radio" name="year" value="First">First
		<input type="radio" name="year" value="Second">Second
		<input type="radio" name="year" value="Third">Third
		<span class="error">* <?php echo $year_err;?></span>
		<br><br>
	Branch:
		<input type="radio" name="branch" value="ICT">ICT
		<input type="radio" name="branch" value="Mechanical">Mechanical
		<input type="radio" name="branch" value="Chemical">Chemical
		<span class="error">* <?php echo $year_err;?></span>
		<br><br>
	Committee:
		<input type="radio" name="comm" value="Class Representative">Class Representative
		<input type="radio" name="comm" value="Festival">Festival
		<input type="radio" name="comm" value="Academic">Academic
		<input type="radio" name="comm" value="Cultural">Cultural
		<input type="radio" name="comm" value="Sports">Sports
		<input type="radio" name="comm" value="Placement">Placement
		<span class="error">* <?php echo $comm_err;?></span>
		<br><br>
		<input type="submit" name="submit" value="Submit"> 
		</form>

		<?php
			echo "<h2>Your Input:</h2>";
			echo $name;
			echo "<br>";
			echo $rollno;
			echo "<br>";
			echo $year;
			echo "<br>";
			echo $branch;
			echo "<br>";
			echo $comm;
			echo "<br>";



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
			if($year=="First")
			{
				if($branch=="ICT")
				{
					$sql = "INSERT INTO first_ict (RollNo, Name, Commitee, Votes) VALUES ('$rollno', '$name', '$comm', '0')";
				}
				else if($branch=="Mechanical")
				{
					$sql = "INSERT INTO first_mech (RollNo, Name, Commitee, Votes) VALUES ('$rollno', '$name', '$comm', '0')";
				}
				else if($branch=="Chemical")
				{
					$sql = "INSERT INTO first_chem (RollNo, Name, Commitee, Votes) VALUES ('$rollno', '$name', '$comm', '0')";
				}
				
				if (mysqli_query($conn,$sql)) 
				{
					echo "New record created successfully";
				} 
				else 
				{
					echo "Entry with the same Roll Number already made!";
				}
			}
			else if($year=="Second")
			{
				if($branch=="ICT")
				{
					$sql = "INSERT INTO second_ict (RollNo, Name, Commitee, Votes) VALUES ('$rollno', '$name', '$comm', '0')";
				}
				else if($branch=="Mechanical")
				{
					$sql = "INSERT INTO second_mech (RollNo, Name, Commitee, Votes) VALUES ('$rollno', '$name', '$comm', '0')";
				}
				else if($branch=="Chemical")
				{
					$sql = "INSERT INTO second_chem (RollNo, Name, Commitee, Votes)
					VALUES ('$rollno', '$name', '$comm', '0')";
				}
				
				if (mysqli_query($conn,$sql)) 
				{
				echo "New record created successfully";
				} 
				else 
				{
					echo "Entry with the same Roll Number already made!";
				}
			}
			else if($year=="Third")
			{
				if($branch=="ICT")
				{
					$sql = "INSERT INTO third_ict (RollNo, Name, Commitee, Votes)
					VALUES ('$rollno', '$name', '$comm', '0')";
				}
				else if($branch=="Mechanical")
				{
					$sql = "INSERT INTO third_mech (RollNo, Name, Commitee, Votes)
					VALUES ('$rollno', '$name', '$comm', '0')";
				}
				else if($branch=="Chemical")
				{
					$sql = "INSERT INTO third_chem (RollNo, Name, Commitee, Votes)
					VALUES ('$rollno', '$name', '$comm', '0')";
				}
				
				if (mysqli_query($conn,$sql)) 
				{
					echo "New record created successfully";
				} 
				else 
				{
					echo "Entry with the same Roll Number already made!";
				}
			}

		mysqli_close($conn);
		?>
	</body>
</html>

			