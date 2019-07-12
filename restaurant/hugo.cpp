#include <string>
#include <vector>
#include <iostream>
#include <stdexcept>
#include "order.h"
#include "table.h"
#include "restaurant.h"
using namespace std;

int main()
{
	Restaurant r1("Studentencafe",vector<Table>(9));
	cout << "Freie Tische: " << r1.get_available_tables() << endl;
	r1.take_table();
	cout << "Freie Tische: " << r1.get_available_tables() << endl;
	r1.take_table();
	cout << "Freie Tische: " << r1.get_available_tables() << endl;
	r1.take_table(8);
	cout << "Freie Tische: " << r1.get_available_tables() << endl;
	r1.take_table(9);
	cout << "Freie Tische: " << r1.get_available_tables() << endl;
	r1.make_order(1,"Fisch");
	r1.make_order(1,"Mineral");
	r1.make_order(2, "Pommes");
	
	/*Order o1("Fisch");
	Order o2("Pudding",4.9);
	cout << "Preis vom Pudding: " << o2.get_preis() << endl;
	cout << o1 << endl;
	cout << o2 << endl;
	Table t1;
	Table t2;
	cout << "Tisch T1=" << t1 << endl;
	cout << "Tisch T2=" << t2 << endl;
	t1.take();
	cout << "Tisch T1=" << t1 << endl;
	o1=t1.make_order("Wiener Schnitzel");
	cout << o1 << endl;
	o2=t2.make_order("Pommes");*/
	return 0;
}
