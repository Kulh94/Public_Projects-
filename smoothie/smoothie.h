#ifndef SMOOTHIE_H
#define SMOOTHIE_H
 
#include<iostream>
#include<string>
#include<vector>
#include<stdexcept>
#include"zutat.h"
using namespace std;

class Smoothie{
string name;
vector <Zutat> zutaten;
public:
Smoothie(string);

void hinzu(const Zutat&);
int brennwert() const;
ostream& print(ostream&) const;
void unterheben(const Zutat&);
void liste(ostream&) const;

};

ostream& operator << (ostream&, const Smoothie&);


#endif
