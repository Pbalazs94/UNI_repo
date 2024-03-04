#include <stdio.h>
#include <stdlib.h>
#include <string.h>
int main(void)
{
    char exit[20];
    system("dir C:\\");
    printf("Ird be a date-t ,hogy a date parancs fusson le!\n");
    printf("Ird be a pwd-t ,hogy a pwd parancs fusson le!\n");
    printf("Ird be a who-t ,hogy a who parancs fusson le!\n");
    printf("Ird be az exit-t ,hogy az exit parancs fusson le/lepjen ki a terminal hasznalatbol!\n");
    system("cmd.exe date dir c:\\");
    if  (strcmp(exit, "exit") == 0)
    system("cmd.exe /c dir c:\\");

    printf("Az osszes folyamat befejezodott!");
    return 0;
}
