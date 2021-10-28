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
