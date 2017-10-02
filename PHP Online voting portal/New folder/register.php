<?php

require_once 'connect.php';

global $con;

if(!$con)
{
	die('Could not Connect!'.mysqli_error());
}

else
{
	$fullname='Priya';
	$emailid='pr.mehta1@gmail.com';
	$username='priya100';
	$password_enter='summerschool100';
	
	$response = array();
	$sql = "INSERT INTO user_info(full_name, email, user_name, password) VALUES ('$fullname', '$emailid', '$username', '$password_enter')";
	
	$result = mysqli_query($con, $sql);
	
	if(isset($result))
	{
		$response['success'] == TRUE;
		$response['message'] = 'Registered';
	}
	
	else
	{
		$response['success'] = FALSE;
		$response['message'] = 'Not Registered';
	}
	
	echo json_encode($response);
}

?>