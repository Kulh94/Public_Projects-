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
&copy; Hakan Kul :: pa_zeigen.php
</title>

<link rel="stylesheet" href="../layout.css">

</head>
<body>

<?php


echo "<table width='100%' height='100%'>";
echo "<tr><td align='center'>";
echo "<table class='table'>";

echo"<tr><td><a href='p_zeigen.php'><img src='../images/auswahl_alles.jpg' width='800px' /></a></td></tr>";

echo"
<tr>
	<td><a href='notebook_zeigen.php'><img src='../images/auswahl_notebook.jpg' width='155' /></a>
	<a href='drucker_zeigen.php'><img src='../images/auswahl_drucker.jpg' width='155px' /></a>
	<a href='tablet_zeigen.php'><img src='../images/auswahl_tablets.jpg' width='155px' /></a>
	<a href='pc_zeigen.php'><img src='../images/auswahl_pc.jpg' width='155px' /></a>
	<a href='smartphone_zeigen.php'><img src='../images/auswahl_smartphoes.jpg' width='155px' /></a></td>
";

echo"</table>";
echo"</td></tr>";
echo"</table>";

?>

</table>

</body>
</html>