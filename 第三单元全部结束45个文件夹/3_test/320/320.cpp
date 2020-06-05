#include<iostream>
#include<string>
#include<vector>
using std::cout;
using std::cin;
using std::endl;
using std::vector;

int main()
{

    vector<int>v;
    int tmp=0;
    char cont ='y';
    cout<<"请输入一组数字"<<endl;
    while(cin>>tmp)
    {
        cin.ignore(1024,'\n');
        v.push_back(tmp);
        //cin.ignore(1000000,'\n');
        cout<<"是否继续输入y?n"<<endl;
        cin>>cont;
        if(cont !='y')
            break;
    }
    for(auto a:v)
    {
        cout<< a<<' ';
    }
    cout<<endl<<endl;
    for(auto begin=v.begin(),end=v.end()-1;begin<=end;begin++,end--)
    {
         cout<<*begin+*end<<endl;
    }

    return 0;
}
