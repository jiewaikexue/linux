#app:hello.cpp
#	:fun.cpp
obj=hello.o fun.o fun1.o
target=app

$(target):$(obj)
	g++ $^ -o $@
#	g++ $(obj) -o $(target)
%.o:%.cpp
	g++  $^ -I ./include/ -c -o $@  #-o $@   这两个可以省略
#
#app: hello.o fun.o fun1.o
#	g++ *.o -o app		     
#hello.o:hello.cpp                                                                             
#	g++  hello.cpp -I ./include/ -c
#fun.o:fun.cpp
#	g++ fun.cpp -I ./include/ -c
#fun1.o:fun1.cpp
#	g++  fun1.cpp -I ./include/ -c
