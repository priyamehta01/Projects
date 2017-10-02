<?php

define ('HOST_NAME', 'mysql.hostinger.in');
define ('USER_NAME', 'u584225544_priya');
define ('PASSWORD', 'priyameet');
define ('DATABASE', 'u584225544_ieee');

$con=mysqli_connect(HOST_NAME, USER_NAME, PASSWORD, DATABASE);

if(!$con)
{
	die('Could not Connect!'.mysqli_error());
	
}

?>