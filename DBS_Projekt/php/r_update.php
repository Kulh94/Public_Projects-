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
&copy; Hakan Kul :: b_update.php
</title>


</head>
<body>

<?php

$k_id=$_POST["knr"];
$titel=$_POST["tt"];
$vname=$_POST["vn"];
$nname=$_POST["nn"];



$sql = "Update Rechnung Set Datum='$titel', Preis_Netto='$vname', Gesamtpreis='$nname' Where R_NR='$k_id'";
  $stmt = oci_parse($conn, $sql);
  oci_execute($stmt);

include("r_zeigen.php");
?>

</table>

</body>
</html>


