import es.datastructur.synthesizer.GuitarString;

import java.util.ArrayList;

public class GuitarHero {
    private static final double CONCERT_A = 440.0;
    private String keyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";

    private static final double CONCERT_C = CONCERT_A * Math.pow(2, 3.0 / 12.0);
    private ArrayList<GuitarString> StringArr;

    public GuitarHero(){
        StringArr = new ArrayList<GuitarString>();
        for(int i=0;i<keyboard.length();i++){
            double CONCERT = CONCERT_A * Math.pow(2, (i - 24) / 12.0);
            GuitarString stringX = new GuitarString(CONCERT);
            StringArr.add(stringX);
        }

    }
/*    private double getConcert(char key){
       int i = keyboard.indexOf(key);
       return CONCERT_A * Math.pow(2, (i - 24) / 12.0);
    }*/
    public void detectKey(char key){
        int i = keyboard.indexOf(key);
        if (i == -1){
            throw new RuntimeException("Not Included!");
        } else {
            StringArr.get(i).pluck();
        }
    }

    public double getSample(){
            /* compute the superposition of samples */
            double sample = 0.0;
            for(int j =0;j<keyboard.length();j++){
                sample += StringArr.get(j).sample();
            }
            return sample;
        }
    public void playSound(){
        /* advance the simulation of each guitar string by one step */
        for(int j =0;j<keyboard.length();j++){
            StringArr.get(j).tic();
        }
    }

    public static void main(String[] args) {
        /* create guitar strings,*/
        GuitarHero I = new GuitarHero();

        while (true) {

            /* check if the user has typed a key; if so, process it */
            if (StdDraw.hasNextKeyTyped()) {
                char key = StdDraw.nextKeyTyped();
                I.detectKey(key);
            }

            /* play the sample on standard audio */
            StdAudio.play(I.getSample());

            I.playSound();


        }
    }
}
