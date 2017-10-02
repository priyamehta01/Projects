<!DOCTYPE html>
<html>
	<body>
		//	<input type = "button" value = "Vote"
		//onclick = "window.location.href='http://2016summerschool.esy.es/SummerProject/Vote.php'" />

			<?php
				session_start();
				$roll = $_SESSION['temp'];
				$roll_length = strlen($roll);

				if($roll_length==7)
				{
					$roll .= '20' . $roll;
				}
				echo $roll;
				$year = (int)substr($roll , 0 , 4);
				$sys_year = (int)date("Y");
				$branch = substr($roll , 4 , 2);

				if($sys_year == $year)
				{
				   if($branch == "01")
				   {
					   
				   }
				}
				else if($sys_year == ($year + 1))
				{
				   echo "Second Year";
				}
				else if($sys_year == ($year + 2))
				{
				   echo  "third year";
				}

				if($branch == "01")
				{
					echo "ICT";
				}

				else if($branch == "02")
				{
					echo "Chemical";
				}

				else if($branch == "03")
				{
					echo "Mechanical";
				}

				$servername = "mysql.hostinger.in";
				$username = "u584225544_priya";
				$password = "priyameet";
				$dbname = "u584225544_ieee";
				$i=0;
				$choice=0;
				$row;
				$inivote;
				$cnt1 = 0;
				$cnt2 = 0;
				$cnt3 = 0;
				$cnt4 = 0;
				$cnt5 = 0;
				$cnt6 = 0;

				// Create connection
				$conn = new mysqli($servername, $username, $password, $dbname);
				// Check connection
				if ($conn->connect_error) 
				{
					die("Connection failed: " . $conn->connect_error);
				} 

				if($sys_year == $year)
				{
					if($branch == "01")
					{
						$sql = "SELECT Name, RollNo, Commitee FROM first_ict ORDER BY Commitee ASC";
						$result = $conn->query($sql);

						if ($result->num_rows > 0) 
						{
							// output data of each row
							while($row = $result->fetch_assoc()) 
							{	
								if($row["Commitee"]=="Festival")
								{
									if($cnt1 == 0)
									{
										echo "Festival  : (First ICT)";
										$cnt1 = 1; 
									}   
									$i++;
									$choice++;
									
									echo "<form action ='' method = 'post'>"."<input type='radio' name='fest' value='".$row["RollNo"]."'>".$row["Name"]."(".$row["RollNo"].")"."<br />"."&nbsp;&nbsp;&nbsp;";
								}

								else if($row["Commitee"]=="Academic")
								{
									if($cnt2 == 0)
									{
										echo "Academic  : (First ICT)";
										$cnt2 = 1; 
									}   
									$i++;
									$choice++;
									echo "<form action ='' method = 'post'>"."<input type='radio' name='aca' value='".$row["RollNo"]."'>".$row["Name"]."(".$row["RollNo"].")"."<br />"."&nbsp;&nbsp;&nbsp;";
								}

								else if($row["Commitee"]=="Class Representative")
								{
									if($cnt3 == 0)
									{
										echo "Class Representative  : (First ICT)";
										$cnt3 = 1; 
									}   
									$i++;
									$choice++;
									echo "<form action ='' method = 'post'>"."<input type='radio' name='cr' value='".$row["RollNo"]."'>".$row["Name"]."(".$row["RollNo"].")"."<br />"."&nbsp;&nbsp;&nbsp;";
								}

								else if($row["Commitee"]=="Cultural")
								{
									if($cnt4 == 0)
									{
										echo "Cultural  : (First ICT)";
										$cnt4 = 1; 
									}   
									$i++;
									$choice++;
									echo "<form action ='' method = 'post'>"."<input type='radio' name='cult' value='".$row["RollNo"]."'>".$row["Name"]."(".$row["RollNo"].")"."<br />"."&nbsp;&nbsp;&nbsp;";
								}

								else if($row["Commitee"]=="Sports")
								{
									if($cnt5 == 0)
									{
										echo "Sports  : (First ICT)";
										$cnt5 = 1; 
									}   
									$i++;
									$choice++;
									echo "<form action ='' method = 'post'>"."<input type='radio' name='sports' value='".$row["RollNo"]."'>".$row["Name"]."(".$row["RollNo"].")"."<br />"."&nbsp;&nbsp;&nbsp;";
								}

								else if($row["Commitee"]=="Placement")
								{
									if($cnt6 == 0)
									{
										echo "Placement  : (First ICT)";
										$cnt6 = 1; 
									}   
									$i++;
									$choice++;
									echo "<form action ='' method = 'post'>"."<input type='radio' name='placement' value='".$row["RollNo"]."'>".$row["Name"]."(".$row["RollNo"].")"."<br />"."&nbsp;&nbsp;&nbsp;";
								}
							}
						}
					}
					echo $i;
				} 

				if($sys_year == $year)
				{
					if($branch == "02")
					{
						$sql = "SELECT Name, RollNo, Commitee FROM first_chem ORDER BY Commitee ASC";
						$result = $conn->query($sql);

						if ($result->num_rows > 0) 
						{	
							// output data of each row
							while($row = $result->fetch_assoc()) 
							{	
								if($row["Commitee"]=="Festival")
								{
									if($cnt1 == 0)
									{
										echo "Festival  : (First Chem)";
										$cnt1 = 1; 
									}   
									$i++;
									$choice++;
									echo "<form action ='' method = 'post'>"."<input type='radio' name='fest' value='".$row["RollNo"]."'>".$row["Name"]."(".$row["RollNo"].")"."<br />"."&nbsp;&nbsp;&nbsp;";
								}

								else if($row["Commitee"]=="Academic")
								{
									if($cnt2 == 0)
									{
										echo "Academic  : (First Chem)";
										$cnt2 = 1; 
									}   
									$i++;
									$choice++;
									echo "<form action ='' method = 'post'>"."<input type='radio' name='aca' value='".$row["RollNo"]."'>".$row["Name"]."(".$row["RollNo"].")"."<br />"."&nbsp;&nbsp;&nbsp;";
								}

								else if($row["Commitee"]=="Class Representative")
								{
									if($cnt3 == 0)
									{
										echo "Class Representative  : (First Chem)";
										$cnt3 = 1; 
									}   
									$i++;
									$choice++;
									echo "<form action ='' method = 'post'>"."<input type='radio' name='cr' value='".$row["RollNo"]."'>".$row["Name"]."(".$row["RollNo"].")"."<br />"."&nbsp;&nbsp;&nbsp;";
								}

								else if($row["Commitee"]=="Cultural")
								{
									if($cnt4 == 0)
									{
										echo "Cultural  : (First Chem)";
										$cnt4 = 1; 
									}   
									$i++;
									$choice++;
									echo "<form action ='' method = 'post'>"."<input type='radio' name='cult' value='".$row["RollNo"]."'>".$row["Name"]."(".$row["RollNo"].")"."<br />"."&nbsp;&nbsp;&nbsp;";
								}

								else if($row["Commitee"]=="Sports")
								{
									if($cnt5 == 0)
									{
										echo "Sports  : (First Chem)";
										$cnt5 = 1; 
									}   
									$i++;
									$choice++;
									echo "<form action ='' method = 'post'>"."<input type='radio' name='sports' value='".$row["RollNo"]."'>".$row["Name"]."(".$row["RollNo"].")"."<br />"."&nbsp;&nbsp;&nbsp;";
								}

								else if($row["Commitee"]=="Placement")
								{
									if($cnt6 == 0)
									{
										echo "Placement  : (First Chem)";
										$cnt6 = 1; 
									}   
									$i++;
									$choice++;
									echo "<form action ='' method = 'post'>"."<input type='radio' name='placement' value='".$row["RollNo"]."'>".$row["Name"]."(".$row["RollNo"].")"."<br />"."&nbsp;&nbsp;&nbsp;";
								}
							}
						}
					}
					echo $i;
				}

				if($sys_year == $year)
				{
					if($branch == "03")
					{
						$sql = "SELECT Name, RollNo, Commitee FROM first_mech ORDER BY Commitee ASC";
						$result = $conn->query($sql);

						if ($result->num_rows > 0) 
						{
							// output data of each row
							while($row = $result->fetch_assoc()) 
							{	
								if($row["Commitee"]=="Festival")
								{
									if($cnt1 == 0)
									{
										echo "Festival  : (First Mech)";
										$cnt1 = 1; 
									}   
									$i++;
									$choice++;
									
									echo "<form action ='' method = 'post'>"."<input type='radio' name='fest' value='".$row["RollNo"]."'>".$row["Name"]."(".$row["RollNo"].")"."<br />"."&nbsp;&nbsp;&nbsp;";
								}

								else if($row["Commitee"]=="Academic")
								{
									if($cnt2 == 0)
									{
										echo "Academic  : (First Mech)";
										$cnt2 = 1; 
									}   
									$i++;
									$choice++;
									echo "<form action ='' method = 'post'>"."<input type='radio' name='aca' value='".$row["RollNo"]."'>".$row["Name"]."(".$row["RollNo"].")"."<br />"."&nbsp;&nbsp;&nbsp;";
								}

								else if($row["Commitee"]=="Class Representative")
								{
									if($cnt3 == 0)
									{
										echo "Class Representative  : (First Mech)";
										$cnt3 = 1; 
									}   
									$i++;
									$choice++;
									echo "<form action ='' method = 'post'>"."<input type='radio' name='cr' value='".$row["RollNo"]."'>".$row["Name"]."(".$row["RollNo"].")"."<br />"."&nbsp;&nbsp;&nbsp;";
								}

								else if($row["Commitee"]=="Cultural")
								{
									if($cnt4 == 0)
									{
										echo "Cultural  : (First Mech)";
										$cnt4 = 1; 
									}   
									$i++;
									$choice++;
									echo "<form action ='' method = 'post'>"."<input type='radio' name='cult' value='".$row["RollNo"]."'>".$row["Name"]."(".$row["RollNo"].")"."<br />"."&nbsp;&nbsp;&nbsp;";
								}

								else if($row["Commitee"]=="Sports")
								{
									if($cnt5 == 0)
									{
										echo "Sports  : (First Mech)";
										$cnt5 = 1; 
									}   
									$i++;
									$choice++;
									echo "<form action ='' method = 'post'>"."<input type='radio' name='sports' value='".$row["RollNo"]."'>".$row["Name"]."(".$row["RollNo"].")"."<br />"."&nbsp;&nbsp;&nbsp;";
								}

								else if($row["Commitee"]=="Placement")
								{
									if($cnt6 == 0)
									{
										echo "Placement  : (First Mech)";
										$cnt6 = 1; 
									}   
									$i++;
									$choice++;
									echo "<form action ='' method = 'post'>"."<input type='radio' name='placement' value='".$row["RollNo"]."'>".$row["Name"]."(".$row["RollNo"].")"."<br />"."&nbsp;&nbsp;&nbsp;";
								}
							}
						}
					}
					echo $i;
				} 				
			?>

			<form action = "" method = "post"><input type = "submit" name="submit" value = "Submit">

			<?php 

				//echo "if upar nu : ".$sys_year;
	
				if($sys_year == $year)	
				{
					if($branch == "01")
					{
						if(isset($_POST['submit']))
						{		
							if(isset($_POST["aca"]))
							{
								echo "Name : ".$_POST['aca'];
								$roll=$_POST['aca'];

								$sql = "SELECT Votes,RollNo FROM first_ict";
								$result = $conn->query($sql);
								
								if ($result->num_rows > 0) 
								{
									while($row = $result->fetch_assoc()) 
									{		
										if($row["RollNo"]==$roll)
										{
							
											$inivote=$row["Votes"];
											$inivote++;
										}
									}
									echo "Vote : ".$inivote;
								}
								$sql = "UPDATE first_ict SET Votes=$inivote WHERE RollNo=$roll";

								if($conn->query($sql) === TRUE)
								{
									echo "Record Edited";
								}
								else
								{
									echo "Error";
								}
							}
							
							if(isset($_POST["cult"]))
							{
								echo "Name : ".$_POST['cult'];
								$roll=$_POST['cult'];

								$sql = "SELECT Votes,RollNo FROM first_ict";
								$result = $conn->query($sql);
								
								if ($result->num_rows > 0) 
								{
									while($row = $result->fetch_assoc()) 
									{		
										if($row["RollNo"]==$roll)
										{
											$inivote=$row["Votes"];
											$inivote++;
										}
									}
									echo "Vote : ".$inivote;
								}
								$sql = "UPDATE first_ict SET Votes=$inivote WHERE RollNo=$roll";
								
								if($conn->query($sql) === TRUE)
								{
									echo "Record Edited";
								}
								else
								{
									echo "Error";
								}
							}

							if(isset($_POST["fest"]))
							{
								echo "Name : ".$_POST['fest'];
								$roll=$_POST['fest'];

								$sql = "SELECT Votes,RollNo FROM first_ict";
								$result = $conn->query($sql);
								
								if ($result->num_rows > 0) 
								{
									while($row = $result->fetch_assoc()) 
									{		
										if($row["RollNo"]==$roll)
										{
											$inivote=$row["Votes"];
											$inivote++;
										}
									}
									echo "Vote : ".$inivote;
								}

								$sql = "UPDATE first_ict SET Votes=$inivote WHERE RollNo=$roll";

								if($conn->query($sql) === TRUE)
								{
									echo "Record Edited";
								}
								else
								{
									echo "Error";
								}
							}

							if(isset($_POST["placement"]))
							{
								echo "Name : ".$_POST['placement'];
								$roll=$_POST['placement'];

								$sql = "SELECT Votes,RollNo FROM first_ict";
								$result = $conn->query($sql);

								if ($result->num_rows > 0) 
								{
									while($row = $result->fetch_assoc()) 
									{		
										if($row["RollNo"]==$roll)
										{							
											$inivote=$row["Votes"];
											$inivote++;
										}
									}
									echo "Vote : ".$inivote;
								}
								$sql = "UPDATE first_ict SET Votes=$inivote WHERE RollNo=$roll";
					
								if($conn->query($sql) === TRUE)
								{
									echo "Record Edited";
								}
								else
								{
									echo "Error";
								}
							}

							if(isset($_POST["cr"]))
							{
								echo "Name : ".$_POST['cr'];
								$roll=$_POST['cr'];

								$sql = "SELECT Votes,RollNo FROM first_ict";
								$result = $conn->query($sql);

								if ($result->num_rows > 0) 
								{
									while($row = $result->fetch_assoc()) 
									{		
										if($row["RollNo"]==$roll)
										{
											$inivote=$row["Votes"];
											$inivote++;
										}
									}
									echo "Vote : ".$inivote;
								}

								$sql = "UPDATE first_ict SET Votes=$inivote WHERE RollNo=$roll";

								if($conn->query($sql) === TRUE)
								{
									echo "Record Edited";
								}
								else
								{
									echo "Error";
								}
							}

							if(isset($_POST["sports"]))
							{
								echo "Name : ".$_POST['sports'];
								$roll=$_POST['sports'];

								$sql = "SELECT Votes,RollNo FROM first_ict";
								$result = $conn->query($sql);

								if ($result->num_rows > 0) 
								{
									while($row = $result->fetch_assoc()) 
									{		
										if($row["RollNo"]==$roll)
										{
											$inivote=$row["Votes"];
											$inivote++;
										}
									}
									echo "Vote : ".$inivote;
								}
								$sql = "UPDATE first_ict SET Votes=$inivote WHERE RollNo=$roll";

								if($conn->query($sql) === TRUE)
								{
									echo "Record Edited";
								}
								else
								{
									echo "Error";
								}
							}
						}
					}
				}

				if($sys_year == $year)
				{
					if($branch == "02")
					{
						if(isset($_POST['submit']))
						{	
							if(isset($_POST["aca"]))
							{
								echo "Name : ".$_POST['aca'];
								$roll=$_POST['aca'];

								$sql = "SELECT Votes,RollNo FROM first_chem";
								$result = $conn->query($sql);

								if ($result->num_rows > 0) 
								{
									while($row = $result->fetch_assoc()) 
									{		
										if($row["RollNo"]==$roll)
										{							
											$inivote=$row["Votes"];
											$inivote++;
										}
									}
									echo "Vote : ".$inivote;
								}	
							
								$sql = "UPDATE first_chem SET Votes=$inivote WHERE RollNo=$roll";
							
								if($conn->query($sql) === TRUE)
								{
									echo "Record Edited";
								}
								else
								{
									echo "Error";
								}
							}

							if(isset($_POST["cult"]))
							{
								echo "Name : ".$_POST['cult'];
								$roll=$_POST['cult'];

								$sql = "SELECT Votes,RollNo FROM first_chem";
								$result = $conn->query($sql);

								if ($result->num_rows > 0) 
								{
									while($row = $result->fetch_assoc()) 
									{		
										if($row["RollNo"]==$roll)
										{							
											$inivote=$row["Votes"];
											$inivote++;
										}
									}
									echo "Vote : ".$inivote;
								}
	
								$sql = "UPDATE first_chem SET Votes=$inivote WHERE RollNo=$roll";
								
								if($conn->query($sql) === TRUE)
								{
									echo "Record Edited";
								}
								else
								{
									echo "Error";
								}
							}

							if(isset($_POST["fest"]))
							{
								echo "Name : ".$_POST['fest'];
								$roll=$_POST['fest'];

								$sql = "SELECT Votes,RollNo FROM first_chem";
								$result = $conn->query($sql);
		
								if ($result->num_rows > 0) 
								{
									while($row = $result->fetch_assoc()) 
									{		
										if($row["RollNo"]==$roll)
										{
											$inivote=$row["Votes"];
											$inivote++;
										}
									}
									echo "Vote : ".$inivote;
								}
								$sql = "UPDATE first_chem SET Votes=$inivote WHERE RollNo=$roll";
						
								if($conn->query($sql) === TRUE)
								{
									echo "Record Edited";
								}
								else
								{
									echo "Error";
								}
							}
							
							if(isset($_POST["placement"]))
							{
								echo "Name : ".$_POST['placement'];
								$roll=$_POST['placement'];

								$sql = "SELECT Votes,RollNo FROM first_chem";
								$result = $conn->query($sql);
								
								if ($result->num_rows > 0) 
								{
									while($row = $result->fetch_assoc()) 
									{		
										if($row["RollNo"]==$roll)
										{
											$inivote=$row["Votes"];
											$inivote++;
										}
									}
									echo "Vote : ".$inivote;
								}
								$sql = "UPDATE first_chem SET Votes=$inivote WHERE RollNo=$roll";
								
								if($conn->query($sql) === TRUE)
								{
									echo "Record Edited";
								}
								else
								{
									echo "Error";
								}
							}

							if(isset($_POST["cr"]))
							{
								echo "Name : ".$_POST['cr'];
								$roll=$_POST['cr'];

								$sql = "SELECT Votes,RollNo FROM first_chem";
								$result = $conn->query($sql);
								
								if ($result->num_rows > 0) 
								{
									while($row = $result->fetch_assoc()) 
									{		
										if($row["RollNo"]==$roll)
										{
							
											$inivote=$row["Votes"];
											$inivote++;
										}
									}
									echo "Vote : ".$inivote;
								}
								$sql = "UPDATE first_chem SET Votes=$inivote WHERE RollNo=$roll";
							
								if($conn->query($sql) === TRUE)
								{
									echo "Record Edited";
								}
								else
								{
									echo "Error";
								}
							}

							if(isset($_POST["sports"]))
							{
								echo "Name : ".$_POST['sports'];
								$roll=$_POST['sports'];

								$sql = "SELECT Votes,RollNo FROM first_chem";
								$result = $conn->query($sql);
								
								if ($result->num_rows > 0) 
								{
									while($row = $result->fetch_assoc()) 
									{		
										if($row["RollNo"]==$roll)
										{
											$inivote=$row["Votes"];
											$inivote++;
										}
									}
									echo "Vote : ".$inivote;
								}
								$sql = "UPDATE first_chem SET Votes=$inivote WHERE RollNo=$roll";
								
								if($conn->query($sql) === TRUE)
								{
									echo "Record Edited";
								}
								else
								{
									echo "Error";
								}
							}
						}
					}
				}
				
				if($sys_year == $year)	
				{
					if($branch == "03")
					{
						if(isset($_POST['submit']))
						{		
							if(isset($_POST["aca"]))
							{
								echo "Name : ".$_POST['aca'];
								$roll=$_POST['aca'];

								$sql = "SELECT Votes,RollNo FROM first_mech";
								$result = $conn->query($sql);
								
								if ($result->num_rows > 0) 
								{
									while($row = $result->fetch_assoc()) 
									{		
										if($row["RollNo"]==$roll)
										{
							
											$inivote=$row["Votes"];
											$inivote++;
										}
									}
									echo "Vote : ".$inivote;
								}
								$sql = "UPDATE first_mech SET Votes=$inivote WHERE RollNo=$roll";

								if($conn->query($sql) === TRUE)
								{
									echo "Record Edited";
								}
								else
								{
									echo "Error";
								}
							}
							
							if(isset($_POST["cult"]))
							{
								echo "Name : ".$_POST['cult'];
								$roll=$_POST['cult'];

								$sql = "SELECT Votes,RollNo FROM first_mech";
								$result = $conn->query($sql);
								
								if ($result->num_rows > 0) 
								{
									while($row = $result->fetch_assoc()) 
									{		
										if($row["RollNo"]==$roll)
										{
											$inivote=$row["Votes"];
											$inivote++;
										}
									}
									echo "Vote : ".$inivote;
								}
								$sql = "UPDATE first_mech SET Votes=$inivote WHERE RollNo=$roll";
								
								if($conn->query($sql) === TRUE)
								{
									echo "Record Edited";
								}
								else
								{
									echo "Error";
								}
							}

							if(isset($_POST["fest"]))
							{
								echo "Name : ".$_POST['fest'];
								$roll=$_POST['fest'];

								$sql = "SELECT Votes,RollNo FROM first_mech";
								$result = $conn->query($sql);
								
								if ($result->num_rows > 0) 
								{
									while($row = $result->fetch_assoc()) 
									{		
										if($row["RollNo"]==$roll)
										{
											$inivote=$row["Votes"];
											$inivote++;
										}
									}
									echo "Vote : ".$inivote;
								}

								$sql = "UPDATE first_mech SET Votes=$inivote WHERE RollNo=$roll";

								if($conn->query($sql) === TRUE)
								{
									echo "Record Edited";
								}
								else
								{
									echo "Error";
								}
							}

							if(isset($_POST["placement"]))
							{
								echo "Name : ".$_POST['placement'];
								$roll=$_POST['placement'];

								$sql = "SELECT Votes,RollNo FROM first_mech";
								$result = $conn->query($sql);

								if ($result->num_rows > 0) 
								{
									while($row = $result->fetch_assoc()) 
									{		
										if($row["RollNo"]==$roll)
										{							
											$inivote=$row["Votes"];
											$inivote++;
										}
									}
									echo "Vote : ".$inivote;
								}
								$sql = "UPDATE first_mech SET Votes=$inivote WHERE RollNo=$roll";
					
								if($conn->query($sql) === TRUE)
								{
									echo "Record Edited";
								}
								else
								{
									echo "Error";
								}
							}

							if(isset($_POST["cr"]))
							{
								echo "Name : ".$_POST['cr'];
								$roll=$_POST['cr'];

								$sql = "SELECT Votes,RollNo FROM first_mech";
								$result = $conn->query($sql);

								if ($result->num_rows > 0) 
								{
									while($row = $result->fetch_assoc()) 
									{		
										if($row["RollNo"]==$roll)
										{
											$inivote=$row["Votes"];
											$inivote++;
										}
									}
									echo "Vote : ".$inivote;
								}

								$sql = "UPDATE first_mech SET Votes=$inivote WHERE RollNo=$roll";

								if($conn->query($sql) === TRUE)
								{
									echo "Record Edited";
								}
								else
								{
									echo "Error";
								}
							}

							if(isset($_POST["sports"]))
							{
								echo "Name : ".$_POST['sports'];
								$roll=$_POST['sports'];

								$sql = "SELECT Votes,RollNo FROM first_mech";
								$result = $conn->query($sql);

								if ($result->num_rows > 0) 
								{
									while($row = $result->fetch_assoc()) 
									{		
										if($row["RollNo"]==$roll)
										{
											$inivote=$row["Votes"];
											$inivote++;
										}
									}
									echo "Vote : ".$inivote;
								}
								$sql = "UPDATE first_mech SET Votes=$inivote WHERE RollNo=$roll";

								if($conn->query($sql) === TRUE)
								{
									echo "Record Edited";
								}
								else
								{
									echo "Error";
								}
							}
						}
					}
				}
				$conn->close(); 
			?>
		</body>
</html>		