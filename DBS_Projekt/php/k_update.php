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
&copy; Hakan Kul :: k_update.php
</title>


</head>
<body>

<?php

$k_id=$_POST["knr"];
$titel=$_POST["tt"];
$vname=$_POST["vn"];
$nname=$_POST["nn"];
$geb=$_POST["geb"];
$str=$_POST["str"];
$ort=$_POST["ort"];
$plz=$_POST["plz"];
$land=$_POST["land"];

$sql = "Update Kunde Set Titel='$titel', Vorname='$vname', Nachname='$nname', Geburtsdatum='$geb', Strasse='$str', Ort='$ort', Plz='$plz', Land='$land' Where K_NR='$k_id'";
  $stmt = oci_parse($conn, $sql);
  oci_execute($stmt);

include("k_zeigen.php");
?>

</table>

</body>
</html>


