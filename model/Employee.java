package com.hexaware.MLP154.model;
import java.util.Objects;
/**
 * Employee class used to display employee information.
 * @author hexaware
 */
public class Employee {
/**
 * empId to store empId.
 */
  private int empId;
  private String empName;
  private String contactNumber;
  private int walletBalance;
  private String empPwd;
  /**
   * Default Constructor.
 * @param contactNumber
 * @param empPwd
 * @param walletBalance
 * @param empName
 * @param empId
   */
  public Employee() {

  }
/**
* @param argEmpId to initialize emp id.
* @param argempName to initialize emp Name.
* @param argcontactNumber to initialize contact number.
* @param argwalletBalance to initialize wallet balance.
* @param argEmpPwd to initialize emp pwd.
*/
  public Employee(final int argEmpId, final String argempName, final String argEmpPwd, final int argwalletBalance, final String argcontactNumber)  {
    this.empId = argEmpId;
    this.empName = argempName;
    this.empPwd = argEmpPwd;
    this.walletBalance = argwalletBalance;
    this.contactNumber = argcontactNumber;
  }
  @Override
    public final boolean equals(final Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    Employee employee = (Employee) obj;
    if (Objects.equals(empId, employee.empId) && Objects.equals(empName, employee.empName)
        && Objects.equals(empPwd, employee.empPwd)
        && Objects.equals(contactNumber, employee.contactNumber) && Objects.equals(walletBalance, employee.walletBalance)) {
      return true;
    }
    return false;
  }
  @Override
    public final int hashCode() {
    return Objects.hash(empId, empName, contactNumber, walletBalance, empPwd);
  }
  /**
  *@return this empId ID.
  */
  public final int getEmpId() {
    return empId;
  }
  /**
   *@param argEmpId gets the emp id.
   */
  public final void setEmpId(final int argEmpId) {
    this.empId = argEmpId;
  }
  /**
  *@return this emp Name.
  */
  public final String getEmpName() {
    return empName;
  }
  /**
  *@param argempName gets the emp name.
  */
  public final void setEmpName(final String argempName) {
    this.empName = argempName;
  }
  /**
  *@return this emp Pwd.
  */
  public final String getEmpPwd() {
    return empPwd;
  }
  /**
  *@param argempPwd gets the emp pwd.
  */
  public final void setEmpPwd(final String argempPwd) {
    this.empPwd = argempPwd;
  }
  /**
  *@return this emp no.
  */
  public final String getcontactNumber() {
    return contactNumber;
  }
  /**
  *@param argcontactnumber gets the emp no.
  */
  public final void setcontactNumber(final String argcontactnumber) {
    this.contactNumber = argcontactnumber;
  }
  /**
  *@return this emp wallet.
  */
  public final int getwalletBalance() {
    return walletBalance;
  }
  /**
  *@param argwalletbalanceId gets the emp wallet.
  */
  public final void setwalletbalanceId(final int argwalletbalanceId) {
    this.walletBalance = argwalletbalanceId;
  }
  @Override
  public final String toString() {
    return "Employee [contactNumber=" + contactNumber + ", empId=" + empId + ", empName=" + empName + ", empPwd="
        + empPwd + ", walletBalance=" + walletBalance + "]";
  }
}
