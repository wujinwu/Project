#include <stdio.h>

int n = 100;

int myCal(int n1,int n2,char oper){
   int n;
    switch (oper)
    {
    case '+':
        n = n1 + n2;
        break;
     case '-':
       n =  n1 - n2;
        break;
    default:
        break;
    }
         return n;
}

 