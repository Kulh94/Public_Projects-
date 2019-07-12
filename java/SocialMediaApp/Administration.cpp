#include<unordered_map>
#include<vector>
#include<iostream>
#include<memory>
#include<string>
#include"Administration.h"
using namespace std;
std::string Administration::create_person(string name){
    map[name] = make_shared<Person>(name);
    return name;
}

void Administration::del_person(string name){
    if (map.count(name) == 0){
        throw std::runtime_error("del_person() - Person (\""+name+"\") does not exist!\n");
    }
    vector<shared_ptr<SocialMediaAccount>> accounts = map[name]->get_accounts();
    auto it = map.find(name);
    map.erase(it);
    for(shared_ptr<SocialMediaAccount> account: accounts){
        account->clear_weak_ptr();
    }
}

std::ostream& Administration::print(std::ostream& o) const{
    o << "map: [";
    for(auto& e: map){
        o << "\t";
        e.second->print(o);
    }
    o << "]";
    return o;
}
