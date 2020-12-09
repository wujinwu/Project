#include <stdio.h>
#include <string.h>
void main() {
    //输入数字打印空心金字塔
    int num =5;
    printf("plase * num\n");
    scanf("%d",&num);
   for (int i = 1;i <= num;i++){
       for (int k = 1;k <= num-i;k++){
          printf(" ");
      }
      for (int j = 1;j <=(2*i)-1;j++){
          if(i==1 || i== num || j == 1 || j == (2*i)-1){
             printf("*");
          }else{
            printf(" ");
            }
      }
        printf("\n");
   }
     getchar();
     getchar();
}
