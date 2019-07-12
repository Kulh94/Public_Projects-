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
&copy; Hakan Kul :: m_loeschen.php
</title>

<link rel="stylesheet" type="text/css" href="../css/format_neu.css">

</head>
<body>

<?php

$m_id=($_GET['mnr']);

$sql = "Delete From Mitarbeiter Where M_NR='$m_id'";
  $stmt = oci_parse($conn, $sql);
  oci_execute($stmt);

include("m_zeigen.php");
?>

</table>

</body>
</html>


