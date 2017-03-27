import java.util.Random;

public class Main {


    public static double r = 0.45;


    public static  int count = 0;
    public static  int sum = 1;

    public static void main(String[] args) {
        Random random = new Random();
        double d = random.nextDouble();
        System.out.println(d<r);
    }
}










