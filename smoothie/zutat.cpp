#include"zutat.h"

Zutat::Zutat(string name, int kj):name{name},kj{kj}{
if(name.empty()) throw runtime_error("Name darf nicht leer sein");
if(kj < 10 || kj > 75) throw runtime_error("Brennwert nicht im vorgegebenen Bereich");

}


ostream& operator << (ostream& o, const Zutat& z){
  return z.print(o);
}


int Zutat::brennwert() const{
  return kj;
}

bool Zutat::operator==(const Zutat& z){

return (name.compare(z.name)==0 && kj==z.kj);
}

ostream& Zutat::print(ostream& o) const{

 o << "[" << name << " " << kj << " kJ" << "]";

return o;
}


