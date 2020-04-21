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
							who: 
								文件所有者: u
								文件所 属组: g
								其他人:     o
								所有的人:   a
							+: 添加权限:
							-: 减少权限
							=: 覆盖原来的权限
							mode:
								r: 读
								w: 写
								x: 执行
				2). 数字设定法:
							- : 没有权限
							r: 4
							w: 2
							x: 1
							765
							7 -- rwx -- 文件所有者
							6 -- rw -- 文件所属组
							5 -- rx -- 其他人 
							
		3>. 改变文件或目录的所有者或所属组:
		4>. 改变文件或目录所属的组: 
8. 查找和检索
		1>. 按文件属性查找:
				1). 文件名:find + 查找的目录 + -name + "文件的名字"
				2). 文件大小: find + 查找目录 + -size + +10k
				3). 文件类型: find + 查找目录 + -type + d/f/b/c/s/p/l
		2>. 按文件内容查找:
				grep -r "查找的内容" + 查找的路径
9. 软件的安装和卸载
		1>. 在线安装:
		2>. deb包安装:
		3>. 源码安装:
				案例: 安装 svn
					a. ./configure  --prefix=/usr/local/apr-util  --with-apr=/usr/local/apr
					b. make
					c. sudo make install
10. U盘的挂载和卸载


历史命令向上滚动: ctrl+p
         下:      ctrl +n
         
删除光标后边的字符: 光标覆盖的字符 ctrl+d
        前..: ctrl+h  backspace
        行首: ctrl+a
        行尾: ctrl+e
        
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

13 .查看文件内容
	1）.cat  看小文件
	2）.more 只能向下
        
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

