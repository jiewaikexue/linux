1. 线程概念

线程与进程关系。

	线程之间共享、非共享
	---:栈区不是共享的，整个栈区会被平均分
	---：8291kb平均分

	优缺点




linux下，线程就是进程。---叫做轻量级进程（最小的执行单元，没有独立的用户空间，内核只看pcb，看不出来进程还是线程）
（程序员魔改进程，为了实现线程）（和windows的线程有很大区别） 



		||查看线程指定的LWP号；这个是线程号，不是线程id！！！！！！！
		||线程号LWP是给内核看的
		||用户看线程id
		||	
		||查看LWP方式
			--找打程序的进程id
			--ps -Lf pdi



多进程和多线程的区别
						多进程：
							||始终共享的资源
							---1.代码
							---.文件描述符
							---3.内存映射区
							---4.mmap 套接字
						多线程
							----1.堆
							----2.全局变量
					
						线程节省资源
						----进程是分配资源的基本单位（时间碎片）
						----线程是执行的基本单位









创建线程----pthread_create



					      #include <pthread.h>

					      int pthread_create(pthread_t *thread, const pthread_attr_t *attr,
					                         void *(*start_routine) (void *), void *arg);
					      			
					      			=======================================================
					      			||返回值：
					      			||			如果成功，返回0.
					      			||			如果失败，返回错误号。
					      			||			//perror不能用  
					      			|| 参数：pthread_t *thread：线程id--是个无符号长整形
					      			|| 		=======这是一个出参，传出之后，告诉程序员线程id是多少
					      			|| 	  const pthread_attr_t *attr：
					      			|| 	   		=========线程的属性
					      			|| 	   		========="一般写NULL，这样默认父子线程不分离，也就是需要我们自己需要手动回收"
					      			|| 	  void *(*start_routine) (void *)
					      			|| 	  		=======	函数指针：
					      			|| 	  		=======这个回调函数，也就是子线程的核心工作
					      			|| 	  void *arg	：回调函数的参数
					      			=============================================================
					      		链接时，gcc xxx.c -lpathread  手动指定线程库
					      		线程也是要抢cpu的 ---原子性
					      		父线程结束了，释放进程虚拟地址空间，所以子线程也就退出了。
					      		但是子线程的pcb还没有回收 ，内存泄漏了



				
				                    ||       #include <string.h>
				                    ||
				                    ||       char *strerror(int errnum);
				                    ||
				                    ||       int strerror_r(int errnum, char *buf, size_t buflen);
				                    ||                   /* XSI-compliant */
				                    ||
				                    ||       char *strerror_r(int errnum, char *buf, size_t buflen);
				                    ||                   /* GNU-specific */
				                    ||
				                    ||         这个函数时用来打印pthread_create的错误信息的




单个线程退出-------pthread_exit
									||
									|| #include <pthread.h>
									||
									||       void pthread_exit(void *retval);
									||参数是一个出参，要么是全局的，要么是堆得
					
						可以退出主线程：谁用谁死 
						！！！
						！！！
						！！！主线程自杀后，并没有死，而是僵尸状态。因为子进程还在跑
						！！！这个和进程的属性有关
    
阻塞等待线程退出：
				
						||    #include <pthread.h>
						||
						||     int pthread_join(pthread_t thread, void **retval);
							
							参数：
							pthread_t thread：这是一个线程id
							void **retval：这个参数是个二级指针
									====这是一个出参
									====指向的内存和 *retval   pthread——exit所指向的内存是同一块
									====retval是    void pthread_exit(void *retval);



			子线程无法自己释放pcb
			所以用pthread——join




线程分离：
	手动后天分离	
									
						
									||      #include <pthread.h>
									||
									||      int pthread_detach(pthread_t thread);
						
									分离之后，子线程会回收自己的pcb
									不需要pthread_join等待
	自动先天分离（生下来就是分离的）
						
									int pthread_create(pthread_t *thread, const pthread_attr_t *attr,
						                          void *(*start_routine) (void *), void *arg);
						
						
						第二个参数用：	 const pthread_attr_t *attr
									
						
							1.先创建一个pthread_attr_t的变量
							2.然后用相关函数对这个变量进行初始化
				
							int pthread_attr_init（pthread_attr_t *attr）
						
								
			设置线程分离属性：
									       int pthread_attr_set detach state(pthread_attr_t *attr, int detachstate);
						      			   int pthread_attr_get detach state(pthread_attr_t *attr, int *detachstate);
						
						
						      				 参数：
						      				 attr：线程属性
						      				 detachstate：
						      				 PTHREAD_CREATE_DETACHED：分离
						              
						
						      				 PTHREAD_CREATE_JOINABLE：非分离
						
						
			释放线程资源函数：
									 #include <pthread.h>
						
						       int pthread_attr_init(pthread_attr_t *attr);
						       int pthread_attr_destroy(pthread_attr_t *attr);
						
						
						
						
杀死线程：
									||	  #include <pthread.h>
									||
									||       int pthread_cancel(pthread_t thread);
									||参数：线程id
						
									真正的取消点：也就是线程真正被杀死的那个点
									====下一次系统调用的地方
									====也就是你没法办法杀死一个死循环的线程
									====因为没有取消点
						
						
					===万能取消点：pthread_testcancel（）；
								这个jb玩意就是一个无任何意义的取消点





比较两个线程id是否相等（预留函数，现在还是手动比把）

pthread_equal（pthread_t t1，pthread_t t2）




进程：
ps -elf | grep "对应的文本内容"
ps aux    ——查看运行的进程

线程：
ps -T -p 进程号
top -H  -p 进程号（sspid对应的为线程号）

Linux下获取当前线程ID号函数：
pthread_t pthread_self();



结论：
子线程的清理只与当前进程是否被销毁有关，跟主线程销毁无关。
















僵尸主线程！




多线程情况下，主线程先退出，子线程会被强制退出吗
 
国境之南Fantasy 2016-07-08 21:37:20  26020  收藏 5 
展开 
1、进程中线程之间的关系
线程不像进程，一个进程中的线程之间是没有父子之分的，都是平级关系。即线程都是一样的, 退出了一个不会影响另外一个。
但是所谓的"主线程"main,其入口代码是类似这样的方式调用main的：exit(main(...))。
main执行完之后, 会调用exit()。
exit() 会让整个进程over终止，那所有线程自然都会退出。

2、主线程先退出，子线程继续运行的方法

在进程主函数（main()）中调用pthread_exit()，只会使主函数所在的线程（可以说是进程的主线程）退出；而如果是return，编译器将使其调用进程退出的代码（如_exit()），从而导致进程及其所有线程结束运行。
理论上说，pthread_exit()和线程宿体函数退出的功能是相同的，函数结束时会在内部自动调用pthread_exit()来清理线程相关的资源。但实际上二者由于编译器的处理有很大的不同。  

按照POSIX标准定义，当主线程在子线程终止之前调用pthread_exit()时，子线程是不会退出的。
When you program with POSIX Threads API, there is one thing about pthread_exit() that you may ignore for mistake. In subroutines that complete normally, there is nothing special you have to do unless you want to pass a return code back using pthread_exit(). The completion won't affect the other threads which were created by the main thread of this subroutine. However, in main(), when the code has been executed to the end, there could leave a choice for you. If you want to kill all the threads that main() created before, you can dispense with calling any functions. But if you want to keep the process and all the other threads except for the main thread alive after the exit of main(), then you can call pthread_exit() to realize it. And any files opened inside the main thread will remain open after its termination.


main()中调用了pthread_exit后，导致住线程提前退出，其后的exit()无法执行了，
||所以要到其他线程全部执行完了，整个进程才会退出。||

https://blog.csdn.net/fivedoumi/article/details/51863931?utm_medium=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-2.nonecase&depth_1-utm_source=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-2.nonecase