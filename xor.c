#include<stdio.h>

int main()
{
    char message[] = "Hello World";
    for(int i =0;message[i] != '\0';i++)
    {
        message[i] = message[i] ^ 0;
    }
    printf("XOR: %s\n",message);
    for(int i =0;message[i] != '\0';i++)
    {
        message[i] = message[i] ^ 0;
    }
    printf("Original: %s\n",message);
    return 0;
}