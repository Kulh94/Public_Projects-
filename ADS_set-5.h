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
        key_type key;
        Element * next{nullptr};

        ~Element() {
            delete next;
          }
    };

    Element * table{nullptr};
    float max_lf{0.7};
    size_type table_size{N};
    size_type  curr_size{0};
    size_type hash_idx(const key_type &key) const { return hasher{}(key) % table_size; }

    void insert_unchecked(const key_type &key) {
        size_type index = hash_idx(key);
        Element *newNode = new Element();

        newNode->next = table[index].next;
        newNode->key = key;
        table[index].next = newNode;
        newNode = nullptr;
        ++curr_size;
        if (curr_size > max_lf * table_size) rehash();
    }

public:
    ADS_set() { table = new Element[table_size]; }

    ADS_set(std::initializer_list<key_type> ilist) : ADS_set{} { insert(ilist); }

    template<typename InputIt> ADS_set(InputIt first, InputIt last): ADS_set(){ insert(first, last); }

    ADS_set(const ADS_set& other) :ADS_set(){
        for (const auto &key: other) insert_unchecked(key);
    }

    ~ADS_set() { delete[] table; }

    //================Uebung 1==================================
    bool z(const ADS_set& a, const ADS_set& b){
        size_type  count{0};
        if(!a.table_size && !b.table_size) return  true;
        for(size_type i{0}; i < a.table_size; i++){
            for(Element *element = a.table[i].next; element; element = element->next){
               if(b.count(element->key)) count++;
               }

        }
        if(a.curr_size*0.9 <= count && b.curr_size*0.9 <= count ) return true;

        return false;
    }
    //=========================================================

    //============== Uebung 2==================================
    bool y(const key_type& a, const key_type& b) const
    {

        for (size_type i{0}; i < table_size; i++)
        {
            for (Element *element = table[i].next; element; element = element->next) {
                if (key_equal{}(a, element->key) || key_equal{}(b, element->key)) {
                    if (element->next) {
                        if (key_equal{}(a, element->next->key) || key_equal{}(b, element->next->key))
                            return true;
                    }
                    else
                        {
                        i++;
                        while (i < table_size && !table[i].next) ++i;
                        if (i == table_size) return false;
                        if (key_equal{}(a, table[i].next->key) || key_equal{}(b, table[i].next->key)) {
                            return true;
                        }
                        return false;
                    }

                }
            }
        }
            return false;

    }
    //===========================================================



    //=============Uebung 3====================================
    size_t x(const key_type& a, const key_type& b) const{
        size_type  counter = 0;
        size_type  counter2 = 0;
        if(key_equal{}(a,b)) return 0;
        for (size_type i = 0; i < table_size; i++) {
            for (Element *j = table[i].next; j != nullptr; j = j->next) {
                if(counter > 0) counter++;
                if(key_equal{}(a,j->key) || key_equal{}(b,j->key)){
                    counter2++;

                    if(counter2 == 2) {
                         --counter;
                        return counter;
                    }
                    counter++;


                }

            }
        }
        if(counter2<2) throw std::runtime_error("Element nicht gefunden");
        return 0;
    }
    //=========================================================


    ADS_set& operator=(const ADS_set& other){
        if (this == &other) return *this;
        ADS_set tmp{other};
        swap(tmp);
        return *this;
    }

    ADS_set& operator=(std::initializer_list<key_type> ilist){
        ADS_set tmp{ilist};
        swap(tmp);
        return *this;
    }


    size_type size() const { return curr_size; }

    bool empty() const{ return !curr_size; }


    size_type count(const key_type& key) const  {
        size_t index = hash_idx(key);
        for (Element *i = table[index].next; i != nullptr; i = i->next)
        {
            if (key_equal{}(key, i->key)) return 1;
        }
        return 0;
    }

    void clear() {
        ADS_set tmp;
        swap(tmp);
    }

    void swap(ADS_set &other) {
        std::swap(table, other.table);
        std::swap(curr_size, other.curr_size);
        std::swap(table_size, other.table_size);
        std::swap(max_lf, other.max_lf);
    }


    void insert(std::initializer_list<key_type> ilist)
    {
        for (auto &tmp:ilist) {
            insert(tmp);
        }

    }

    std::pair<iterator,bool> insert(const key_type& key)
    {
        if(!count(key)){
            hash_idx(key);
            insert_unchecked(key);
            return std::make_pair(find(key), true);}
        else return std::make_pair(find(key), false);
    }

    template<typename InputIt> void insert(InputIt first, InputIt last)
    {
        for (auto it = first; it != last; ++it)
            if (!count(*it))
                insert_unchecked(*it);
    }




    iterator find(const key_type &key) const {
        size_type pos = hash_idx(key);
        if (table[pos].next == nullptr) return end();
        for (Element *i = table[pos].next; i != nullptr; i = i->next)
            if (key_equal{}(key, i->key)) return const_iterator{i, table, table_size, pos};
        return end();
    }


    const_iterator end() const { return const_iterator{nullptr}; }

    void rehash() {
        std::vector<Key> v;
        for (size_t i = 0; i < table_size; ++i)
            for (Element *j = table[i].next; j != 0; j = j->next)
                v.push_back(j->key);
        delete[] table;
        curr_size = 0;
        table_size = table_size * 2;
        table = new Element[table_size];
        for (Key &it: v) insert_unchecked(it);
    }

    size_type erase(const key_type &key) {
       size_type  idx = hash_idx(key);
       Element* help = table[idx].next;
       Element* before = nullptr;
       for(; help; help = help->next){
           if(key_equal{}(key,help->key)){
                if(help == table[idx].next){
                        table[idx].next = help->next;
                        help->next = nullptr;
                        delete  help;
                }
                else {
                    before->next = help->next;
                    help->next = nullptr;
                    delete help;
                    before = nullptr;
                }
                --curr_size;
               return 1;
           }
           before = help;
       }
        return 0;
    }

    const_iterator begin() const {
        if (this->empty()) return end();
        size_t idx = 0;
        while (table[idx].next == nullptr) idx++;
        return const_iterator{table[idx].next, table, table_size, idx};
    }

    //=====================Uebung 4  const_iterator  v============================
    const_iterator  v(size_t n) const{
        if (this->empty()) return end();
        size_t idx = 0;
        while (table[idx].next == nullptr) idx++;

        return const_iterator{table[idx].next, table, table_size, idx, n};
    }
    //=========================================================



    //=====================Uebung 5 const_iterator w============================
    const_iterator w(const key_type &limit) const{
        if(this->empty()) return end();
        for(size_t i = 0; i < table_size; i++) {
            for(Element* element = table[i].next; element; element = element->next)
                if (key_compare{}(limit, element->key)) {
                    return const_iterator{element, table, table_size, i, limit};
                }
        }
        return end();
    }
    //=========================================================


    friend bool operator==(const ADS_set &lhs, const ADS_set &rhs) {
        if (lhs.curr_size != rhs.curr_size) return false;
        for (const auto &key: rhs) {
            if (!lhs.count(key)) return false;
        }
        return true;
    }


    //========Adhock 1 friend double z==========================================
    friend double z(const ADS_set& a, const ADS_set& b){

        double counter{0.00};

        if(a.curr_size==0 && b.curr_size==0) return 1;
        if(a.curr_size ==0 || b.curr_size == 0) return 0;


        for (size_type i = 0; i < a.table_size; i++) {
            for (Element *j = a.table[i].next ; j != nullptr; j = j->next) {
               if(b.count(j->key)){
                    counter++;
                    cout << "counter: " << counter << endl;
               }
            }

        }
        double result = counter / double((a.curr_size - counter) + (b.curr_size - counter) + counter);
        return result;

    }
    //==========================================================


    //===========Uebung 1 mit Besa const_iterator uebung1==============================
    const_iterator uebung1(size_t n) const{
        if (this->empty()) return end();
        size_t idx = 0;
        while (table[idx].next == nullptr) idx++;
        return const_iterator{table[idx].next, table, table_size, idx,n};
    }
    //==========================================================

    //===========Uebung 2 mit Besa [28.06.2018] bool y==============================
    bool y_uebung2(const key_type& a, const key_type& b) const {
        for (size_type i = 0; i < table_size; i++) {
            for (Element *j = table[i].next; j != nullptr; j = j->next) {
                if (key_equal{}(a, j->key) || key_equal{}(b, j->key)) {
                    if (j->next){
                        if (key_equal{}(a, j->next->key) || key_equal{}(b, j->next->key)) return true;
                    }
                    else {
                        i++;
                        while (i < table_size && !table[i].next) ++i;
                        if(i==table_size) return false;
                        if(key_equal{}(a,table[i].next->key ) || key_equal{}(b, table[i].next->key)){ return true;}
                    }
                }
            }
        }
        return false;
    }
    //==========================================================



    //===========Uebung 2 mit Besa [29.06.2018]=================

    size_t x_uebung3(const key_type& a, const key_type& b) const{
        size_t counter{0}, equalCounter{0} ;
        bool counterStart = false;
        for (size_type i = 0; i < table_size; i++) {
            for (Element *j = table[i].next; j != nullptr; j = j->next) {
                if (counterStart) counter++;
                if (key_equal{}(a, j->key) || key_equal{}(b, j->key)) {
                    counterStart = true;
                    equalCounter++;
                }
                if (equalCounter == 2) return counter; //= counter - 2;
            }
        }
        if(equalCounter < 2 ) throw std::runtime_error("Element not find");
        return 0;
        }
    //==========================================================




    //================Uebung 3 [5.07.2018] ========================

    const_iterator w_uebung3(const key_type &limit){
        if (this->empty()) return end();
        for (size_t i = 0; i < table_size; i++){
            for(Element *j = table[i].next; j; j=j->next){
                if(key_compare{}(limit, j->key)){
                    return const_iterator{table[i].next, table, table_size, i, limit};
                }

            }

        }
        return end();
    }
    //=============================================================



    //=================Übung 25.01.2019=============================
    /*size_t y() const{
        size_t counterGlobal{0};
        Element *help{0};

        for(size_type i = 0; i < table_size; i++) {


            for(Element *j = table[i].next ; j != nullptr; j = j->next) {
                size_t counterLocal{0};
                if(key_compare{}(j->key, j->next ->key)){
                    counterLocal++;
                    if(counterGlobal < counterGlobal){
                        counterGlobal = counterLocal;
                    }
                }
                if(j) help = j;
            }
            while(i < table_size && !table[i].next) i++;
            if(i == table_size) return 0;
            if(key_compare{}(j->key, table[i].next)){
                counter
            }

        }
    }
*/

    //==============================================================

    friend bool operator!=(const ADS_set &lhs, const ADS_set &rhs) {
        return !(lhs == rhs);
    }

    void dump(std::ostream &o = std::cerr) const;

};


template <typename Key, size_t N>
class ADS_set<Key,N>::Iterator {
    Element *element;
    Element *table;
    size_t table_size;
    size_t idx;
    bool modus{false};
    key_type limit{0};
    size_t abstand;

public:
    using value_type = Key;
    using difference_type = std::ptrdiff_t;
    using reference = const value_type&;
    using pointer = const value_type*;
    using iterator_category = std::forward_iterator_tag;


    explicit Iterator(Element *element = nullptr, Element *table = nullptr, size_t table_size = 0, size_t idx = 0) {
        this->element = element;
        this->table = table;
        this->table_size = table_size;
        this->idx = idx;

    }


    explicit Iterator(Element *element, Element *table, size_t table_size, size_t idx, size_t abstand) {
        this->element = element;
        this->table = table;
        this->table_size = table_size;
        this->idx = idx;
        modus = true;
        //this->limit = limit;
        this->abstand = abstand;
    }


    void skip() {
        while (idx < table_size && !table[idx].next) ++idx;
    }

    reference operator*() const { return element->key; }
    pointer operator->() const { return &element->key; }

    Iterator operator++(int) {
        Iterator rc{*this};
        operator++();
        return rc;
    }
    Iterator &operator++() {
        size_t counter = 0;
        if(modus==false) {
            if (element->next) element = element->next;
            else {
                idx++;
                skip();
                element = table[idx].next;
                if (idx == table_size) {
                    element = nullptr;
                    return *this;
                }
            }
            return *this;
        }

        else {
            for (; element->next; element = element->next) {
                counter++;

                if (counter == abstand) {
                    element = element->next;
                    //counter--;
                    return *this;
                }
            }

            idx++;
            skip();
            for (; idx < table_size; idx++) {
                //if(counter>1) counter++;
                for (element = table[idx].next; element; element = element->next) {
                    cout << "element: " << element->key << endl;

                    counter++;
                    if (counter == abstand){
                       if(element->next) element = element->next;
                       // counter --;
                        return *this;}
                }
            }

            element= nullptr;
            return *this;
        }

        return *this;
    }

    friend bool operator==(const Iterator &lhs, const Iterator &rhs) { return lhs.element == rhs.element; }

    friend bool operator!=(const Iterator &lhs, const Iterator &rhs) { return lhs.element != rhs.element; }
};

template <typename Key, size_t N> void swap(ADS_set<Key,N>& lhs, ADS_set<Key,N>& rhs) { lhs.swap(rhs); }


template<typename Key, size_t N>
void ADS_set<Key, N>::dump(std::ostream &o) const {

    o << "Elementen Anzahl: " << curr_size ;
    o << std::endl;
    o << "Tabelle Groesse: " << table_size ;
    o << std::endl;

    for (size_type i = 0; i < table_size; i++) {
        o << "Element[" << i << "]: ";
        for (Element *j = table[i].next ; j != nullptr; j = j->next) {
            o << j->key;
            if (j->next) o << " --> ";
        }
        o << std::endl;
    }
}

#endif // ADS_SET_H
