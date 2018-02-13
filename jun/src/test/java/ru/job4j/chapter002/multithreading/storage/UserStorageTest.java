package ru.job4j.chapter002.multithreading.storage;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * This class tests user storage.
 *
 * @author Kutsyih Vasily (mailto:basil135@mail.ru)
 * @version $Id$
 * @since 13.02.2018
 */
public class UserStorageTest {

    /**
     * method to test user storage with multithreading.
     *
     * @throws InterruptedException throws if threads interrupted
     */
    @Test
    public void when2ThreadsManageUsersThenAllCorrect() throws InterruptedException {
        UserStorage storage = new UserStorage();
        Thread first = new Thread(new Runnable() {
            @Override
            public void run() {
                storage.addUser(new User(1, 1));
                storage.addUser(new User(3, 0));
                storage.updateUser(new User(1, 500));
            }
        });
        Thread second = new Thread(new Runnable() {
            @Override
            public void run() {
                storage.addUser(new User(2, 1));
                storage.updateUser(new User(2, 250));
                storage.transfer(1, 3, 250);
            }
        });

        first.run();
        second.run();
        first.join();
        second.join();

        User firstUser = storage.getUser(1);
        User secondUser = storage.getUser(2);
        User thirdUser = storage.getUser(3);
        User expectedUserFirst = new User(1, 250);
        User expectedUserSecond = new User(2, 250);
        User expectedUserThird = new User(3, 250);

        assertThat(firstUser.getAmount(), is(expectedUserFirst.getAmount()));
        assertThat(secondUser.getAmount(), is(expectedUserSecond.getAmount()));
        assertThat(thirdUser.getAmount(), is(expectedUserThird.getAmount()));
    }
}
