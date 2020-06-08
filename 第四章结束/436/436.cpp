#include<iostream>
using namespace std;

int main()
{
    int i=6;
    double d=3.141526;
    cout<<(i*=d)<<endl;
    cout<<(i*=static_cast<int>(d))<<endl;
    
}
