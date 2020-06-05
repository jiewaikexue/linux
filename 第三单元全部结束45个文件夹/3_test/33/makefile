src=$(wildcard ./*.cpp)
obj=$(patsubst %.cpp,%.o,$(src))
.PHONY=app
target=app


$(target):$(obj)
		g++ -std=c++11 $^ -o $@
$(obj):$(src)
		g++ -std=c++11 -c $< -o $@ 

.PHONY=clean
clean:
		rm -f temp
		rm -f $(target) $(obj);
.PHONY=ll
ll:
		ls -lh
