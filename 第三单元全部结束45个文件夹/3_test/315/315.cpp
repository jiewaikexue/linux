#include<iostream>
#include<string>
#include<vector>

using std::string;
using std::vector;
using std::cin;
using std::cout;
using std::endl;

int main()
{
    vector<string> v;
    string s;
    char cont='y';
    while(cin>>s)
    {
    v.push_back(s);
    cout<<"继续？"<<" y?n"<<endl;
    cin >>cont;
    if(cont!='y')
    {
    break;
    }
    }
    for(auto& a:v)
    {
        cout<<' '<<a<<' ';
    
    }

        cout<<endl;
    return 0;
}
