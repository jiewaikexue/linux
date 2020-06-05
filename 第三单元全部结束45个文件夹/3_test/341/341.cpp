#include<iostream>
#include <iterator>
#include<vector>
using std::endl;
using std::cout;
using std::cin;
using std::vector;
#include<time.h>
int main()
{
    srand((unsigned)time(NULL));
     size_t sz=random()%10;
    const size_t&a=sz;
    int array[10];
    auto beg =std::begin(array) ;
   auto end1=std::end(array);
for(int*a=std::begin(array);a!=std::end(array);a++)
     *a=random()%40 ;
vector <int> v(std::begin(array),std::end(array));
for(auto a:v)
    cout<<a<<' ';
cout<<endl;
return 0;

}
