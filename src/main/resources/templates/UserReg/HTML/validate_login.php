<?php

// Grab User submitted information
$user_n = $_POST["user_name"];
$pass = $_POST["password"];


$mysqli = new mysqli("localhost","root","","hostel");
// Check connection
if ($mysqli -> connect_errno) {
  echo "Failed to connect to MySQL: " . $mysqli -> connect_error;
  exit();
}

// Perform query
  $result = $mysqli -> query("SELECT * FROM users");
  $row = mysqli_fetch_array($result, MYSQLI_ASSOC);
  
  if($row["username"] == $user_n && $row["password"]== $pass ){
	  printf ("Success");
	 // include 'C:/xampp/htdocs/SIBA DIGITAL HOSTEL/dashboard.html';
  }
  else{
	   printf ("Failed");
  }
  
  
  $result -> free_result();


$mysqli -> close();
?>
?>