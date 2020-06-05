#include<iostream>
#include<vector>
#include<time.h>
using std::cout;
using std::endl;
using std::vector;

int main()
{
    int ia[3][4]={1,2,3,4,5,6,7,8,9,10,11,12};
    //这里必须是引用，不然就是用数组给数组进行初始化了
    for(int(&a) [4] :ia)
    {
            for(int b:a)
            {
                cout<<b<<' ';
            }
    }
    cout<<"范围for结束"<<endl;
    for(int (*a)[4]=std::begin(ia);a!=std::end(ia);a++)
    {
        for(int *b=std::begin(*a);b!=std::end(*a);b++)
        {
        
            cout<<*b<<' ';
        }
    }
    cout<<"指针for结束"<<endl;
   for(int i=0;i<3;i++)
   {
       for(int m=0;m<4;m++)
       {
           cout<<ia[i][m];
       }
   
   }
   cout<<"下标for结束"<<endl;
    return 0;
}
