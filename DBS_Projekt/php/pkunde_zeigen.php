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

<h3 align="center">PRODUKTE</h3>

<?php

$pk_id=($_GET['pknr']);

$sql = "select p.p_nr, p.lager_nr, p.kategorie, p.marke, p.modell, p.preis_netto, p.preis_brutto  from rechnung r join umfasst u on (r.bestellung_nr=u.b_nr) join produkt p on (u.p_nr=p.p_nr)  where u.b_nr='$pk_id'";
  $stmt = oci_parse($conn, $sql);
  oci_execute($stmt);

echo "<table  align='center' width='100%' height='100%'>";
echo "<tr><td align='center'>";
echo "<table align='center' class='table'>";

echo"<tr><th>PRODUKT NR</th><th>LAGER NR</th><th>MARKE</th><th>MODELL</th><th>PREIS NETTO</th><th>PREIS BRUTTO</th><th>AUSWAHL</th></tr>";

while($datensatz = oci_fetch_object($stmt))
{

echo"<tr align='center'>
<td><a href='pdetail_zeigen.php?pdnr=$datensatz->P_NR' target='rechts'><button class='button' style='vertical-align:middle'><span>$datensatz->P_NR</span></button></a> </td>
<td>$datensatz->LAGER_NR</td>
<td>$datensatz->MARKE</td>
<td>$datensatz->MODELL</td>
<td>$datensatz->PREIS_NETTO €</td>
<td>$datensatz->PREIS_BRUTTO €</td>
<td> <a href='p_loeschen.php?pnr=$datensatz->P_NR' target='rechts'><button class='button' style='vertical-align:middle'><span>L&ouml;schen </span></button></a>
     <a href='p_update_formular.php?knr=$datensatz->P_NR&tt=$datensatz->LAGER_NR&vn=$datensatz->KATEGORIE&nn=$datensatz->MARKE&geb=$datensatz->MODELL&str=$datensatz->PREIS_BRUTTO&ort=$datensatz->PREIS_NETTO' target='rechts'><button class='button' style='vertical-align:middle'><span>Update</span></button></a></td>

";
}

echo"</table>";
echo"</td></tr>";
echo"</table>";

?>

</table>

</body>
</html>