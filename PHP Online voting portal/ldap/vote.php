<?php
require 'core.inc.php';

if (loggedin()) {
    $roll = $_SESSION['user_id'];
} else {
    header('Location: index.php');
}

echo "Welcome: ".$roll." you have successfully logged in.";
echo "<br/><a href=\"logout.php\">Logout</a>";
?>