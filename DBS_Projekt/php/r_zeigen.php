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
<title>
&copy; Hakan Kul :: mitarbeiter_zeigen.php
</title>

<link rel="stylesheet" href="../layout.css">
<style>
body{
	font-family: "Verdana";	
}
table {
    border-collapse: collapse;
    width: 90%;
	font-size:12pt;
	font-family: "Verdana";	
}

th, td {
    padding: 8px;
}

tr:nth-child(even){background-color: #f2f2f2}

th {
    background-color: gray;
    color: white;
}
			

.button {
		  display: inline-block;
		  background-color: grey;
		  border: none;
		  color: #ffffff;
		  text-align: center;
		  font-size: 12px;
		  padding: 5px;
		  width: 60px;
		  transition: all 0.5s;
		  cursor: pointer;
		  margin: 5px;
		}

		.button span {
		  cursor: pointer;
		  display: inline-block;
		  position: relative;
		  transition: 0.5s;
		}

		.button:hover span {
		  padding: 0px;
		}

		.button:hover span:after {
		  opacity: 1;
		  right: 3;
		}
</style>
</head>
<body>


<?php

$sql = "select * from Rechnung order by R_NR";
  $stmt = oci_parse($conn, $sql);
  oci_execute($stmt);

echo "<table align='center' width='100%' height='100%'>";
echo "<tr><td align='center'>";
echo "<table align='center' class='table'>";

echo"<tr align='center'><th>RECHNUNG NR</th><th>BESTELLUNG NR</th><th>DATUM</th><th>ANZAHL PRODUKTE</th><th>PREIS NETTO</th><th>GESAMTPREIS</th><th>AUSWAHL</th></tr>";

while($datensatz = oci_fetch_object($stmt))
{

echo"<tr align='center'>
<td><a href='rkundedetail_zeigen.php?rknr=$datensatz->BESTELLUNG_NR' target='rechts'><button class='button' style='vertical-align:middle'><span>$datensatz->R_NR</span></button></a>  </td>
<td><a href='rkunde_zeigen.php?rknr=$datensatz->BESTELLUNG_NR' target='rechts'><button class='button' style='vertical-align:middle'><span>$datensatz->BESTELLUNG_NR</span></button></a> </td>
<td>$datensatz->DATUM</td>
<td><a href='pkunde_zeigen.php?pknr=$datensatz->BESTELLUNG_NR' target='rechts'><button class='button' style='vertical-align:middle'><span>$datensatz->ANZAHL_PRODUKTE</span></button></a> </td>
<td>$datensatz->PREIS_NETTO €</td>
<td>$datensatz->GESAMTPREIS €</td>
<td> <a href='r_update_formular.php?knr=$datensatz->R_NR&tt=$datensatz->DATUM&vn=$datensatz->PREIS_NETTO&nn=$datensatz->GESAMTPREIS' target='rechts'><button class='button' style='vertical-align:middle'><span>Update</span></button></a>
</tr>";
}

echo"</table>";
echo"</td></tr>";
echo"</table>";

?>

</table>

</body>
</html>