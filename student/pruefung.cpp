#include"pruefung.h"

Pruefung::Pruefung(string name):name{name}{
  if(name.empty()) throw runtime_error("Kein Name angegeben!");
}

ostream& Pruefung::print(ostream& o) const{
 o << "[" << name << ":" << "{";
  for(size_t i{0};i<studenten.size();i++){
    studenten.at(i).print(o);
    if(i<studenten.size()-1) o << ", ";
  }
 o << "}]";
return o;
}

ostream& operator<<(ostream& o, const Pruefung& p){
  return p.print(o);
}

bool Pruefung::anmelden(const StudentIn& s){
 bool erg=true;
 if(studenten.empty()){
  studenten.push_back(s);
 }
 else{
  for(size_t i{0};i<studenten.size();i++){
    if(studenten.at(i)==s){
     erg=false;
     cout << "ERG2:" << erg << endl;
      break;
    }
  }
 }
 if(erg==true){
   studenten.push_back(s);
 }

return erg;
}

void Pruefung::abmelden(const vector<StudentIn>& slist){
 for(size_t i{0};i<studenten.size();i++){
   for(size_t j{0};j<slist.size();j++){
     if(studenten.at(i)==slist.at(j)){
       studenten.erase(studenten.begin()+i);
     }
   }
 }
}


