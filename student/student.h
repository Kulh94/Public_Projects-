#ifndef STUDENT_H
#define STUDENT_H

#include<iostream>
#include<vector>
#include<string>
#include<stdexcept>
using namespace std;

class StudentIn{
  string vname;
  string nname;
  string mtnr;
  string srichtung;
public:
StudentIn(string,string,string,string="Informatik");
void wechseln(const string&);
bool operator ==(const StudentIn&);
ostream& print(ostream&) const;


};
ostream& operator<<(ostream&, const StudentIn&);

#endif
