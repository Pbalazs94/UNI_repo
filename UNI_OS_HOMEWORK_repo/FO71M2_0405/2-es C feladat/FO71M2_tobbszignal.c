#include <stdio.h>
#include <stdlib.h>
#include <signal.h>
#include <unistd.h>

void handleSignals (int sig){
if (sig == SIGQUIT)
printf("stop not allowed");

if (sig == SIGINT)
{
SIG_DFL;
}
}

//void handleSignalsSIGINT (int sig){
//SIG_DFL;
//}
void handleSignalsSIGINT_AFTER (int sig){
printf("a program befejezese!\n");
exit(0);
}
int main(int argc ,char* argv[]){
        struct sigaction sa;
        int x;

        sa.sa_handler = &handleSignals;
        sa.sa_flags = SA_RESTART;
        sigaction(SIGQUIT,&sa,NULL);


        sigaction(SIGINT,&sa,NULL);
        sa.sa_handler = &handleSignalsSIGINT_AFTER;

//      sa.sa_handler = &handleSignalsSIGINT;
//      sigaction(SIGINT,&sa,NULL);


 printf("Hello. Add meg a kivant szamot!\n Az elso SIGNINT parancs most amig nincs szam beirva es enter lenyomva csak folytatja a progit!\n");
        scanf("%d",&x);
        printf("Hello OS world! A kivant szam %d\n Mostantol a SIGNINT kilep a programbol!\n",x);
sigaction(SIGINT,&sa,NULL);
        while(1)
sleep(1);
    return 0;
}

