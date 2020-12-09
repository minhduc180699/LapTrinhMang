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
}
typedef struct udphdr Goitin;
int main(){
    Goitin gt;
    FILE *fo = fopen("pkt_hdr.bin","rb");
    fread(&gt,sizeof(gt),1,fo);
    printf("Kich thuoc: %d\n",gt.fileSize);
    printf("Kieu file: %s\n",gt.fileType);
    printf("Do dai ten file: %d\n",gt.fileNameLength);
    printf("Ten file: %s\n",gt.fileName);
    fclose(fo);
    return 0;
}
