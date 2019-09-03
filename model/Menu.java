package com.hexaware.MLP154.model;
import java.util.Objects;
/***
 * Menu class used to display menu information.
 * @author hexware
 */
public class Menu {
/*
 * foodId to store foodId.
 */
  private int foodId;
/*
 * fdName to store foodName.
 */
  private String fdName;
/*
 * fdPrice to store foodPrice.
 */
  private int fdPrice;
/*
 * venId to store vendor Id.
 */
  private int venId;

/** Default Constructor.
   */
  public Menu() {

  }
/*** @param argFoodId to initialize food id.
      @param argFdName to initialize food name.
      @param argFdPrice to initialize food Price.
      @param argVenId to initialize vendor id.
 * used to get details through constructor.
 */
  public Menu(final int argFoodId, final String argFdName, final int argFdPrice, final int argVenId) {
    this.foodId = argFoodId;
    this.fdName = argFdName;
    this.fdPrice = argFdPrice;
    this.venId = argVenId;
  }
  @Override
    public final boolean equals(final Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    Menu menu = (Menu) obj;
    if (Objects.equals(foodId, menu.foodId) && Objects.equals(fdName, menu.fdName) && Objects.equals(fdPrice, menu.fdPrice)
        && Objects.equals(venId, menu.venId)) {
      return true;
    }
    return false;
  }
  @Override
    public final int hashCode() {
    return Objects.hash(foodId, fdName, fdPrice, venId);
  }
    /**
     * @return this food ID.
     */
  public final int getFoodId() {
    return foodId;
  }
  /**
     * @return this food Name.
     */
  public final String getfdName() {
    return fdName;
  }
  /**
     * @return this food Price.
     */
  public final int getfdPrice() {
    return fdPrice;
  }
  /**
     * @return this Vendor ID.
     */
  public final int getvenId() {
    return venId;
  }
    /*** @param argFoodId gets the food id.
     */
  public final void setfoodId(final int argFoodId) {
    this.foodId = argFoodId;
  }
  /*** @param argFdName gets the food Name.
     */
  public final void setfdName(final String argFdName) {
    this.fdName = argFdName;
  }
  /*** @param argFdPrice gets the food Price.
     */
  public final void setfdPrice(final int argFdPrice) {
    this.fdPrice = argFdPrice;
  }
  /*** @param argVenId gets the vendor id.
     */
  public final void setvenId(final int argVenId) {
    this.venId = argVenId;
  }

  @Override
  public final String toString() {
    return "Menu [fdName=" + fdName + ", fdPrice=" + fdPrice + ", foodId=" + foodId + ", venId=" + venId + "]";
  }
}
