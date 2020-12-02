#include <stdio.h>

void main() {
    int n1 = 9;
    int n2 = 8;
    int n3 = 7;
    
    int temp = 0;

    if(n1 > n2){
          temp = n2;
          n2 = n1;
          n1 = temp;
    }

     printf("第一次交换的顺序%d%d%d\n",n1,n2,n3);

      if(n2 > n3){
            temp = n3;
            n3 = n2;
            n2 = temp;
      }

      printf("第二次交换的顺序%d%d%d\n",n1,n2,n3);


       if(n1 > n2){
          temp = n2;
          n2 = n1;
          n1 = temp;
       }

      printf("第三次交换的顺序%d%d%d\n",n1,n2,n3);

    
}