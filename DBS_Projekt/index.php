
<!DOCTYPE html>
<html lang="en">
<head>
<title>&copy; Hakan Kul</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="layout.css">

<script type="text/javascript"> 
  function pruefen()
  {
  t1= document.suche.s.value;



  if(t1=="")
  {
	meldung="Sie haben im Suchfeld nichts eingegeben";
	alert(meldung);
	document.suche.s.focus();
  return false;
  }
  
  }
  </script>
<style>
* {
    box-sizing: border-box;
}

body {
  margin: 0;
  font-family: "Verdana";
}

/* Style the top navigation bar */
.topnav {
    overflow: hidden;
    background-color: #333;
}

/* Style the topnav links */
.topnav a {
    float: left;
    display: block;
    color: #f2f2f2;
    text-align: center;
    padding: 14px 16px;
    text-decoration: none;
}

/* Change color on hover */
.topnav a:hover {
    background-color: #ddd;
    color: black;
  
}

/* Style the content */
.content {
    background-color: #ddd;
    padding: 10px;
    height: 700px;

}

/* Style the footer */
.footer {
    background-color: #f1f1f1;
    padding: 10px;
   
}

.topnav a.active {
  background-color: gray;
  color: white;
}

.topnav .search-container {
  float: right;
}

.topnav input[type=text] {
  padding: 6px;
  margin-top: 8px;
  font-size: 17px;
  border: none;
}

.topnav .search-container button {
  float: right;
  padding: 6px 10px;
  margin-top: 8px;
  margin-right: 16px;
  background: #ddd;
  font-size: 17px;
  border: none;
  cursor: pointer;
}

.topnav .search-container button:hover {
  background: #ccc;
}

@media screen and (max-width: 600px) {
  .topnav .search-container {
    float: none;
  }
  .topnav a, .topnav input[type=text], .topnav .search-container button {
    float: none;
    display: block;
    text-align: left;
    width: 100%;
    margin: 0;
    padding: 14px;
  }
  .topnav input[type=text] {
    border: 1px solid #ccc;  
  }
}

</style>
</head>
<body>

		
			
				<div class="topnav">
				<a class="active" href="php/start.php" target="rechts" >HOME</button></a>
				<a href="php/k_zeigen.php" target="rechts" >KUNDEN </a>
				<a href="php/pa_zeigen.php" target="rechts" >PRODUKTE </a>
				<a href="php/b_zeigen.php" target="rechts" >BESTELLUNGEN </a>
				<a href="php/r_zeigen.php" target="rechts" >RECHNUNGEN </a>
				<div class="search-container">
				<form name="suche" action="php/suche.php" target="rechts" method="POST" onsubmit="return pruefen()">
				  <input type="text" id="search" name="s" placeholder="Suche Kunde: Nachname">
				  <button type="submit">LOS</button>
				</form>
				</div>
			

				</div>
			
				<div class="content">
					
					<iframe  name="rechts" width="100%" height="100%" frameBorder="0" scrolling="auto" src="php/start.php">																																																	>
					</iframe>
					
				</div>
				
				<div class="footer" align="center">
					&copy; Hakan Kul
				</div>

</body>
</html>
