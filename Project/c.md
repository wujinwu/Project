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

































