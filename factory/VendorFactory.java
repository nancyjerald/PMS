package com.hexaware.MLP154.factory;

import java.util.List;

import com.hexaware.MLP154.model.Vendor;
import com.hexaware.MLP154.persistence.DbConnection;
import com.hexaware.MLP154.persistence.VendorDAO;
/**
 * VendorFactory class used to fetch menu data from database.
 * @author hexware
 */
public class VendorFactory {
  /**
   *  Protected constructor.
   */
  protected VendorFactory() {

  }
  /**
   * Call the data base connection.
   * @return the connection object.
   */
  private static VendorDAO dao() {
    DbConnection db = new DbConnection();
    return db.getConnect().onDemand(VendorDAO.class);
  }
  /**
   * Call the data base connection.
   * @return the array of vendor object.
   */
  public static Vendor[] showMenu() {
    List<Vendor> ven = dao().show();
    return ven.toArray(new Vendor[ven.size()]);
  }
  /**
   * Call the data base connection.
   * @param id gdfg
   * @param eN gdgf
   * @return the array of vendor object.
   */
  public static Vendor venValidate(final int id, final String eN) {
    VendorDAO vDAO = dao();
    Vendor val = vDAO.venValidate(id, eN);
    return val;
  }
  /**
   * Call the data base connection.
   * @return the array of vendor object.
   * @param eid employee id
   */
  public static Vendor showVenWalletBalance(final int eid) {
    VendorDAO vDAO = dao();
    Vendor val = vDAO.showVenWalletBalance(eid);
    return val;
  }
  /**
   * Call the data base connection.
   * @return the array of vendor object.
   * @param venId vendor Id
   * @param addedBal edited balance
   */
  public static int updateWalletGivenVenId(final int venId, final int addedBal) {
    VendorDAO vDAO = dao();
    int balance = vDAO.updateWallet(venId, addedBal);
    return balance;
  }
}
