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

$sql = "select * from Kunde order by K_NR";
  $stmt = oci_parse($conn, $sql);
  oci_execute($stmt);
  
echo "<table align='center' width='100%' height='100%'>";
echo "<tr ><td align='center'>";
echo "<table align='center' class='table'>";

echo"<tr> <th colspan='10'><a href='k_neu_formular.php' target='rechts'><button class='button2' style='vertical-align:middle'><span>NEUE KUNDEN ANLEGEN</span></button></a></th></tr>";

echo"<tr><th>KUNDEN NR</th><th>TITEL</th><th>VORNAME</th><th>NACHNAME</th><th>GEBURTSDATUM</th><th>STRASSE</th><th>ORT</th><th>PLZ</th><th>LAND</th><th>AUSWAHL</th></tr>";

while($datensatz = oci_fetch_object($stmt))
{

echo"<tr align='center'>
<td><a href='kdetail_zeigen.php?kdnr=$datensatz->K_NR' target='rechts'><button class='button' style='vertical-align:middle'><span>$datensatz->K_NR</span></button></a> </td>
<td>$datensatz->TITEL</td>
<td>$datensatz->VORNAME</td>
<td>$datensatz->NACHNAME</td>
<td>$datensatz->GEBURTSDATUM</td>
<td>$datensatz->STRASSE</td>
<td>$datensatz->ORT</td>
<td>$datensatz->PLZ</td>
<td>$datensatz->LAND</td>
<td> <a href='k_loeschen.php?knr=$datensatz->K_NR' target='rechts'><button class='button' style='vertical-align:middle'><span>L&ouml;schen </span></button></a>
     <a href='k_update_formular.php?knr=$datensatz->K_NR&tt=$datensatz->TITEL&vn=$datensatz->VORNAME&nn=$datensatz->NACHNAME&geb=$datensatz->GEBURTSDATUM&str=$datensatz->STRASSE&ort=$datensatz->ORT&plz=$datensatz->PLZ&land=$datensatz->LAND' target='rechts'><button class='button' style='vertical-align:middle'><span>Update</span></button></a>";
}

echo"</table>";
echo"</td></tr>";
echo"</table>";

?>

</table>

</body>
</html>