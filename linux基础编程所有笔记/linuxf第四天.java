1. gdb调试
2. makefile的编写
3. 系统IO函数


1. gdb调试:
		1. 启动gdb
				start -- 只执行一步
					n -- next
					s -- step(单步) -- 可以进入到函数体内部
					c - continue -- 直接停在断点的位置
				传参：set args 参数字符串
		2. 查看代码:
			1>.	l -- list
					show listsize ---->查看最大显示行数
					set  listsize----自定义行数
			2>.	l 10（函数名）
			3>.	l filename：行号（函数名）

		3. 设置断点:
				设置当前文件断点:
					b -- break
					b 10（函数名）
					b fileName:行号（函数名）
				设置指定文件断点:
				
				设置条件断点:
					b 10 if value==19
				删除断点:
					delete -- del - d
					d 断点的编号
						获取编号： info -- i
											info b
		4. 查看设置的断点
		5. 开始 执行gdb调试
				执行一步操作: 
					继续执行:
				执行多步, 直接停在断点处:
		5. 单步调试
				进入函数体内部: s
					从函数体内部跳出: finish
				不进入函数体内部:
					n
				退出当前循环: u
		6. 查看变量的值: p -- print
		7. 查看变量的类型: ptype 变量名
		8. 设置变量的值:	set var 变量名 = 赋值
		9. 设置追踪变量
				display
				取消追踪变量
				undisplay 编号
						获取编号： info display
		10. 退出gdb调试
					quit


















makefile“：
	gccc编译器
	make-linux自带的构建器
		
2. makefile的编写:  直接make会生成终极目标。make 可以指定目标

		1. makefile的命名
				Makefile 或 makefile
		2. makefile的规则:
				规则中的三要素: 目标， 依赖， 命令
					目标：最终要生成的文件
					依赖条件：生成文件需要的原材料里奥
					命令：
			写法：
				目标：依赖
					（tab缩进）命令 



				eg：
		FIRST版本	app：a.c b.c c.c
						gcc ./.c -o app (这样效率太低)
						因为修改一个，所有文件都会被重新编译
		SECOND版本 :
				先生成所有的.o文件，然后在链接所有的.o文件。避免重复编译浪费时间

		THSIRD版本---->模式匹配
		 1>.自定义遍量（小写）： obj=a.o b.o c.o
		     变量的取值赋值；aa=$（obj）
		 2>.makefile自带的变量（大写）
		 	CPPFLAGS: CPP是预处理器  FLAGS预处理时候的参数
		    CC：
		 3>.自动变量：------------只能在命令中使用-------
		 	$@:规则中的目标
		 	$<:规则中的第一个依赖
		 	$^:规则中所有的依赖
			//makefile由多条命令组合
			!1>模式匹配规则：
					会一个一个的替换掉百分号然后循环执行命令

			-------------------------------------------------
			/		Makefile 的通配符是在带着目的			/
			/		（如“寻找test1.o”）的					/
			/		时候才会把他要寻找的目标套用通配符%中。 /
			-------------------------------------------------
				obj=hello.o fun.o fun1.o
				target=app
				$(target):$(obj)
					g++ $(obj) -o $(target)
				%.o:%.cpp
					g++  $^ -I ./include/ -c -o $@   

		FOURTH版本：可移植性版本（调用函数）
			<1>makefile中所有的函数都是有返回值得
				(1)查找指定文件目录下的指定类型的文件
					src=$(wildcard./ *.c)
					----->这里是在本地文件夹下  通配 *
				（2）匹配替换
					obj=$（patsubst %.c,%.o,$(src)）
					解释：%.c：模式匹配变量里的每一个.c文件
						  %.o：模式匹配，将每一个.c文件替换成.o文件
						  $（src）；.c文件的来源，也就是上一步查找到的所有.c文件

			FIFTH版本：清理项目
				 编写一个清理项目的规则
				 	clean：
				 			rm $(obj) $(target)

				 makefile命令部分 如果最前面加一个减号 ：如果失败，则忽略，继续向下执
		
			make 指定目标 ；如果和当前目录下文件名称冲突，会罢工
				<1.>声明伪目标：好处：伪目标不会进行更新检查，所以也不会做时间上的比对
			-------------------------------------------------
			/	.PHONY：clean								/
			/	clean:										/
			/		rm -f $(obj) &(target) 					/
			-------------------------------------------------
				<2>.生成不是终极目标（第一个目标）的目标
					make 目标名字

				<3>-f 强制执行
					命令前面 -：忽略失败结果，继续执行
makefile工作原理：
检测依赖是否存在
	向下搜索下边的规则，如果有规则是用来生成该依赖的，就执行工作中的命令
	如果依赖存在，则会判断是否需要更新
	------通过时间来判断是否更新---如何判断
	------>通过对比依赖和目标的时间；
			如果目标比依赖的时间早---->更新目表
			如果目标比依赖的时间晚---->不更新
			时间从哪来--->每一次更新文件都会更改文件的属性信息
		原则：目标时间>依赖时间
		makefile内建规则：有时候会搜索一遍本地文件夹，从而推导出命令


				子目标和终极目标的关系:
				更新目标的原则:
		3. makefile的两个函数
				wildcard
				patsubst
		4. makefile的三个自动变量
				$<
				$@
				$^
			模式匹配：
					%.o：%.c
						g++ -c $<








3. 系统IO函数(系统函数)
		1>. 一些概念
			文件描述符
			PCB
			C库函的IO缓冲区
				
		2>. open是一个可变参数函数
		 int open(const char *pathname, int flags)
         int open(const char *pathname, int flags, mode_t mode) 
         ----》如果第二个参数是 O_CREAT ，则你必须给这个文件 权限 

				打开方式: 
					#includ e <sys/types.h>
       				#include <sys/stat.h>
       				#include <fcntl.h>
       			因为open在传参的时候需要制定一些宏，这些宏在上述这些头文件中定义

					必选项:
						O_RDONLY：只写
						O_WRONLY：只读
						O_RDWR：读写
					可选项:
						创建文件	O_CREAT
						<!!!>创建文件是必须检测文件是否存在：O_EXCL
						<!!!>如果文件存在，返回-1，不存在则创建之后返回文件指针
						<!!!>必须与 O_CREAT 一起使用
						追加文件：O_APPEND----->打开文件之后，会把文件指针移动到末尾  fcntl函数
						文件截断：）O_TRUNC------->相当于文件清空
						设置非阻塞：O_NONBLOCK

						mode
							文件权限: 本地有一个掩码
									文件的实际权限:

									给定的权限&本地掩码(取反)
									eg： 0777& （！0022）
									
								
									实际的文件权限
									777
									111111111
									111111101
									111111101
									775
									
					
		3>. read 
		#include <unistd.h>

      	 ssize_t read(int fd, void *buf, size_t count);
      	 	<!!!>fd:S是open的返回值
      	 	<!!!>buf：缓冲区，存储要读取的数据
      	 	<!!!>count：缓冲区能够存放的最大字节数==sizeof（buf）
      	 	<!!!>ssize_t:有符号数
      	 		 size_t:无符号数

				返回值:
					1.失败 ： -1 读文件失败
					2. 成功读完了 ： 0：读到文件指针的末尾
					3. 成功：>0 读取的字节数， 

			读取fd文件，将内容放到buf缓冲区
		4>. write 
		 #include <unistd.h>

       ssize_t write(int fd, const void *buf, size_t count);
       <!!!>open，打开文件的文件描述符：
       <!!!>buf：缓冲区里面要写到文件的数据（全部数据）
       <!!!>count：计算出来的buf里面有效的字节数  strlen（buf）
 

			返回值:
				1.失败： -1 写入文件失败
				3. 成功：>0 写入的字节数， 


		5>. lseek
	  		 #include <sys/types.h>
      		 #include <unistd.h>

      		 off_t lseek(int fd, off_t offset, int whence);
       <!!!>fd：文件描述符
       <!!!>offset：偏移位置，也就是开始位置
       <!!!>whence：
       		<>.SEEK_SET：头部
       		<>.SEEK_CUR：当前位置
       		<>.SEEK_END：末尾
       	使用：
       	A. 文件指针移动到头部
       		lseek（fd，0，seek_set）
       		返回值为0
       	B. 获取文件指针当前位置，偏移量
       		lseek（fd，0，seek_cur）
       		返回值为0
       	C. 获取文件长度
       		lseek（fd，0，seek_end）
       	 	文件原来大小100k--->1100k
       		lseek(fd,1000，seek_end)
       		还需要在做一次写操作
       		write（fd，”a“，1）；


		6>. close
				返回值:






全局变量errno：
	不同的值对应不同的错误信息：
	----->perror（）；



阻塞和非阻塞
	阻塞：等待条件满足
	非阻塞；不等
=-========	================================================
==========阻塞和非阻塞是文件的属性还是read函数的属性？











				
				
cpu 为什么要使用虚拟地址空间与物理地址空间映射？解决了什么样的问题？

1.方便编译器和操作系统安排程序的地址分布。
		程序可以使用一系列相邻的虚拟地址来访问物理内存中不相邻的大内存缓冲区。
		
2.方便进程之间隔离
		不同进程使用的虚拟地址彼此隔离。一个进程中的代码无法更改正在由另一进程使用的物理内存。
		
3.方便OS使用你那可怜的内存。
		程序可以使用一系列虚拟地址来访问大于可用物理内存的内存缓冲区。当物理内存的供应量变小时，
		内存管理器会将物理内存页（通常大小为 4 KB）保存到磁盘文件。数据或代码页会根据需要在物理内存与磁盘之间移动。
		
		
		
		
		
		
		
		
		
		
		
		
		
app:main.o sub.o mul.o
	gcc main.o sub.o mul.o -o app
	gcc $^ -o $@
		
%.o:%.c 
	gcc -c $< -o $@

makefile中的自动变量
$<: 规则中的第一个依赖
$@: 规则中的目标
$^: 规则中的所有依赖
只能在规则的命令中使用


大文件

两种方式: 
	read write  -- 每次读1个byte
	getc putc   -- 每次读一个byte
	
两种方式, 哪个效率高
	
		



虚拟空间地址
	32 位虚拟 4  个g 理论值
	64 位虚拟 32 个g

PCB 里面有一个文件描述符表 int array[1024]
<A>
	array[0]:标准输入--->STDIN_FILENO
	array[1]：标准输出 ----->STDOUT_FILENO
	array[2]:标准错误------>STDERR_FILENO
	前三个文件描述符默认打开
后续的文件描述符：
	没打开一个文件，则占用一个文件描述符，切是空闲的最小的

<B>	通过文件描述符，找到在磁盘上的对应的文件