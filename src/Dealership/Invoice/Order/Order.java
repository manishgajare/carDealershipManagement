package Dealership.Invoice.Order;

import Dealership.Inventory.InventoryCatalog;
import Dealership.Inventory.InventoryItem;
import Dealership.Invoice.InvoiceCatalog;
import Dealership.Profiles.Customer.Customer;
import Dealership.Profiles.SalesPerson.SalesPerson;

import java.util.HashSet;

/**
 * Order - List of OrderItems
 *
 * Created by manishgajare
 */
public class Order {

  private int id;
  private HashSet<OrderItem> orderItemList;
  private Customer customer;
  private SalesPerson salesPerson;
  private int orderItemCountForID;

  protected Order(int id, Customer customer, SalesPerson salesPerson) {
    orderItemList = new HashSet<OrderItem>();
    this.customer = customer;
    this.salesPerson = salesPerson;
    this.id = id;
    orderItemCountForID = 1;
  }

  public int getId() {
    return id;
  }

  public HashSet<OrderItem> getOrderItemList() {
    return orderItemList;
  }

  public Customer getCustomer() {
    return customer;
  }

  public SalesPerson getSalesPerson() {
    return salesPerson;
  }

  /**
   * Create orderItem and add to Order
   * Also change the Inventory space and Quantity as per the orderItem
   */
  protected OrderItem addOrderItem(InventoryItem inventoryItem, double price) {
    OrderItem orderItem = new OrderItem(orderItemCountForID++, inventoryItem, price);
    InventoryCatalog inventoryCatalog = InventoryCatalog.getInstance();
    inventoryCatalog.removeInventoryItem(inventoryItem, 1);
    orderItemList.add(orderItem);
    return orderItem;
  }

  @Override
  public String toString() {
    return "OrderItem -> " +
      "Order id: " + id +
      "Customer: " + customer +
      "Sales Person: " + salesPerson +
      "Order Items: " + orderItemList;
  }

}
