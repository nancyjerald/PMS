package com.hexaware.MLP154.factory;

import com.hexaware.MLP154.persistence.EmployeeDAO;
import com.hexaware.MLP154.persistence.DbConnection;
import java.util.List;

import com.hexaware.MLP154.model.Employee;
/**
 * MenuFactory class used to fetch Employee data from database.
 * @author hexware
 */
public class EmployeeFactory {
  /**
   *  Protected constructor.
   */
  protected EmployeeFactory() {

  }
  /**
   * Call the data base connection.
   * @return the connection object.
   */
  private static EmployeeDAO dao() {
    DbConnection db = new DbConnection();
    return db.getConnect().onDemand(EmployeeDAO.class);
  }
  /**
   * Call the data base connection.
   * @return the array of Employee object.
   */
  public static Employee[] showEmployee() {
    List<Employee> employee = dao().show();
    return employee.toArray(new Employee[employee.size()]);
  }
  /**
   * Validation for empId and password.
   * @return val as true or false.
   * @param id hdfgs.
   * @param eP ojojo.
   */
  public static Employee empValidate(final int id, final String eP) {
    EmployeeDAO eDAO = dao();
    Employee val = eDAO.empValidate(id, eP);
    return val;
  }
  /**
   * Call the data base connection.
   * @return the wallet balance of Employee object.
   * @param eid employee id of the employee object
   *
   */
  public static Employee showEmpWalletBalance(final int eid) {
    EmployeeDAO eDAO = dao();
    Employee val = eDAO.showEmpWalletBalance(eid);
    return val;
  }
  /**
   * Call the data base connection.
   * @return the wallet balance of Employee object.
   * @param empId employee id of the employee object
   * @param deductedBal updated balance
   */
  public static int updateWalletGivenEmpId(final int empId, final int deductedBal) {
    EmployeeDAO eDAO = dao();
    int balance = eDAO.updateWallet(empId, deductedBal);
    return balance;
  }
}
