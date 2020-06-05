src=$(wildcard ./*.cpp)
obj=$(patsubst %.cpp,%.o,$(src))
.PHONY=app
target=app

$(target):$(obj)
	g++ -std=c11 $^ -o $@
%.o:%.c
	g++ -std=c11 -c $< -o $@ 

.PHONY=clean
clean:
	rm -f temp
	rm -f $(target) $(obj);
.PHONY=ll
ll:
	ls -lh

