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
<script type="text/javascript"> 
  function pruefen()
  {
  t1= document.eingabe.tt.value;

  if(t1>5)
  {
	meldung="Lager Nummer existiert nicht! Max: 5";
	alert(meldung);
	document.eingabe.vn.focus();
  return false;
  }
 
  }
  </script>

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

<h3 align="center" >PRODUKTDATEN EDITIEREN</h3>


<form name="eingabe" action="p_update.php" method="POST" onsubmit='return pruefen()'>

<?php

$k_id=$_GET["knr"];
$titel=$_GET["tt"];
$vname=$_GET["vn"];
$nname=$_GET["nn"];
$geb=$_GET["geb"];
$str=$_GET["str"];
$ort=$_GET["ort"];

echo"
<div>

    <label for='titel'>LAGER NR</label>
	<input type='text' name='tt' value='$titel'>
	 
	<label for='vname'>KATEGORIE</label>
    <input type='text' name='vn' value='$vname'>

    <label for='nname'>MARKE</label>
    <input type='text' name='nn' value='$nname'>
	
	<label for='gdat'>MODELL</label>
    <input type='text' name='geb' value='$geb'>
	
	<label for='str'>PREIS_BRUTTO</label>
    <input type='text' name='str' value='$str'>
	
	<label for='ort'>PREIS_NETTO</label>
    <input type='text' name='ort' value='$ort'>
	<input type='hidden' name='knr' value='$k_id'>
  
    <input type='submit' value='Update'>

</div>
";
?>

</form>
</body>
</html>
