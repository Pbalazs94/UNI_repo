#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>
#include <sys/types.h>
#include <fcntl.h>
#include <string.h>
#include <sys/wait.h>
#include <signal.h>
#include <sys/ipc.h>
#include <sys/shm.h>
#define SHMKEY 69905L
#define KEY  1
#define PERM 0666
#define BUFFSIZE 100
int main()
{
int shmid;		/* osztott mem azonosito */
	key_t key;		/* kulcs a shmem-hez */
	int size=512;		/* osztott szegmens meret byte-ban */
	int shmflg;		/* flag a jellemzokhoz */
struct vmi {
		int  hossz;
		char szoveg[512-sizeof(int)]; /* az egesz merete 512, ezert a hossz valtozot levonjuk a tombbol */
	} *segm;
	
	int rtn;		/* rensz.hivas visszter. ertek */
	int cmd;		/* parancskod */
	struct shmid_ds shmid_ds, *buf; /* adatstruktura a status
					   adatok fogadasahoz */
	buf = &shmid_ds;	/* es annak pointere */
	key = SHMKEY;
	
	char bufffer[35];
     pid_t cpid;	// gyerkoc pidje lesz benne

char sen2[BUFFSIZE];
char senSIGTERM[]="SIGTERM";
	bufffer[0]=0;

     cpid = fork();
     if (cpid == -1) {
	   perror("fork");
	   exit(-1);
     }

     if (cpid == 0) {    /* gyerek vagyok */
	   printf("%d: gyerek vagyok\n",getpid());
shmflg = 0;
	if ((shmid=shmget(key, size, shmflg)) < 0) {
	   printf("Nincs meg szegmens! Keszitsuk el!\n");
	   shmflg = 00666 | IPC_CREAT;
	   if ((shmid=shmget(key, size, shmflg)) < 0) {
	      perror("Az shmget() system-call sikertelen!\n");
	      exit(-1);
	   }
	} else printf("Van mar ilyen shm szegmens!\n");

	printf("\nAz shm szegmens azonositoja %d: \n", shmid);

	
	
}
 if (cpid == 1) {    /* 2.gyerek vagyok */
	   printf("%d: 2. gyerek vagyok\n",getpid());
shmflg = 0;
/* Attach - rakapcsolodunk*/

	shmflg = 00666 | SHM_RND;	/* RND az igazitashoz */
	segm = (struct vmi *)shmat(shmid, NULL, shmflg);
				/* Itt a NULL azt jelenti, hogy az OS-re bizom, milyen cimtartomanyt hasznaljon. */
	if (segm == (void *)-1) {
		perror("Sikertelen attach!\n");
		exit(-1);
	}

/* Sikeres attach utan a "segm" cimen ott az osztott memoria.
   Ha van benne valami, kiiratom, utana billentyuzetrol kerek uj beteendo szoveget */

/* Kerdes: ez alabbi jol fog mindig mukodni? */
	if (strlen(segm->szoveg) > 0) 
		printf("\n Regi szoveg: %s (%d hosszon)",segm->szoveg,segm->hossz);
 
	printf("\nUj szoveget kerek!\n");
	scanf("%s",segm->szoveg);
	printf("Az uj szoveg: %s\n",segm->szoveg);
	segm->hossz=strlen(segm->szoveg);
		
/* Detach */
	shmdt(segm);
	
	
}
	   else {	/* szulo vagyok */

	   printf("%d: szulo vagyok\n",getpid());
		
	   wait(NULL);    /* varjunk gyerekre */
shmflg = 0;
do
	{
		printf("\nAdd meg a parancs szamat:\n");
		printf("0. IPC_STAT (status)\n");
		printf("1. IPC_RMID (torles)\n> ");
		scanf("%d",&cmd);
	} while (cmd < 0 || cmd > 1);

	switch (cmd)
	{
	    case 0:
		rtn = shmctl(shmid, IPC_STAT, buf);
		printf("Szegmens merete: %ld\n",buf->shm_segsz);
		printf("Utolso shmop()-os processz pid-je: %d\n",buf->shm_lpid);
		break;
	    case 1:
		rtn = shmctl(shmid, IPC_RMID, NULL);
		printf("Szegmens torolve. Hibakod: %d\n", rtn);
	}

	exit(0);

}

}