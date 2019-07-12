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
		
		.button2 {
		  display: inline-block;
		  background-color: grey;
		  border: none;
		  color: #ffffff;
		  text-align: center;
		  font-size: 14px;
		  font-weight: bold;
		  padding: 5px;
		  width: 300px;
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

$sql = "select * from Bestellung order by B_NR";
  $stmt = oci_parse($conn, $sql);
  oci_execute($stmt);

echo "<table  align='center' width='100%' height='100%'>";
echo "<tr><td align='center'>";
echo "<table align='center' class='table'>";


echo"<tr><th>BESTELLUNG NR</th><th>KUNDEN NR</th><th>ZAHLUNGSART</th><th>DATUM</th><th>AUSWAHL</th></tr>";

while($datensatz = oci_fetch_object($stmt))
{

echo"<tr align='center'>
<td><a href='rkunde_zeigen.php?rknr=$datensatz->B_NR' target='rechts'><button class='button' style='vertical-align:middle'><span>$datensatz->B_NR</span></button></a> </td>
<td><a href='kdetail_zeigen.php?kdnr=$datensatz->KUNDEN_NR' target='rechts'><button class='button' style='vertical-align:middle'><span>$datensatz->KUNDEN_NR</span></button></a></td>
<td>$datensatz->ZAHLUNGSART</td>
<td>$datensatz->DATUM</td>
<td> <a href='b_loeschen.php?bnr=$datensatz->B_NR' target='rechts'><button class='button' style='vertical-align:middle'><span>L&ouml;schen</span></button></a>
     <a href='b_update_formular.php?knr=$datensatz->B_NR&tt=$datensatz->ZAHLUNGSART&vn=$datensatz->DATUM' target='rechts'><button class='button' style='vertical-align:middle'><span>Update</span></button></a></td>";
}

echo"</table>";
echo"</td></tr>";
echo"</table>";

?>

</table>

</body>
</html>