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
&copy; Hakan Kul :: p_neu_formular.php
</title>

<script type="text/javascript"> 
  function pruefen()
  {
  t1= document.eingabe.tt.value;
  t3= document.eingabe.nn.value;
  t4= document.eingabe.geb.value;
  t5= document.eingabe.ort.value;


  if(t1=="")
  {
	meldung="Sie haben keine Lager Nummer eingegeben";
	alert(meldung);
	document.eingabe.tt.focus();
  return false;
  }

  if(t3=="")
  {
  meldung="Sie haben keine Marke eingegeben";
  alert(meldung);
  document.eingabe.nn.focus();
  return false;
  }
  if(t4=="")
  {
  meldung="Sie haben kein Modell eingegeben";
  alert(meldung);
  document.eingabe.geb.focus();
  return false;
  }
  
  if(t5=="")
  {
  meldung="Sie haben keinen Brutto Preis eingegeben";
  alert(meldung);
  document.eingabe.ort.focus();
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

<h3 align="center" >PRODUKTE ERFASSEN</h3>


<form name="eingabe" action="p_insert.php" method="POST" onsubmit='return pruefen()'>

<?php

echo"
<div>

    <label for='titel'>LAGER NR</label>
    <input type='text'  name='tt' placeholder='Lager Nr'>
	
	<label for='vname'>KATEGORIE</label>
    <input type='text' name='vn' placeholder='Kagegorie'>

    <label for='nname'>MARKE</label>
    <input type='text' name='nn' placeholder='Marke'>
	
	<label for='gdat'>MODELL</label>
    <input type='text' name='geb' placeholder='Modell'>
	
	<label for='str'>PREIS_NETTO</label>
    <input type='text' name='str' placeholder='Preis Netto'>
	
	<label for='ort'>PRIS_BRUTTO</label>
    <input type='text' name='ort' placeholder='Preis Brutto'>
  
    <input type='submit' value='Insert'>

</div>
";
?>

</form>
</body>
</html>
