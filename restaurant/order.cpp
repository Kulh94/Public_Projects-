#include "order.h"
using namespace std;

Order::Order(string name, double preis):name{name},preis{preis} {}	//this->name=name;
string Order::get_name() const{    //Getter, der nur lesend zugreift, daher const
	return name;}
double Order::get_preis() const{
	return preis;}
ostream& Order::print(ostream& o) const{ //zum Überladen des Ausgabeoperators
	return o << '[' << name << ", " << preis << "€]";}

ostream& operator<<(ostream& o, const Order& ord){
	return ord.print(o);}
