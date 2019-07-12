#include "smoothie.h"

Smoothie::Smoothie(string name){
if(name.empty()) throw runtime_error("Keine Bezeichung angegeben");

this->name=name;
}

void Smoothie::hinzu(const Zutat& z){
  zutaten.push_back(z);
}

int Smoothie::brennwert() const{
int sum{0};

 for(size_t i{0}; i<zutaten.size();i++){
   sum += zutaten.at(i).brennwert();
 }

return sum;
}


ostream& Smoothie::print(ostream& o) const{
 
 o << "[{"; 
 
 for(size_t i{0}; i<zutaten.size();i++){
   zutaten.at(i).print(o);
 if(i<zutaten.size()-1)
   o << ", ";
 }
 
 o << "} ";
 o << name << "]" << endl; 

 return o;
}

ostream& operator << (ostream& o, const Smoothie& s){
  return s.print(o);
}

void Smoothie::unterheben(const Zutat& z){
if(zutaten.empty()) throw runtime_error("Der Smoothie enthaltet keine Zutaten");
for(int i{0};i<zutaten.size();i+=2){
      zutaten.insert(zutaten.begin()+i,z);
 }
}
/*
void Smoothie::liste(ostream& o) const
{
vector <Zutat> end_liste;
vector <int> anzahl_liste;
 
 
 for(size_t i{0}; i<zutaten.size();i++)
 {
     Zutat current=zutaten.at(i);
    
 
     bool exist=false;
     for(size_t j{0}; j<end_liste.size();j++)
     {
         Zutat next= end_liste.at(j);
        
         if(current==next) {
             exist=true;
         }
    }
    if(exist)
    {
        continue;
    }

 
    int anzahl_z{0};
    for(size_t j{0};j<zutaten.size();j++)
    {
        Zutat next=zutaten.at(j);
        if(current==next)
        {
            anzahl_z++;
        }
    }
 
    end_liste.push_back(zutaten.at(i));
    anzahl_liste.push_back(anzahl_z);
 } 
 o << "[{"; 
 for(size_t i{0}; i<end_liste.size();i++)
 {
      o << end_liste.at(i) << "*" << anzahl_liste.at(i);
 }
 o << "} ";
 o << name << "]" << endl; 
 
}
*/
void Smoothie::liste(ostream& o) const
{
vector <Zutat> neu1;
vector <Zutat> fertig;

for(size_t i{0};i<zutaten.size();i++){
  neu1.push_back(zutaten.at(i));
}


 
  o << "[{"; 
 for(size_t i{neu1.size()-1};i>0;i--)
 {
  int anzahl_z{1};
  fertig.push_back(neu1.at(i));
     for(size_t j{0};j<i;j++)
     {
      size_t x{fertig.size()-1};
      if(x!=0 && neu1.at(i)==fertig.at(x)){
         continue;
      }
        if(neu1.at(j)==neu1.at(i))
        {
           anzahl_z++;
          /* o << anzahl_z; 
           o << " Anzahl erhöhen_j" << endl;*/
        } 
     }
     
  if(anzahl_z!=1)
   {
    neu1.at(i).print(o);
    o << "*" << anzahl_z;
   }
  else
   {
    neu1.at(i).print(o);
   }
  if(i<neu1.size()-1)
  {
   o << ", ";
  }
 }
 
 o << "} ";
 o << name << "]" << endl; 
}


