#ifndef RESTAURANT_H
#define RESTAURANT_H
#include <vector>
#include <string>
#include <unordered_map>
#include "order.h"
#include "table.h"
using namespace std;
class Restaurant{
	string name;
	vector<Table> tables;
	unordered_map<int,vector<Order>> om;
	public:
		Restaurant(string, vector<Table>);
		string get_available_tables() const;
//		ostream& print(ostream&) const;
		void take_table();
		void take_table(int);
		void make_order(int, const string&);
/*		string process();*/
};

/*ostream& operator << (ostream&, const Restaurant&); */
#endif
