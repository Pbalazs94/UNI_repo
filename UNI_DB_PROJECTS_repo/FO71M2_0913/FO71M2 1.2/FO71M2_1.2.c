#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
void pelda_1();
int main()
{
pelda_1();
return 0;
}
void pelda_1() {
FILE *fp;
char ch;
char fnev[50];
printf("Filenev: (a szovegfile amibe irjuk az uzenetet a '#' karakterig(Lehet ez munka.txt))");
scanf("%s", fnev);
fp = fopen(fnev, "w");
printf("Uzenet (Adja meg a szoveget amit a file -ba szeretne irni, majd '#' karakterrel zarja le a szoveget!)");
while( (ch = getchar()) != '#') {
putc(toupper(ch), fp);
}
fclose(fp);
fp = fopen(fnev, "r");
while ( (ch = getc(fp)) != EOF ) {
printf("%c",ch);
}
fclose(fp);
//return 0;
}
