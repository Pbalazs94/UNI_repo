#include "mysem.h"

#include <stdlib.h>

#include <unistd.h>

int main( ) {

int 	id; /* A szemafor azonosítója */

 

	if ((id = semget(KEY, 1, 0)) < 0) { /* Még nem létezik. */

		if ((id = semget(KEY, 1, PERM | IPC_CREAT)) < 0) {

		 	perror(" A szemafor nem nyitható meg. ");

			exit(-1);

		}

	}

	else    {

		perror(" Már létezik a szemafor. ");

		exit(0);

	}



	if (semctl(id, 0, SETVAL, 1) < 0) 

		perror(" Nem lehetett inicializálni. ");

	else	puts(" Kész és inicializált a szemafor. ");



	//exit(0);



struct sembuf up[1]  =  {0,  1, SEM_UNDO};

struct sembuf down[1] = {0, -1, SEM_UNDO};



	if ((id = semget(KEY, 1, 0)) < 0) { 

		perror(" Még nem létezik a szemafor. ");

		exit(-1);

	}

for (int i=0;i<3;i++){

	puts(" Itt fut a nem kritikus szakasz. ");



	semop(id, down, 1);   /* A belépési szakasz */

		puts("    Itt fut a kritikus szakasz. ");

		sleep(3);

		printf("PID: %d\n",getppid());

	semop(id, up, 1);    /* Ez a kilépési szakasz */



	puts(" Itt ismét nem kritikus szakasz fut. ");

}

	//exit(0);



	if ((id = semget(KEY, 1, 0)) < 0) { 

		perror(" Már nem létezik a szemafor. ");

		exit(-1);

	}



	if (semctl(id, 0, IPC_RMID, 0) < 0) {

		perror(" Nem sikerült törölni.");

		exit(-1);

	}



	puts(" A szemafort megszüntettük. \n");

	exit(0);

}