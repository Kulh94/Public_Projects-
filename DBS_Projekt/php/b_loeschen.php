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
&copy; Hakan Kul :: b_loeschen.php
</title>

<link rel="stylesheet" type="text/css" href="../css/format_neu.css">

</head>
<body>

<?php

$b_id=($_GET['bnr']);

$sql = "Delete From Bestellung Where B_NR='$b_id'";
  $stmt = oci_parse($conn, $sql);
  oci_execute($stmt);

include("b_zeigen.php");
?>

</table>

</body>
</html>


