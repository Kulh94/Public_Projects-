#include"student.h"

StudentIn::StudentIn(string vname,string nname,string mtnr,string srichtung):vname{vname},nname{nname},mtnr{mtnr},srichtung{srichtung}{
  if(vname.empty()) throw runtime_error("Vorname leer");
    if(nname.empty()) throw runtime_error("Nachname leer");
  bool mtnrueberpruefug=true;
  for(size_t i{0};i<mtnr.size();i++){
     if(isdigit(mtnr.at(i))==false){
        mtnrueberpruefug=false;
        break;
     }
  }
  if(mtnr.size()>8 || mtnr.size()<8 || !mtnrueberpruefug) throw runtime_error("Martikelnummer passt nicht!");
}

ostream& StudentIn::print(ostream& o) const{
  o << "(";
  o << mtnr <<", ";
  o << vname << " ";
  o << nname <<", ";
  o << srichtung;
  o << ")";
 return o;

}

ostream& operator<<(ostream& o, const StudentIn& s){
  return s.print(o);
}

void StudentIn::wechseln(const string& s){
  if(s.empty()) throw runtime_error("Keine Richtung!");
   this->srichtung=s;
}

bool StudentIn::operator==(const StudentIn& s){
  if(this->mtnr==s.mtnr){
    return true;
  }
  else{
    return false;
  }
}

