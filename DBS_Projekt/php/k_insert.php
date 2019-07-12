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
&copy; Hakan Kul :: k_insert.php
</title>


</head>
<body>

<?php

$titel=$_POST["tt"];
$vname=$_POST["vn"];
$nname=$_POST["nn"];
$geb=$_POST["geb"];
$str=$_POST["str"];
$ort=$_POST["ort"];
$plz=$_POST["plz"];
$land=$_POST["land"];

$sql = "Insert Into Kunde (Titel, Vorname, Nachname, Geburtsdatum, Strasse, Ort, PLZ, Land ) Values('$titel','$vname','$nname','$geb','$str','$ort','$plz','$land')";
  $stmt = oci_parse($conn, $sql);
  oci_execute($stmt);

include("k_zeigen.php");
?>

</table>

</body>
</html>


