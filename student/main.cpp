#include<iostream>
#include<vector>
#include<string>
#include<stdexcept>
#include"student.h"
#include"pruefung.h"
using namespace std;

int main(){
try{
  cout <<StudentIn{"","Mayr","12345678","Informatik"};
  cout <<"A";
}
catch (runtime_error&){
  cout << '1';
}
try{
  cout <<StudentIn{"Lisa","Mayr","0123456","Biologie"};
  cout <<"B";
}
catch (runtime_error&){
  cout << '2';
}
try{
  cout <<StudentIn{"Lisa","Mayr","012mat67","Mathematik"};
  cout <<"C";
}
catch (runtime_error&){
  cout << '3';
}
try{
  cout <<StudentIn{"Lisa","Mayr","01234567","Anglizistik"};
  cout <<"D";
}
catch (runtime_error&){
  cout << '4';
}
StudentIn s{"Lisa","Mayr","01234567","Anglizistik"};
try{
  s.wechseln("");
  cout <<"E";
}
catch (runtime_error&){
  cout << '5';
}
s.wechseln("Germanistik");
cout << '\n'<<(s==s)<<(s==StudentIn{"Herbert","Mueller","01234567","Informatik"})
              <<(s==StudentIn{"Lisa","Mayr","12345678","Anglizistik"})<<'\n';
try{
  cout << Pruefung{""};
  cout << "F";
}
catch (runtime_error&){
  cout << '6';
}
cout<<"\n\n";

Pruefung p("Programmierung");
cout<<p<<'\n';
cout<<p.anmelden(StudentIn{"Herbert","Mueller","01234567","Informatik"});
cout<<p.anmelden(s);
cout<<p.anmelden(StudentIn{"Maria","Bauer","23456789","Informatik"});
cout<<p.anmelden(StudentIn{"Lisa","Mayr","87654321","Anglizistik"});
cout<<'\n';
cout<<p<<'\n';
cerr<<p<<"\n\n";

//Zuatz1


//Zusatz2
Pruefung p1{p};
p.abmelden(vector<StudentIn>{s,s,StudentIn{"Herbert","Mueller","01234567","Informatik"}, StudentIn{"Maria","Bauer","23456789","Informatik"},s});
p1.abmelden({s});
p1.abmelden(vector<StudentIn>{});
cout << s << '\n' <<p <<'\n' << p1 <<"\n\n";

return 0;
}
