#include<iostream>
#include<vector>
using std::cout;
using std::cin;
using std::endl;
using std::vector;
int main ()
{
    constexpr int sz=10;
    int a[sz],b[sz];
    for(int x=0;x<sz;x++)
        a[x]=x;
    for(int y=0;y<sz;y++)
        b[y]=a[y];
    for(auto a:b)
        cout<<a<<" ";
    cout <<endl;

    return 0;
}
