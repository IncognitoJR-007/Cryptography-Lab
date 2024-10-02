#include <stdio.h>
#include <string.h>

void perform_operation(char *str, char op) {
    for (int i = 0; str[i] != '\0'; i++) {
        if (op == 'A') {
            str[i] &= 127;
        } else if (op == 'X') {
            str[i] ^= 127;
        } else if (op == 'O') {
            str[i] |= 127;
        }
    }
}

int main() {
    char str[] = "Hello World";
    perform_operation(str, 'X');
    printf("XOR: %s\n", str);
    strcpy(str, "Hello World");
    perform_operation(str, 'A');
    printf("AND: %s\n", str);
    strcpy(str, "Hello World");
    perform_operation(str, 'O');
    printf("OR: %s\n", str);
    return 0;
}