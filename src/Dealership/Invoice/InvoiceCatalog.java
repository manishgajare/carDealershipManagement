package Dealership.Invoice;

import Dealership.Invoice.Order.Order;

import java.util.HashSet;

/**
 * Invoice Catalog
 *
 * Created by manishgajare
 */
public class InvoiceCatalog {

  private static volatile InvoiceCatalog instance;
  private static Object mutex = new Object();
  private HashSet<Invoice> invoiceList;
  private int invoiceCountForID;

  protected InvoiceCatalog() {
    invoiceList = new HashSet<Invoice>();
    invoiceCountForID = 1;
  }

  public static InvoiceCatalog getInstance() {
    InvoiceCatalog result = instance;
    if (result == null) {
      synchronized (mutex) {
        result = instance;
        if (result == null) {
          instance = result = new InvoiceCatalog();
        }
      }
    }
    return result;
  }

  /**
   * Adding invoice to InvoiceCatalog
   */
  public Invoice addInvoice(Order order) {
    Invoice invoice = new Invoice(invoiceCountForID++, order);
    invoiceList.add(invoice);
    return invoice;
  }

  @Override
  public String toString() {
    return "InvoiceList -> " + invoiceList;
  }


}
