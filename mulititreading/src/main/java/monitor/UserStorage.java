package monitor;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

/**
 * Created by Дмитрий on 22.10.2018.
 */
@ThreadSafe
class UserStorage {
    @GuardedBy("this")
    private Map<Integer, User> storage = new HashMap();

    boolean add(User user) {
        Integer id = user.getId();
        boolean result = false;
        synchronized (storage) {
            if (!isElementExist(id)) {
                storage.put(id, user);
                result = true;
            }
        }
        return result;
    }

    boolean update(User user) {
        Integer id = user.getId();
        boolean result = false;
        synchronized (storage) {
            if (isElementExist(id)) {
                storage.put(id, user);
                result = true;
            }
        }
        return result;
    }

    boolean delete(User user) {
        Integer id = user.getId();
        boolean result = false;
        synchronized (storage) {
            if (isElementExist(id)) {
                storage.remove(id);
                result = true;
            }
        }
        return result;
    }

    synchronized User getUserById(int id) {
        if (isElementExist(id)) {
            return storage.get(id);
        }
        throw new NoSuchElementException("No user with id=" + id);
    }

    synchronized private boolean isElementExist(int id) {
        return storage.containsKey(id);
    }

    synchronized boolean transfer(int fromId, int toId, int amount) {
        boolean result = false;
        if (isElementExist(fromId) && isElementExist(toId) && storage.get(fromId).getAmount() >= amount) {
            int currentFromIdAmount = storage.get(fromId).getAmount();
            int currentToIdAmount = storage.get(toId).getAmount();
            storage.get(fromId).setAmount(currentFromIdAmount - amount);
            storage.get(toId).setAmount(currentToIdAmount + amount);
            result = true;
        }
        return result;
    }
}
