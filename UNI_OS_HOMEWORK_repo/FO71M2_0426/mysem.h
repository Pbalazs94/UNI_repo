#include <sys/types.h>
#include <sys/ipc.h>
#include <sys/sem.h>
#include <stdio.h>

#define	PERM 0666
#define KEY  (key_t) 1

/* Néhány makró és deklaráció a termelő-fogyasztó problémához még kell */

#include <signal.h>

#define TFKEY (key_t) 2
#define N 32  /* A raktár méret */

/* A szemafor operációkat összefoglaló struktúrák az alábbiak. 
   Rendre két elemi oprációt kell majd végrehajtani. 
   Miután ezek "atomiak, a sorrendjük tulajdonképpen mindegy, 
   mégis, az "eredeti" sorrendben írtok meg azokat. 
*/

static struct sembuf termelo_be[2] = {
	2, -1, 0, 	/* down ures (üres rekeszre vár) */
	0, -1, 0};	/* down mutex (belép a raktárba */
	
static struct sembuf termelo_ki[2] = {
	0,  1, 0, 	/* up mutex (kilép a raktárból */
	1,  1, 0};	/* up teli (rekeszt töltött */

static struct sembuf fogyaszto_be[2] = {
	1, -1, 0, 	/* down teli (teli rekeszre vár) */
	0, -1, 0};	/* down mutex (belép a raktárba */

static struct sembuf fogyaszto_ki[2] = {
	0,  1, 0, 	/* up mutex (kilép a raktárból */
	2,  1, 0};	/* up ures (rekeszt kiürített */