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

<h3 align="center">LAGER</h3>

<?php
$l_id=($_GET['lnr']);



$sql = "select lager.l_nr, lager.kapatzitaet, lager.strasse, lager.plz, lager.ort, produkt.p_nr, produkt.kategorie, produkt.marke, produkt.modell, produkt.preis_brutto from lager right outer join produkt on lager.l_nr = produkt.lager_nr where  produkt.lager_nr='$l_id'";
  $stmt = oci_parse($conn, $sql);
  oci_execute($stmt);

echo "<table align='center' width='100%' height='100%'>";
echo "<tr><td align='center'>";
echo "<table align='center' class='table'>";

echo"<tr><th>LAGER NR</th><th>KAPAZITAET</th><th>STRASSE</th><th>PLZ</th><th>ORT</th><th>PRODUKT NR</th><th>KATEGORIE</th><th>MARKE</th><th>MODELL</th><th>PREIS BRUTTO</th><th>AUSWAHL</th></tr>";

while($datensatz = oci_fetch_object($stmt))
{

echo"<tr align='center'>
<td>$datensatz->L_NR</td>
<td>$datensatz->KAPATZITAET</td>
<td>$datensatz->STRASSE</td>
<td>$datensatz->PLZ</td>
<td>$datensatz->ORT</td>
<td>$datensatz->P_NR</td>
<td>$datensatz->KATEGORIE</td>
<td>$datensatz->MARKE</td>
<td>$datensatz->MODELL</td>
<td>$datensatz->PREIS_BRUTTO €</td>
<td> <a href='p_loeschen.php?pnr=$datensatz->P_NR' target='rechts'><button class='button' style='vertical-align:middle'><span>L&ouml;schen </span></button></a>";
}

echo"</table>";
echo"</td></tr>";
echo"</table>";

?>

</table>

</body>
</html>