package Dealership.Invoice.Order;

import Dealership.Inventory.InventoryItem;
import Dealership.Profiles.Customer.Customer;
import Dealership.Profiles.SalesPerson.SalesPerson;

import java.util.HashSet;

/**
 * Order Catalog
 *
 * Created by manishgajare
 */
public class OrderCatalog {

  private static volatile OrderCatalog instance;
  private static Object mutex = new Object();
  private HashSet<Order> orderList;
  private int OrderCountForID;

  protected OrderCatalog() {
    orderList = new HashSet<Order>();
    OrderCountForID = 1;
  }

  public static OrderCatalog getInstance() {
    OrderCatalog result = instance;
    if (result == null) {
      synchronized (mutex) {
        result = instance;
        if (result == null) {
          instance = result = new OrderCatalog();
        }
      }
    }
    return result;
  }

  public HashSet<Order> getOrderList() {
    return orderList;
  }

  /**
   * Create and add Order in OrderCatalog
   */
  public Order addOrder(Customer customer, SalesPerson salesPerson, InventoryItem inventoryItem, double price) {
    Order order = new Order(OrderCountForID++, customer, salesPerson);
    order.addOrderItem(inventoryItem, price);
    orderList.add(order);
    return order;
  }

  @Override
  public String toString() {
    return "Order Catalog -> " + orderList;
  }

}
