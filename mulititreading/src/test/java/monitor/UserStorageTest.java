package monitor;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Дмитрий on 22.10.2018.
 */
public class UserStorageTest {

    /**
     * Класс описывает нить со счетчиком.
     */
    private class ThreadStorage extends Thread {
        private final UserStorage storage;

        private ThreadStorage(final UserStorage storage) {
            this.storage = storage;
        }

        @Override
        public void run() {
            this.storage.transfer(1, 2, 25);
        }
    }

    @Test
    public void whenExecute2ThreadThen2() throws InterruptedException {
        //Создаем счетчик.
        final UserStorage userStorage = new UserStorage();
        userStorage.add(new User(1, 100));
        userStorage.add(new User(2, 200));
        //Создаем нити.
        Thread first = new UserStorageTest.ThreadStorage(userStorage);
        Thread second = new UserStorageTest.ThreadStorage(userStorage);
        //Запускаем нити.
        first.start();
        second.start();
        //Заставляем главную нить дождаться выполнения наших нитей.
        first.join();
        second.join();
        //Проверяем результат.
        assertThat(userStorage.getUserById(1).getAmount(), is(50));
        assertThat(userStorage.getUserById(2).getAmount(), is(250));
    }
}