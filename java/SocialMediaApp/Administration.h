#ifndef _ADMINISTRATION_H
#define _ADMINISTRATION_H

#include<unordered_map>
#include<vector>
#include<iostream>
#include<memory>
#include<string>
#include"Person.h"
#include"SocialMediaAccount.h"

using namespace std;

struct Administration{
    std::unordered_map<string, shared_ptr<Person>> map;
    std::string create_person(string name);
    void del_person(std::string name);
    virtual std::ostream& print(std:: ostream& o) const;
};

#endif
