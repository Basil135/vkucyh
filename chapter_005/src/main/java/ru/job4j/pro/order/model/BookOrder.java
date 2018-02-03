package ru.job4j.pro.order.model;
/**
 * This class describes entity BookOrder as order id and OperationMyOrder as next else data of order.
 *
 * @author Kutsyih Vasily (mailto:basil135@mail.ru)
 * @version $Id$
 * @since 28.01.2018
 */
public class BookOrder {
    /**
     * parameter orderId is id of order.
     */
    private final String orderId;
    /**
     * parameter operationMyOrder is data of order.
     */
    private final OperationMyOrder operationMyOrder;
    /**
     * constructor of this class.
     *
     * @param orderId is id of order
     * @param operationMyOrder is data of order
     */
    public BookOrder(final String orderId, final OperationMyOrder operationMyOrder) {
        this.operationMyOrder = operationMyOrder;
        this.orderId = orderId;
    }
    /**
     * method return orderId.
     *
     * @return orderId
     */
    public String getOrderId() {
        return orderId;
    }
    /**
     * method return operationMyOrder.
     *
     * @return operationMyOrder
     */
    public OperationMyOrder getOperationMyOrder() {
        return operationMyOrder;
    }
}
