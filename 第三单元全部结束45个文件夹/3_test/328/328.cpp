#include<iostream>
#include<string>

using std::cout;
using std::cin;
using std::endl;
using std::string;
string ia[10];
int ia2[10];

int main()
{
    string sa[10];
    int sa2[10];
    for(auto a:ia)
        cout<<a<<' ';
    cout<<endl;
    for(auto a:sa)
        cout<<a<<' ';
    cout<<endl;

    for(auto a:sa2)
        cout<<a<<' ';
    cout<<endl;
    for(auto a:ia2)
        cout<<a<<' ';
    cout<<endl;
    return 0;
}
