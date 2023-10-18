import greenfoot.*;
import java.util.Random;

public class MyWorld extends World {
    private int specialObjectDelay = 100;
    private int specialObjectCounter = 0;
    private int score = 0;

    public MyWorld() {
        super(1200, 600, 1);
        prepare();
    }

    public void act() {
        if (score >= 100) {
            showText("You Won!", getWidth() / 2, getHeight() / 2);
            Greenfoot.stop();
        }
    }

    public void prepare() {
        // Inisialisasi objek dan karakter utama untuk level pertama
        Player player = new Player();
        addObject(player, getWidth() / 2, getHeight() - 30);
        
        Enemy enemy = new Enemy();
        addObject(enemy, getWidth() / 2, 30);

        ObjectSpecial specialObject = new ObjectSpecial();
        addObject(specialObject, Greenfoot.getRandomNumber(getWidth()), Greenfoot.getRandomNumber(getHeight()));
    }

    public void nextLevel() {
        if (score >= 100) {
            showText("You Won!", getWidth() / 2, getHeight() / 2);
            Greenfoot.stop();
        } else {
            removeObjects(getObjects(ObjectSpecial.class));
            prepare();
            // Logic tambahan untuk menyiapkan level berikutnya
        }
    }

    public void addScore() {
        score++;
    }
}
