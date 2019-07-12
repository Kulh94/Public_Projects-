#include "SocialMediaAccount.h"
#include <memory>
#include <vector>
#include <string>
#include <iostream>

using namespace std;

SocialMediaAccount::SocialMediaAccount(string n, std::shared_ptr<Person> s_ptr):name{n}, accountnumber{++static_accountnumber}{
    authorized_person.push_back(s_ptr);
    //cout << name << + " is created" << endl;
}
SocialMediaAccount::~SocialMediaAccount(){}

bool SocialMediaAccount::add_person(std::shared_ptr<Person> p){
    for(auto a_person : authorized_person){
        if (a_person.lock() == p){
            //cout << "[INFO] SocialMediaAccount::add_person() - Person already exists" << endl;
            return false;
        }
    }
    weak_ptr<Person> ptr = p;
    authorized_person.push_back(ptr);
    //for(auto p: authorized_person) cout << p.lock()->get_name() << endl;
    return true;
}

void SocialMediaAccount::clear_messages(){
    messages.clear();
}

bool SocialMediaAccount::clear_weak_ptr(){
    bool cleared = false;
    for(auto itr = authorized_person.begin();itr != authorized_person.end();){
        if((*itr).expired()) {
            authorized_person.erase(itr);
            //cout << "[INFO] SocialMediaAccount::clear_weak_ptr() - Dangeling deleted!" << endl;
            cleared = true;
        }
        else{
            itr ++;
        }
    }
    return cleared;
}

void SocialMediaAccount::write_msg(std::shared_ptr<SocialMediaAccount> sma, string msg){
    if(sma->size() >= MESSAGE_LIMIT) throw std::runtime_error("!!ERROR : [SocialMediaAccount::write_msg] Too many messages in " + sma->get_name() + "\n");
    sma->messages.push_back(msg);
    score+= calc_score(msg);
}

size_t SocialMediaAccount::size() const {return messages.size();}
int SocialMediaAccount::get_accountnumber() const {return accountnumber;}
string SocialMediaAccount::get_name() const{return name;}

int SocialMediaAccount::static_accountnumber{0};
// --------------------- print ---------------------------------------
std::ostream& SocialMediaAccount::print(std::ostream& o) const{
    o << "[Name: " << name << ", id: " << accountnumber << ", Msgs: {";
    bool first = true;
    for(string msg: messages){
        if (first == true){
            o << msg;
            first = false;
        }
        else o << "," << msg;
    }
    o << "}, Owner: {";
    first = true;
    for(weak_ptr<Person> p: authorized_person){
        if (p.expired()) continue;
        if (first == true){
            o << p.lock()->get_name();
            first = false;
        }
        else o << "," << p.lock()->get_name();
    }

    o << "}, Score: " << score << "]";
    return o;
}
std::ostream& SocialMediaAccount::print_small(std::ostream& o) const{
    o << "[Name: " << name << ", Acc: " << accountnumber << ", Owner: {";
    bool first = true;
    for(weak_ptr<Person> p: authorized_person){
        if (p.expired()) continue;
        if (first == true){
            o << p.lock()->get_name();
            first = false;
        }
        else o << "," << p.lock()->get_name();
    }
    o << "}, #Msgs: " << messages.size() << "]";
    return o;
}



// ----------- VIP Account -------------------
VipAccount::VipAccount(string n, shared_ptr<Person> s_ptr): SocialMediaAccount(n, s_ptr){}
std::ostream& VipAccount::print(std::ostream& o)const{
    SocialMediaAccount::print(o);
    o << "(VIP)";
    return o;
}

int VipAccount::calc_score(string s){
    return (10 + s.size())%20;
}

// ----------- Normal Account -------------------
NormalAccount::NormalAccount(string n, shared_ptr<Person> s_ptr):SocialMediaAccount(n, s_ptr){}
std::ostream& NormalAccount::print(std::ostream& o)const{
    SocialMediaAccount::print(o);
    o << "(Normal)";
    return o;
}

int NormalAccount::calc_score(string s){
    return (5 + s.size())%10;
}
