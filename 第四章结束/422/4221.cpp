#include<iostream>
#include<string>

using namespace std;
int main()
{
    string finalgrade;
    int gradge;
    cout<<"请输入你需要检查的成绩"<<endl;

    //确保输入合法
    while(cin>>gradge&&gradge>=0&&gradge<=100)
    {
        //这个三段式和是一样


        finalgrade=(gradge>90)?"high pass":(gradge>75)?"pass":(gradge>60)?"low pass":"fail";
        cout<<"档次为："<<finalgrade<<endl;
        cout<< "输入EOF退出"<<"或者你还可以继续输入"<<endl;
    }
    return 0;
}
