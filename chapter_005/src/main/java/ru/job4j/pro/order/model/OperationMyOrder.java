package ru.job4j.pro.order.model;

/**
 * This class describes data of order as operation of order and Order entity.
 *
 * @author Kutsyih Vasily (mailto:basil135@mail.ru)
 * @version $Id$
 * @since 28.01.2018
 */
public class OperationMyOrder {

    /**
     * parameter operation is enum - sale or buy.
     */
    private final Operation operation;
    /**
     * parameter order is data of order - volume and price.
     */
    private final Order order;

    /**
     * constructor of this class.
     *
     * @param operation is operation of order
     * @param order is order data like volume and price
     */
    public OperationMyOrder(Operation operation, Order order) {
        this.operation = operation;
        this.order = order;
    }

    /**
     * method return order.
     *
     * @return order
     */
    public Order getOrder() {
        return order;
    }

    /**
     * method return operation.
     *
     * @return operation
     */
    public Operation getOperation() {
        return operation;
    }

}
