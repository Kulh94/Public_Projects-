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
&copy; Hakan Kul :: p_update.php
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


$sql = "Update Produkt Set Lager_Nr='$titel', Kategorie='$vname', Marke='$nname', Modell='$geb', Preis_Brutto='$str', Preis_Netto='$ort' Where P_NR='$k_id'";
  $stmt = oci_parse($conn, $sql);
  oci_execute($stmt);

include("p_zeigen.php");
?>

</table>

</body>
</html>


