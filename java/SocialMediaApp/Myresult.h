#include"Administration.h"
#include "Person.h"
#include <memory>
#include <vector>
#include <string>
#include <iostream>
#include "SocialMediaAccount.h"

//using namespace std;

  enum class Section
  {
     Lifestyle=5,
     Politics=1,
     Sports=2,

  };

 class Management:  public Administration 
 {
   private:
    double credibility;

 public:
   Management(int);
   virtual int pr_effect(int articles, Section section) const = 0;
   bool advertise(int articles, Section section);
   std::ostream& print(std::ostream&) const;
 
   //virtual ~Management();
 };


 class M_NFL: public Management 
 {
   public:
      M_NFL(int);
      int pr_effect(int articles, Section section) const;
 };

 class M_AM: public Management 
 {
   public:
   M_AM(int);
   int pr_effect(int articles, Section section) const;

 };

