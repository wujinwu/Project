#include <stdio.h>
#include <string.h>
#include "p.c"

int  getTest(int n){
 if(n == 10){
   return 1;
 }else{
   return 2 * (getTest(n+1)+1);
 }
}
void main() {
  //猴子吃桃,吃一半 ，在多吃一个，第十天只剩一个，求一共有多少个桃子
  //第九天 (1 + 1)*2
  int res =  getTest(9);
  printf("res = %d\n",res);
  getchar();
}

