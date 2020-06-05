obj=$(wildcard ./*.cpp)
src=$(patsubst %.cpp,%.o,$(obj))

.PHONY=app
target =app

$(target):$(src)
		g++ -std=c++11 $^ -o $@
$(src):$(obj)
		g++ -std=c++11 -c $< -o $@
