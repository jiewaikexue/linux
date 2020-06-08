#include<iostream>
#include<vector>
#include<ctime>
#include<cstdlib>

using std::cout;
using std::cin;
using std::endl;
using std::vector;

int main()
{

    vector<int>v;
    constexpr int sz=10;
    srand((unsigned)time(NULL));
    cout<<"数组初始值为：";
    int i=sz;
    while(i)
    {
        int k=random()%20;
        v.push_back(k);
        cout<<k<<' '; 
        i--; 
    }
    cout<<endl;
    for(auto &a:v)
        if(a%2!=0)
            a=a*2;
    for(auto b:v)
        cout<<b<<' ';
    cout<<endl;
    return 0;
}
