    CREATE TABLE Mitarbeiter (
        M_Nr INT NOT NULL,
        Chef_Mnr INT,
        Titel VARCHAR2(80),
        Vorname VARCHAR2(220) NOT NULL,
        Nachname VARCHAR2(220) NOT NULL,
        Geburtsdatum DATE NOT NULL,
        Einstellungsdatum DATE NOT NULL,
        Strasse VARCHAR2(220) NOT NULL,
        Ort VARCHAR2(120) NOT NULL,
        Plz Number(4,0) NOT NULL,
        CONSTRAINT pk_mitarbeitrnummer PRIMARY KEY(M_Nr),
        CONSTRAINT fk_chefnummer FOREIGN KEY(Chef_Mnr) REFERENCES Mitarbeiter(M_Nr) ON DELETE CASCADE
        );
    
    CREATE TABLE Abteilung (
        A_Nr INT NOT NULL,
        Name VARCHAR2(220) NOT NULL,
        A_Leiter INT NOT NULL,
        CONSTRAINT pk_abteilungsnummer PRIMARY KEY(A_Nr),
	CONSTRAINT fk_abteilungsleiter FOREIGN KEY(A_Leiter) REFERENCES Mitarbeiter ON DELETE CASCADE
        );	
        
    CREATE TABLE unterliegt (
        M_Nr INT NOT NULL,
        A_Nr INT NOT NULL,
        CONSTRAINT pk_unterliegt PRIMARY KEY(M_Nr, A_Nr),
        CONSTRAINT fk_ma_unterliegt FOREIGN KEY(M_Nr) REFERENCES Mitarbeiter ON DELETE CASCADE,
        CONSTRAINT fk_abt_unterliegt FOREIGN KEY(A_Nr) REFERENCES Abteilung ON DELETE CASCADE
        );
        
    CREATE TABLE Service (
        S_Nr INT NOT NULL,
		A_Nr INT NOT NULL,
		Bereich VARCHAR2(220),
        Hotline Number(12,0) NOT NULL,
        CONSTRAINT pk_service PRIMARY KEY(S_Nr),
        CONSTRAINT fk_service FOREIGN KEY(A_Nr) REFERENCES Abteilung ON DELETE CASCADE
        );
        
    CREATE TABLE Lager (
        L_Nr INT NOT NULL,
		A_Nr INT NOT NULL,
        Kapatzitaet Number(38,0) NOT NULL,
        Strasse VARCHAR(220) NOT NULL,
        Plz Number(4,0) NOT NULL,
        Ort VARCHAR2(220) NOT NULL,
        CONSTRAINT pk_lager PRIMARY KEY(L_Nr),
        CONSTRAINT fk_lager FOREIGN KEY(A_Nr) REFERENCES Abteilung ON DELETE CASCADE
        );
        
    CREATE TABLE Kunde (
        K_Nr INT NOT NULL, 
        Titel VARCHAR2(80),
        Vorname VARCHAR2(220) NOT NULL,
        Nachname VARCHAR2(220) NOT NULL,
        Geburtsdatum DATE NOT NULL,
        Strasse VARCHAR2(220) NOT NULL,
        Ort VARCHAR2(120) NOT NULL,
        Plz Number(4,0) NOT NULL,
        Land VARCHAR(120) NOT NULL,
        CONSTRAINT pk_kunde PRIMARY KEY(K_Nr)
        );
    
    CREATE TABLE Produkt (
        P_Nr INT NOT NULL,
        Lager_Nr INT NOT NULL,
		Kategorie VARCHAR2(220),
		Marke VARCHAR2(220) NOT NULL,
        Modell VARCHAR2(220) NOT NULL,
        Preis_brutto NUMBER(6,2) NOT NULL,
        Preis_netto Number(6,2),
        CONSTRAINT pk_produkt PRIMARY KEY(P_Nr),
        CONSTRAINT fk_produkt FOREIGN KEY(Lager_Nr) REFERENCES Lager ON DELETE CASCADE
        );
     
     CREATE TABLE Bestellung (
        B_Nr INT NOT NULL,
        Kunden_Nr INT NOT NULL,
        Zahlungsart VARCHAR2(80),
        Datum Date NOT NULL,
        CONSTRAINT pk_bestellung PRIMARY KEY(B_Nr),
        CONSTRAINT fk_bestellung FOREIGN KEY(Kunden_Nr) REFERENCES Kunde ON DELETE CASCADE
        );
        
    CREATE TABLE Umfasst (
		U_Id INT NOT NULL,
        B_Nr INT NOT NULL,
        P_Nr Int NOT NULL,
		CONSTRAINT pk_umfasst PRIMARY KEY(U_id),
        CONSTRAINT fk_bestellungumfasst FOREIGN KEY(B_Nr) REFERENCES Bestellung ON DELETE CASCADE,
        CONSTRAINT fk_produktumfasst FOREIGN KEY(P_Nr) REFERENCES Produkt ON DELETE CASCADE
        );
        
    CREATE TABLE Rechnung (
        R_Nr INT NOT NULL,
        Bestellung_Nr INT NOT NULL,
        Datum DATE,
		Anzahl_produkte Int,
        Preis_netto Number(7,2),
        Gesamtpreis Number(7,2) NOT NULL,
        CONSTRAINT pk_rechnung PRIMARY KEY(R_Nr, Bestellung_Nr),
        CONSTRAINT fk_rechnung FOREIGN KEY(Bestellung_Nr) REFERENCES Bestellung ON DELETE CASCADE 
        );
    

    
    CREATE SEQUENCE mitarbeiter_auto_increment START WITH 1 INCREMENT BY 1;
	
	CREATE TRIGGER mitarbeiter_auto_increment
    BEFORE INSERT ON Mitarbeiter
    FOR EACH ROW
    BEGIN
    :new.M_Nr := mitarbeiter_auto_increment.nextval;
    END;
	/
     
	 
	CREATE SEQUENCE abteilung_auto_increment START WITH 1 INCREMENT BY 1;
	
    CREATE TRIGGER abteilung_auto_increment 
    BEFORE INSERT ON Abteilung
    FOR EACH ROW
    BEGIN
    :new.A_Nr := abteilung_auto_increment.nextval;
    END;
	/
    
    CREATE SEQUENCE bestellung_auto_increment START WITH 1 INCREMENT BY 1;	
	
    CREATE TRIGGER bestellung_auto_increment 
    BEFORE INSERT ON Bestellung
    FOR EACH ROW
    BEGIN
    :new.B_Nr := bestellung_auto_increment.nextval;
    END;
	/
    
	CREATE SEQUENCE kunde_auto_increment START WITH 1 INCREMENT BY 1;
	
    CREATE TRIGGER kunde_auto_increment 
    BEFORE INSERT ON Kunde
    FOR EACH ROW
    BEGIN
    :new.K_Nr := kunde_auto_increment.nextval;
    END;
	/
    
	CREATE SEQUENCE lager_auto_increment START WITH 1 INCREMENT BY 1;
	
    CREATE TRIGGER lager_auto_increment 
    BEFORE INSERT ON Lager
    FOR EACH ROW
    BEGIN
    :new.L_Nr := lager_auto_increment.nextval;
    END;
	/
    
	CREATE SEQUENCE produkt_auto_increment START WITH 1 INCREMENT BY 1;
	
    CREATE TRIGGER produkt_auto_increment 
    BEFORE INSERT ON Produkt
    FOR EACH ROW
    BEGIN
    :new.P_Nr := produkt_auto_increment.nextval;
    END;
	/
    
	CREATE SEQUENCE umfasst_auto_increment START WITH 1 INCREMENT BY 1;
	
    CREATE TRIGGER umfasst_auto_increment 
    BEFORE INSERT ON Umfasst
    FOR EACH ROW
    BEGIN
    :new.U_Id := umfasst_auto_increment.nextval;
    END;
	/
	
	CREATE SEQUENCE rechnung_auto_increment START WITH 1 INCREMENT BY 1;
	
    CREATE TRIGGER rechnung_auto_increment 
    BEFORE INSERT ON Rechnung
    FOR EACH ROW
    BEGIN
    :new.R_Nr := rechnung_auto_increment.nextval;
    END;
	/
    
	CREATE SEQUENCE service_auto_increment START WITH 1 INCREMENT BY 1;
	
    CREATE TRIGGER service_auto_increment 
    BEFORE INSERT ON Service
    FOR EACH ROW
    BEGIN
    :new.S_Nr := service_auto_increment.nextval;
    END;
	/
    
    