1.信号
		<1>特点：（信号的优先级比较高，会优先处理信号） 
			1.简单
			2.携带的信息量少
			3.使用在某个特定场景
	
		<2>信号的状态
	
			1.产生
				1.键盘eg ctrl+c
				2.命令：eg kill
				3.系统函数：eg 定时器
				4.软条件： 定时器
				5.硬条件： 段错误，除零错误（系统中断）
			2.未决状态---没有被处理，等待被处理
	
			3.递达状态：信号被处理了（三种方式）
				1.忽略
				2.捕捉
				3.执行默认动作
			4.默认处理动作：1. term 终止  2.ign  忽略  3.core 终止并产生核心转储  4.stop  暂停  5.cont continue
									  信号         值      动作   说明
    							|─────────────────────────────────────────────────────────────────────
    							|		SIGHUP        1       A     在控制终端上是挂起信号, 或者控制进程结束
    							|		SIGINT        2       A     从键盘输入的中断
    							|		SIGQUIT       3       C     从键盘输入的退出
    							|		SIGILL        4       C     无效硬件指令
    							|		SIGABRT       6       C     非正常终止, 可能来自 abort(3)
    							|		SIGFPE        8       C     浮点运算例外
    							|		SIGKILL       9      AEF    杀死进程信号
    							|		SIGSEGV      11       C     无效的内存引用
    							|		SIGPIPE      13       A     管道中止: 写入无人读取的管道
    							|		SIGALRM      14       A     来自 alarm(2) 的超时信号
    							|		SIGTERM      15       A     终止信号
    							|		SIGUSR1   30,10,16    A     用户定义的信号 1
    							|		SIGUSR2   31,12,17    A     用户定义的信号 2
    							|		SIGCHLD   20,17,18    B     子进程结束或停止
    							|		SIGCONT   19,18,25          继续停止的进程
    							|		SIGSTOP   17,19,23   DEF    停止进程
    							|		SIGTSTP   18,20,24    D     终端上发出的停止信号
    							|		SIGTTIN   21,21,26    D     后台进程试图从控制终端(tty)输入
    							|		SIGTTOU   22,22,27    D     后台进程试图在控制终端(tty)输出
								────────────────────────────────────────────────────────────────────────────
			
    								 EF：SIGKILL SIGSTOP 补课捕捉，不可
    		6.阻塞信号集合未决信号集
    			1.都在pcb里面
    			2.所以不能能直接操作这俩

    		7.阻塞信号集： 里面放的是要屏蔽的信号的集合
    		8.未决信号集： 里面放的是没有被处理的信号
    				---->阻塞信号集里面的信号，被阻塞之后，都在未决信号集

		<3>信号相关函数
			>1<. 闹钟（定时器）



				alarm ---设置定时器（"每个进程只有一个定时器"）

						1.使用的是自然定时法（时间的运行不受进程影响，完全按照系统时钟）
							------不受进程状态的影响



						2.函数原型：unsigned int alarm(unsigned int seconds);
		
							参数：秒级
									如果参数为0----意思就是取消上一个闹钟
									如果参数大于0，意思就是重新设置定时器，并返回上一个闹钟还剩多少时间
							
							当时间到达之后，函数发信号：SIGALARM------重写用\a可以让他叫
							
							返回值：返回上一个定时器还有多久时间就会发信号

						eg：alarm（5）  ：5秒之后给当前进程发一个提醒，然后终止本进程


				-----------------"定时器超时，会发一个信号，终止本进程"



			>2<.setitimer函数。---定时器，并实现周期性定时：

					#include <sys/time.h>

    				 int getitimer(int which, struct itimerval *curr_value);
    				 int setitimer(int which, const struct itimerval *new_value, struct itimerval *old_value);


    				 	参数：

    				 		which：选择定时法则
    				 				法则：
    				 				ITIMER_REAL：自然计时法则	（real）
    				 				ITIMER_VIRTUAL：只计算  用户耗时  （usr）
    				 				ITIMER_PROF：只计算用户+内核的时间（usr+sys）

    				 				自然定时法信号：SIGALRM    6
    				 				用户耗时法~：SIGVTALRM
    				 				执行耗时法~：SIGPROF

    				 		const struct itimerval *new_value：定时器，用一个结构体来初始化定时器

    				 		结构体：：
										||	|| ||	|| ||	|| ||	|| ||	|| ||	|| ||	|| ||	|| 					
				
										||	struct itimerval {
										||	
				
										||	              struct timeval it_interval; /*各多少时间想一次 */
										||	
				
										||	              struct timeval it_value;    /*第一次响的时候*/
										||	
				
										||	          };
				
										||	|| ||	|| ||	|| ||	|| ||	|| ||	|| ||	|| ||	|| ||	
				
										||	          struct timeval {
										||	
				
										||	              time_t      tv_sec;         /* 秒 */
										||	
				
										||	              suseconds_t tv_usec;        /* 微秒 */
										||	
				
										||	          };//这俩相加就是时间
				
										||	|| ||	|| ||	|| ||	|| ||	|| ||	|| ||	|| ||	|| 
				========================>这个结构体坑爹

											A{

												B it_interval/*各多少时间想一次 */

												B 	it_value /*第一次响的时候*/
								
											}




















    				 		struct itimerval *old_value：这是个出参，传出上一次定时器的信息。一般写NULL


















			>3<kill --发送信号给指定进程：
			 			函数原型：int kill （pid，int sig）
			 			参数：  
			 			pid：目标进程pid
			 		

			 				||		pid>0：发送给指定的进程（本组内缉捕令）
			 		

			 				||		pid=0：杀死本组所有进程（乱杀，自己豆沙）
			 		

			 				||		pid<0：指定GID	（万里追杀，管你在哪）(直接杀掉一个组)

			 		
			 				||		pid=-1： 进程屠杀计划，能杀的全杀了（有血缘关系的一个都跑不了0

			 			sig：发送信号的编号	
			 			返回值： -1 faulse
			 					 0  true

			 			eg： 	kill（getppid（），9）





		<4.>raise：-----自己给自己发信号
			int raise（int sig）



	
		<5.>abort：谁用睡死系列-------调用abord信号会产生6好信号 SIGABRT
	
		<>
	






















1. 信号的概念

	基本的属性。--- 软中断  --- 延时性

	信号4要素。 

2. 产生信号 5 种

	kill 

	alarm函数。

	setitimer函数。

3. 信号集操作函数。  

	自定义集合：  5函数 emptyset  fillset  addset  delset  ismember

	信号屏蔽字   sigprocmask

	未决信号集   sigpending


4. 信号的捕捉

	注册信号捕捉函数。

	signal()

	sigaction函数。(重点)

		struct sigaction:  sa_handler  

				   sa_mask

				   sa_flags = 0; 





