<?php
require 'core.inc.php';
if (loggedin()) {
    header('Location: vote.php');
} else {
    include 'login.php';
}
?>