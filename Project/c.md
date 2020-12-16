# c语言笔记
**1.hello world 输出**
```c
printf("hello world");
```
**2.输出1，2，3，4不重复出现的组合**
```c
void main() {
	//printf("hello world");
	int i, j, k;
	for (i = 1; i < 5; i++) {
		for (j = 1; j < 5; j++) {
			for (k = 1; k < 5; k++) {
				if (i != j && i != k && j != k) {
					printf("%d,%d,%d\n",i, j, k);
				}
			}
		}
	}
	getchar();
}

```
**3.企业发放的奖金根据利润提成.**  
	利润(I)低于或等于10万元时，奖金可提10% ；  
	利润高于10万元，低于20万元时，低于10万元的部分按10% 提成，高于10万元的部分，可提成7.5 % ；  
	20万到40万之间时，高于20万元的部分，可提成5 % ；  
	40万到60万之间时高于40万元的部分，可提成3 % ；  
	60万到100万之间时，高于60万元的部分，可提成1.5 % ；  
	高于100万元时，超过100万元的部分按1 % 提成。  
	从键盘输入当月利润I，求应发放奖金总数？
```c
void main() {
	//企业发放的奖金根据利润提成。

	//	利润(I)低于或等于10万元时，奖金可提10% ；
	//	利润高于10万元，低于20万元时，低于10万元的部分按10% 提成，高于10万元的部分，可提成7.5 % ；
	//	20万到40万之间时，高于20万元的部分，可提成5 % ；
	//	40万到60万之间时高于40万元的部分，可提成3 % ；
	//	60万到100万之间时，高于60万元的部分，可提成1.5 % ；
	//	高于100万元时，超过100万元的部分按1 % 提成。
	//	从键盘输入当月利润I，求应发放奖金总数？
	double i;
	double b = 0;
	printf("你的净利润是：\n");

	scanf_s("%lf", &i);
	if (i <= 100000) {
		b = i * 0.1; 
	}
	else if (i <= 200000) {
		b = 100000 * 0.1 + (i - 100000) * 0.075;

	}
	else if (i <= 400000) {
		b = 100000 * 0.1 + 100000 * 0.075 + (i - 200000) * 0.05;
	}
	else if (i <= 600000) {
		b = 100000 * 0.1 + 100000 * 0.075 + 200000 * 0.05 + (i - 400000) * 0.03;
	}
	else if (i <= 1000000) {
		b = 100000 * 0.1 + 100000 * 0.075 + 200000 * 0.05 + 200000 * 0.03 + (i - 600000) * 0.015;
	}
	else if (i > 1000000) {
		b = 100000 * 0.1 + 100000 * 0.075 + 200000 * 0.05 + 200000 * 0.03 + 400000 * 0.015 + (i - 1000000) * 0.01;
	}

	printf("提成为：bonus=%lf", b);

	printf("\n");
	getchar();
}
```

**4.符号**
```c
void main() {
	//1.\t制表符 
	//2.\n换行符  \r表示回车
	//3.\\ 第一个\转义符  第二个\表示输出内容
	//4.\" 第一个\转义符  第二个"表示输出内容
	printf("姓名\t年龄\t性别\t爱好\n1\t2\t3\t4  \n");
	printf("撒\n");
	printf("\\ \n");
	printf("\" \n");
	getchar();
}
```

**5.输出**
```c
void main() {
	int num = 1;
	double score = 2.0;
	char gender = 'A'; 
	char name[] = "科学上网";

	/**
	*变量表示一个存储区域(不同的数据类型，占用的空间大小是不一样的) 
	*整数%d
	*小数%f, 保留小数点数%f.2
	*字符%c
	*字符串%s
	*/
	printf("num = %d , score = %.2f , gender = %c ,name = %s",num,score,
	gender,name);

	getchar();
}
```
**6.整数类型**  
char	1 字节 -2的7次方	-128 到 127 或 0 到 255   2的8次方减一  
  有符号  负的2的7次方  正的2的7次方-1  
  无符号   0 到  2的8次方-1  
$
{-2^7 = 128}
$  
$
{2^7 -1= 127}
$  
$
{2^8 - 1 = 255}
$  
unsigned char	1 字节	0 到 255  
signed char	1 字节	-128 到 127  
int	2 或 4 字节	-32,768 到 32,767 或 -2,147,483,648 到 2,147,483,647  

unsigned int	2 或 4 字节	0 到 65,535 或 0 到 4,294,967,295  
short	2 字节	-32,768 到 32,767  
unsigned short	2 字节	0 到 65,535  
long	4 字节	-2,147,483,648 到 2,147,483,647  
unsigned long	4 字节	0 到 4,294,967,295  
**浮点数类型**  
float	4 字节	1.2E-38 到 3.4E+38	6 位小数  
double	8 字节	2.3E-308 到 1.7E+308	15 位小数  
long double	16 字节	3.4E-4932 到 1.1E+4932	19 位小数  
```c
void main() {

    float f = 5.12f;
	float f1 = .512f;
	double d = 5.12E2; //5.12*10^2
	double d1 = 5.12E-2;//5.12*10^-2

	printf("f = %f , f1 = %f , d = %f ,d1 = %f",
	f,f1,d,d1);
	getchar();
}
```
**char类型**
```c
void main() {
char c = 'a';
char c1 = 'A';

printf("c = %c , c1 = %c \n",c,c1);
printf("c = %d , c1 = %d ",c,c1);
getchar();
}
```
**bool类型**
```c
void main() {
    //0假 1 真
	int n = 1;
	if(n){
		printf("我是真的 \n");
	}else{
		printf("我是假的 \n");
	}
	getchar();
}
```

**基本数据类型转换**  
低精度自动转换高精度  
高精度 转 低精度 强制类型转换 造成精度损失 

```c
//类型转换
void main() {
    double n = 156.12;
	int num = (int)n;
	printf("num = %d \n",num);//直接截断小数，不是四舍五入
	getchar();
}

void main() {
    double n = 156.12;
	double db = (9*3.2+5*4.2);//28.8 + 21 = 49.8
	int num = (int)(9*3.2+5*4.2);//49
	printf("num = %d  db = %.2f\n",num,db);
	getchar();
}


void main() {
    char c = 'a';
	int t = 5;
	float f = .314f;
	double result = c + t + f;
	printf("强制转换 int  result = %d \n",(int)result); //102
	printf("强制转换 char result = %c \n",(char)result);//f
	printf("字符 result = %f \n",result);//102.314000
	printf("字符 result = %.2f \n",result); //102.31
	getchar();
}
```

## 指针  
1.指针是什么 --> 指针表示一个地址  
2.指针类型 要  和 值类型一致 比如 char *p --> char c; int *p --> int i  
3.数组指针，结构体指针 ,二级指针 多级指针
```c
void main() {
    char c = 'a';
	//如果要输出变量的地址，使用格式 %p
    //&c 表示 取出 'c变量' 内存地址
	printf("c = %c c内存地址 = %p \n",c,&c); 
	getchar();
}


void main() {
    char c = 'a';
	//char * 表示类型 为 指针类型
	//p 指向了 一个 char 类型的 内存地址
	char *p = &c;
	printf("c = %c 指针p = %p \n",c,p);  
	printf("p的地址 = %p \n",&p);  //指针p的地址
	getchar();
}

void main() {
    char c = 'a';
	//char * 表示类型 为 指针类型
	//p 指向了 一个 char 类型的 内存地址
	char *p = &c;
	printf("c = %c 指针p = %p \n",c,p);  
	 //指针p本身的地址
	printf("p的地址 = %p \n",&p); 
    //获取指针p指向的值
	printf("p指向的值 = %c \n",*p);
	getchar();
}

void main() {
   
    int i = 999;
    printf("i = %d \n",i); //999
	int *ptr = &i;
	*ptr = 666;
	printf("ptr = %p \n",ptr);//i的地址
	printf("i = %d \n",i);    //666
	printf("i = %d \n",*ptr); //666
	getchar();
}


void main() {
   
    int i = 999;
    printf("i = %d \n",i); //999
	int *ptr = &i;
	*ptr = 666;
	printf("ptr = %p \n",ptr);//i的地址
	printf("i = %d \n",i);    //666
	*ptr = 777;
	printf("i = %d \n",*ptr); //777
	getchar();
}
```
## 值传递 地址传递
1.默认传递值 -- 基本数据类型，结构体，共用体  i --> 地址 --> 值  传递值
2.默认传递地址 -- 指针和数组  i --> 地址 --> 地址 -->值 传递的是第二个地址
```c

void main() {
	
    int i = 999;
	int *ptr = &i; 
	int *p = ptr;
    int *pr = p;
	

	printf("i = %p *ptr = %p *p = %p\n",&i,ptr,p); 
	//i = 0061FF10 *ptr = 0061FF10 *p = 0061FF10
	printf("i = %d *ptr = %d *p = %d\n",i,*ptr,*p); 
	//i = 999 *ptr = 999 *p = 999
    printf("pr = %p pr = %d\n",pr,*pr);
	 //pr = 0061FF10 pr = 999
	getchar();
}


```

**练习**
```c
void main() {
	char name[10] = "爱情";
	int age  = 18;
	float score = 75.9f;
    char gender = 'M';
	char hobby[20] = "男朋友,女朋友";
	printf("姓名\t 年龄 \t 成绩 \t 性别 \t 爱好 \n%s \t %d \t %f \t %c \t %s \n",
	name,age,score,gender,hobby);
	//输出
	//姓名	 年龄 	 成绩 	 性别 	 爱好
    //爱情 	 18 	 75.900002 	 M 	 男朋友,女朋友

	getchar();
}


void main() {

	int i = 9;
	int i1 = 99;

    int sum = i + i1;
	int sub = i1 -i;
	int c = i1 * i;
	int c1 = i1 / i;

    printf("************************************\n");
	printf("********小小计算机**********\n");
	printf("************************************\n");

	printf("%d + %d = %d \n",i,i1,sum);
    printf("%d - %d = %d \n",i1,i,sub);
	printf("%d * %d = %d \n",i1,i,c);
	printf("%d / %d = %d \n",i1,i,c1);
	getchar();
}


void main() {
    int num =10;  

	if(num % 2 == 0 ){
 		printf("%d 是 偶数\n",num);
	}else{
		printf("%d 是 奇数\n",num);
	}
	getchar();
}
```
## 常量  
整型常量，字符常量,浮点型常量,字符串常量  
define 和 const  
1.const需要定义类型,define不需要  
2.const编译运行才生效,define 预处理阶段就生效了  


```c
void main() {
   //0x开头 16进制
    int num =0x12;  
     //0开头 8进制
    int num1 =0234;  
	//"\t字符常量"
	char c = '\t';
    //字符串常量 \转义符
	char c1[200] = "字符串常量";
	char c2[200] = "字符串 \\ 常量";
	printf("%d %d %d %s %s\n",num,num1,c,c1,c2);
	getchar();
}


#define WIDTH 10 //常量定义 define可以不加分号
#define HEIGHT 10
void main() {
  
	int s;
	s = WIDTH * HEIGHT;
	printf("ssss %d\n",s);
	getchar();
}



const int  LENGTH = 10;//const定义常量
const int  WIDTH  = 5;
void main() {
  
	int s;
	s = WIDTH * LENGTH;
	printf("s= %d\n",s);
	getchar();
}
```
3.define 只是简单替换  
4.const可以调试,define不可以调试  
```c
#define A 1
#define B A+1
#define D A/B*3

void main() {
  
   //define 只是一个简单的替换 A/B*3=A/A+1*3=1/1+1*3=1+3=4        
	printf("d = %d\n",D);
	getchar();
}

```
5.const不能重复定义,define通过undef取消某个符号的定义，再重新定义

```c
#define A 1
#define undef A
#define A 4

void main() {   
	printf("A = %d\n",A);//4
	getchar();
}
```

6.define可以配合 #ifdef,#ifndef,#endif来使用,比如通过#define来启动，关闭调试信息
```c
#define A

void main() {
  
    #ifdef A
       printf("ok,调试信息 \n");
	#endif

	#ifndef A
       printf("hello,其他信息 \n");
	#endif

	getchar();
}
```

## 算数运算符

1.除法
```c
void main() {
  
    int dub = 10 / 4;//int砍掉小数 = 2
	printf("dub=%d\n",dub);

    double dubb = 10.0 / 4;
	//如果希望保留小数,参与运算数必须带有浮点数,否则=2.0000
	printf("dubb=%.2f\n",dubb);//2.50

	getchar();
}
```

2.取模
```c
void main() {
   //10 % 3 = 10 - (10/3) * 3 = 10 - 3*3 = 10 - 9 = 1
   int i = 10 % 3;
   //10 % 4 = 10 - (10/4) * 4 = 10 - 2*4 = 10 - 8 = 2
   int i2 = 10 % 4;
    printf("i = %d i2 = %d\n",i,i2);
	getchar();
}
```

3.++,--
```c
void main() {
    int i = 10;
	int j = i++;
	//i++ 先赋值  再自增 j = 10; i = 11; ==> j = i ; i = i +1;
    printf("j = %d ,i = %d \n",j,i);
	int k = ++i;
	//++i先自增，再赋值， k = 12 ,i = 12; ==> i = i + 1; k = i;
	printf("k = %d ,i = %d \n",k,i);
	getchar();
}
```
### 练习  

```c
void main() {
   //97天放假，问，有多少个星期零多少天
   int i = 97;
   int day = i % 7;

   int week = i / 7;
   printf("还有%d周 ,零%d天放假  \n",week, day);

   getchar();
}

```
华氏温度转摄氏温度，注意要得到浮点数除法的小数
```c
void main() {
 
   double huashi = 200.0;

   double sheshi = 5.0/9.0*(huashi - 100);

   printf("%.2f华氏温度 = %.2f摄氏温度\n",huashi,sheshi);
   //200.00华氏温度 = 55.56摄氏温度
   getchar();
}
```

###关系运算符 > < == <= >= != 
```c

void main() {
   //假 为  0 ，真 为 非0 (默认为1)
   int a = 8;
   int b = 7;
   printf("a > b = %d\n",a>b);
   printf("a < b = %d\n",a<b);
   printf("a <= b = %d\n",a<=b);
   printf("a >= b = %d\n",a>=b);
   printf("a == b = %d\n",a==b);
   printf("a != b = %d\n",a!=b);
   getchar();
}
```

### 逻辑运算符 &&逻辑与运算符 ||逻辑或运算符 !逻辑非运算符
```c
void main() {
   //假 为  0 ，真 为 非0
   int a = 80;
  if(a > 70 && a < 90){
	  printf("ok,a 在70 与 90 区间内\n"); //输出
  }else {
	  printf("a不在70 与 90 区间内\n");
  }
    
   getchar();
}


void main() {
   //假 为  0 ，真 为 非0
   int a = 80;
   int i = 99;
  if(a < 100 && i++  > 99){
	  printf("ok100");
  }else {
	  printf("i = %d\n",i);//输出
  }
    
   getchar();
}
```
||逻辑或  
```c
void main() {
   //假 为  0 ，真 为 非0
   int a = 80;
   int i = 99;
  if(a < 100 || i++  > 99){
	  printf("ok100");//输出
  }else {
	  printf("i = %d\n",i);
  }
    
   getchar();
}
```

### 赋值运算符  = += *= /= %= 
1.= 把右边赋值给左边  
```c
void main() {
  
   int a = 80;
   int i = 99;
   
   int temp = a;
   a = i;
   i = temp;
   printf("a = %d,i = %d \n",a,i);//a = 99,i = 80
   getchar();
}
```
2.+= 
```c
void main() {

	int a = 3;
	a += 3;//a = a + 3
	printf("a = %d \n",a);//a = 6

	getchar();
}
```
3.*=

```c
void main() {

	int a = 3;
	a *= 3;//a = a * 3
	printf("a = %d \n",a);//a = 9

	getchar();
}
```

### 三元运算符   
1.条件表达式?表达式1:表达式2   
2. 表达式为真返回1，为假返回2  

```c
void main() {
	int a = 3;
    int b = 4;
	int res = a > b ? a : b; //返回最大值
	printf("res  = %d \n",res);//res = 4

	getchar();
}
```
练习，取最大值
```c

void main() {
	int a = 3;
    int b = 4;
	int c = 8;
	int res = a > b ? a : b;  
	// 如果a大于b,返回a,否则返回b
	int m = res > c ? res : c; 
	// 如果rec大于c,返回res,否则返回c
	printf("m  = %d \n",m); //8

	getchar();
}
```
   
### 运算符优先级
1.三个从右向左  赋值运费符，单目运算，三目运算  
2.其他从左向右  
3.逗号运算符优先级最低   
4.优先级的大概顺序,算数>关系>逻辑(逻辑非除外)>赋值>逗号  
5.?怎么用


### 控制台输入scanf
```c

void main() {
      char name[100] = "";
      printf("you age \n");
      scanf("%s",&name);
      printf("you age is %s\n",name);
      getchar();
      getchar();	
}
```

###  练习

 1.x秒 转换x小时x分钟x秒
 ```c
void main() {
      //秒 = x小时x分钟x秒
      int second = 99999;
      int hour = second / 3600;
      int min = second % 3600 / 60;
      int leftSecond = second % 60;
      printf("%d秒 == %d小时%d分钟%d秒 \n",second,hour,min,leftSecond);
      getchar();	
    
}
 ```
 2.实现3个数排序,按照从小到大排序
 ```c
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
 ```
 ## 二进制和位运算  
 ### 进制
 1.二进制  满二进1  所以只有0和1  
 2.十进制  满十进一 所以只有0-9  
 3.八进制  满八进一 所以只有0-7 
 4.十六进制 满十六进一    
 所以只有0-9 A-F A->10 B->11 C-12 D-13 E-14 F-15  

 ### 进制转换  
 #### 其他进制转十进制 x进制 yyy = y*x^0 + y*x^1 + y*x^2
 1.二进制转十进制 
 ```c
 //二进制转10进制  规则，从低位开始 乘以2的位数-1次方 
 //每一位相加的和
 //1000  0*2^0 + 0*2^1 + 0*2^2 + 1*2^3 = 0+0+0+8 = 8
 ```
2.八进制转十进制 
 ```c
 //8进制转十进制 规则,从低位开始，乘以8的位数-1次方
//每一位相加的和
 //107  7*8^0 + 0*8^1 + 1*8^2 = 7+0+64 = 71
 ```
 3.十六进制转十进制
 ```c
 //十六进制转十进制 规则，从低位开始，乘以十六的位数-1次方
//每一位相加的和
 //0xA8 8*16^0 + 10*16^1 = 8 + 160 = 168
 ```
### 十进制转其他进制  除以该进制,直到商为0 ,将得到的余数倒转
1.十进制转二进制
```c
//规则，将该数不断的除以2，直到为商0，然后将每步得到的余数倒转 
//56   56/2 = 28    0
//28   28/2 = 14    0
//14   14/2 = 7     0
//7    7/2  = 3     1
//3    3/2  = 1     1
//1    1/2  = 0     1
//56 = 111000
```
2.十进制转八进制
```c
//规则,将该数不断的除以8,直到商为0，然后将每步的余数倒转
//76 76/8 = 9   4
//9  9/8  = 1   1
//1  1/8  = 0   1
//76 = 114
```
3.十进制转16进制
```c
//规则,将该数不断的除以16,直到商为0，然后将每步的余数倒转
//56 56/16 = 3  8
//3  3/16  = 0  3

//56 = 38


//999 999/16 = 62   7
//62  62/16 =  3    E
//3   3/16 = 0      3

//999 = 3E7
```
 ### 二进制转其他进制  
 1.二进制转八进制
 ```c
 //二进制转八进制 
 //110110 三位一组转为10进制 110-5  110-5  066

 //1 110 010 110  110=6 010=2 110=6 1=1   1626
 ```
 2.二进制转16进制
 ```c
 //二进制转16进制
//四位一组转10进制
 //110110  0110=6 11=3  0x36

//111 0010 1110  = 72E
//1110 = 0 + 1*2^1 + 1*2^2 + 1*2^3 =0+2+4+8=14(E)
//0010 = 2
//111 = 1*2^0 + 1*2^1 + 1*2^2 =1+2+4=7

 ```

 ### 其他进制转二进制  
 1.八进制转二进制
 ```c
 //将八进制的每一位转为  一个 3位的二进制数
 //0237 = 010 011 111
 //7 = 7/2 = 3 余 1   
 //3 = 3/2 = 1 余 1
 //1 = 1/2 = 0 余 1
 //7 = 111
 //3 = 011
 //2 = 010
 ```
 2.16进制转二进制
 ```c
 //将16进制的每一位转为 一个 4位的二进制数
 //0x66  = 0110 0110
 //6 6/2 = 3 余 0
 //3 3/2 = 1 余 1
 //1 1/2 = 0 余 1 
 //6 = 0110
  
 ```
### 二进制的原码，反码，补码  （重要？）
1.二进制最高位为符号位，0表示正数，1表示负数  
2.整数的原码，反码，补码都一样  
3.负数的反码 = 原码的符号位不变，其他位取反  
4.负数的补码 = 反码 + 1  
5.0的 原码，反码，补码 都是0  
6.计算机的运算，都是以 **补码的方式** 来运算的  

### 位运算符  
1.& 按位与 0&0 = 0 0&1 = 0 1&0=0 1&1=1  
2.| 按位或 0|0 = 0 0|1 = 1 1|0=1 1|1=1   
3.^ 异或运算符 0^0 = 0 0^1 = 1  1^0 = 1 1^1 = 0  
4.~ 取反 ~0 = 1 ~1 = 0  
5.<< 二进制左移运算符 ，将一个二进制全部左移若干位(左边去掉，右边补0)  
6.>> 二进制右移运算符,将一个二进制全部右移若干位(右边去掉，左边 正数补0，负数补1)    
  
### 练习  
1.~2  
```c
// ~2 00000000 00000000 00000000 00000010 //补码取反
//    11111111 11111111 11111111 11111101 //负数的补码 
//反码11111111 11111111 11111111 11111100 = 补码- 1   
//原码10000000 00000000 00000000 00000011 = 符号位不变,其他取反
//   
   int a = ~2;
   printf("a = %d \n",a);
   getchar(); 
```
2.2&-3 
```c
//2的补码 00000000 00000000 00000000 00000010

//-3的原码10000000 00000000 00000000 00000011
//-3的反码11111111 11111111 11111111 11111100
//-3的补码11111111 11111111 11111111 11111101
//2& -3
//2         00000000 00000000 00000000 00000010
//-3        11111111 11111111 11111111 11111101
//2&-3      00000000 00000000 00000000 00000000
   int a = 2&-3;
   printf("a = %d \n",a);
   getchar();
```
3.~-5
```c
//~-5
//-5的原码    10000000 00000000 00000000 00000101
//-5的反码    11111111 11111111 11111111 11111010
//-5的补码    11111111 11111111 11111111 11111011
//-5的补码取反00000000 00000000 00000000 00000100
//~-5=4
   int a = ~-5;
   printf("a = %d \n",a);
   getchar();
```
4.2|3 
```c
//2|3 
//2   00000000 00000000 00000000 00000010
//3   00000000 00000000 00000000 00000011
//2|3 00000000 00000000 00000000 00000011 
//2|3 = 3
  int a = 2|3;
   printf("a = %d \n",a);
   getchar();
```

5.2^3 
```c
//2^3 
//2   00000000 00000000 00000000 00000010
//3   00000000 00000000 00000000 00000011
//2^3 00000000 00000000 00000000 00000001
//2^3 = 1
   int a = 2^3;
   printf("a = %d \n",a);
   getchar();
```

6.1>>2
```c
//1>>2 左移2位 
// 二进制右移运算符,将一个二进制全部右移若干位(右边去掉，左边 正数补0，负数补1)    
//1    00000000 00000000 00000000 00000001
//     00000000 00000000 00000000 00000000
//1>>2 = 0
void main() {
   int a = 1>>2;
   printf("a = %d \n",a);
   getchar();
}
```  
7.-1>>2 
```c
//-1 >> 2
//-1的原码   10000000 00000000 00000000 00000001 
//-1的反码   11111111 11111111 11111111 11111110
//-1的补码   11111111 11111111 11111111 11111111 补码-反码+1
//右移两位   11111111 11111111 11111111 11111111
//反码       11111111 11111111 11111111 11111110
//原码       10000000 00000000 00000000 00000001
//-1 >> 2 == -1


void main() {
   int a = -1>>2;
   printf("a = %d \n",a);
   getchar();
}
```

8.1<<2 
```c
//1<<2
//左移两位，右边补0 左边去掉
//1         00000000 00000000 00000000 00000001
//          00000000 00000000 00000000 00000100
//1<<2 = 4  
void main() {
   int a = 1<<2;
   printf("a = %d \n",a);
   getchar();
}
```  
9.-5&6
```c
//-5&6
//-5的原码 10000000 00000000 00000000 00000101
//-5的反码 11111111 11111111 00000000 11111010
//-5的补码 11111111 11111111 11111111 11111011
//6的补码  00000000 00000000 00000000 00000110
//-5&6     00000000 00000000 00000000 00000010
//-5&6 = 2
void main() {
   int a = -5&6;
   printf("a = %d \n",a);
   getchar();
}
```

9.-5|6
```c
//-5&6
//-5的原码 10000000 00000000 00000000 00000101
//-5的反码 11111111 11111111 00000000 11111010
//-5的补码 11111111 11111111 11111111 11111011
//6的补码  00000000 00000000 00000000 00000110
//-5|6     11111111 11111111 11111111 11111111
//负数的补码=反码-1
//         11111111 11111111 11111111 11111110
//负数的原码=反码取反，符号不变
//         10000000 00000000 00000000 00000001
//-5|6 = -1


void main() {
   int a = -5|6;
   printf("a = %d \n",a);
   getchar();
}

```

## 流程控制(顺序控制 分支控制 循环控制)
### 顺序控制,从上往下依次执行  
### 分支控制 
1.单分支控制
```c
//单分支控制 

void main() {
      int a = 1;
      printf("please age ");
      scanf("%d",&a);
      if(a >= 18){
      printf("a = %d \n",a);
      }


    getchar();
    getchar();
}
```

2.双分支控制
```c
//双分支控制 

void main() {
      int a = 1;
      printf("please age ");
      scanf("%d",&a);
      if(a >= 18){
      printf("a = %d \n",a);
      }else{
      printf("a < 18  \n");
      }
    getchar();
}
```
### 练习 
```c
void main() {
      int a = 1;
      int b = 81;
      if(a + b >= 18 && a+b < 30){
      printf("a = %d \n",a+b);
      }else if(a + b > 60){
      printf("a = %d \n",a+b);
	  }else{
      printf("a < 18  \n");
      }
    getchar();
}
```
3.多分支  
```c
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
``` 

### switch 分支 
```c
//输入月份，显示季节
void main() {
      int  a = 1;
      printf("Please enter month \n");
      scanf("%d",&a);
    switch (a){
    case 1:
    case 2:
    case 3:
          printf(" It's spring \n");
      break;
    case 4:
    case 5:
    case 6:
           printf(" It's summer \n");
    break;
    case 7:
    case 8:
    case 9:
          printf(" It's autumn \n");
      break;
    case 12:
    case 10:
    case 11:
          printf(" It's winter \n");
    break;
    default:
      break;
    }
    getchar();
    getchar();
}
```  
## 循环 控制
1.多次输出,循环控制
```c
//从0到8 依次输出
//0 number
//1 number
//2 number
//3 number
//4 number
//5 number
//6 number
//7 number
//8 number
void main() {
    for( int i = 0 ; i < 9 ; i++){
          printf("%d number\n",i);
    }
    getchar();
}
```  
2.多条初始化语句，循环变量迭代多条语句
```c
void main() {
    for( int i = 0 , j = 0 ; i < 9 ; i ++ , j = i * 2){
          printf("i = %d ; j= %d\n",i,j);
    }
    getchar();
}
```
1.练习
```c
void main() {
   
   //1-100内 9的倍数相加，以及个数
   int i = 0;
   int num = 0;
   int total = 0;
   for(i = 1 ;i < 100 ; i++){
       if(i % 9 == 0){
         num++;
         total = total + i;
       }
   }
   printf("1 - 100 内9的倍数相加 %d,9的倍数 的 个数%d\n",total,num);
    getchar();
}
``` 
```c
void main() {
   
  //0-num 相加等于num的组合
  for( int i = 0; i < 6; i++) {
    printf("%d + %d = %d \n",i,(6-i),6);
  }
    getchar();
}
```
## while循环 
1.用while循环输出1-9 
```c
void main() {
    int i = 1;
    while (i <= 9)
    {
      printf("%d\n",i);
      i++;
    }
     getchar();
}

```
### 练习 
1.输出1-100能被3整除的数
```c
void main() {
    int i = 1;
    while (i <= 100)
    {
      if(i%3 == 0){
      printf("%d\n",i);
    }
      i++;
    }
     getchar();
}
```
2.在控制台输出名字，直到输入exit退出
```c
#include <stdio.h>
#include <string.h>
void main() {
    char i[10] = "" ;
    while (strcmp(i, "exit")!=0)
    {
      printf("\nPlease enter a name\n");
      scanf("%s",i);
      printf("you name %s\n",i);
    }
     getchar();
}
```
## do{循环语句,循环变量迭代}while(循环条件)  循环控制 
```c
void main() {
  
     int i = 0;//循环变量初始化
     do{
      printf("%d\n",i);//循环体
      i++;//循环变量迭代
     }while(i<9);//循环条件
     getchar();
}
``` 
##练习
```c
void main() {
     //1-800相加的和
     int i = 0;//循环变量初始化
     int num = 0;
     do{
    //  printf("%d\n",i);//循环体
      num = num + i;
      i++;//循环变量迭代
     }while(i<=800);//循环条件 
     printf("%d \n",num);
     getchar();
}

```

```c
#include <stdio.h>
#include <string.h>
void main() {
    //一直输入,直到输入n退出
     char s[10] = "";
     do{
  
      printf("i like gowu   y/n");
      scanf("%s",s);
      getchar();  
     }while(strcmp(s, "n") !=0);//循环条件
   

     getchar();
}

```

```c
void main() {
    //1-100内能被5整除，但不能被3整除
     int i = 0;
     do{
      if(i % 5 == 0 && i % 3 != 0){
          printf("%d\n",i);
      }
      i++;
     }while(i<=100);//循环条件
   

     getchar();
}

```
### 嵌套循环
```c
void main() {
     //统计3个班的学生成绩，求各个班的平均成绩，和5个班的平均成绩
     //班级的个数classNum,每个班级的人数stuNum
     //各个班的总分classTotalNum
     //score学生成绩
     //各个班的总平均成绩 
     //及格人数
     int stuNum = 5;
     int classNum = 3;
     int classtotalNum=0;
     int  classtotalNums=0;
     int score = 0; 
     int i,j;
     int jige = 0;
     for(i=0;i<classNum;i++){
         classtotalNum = 0;
         for ( j = 0; j < stuNum; j++) {
            printf("di %d ban ji di %d ge xue sheng\n",i,j);
            scanf("%d",&score);
            classtotalNum += score;
            if(score > 60){
              jige++;
            }
         }
         printf("di %d ban ji ping jun fen =%d\n",i,classtotalNum / stuNum);
        classtotalNums += classtotalNum;

     }
    printf("ji ge ren shu =%d\n",jige);
    printf("zong ping jun fen =%d\n",classtotalNums / (stuNum*classNum));

     getchar();
     getchar();
}

```
### 九九乘法表
```c
void main() {
   //打印99乘法表
   for (int i = 1;i <= 9;i++){
        for (int j = 1;j <= i;j++){
       printf("%d * %d = %d \t",j,i,i*j);
    }
     printf("\n");
   }
     getchar();
}

```

```c
//长方形
//******
//******
//******
//******
//******
void main() {
   for (int i = 1;i <= 5;i++){
 
      for (int j = 1;j <= 5;j++){
          printf("*");
      }
        printf("\n");
   }
     getchar();
}
//星号
//*
//**
//***
//****
//*****
void main() {
   for (int i = 1;i <= 5;i++){
 
      for (int j = 1;j <= i;j++){
          printf("*");
      }
        printf("\n");
   }
     getchar();
}


//没有空格的金字塔 (2*i)-1 星号的数量
//*
//***
//*****
//*******
//*********
void main() {
   for (int i = 1;i <= 5;i++){
 
      for (int j = 1;j <= (2*i)-1;j++){
          printf("*");
      }
        printf("\n");
   }
     getchar();
}
//金字塔 5-i=空格数
//    *
//   ***
//  *****
// *******
//*********
void main() {
   for (int i = 1;i <= 5;i++){
       for (int k = 1;k <= 5-i;k++){
          printf(" ");
      }
      for (int j = 1;j <=(2*i)-1;j++){
          printf("*");
      }
        printf("\n");
   }
     getchar();
}

//空心金字塔
    *
   * *
  *   *
 *     *
*********

void main() {
   for (int i = 1;i <= 5;i++){
       for (int k = 1;k <= 5-i;k++){
          printf(" ");
      }
      for (int j = 1;j <=(2*i)-1;j++){
          if(i==1 || i==5 || j == 1 || j == (2*i)-1){
             printf("*");
          }else{
            printf(" ");
            }
      }
        printf("\n");
   }
     getchar();
}


void main() {
    //输入任意数字打印空心金字塔
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

```
## break 结束当前循环
```c
void main() {
  
    for(int i=0;i<5;i++){
      for(int j=1;j<5;j++){
        if(j==2){
           break;
        }
        printf("i = %d\n",i);
      }
    }
     getchar();
}

//i=0
//i=1
//i=2
//i=3
//i=4
```
1.登录验证，3次机会，输入hello 登录成功，否则显示还剩余几次机会
```c
void main() {
     int channce = 3;
     int j =3;
     char name[10] = "";
     for(int i=1;i<=3;i++){
          printf("plase you name\n");
          scanf("%s",name);
          if(strcmp("hello",name) == 0){
           printf("success");
           break;
          }else{
              channce--;
              printf("hai sheng %d ci\n",channce);
            if(channce<=0){
              break;
            }
          }
     }
       getchar();
       getchar();
}

```

## continue 结束本次循环
```c
void main() {
   
     for(int i=1;i<=5;i++){
       if(i==3){
         continue;
       }
       printf("%d\n",i);
     }
       getchar();
}

```
1.从键盘输入数字，记录负数和正数的个数，输入0时退出循环
```c
void main() {
   
      int p = 0;//正数的个数
      int n = 0;//负数的个数
      int num = 0;
      for (;;){//表示死循环，永远不退出
      printf("plase enter  num\n");
      scanf("%d",&num);
        if(num == 0){
          break;
        }
        if(num < 0){
          n++;
          continue;
        }
         if(num > 0){
          p++;
           continue;
        }
      }
      printf("zheng shu ge shu= %d fu shu ge shu =  %d",p,n);
    getchar();
    getchar();
}

```
2.100000人民币可以过多少个路口,50000以上收5%，以下收1000
```c
void main() {
   int lukou = 0;
    int tom = 100000;
    while(1){
      if(tom < 1000){
        break;
      }
      if(tom>50000){
        tom = tom *0.95;
      }else{
        tom = tom - 1000;
      }
      lukou++;

    }
    printf("100000 RMB ke yi jing guo %d ge lu kou\n,sheng yu %d RMB\n",lukou,tom);
    getchar();
}

```

## goto语句 和 return 语句 
1.goto想去哪就去哪 goto lable
```c
void main() {
printf("0000");
goto lable1;
printf("0000\n");

printf("100000 RMB ke yi jing guo %d ge lu kou\n,sheng yu %d RMB\n",1,2);

lable1:
getchar();
}

```

2.水仙花数
```c
void main() {
for(int i=100;i<1000;i++){
  //水仙花数 各个位数的3次方 相加 等于本身
  int b = i / 100; //百位数
  int s = i % 100 /10; //十位数
  int g = i % 10; //个位数
  if(g * g * g + s * s * s +b * b * b == i){
        printf("%d is shui xian hua shu\n",i);
  }
}
getchar();
}

```

## enum枚举 

```c
enum DAY{
  one=1,two ,three ,si ,wu ,liu,qi,ba,jiu
}day;
void main() {
for(day = one;day<jiu;day++){
  printf("%d\n",day);
}
getchar();
}

```

## 函数
解决传统方法代码冗余问题  
不利于维护  
引出函数

完成某一功能的程序指令的集合  

1.函数的递归实验

```c
//依次输出 n = 2, n = 3 , n = 4  
//
void getTest(int n){
  if(n>2){
    getTest(n-1);
  }
  printf("n = %d\n",n);
}
void main() {
 

  getTest(4);
  getchar();
}
```
2.使用斐波拉系数,1,1,2,3,5,8,13给你一个整数，求出他的斐波拉系数
```c
int  getTest(int n){
  if(n == 1|| n == 2 ){
    return 1; 
  }else{
    return getTest(n - 1) + getTest(n - 2);
  }
  
}
void main() {
 //使用斐波拉系数,1,1,2,3,5,8,13给你一个整数，求出他的斐波拉系数
 //使用递归

  int res =  getTest(7);
  printf("res = %d\n",res);
  getchar();
}

```

3.已知f(1) = 3,f(n)=2*f(n-1)+1
```c
int  getTest(int n){
 if(n == 1){
   return 3;
 }else{
   return 2 * getTest(n-1) + 1;
 }
}
void main() {
  //已知f(1) = 3,f(n)=2*f(n-1)+1
  int res =  getTest(7);
  printf("res = %d\n",res);
  getchar();
}
```
4.猴子吃桃,吃一半 ，在多吃一个，第十天只剩一个，求一共有多少个桃子
```c
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

```


























