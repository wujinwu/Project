#include <stdio.h>

void main() {
     
      double a = 0.0;
      printf("plase score \n");
      scanf("%lf",&a);
      if(a  > 90){
        printf("\nget BMW");
      }else if (a > 80)      {
        printf("\nget iphone");
      }else if (a > 60)      {
        printf("\nget wanju");
      }else {
        printf("\n no jiangli");
      }
    getchar();
    getchar();
}