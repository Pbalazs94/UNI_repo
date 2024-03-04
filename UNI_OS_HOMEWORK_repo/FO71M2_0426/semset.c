/*	wait-or problema	*/
/*	Kreál/azonosít
	semaphor készletet, benne N semaphor-t. 
	A kezdô értéket 0-ra allitja
*/
//semset
#define N 4	
#include <stdlib.h>
#include <stdio.h>
#include <sys/types.h>
#include <sys/ipc.h>
#include <sys/sem.h>
#define SEMKEY 123456L  /* kulcs a semget-nek; remelem, egyedi */

	int semid,	/* semaphor set azonosito */
	    nsems=N,	/* semaphorok szama a keszletben */
	    semnum,	/* semapho szam a set-en belul */
	    rtn;	/* visszateresi ertek */
	struct sembuf buf={0,1,0};
	int semflg;	/* flag */
	ushort t[N]; 
	union semun arg; /* union a semctl parancs argumentumnak */
	int cmd;	/* semctl-nek szolo parancs */
	char c='n';

int main()
{

	semflg = 00666 | IPC_CREAT;
	semid = semget (SEMKEY, nsems, semflg);
	if (semid < 0 ) {perror(" semget hiba"); exit(0);}
	else printf("\n semid: %d ",semid);
	arg.array=&t[0];
	for(semnum=0;semnum<N;semnum++) arg.array[semnum]=0;
	printf(" Eddig1");
	rtn = semctl(semid,nsems,SETALL,arg); 
	printf("\nOk, kesz a keszlet. Esetleg megszuntessuk? (y)");
	scanf("%c", &c); 
	if(c=='y') semctl(semid,nsems,IPC_RMID,NULL); 
	rtn = semctl(semid,nsems,GETALL,arg);
	printf(" Igy allunk:");
	for(semnum=0;semnum<N;semnum++) {
	  printf("%d ",arg.array[semnum]);
	  }
/*	semop(semid, &buf, 1);
	printf(" Kilepes\n"); rtn = semctl(semid,nsems,GETALL,arg);
	for(semnum=0;semnum<N;semnum++) {
	   printf(" Igy allunk: %d ",arg.array[semnum]);
	  }
*/
}
