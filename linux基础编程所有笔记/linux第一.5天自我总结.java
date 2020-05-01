第一天内容:
1>. 命令解析器
2>. Linux快捷键
3>. Linux 系统目录结构
4>. 用户目录
5>. 文件和目录操作
6>. 文件和目录的属性
7>. 文件权限, 用户, 用户组
8>. 文件的查找和检索
9>. 软件的安装和卸载
10>. U盘的挂载和卸载



运行命令:
	命令格式:
		COMMAND [OPTIONS...] [ARGUMENTS...]
		   命令 +选项（可多个）+参数
		   选项:用于启用或关闭命令的某个或某些功能:
	   	      	 短选项: -C, 例如: -1, -h
		  		 多个短选项可命令使用， 例如-1 -h, 可写作-lh;
		 		  长选项: --word, 例如: - long, - -human - readable
		   参数:命令的作用对象
			    向命令提供数据:

1. 命令解析器:
		shell -- unix操作系统
		bash -- Linux操作系统
	本质: 根据命令的名字, 调用对应的可执行程序
2. Linux 快捷键
		1>. 命令和路径补齐: 
		2>. 主键盘快捷键:
				1). 历史命令切换:
						历史命令:
						向上遍历:
						向下遍历:
				2). 光标移动:
						向左:
						向右:
						移动到头部:
						移动到尾部:
				3). 删除字符:
						删除光标后边的字符:
						删除光标前边的字符:
						删除光标前的所有内容:
3. Linux系统目录结构:
		1>. 根目录:
		2>. /bin: 二进制文件，可执行程序 shell命令
		3>. /dev: device（设备）一切皆文件
					 硬盘  显卡 显示器 等设备都在这里
					 一般硬件挂载都在这里
		4>. /etc:  配置文件
				 	---etc/passwd  存linux下当前用户信息

				 	---etc/group  linux下都有哪些用户组
				 	---man 5 passwd/group
		5>. /home: linux操作系统所有用户的家目录   （小区）
						每个用户有单独的home ~
		6>. /lib: linux运行的时候需要加载的动态库
		7>. /media:外设的知道个挂载目录
		8>. /mnt: 手动挂载目录 （嵌入式）
		9>. /root: linux超级用户的home
		10>. /usr:unix system resource（unix系统的资源目录）
					-各种头文件 游戏 用户安装的程序
		11> /opt: 安装第三方程序
		12>/tmp: 存放临时文件
		13>/boot：存放开机文档





4. 用户目录:
		1>. 绝对路径: 从根目录开始写 /home/itcast/aa
		2>. 相对路径: bb 相对于当前的工作目录而言
				. -> 当前目录
				.. -> 当前的上一级目录
				- -> 在临近的两个目录直接切换 cd -
		3>. itcast@ubuntu:~$
					itcast: 当前登录用户
					@: at 在
					ubuntu//bogon: 主机名
					~: 用户的家目录(宿主目录)
					$: 当前用户为普通用户
					#: 超级用户 -- root




5. 文件和目录操作:  7中文件类型
	第一个字符代表文件类型：
		   1.普通文件 ； -
				--->  .txt  压缩包 可执行程序
		   2.目录： d
		   3.符号链接： l（link）
		   4.管道；p
		   5.套接字： s
		   6.字符设备；c
		   7.块设备:b 例如u盘硬盘
		1>. 查看我的资产(目录)
				1). tree -- 必须安装该软件
						查看目录的内容
						tree /etc 
				2). ls -a 查看隐藏文件 touch .a
				3). ls -h(human)
				4). ls -l（list） 查看详细信息

		2>. 在情人和前妻之间徘徊:
					cd 情人目录
					cd 
					cd -：来回切换
				回家安抚老婆孩子: (三种回家方式)
					cd /home/aaa (绝对路径)
					cd ~
					cd
				查看我当前是在老婆, 前妻, 还是情人的床上:
					pwd： printf work directory 
		3>. 给情人买房子(创建目录)
				一间小屋: mkdir dirName
				一套别墅: mkdir -p dir/dir1/dir2 
		4>. 趁前妻不在的时候卖掉前妻的一间房子: 删除空目录
		5>. 给妻子买一个和田玉的手镯: 
		6>. 没收情人的所有财产:
					别墅:
					首饰:
		7>. 给妻子置办一份财产, 跟情人的一模一样
		8>. 妻子查看清单中的内容(5种方式):
		9>. 妻子使用了黑科技, 不管在哪儿都能迅速来到我身边(快捷方式):
		10>. 妻子将我的财产做了备份	



touch： 文件存在 更新文件时间；
		文件不存在，创建


6. 文件或目录属性: (理解内容, 非重点)
		1>. wc
		2>. od
		3>. du
		4>. df




7. 文件权限, 用户, 用户组
      drwxr-xr-x. 2 jiewaikexue jiewaikexue    6 3月  29 05:47 文档
      
        目录的大小肯定是4096 不包含内部文件大小
		1>. 查看当前登录用户:
		2>. 修改文件权限:
				1). 文字设定法: chmod [who] [+|-|=] [mode] 
								chmod uog+rwx www
								chmod u+rwx www
								chmod u+rwx,g+rwx www

							who: 
								文件所有者: u
								文件所 属组: g
								其他人:     o
								所有的人:   a
								什么都不写 ：默认a
								    |----> 什么都不写时，有保护机制
							+: 添加权限:
							-: 减少权限
							=: 覆盖原来的权限
							mode:
								r: 读
								w: 写
								x: 执行
				2). 数字设定法:chmod 0756 a.c
							- : 没有权限
							r: 4
							w: 2
							x: 1
							765
							7 -- rwx -- 文件所有者
							6 -- rw -- 文件所属组
							5 -- rx -- 其他人 

						单纯的加减权限： chmod +/- 0777 a.c
							---->eg:
									rwxr-xrw-. 1 jiewaikexue jiewaikexue    0 4月  21 15:33 a.c
									chmod -400 a.c
									wxrwxrwx. 1 jiewaikexue jiewaikexue    0 4月  21 15:33 a.c
							
		3>. 改变文件或目录的所有者或所属组:
		        chown：
		        chown 新的所有者 文件名
		        chown 新的所有者：新的所有组 文件名
		       ***** 需要root权限*****
		4>. 改变文件或目录所属的组: chgrp
				chgrp 新的组 文件名
		       ***** 需要root权限*****

	注意 ：修改目录的权限时，该目录必须有可执行权限















8. 查找和检索
		1>. 按文件属性查找:find
				1). 文件名:find 查找的目录 -name "文件的名字"
				2). 文件大小: find 查找目录 -size +10k
                     		k小写
                     		M大写
                     		+表示大于
                     		-表示小于
                     		=没有
                     	eg:找大于10k小于100k
                     	find ./ -size +10k -size -100k

						
				3). 文件类型: find + 查找目录 + -type + d/f/b/c/s/p/l
						type:　f,d,l,p,s,c,b
				4).按日期：
 					1>.创建日期；-ctime 
 							-n ：n天以内
 							+n ：n天以外
 						find . -ctime +/-1
 					2>修改日期； -mtime
							-n ：n天以内
 							+n ：n天以外
 						find . -ctime +/-1
 					3>访问日期； -atime
							-n ：n天以内
 							+n ：n天以外
 						find . -ctime +/-1
 				5）.根据深度
 					1> -maxdepth n（n就是层数)
						find . -maxdepth  5  -name a.c 
					2> -mindepth n（n就是层数)
						find . -mindepth  5  -name a.c 
				6）高级查找
				  例如：查找指定目录，并列出该目录的文件详细信息
						find ./ -type d -exec ls -l {} \;

						[jie@VM_0_9_centos ~]$ find ./ -type d -ok ls -l {} \;
						< ls ... ./ > ? 
					区别：ok 比exec 更安全
						find ./ -type d | xargs ls -l

		2>. 按文件内容查找:grep
				grep -r "查找的内容" + 查找的路径 （-r是为了递归搜索）

		eg：	grep -r "stdio.h" /

                 grep -rn "stdio.h" /  （-n显示行号）




        3>总结：
          1.find   搜索的路径 搜索的内容（文件的属性信息）
          2.greo-r 搜索内容（文件的内容信息）  搜索路径











9. 软件的安装和卸载
		1>. 在线安装:
		2>. deb包安装:
		3>. 源码安装:
				案例: 安装 svn
					a. ./configure  --prefix=/usr/local/apr-util  --with-apr=/usr/local/apr
					b. make
					c. sudo make install

4444.压缩包管理
	1.linux下常用压缩格式
		1>.gz --->gzip 光压缩不打包
		2>.bz2 --->bzip2 光压缩不打包
	2.常用压缩命令
		1>tar  ----打包
			参数；
				 -z：使用gzip压缩文件  -xx.tar.gz（生成包的名字）
				-c：创建压缩文件
				-x；释放压缩文件
				-v：打印提示信息
				-f：指定压缩包的name
				-j：使用bzip2的方式压缩文件 -xxx.tar.bz2（生成包的名字）
			压缩
				tar 参数 压缩包的名字 原材料 --gz
				---->tar -zcvf test.tar.gz file file1 file2
			解压缩
				---->tar -zxvf test.tar.gz
				参数：-C：解压到指定文件
				tar -zxvf t.tar.gz -C ..
		2>rar 
			1>rar 需要安装
			sudo apt-get install rar
			2> 压缩： 
				 rar a（没有-）压缩包名字（不需要指定后缀） 原材料
				 压缩的时候 压缩目录需要 -r 递归压缩
			3>解压缩
				 解压到当前目录：rar x（没有-） 压缩包的名字
				 解压到指定目录；rar x 压缩包名字 指定解压目录 
		3>zip/unzip
				同上
				unzip xxxx.zip -b 目录 解压到指定目录
	总结：
	 tar 参数 压缩包名字 原材料
	 tar 参数 压缩包名字 —C 解压路径
	 rar a 压缩包名字 原材料
	 rar  x 压缩包名字 指定的解压目录
	 zip 压缩包名字 原材料
	 unzip 压缩包名字 -b 指定路径
10. U盘的挂载和卸载


/*历史命令向上滚动: ctrl+p
         下:      ctrl +n
         
删除光标后边的字符: 光标覆盖的字符 ctrl+d
        前..: ctrl+h  backspace
        行首: ctrl+a
        行尾: ctrl+e
*/
        
11.cp: 拷贝
    1）.cp 拷贝文件（file1）不存在
		 1.创建file 拷贝
	2）.cp file1 file（存在）
	    file1覆盖file（内容拷贝）
	3）.cp file dir（存在）
		拷贝file到dir里面（文件拷贝）
	4）.cp dir（存在） dir（空目录）
	5）.cp dir（存在） dir1（不存在）
 
	总结： 如果生成文件不存在，则创建一个对应的文件，改名然后把目标文件的内容写进去
	       如果存在，就将目标文件全部写进去（包含第一级）
12.mv：改名或移动文件
		1）.改名：
		   1.mv file（存在）file1（不存在）  ---＞ 改名
		   2.mv dir(存在) dir1（不存在） --＞改名
		2）.移动
		   1.mv file(存在) dir1（存在） --＞file移动到dir1
		   2..mv dir(存在) dir1（存在） --＞移动
		3）.极端
		   1.mv file(存在) file2（存在）
		   		-》file文件覆盖file2文件
		   		-》file文件不存在
       
13.软硬链接ln
		1）.软连接----------快捷方式
			1.	**ln -s 文件名  快捷方式的名字

						1.文件名最好是绝对路径--》如果时候相对路径的话在移动后会失效

						2.

				    ln -s file  kuaijie.soft（随便取名字）
				   	lrwxrwxrwx. 1 jiewaikexue jiewaikexue   25 4月  21 16:24 hellow -> /home/jiewaikexue/456/qwe

	              ----->hellow -> /home/jiewaikexue/456/qwe ----->25个字节
			      ----->软连接的大小，就是链接路径信息及链接对象名字的大小
			 2.一切皆可以创建软连接：
			 		一切皆文件！
 
		2）.硬链接----》
		------》个人理解。硬链接就是文件句柄。文件的本质就是  句柄 索引到 数据块 删除文件就是删除硬链接 
		------》硬链接的使用场景：
			------》（1.）磁盘上的文件/home/jie/hello
					------》在其他多个目录中管理hello，并且能够实时同步
					


			1.ln 文件名 硬链接的名字

				-----》硬链接的使用场景：
						1.磁盘上有一个文件
						 /~/jie/hello
						 2.在其他多个目录中能管理hello，，并且实时同步
						 	ln ./world.c xxx
						 	mv xxx ../xxx


/*        
tab: 自动补齐	

根目录: /

ls aa
tree

ls -la

cd .
cd ..
cd /home/itcast
cd ~
cd

cd -

mkdir aa
mkdir aa/bb/cc -p
rmdir -- del kong
rm -r dir

touch a.txt
rm a.txt

cp a.txt b.txt
cp dir1 dir2 -r

cat
more
less
head
tail
*/

