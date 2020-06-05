#include<iostream>
#include<string>
#include<vector>
int main(){
    
using std::vector;
using std::string;
    vector<vector<int>>ivec;
//    vector<string>sevc=ivec;
  vector <string>svec(10,nullptr);
 /*第一句，容器里面放了个int的容器
  * 第二句，因为类型不匹配，也没有转换构造，所以就是个错的
  * 第三句是调用了构造函数。*/
  return 0;
}
