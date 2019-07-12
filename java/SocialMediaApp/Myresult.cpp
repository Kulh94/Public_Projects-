#include"Administration.h"
#include "Person.h"
#include <memory>
#include <vector>
#include <string>
#include <iostream>
#include "SocialMediaAccount.h"
#include "Myresult.h"

using namespace std;

 Management::Management(int credibility): credibility{credibility} {}



   bool Management::advertise(int articles, Section section)
   {
      int e = credibility;
    
     e+= pr_effect(articles, section);

     if(e < -100)
     {
       e = -100;
     } else if(e > 100)
            {
              e = 100;
            }
   
     if(credibility != e)
     {
       credibility = e;
       return true;  
   
     } else return false;

   }

      std::ostream& Management::print(std::ostream& o) const
      {
         Administration::print(o);
         o << "\t credibility: " << credibility;
         return o;
      }


    M_NFL::M_NFL(int credibility):Management(credibility){}
    M_AM::M_AM(int credibility):Management(credibility){}

  int M_NFL::pr_effect(int articles, Section section) const{
  return articles * 2 * static_cast<int>(section);
   }

   int M_AM::pr_effect(int articles, Section section) const{

  return articles * 3 * static_cast<int>(section);
   }





