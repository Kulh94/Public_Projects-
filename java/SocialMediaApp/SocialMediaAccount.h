#ifndef _SOCIALMEDIACCOUNT_H
#define _SOCIALMEDIACCOUNT_H

#include <memory>
#include <vector>
#include <string>
#include "Person.h"
using namespace std;

class Person;
class SocialMediaAccount {
private:
  constexpr static std::size_t MESSAGE_LIMIT{10};

  int score = 0;
  string name;
  int accountnumber;

  static int static_accountnumber;

  vector<weak_ptr<Person>> authorized_person;
  vector<string> messages;

  void add_msg(const string);

public:
  SocialMediaAccount(string, std::shared_ptr<Person>);
  virtual ~SocialMediaAccount();

  bool add_person(std::shared_ptr<Person>);
  // bool remove_person(Person);
  bool clear_weak_ptr();
  void clear_messages();
  virtual int calc_score(string)=0;
  void write_msg(std::shared_ptr<SocialMediaAccount>, string);
  size_t size() const;
  int get_accountnumber() const ;
  string get_name() const;
  virtual std::ostream& print(std::ostream&) const;
  std::ostream& print_small(std::ostream&) const;
};

//int SocialMediaAccount::accountnumber{0};

//------------ VIP Account -------------------
class VipAccount: public SocialMediaAccount{
public:
    VipAccount(string, std::shared_ptr<Person>);
    std::ostream& print(std::ostream&) const;
    int calc_score(string);
};

//------------- Normal Account ----------------
class NormalAccount: public SocialMediaAccount{
public:
    NormalAccount(string, std::shared_ptr<Person>);
    std::ostream& print(std::ostream&) const;
    int calc_score(string);
};
#endif
