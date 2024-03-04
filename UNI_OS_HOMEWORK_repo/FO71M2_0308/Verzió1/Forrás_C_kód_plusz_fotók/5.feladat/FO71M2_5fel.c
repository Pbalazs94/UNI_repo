#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <fcntl.h>
#include <unistd.h>
pid_t pid;
//pid_t fork( );

int main()
{
    int ppid, pid,gpid;
    ppid=getpid( );
    if ((pid=fork())==0)
    {
        gpid=getpid( );
        exit(0);
    }
    exit(1);
return 0;
}
