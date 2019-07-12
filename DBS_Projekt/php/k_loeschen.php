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
&copy; Hakan Kul :: k_loeschen.php
</title>

<link rel="stylesheet" type="text/css" href="../css/format_neu.css">

</head>
<body>

<?php

$k_id=($_GET['knr']);

$sql = "Delete From Kunde Where K_NR='$k_id'";
  $stmt = oci_parse($conn, $sql);
  oci_execute($stmt);

include("k_zeigen.php");
?>

</table>

</body>
</html>


