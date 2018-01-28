package ru.job4j.pro.order.controller;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import ru.job4j.pro.order.model.BookOrder;
import ru.job4j.pro.order.model.Operation;
import ru.job4j.pro.order.model.OperationMyOrder;
import ru.job4j.pro.order.model.Order;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

/**
 * This class describes actions to parse xml file.
 *
 * @author Kutsykh Vasily (mailto:basil135@mail.ru)
 * @version $Id$
 * @since 28.01.2018
 */
public class XMLParser extends DefaultHandler {

    /**
     * parameter orderMap is instance of OrderMp class.
     */
    private final OrderMap orderMap = new OrderMap();

    /**
     * method override start element of xml and add order to map or delete.
     *
     * @param uri is uri of xml of tag
     * @param localName is localName of tag
     * @param qName is qName of tag
     * @param attributes is attributes of tag
     */
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {

        if (qName.equals("AddOrder")) {

            String bookName = attributes.getValue("book");
            String orderId = attributes.getValue("orderId");
            String volume = attributes.getValue("volume");
            String price = attributes.getValue("price");
            String strOperation = attributes.getValue("operation");

            Operation operation = strOperation.equals("BUY") ? Operation.BUY : Operation.SELL;

            Order order = new Order(volume, price);

            OperationMyOrder operationMyOrder = new OperationMyOrder(operation, order);

            BookOrder bookOrder = new BookOrder(orderId, operationMyOrder);

            orderMap.addOrder(bookName, bookOrder);

        } else if (qName.equals("DeleteOrder")) {

            String bookName = attributes.getValue("book");
            String orderId = attributes.getValue("orderId");

            BookOrder bookOrder = new BookOrder(orderId, null);

            orderMap.deleteOrder(bookName, bookOrder);

        }

    }

    /**
     * method parse file to orderMap.
     *
     * @param file is xml file to parse
     * @param xmlParser is instance of class
     * @return orderMap
     * @throws ParserConfigurationException throw if something going wrong in parse
     * @throws SAXException throw if something going wrong in parse
     * @throws IOException throw if something going wrong in parse
     */
    public OrderMap parse(final File file, XMLParser xmlParser) throws ParserConfigurationException, SAXException, IOException {

        SAXParser parser = SAXParserFactory.newInstance().newSAXParser();

        parser.parse(file, xmlParser);

        return orderMap;

    }

}
