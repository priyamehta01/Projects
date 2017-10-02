<!DOCTYPE html>
<html>
	<body>
		<?php
			// define variables and set to empty values
			$ict_first_Err = $mech_first_Err = $chem_first_Err ="";
			$ict_first = $mech_first = $chem_first ="";

			$ict_second_Err = $mech_second_Err = $chem_second_Err ="";
			$ict_second = $mech_second = $chem_second ="";

			$ict_third_Err = $mech_third_Err = $chem_third_Err ="";
			$ict_third = $mech_third = $chem_third ="";

			if ($_SERVER["REQUEST_METHOD"] == "POST") 
			{
				if(empty($_POST["ict_first"])) 
				{
					$ict_first_Err = "Empty Field";  
				} 
				else
				{
					$ict_first = $_POST["ict_first"];	
				}
				if(empty($_POST["mech_first"])) 
				{
					$mech_first_Err = "Empty Field";  
				} 
				else
				{
					$mech_first = $_POST["mech_first"];	
				}
				if(empty($_POST["chem_first"])) 
				{
					$chem_first_Err = "Empty Field";  
				} 
				else
				{
					$chem_first = $_POST["chem_first"];	
				}
				if(empty($_POST["ict_second"])) 
				{
					$ict_second_Err = "Empty Field";  
				} 
				else
				{
					$ict_second = $_POST["ict_second"];	
				}
				if(empty($_POST["mech_second"])) 
				{
					$mech_second_Err = "Empty Field";  
				} 
				else
				{
					$mech_second = $_POST["mech_second"];	
				}
				if(empty($_POST["chem_second"])) 
				{
					$chem_second_Err = "Empty Field";  
				} 
				else
				{
					$chem_second = $_POST["chem_second"];	
				}
				if(empty($_POST["ict_third"])) 
				{
					$ict_third_Err = "Empty Field";  
				} 
				else
				{
					$ict_third = $_POST["ict_third"];	
				}
				if(empty($_POST["mech_third"])) 
				{
					$mech_third_Err = "Empty Field";  
				} 
				else
				{
					$mech_third = $_POST["mech_third"];	
				}
				if(empty($_POST["chem_third"])) 
				{
					$chem_third_Err = "Empty Field";  
				} 
				else
				{
					$chem_third = $_POST["chem_third"];	
				}	
			}
		?>

		<h2> Admin Form </h2>
		<form method = "post" action = "<?php echo htmlspecialchars($_SERVER["PHP_SELF"]);?>">
		
			<h3> First Year </h3> <br>

			ICT : <input type = "text" name = "ict_first">
			<span class = "error">* <?php echo $ict_first_Err; ?> </span> 
			<br><br>

			Mechanical : <input type = "text" name = "mech_first">
			<span class = "error">* <?php echo $mech_first_Err; ?> </span>
			<br><br>

			Chemical : <input type = "text" name = "chem_first">
			<span class = "error">* <?php echo $chem_first_Err; ?> </span>
			<br><br>

			<h3> Second Year </h3> <br>

			ICT : <input type = "text" name = "ict_second">
			<span class = "error">* <?php echo $ict_second_Err; ?> </span> 
			<br><br>

			Mechanical : <input type = "text" name = "mech_second">
			<span class = "error">* <?php echo $mech_second_Err; ?> </span>
			<br><br>

			Chemical : <input type = "text" name = "chem_second">
			<span class = "error">* <?php echo $chem_second_Err; ?> </span>
			<br><br>

			<h3> Third Year </h3> <br>

			ICT : <input type = "text" name = "ict_third">
			<span class = "error">* <?php echo $ict_third_Err; ?> </span> 
			<br><br>

			Mechanical : <input type = "text" name = "mech_third">
			<span class = "error">* <?php echo $mech_third_Err; ?> </span>
			<br><br>

			Chemical : <input type = "text" name = "chem_third">
			<span class = "error">* <?php echo $chem_third_Err; ?> </span>
			<br><br>

			<input type="submit" name="submit" value="Submit">  
		</form>

		<?php
			echo "<h2>Your Input:</h2>";
			echo $ict_first;
			echo "<br>";
			echo $mech_first;
			echo "<br>";
			echo $chem_first;
			echo "<br>";

			echo $ict_second;
			echo "<br>";
			echo $mech_second;
			echo "<br>";
			echo $chem_second;
			echo "<br>";

			echo $ict_third;
			echo "<br>";
			echo $mech_third;
			echo "<br>";
			echo $chem_third;
			echo "<br>";
		?>
	</body>
</html>