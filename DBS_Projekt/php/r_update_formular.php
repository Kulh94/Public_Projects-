<?php
  $user = 'a01563490';
  $pass = '1214hf';
  $database = 'lab';
 
  // establish database connection
  $conn = oci_connect($user, $pass, $database);
  if (!$conn) exit;
?>

<html>
<head>

<style>
body{
	font-family: "Verdana";	
}

input[type=text], select {
    width: 100%;
    padding: 12px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 1px solid #ccc;
    border-radius: 4px;
    box-sizing: border-box;
}

input[type=text] {
    width: 100%;
    padding: 12px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 1px solid #ccc;
    box-sizing: border-box;
}

input[type=submit] {
    width: 100%;
    background-color: gray;
    color: white;
    padding: 14px 20px;
    margin: 8px 0;
    border: none;
    cursor: pointer;
}


div {
    border-radius: 5px;
    background-color: #f2f2f2;
    padding: 20px;
}
</style>
</head>
<body>

<h3 align="center" >RECHNUNG EDITIEREN</h3>


<form name="eingabe" action="r_update.php" method="POST">

<?php

$k_id=$_GET["knr"];
$titel=$_GET["tt"];
$vname=$_GET["vn"];
$nname=$_GET["nn"];


echo"
<div>

    <label for='titel'>DATUM</label>
	<input type='text' name='tt' value='$titel' placeholder='Format: 01-Jan-2018'>
	 
	<label for='vname'>PREIS NETTO</label>
    <input type='text' name='vn' value='$vname'>
	
	<label for='titel'>GESAMTPREIS</label>
	<input type='text' name='nn' value='$nname'>
	<input type='hidden' name='knr' value='$k_id'>
  
    <input type='submit' value='Update'>

</div>
";
?>

</form>
</body>
</html>
