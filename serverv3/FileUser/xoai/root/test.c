#include<stdio.h>
#include<string.h>
void tostring(char s[], int num){
     int n;
     while(num!= 0){
        n = num%10;
        num = (num-n)/10;
        switch(n){
            case 1: {strcat(s,"1"); break;}
            case 2: {strcat(s,"2"); break;}
            case 3: {strcat(s,"3"); break;}
            case 4: {strcat(s,"4"); break;}
            case 5: {strcat(s,"5"); break;}
            case 6: {strcat(s,"6"); break;}
            case 7: {strcat(s,"7"); break;}
            case 8: {strcat(s,"8"); break;}
            case 9: {strcat(s,"9"); break;}
            case 0: {strcat(s,"0"); break;}
        }
     }
    s = strrev(s);
     //return s;
}
void main(){
    char s[10];
    tostring(&s,1234);
    puts(s);
}
