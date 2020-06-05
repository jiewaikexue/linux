#include<iostream>
#include<vector>
#include<string>
using std::vector;
using std::string;
using std::cin;
using std::cout;
using std::endl;

int main(){
    

vector<string> v;
   string str;
   std::getline(cin,str);
   while(str!="")
   {    v.push_back(str);
        std::getline(cin,str);
   }

    for(auto &a:v)
    {
        for(auto &b:a)
        {
            if(islower(b))
                b+='A'-'a';
        }
    }
    for(auto a:v)
        cout <<a<<endl;
    return 0;
}
