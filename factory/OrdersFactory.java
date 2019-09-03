package com.hexaware.MLP154.factory;
import com.hexaware.MLP154.persistence.OrdersDAO;
import com.hexaware.MLP154.persistence.DbConnection;
import java.util.List;
//import com.hexaware.MLP154.model.Menu;
import com.hexaware.MLP154.model.Orders;
/**
 * OrdersFactory class used to fetch orders data from database.
 * @author hexware.
 */
public class OrdersFactory {
/**
   * Protected constructor.
*/
  protected OrdersFactory() {
  }

  /**
   * Call the data base connection.
   * @return the connection object.
   */
  private static OrdersDAO dao() {
    DbConnection db = new DbConnection();
    return db.getConnect().onDemand(OrdersDAO.class);
  }

  /**
   * Call the data base connection.
   * @return the array of Orders object.
   */
  public static Orders[] showOrders() {
    List<Orders> ord = dao().show();
    return ord.toArray(new Orders[ord.size()]);
  }

  /*
   * public static Orders[] orderAccept(Integer ordid){ List<Orders>
   * acord=dao().acceptOrder(); return acord.toArray(new Orders[acord.size()]);
   * //return acord.toArray(new Orders[acord.size()]); } public static Orders[]
   * regupdate(){ List<Orders> rcord=dao().rstat(); return rcord.toArray(new
   * Orders[rcord.size()]); }
   */
  /**
   * Call the data base connection.
   * @return the array of Orders object.
   * @param ordid the order of the objects.
   */
  public static int acceptOrder(final int ordid) {
    OrdersDAO eDAO = dao();
    int val = eDAO.acceptOrder(ordid);
    return val;
  }
  /**
   * rejecting orders.
   * @param ordid orderid.
   * @return returns the order details.
   */
  public static int rejectOrder(final int ordid) {
    OrdersDAO eDAO = dao();
    int val = eDAO.rejectOrder(ordid);
    return val;
  }

  /**
   * Call the data base connection.
   * @return the array of Orders object.
   */
  /*public static Orders[] showOrdersForCustomers() {
    List<Orders> ord = dao().show();
    return ord.toArray(new Orders[ord.size()]);
  }
*/
  /**
   * Call the data base connection.
   * @return the array of Orders object.
   * @param ab the array of orders object
   */
  // public static Orders showOrdersForVendorss(final int ab) {
  // OrdersDAO eDAO = dao();
  // Orders emp = eDAO.showOrdersForVendorss(ab);
  // return emp;
  // }
  /**
   * Call the data base connection.
   * @return the array of Orders object.
   */
   /*public static Orders[] showOrdersForVendors() {
    List<Orders> ord = dao().show();
    return ord.toArray(new Orders[ord.size()]);
  }
*/
  /**
   * Call the data base connection.
   * @return the array of Orders object.
   * @param a the array of orders object
   */
  public static Orders[] employeeorderhistory(final int a) {
    OrdersDAO oDAO = dao();
    List<Orders> odr = oDAO.employeeorderhistory(a);
    return odr.toArray(new Orders[odr.size()]);
  }
  /**
   * vendor history.
   * @param a array of orders object.
   * @return the arrays of the orders.
   */
  public static Orders[] vendororderhistory(final int a) {
    OrdersDAO oDAO = dao();
    List<Orders> odr = oDAO.vendororderhistory(a);
    return odr.toArray(new Orders[odr.size()]);
  }
  /**
   * call insertion order.
   * @return inserted order.
   * @param eId empid.
   * @param mfoodId food id.
   * @param ordQuant orderquantity.
   * @param tamnt total amount.
   * @param ordstat order status.
   * @param ordmsg order message.
   */
  public static int insertord(final int eId, final int mfoodId, final int ordQuant, final int tamnt, final String ordstat, final String ordmsg) {
    OrdersDAO ord = dao();
    return ord.insertoneord(eId, mfoodId, ordQuant, tamnt, ordstat, ordmsg);
  }
  /**
   * Call the data base connection.
   * @return the wallet balance of Employee object.
   * @param oId order id of the employee object.
   */
  public static Orders showOrderAmount(final int oId) {
    OrdersDAO oDAO = dao();
    Orders val = oDAO.showOrderAmount(oId);
    return val;
  }
  /**
   * Call the data base connection.
   * @return the wallet balance of Employee object.
   * @param vid order id of the employee object.
   */
  public static Orders[] getplacedOrders(final int vid) {
    List<Orders> ord = dao().getplacedOrders(vid);
    return ord.toArray(new Orders[ord.size()]);
  }
}
