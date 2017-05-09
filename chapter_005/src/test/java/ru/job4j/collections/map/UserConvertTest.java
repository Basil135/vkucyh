package ru.job4j.collections.map;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * This class tests class UserConvert.
 *
 * @author Kucykh Vasily (mailto:basil135@mail.ru)
 * @version $Id$
 * @since 08.05.2017
 */
public class UserConvertTest {

    /**
     * method tests method process of class UserConvert.
     */
    @Test
    public void whenConvertListWithFiveUsersThenMapHasFiveUsers() {

        UserConvert convert = new UserConvert();

        User john = new User(1, "John", "NY");
        User sara = new User(2, "Sara", "LA");
        User boris = new User(3, "Boris", "Moscow");
        User michael = new User(4, "Michael", "Paris");
        User chris = new User(5, "Chris", "Washington");

        List<User> users = new ArrayList<>();

        users.add(john);
        users.add(sara);
        users.add(boris);
        users.add(michael);
        users.add(chris);

        Map<Integer, User> expectedMap = new HashMap<>();

        expectedMap.put(1, john);
        expectedMap.put(2, sara);
        expectedMap.put(3, boris);
        expectedMap.put(4, michael);
        expectedMap.put(5, chris);

        Map<Integer, User> actualMap = convert.process(users);

        assertThat(actualMap, is(expectedMap));

    }

}
