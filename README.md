# learningCS61B
## Courses & materials
- CS61B Main

https://fa20.datastructur.es/

- CS61B Github

https://github.com/Berkeley-CS61B/skeleton-fa20

- Standard Libraries

https://introcs.cs.princeton.edu/java/stdlib/

## Tasks
- [ ] Learning about scanner & system.in

## Proj0
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

因为通过代理，和internet设置有关



## Week 2
⭐ 8种基本数据类型（int,double等等）存储的是数据本身，而reference（比如Object）存储的是地址
```java
Walrus a = new Walrus(1000, 8.3);
Walrus b;
b = a;
```
![image](https://user-images.githubusercontent.com/76512484/137616875-a396c2b7-9ca0-40e0-a6a0-b28d5069a479.png)

⭐ List1Exercise和Lab2里面对于链表有一个通用思路：stop one ahead

首先linked list题一般都要查head本身就是null的情况；

然后如果操作需要stop one ahead，那就得查head.next 是null的情况，并且head本身有单独的case，在loop前面单独写。

