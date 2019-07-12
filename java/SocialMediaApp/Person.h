#ifndef _PERSON_H
#define _PERSON_H

#include <memory>
#include <vector>
#include <string>
#include "SocialMediaAccount.h"

using namespace std;
class SocialMediaAccount;
class Person : public enable_shared_from_this<Person>{
private:
  string name;
  vector<shared_ptr<SocialMediaAccount>> media_accounts;
public:
  Person(string n);
  shared_ptr<Person> get_person();
  string get_name() const;
  int add_account(string n, int i);
  bool add_account(shared_ptr<SocialMediaAccount>);
  bool remove_account(int);
  bool share(shared_ptr<Person>, shared_ptr<SocialMediaAccount>);
  const vector<shared_ptr<SocialMediaAccount>>& get_accounts() const;
  const shared_ptr<SocialMediaAccount>& get_account(int) const;

  std::ostream& print(std::ostream&) const;
  //ostream& print_small(ostream&) const;
};

#endif
