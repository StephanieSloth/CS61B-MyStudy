# 学习CS61B
## Courses & materials
- CS61B Main

https://fa20.datastructur.es/

- CS61B Github

https://github.com/Berkeley-CS61B/skeleton-fa20

- Standard Libraries

https://introcs.cs.princeton.edu/java/stdlib/

## Proj 0
### Q1:怎么使用scanner和System.in?

https://stackoverflow.com/questions/26446599/how-to-use-java-util-scanner-to-correctly-read-user-input-from-system-in-and-act

### Q2:在IntelliJ IDEA中读取命令行输入?
Answer: https://blog.csdn.net/qq_43907505/article/details/109176099

Example code:
```java
public class Demo{
    public static void main(String [] args){
        for(int i=0;i<args.length;i++)
            System.out.println(args[i]);
    }
}
```
### Q3:IntelliJ IDEA和Githubl连接使用
https://www.bilibili.com/video/BV1bi4y1F7se?share_source=copy_web
https://www.bilibili.com/video/BV1e541137Tc?spm_id_from=333.999.0.0

总报错 “Failed to connect to github.com port 443: Timed out”

通过代理和internet设置有关
git_bash执行下这个就可以了 git config --global --unset http.proxy


## Week 2
https://joshhug.gitbooks.io/hug61b/content/chap2/chap21.html

⭐ 在Java中，使用关键字 new 来创建一个新的对象。创建对象需要以下三步：
1. 声明：声明一个对象，包括对象名称和对象类型。
2. 实例化：使用关键字 new 来创建一个对象。（对象是类的一个实例）
3. 初始化：使用 new 创建对象时，会调用构造方法初始化对象。

```java
Walrus a = new Walrus(1000, 8.3);
Walrus b;
b = a;
```
⭐ 分配给变量的空间，对于8种基本数据类型（int,double等等）存储的是数据本身，而对于Object存储的是地址reference
- 声明：Walrus a是说分配空间给一个Walrus类的变量，名字叫a，a本质上是一个reference（creates a box of 64 bits.）
- 新建对象/实例：new Walrus(1000,8.3)是说新建了一个object，是Walrus类的instance
- new之后产生的地址给a
- 复制a的数据给b

⭐ In Java, we always pass by value.

⭐ This Golden Rule of Equals (GRoE)
- When you write y = x, you are telling the Java interpreter to copy the bits from x into y. 


![image](https://user-images.githubusercontent.com/76512484/137616875-a396c2b7-9ca0-40e0-a6a0-b28d5069a479.png)

⭐ List1Exercise和Lab2里面对于链表有一个通用思路：stop one ahead

首先linked list题一般都要查head本身就是null的情况；

然后如果操作需要stop one ahead，那就得查head.next 是null的情况，并且head本身有单独的case，在loop前面单独写。

## Proj 1a
循环双链表 circular doubly linked list
![捕获](https://user-images.githubusercontent.com/76512484/138862425-01216d3c-9b16-4e8c-bd91-800516025a08.PNG)
## Link 4
![image](https://user-images.githubusercontent.com/76512484/139063623-9de9b27d-183f-4ab5-bd07-6334c33518c3.png)

java中的array的大小给定，如果需要扩展，我们需要新建一个

![image](https://user-images.githubusercontent.com/76512484/139182385-cddff614-8752-4e53-809e-7b36756cbc14.png)

linked list查改是O(n)复杂度，增删首尾是O(1)

Array list查改是O(1)，增删O(n)

# Inheritance
⭐ Interface inheritance (what): Simply tells what the subclasses should be able to do.

EX) all lists should be able to print themselves, how they do it is up to them.

⭐ Implementation inheritance (how): Tells the subclasses how they should behave.

EX) Lists should print themselves exactly this way: by getting each element in order and then printing them.

⭐ 对于compile错误，是在还没有运行的时候检查有没有按照接口给对输入（exercise 4.3.3）

![1](https://user-images.githubusercontent.com/76512484/144340742-738e59a1-fce9-41d8-bccc-8c8f84afa7fe.PNG)

![2](https://user-images.githubusercontent.com/76512484/144340753-6f90d339-e5d4-4b48-b0c6-dbc96f82ea80.PNG)


## Extends
By using the extends keyword, subclasses inherit all members of the parent class. "Members" includes:

- All instance and static variables
- All methods
- All nested classes

constructors are not inherited, and private members cannot be directly accessed by subclasses.

⭐ 继承的子类也不能访问parent class的private属性（比如sentinel和size），如果要用parent的就要用标识符“super”转到上层
```java
public static Dog maxDog(Dog d1, Dog d2) { ... } //假设一个函数，返回的是Dog

Poodle frank = new Poodle("Frank", 5);
Poodle frankJr = new Poodle("Frank Jr.", 15);

Dog largerDog = maxDog(frank, frankJr);
Poodle largerPoodle = maxDog(frank, frankJr); //does not compile! RHS has compile-time type Dog
// maxDog返回的是Dog，但Dog is a poodle吗？不是！
```

## Overload重载 & Override重写
⭐ 每个重载的方法（或者构造函数）都必须有一个独一无二的参数类型列表。

对于overload（有对应的signature，如SLList<String>），就只运行包含signature的函数

⭐ 重写是子类对父类的允许访问的方法的实现过程进行重新编写, 返回值和形参都不能改变

对于override，则是运行子类的函数（dynamic type）

子类可以根据需要，定义特定于自己的行为。 也就是说子类能够根据需要实现父类的方法

![image](https://user-images.githubusercontent.com/76512484/141981913-e59e4983-a08b-4ca2-a416-f09843fe6274.png)
    

