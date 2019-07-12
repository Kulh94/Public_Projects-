<?php
  $user = 'a01563490';
  $pass = '1214hf';
  $database = 'lab';
 
  // establish database connection
  $conn = oci_connect($user, $pass, $database);
  if (!$conn) exit;
?>

<html>
<style>
body{
	font-family: "Verdana";	
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
<body>

<h3 align="center" >KUNDENDATEN EDITIEREN</h3>


<form name="eingabe" action="k_update.php" method="POST">

<?php

$k_id=$_GET["knr"];
$titel=$_GET["tt"];
$vname=$_GET["vn"];
$nname=$_GET["nn"];
$geb=$_GET["geb"];
$str=$_GET["str"];
$ort=$_GET["ort"];
$plz=$_GET["plz"];
$land=$_GET["land"];
echo"
<div>

    <label for='titel'>TITEL</label>
    <input type='text'  name='tt' value='$titel'>
	
	<label for='vname'>VORNAME</label>
    <input type='text' name='vn' value='$vname'>

    <label for='nname'>NACHNAME</label>
    <input type='text' name='nn' value='$nname'>
	
	<label for='gdat'>GEBURTSDATUM</label>
    <input type='text' name='geb' value='$geb' placeholder='bsp. 01-Jan-2018'>
	
	<label for='str'>STRASSE</label>
    <input type='text' name='str' value='$str'>
	
	<label for='ort'>ORT</label>
    <input type='text' name='ort' value='$ort'>
	
	<label for='plz'>PLZ</label>
    <input type='text' name='plz' value='$plz'>
	
	<label for='land'>LAND</label>
    <input type='text' name='land' value='$land'>
	<input type='hidden' name='knr' value='$k_id'>
  
    <input type='submit' value='Update'>

</div>
";
?>

</form>
</body>
</html>
