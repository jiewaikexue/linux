#include<iostream>
#include<vector>
#include<time.h>
using std::cout;
using std::endl;
using std::vector;

int main()
{
    srand((unsigned)time(NULL));
     int yy=random()%20;
    vector<int>v;
    int sz=yy;
    while(sz)
    {
        v.push_back(random()%50);
    sz--;
    }
    const int x=yy;
    int array[x];
    for(int i=0;i<x;i++)
    {
        array[i]=v[i];
    
    }
    for(auto xx:array)
        cout<<xx<<' ';
    cout<<endl;
    return 0;
}
