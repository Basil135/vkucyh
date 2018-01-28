package ru.job4j.pro.order;

import org.xml.sax.SAXException;
import ru.job4j.pro.order.controller.Action;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

/**
 * This class is use to run program.
 *
 * @author Kutsykh Vasily (mailto:basil135@mail.ru)
 * @version $Id$
 * @since 28.01.2018
 */
public class Main {

    /**
     * method run a program.
     *
     * @param args args
     * @throws ParserConfigurationException is exception
     * @throws IOException is exception
     * @throws SAXException is exception
     * @throws InterruptedException is exception
     */
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException, InterruptedException {

        Action.action("/Users/kucyh/Downloads/orders.xml");

    }

}
