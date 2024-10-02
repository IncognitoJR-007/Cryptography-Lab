import java.io.*;

class RC4 {
    public static void main(String[] args) throws IOException{
        int temp =0;
        String ptext;
        String key;
        int s[] = new int[256];
        int k[] = new int[256];
        DataInputStream in = new DataInputStream(System.in);
        System.out.println("Enter the plaintext");
        ptext = in.readLine();
        System.out.println("Enter the key");
        key = in.readLine();
        char ptextc[] = ptext.toCharArray();
        char keyc[] = key.toCharArray();
        int cipher[] = new int[ptext.length()];
        int decrypt[] = new int[ptext.length()];
        int ptexti[] = new int[ptext.length()];
        int keyi[] = new int[key.length()];
        for(int i=0;i<ptext.length();i++){
            ptexti[i] = (int)ptextc[i];
        }
        for(int i=0;i<key.length();i++){
            keyi[i] = (int)keyc[i];
        }
        for(int i=0;i<256;i++){
            s[i] = i;
            k[i] = keyi[i%key.length()];
        }
        int j=0;
        for(int i=0;i<256;i++){
            j = (j+s[i]+k[i])%256;
            temp = s[i];
            s[i] = s[j];
            s[j] = temp;
        }
        int i=0;
        j=0;
        int z=0;
        for(int y=0;y<ptext.length();y++){
            i = (i+1)%256;
            j = (j+s[i])%256;
            temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            z = (s[i]+s[j])%256;
            cipher[y] = s[z]^ptexti[y];
            decrypt[y] = s[z]^cipher[y];
        }
        System.out.println("The cipher text is:");
        display(cipher);
        System.out.println("The decrypted text is:");
        display(decrypt);
    }
    public static void display(int[] arr){
        for(int i=0;i<arr.length;i++){
            System.out.print((char)arr[i]);
        }
        System.out.println();
    }
}