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
&copy; Hakan Kul :: b_insert.php
</title>


</head>
<body>

<?php

$titel=$_POST["tt"];
$vname=$_POST["vn"];
$nname=$_POST["nn"];



$sql = "Insert Into Bestellung (Kunden_Nr, Zahlungsart, Datum) Values('$titel','$vname','$nname')";
  $stmt = oci_parse($conn, $sql);
  oci_execute($stmt);

  
include("b_zeigen.php");
?>

</table>

</body>
</html>


