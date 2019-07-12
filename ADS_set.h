#ifndef ADS_SET_H
#define ADS_SET_H

#include <functional>
#include <algorithm>
#include <iostream>
#include <stdexcept>
#include <vector>
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

//__________________________________________________________________________
//________________________cost_iterator w()________________________________

  const_iterator w(const key_type &limit) const{
   size_type i=0;
    for(;i < max_sz; ++i){
      for(Element *help=table[i].next; help != nullptr; help=help->next){
       if(key_compare{}(limit, help->value))return const_iterator{help,table,max_sz,i,limit};
     }
    }
     return end();
  }

//__________________________________________________________________________
//____________________ cost_iterator v()___________________________________

  const_iterator v(size_t n) const{
   size_type help=0;
    for(;help < max_sz; ++help){
       if(table[help].next != nullptr) return const_iterator{table[help].next,table,max_sz,help,n};
     }
     return end();
  }

//__________________________________________________________________________
//____________________ cost_iterator x()___________________________________


const_iterator x(const key_type& k) const{
   size_type help=0;
    Element * kleinmax=nullptr;

    for(;help < max_sz; ++help){
      for(Element *wert=table[help].next; wert != nullptr; wert=wert->next){
      cout << "wert: " << wert->value << endl;
      if(key_compare{}(wert->value,k)){
        
       if(key_compare{}(wert->next->value, wert->value)){
           cout << "kleinermax: " << kleinmax->value << endl;
         kleinmax= wert;
       }
      }
     }
    }
    if(kleinmax != nullptr) return const_iterator{kleinmax, table, max_sz, help};

     return end();
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

//__________________________________________________________________________
//____________________________ bool z()____________________________________


friend bool zz(const ADS_set& a, const ADS_set& b){
  size_type gleichinbeiden=0;
  size_type nichtgleichA=0;
  size_type nichtgleichB=0;
  double ergebnis1=0.0;
  double ergebnis2=0.0;

  for(size_type i=0; i< a.max_sz; i++){
    for(Element *help=a.table[i].next; help != nullptr; help= help->next){
        if(b.count(help->value)) ++gleichinbeiden;
        else{
           ++nichtgleichA;
        }
    }
  }
  
       
nichtgleichB= b.sz - gleichinbeiden;
 

//divident= gleichinbeiden+nichtgleichA+nichtgleichB;
 ergebnis1= static_cast<double> (gleichinbeiden) / static_cast<double> (a.sz);
  ergebnis2= static_cast<double> (gleichinbeiden) / static_cast<double> (b.sz);


  
if(ergebnis1 >= 0.9 && ergebnis2 >= 0.9) return true;
return false;

}

//__________________________________________________________________________
//________________________ size_type y()___________________________________

  size_type y() const{
    size_type result=1;   
    size_type help2=0;
    Element *x=nullptr;
    Element *y=nullptr;

    for(size_type i=0;i < max_sz; ++i){
      for(Element *help=table[i].next; help != nullptr; help=help->next){
        
         y=help;
         if(x != nullptr){
           if(key_compare{}(x->value,y->value)){     
             if(help2 == 0) ++++help2;
              else ++help2;
              if(help2 > result) result=help2;
           } 
           else{
             help2=0;
           }
        }
    x=help;
    }
     }
       if(y == nullptr && x == nullptr) result = 0;
  return result;
  }

//__________________________________________________________________________
//___________________________ bool y()______________________________________

bool yy(const key_type& a, const key_type& b) const{

  Element* wert=nullptr;
  for(size_type i=0; i<max_sz; i++){
    for(Element* help=table[i].next; help != nullptr; help=help->next){
      
      if(wert != nullptr){
      if(key_equal{}(wert->value, a) && key_equal{}(help->value,b) || key_equal{}(wert->value, b) && key_equal{}(help->value,a))  
        return true;
      }
     wert=help;
    }
  }
 return false;
}

//__________________________________________________________________________
//____________________ size_type x()___________________________________

size_t x(const key_type& a, const key_type& b) const{
  bool x=false;
  bool y=false;
  size_type result=0;
  size_type ae=0;
  size_type be=0;

  for(size_type i=0; i<max_sz; i++){
    for(Element* help=table[i].next; help != nullptr; help=help->next){
      if(key_equal{}(help->value, a)) x=true;
        if(key_equal{}(help->value, b)) y = true;
    }
  }
  if(x && y){
    for(size_type i=0; i<max_sz; i++){
      if(x){
      for(Element* help=table[i].next; help != nullptr; help=help->next){
        if(key_equal{}(help->value, a))  x=false;
        if(x) ++ae;
        //cout << "AE:" << ae << endl;
    }
      }
  }
    for(size_type i=0; i<max_sz; i++){
      if(y){
      for(Element* help=table[i].next; help != nullptr; help=help->next){
        if(key_equal{}(help->value, b)) y=false;
        if(y) ++be;
        //cout << "BE:" << be << endl;
    }
    }
  }
  }
  else {
    throw runtime_error("Wert a oder b nicht vorhanden!");
  }
/*cout << "AE: " << ae << endl; 
cout << "BE:" << be << endl;*/

if(ae > be || ae == be) result = ae - be;
else result = be - ae;


  return result;

}

//__________________________________________________________________________
//_________________________ double z()______________________________________

friend double z(const ADS_set& a, const ADS_set& b)
{
   size_t counter1 = 0;
   size_t counter2 = 0;
   size_t counter3 = 0;
   size_t counter4 = 0;

  if(a.sz == 0 && b.sz == 0) return 1;

  for(size_t i{0}; i < a.max_sz; i++)
  {
      for(Element* j = a.table[i].next; j != nullptr; j = j->next)
      {

        if(b.count(j->value))
        {
           counter1++;

        }  else counter2++;      
 
      }
     
  }
         counter3 = b.sz - counter1;
         counter4 = counter1 + counter2 + counter3;
      return static_cast<double>(counter1) / static_cast<double>(counter4); // oder return (double)counter1 / (double)counter4;
}

//__________________________________________________________________________
//_________________________  key_type x() nachtermin2______________________________________

key_type x_nt2() const {
  Element * vor=nullptr;
  Element * wert=nullptr;
  Element * x=nullptr;
  Element * y=nullptr;
  size_type c=0;
  key_type erg;

  if(sz < 3) throw runtime_error("Max Element nicht findbar");
  
  for(size_type i=0;i<max_sz;i++){
    for(Element *help=table[i].next; help != nullptr; help=help->next){
        wert=help;

        if(x != nullptr){
          if(key_compare{}(wert->value, x->value)){
            ++c;
            if(y == nullptr){
              y=x;
            }
            else{
              if(key_compare{}(x->value, y->value)){
                y=x;
              }
            }
          }
        }

        x=nullptr;

        if(vor != nullptr){
          if(key_compare{}(vor->value, wert->value)){
            x=wert;
          }

        }
        vor=help;
    }
  }


  if(c == 0) throw runtime_error("Max Element nicht findbar"); 

  if(y != nullptr){
    erg=y->value;
    return erg;
  }

  return erg;
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


  bool special =false;
  key_type limit;
  size_type abstand;
  size_type kleiner;
   Element *x;
  

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

/*
//_________________________ Konstruktor const_iterator w()______________________________________
   explicit Iterator(Element *pos, Element *table, size_type max_sz, size_type help, key_type limit):
   pos{pos}, table{table}, max_sz{max_sz}, help{help}, special{true}, limit{limit} {}

*/

/*
//_________________________ Konstruktor const_iterator w()______________________________________
   explicit Iterator(Element *pos, Element *table, size_type max_sz, size_type help, size_type abstand):
   pos{pos}, table{table}, max_sz{max_sz}, help{help}, special{true}, abstand{abstand} {}
   */
/*
//_________________________ Konstruktor const_iterator x()______________________________________
   explicit Iterator(Element *pos, Element *table, size_type max_sz, size_type help, size_type kleiner):
   pos{pos}, table{table}, max_sz{max_sz}, help{help}, special{true}, kleiner{kleiner}, x{nullptr}{}
*/
  


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


/*
  //_________________________ Konstruktor const_iterator v()______________________________________
  Iterator& operator++() {
  
    if(!special){
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
  else{
    size_type c=0;
    for(;pos->next != nullptr; pos=pos->next){   
        c++;  
        if(c > abstand){
          pos=pos->next;
          return *this;
        }   
    }
    ++help;
    skip();

    for(;help < max_sz;++help){
      for(pos=table[help].next; pos != nullptr; pos = pos->next){
        c++; 
        if(c > abstand) {
         return *this;
        }
      }
    }
    pos = nullptr;
    return *this;
  }
  }
*/

/*
  //_________________________ operator++() const_iterator w()______________________________________
  Iterator& operator++() {
    if(!special){
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
  else{
            for (; pos->next != nullptr; pos = pos->next) {
                if (key_compare{}(limit, pos->next->value)) {
                    return *this;
                }
            }

            help++;
            skip();
            if(help < max_sz) {
                for (pos = table[help].next; pos != nullptr; pos = pos->next) {
                    if (key_compare{}(limit, pos->value)){
                        return *this;
                        }
                }
            }
            pos= nullptr;
            return *this;
  }
  }
  */

/*
//_________________________ Operator ++ const_iterator x()______________________________________
Iterator& operator++() {
    
    if(!special){
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
  else{

   
    if(x == nullptr){
    for(;pos->next != nullptr; pos=pos->next){
           // cout << "Pos1: " << pos->next->value << endl;
      if(pos->next->value > pos->value){
        if(key_compare{}(pos->next->value,kleiner)) {
                
          x= pos->next;
        //   if(x != nullptr) cout << "X-1: " << x->value << endl;
         
        }
        
    }
    }
    ++help;
    skip();
    if(help < max_sz){
      for(pos=table[help].next; pos != nullptr; pos=pos->next){
           //   cout << "Pos2: " << pos->value << endl;
              if(pos->next != nullptr){
       if(pos->value > pos->next->value && pos->value > x->value){
        if(key_compare{}(pos->value,kleiner)) {
               
            x= pos;
        //    if(x != nullptr) cout << "X-2: " << x->value << endl;
        }
    }
      }
      }
    }

  }
  
    if(x != nullptr){
   //   cout << "X: " << x->value << endl;
  
            pos= x;
    }       
            return *this;
            
    
  
    pos = nullptr;
    return *this;
    
  
  }
}*/


 Iterator operator++(int) { 
    Iterator rc {*this}; ++*this; return rc;     
  }

  friend bool operator==(const Iterator &lhs, const Iterator &rhs) { return lhs.pos == rhs.pos; }
  friend bool operator!=(const Iterator &lhs, const Iterator &rhs) { return lhs.pos != rhs.pos; }
};


template <typename Key, size_t N> void swap(ADS_set<Key,N>& lhs, ADS_set<Key,N>& rhs) { lhs.swap(rhs); }

#endif