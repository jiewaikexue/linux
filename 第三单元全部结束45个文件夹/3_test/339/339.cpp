#include<iostream>
#include<string>
#include<string.h>
using std::string;
using std::cout;
using std::cin;
using std::endl;
using std::getline;
int main()
{
    char* a=nullptr;
    char *b=nullptr;

    string stra,strb;
    cout<<"请输入字符串1"<<endl;
    std::    getline(cin,stra);
    cout<<"请输入字符串2"<<endl;
    std::    getline(cin,strb);
    a=(char *)stra.c_str();
    b=(char *)strb.c_str();
    if(stra!=strb)
    {
        cout<<(stra>strb?'>':'<')<<endl;
    }else{
        cout<<'='<<endl;
    }
  int i=  strcmp(a,b);
  if(i!=0)
  {
      if(i<0)
          cout<<'<';
      cout<<'>';
      
  }
  else{
      cout<<'=';

  }
  return 0;
}
