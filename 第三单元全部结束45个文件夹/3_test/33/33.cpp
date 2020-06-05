#include<iostream>
#include<string>
using namespace  std;
int main()
{

    string line("q");
    string world;
    cout<< "1. string 2.getline"<<endl;
    char ch;
    cin >> ch;
    if(ch=='1')
    {
        cout<<"start "<<endl;
        cin >>world;
        cout<<"putin is:"<<world<<endl;
        return 0;
    }
    cin.clear();//清楚缓冲区
    cin.sync();//
    cin.ignore();   if(ch=='2')
    {
        cout<<"请输入字符串：welcome to c++ family "<<endl;
        getline(cin,line);
        cout<<"系统读取的有效字符串是："<<endl;
        cout<<line <<endl;
        return 0;
    }
    return -1;
}
