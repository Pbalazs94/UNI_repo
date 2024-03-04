#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>
#include <sys/file.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <string.h>
#include <sys/wait.h>

int main()
{
	int fd, ret;
	char buf[35];
int pipefd[2];	// 2 eleme tomb, mert ket vege lesz a csonek, ezert ket valtozo neki
     pid_t cpid;	// gyerkoc pidje lesz benne
 
     //char szoveg[32];	// masik buffer a kuldendo szovegnek
	buf[0]=0;


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


 printf("%d: fd1: %d, fd2: %d\n",getpid(),pipefd[0],pipefd[1]);

     cpid = fork();
     if (cpid == -1) {
	   perror("fork");
	   exit(-1);
     }

     if (cpid == 0) {    /* gyerek vagyok */
	   printf("%d: gyerek vagyok\n",getpid());
	   
	  
	   strcpy(buf,"A hallgató neve: Petró Balázs \0");
	printf("irok a fifoba: %s:%ld\n",buf,strlen(buf));
	write(fd,buf,strlen(buf)); // irok bele valamit, hogy ne legyen ures
	   close(fd);

   	   exit(0);	// kilep
	   
	   } 
	   else {	/* szulo vagyok */
	   
	   printf("%d: szulo vagyok\n",getpid());
		
		printf("%d: megnezem mi van a csoben\n%d: ",getpid(),getpid());
	  ret=read(fd,buf,32); // olvasok belole ugyanazt, ret: mennyit sikerult olvasni
	printf("read() olvasott %d byteot, ami a kovetkezo: %s\n",ret,buf);
	   printf("\n%d:lezartak a cso masik oldalat\n",getpid());

	   close(fd);

	   wait(NULL);    /* varjunk gyerekre */

	   exit(0); // kilep
     }

	unlink("fifoka");	// letorlom a fifomat az fs-rol
}