package com.hexaware.MLP154.model;
import java.util.Objects;
/***
 * Vendor class used to display vendor information.
 * @author hexware
 */
public class Vendor {
  private int venId;
  private String venName;
  private String venPwd;
  private int venWbal;
/*
* venId to store vendorId.
* venName to store vendorname.
* venPwd to store vendor password.
* venWbal to store vendor balance.
*/
/** Default Constructor.
*/
  public Vendor() {
  }
/*** @param argvenId to initialize vendor id.
      @param argvenName to initialize vendor name.
      @param argvenPwd to initialize vendor Password.
      @param argvenWbal to initialize vendor wallet balance.
* used to get details through constructor.
*/
  public Vendor(final int argvenId, final String argvenName, final String argvenPwd, final int argvenWbal) {
    this.venId = argvenId;
    this.venName = argvenName;
    this.venPwd = argvenPwd;
    this.venWbal = argvenWbal;
  }
  @Override
  public final boolean equals(final Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    Vendor vendor = (Vendor) obj;
    if (Objects.equals(venId, vendor.venId) && Objects.equals(venName, vendor.venName) && Objects.equals(venPwd, vendor.venPwd)
        && Objects.equals(venWbal, vendor.venWbal)) {
      return true;
    }
    return false;
  }
  @Override
    public final int hashCode() {
    return Objects.hash(venId, venName, venPwd, venWbal);
  }
  /**
  * @return this vendor ID.
  */
  public final int getvenId() {
    return venId;
  }
  /**
  * @return this vendor Name.
  */
  public final String getvenName() {
    return venName;
  }
  /**
  * @return this vendor Password.
  */
  public final String getvenPwd() {
    return venPwd;
  }
  /**
  * @return this Vendor wallet balance.
  */
  public final int getvenWbal() {
    return venWbal;
  }
  /*** @param argvenId gets the vendor id.
  */
  public final void setvenId(final int argvenId) {
    this.venId = argvenId;
  }
  /*** @param argvenName gets the vendor Name.
  */
  public final void setvenName(final String argvenName) {
    this.venName = argvenName;
  }
  /*** @param argvenPwd gets the vendor password.
  */
  public final void setvenPwd(final String argvenPwd) {
    this.venPwd = argvenPwd;
  }
  /** @param argvenWbal the vendor wallet balance.
  */
  public final void setvenWbal(final int argvenWbal) {
    this.venWbal = argvenWbal;
  }
}
