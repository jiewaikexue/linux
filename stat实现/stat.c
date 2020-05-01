#include<stdio.h>
#include<unistd.h>
#include<stdlib.h>
#include<sys/stat.h>
#include<sys/types.h>
#include<string.h>

int main(int agrc,const char *argv[])
{   //struct stat*st 

    struct stat st;
    int ret=lstat("./en",&st);
    if(ret==-1){
        perror("stat erroe");
        exit(-1);
    }

    printf("file size =%d\n",(int)st.st_size);
    
    printf("mode size =%d\nmode =%d",sizeof(st.st_mode),(int)st.st_mode);

   int a=st.st_mode&(S_IRUSR|S_IWUSR|S_IXUSR);
   int b=st.st_mode&(S_IRGRP|S_IWGRP|S_IXGRP);
   int c=st.st_mode&(S_IROTH|S_IWOTH|S_IXOTH);
   int f=st.st_mode>>12; 
   printf("\n:1=%d,2=%d,3=%d,f=%d",a>>6,b>>3,c,f);
    return 0;
}
