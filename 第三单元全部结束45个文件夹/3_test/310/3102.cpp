#include<iostream>
#include<string>
        
int main(){

    std::string str;
    std::getline(std::cin,str);
    std::string r;
   // for(auto c:str)
    
    for(decltype(str.size())i=0;i<str.size();i++)
    {
        if(!ispunct(str[i]))
        {
        //std::cout<<c;
             r+=str[i] ;  
        }
    }

    return 0;

}
