#include "Person.h"
#include <memory>
#include <vector>
#include <string>
#include <iostream>
#include "SocialMediaAccount.h"

using namespace std;

Person::Person(string n) : name{n}{}
string Person::get_name()const {return name;}
shared_ptr<Person> Person::get_person(){return shared_from_this();}
int Person::add_account(string n, int i){
    shared_ptr<Person> s_ptr = get_person();
    shared_ptr<SocialMediaAccount> sma;
    if(i == 0){
        sma = make_shared<NormalAccount>(n, s_ptr);
    }
    else{
        sma = make_shared<VipAccount>(n, s_ptr);
    }
    media_accounts.push_back(sma);
    return sma->get_accountnumber();
}
bool Person::add_account(shared_ptr<SocialMediaAccount> sma){
    for(shared_ptr<SocialMediaAccount> s: media_accounts){
        if(s == sma) return false;
    }
    media_accounts.push_back(sma);
    return true;
}
const vector<shared_ptr<SocialMediaAccount>>& Person::get_accounts() const{
    return media_accounts;
}

const shared_ptr<SocialMediaAccount>& Person::get_account(int number) const{
    for(auto itr = media_accounts.begin(); itr != media_accounts.end(); itr ++){
        if((*itr)->get_accountnumber() == number){
            return (*itr);
        }
    }
    throw std::runtime_error("Person::get_account - "+ name + " has no account with accountnumber " + to_string(number) + "\n");
}

bool Person::remove_account(int number){
    for(auto itr = media_accounts.begin(); itr != media_accounts.end(); itr ++){
        if((*itr)->get_accountnumber() == number){
            media_accounts.erase(itr);
            return true;
        }
    }
    return false;
}

bool Person::share(shared_ptr<Person> ptr_person, shared_ptr<SocialMediaAccount> ptr_sma){
    bool person_check = ptr_person->add_account(ptr_sma);
    bool sma_check = false;
    if (person_check){
        sma_check = ptr_sma->add_person(ptr_person);
    }
    return person_check && sma_check;
}

// ----------------- print --------------------------------------------
std::ostream& Person::print(std::ostream& o) const{
    o << "[Name: " << name << ", Accounts:{";
    bool first = true;
    for(shared_ptr<SocialMediaAccount> sma: media_accounts){
        if(first == true){
            sma->print_small(o);
            first = false;
        }
        else {
            o << ", ";
            sma->print_small(o);
        }

    }
    o << "}]";
    return o;
}
