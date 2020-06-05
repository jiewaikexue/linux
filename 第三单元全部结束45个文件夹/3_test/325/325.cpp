#include<iostream>
#include<vector>

using std::vector;
using std::cin;
using std::cout;
using std::endl;

int main()
{
    vector<unsigned>vUs(11);
    auto it =vUs.begin();
    int iVal;
    cout<<"请输入一组成绩"<<endl;
    while(cin>>iVal)
    {
        if(iVal<101)
            ++*(it+iVal/10);

    }
    cout<<"您总计输入了"<<vUs.size()<<"个成绩"<<endl;
    cout<<"成绩从高到底，个分数段的人数分布是："<<endl;
    for(it=vUs.begin();it!=vUs.end();it++)
    {
        cout<<*it<<" ";
    }

    cout<<endl;
    return 0;
}
