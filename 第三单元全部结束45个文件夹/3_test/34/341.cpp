#include<iostream>
#include<string>
using namespace  std;
int main()
{
    string s1,s2;
    cout<<"请输入两个字符串"<<endl;
    cin>>s1>>s2;
    if(s1==s2)
    {
        cout<<"这俩字符串相等"<<endl;
    }
    else{
        if(s1<s2)

            cout<<"s1小于s2"<<endl;        
        else cout<<"s1大于s2"<<endl;

    }
    return 0;
}
