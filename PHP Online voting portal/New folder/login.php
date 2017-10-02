<?php

require_once 'connect.php';

global $con;

if(!$con)
{
	die('Could not Connect!'.mysqli_error());
}

else
{

	$username='priya100';
	$password_enter='summerschool100';
	
	$response = array();
	$sql = "SELECT full_name FROM user_info WHERE user_name = '$username' AND password='$password'";
	
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