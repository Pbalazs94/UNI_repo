#define P_PID 0

#include <stdio.h>
#include <stdlib.h>
#include <signal.h>
#include <sys/types.h>
void handler(void) {;} /* Nem csinál semmit a kezelő */
int

int main(int argc, char **argv)
{
pid_t	pid; 
	if(argc < 2) {
		printf(" \n Nincs kinek, exitálok. \n");
		exit(1);
	}
	pid = atoi(argv[1]); 
	sigsend(P_PID, pid, SIGALRM); /* Itt a küldés! */
	struct sigaction action;

	action.sa_handler=(void (*)()) handler;
	sigaction(SIGALRM, &action, NULL); /* Diszponáltunk. */
	printf("\n Várakozni kezdek ... \n");
	pause( );
	
	printf(" Kibillentem a várakozásból, exitálok. \n");
	exit(0);	
}