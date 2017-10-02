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

			// Create connection
			$conn = mysqli_connect($servername, $username, $password, $dbname);
			// Check connection
			if(!$conn) 
			{
				die("Connection failed: " . $conn->connect_error);
			} 
			
			if ($_SERVER["REQUEST_METHOD"] == "POST") 
			{
				if(empty($_POST["choice"])) 
				{
					$choice_err = "Empty Field";  
				} 
				else
				{
					$choice = $_POST["choice"];
					echo $choice;	
				}
				$sql = "UPDATE register_vote SET reg_vote='$choice' WHERE id='5'";
				if (mysqli_query($conn,$sql)) 
				{    
					echo "New record created successfully";
				} 
				else 
				{
					echo "Entry with the same Roll Number already made!";
				}
				
				mysqli_close($conn);
			}
		?>

		<h4> Select the Button you want to Enable </h4>

		<form method = "post" action = "<?php echo htmlspecialchars($_SERVER["PHP_SELF"]);?>">

		<input type="radio" name="choice" value="Register">Register
		<input type="radio" name="choice" value="Vote">Vote
		<span class="error">* <?php echo $choice_err;?></span>
		<br>
		<input type="submit" name="submit" value="Submit"> 
		
		</form>
		
		<?php
			echo $choice;
		?>
		
	</body>
</html>
