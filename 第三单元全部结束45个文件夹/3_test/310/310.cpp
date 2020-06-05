#include<iostream>
#include<string>
        
int main(){

    std::string str;
    std::getline(std::cin,str);

    for(auto c:str)
    {
        if(!ispunct(c))
        {
            std::cout<<c;

        }
    }

    return 0;

}
