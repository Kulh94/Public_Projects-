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
.menu
{
border-radius:14px 14px 8px 8px;
border-bottom:2px solid #000000;
border-top:20px outset #ffcccc;
background-color:rgb(153,204,255);
color:rgb(0,51,51);
text-align:left;
vertical-align:top;
padding:10px;
}

  .table {
	font-size:12pt;
	font-family: "Verdana";	
	
	
}
  .zeile {
		
	border-style: solid;
	padding: 5px;
	font-size: 12pt;
	font-style: bold;
	
}

.button {
		  display: inline-block;
		  border-radius: 4px;
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

$sql = "select * from Mitarbeiter order by M_NR";
  $stmt = oci_parse($conn, $sql);
  oci_execute($stmt);

echo "<table width='100%' height='100%'>";
echo "<tr><td align='center'>";
echo "<table class='table'>";

echo"<tr class='zeile'><td>Mitarbeiter Nr</td><td>Chef Nr</td><td>Titel</td><td>Vorname</td><td>Nachname</td><td>Geburtsdatum</td><td>Einstellungsdatum</td><td>Strasse</td><td>Ort</td><td>PLZ</td><td>Auswahl</td></tr>";

while($datensatz = oci_fetch_object($stmt))
{

echo"<tr class='zeile'>
<td>$datensatz->M_NR</td>
<td>$datensatz->CHEF_MNR</td>
<td>$datensatz->TITEL</td>
<td>$datensatz->VORNAME</td>
<td>$datensatz->NACHNAME</td>
<td>$datensatz->GEBURTSDATUM</td>
<td>$datensatz->EINSTELLUNGSDATUM</td>
<td>$datensatz->STRASSE</td>
<td>$datensatz->ORT</td>
<td>$datensatz->PLZ</td>
<td> <a href='m_loeschen.php?mnr=$datensatz->M_NR' target='rechts'><button class='button' style='vertical-align:middle'><span>L&ouml;schen </span></button></a>";
}

echo"</table>";
echo"</td></tr>";
echo"</table>";

?>

</table>

</body>
</html>