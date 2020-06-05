#include<iostream>
#include<vector>
#include<string>

using std::cout;
using std::cin;
using std::endl;
using std::string;
using std::vector;

int main()
{ 
    vector<string>v;
    string s;
    char cont ='y';
    cout<<"请输一组词"<<endl;
    while(cin>>s)
    {
    v.push_back(s);     
    cin.ignore(100000,'\n');
    cout<<"是否结束？y?n";
    cin>>cont;
    if(cont=='y')
    break;
    }
    for(auto &a:v)
    {
        for(auto&b:a)
        {
              if(islower(b))
                 b+='A'-'a' ;
        }
    }
    for(auto a:v)
    {
        cout<<a<<endl;
    }
    return 0;
}
