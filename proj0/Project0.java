public class Project0 {
    public static void main(String[] args){
        Body Samh = new Body(1, 0, 0,
        0, 7e5, null);
        Body Aegir = new Body(3, 3, 0,
                0, 8e5, null);
        Body Rocinante = new Body(5, -3, 0,
                0, 9e6, null);
        Body Saturn = new Body(2.3e12,9.5e11,0,0,6e26,null);
        Body Sun = new Body(1e12,2e11,0,0,2e30,null);
        Body[] allBodys = {Samh,Aegir,Rocinante};
        Samh.update(1,5,5);
        System.out.println(Samh.calcNetForceExertedByX(allBodys));
        System.out.println(Samh.calcForceExertedByX(Rocinante));
        System.out.println(Samh.calcForceExertedByX(Aegir));
    }

}
