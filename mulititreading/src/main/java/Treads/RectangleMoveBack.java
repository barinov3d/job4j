package Treads;
/**
 * Created by Дмитрий on 21.10.2018.
 */
import javafx.scene.shape.Rectangle;

public class RectangleMoveBack implements Runnable {
    private final Rectangle rect;

    public RectangleMoveBack(Rectangle rect) {
        this.rect = rect;
    }

    @Override
    public void run() {
        while (this.rect.getX() > 0) {
            this.rect.setX(this.rect.getX() - 1);
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        new Thread(new RectangleMove(rect)).start();
    }
}