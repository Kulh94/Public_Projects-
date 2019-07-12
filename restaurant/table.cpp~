#include "table.h"
Table::Table(bool frei):frei{frei} {}
bool Table::is_free() const{
	return frei;
}
ostream& Table::print(ostream& o) const{
	return o << '[' << (frei ? "Frei" : "Besetzt") << ']';
}

void Table::take(){
	frei=false;
}
void Table::giveback(){
	frei=true;
}
Order Table::make_order(const string& strNameOrder) {
	if (frei) throw runtime_error("No customer here");
	return Order(strNameOrder);
}

ostream& operator<<(ostream& o, const Table& t){
	return t.print(o);}
