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
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>
&copy; Hakan Kul :: mitarbeiter_zeigen.php
</title>

<script type="text/javascript"> 
  function pruefen()
  {
  t1= document.eingabe.vn.value;
  t2= document.eingabe.nn.value;
  t3= document.eingabe.geb.value;
  t4= document.eingabe.str.value;
  t5= document.eingabe.ort.value;
  t6= document.eingabe.plz.value;
  t7= document.eingabe.land.value;
  if(t1=="")
  {
	meldung="Sie haben keinen Vornamen eingegeben";
	alert(meldung);
	document.eingabe.vn.focus();
  return false;
  }
  if(t2=="")
  {
  meldung="Sie haben keinen Familiennamen eingegeben";
  alert(meldung);
  document.eingabe.nn.focus();
  return false;
  }
  if(t3=="")
  {
  meldung="Sie haben kein Geburtsdatum eingegeben";
  alert(meldung);
  document.eingabe.geb.focus();
  return false;
  }
  if(t4=="")
  {
  meldung="Sie haben keine Strasse eingegeben";
  alert(meldung);
  document.eingabe.str.focus();
  return false;
  }
  
  if(t5=="")
  {
  meldung="Sie haben keinen Ort eingegeben";
  alert(meldung);
  document.eingabe.ort.focus();
  return false;
  }
  if(t6=="")
  {
  meldung="Sie haben keine PLZ eingegeben";
  alert(meldung);
  document.eingabe.plz.focus();
  return false;
  }
  if(t7=="")
  {
  meldung="Sie haben kein Land eingegeben";
  alert(meldung);
  document.eingabe.land.focus();
  return false;
  }
 
  }
  </script>

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

</head>
<body onLoad="document.eingabe.tt.focus()">

<h3 align="center" >KUNDEN ERFASSEN</h3>


<form name="eingabe" action="k_insert.php" method="POST" onsubmit='return pruefen()'>

<?php

echo"
<div>

    <label for='titel'>TITEL</label>
    <input type='text'  name='tt' placeholder='Titel'>
	
	<label for='vname'>VORNAME</label>
    <input type='text' name='vn' placeholder='Vorname'>

    <label for='nname'>NACHNAME</label>
    <input type='text' name='nn' placeholder='Nachname'>
	
	<label for='gdat'>GEBURTSDATUM</label>
    <input type='text' name='geb' placeholder='bsp. 01-Jan-2018'>
	
	<label for='str'>STRASSE</label>
    <input type='text' name='str' placeholder='Strasse'>
	
	<label for='ort'>ORT</label>
    <input type='text' name='ort' placeholder='Ort'>
	
	<label for='plz'>PLZ</label>
    <input type='text' name='plz' placeholder='Plz'>
	
	<label for='land'>LAND</label>
    <input type='text' name='land' placeholder='Land'>
  
    <input type='submit' value='Insert'>

</div>
";
?>

</form>
</body>
</html>
