<?php

require_once 'connect1.php';

global $con;

if(!$con)
{
	die('Could not Connect!'.mysqli_error());
}

else
{

	$username=$_POST['user_name'];
	$password_enter=$_POST['password'];
	
	$response = array();
	$sql = "SELECT full_name FROM user_info WHERE user_name = '$username' AND password='$password'";
	
	$result = mysqli_query($con, $sql);
	
	if(isset($result))
	{
		$response['success'] == TRUE;
		$response['message'] = 'Registered';
		$check = mysqli_fetch_array($result);
		
		$response['full_name']= $check['full_name'];
	}
	
	else
	{
		$response['success'] = FALSE;
		$response['message'] = 'Not Registered';
	}
	
	echo json_encode($response);
}

?>