#include<stdio.h>
#include<string.h>
#include<stdlib.h>
#define MAX_NAME_LENGTH 100
struct udphdr {
  		unsigned short fileSize;           		// file size
  		unsigned char fileType[10];          		// file type
  		unsigned short fileNameLength;  	// file name length
  		char fileName[MAX_NAME_LENGTH];           //file name
	};
typedef struct udphdr Goitin;
void XuatFilebin(FILE* fo, Goitin gt){
    fwrite(&gt,sizeof(gt),1,fo);
    fseek(fo,0,SEEK_END);
    printf("Kich thuoc file la: %d", ftell(fo));
}
typedef struct udphdr Goitin;
int main(){
    Goitin gt;
    FILE *fo = fopen("pkt_hdr.bin","wb");
    printf("NHAP THONg TIN GOI TIN: \n");
    printf("Kich thuoc: ");
        scanf("%d",&gt.fileSize);
    printf("Ten: ");
        scanf("%s", &gt.fileName);
    printf("Kieu file: ");
        scanf("%s", &gt.fileType);
    gt.fileNameLength = strlen(gt.fileName);
    XuatFilebin(fo,gt);
    fclose(fo);
    return 0;
}
