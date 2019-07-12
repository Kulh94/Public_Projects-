#ifndef ORDER_H
#define ORDER_H
#include <vector>
#include <string>
#include <iostream>
#include <stdexcept>
using namespace std;

class Order{
	string name; //gekapselte private Variablen
	double preis;
	public:
	Order(string,double=10);    //Methoden mit Namen der Klasse sind die Konstruktoren
	string get_name() const;    //Getter, der nur lesend zugreift, daher const
	double get_preis() const;
	ostream& print(ostream&) const; //zum Überladen des Ausgabeoperators
};

ostream& operator<<(ostream&, const Order&);
#endif
