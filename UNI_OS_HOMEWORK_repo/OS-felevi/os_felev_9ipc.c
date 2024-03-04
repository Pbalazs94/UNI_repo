#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>
#include <sys/file.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <string.h>
#include <sys/wait.h>
#include <signal.h>
#define BUFFSIZE 100
int main()
{

	int sig;
	int fd, ret;
	char buf[35];
int pipefd[2];	// 2 eleme tomb, mert ket vege lesz a csonek, ezert ket valtozo neki
     pid_t cpid;	// gyerkoc pidje lesz benne

char sen[BUFFSIZE];
char sen2[BUFFSIZE];
char senSIGTERM[]="SIGTERM";
	buf[0]=0;



     cpid = fork();
     if (cpid == -1) {
	   perror("fork");
	   exit(-1);
     }

     if (cpid == 0) {    /* gyerek vagyok */
	   printf("%d: gyerek vagyok\n",getpid());

printf(" Adj meg adatokat amivel feltoltom a szavak.txt-t\n ENTER lenyomása után már több adatot nem tudsz felvinni!\n");    
fgets(sen, BUFFSIZE, stdin);
	write(fd,sen,strlen(sen));

FILE *fp;

		fp = fopen("szavak.txt", "w+");
		fprintf(fp, "Sorszam: 1.\n");
		fputs(sen, fp);
		fclose(fp);

	   }
	   else {	/* szulo vagyok */

	   printf("%d: szulo vagyok\n",getpid());

		ret=mkfifo("fifoka",00666);	// letrehozom a fifo-t a filerendszeren
	if (ret == -1) {
	    perror("mkfifo()");
	    exit(-1);
	}

	fd=open("fifoka",O_RDWR);	// megnyitom a fifot amit az iment hoztam letre
	if (fd == -1) {
	    perror("open() hiba!");
	    exit(-1);
	}


	   wait(NULL);    /* varjunk gyerekre */


int ok=1;
do {

scanf("%s",sen2); 
if (strcmp(sen2, "SIGTERM") == 0)
{
close (fd);
unlink("fifoka");
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