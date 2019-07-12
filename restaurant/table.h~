#ifndef TABLE_H
#define TABLE_H
#include <vector>
#include <string>
#include <iostream>
#include <stdexcept>
#include "order.h"
class Table{
	bool frei;
	public:
		Table(bool=true);
		bool is_free() const;
		ostream& print (ostream&) const;
		void take();
		void giveback();
		Order make_order(const string&);
};

ostream& operator<<(ostream&, const Table&);
#endif
