#include <sys/wait.h>
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <string.h>

/*
Feladat:Készítsen C nyelvű programot, ahol egy szülő processz létrehoz 
egy csővezetéket, a gyerek processz beleír egy szöveget a csővezetékbe 
(A kiírt szöveg: XY neptunkod), a szülő processz ezt kiolvassa, 
és kiírja a standard kimenetre
*/


int main() {
     int pipefd[2];	// 2 eleme tomb, mert ket vege lesz a csonek, ezert ket valtozo neki
     pid_t cpid;	// gyerkoc pidje lesz benne
     char buf;		// bufferke
     char szoveg[32];	// masik buffer a kuldendo szovegnek
     int ret;

     if (pipe(pipefd) == -1) {	// krealunk csovezeteket, es a ket fd a pipefd-ben lesz tarolva
	   perror("pipe");
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
	   
	   strcpy(szoveg,"Petró Balázs FO71M2 \0");   // feltoltom a buffert a kuldeni kivant stringgel
	   printf("%d: kuldom a szoveget: %s:%ld\n",getpid(),szoveg,strlen(szoveg));

	   write(pipefd[1], szoveg, strlen(szoveg));	// ontunk anyagot a csobe
	   close(pipefd[1]);    /* lecsukom a csatorna fedelet, a masik oldalon EOF lesz */
	   
	  
		close(pipefd[0]);    /* az olvaso veget csukjuk le */
	   

   	   exit(0);	// kilep

     } else {	/* szulo vagyok */
	   
	   //printf("%d: szulo vagyok\n",getpid());
		printf("%d: megnezem mi van a csoben\n%d: ",getpid(),getpid());

	   close(pipefd[1]);    /* az iras fd-t le is csukom */

	   while (read(pipefd[0], &buf, 1) > 0) {	// olvasunk a cso kimeneterol, amig van mit (1 byteonkent)
		 printf("%c",buf);

	   }

		printf("\n gyerek atadta a szoveget");
	   printf("\n%d:lezartak a cso masik oldalat\n",getpid());

	   close(pipefd[0]);	/* becsukom mar az olvaso veget */
   	   


	   wait(NULL);    /* varjunk gyerekre */
		
	   exit(0); // kilep
     }
}