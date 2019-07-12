import java.sql.*;
import oracle.jdbc.driver.*;
import java.util.Random;
import java.nio.charset.Charset;
import java.lang.Object;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;
import java.lang.String;
import java.lang.Object;
import java.util.Vector;


public class  TestdataGenerator {

  public static void main(String args[]) {

    try {
      Class.forName("oracle.jdbc.driver.OracleDriver");
      String database = "jdbc:oracle:thin:@oracle-lab.cs.univie.ac.at:1521:lab";
      String user = "a01563490";
      String pass = "1214hf";

      // establish connection to database 
      Connection con = DriverManager.getConnection(database, user, pass);
      Statement stmt = con.createStatement();

	 
	  
	  
	  
	  String[] titel = {"Dr."," "," "," ","Mag."," "," "," ","Dipl. Ing."," "," "," ","BSC"," "," "," ","Mas.o. S."," "," "," ","Prof. Dr."," "," "," ","DrDr."," "," "," ","MMag"};
	  String[] vname = {"Hans", "Kevin", "Daniel", "Thomas", "Johannes", "Harald", "Ralf", "Patrick", "Stefan", "Markus","Christoph","David","Andreas"};
	  String[] nname = {"Müller", "Bauer", "Hartmann", "Hofer", "Rachelsberger", "Schneider", "Trapp", "Fichtenbaum", "Nussbaumer", "Haitzmann","Rasser","Mader","Ofensberber"};
	  String[] strasse= {"Erstestrasse", "Zweitestrasse", "Drittstrasse", "Virtestrasse", "Fuenftestrasse", "Sechstestrasse", "Siebentestrasse", "Achtestrasse", "Neuntestrasse", "Zehntestrasse"};
	  String[] oesterreich= {"Wien","Salzburg", "Graz", "Innsbruck","Linz","Bregenz","Klagenfurt","Lienz","Eisenstadt","Wels"};
	  String[] deutschland= {"Berin","München", "Dortmund", "Frankfurt","Leipzig","Hannover","Koeln","Nuernberg","Essen","Hamburg"};
	  String[] frankreich= {"Paris","Toulouse","Lyon","Bordeaux","Dijon","Lille","Rennes","Marseille","Strassburg","Rouen"};
	  String[] england= {"London","Manchester","Cambridge","Plymouth","Liverpool","Luton","Lingoln","York","Brighton","Dover"};
	  String[] schweiz= {"Genf","Bern","St. Gallen","Interlaken","St. Moritz","Zuerich","Zermatt","Lausanne","Schwyz","Chur"};
	  String[] land= {"Österreich", "Deutschland", "Frankreich", "England", "Schweiz"};
	  String[] month= {"Jan", "Feb", "Mar", "Apr", "May", "June", "July", "Aug", "Sep", "Oct", "Nov", "Dec"}; 
	  
	  
	  
	  	String[] bestelltag=new String[4500];
		String[] bestellmonat=new String[4500];
		String[] bestelljahr=new String[4500];
	  //Mitarbeiter
	  
	   for(int j=0;j<30;j++){
		  
		 
		  
		  String monat= (month[(int)((Math.random() * 11)+0)]);
		int tag;
		
			if(monat == "Feb"){
				monat="Feb";
				tag=((int)((Math.random() * 28)+1));
			}
			else if(monat == "Apr" ) {
				monat="Apr";
				tag=((int)((Math.random() * 30)+1));
			}
			else if(monat == "June" ) {
				monat="June";
				tag=((int)((Math.random() * 30)+1));
			}
			else if(monat == "Sep") {
				monat="Sep";
				tag=((int)((Math.random() * 30)+1));
			}
			else if(monat == "Nov") {
				monat="Nov";
				tag=((int)((Math.random() * 30)+1));
			}
			else{
				tag=((int)((Math.random() * 31)+1));
			}
			
			 String monat2= (month[(int)((Math.random() * 11)+0)]);
		int tag2;
		
			if(monat2 == "Feb"){
				monat2="Feb";
				tag2=((int)((Math.random() * 28)+1));
			}
			else if(monat2 == "Apr" ) {
				monat2="Apr";
				tag2=((int)((Math.random() * 30)+1));
			}
			else if(monat2 == "June" ) {
				monat2="June";
				tag2=((int)((Math.random() * 30)+1));
			}
			else if(monat2 == "Sep") {
				monat2="Sep";
				tag2=((int)((Math.random() * 30)+1));
			}
			else if(monat2 == "Nov") {
				monat2="Nov";
				tag2=((int)((Math.random() * 30)+1));
			}
			else{
				tag2=((int)((Math.random() * 31)+1));
			}
		  

		String insertSql = "INSERT INTO mitarbeiter VALUES ('','1','" + titel[(int)(Math.random() * 29)] +"','" + vname[(int)(Math.random() * 13)] +"','" + nname[(int)(Math.random() * 13)] +"','" + tag +'-' + monat +'-' +(int)((Math.random() * 61)+1940)+"','" + tag2 +'-' + monat2 +'-' +(int)((Math.random() * 3)+2014) + "','" + strasse[(int)(Math.random() * 10)] + (int)((Math.random() * 100) + 1) +"','Wien','" + (int)((Math.random() * 9000) + 1000)+"')";		  

												
		try {
			stmt.executeUpdate(insertSql);
		} catch (Exception e) {
			System.err.println("Fehler beim Einfuegen des Datensatzes: " + e.getMessage());
		}	
		  
       
	  }
	  
	
	
	
	  // Kunden

	  for(int j=0;j<2500;j++){
		  
		 
		  
		  String monat= (month[(int)((Math.random() * 11)+0)]);
		int tag;
		
			if(monat == "Feb"){
				monat="Feb";
				tag=((int)((Math.random() * 28)+1));
			}
			else if(monat == "Apr" ) {
				monat="Apr";
				tag=((int)((Math.random() * 30)+1));
			}
			else if(monat == "June" ) {
				monat="June";
				tag=((int)((Math.random() * 30)+1));
			}
			else if(monat == "Sep") {
				monat="Sep";
				tag=((int)((Math.random() * 30)+1));
			}
			else if(monat == "Nov") {
				monat="Nov";
				tag=((int)((Math.random() * 30)+1));
			}
			else{
				tag=((int)((Math.random() * 31)+1));
			}
			
			 String staat= (land[(int)((Math.random() * 5)+0)]);
			String stadt="";
		
			if(staat == "Österreich"){
				staat="Österreich";
				stadt=(oesterreich[(int)((Math.random() * 10))]);
			}
			else if(staat == "Deutschland" ) {
				staat="Deutschland";
				stadt=(deutschland[(int)((Math.random() * 10))]);;
			}
			else if(staat == "Frankreich" ) {
				staat="Frankreich";
				stadt=(frankreich[(int)((Math.random() * 10))]);;
			}
			else if(staat == "England" ) {
				staat="England";
				stadt=(england[(int)((Math.random() * 10))]);;
			}
			else if(staat == "Schweiz" ) {
				staat="Schweiz";
				stadt=(schweiz[(int)((Math.random() * 10))]);;
			}
			
		    String insertSql = "INSERT INTO kunde  VALUES ('','" + titel[(int)(Math.random() * 29)] +"','" + vname[(int)(Math.random() * 13)] +"','" + nname[(int)(Math.random() * 13)] +"', '" + tag +'-' + monat +'-' +(int)((Math.random() * 61)+1940)+"', '" + strasse[(int)(Math.random() * 10)] + ' ' + (int)((Math.random() * 100) + 1) +"', '"+ stadt +"','"+ (int)((Math.random() * 9000) + 1000)+"', '"+ staat +"')";		  
      try {
        stmt.executeUpdate(insertSql);
      } catch (Exception e) {
        System.err.println("Fehler beim Einfuegen des Datensatzes: " + e.getMessage());
      }	  
	  }
	
		
	  // Abteilung
	  {
		String[] name = {"Conrolling", "Personal", "Buchhaltung", "Rechnungswesen", "Service", "Marketing", "Lager", "Vertrieb"};
		
		String[] leiter = {"1", "2", "3", "4", "5", "6", "7", "8"};  
		  
	  for(int j=0;j<8;j++){
		    String insertSql = "INSERT INTO abteilung VALUES ('','" + name[j] +"','"+ leiter[j] +"')";		  
      try {
        stmt.executeUpdate(insertSql);
      } catch (Exception e) {
        System.err.println("Fehler beim Einfuegen des Datensatzes: " + e.getMessage());
      }	  
	  }	
	  }
	  
	  //Lager
	    {
		String[] strassel= {"Erstestrasse 1", "Zweitestrasse 2", "Drittstrasse 3", "Virtestrasse 4", "Fuenftestrasse 5"};
	    String[] ortl= {"Wien", "Berin", "Salzburg", "Muenchen", "Frankfurt"};
		
		  
	  for(int j=0;j<5;j++){
		    String insertSql = "INSERT INTO lager (a_nr,kapatzitaet, strasse, plz, ort) VALUES (7,'"+ (int) ((Math.random() * 40000) +15000) +"', '"+ strassel[j] + (int)((Math.random() * 100) + 1) +"','" + (int)((Math.random() * 9000) + 1000)+"', '"+ ortl[j] +"')";		  
      try {
        stmt.executeUpdate(insertSql);
      } catch (Exception e) {
        System.err.println("Fehler beim Einfuegen des Datensatzes: " + e.getMessage());
      }	  
	  }	
	  }
	  
	  //Service
	  {
	  String[] bereich = {"Rechnung", "Allgeimeine Fragen", "Versand & Paket", "Kauf & Wiederruf"};
		
		  
	  for(int j=0;j<4;j++){
	  String insertSql = "INSERT INTO service (a_nr,bereich, hotline) VALUES (5,'"+ bereich[j] +"','" + (int) ((Math.random() * 8000000) +1000000) +"')";		  
      try {
        stmt.executeUpdate(insertSql);
      } catch (Exception e) {
        System.err.println("Fehler beim Einfuegen des Datensatzes: " + e.getMessage());
      }	  
	  }	
	  }
	  
	  //Produkte
	  {
	   String[] kategorie = {"Notebook", "Tablet", "Smartphone", "PC","Drucker"};
	   String[] marke = {"Samsung", "HP", "Apple", "Huawei","ZTE","Xiaomi","Nokia","Lenovo","Asus","Acer","Medion","LG","Sony","BQ","Archos"};
	   
		int leftLimit = 97;
		int rightLimit = 122;
		int targetStringLength = 4;
		double preisn;
		double preisb;
		
		
		  
	  for(int j=0;j<10000;j++){
		  preisn=((int) (Math.random() *910)+90);
		preisb= preisn * 1.2;
		
		 Random random = new Random();
			StringBuilder buffer = new StringBuilder(targetStringLength);
			for (int i = 0; i < targetStringLength; i++) {
				int randomLimitedInt = leftLimit + (int) 
				  (random.nextFloat() * (rightLimit - leftLimit + 1));
				buffer.append((char) randomLimitedInt);
			}
			String modell = buffer.toString();
		  
	  String insertSql = "INSERT INTO produkt VALUES ('','"+ ((int) (Math.random() *5)+1) +"','"+ kategorie[(int) (Math.random() * 5)] +"','"+ marke[(int) (Math.random() * 15)] +"','"+ modell + ((int) (Math.random() *90000)+10000) +"','"+preisb+"','"+ preisn +"')";		  
      try {
        stmt.executeUpdate(insertSql);
      } catch (Exception e) {
        System.err.println("Fehler beim Einfuegen des Datensatzes: " + e.getMessage());
      }	  
	  }	
	  }
	  
	  //Bestellungen
	   {
	   String[] zahlungsart = {"Paypal", "Sofortüberweisung", "Nachname", "Vorauskasse","Rechnung"};
	   
	   
	   int kundenanzahl=1;
	  
	   for(int j=0;j<4500;j++){
		   
		   
		    ResultSet ka = stmt.executeQuery("SELECT COUNT(*) FROM kunde");
      if (ka.next()) {
        int kunden = ka.getInt(1);
		
      
	  
	  String monat= (month[(int)((Math.random() * 11)+0)]);
		int tag;
		
			if(monat == "Feb"){
				monat="Feb";
				tag=((int)((Math.random() * 28)+1));
			}
			else if(monat == "Apr" ) {
				monat="Apr";
				tag=((int)((Math.random() * 30)+1));
			}
			else if(monat == "June" ) {
				monat="June";
				tag=((int)((Math.random() * 30)+1));
			}
			else if(monat == "Sep") {
				monat="Sep";
				tag=((int)((Math.random() * 30)+1));
			}
			else if(monat == "Nov") {
				monat="Nov";
				tag=((int)((Math.random() * 30)+1));
			}
			else{
				tag=((int)((Math.random() * 31)+1));
			}
			
			int jahr = ((int)(Math.random() * 3)+2014);
			
		
			
			bestelltag[j]=String.valueOf(tag);
			bestellmonat[j]=monat;
			bestelljahr[j]=String.valueOf(jahr);
			
	 if(kundenanzahl<=kunden){
		 String insertSql = "INSERT INTO bestellung VALUES ('','"+ kundenanzahl +"','"+ zahlungsart[((int) (Math.random() *5))] +"','"+tag+'-'+monat+'-'+jahr+"')";		  
	 try {
        stmt.executeUpdate(insertSql);
      } catch (Exception e) {
        System.err.println("Fehler beim Einfuegen des Datensatzes: " + e.getMessage());
      }
	 
	 }
	 else{
		 String insertSql = "INSERT INTO bestellung VALUES ('','"+ ((int) (Math.random() * kunden)+1) +"','"+ zahlungsart[((int) (Math.random() *5))] +"','"+tag+'-'+monat+'-'+jahr+"')";		  
	 
	 try {
        stmt.executeUpdate(insertSql);
      } catch (Exception e) {
        System.err.println("Fehler beim Einfuegen des Datensatzes: " + e.getMessage());
      }
	 }
     
	  kundenanzahl++;
		
	  
      
	  }	  
	  }	
	  }
	  
	  
	    //umfasst
	   {
	   int ordern=1;
	   for(int j=0;j<15000;j++){
		   
		   

	   
		    ResultSet best = stmt.executeQuery("SELECT COUNT(*) FROM bestellung");
      if (best.next()) {
        int orders = best.getInt(1);
		
		 ResultSet pro = stmt.executeQuery("SELECT COUNT(*) FROM produkt");
      if (pro.next()) {
        int products = pro.getInt(1);
	   
	   
		  if(ordern<=orders){
			   String insertSql = "INSERT INTO umfasst VALUES ('','"+ ordern +"','"+ ((int) (Math.random() * products)+1) +"')";	

      try {
        stmt.executeUpdate(insertSql);
      } catch (Exception e) {
        System.err.println("Fehler beim Einfuegen des Datensatzes: " + e.getMessage());
      }			   
		  }
		  else{
			   String insertSql = "INSERT INTO umfasst VALUES ('','"+ ((int) (Math.random() * orders)+1) +"','"+ ((int) (Math.random() * products)+1) +"')";	

      try {
        stmt.executeUpdate(insertSql);
      } catch (Exception e) {
        System.err.println("Fehler beim Einfuegen des Datensatzes: " + e.getMessage());
      }			   
		  }
		  
	 ordern++;

	  }	
	  }	  
	  }	
	  }
	  
	  
	   //Rechnungen
	   {
	   
	    ResultSet best = stmt.executeQuery("SELECT COUNT(*) FROM bestellung");
      if (best.next()) {
        int orders = best.getInt(1);
		
		ResultSet rech = stmt.executeQuery("SELECT COUNT(*) FROM rechnung");
      if (rech.next()) {
       int bills = rech.getInt(1);
		
	   
	   for(int j=0;j<4500;j++){
		  
		   int i=j+1;
		   
			ResultSet preis = stmt.executeQuery("select sum(preis_netto) from (select b.b_nr, p.preis_netto from bestellung b join umfasst u on (b.b_nr=u.b_nr) join produkt p on (u.p_nr=p.p_nr)  where u.b_nr='"+i+"')");
	
		   if (preis.next()) {
			   
			 double gpreis = preis.getInt(1);
		double bgpreis=gpreis*1.2;   		  

					  ResultSet anzahlp = stmt.executeQuery("select count (*) from (select b.b_nr, p.p_nr from bestellung b join umfasst u on (b.b_nr=u.b_nr) join produkt p on (u.p_nr=p.p_nr)  where u.b_nr='"+i+"')");
							if (anzahlp.next()) {
       
		
		int panzahl=anzahlp.getInt(1);
		
		
		  int orderv=(orders-4500)+i;
	  int billv=bills+i;
	  
	  	
	  int y = Integer.parseInt(bestelltag[j]);
	   if(y>27 && bestellmonat[j] == "Jan"){
		  bestelltag[j]="1";
			bestellmonat[j]="Feb";
	  }
	  else if(y>24 && bestellmonat[j] == "Feb"){
			bestelltag[j]="3";
			bestellmonat[j]="Mar";
	  }
	  else if(y>27 && bestellmonat[j] == "Mar"){
		  bestelltag[j]="3";
			bestellmonat[j]="Apr";
	  }
	  else if(y>26 && bestellmonat[j] == "Apr"){
		  bestelltag[j]="2";
			bestellmonat[j]="May";
	  }
	   else if(y>27 && bestellmonat[j] == "May"){
		  bestelltag[j]="8";
			bestellmonat[j]="June";
	  }
	   else if(y>26 && bestellmonat[j] == "June"){
		  bestelltag[j]="7";
			bestellmonat[j]="July";
	  }
	   else if(y>27 && bestellmonat[j] == "July"){
		  bestelltag[j]="4";
			bestellmonat[j]="Aug";
	  }
	   else if(y>27 && bestellmonat[j] == "Aug"){
		  bestelltag[j]="2";
			bestellmonat[j]="Sep";
	  }
	   else if(y>26 && bestellmonat[j] == "Sep"){
		  bestelltag[j]="5";
			bestellmonat[j]="Oct";
	  }
	   else if(y>27 && bestellmonat[j] == "Oct"){
		  bestelltag[j]="6";
			bestellmonat[j]="Nov";
	  }
	   else if(y>26 && bestellmonat[j] == "Nov"){
		  bestelltag[j]="4";
			bestellmonat[j]="Dec";
	   }
	    else if(y>27 && bestellmonat[j] == "Dec"){
		  bestelltag[j]="9";
			bestellmonat[j]="Jan";
	  }
	  else{
		  int tagneu=y+4;
		  bestelltag[j]=String.valueOf(tagneu);
	  }
	 
	  
	
		  
		   String insertSql = "INSERT INTO rechnung VALUES ('"+ billv +"','"+ orderv +"','"+bestelltag[j]+ '-' +bestellmonat[j]+ '-' +bestelljahr[j]+"','"+ panzahl +"','"+gpreis+"','"+ bgpreis +"')";		  
		   
      try {
        stmt.executeUpdate(insertSql);
      } catch (Exception e) {
        System.err.println("Fehler beim Einfuegen des Datensatzes: " + e.getMessage());
      }	  
		   
		   }
		   }
		   
	  }
	  }	  
	  }
	  }
	  

      // check number of datasets in person table
      ResultSet rs = stmt.executeQuery("SELECT COUNT(*) FROM kunde");
      if (rs.next()) {
        int count = rs.getInt(1);
        System.out.println("Number of datasets kunden: " + count);
      }
	  
	     ResultSet ms = stmt.executeQuery("SELECT COUNT(*) FROM mitarbeiter");
      if (ms.next()) {
        int count = ms.getInt(1);
        System.out.println("Number of datasets mitarbeiter: " + count);
      }
	  
	  ResultSet as = stmt.executeQuery("SELECT COUNT(*) FROM abteilung");
      if (as.next()) {
        int count = as.getInt(1);
        System.out.println("Number of datasets abteilung: " + count);
      }
	  
	   ResultSet ls = stmt.executeQuery("SELECT COUNT(*) FROM lager");
      if (ls.next()) {
        int count = ls.getInt(1);
        System.out.println("Number of datasets lager: " + count);
      }
	  
	    ResultSet ss = stmt.executeQuery("SELECT COUNT(*) FROM service");
      if (ss.next()) {
        int count = ss.getInt(1);
        System.out.println("Number of datasets service: " + count);
      }
	  
	     ResultSet ps = stmt.executeQuery("SELECT COUNT(*) FROM produkt");
      if (ps.next()) {
        int count = ps.getInt(1);
        System.out.println("Number of datasets produkte: " + count);
      }
	   ResultSet bs = stmt.executeQuery("SELECT COUNT(*) FROM bestellung");
      if (bs.next()) {
        int count = bs.getInt(1);
        System.out.println("Number of datasets bestellungen: " + count);
      }
	    ResultSet us = stmt.executeQuery("SELECT COUNT(*) FROM umfasst");
      if (us.next()) {
        int count = us.getInt(1);
        System.out.println("Number of datasets umfasst: " + count);
      }
	    ResultSet res = stmt.executeQuery("SELECT COUNT(*) FROM rechnung");
      if (res.next()) {
        int count = res.getInt(1);
        System.out.println("Number of datasets rechnung: " + count);
      }                                             

      // clean up connections
      rs.close();
      stmt.close();
      con.close();

    } catch (Exception e) {
      System.err.println(e.getMessage());
    }
  }
}