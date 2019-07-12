#ifndef ADS_SET_H
#define ADS_SET_H

#include <vector>
#include <functional>
#include <algorithm>
#include <iostream>
#include <stdexcept>
using namespace std;

template <typename Key, size_t N = 7>
class ADS_set {
public:
  class Iterator;
  using value_type = Key;
  using key_type = Key;
  using reference = key_type&;
  using const_reference = const key_type&;
  using size_type = size_t;
  using difference_type = std::ptrdiff_t;
  using iterator = Iterator;
  using const_iterator = Iterator;
  using key_compare = std::less<key_type>;   // B+-Tree
  using key_equal = std::equal_to<key_type>; // Hashing
  using hasher = std::hash<key_type>;        // Hashing

private: 

  struct Element{
    Element * next{nullptr};
    key_type value;
   ~Element() { delete next; }
  };

  Element * table{nullptr};
  size_type sz = 0;
  size_type max_sz = 7; 
  
  size_type hash_idx(const key_type& k) const { return hasher{}(k) % max_sz;}

  void insert_unchecked (const key_type& key){
   Element* help;
   help = new Element();
   size_type pos = hash_idx(key);
   help->next = table[pos].next;
   help->value = key;
   table[pos].next = help;
   ++sz;
   if(sz > max_sz*7) rehash();
  }

  bool find_pos(const key_type &key) const{
    size_type findel = hash_idx(key);
    Element *help=table[findel].next;

    while(help != nullptr && !key_equal{}(key,help->value))    
       help = help->next;

    if(help != nullptr) return true;
    else return false;
  } 

  Element *find_position(const key_type &key) const{
    size_type findel = hash_idx(key);
    Element *help=table[findel].next;

    while(help != nullptr && !key_equal{}(key,help->value))    
       help = help->next;

    if(help != nullptr) return help;
    else return nullptr;
  } 

  void rehash(){
    vector<Key> help;
    for(size_t i=0;i<max_sz;i++){
      for(Element* wert=table[i].next; wert != nullptr; wert=wert->next){
        help.push_back(wert->value);
      }
    }
    
    delete[] table;
    sz=0;
    max_sz=max_sz*2;
    table = new Element[max_sz];
    for(const auto x : help){
      insert_unchecked(x);
    }
  }

 public:
  ADS_set(){
    table = new Element[max_sz];
  }

  ADS_set(std::initializer_list<key_type> ilist):
    ADS_set{} { insert(ilist); }

  template<typename InputIt> ADS_set(InputIt first, InputIt last):
    ADS_set{} { insert(first,last); }
  
  ADS_set(const ADS_set& other): ADS_set{} { 
    for (const auto &key: other) insert_unchecked(key);
  }
   
   ~ADS_set(){
     delete[] table;
   }

  ADS_set& operator=(const ADS_set& other){
    if(this == &other) return *this;
    ADS_set tmp{other};
    swap(tmp);
    return *this;
  }

  ADS_set& operator=(std::initializer_list<key_type> ilist){
    ADS_set tmp{ilist};
    swap(tmp);
    return *this;
  }

  size_type size() const{
    return sz;
  }
  bool empty() const{
     return !sz;
  }

  size_type count(const key_type& key) const{
    size_type result=hash_idx(key);
    for(Element *help=table[result].next;help != nullptr ; help=help->next){
          if(key_equal{}(key,help->value)) return 1;
      }
     return 0;
  }

  iterator find(const key_type& key) const{
    size_type help = hash_idx(key);
    if (Element *pos {find_position(key)}) return iterator{pos,table, max_sz, help};
    return end();
  }

  void clear(){
    ADS_set tmp;
    swap(tmp);
  }

  void swap(ADS_set& other){
    std::swap(table, other.table);
    std::swap(sz, other.sz);
    std::swap(max_sz, other.max_sz);
  }

  void insert(std::initializer_list<key_type> ilist){
     for (const auto &key: ilist) {
       if (!find_pos(key)) insert_unchecked(key);       
     }
  }


  std::pair<iterator,bool> insert(const key_type& key){
     if(find_pos(key)){
       return {iterator{find(key)},false};
     } 
     else{
        insert_unchecked(key);
     }
     return {iterator{find(key)}, true};
  }

  template<typename InputIt> void insert(InputIt first, InputIt last){
    for(auto it = first; it != last; ++it){
        if(!find_pos(*it)){
          insert_unchecked(*it);
        }
    }
  }

  size_type erase(const key_type &key){
    size_type findel = hash_idx(key);
    Element *help = nullptr;
    Element *help2 = nullptr;
    help=table[findel].next;
    int x=0;
    
    if(find_pos(key)){
      for(; help != nullptr ; help=help->next){
          if(key_equal{}(help->value,key)){
            if(x==0){
              table[findel].next=help->next;
              help->next=nullptr;
              delete help;
              --sz;
              return 1;
            }
            else{
              help2->next=help->next;
              help->next=nullptr;
              help2=nullptr;
              delete help;
              delete help2;
              --sz;
              return 1;
            }    
       
          }
          else{
            help2=help;
            ++x;
          }
      }
    }
    return 0;
  }

  const_iterator begin() const{
   size_type help=0;
    for(;help < max_sz; ++help){
       if(table[help].next != nullptr) return const_iterator{table[help].next,table,max_sz,help};
     }
     return end();
  }

  const_iterator end() const{
    return const_iterator{nullptr};
  }

  void dump(std::ostream& o = std::cerr) const{
    size_type help=0;
    for(;help < max_sz; ++help){
      o << "Idx:" << help << "|";
      for(Element *help2=table[help].next; help2 != nullptr; help2= help2->next){
       o << " " << help2->value;
      }
      o << endl;
    }
  }

  friend bool operator==(const ADS_set& lhs, const ADS_set& rhs){
    if (lhs.sz != rhs.sz) return false;
    for (const auto &key: rhs) {
      if (!lhs.find_pos(key)) return false;
    }
    return true;
  }
  
  friend bool operator!=(const ADS_set &lhs, const ADS_set &rhs) { return !(lhs == rhs); } 
};

template <typename Key, size_t N>
class ADS_set<Key,N>::Iterator {
  Element *pos;
  Element *table;
  size_type max_sz;
  size_type help;

  void skip() {
   while(table[help].next == nullptr && help < max_sz){
     help++;
   }
  }

public:
  using value_type = Key;
  using difference_type = std::ptrdiff_t;
  using reference = const value_type&;
  using pointer = const value_type*;
  using iterator_category = std::forward_iterator_tag;

  explicit Iterator(Element *pos = nullptr, Element *table=nullptr, size_type max_sz=0, size_type help=0):
   pos{pos}, table{table}, max_sz{max_sz}, help{help} {}

  reference operator*() const { return pos->value; }
  pointer operator->() const { return &pos->value; }

  Iterator& operator++() {
     if(pos->next == nullptr){
        ++help;
        skip();
        if(help == max_sz){
          pos = nullptr;
          return *this;
        }
        pos = table[help].next;
        return *this;
     }
     else{
       pos=pos->next;
       return *this;
     }
  }

  Iterator operator++(int) { 
    Iterator rc {*this}; ++*this; return rc;     
  }

  friend bool operator==(const Iterator &lhs, const Iterator &rhs) { return lhs.pos == rhs.pos; }
  friend bool operator!=(const Iterator &lhs, const Iterator &rhs) { return lhs.pos != rhs.pos; }
};

template <typename Key, size_t N> void swap(ADS_set<Key,N>& lhs, ADS_set<Key,N>& rhs) { lhs.swap(rhs); }

#endif