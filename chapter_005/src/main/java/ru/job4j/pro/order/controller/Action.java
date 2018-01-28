package ru.job4j.pro.order.controller;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * This class describes main action that execute all classes that need.
 *
 * @author Kutsyih Vasily (mailto:basil@mail.ru)
 * @version $Id$
 * @since 28.01.2018
 */
public class Action {

    /**
     * method that execute all.
     *
     * @param filePath is path to xml file
     * @throws IOException throws when file does not exist
     * @throws SAXException throws when SAXParser is going wrong
     * @throws ParserConfigurationException throws when parser is going wrong
     */
    public static void action(String filePath) throws IOException, SAXException, ParserConfigurationException {

        File file = new File(filePath);

        XMLParser parser = new XMLParser();

        OrderMap orderMap = parser.parse(file, parser);

        ConsoleWriter consoleWriter = new ConsoleWriter();

        Set<String> books = orderMap.getBookNames();

        List<List<String>> result = new ArrayList<>();

        for (String book : books) {
            result.add(consoleWriter.getResultOrder(book, orderMap.getMap()));
        }

        consoleWriter.writeToConsole(result);

    }

}
