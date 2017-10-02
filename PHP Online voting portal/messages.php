<?php

require_once 'connect1.php';

global $con;

if(!$con)
{
	die('Could not Connect!'.mysqli_error());
}

else
{
	$sql = "SELECT * FROM messages ORDER BY id DESC";
	$result = mysqli_query($con, $sql);
	
	$response = array();
	$response['success'] = FALSE;
	$messages=array();
	
	while($row = mysqli_fetch_array($result))
	{
		array_push($messages, 
		array(
		'temp_id'=>$row[1],
		'temp_message'=>$row[2],
		'temp_person'=>$row[3],
		'temp_mobile'=>$row[4])
		);
		
		$response['success'] = TRUE;
		
		$response['messageData']=$messages;
	}
	
	echo json_encode($response);
}

?>	