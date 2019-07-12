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
&copy; Hakan Kul :: b_neu_formular.php
</title>

<script type="text/javascript"> 
  function pruefen()
  {
  t1= document.eingabe.tt.value;
  t3= document.eingabe.nn.value;



  if(t1=="")
  {
	meldung="Sie haben keine Kunden Nummer eingegeben";
	alert(meldung);
	document.eingabe.tt.focus();
  return false;
  }

  if(t3=="")
  {
  meldung="Sie haben kein Datum eingegeben";
  alert(meldung);
  document.eingabe.nn.focus();
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
<body onLoad="document.eingabe.tt.focus()">

<h3 align="center" >BESTELLUNG ERFASSEN</h3>


<form name="eingabe" action="b_insert.php" method="POST" onsubmit='return pruefen()'>

<?php




echo"

<div>

    <label for='titel'>KUNDEN NR</label>
    <input type='text'  name='tt' placeholder='Kunden Nr'>";
	
	  $sql="select kategorie, marke, modell from Produkt order by P_Nr";
$stmt=oci_parse($conn, $sql);
 oci_execute($stmt);
echo"
<td>";
echo"
<label for='pk'>PRODUKTE</label>
<select name='pk'>";
while($row_t=oci_fetch_object($stmt))
{
echo"<option value='$row_t->P_NR'>$row_t->KATEGORIE $row_t->MARKE $row_t->MODELL</option>"; 
}
echo"
</select> 
</td>";
echo"	
	<label for='vname'>ZAHLUNGSART</label>
    <input type='text' name='vn' placeholder='Zahlungsart: Sofortüberweisung Rechnung Nachname Paypal Vorauskasse'>

    <label for='nname'>DATUM</label>
    <input type='text' name='nn' placeholder='Format: 01-Jan-2018'>
  
    <input type='submit' value='Insert'>

</div>
";
?>

</form>
</body>
</html>
