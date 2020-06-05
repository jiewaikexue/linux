
#include<iostream>

#include<string>
int main()
{
    const std::string s="Keep out!";
    for(auto &a:s);

    return 0;
}
