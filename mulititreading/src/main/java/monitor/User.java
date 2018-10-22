package monitor;

/**
 * Created by Дмитрий on 22.10.2018.
 */
public class User {
    int id;
    int amount;

    public int getId() {
        return id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public User(int id, int amount) {
        this.id = id;
        this.amount = amount;
    }
}
