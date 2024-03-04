#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>
#include <sys/file.h>
#include <fcntl.h>
#include <string.h>
#include <sys/wait.h>
#include <sys/ipc.h>
#include <sys/msg.h>
#include <sys/stat.h>
#include <sys/types.h>
#define MAX 10
#define BUFFSIZE 100


// structure for message queue
struct mesg_buffer {
    long mesg_type;
    char mesg_text[100];
} message;

int main()
{
     pid_t cpid;	// gyerkoc pidje lesz benne

char sen2[BUFFSIZE];

     cpid = fork();
     if (cpid == -1) {
	   perror("fork");
	   exit(-1);
     }
	 
	 
 key_t key;
    int msgid;
  
    // ftok to generate unique key
    key = ftok("progfile", 65);
  
    // msgget creates a message queue
    // and returns identifier
    msgid = msgget(key, 0666 | IPC_CREAT);
    message.mesg_type = 1;
	
	
     if (cpid == 0) {    /* gyerek vagyok */
	   printf("%d: gyerek vagyok\n",getpid());
printf("Write Data : ");
    fgets(message.mesg_text,MAX,stdin);
 
    // msgsnd to send message
    msgsnd(msgid, &message, sizeof(message), 0);


}
	   else {	/* szulo vagyok */

	   printf("%d: szulo vagyok\n",getpid());

	
	
	   wait(NULL);    /* varjunk gyerekre */
 printf("\n Ha ki akar lepni gepelje be az exit -et! \n");
scanf("%s",sen2);
if (strcmp(sen2, "exit")==0)
{
exit(0);
}
printf("MENU OPCIOK:  1 beirasa uzenetek darabszamanak kiirasa \n 2 beirasa uzenet kiolvasasa \n");
scanf("%s",sen2);
if (strcmp(sen2, "1")==0)
{
msgctl(msgid,IPC_STAT,0);
	
}
if (strcmp(sen2, "2")==0)
{
	// msgrcv to receive message
    msgrcv(msgid, &message, sizeof(message), 1, 0);
	 // display the message
    printf("Data send is : %s \n", message.mesg_text);
// to destroy the message queue
    msgctl(msgid, IPC_RMID, NULL);
printf("\n");
}


int ok=1;
do {
	printf("Kilepesi Opcio: SIGTERM beirasa= kilepes \n");
scanf("%s",sen2); 
if (strcmp(sen2, "SIGTERM") == 0)
{
	 // to destroy the message queue
    msgctl(msgid, IPC_RMID, NULL);
exit(0);
}
else
{
printf("A begepelt szoveg: %s \n",sen2);
printf("Ha begepelt szoveg nem SIGTERM akkor folytatodik a bekeres amíg nem SIGTERM a szoveg! \n");    
}
}while(ok!=0);
}

}