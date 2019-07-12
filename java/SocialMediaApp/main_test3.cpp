#include "Person.h"
#include "SocialMediaAccount.h"
#include "Administration.h"
#include "Management.h"
#include <iostream>
#include <memory>

using namespace std;

struct Conglomerate {
    vector<shared_ptr<Management>> managements;
    bool campaign(int articles, Section section){
      bool worked = false;
      for(auto m : managements){
        bool w = m->advertise(articles, section);
        if (w == true){
          worked = true;
        }
      }
      return worked;
    }
};


int main(){
  cout << "Aufgabe 1" << endl;


   Administration admin;
   
   admin.create_person("Havelock");
   admin.create_person("Angua");

   int angua_id = admin.map["Angua"]->add_account("Wache", 1);
   int havelock_id = admin.map["Havelock"]->add_account("Patrizier", 0);

   auto angua_account = admin.map["Angua"]->get_account(angua_id);
   auto havelock_account = admin.map["Havelock"]->get_account(havelock_id);

   admin.map["Havelock"]->share(admin.map["Angua"], havelock_account);

   havelock_account->write_msg(angua_account,"Democracy: One Man, One Vote. The Patrician was the Man; he had the Vote");
   angua_account->write_msg(havelock_account, "Kappa");

   admin.map["Angua"]->print(cout) << endl;
   admin.map["Havelock"]->print(cout) << endl;

   angua_account->print(cout) << endl;
   havelock_account->print(cout) << endl;

   admin.del_person("Havelock");

   angua_account->print(cout) << endl;
   havelock_account->print(cout) << endl;




  cout << "Aufgabe 2" << endl;
  M_NFL obj1(0);
  M_AM obj2(0);
  
   obj1.advertise(5, Section::Politics);
   

   obj2.advertise(5, Section::Politics);

   obj1.advertise(-8, Section::Lifestyle);

   obj2.advertise(-8, Section::Lifestyle);

   obj1.print(cout) << " , ";
   obj2.print(cout) << endl;
  

  cout << "Aufgabe 3:";
  Conglomerate min;
  min.managements.push_back(make_shared<M_NFL>(60));
  min.managements.push_back(make_shared<M_AM>(60));

  min.campaign(3, Section::Lifestyle); 
  min.campaign(2, Section::Sports);
  
  int i = 0;
  for(auto m: min.managements){
    m->print(cout);
    if(i == 0) cout << " ), ";
    else cout << "\n";
    i++;
  }


  
return 0;
}
