#include <stdio.h>
#include <stdlib.h>

int main()
{
    FILE* fp;
    fp=fopen("vezeteknev.txt","w+");

    fprintf(fp," Nev=Petro Balazs,\n Szak=Mernokinformatikus,\n Neptunkod=FO71M2 \n");
    fclose(fp);
    char  c;
   fp = fopen("vezeteknev.txt", "r");

    if (fp == NULL)
    {
        printf("Cannot open file \n");
        exit(0);
    }

    // Read contents from file
    c = fgetc(fp);
    while (c != EOF)
    {
        printf ("%c", c);
        c = fgetc(fp);
    }


getchar();
    fclose(fp);
    return 0;
}
