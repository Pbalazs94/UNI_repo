#include <stdio.h>
#include <stdlib.h>
#include <sys/stat.h>
#include <sys/types.h>
#include <unistd.h>
#include <fcntl.h>
#include <sys/file.h>

int main()
{

char buf[20];
int bufLength;
int fileDescriptor;
int writeInfo;
int seekInfo;
int readInfo;

//fájl megnyítása open()-el

fileDescriptor =open("FO71M2.txt",O_RDWR);
if(fileDescriptor ==-1){
perror("open() hiba");
exit(fileDescriptor);
}
printf("File Descriptor erteke:%d\n", fileDescriptor);

//Pozicionalas
seekInfo =lseek(fileDescriptor,0,SEEK_SET);
if(seekInfo ==-1){
perror("A pozicionalas nem jo, hiba");
exit(seekInfo);
}
//Olvasás read()el

readInfo = read(fileDescriptor,buf,15);
if(readInfo ==-1)
{
perror("Az olvasas nem volt sikeres hiba");
exit(seekInfo);
}
printf("A read() erteke : %d \n",readInfo);
printf("A beolvasott ertek : %s ",buf);

//írás write()al

strcpy(buf, "Ez egy teszt");
bufLength =strlen(buf);
writeInfo =write(fileDescriptor,buf,bufLength);
if (writeInfo ==-1){
perror("Az írás nem volt sikeres");
exit(writeInfo);
}
printf("A write()-al beirt byte-ok szama: %d",writeInfo);
    return 0;
}
