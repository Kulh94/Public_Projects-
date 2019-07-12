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
&copy; Hakan Kul :: p_loeschen.php
</title>

<link rel="stylesheet" type="text/css" href="../css/format_neu.css">

</head>
<body>

<?php

$p_id=($_GET['pnr']);

$sql = "Delete From Produkt Where P_NR='$p_id'";
  $stmt = oci_parse($conn, $sql);
  oci_execute($stmt);

include("p_zeigen.php");
?>

</table>

</body>
</html>


