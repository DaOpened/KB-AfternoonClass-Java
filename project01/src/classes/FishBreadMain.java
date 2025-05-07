package classes;

public class FishBreadMain
{
    public static void main(String[] args)
    {
        FishBread fish1 = new FishBread("슈크림", "잉어빵", 1000);
        FishBread fish2 = new FishBread();


        System.out.println( fish1.taste+ " " + fish1.shape+ " " + fish1.price+" "+fish1.makeTime);
        System.out.println( fish2.taste+ " " + fish2.shape+ " " + fish2.price+" "+fish2.makeTime);
    }
}
