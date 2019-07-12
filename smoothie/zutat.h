#ifndef ZUTAT_H
#define ZUTAT_H
 
#include<iostream>
#include<string>
#include<vector>
#include<stdexcept>
using namespace std;

class Zutat{
string name;
int kj;
public:
Zutat(string, int=32);

ostream& print(ostream&) const;
int brennwert() const;
bool operator ==(const Zutat&);


};

ostream& operator << (ostream&, const Zutat&);

#endif
