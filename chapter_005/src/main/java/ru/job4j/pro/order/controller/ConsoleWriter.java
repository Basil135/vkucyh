package ru.job4j.pro.order.controller;

import ru.job4j.pro.order.model.BookOrder;
import ru.job4j.pro.order.model.Operation;
import ru.job4j.pro.order.model.OperationMyOrder;
import ru.job4j.pro.order.model.Order;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * This class describes methods to write into console.
 *
 * @author Kutsykh Vasily (mailto:basil135@mail.ru)
 * @version $Id$
 * @since 28.01.2018
 */
public class ConsoleWriter {
    /**
     * method return String to separate orders.
     *
     * @return string with separator
     */
    private String lineSeparator() {
        return "---------";
    }
    /**
     * method generate result String from sellList of order and buyList Of Order.
     *
     * @param count describes count of list to generate to string
     * @param sellList list of order to sell
     * @param buyList list of order to buy
     * @return return string
     */
    private String generateString(int count, List<Order> sellList, List<Order> buyList) {
        StringBuilder result = new StringBuilder();
        result.append(count < sellList.size() ? sellList.get(count) : lineSeparator());
        result.append("\t\t");
        result.append("-");
        result.append("\t\t");
        result.append(count < buyList.size() ? buyList.get(count) : lineSeparator());
        return result.toString();
    }
    /**
     * method generate list of orders by operation.
     *
     * @param bookOrderList list of all BookOrder class list
     * @param operation is operation, enum buy or sell
     * @return list of order by operation
     */
    private List<Order> getOrders(List<BookOrder> bookOrderList, Operation operation) {
        List<Order> result = new ArrayList<>();
        for (BookOrder bookOrder : bookOrderList) {
            OperationMyOrder operationMyOrder = bookOrder.getOperationMyOrder();
            if (operationMyOrder.getOperation().equals(operation)) {
                Order order = operationMyOrder.getOrder();
                if (result.contains(order)) {
                    int index = result.indexOf(order);
                    int volumeNewOrder = Integer.parseInt(result.get(index).getVolume());
                    int volumeOrderInResult = Integer.parseInt(order.getVolume());
                    String newVolume = String.valueOf(volumeNewOrder + volumeOrderInResult);
                    Order newOrder = new Order(newVolume, order.getPrice());
                    order = newOrder;
                    result.remove(index);
                }
                result.add(order);
            }
        }
        if (operation.equals(Operation.SELL)) {
            result.sort((o1, o2) -> o2.getPrice().compareTo(o1.getPrice()));
        } else {
            result.sort((o1, o2) -> o1.getPrice().compareTo(o2.getPrice()));
        }
        return result;
    }
    /**
     * method print to console list of string.
     *
     * @param list is list of string to print on console
     */
    private void writeStringToConsole(List<String> list) {
        for (String string : list) {
            System.out.println(string);
        }
    }
    /**
     * method generate result list of String of orders by book name.
     *
     * @param bookName is name of a book
     * @param map is map of a String as name of a book and list of BookOrder by this book
     * @return list of string as order for one book name
     */
    public List<String> getResultOrder(final String bookName, Map<String, List<BookOrder>> map) {
        List<String> result = new ArrayList<>();
        result.add("\n\nOrder book: " + bookName);
        result.add("BID\t\t\t\t\t\tASK");
        result.add("Volume@Price\t–\t\tVolume@Price");
        List<BookOrder> bookOrderList = map.get(bookName);
        if (bookOrderList == null) {
            result.add(lineSeparator() + "\t\t" + lineSeparator());
        } else {
            List<Order> sellList = getOrders(bookOrderList, Operation.SELL);
            List<Order> buyList = getOrders(bookOrderList, Operation.BUY);
            int size = sellList.size() < buyList.size() ? buyList.size() : sellList.size();
            for (int i = 0; i  < size; i++) {
                result.add(generateString(i, sellList, buyList));
            }
        }
        return result;
    }
    /**
     * method write to console list of list of string.
     *
     * @param list is list of list of string as result list of order by book name
     */
    public void writeToConsole(List<List<String>> list) {
        for (List<String> stringList: list) {
            writeStringToConsole(stringList);
        }
    }
}
