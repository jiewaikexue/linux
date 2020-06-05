#include<iostream>
using std::cout;
using std::cin;
using std::endl;

int main()
{

    constexpr size_t sz=10;
    int a[sz];
    for (int i=0;i<sz;i++)
        a[i]=i;
    for(auto x:a)
        cout<<x<<' ';
    cout<<endl;
    for(auto *p=std::begin(a);p<std::end(a);p++)
        *p=0;

    for(auto x:a)
        cout<<x<<' ';
    cout<<endl;

    return 0;
}
