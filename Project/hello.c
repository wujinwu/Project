#include <stdio.h>
#include <string.h>
#include <stdlib.h>

int main() {

  char str1[20] = "9999";
  char str2[20] = "66.0";
  char str3[20] = "bf";
  //基本数据类型转字符串

  int num1 = atoi(str1);
  double num2 = atof(str2);
  char num3 = str3[0];

  printf("%d,%f,%c \n",num1,num2,num3);
  getchar();
}

