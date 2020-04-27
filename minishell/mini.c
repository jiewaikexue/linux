#include<stdio.h>
#include<unistd.h>
#include<string.h>
#include<ctype.h>
#include<sys/wait.h>
#include<stdlib.h>
char g_command[1024];

int GetCommand()
{
    //清空字符数组
    memset(g_command,'\0',sizeof(g_command));
    printf("xxxxxx_______>>>>>>>");
    fflush(stdout);
    if( fgets(g_command,sizeof(g_command)-1,stdin )==NULL) 
    {
        printf("GET is erro ");
        return -1;
    }
    return 0;
}
int ExecCommand(char *argv[])
{
    if(argv[0]==NULL)
    {
        printf("ExecCommand  Pram error \n");
        return -1;
    }
    pid_t pid=fork();
    if(pid<0)
    {
        printf("create subprocess failed\n");
        return -1;
    }
    else if(pid ==0)
    {

        //child
        execvp(argv[0],argv);
        //替换失败的话，一定要杀掉子进程
        exit(0);
    }
    else
    {
        //father
        waitpid(pid,NULL,0);
    }return 0;
}
int DealCommand(char *command)
{
    //差错控制
    if(!command||*command =='\0')
    {
        printf("command is error \n");
        return -1;
    }
    //拆分命令
    char *argv[1024]={0};
    int argc=0;

    while(*command)
    {
        if(isspace(*command)&&*command!='\0')
        {
            argv[argc]=command;

            argc++;
            while(!isspace(*command)&&*command!='\0')
            {
                command++;
            }
            *command='\0';
        }
        command++;
    }
    argv[argc]=NULL;
    //    for(int i=0;i<argc;i++)
    //    {
    //        printf("argv[%d]=%s\n",i,argv[i]);
    //    } 
	ExecCommand(argv);
    return 0;
}

int main()
{
    while(1)
    {
        //从标准输入当中读取命令
        if(GetCommand()==-1)
        {
            continue;
        }
        else//拆分字符串，创建子进程，子进程替换 
        {
            DealCommand(g_command);
        }
    }
    return 0;
}
