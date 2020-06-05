#include<iostream>
#include<vector>
#include<string>

using std::cout;
using std::cin;
using std::endl;
using std::vector;
using std::string;

int main()
{
    vector<vector<int>>vet;
    vector<int>v1;
    vector<int>v2(10);
    vector<int>v3(10,42);
    vector<int>v4{10};
    vector<int>v5{10,42};
    vector<string>v6{10};
    vector<string>v7{10,"hi"};
    vet.push_back(v1);    
    vet.push_back(v2);

    vet.push_back(v3);    
    vet.push_back(v4);

    vet.push_back(v5);

    vector<vector<string>>vet2;

    vet2.push_back(v6);    
    vet2.push_back(v7);
    int i=1;
    for(auto a:vet)
    {
        cout<<'v'<<i<<endl;
    
        cout<<"个数"<<'\t'<<a.size()<<endl;
        if(a.size()>0)
        {   cout<<"内容"<<':';
            for(auto b:a){
                cout<<b<<' ';
            }
        }else{
            cout<<'v'<<i<<"个数为0";
        }
        cout<<endl<<endl;
        i++;
    }
    i=1;
    for(auto a:vet2)
    {
        cout<<'k'<<i<<endl;
    
        cout<<"个数"<<'\t'<<a.size()<<endl;
        if(a.size()>0)
        {   cout<<"内容"<<':';
            for(auto b:a){
                cout<<b<<' ';
            }
        }else{
            cout<<'k'<<i<<"个数为0";
        }
        cout<<endl<<endl;
        i++;}
    return 0;
}
