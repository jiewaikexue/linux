#include<iostream>
using namespace std;
int main()
{
    int x=10,y=20;
    bool someValue=true;
    someValue?++x,++y:--x,--y;
    cout<<"x="<<x<<endl;
    cout<<"y="<<y<<endl;
    
    cout<<"someValue="<<someValue<<endl;
     x=10;y=20;
     someValue=false;
    someValue?++x,++y:--x,--y;
    cout<<"x="<<x<<endl;
    cout<<"y="<<y<<endl;
    
    cout<<"someValue="<<someValue<<endl;




}
