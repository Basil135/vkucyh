package ru.job4j.pro.generic;

import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * This class tests classes UserStore and RoleStore.
 *
 * @author Kucykh Vasily (mailto:basil135@mail.ru)
 * @version $Id$
 * @since 23.05.2017
 */
public class StoreTest {

    /**
     * method tests UserStore class.
     */
    @Test
    public void whenUserStoreDoAllOperationThenRightStore() {

        UserStore us = new UserStore();

        User user1 = new User();
        user1.setId("1");

        User user2 = new User();
        user2.setId("2");

        User user3 = new User();
        user3.setId("3");

        us.add(user1);
        us.add(user2);
        us.add(user3);

        us.remove(user3);
        us.update(user1, user2);

        User[] actualArray = new User[1];
        actualArray = us.toArray(actualArray);

        User[] expectedArray = {user2, user2};

        assertThat(actualArray, is(expectedArray));

    }

    /**
     * method tests RoleStore class.
     */
    @Test
    public void whenRoleStoreDoAllOperationThenRightStore() {

        RoleStore rs = new RoleStore();

        Role role1 = new Role();
        role1.setId("1");

        Role role2 = new Role();
        role2.setId("2");

        Role role3 = new Role();
        role3.setId("3");

        rs.add(role1);
        rs.add(role2);
        rs.add(role3);

        rs.remove(role3);
        rs.update(role1, role2);

        Role[] actualArray = new Role[1];
        actualArray = rs.toArray(actualArray);

        Role[] expectedArray = {role2, role2};

        assertThat(actualArray, is(expectedArray));

    }

}
