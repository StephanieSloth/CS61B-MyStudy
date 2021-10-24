import java.lang.reflect.Array;

public class Body {
    //Body类的属性
    public double xxPos; //current x position
    public double yyPos; //current y position
    public double xxVel; //current velocity in the x direction
    public double yyVel; //current velocity in the y direction
    public double mass; //mass
    //The name of the file that corresponds to the image that depicts the body (for example, jupiter.gif)
    public String imgFileName;

    // constructor 构造函数1
    public Body(double xP, double yP, double xV,
                double yV, double m, String img){
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;

    }
    // constructor 构造函数2
    public Body(Body b){
        this.xxPos = b.xxPos;
        this.yyPos = b.yyPos;
        this.xxVel = b.xxVel;
        this.yyVel = b.yyVel;
        this.mass = b.mass;
        this.imgFileName = b.imgFileName;
    }
    //计算距离calcDistance
    public double calcDistance(Body b1){
        double r =0;
        double dx =0;
        double dy =0;
        dx = b1.xxPos-this.xxPos;
        dy = b1.yyPos-this.yyPos;
        r = Math.sqrt(Math.pow(dx,2)+Math.pow(dy,2));
        return r;
    }
    // 计算力calcForceExertedBy this对象受到的力
    public double calcForceExertedBy(Body b1){
        double F =0;
        double G = 6.67e-11;
        double r = this.calcDistance(b1);
        double m1 = this.mass;
        double m2 = b1.mass;
        if(this.equals(b1)) {
            F=0;
        }  else  {
            F = G*m1*m2/Math.pow(r,2);
        }
        return F;
    }
    // 计算分力calcForceExertedByX this对象受到的力
    public double calcForceExertedByX(Body b1){
        double Fx =0;
        double F = this.calcForceExertedBy(b1);
        double r = this.calcDistance(b1);
        double dx = b1.xxPos-this.xxPos;
        Fx = F*dx/r;
        return Fx;
    }
    // 计算分力calcForceExertedByY this对象受到b1的力
    public double calcForceExertedByY(Body b1){
        double Fy =0;
        double F = this.calcForceExertedBy(b1);
        double r = this.calcDistance(b1);
        double dy = b1.yyPos-this.yyPos;
        Fy = F*dy/r;
        return Fy;
    }
    // 所有合力X
    public double calcNetForceExertedByX(Body[] allBodys){
        double Fnetx = 0;
        // enhanced for loop
        for (Body now :allBodys){
            if (this.equals(now)){
                continue;
            }else {
                Fnetx += calcForceExertedByX(now);
            }
        }
        return Fnetx;
    }
    // 所有合力Y
    public double calcNetForceExertedByY(Body[] allBodys){
        double Fnety = 0;
        // enhanced for loop
        for (Body now :allBodys){
            if (this.equals(now)){
                continue;
            }else {
                Fnety += calcForceExertedByY(now);
            }
        }
        return Fnety;
    }
    //update the body’s position and velocity instance variables
    public void update(double dt,double fX,double fY){
        // xy方向的加速度
        double ax = fX/this.mass;
        double ay = fY/this.mass;
        // update the velocity
        this.xxVel +=dt*ax;
        this.yyVel +=dt*ay;
        // update the postion
        this.xxPos +=dt*this.xxVel;
        this.yyPos +=dt*this.yyVel;
    }
    public void draw(){
        String imgaddr = "proj0/"+this.imgFileName;
        StdDraw.picture(this.xxPos,this.yyPos,imgaddr);
    }
}
