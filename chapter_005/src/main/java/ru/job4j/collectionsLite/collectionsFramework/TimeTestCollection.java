package ru.job4j.collectionsLite.collectionsFramework;

import java.util.Collection;
import java.util.Iterator;

/**
 * This class show us how many milliseconds do add operation on collection and delete operation.
 *
 * @author Kucykh Vasily (mailto:basil135@mail.ru)
 * @version $Id$
 * @since 05.05.2017
 */
public class TimeTestCollection {

    /**
     * method return how many millis gone to do operation add String line amount times.
     *
     * @param collection is collection we add String line
     * @param line is String we add to collection
     * @param amount is number of times we need to add
     * @return how many millis gone
     */
    public long add(Collection<String> collection, String[] line, int amount){

        long result = System.currentTimeMillis();

        for (int count = 0; count < amount; count++) {
            collection.add(line[count]);
        }

        result = System.currentTimeMillis() - result;

        return result;

    }

    /**
     * method return how many millis gone to delete first item of collection amount times.
     *
     * @param collection is collection we remove
     * @param amount is number of times we need to remove
     * @return how many millis gone
     */
    public long delete(Collection<String> collection, int amount) {

        int count = 0;

        Iterator<String> iter = collection.iterator();

        long result = System.currentTimeMillis();

        while (iter.hasNext()) {

            iter.next();
            iter.remove();

            if (++count >= amount) {
                break;
            }

        }

        result = System.currentTimeMillis() - result;

        return result;

    }

}
