#include<stdio.h>

char alphabet[26] = "abcdefghijklmnopqrstuvwxyz";
char substitution[26] = "zyxwvutsrqponmlkjihgfedcba";

void encrypt(){
    char message[100];
    printf("Enter the message: ");
    scanf("%s",message);
    for(int i =0;message[i]!='\0';i++){
        for(int j=0;j<26;j++){
            if(message[i]==alphabet[j]){
                message[i] = substitution[j];
                break;
            }
        }
    }
    printf("Encrypted message: %s\n",message);
}
void decrypt(){
    char message[100];
    printf("Enter Cipher text: ");
    scanf("%s",message);
    for(int i =0;message[i]!='\0';i++){
        for(int j=0;j<26;j++){
            if(message[i]==substitution[j]){
                message[i] = alphabet[j];
                break;
            }
        }
    }
    printf("Decrypted message: %s\n",message);
}


int main(){
    int choise;
    do{
        printf("1. Encrypt\n 2. Decrypt\n 3. Exit\n");
        printf("Enter your choise: ");
        scanf("%d",&choise);
        switch(choise){
            case 1:
                encrypt();
                break;
            case 2:
                decrypt();
                break;
            case 3:
                break;
            default:
                printf("Invalid choise\n");
                break;
        }
    }while(choise!=3);
    return 0;
}