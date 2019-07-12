#ifndef PRUEFUNG_H
#define PRUEFUNG_H

#include<iostream>
#include<vector>
#include<string>
#include<stdexcept>
#include"student.h"
using namespace std;

class Pruefung{
  string name;
  vector <StudentIn> studenten;
public:
Pruefung(string);
bool anmelden(const StudentIn&);
void abmelden(const vector<StudentIn>&);
ostream& print(ostream&) const;


};
ostream& operator<<(ostream&, const Pruefung&);

#endif
