#include<iostream>
#include<vector>
using std::cout;
using std::endl;
using std::vector;
int main()
{
    vector<int> vec={1,2,3,4,5};

    cout<<*(vec.begin())<<endl;
    cout<<"*vec.begin()"<<*vec.begin()<<endl;
    cout<<"*vec.begin()+1"<<*vec.begin()+1<<endl;
    cout<<"*(vec.begin()+1)"<<*(vec.begin()+1)<<endl;
    return 0;
}
