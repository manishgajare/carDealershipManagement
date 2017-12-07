package Dealership.Invoice;

import Dealership.Invoice.Order.Order;
import Dealership.Invoice.Order.OrderItem;

/**
 * Invoice
 *
 * Created by manishgajare
 */
public class Invoice {

  private int id;
  private Order order;
  private double price = 0;

  public Invoice(int id, Order order) {
    this.id = id;
    this.order = order;
    for (OrderItem orderItem : order.getOrderItemList()) {
      this.price += orderItem.getPrice();
    }
  }

  public int getId() {
    return id;
  }

  public Order getOrder() {
    return order;
  }

  public double getPrice() {
    return price;
  }

  @Override
  public String toString() {
    return "Invoice -> " +
      "Order id: " + id +
      ", Order: " + order +
      ", price: " + price + System.lineSeparator();
  }
}
