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



$sql = "Update Bestellung Set Zahlungsart='$titel', Datum='$vname' Where B_NR='$k_id'";
  $stmt = oci_parse($conn, $sql);
  oci_execute($stmt);

include("b_zeigen.php");
?>

</table>

</body>
</html>


