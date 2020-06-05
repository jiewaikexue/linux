#include<iostream>
#include<string>

int main()
{
    std::string str;
    std:: cout<<"请输入一个字符，可以包含空格"<<std::endl;

    //std::getline(std::cin,str);
    
for(char& a:str)
    {
        a='X';
    }

    std::cout<<str;
    return 0;
}
