#ifndef _VECTOR_H_
#define _VECTOR_H_

#include<iostream>
#include<cstddef>
#include<initializer_list>
#include<stdexcept>
#include <sstream>

using namespace std;
template <typename T>

class Vector {
public:

class ConstIterator;
class Iterator;
using value_type = T;
using size_type = std::size_t;
using difference_type = std::ptrdiff_t;
using reference = value_type&;
using const_reference = const value_type&;
using pointer = value_type*;
using const_pointer = const value_type*;
using iterator = Vector::Iterator;
using const_iterator = Vector::ConstIterator;


private:
	size_type sz;
	size_type max_sz;
	pointer values;
//static damit min_sz nicht bei jeder initialisierung immer wieder erstellt wird, so existiert es nur 1 mal.
	static constexpr size_type min_sz=5;

public:

class Iterator{
	public:

	using value_type = Vector::value_type;
	using reference = Vector::reference;
	using pointer = Vector::pointer;
	using difference_type = Vector::difference_type;
	using iterator_category = std::forward_iterator_tag;

	private:
	pointer ptr;
	

	public:
	
	// default constructor
	Iterator():ptr{nullptr}{}
		
	// pointer auf element consturcotr
	Iterator(pointer pt):ptr{pt}{}
		
	//
	reference operator*(){
		return *ptr;
	}

	pointer operator->(){
		return ptr;
	}

	friend bool operator==(const iterator& x, const iterator& c){
		return x.ptr == c.ptr;
	}

	friend bool operator!=(const iterator& x, const iterator& c){
		return x.ptr != c.ptr;
	}




	//prefix
	iterator& operator++(){
		++ptr;
		return *this;
	}
	
	//postfix
	iterator operator++(int){

		iterator key(*this);
		++(*this);
		return key;
		
	}

	operator const_iterator() const{
		return const_iterator(ptr);
	}

	friend difference_type operator-(const iterator& lop, const iterator& rop){
		return lop.ptr-rop.ptr;
	}

	};


class ConstIterator{
	public:

	using value_type = Vector::value_type;
	using reference = Vector::const_reference;
	using pointer = Vector::const_pointer;
	using difference_type = Vector::difference_type;
	using iterator_category = std::forward_iterator_tag;

	private:
	pointer ptr;
	

	public:
	
	// default constructor
	ConstIterator():ptr{nullptr}{}
		
	// pointer auf element consturcotr
	ConstIterator(pointer pt):ptr{pt}{}
		
	//
	const reference operator*(){
		return *ptr;
	}

	const pointer operator->(){
		return ptr;
	}

	friend bool operator==(const const_iterator& x, const const_iterator& c){
		return x.ptr == c.ptr;
	}

	friend bool operator!=(const const_iterator& x, const const_iterator& c){
		return x.ptr != c.ptr;
	}

	//prefix
	const_iterator& operator++() {
		++ptr;
		return *this;
	}
	
	//postfix
	const_iterator operator++(int) {

	const_iterator key(*this);
		++(*this);
		return key;
	
		
	}

	friend Vector::difference_type operator-(const const_iterator& lop, const const_iterator& rop){
		return lop.ptr-rop.ptr;
	}


	};


//default constructor
Vector():sz{0}, max_sz{min_sz}, values{new value_type[max_sz]}{}

//Vector(5)
Vector(size_type n):sz{0} {


	if(n < min_sz){
		values = new value_type[min_sz];
		max_sz = min_sz;
	}
	else{
		values = new value_type[n];
		max_sz = n;
	}


}

//initalizer list constructor
Vector(initializer_list<value_type> il):Vector(il.size()){
	
	for(auto& x : il){
		values[sz] = x;
		sz++;
	}

}

//destructor
~Vector(){delete[] values;}

//copy constructor
Vector(const Vector& x):Vector(x.size()){
	
	for(size_type i=0; i<x.size(); i++){
		values[i] = x.values[i];
	}

	sz=x.sz;
	max_sz = x.max_sz;	

}

//copy assignment
Vector operator=(Vector v){
 
	 delete[] values;

    max_sz=v.size();
    sz=0;
    
    values=new value_type[v.size()];
    for(size_type i=0;i<v.size();i++)
      push_back(v[i]);
     
return *this;
}


//methoden


void push_back(value_type x){
	if(sz  == max_sz){
		reserve(sz*2);
	}	
	
	values[sz++]=x;
}

size_type size() const{
	return sz;
}

void clear(){
  sz=0;
}

bool empty() const{
	return sz == 0;
} 

void shrink_to_fit(){
  max_sz=sz;
}

void reserve(size_type n){

	pointer tmp = new value_type[n];
	for(size_type i=0;i<sz;++i){
		tmp[i] = values[i];	
	}	

	delete[] values;

	values = tmp;
	max_sz=n;
}

reference operator[](size_type index){
	
	if(index < 0 || index >=sz){
	throw runtime_error("Auswahl nicht möglich");	
	}
	return values[index];

}

const reference operator[](size_type index) const{
	
	if(index < 0 || index >=sz){
	throw runtime_error("Auswahl nicht möglich");	
	}
	return values[index];


}

void pop_back(){

	if(sz == 0) throw runtime_error("Vector ist leer");
	sz--;
	
}

iterator begin() {return iterator(values);}
iterator end() {return iterator(values+sz);}
const_iterator begin() const {return const_iterator(values);}
const_iterator end() const {return const_iterator(values+sz);}


iterator insert(const_iterator pos, const_reference val){
	auto diff = pos-begin();
	if(diff<0 || static_cast<size_type>(diff)>sz)
		throw runtime_error("Iterator_out_of_bounds");
	size_type current{static_cast<size_type>(diff)};
	if(sz>=max_sz)
		reserve(max_sz*2);
	for(size_t i{sz}; i-->current;)
		values[i+1]=values[i];
	values[current]=val;
	++sz;
	return iterator{values+current};
}

iterator erase(const_iterator pos){
	auto diff = pos-begin();
	if(diff<0 || static_cast<size_type>(diff)>=sz)
		throw runtime_error("Iterator_out_of_bounds");
	size_type current{static_cast<size_type>(diff)};
	for(size_type i{current}; i<sz-1; ++i)
		values[i]=values[i+1];
	--sz;
	return iterator{values+current};
}

 	friend ostream& operator<<(ostream& o,const Vector& v){
		o << "[";
		
	for(auto x: v){	
	o << x;
}
	o << "]";
	return o;
}

};
   	
 	
#endif

