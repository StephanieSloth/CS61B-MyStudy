public class NBody {
    public static void main(String[] args){

        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = "proj0/planets.txt";
        double universe_R = NBody.readRadius(filename);
        Body[] universe =NBody.readBodies(filename);

        StdDraw.setScale(-universe_R,universe_R); //设置xy尺度,位置和宇宙半径的比例参考系
        String background =  "proj0/starfield.jpg";
        //Draw picture (gif, jpg, or png) centered on (x, y).
        StdDraw.picture(0,0,background);
        for(Body planet:universe){
            planet.draw();
        }
        // animation
        StdDraw.enableDoubleBuffering(); //屏幕闪烁
        for(double lasting_time = 0; lasting_time<=T; lasting_time +=dt){
            double[] xForces = new double[universe.length];
            double[] yForces = new double[universe.length];
            for(int b =0;b<universe.length;b+=1) {
                xForces[b] = universe[b].calcNetForceExertedByX(universe);
                yForces[b] = universe[b].calcNetForceExertedByY(universe);
            }
            StdDraw.picture(0,0,"proj0/starfield.jpg"); //刷新覆盖背景，否则显示行星滑动重影
            for (int b = 0; b < universe.length; b++) {
                universe[b].update(dt, xForces[b], yForces[b]);
                universe[b].draw();
            }
                StdDraw.show();
                StdDraw.pause(10);
        }
        StdOut.printf("%d\n", universe.length);
        StdOut.printf("%.2e\n", universe_R);
        for (int i = 0; i < universe.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                    universe[i].xxPos, universe[i].yyPos, universe[i].xxVel,
                    universe[i].yyVel, universe[i].mass, universe[i].imgFileName);
        }
    }

    public static double readRadius(String filename){
        In in = new In(filename);
        int planet_num = in.readInt(); //行星个数
        double  universe_R= in.readDouble(); //宇宙半径
        return universe_R;
    }

    public static Body[] readBodies(String filename){
        In in = new In(filename);
        int planet_num = in.readInt(); //行星个数
        double  universe_R= in.readDouble(); //宇宙半径

        Body[] universe=new Body[planet_num]; //创建类数组
        for(int i =0;i<planet_num;i+=1){
            double xP = in.readDouble();
            double yP = in.readDouble();
            double xV = in.readDouble();
            double yV = in.readDouble();
            double m = in.readDouble();
            String img = in.readString();

            universe[i] = new Body(xP,  yP,  xV, yV,  m,  img);
            //System.out.println("The file contained "+ universe[i].imgFileName );
        }
        return universe;
    }
}

