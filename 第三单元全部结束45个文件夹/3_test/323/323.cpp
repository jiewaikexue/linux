#include<iostream>
#include<vector>
#include<string>
#include<ctime>
using std::cout;
using std::cin;
using std::endl;
using std::vector;

int main()
{
    vector<int> v(10,0);
std:srand((unsigned)time(NULL));
    for(auto &a:v)
    {
        a=rand()%10000;
    }
    cout<<"元素初始值为"<<endl;
    for(auto b:v)
        cout<<' '<<b<<' ';

    for(auto &b:v)
    {
        b*=2;
    }
    cout<<endl;
    for(auto b:v)
        cout<<' '<<b<<' ';

    return 0;

}
