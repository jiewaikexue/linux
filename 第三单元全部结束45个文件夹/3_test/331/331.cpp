#include<iostream>

using std::cout;
using std::cin;
using std::endl;

int main()
{

    constexpr int sz=10;
    int a[sz];
    for(int x=0;x<sz;x++)
        a[x]=x;
    for(auto z:a)
        cout<<z<<' ';
    cout<<endl;

    return 0;
}
