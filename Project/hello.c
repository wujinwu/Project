#include <stdio.h>
#include <string.h>
void main() {
    //一直输入,直到输入n退出
     int i = 0;
     do{
      if(i % 5 == 0 && i % 3 != 0){
          printf("%d\n",i);
      }
      i++;
     }while(i<=100);//循环条件
   

     getchar();
}
