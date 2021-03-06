package threads;
/**
 * Created by Дмитрий on 21.10.2018.
 */

import javafx.scene.shape.Rectangle;

import static java.lang.Thread.currentThread;

public class RectangleMove implements Runnable {
    private final Rectangle rect;
    private int direct;

    public RectangleMove(Rectangle rect, int direct) {
        this.rect = rect;
        this.direct = direct;
    }

    @Override
    public void run() {
        while (!currentThread().isInterrupted()) {
            this.rect.setX(this.rect.getX() + this.direct);
            if ((this.rect.getX() >= 300) || (this.rect.getX() <= 0)) {
                direct = direct * (-1);
            }
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                currentThread().interrupt();
                e.printStackTrace();
            }
        }
    }
}