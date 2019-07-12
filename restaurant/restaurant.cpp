#include "restaurant.h"
Restaurant::Restaurant(string name, vector<Table> tables):name{name},tables{tables}{}

string Restaurant::get_available_tables() const{
	string strTables;
	int i{1};
	for (const Table& t : tables){
		if (t.is_free())
			strTables+=to_string(i) + " ";
		++i;
	}
	return strTables;
}

void Restaurant::take_table(){
	for (Table& t: tables)
		if (t.is_free()){
			t.take();
			return;
		}
}
void Restaurant::take_table(int tischnummer){
	if (tischnummer>=1  && static_cast<size_t>(tischnummer)<=tables.size()){
		tischnummer--;	
		if (tables.at(tischnummer).is_free())
			tables.at(tischnummer).take();	
		else
			throw runtime_error("Na Hallo, da sitzt schon jemand!");
	}
	else
		throw runtime_error("Den Tisch gibt es gar nicht");
}

void Restaurant::make_order(int tischnummer, const string& order){
	if (tischnummer>=1  && static_cast<size_t>(tischnummer)<=tables.size()){
		tischnummer--;	
		Order o =tables.at(tischnummer).make_order(order);
		auto f=om.find(tischnummer);
		if (f==om.end())	
			om.insert(std::pair<int,vector<Order>>(tischnummer,{}));
		om.at(tischnummer).push_back(o);
	}
	else
		throw runtime_error("Den Tisch gibt es gar nicht");
}
	



















