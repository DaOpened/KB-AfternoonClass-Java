package classes;
import java.util.Date;

public class FishBread {
    String taste, shape;
    int price;
    Date makeTime = new Date();

    FishBread () {
        this.taste = "팥";
        this.shape = "붕어빵";
        this.price = 700;
    }

    FishBread(String taste, String shape, int price) {
        this.taste = taste;
        this.shape = shape;
        this.price = price;
    }
}
