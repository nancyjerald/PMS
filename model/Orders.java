
package com.hexaware.MLP154.model;
import java.sql.Time;
import java.util.Objects;
/**
* Menu class used to display menu information.
* @author hexware
*/
public class Orders {
/**
* ordId to store orderId.
*/
  private int ordId;
/**
* empId to store empId.
*/
  private int empId;
/**
* fdId to store foodId.
*/
  private int fdId;
/**
* ordQuant to store Order Quantity.
*/
  private int ordQuant;
/**
* ordAmnt to store OrderAmount.
*/
  private int ordAmnt;
/**
* ordTime to store ordertime.
*/
  private Time ordTime;
/**
* estTime to store Estimation time.
*/
  private Time estTime;
/**
* ordStatus to store Orderstatus.
*/
  private String ordStatus;
/**
* ordMsg to store Ordermessage.
*/
  private String ordMsg;
/**
* ordRating to store orderRating.
*/
  private int ordRating;
/**
* Default Constructor.
 * @param i
*/
  public Orders() {

  }
/**
*  @param argOrdId to initialize order id.
      @param argEmpId to initialize Employee id.
      @param argFdId to initialize food id.
      @param argOrdQuant to initialize order Quantity.
      @param argOrdAmnt to initialize Order Amount.
      @param argOrdTime to initialize Order Time.
      @param argEstTime to initialize Estimation time.
      @param argOrdStatus to initialize Order Status.
      @param argOrdMsg to initialize Order Message.
      @param argOrdRating to initialize Order Rating.
 * used to get details through constructor.
 */
  public Orders(final int argOrdId,
                final int argEmpId,
                final int argFdId,
                final int argOrdQuant,
                final int argOrdAmnt,
                final Time argOrdTime,
                final Time argEstTime,
                final String argOrdStatus,
                final String argOrdMsg,
                final int argOrdRating) {
    this.ordId = argOrdId;
    this.empId = argEmpId;
    this.fdId = argFdId;
    this.ordQuant = argOrdQuant;
    this.ordAmnt = argOrdAmnt;
    this.ordTime = argOrdTime;
    this.estTime = argEstTime;
    this.ordStatus = argOrdStatus;
    this.ordMsg = argOrdMsg;
    this.ordRating = argOrdRating;

  }
  @Override
    public final boolean equals(final Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    Orders ord = (Orders) obj;
    if (Objects.equals(ordId, ord.ordId) && Objects.equals(empId, ord.empId) && Objects.equals(fdId, ord.fdId)
        && Objects.equals(ordQuant, ord.ordQuant) && Objects.equals(ordAmnt, ord.ordAmnt) && Objects.equals(ordTime, ord.ordTime)
        && Objects.equals(estTime, ord.estTime) && Objects.equals(ordStatus, ord.ordStatus) && Objects.equals(ordMsg, ord.ordMsg)
        && Objects.equals(ordRating, ord.ordRating)) {
      return true;
    }
    return false;
  }
  @Override
    public final int hashCode() {
    return Objects.hash(ordId, empId, fdId, ordQuant, ordAmnt, ordTime, estTime, ordStatus, ordMsg, ordRating);
  }
/**
* @return this order ID.
*/
  public final int getordId() {
    return ordId;
  }
/**
* @return this employee Id.
*/
  public final int getempId() {
    return empId;
  }
/**
* @return this food Id.
*/
  public final int getfdId() {
    return fdId;
  }
/**
* @return this order Quantity.
*/
  public final int getordQuant() {
    return ordQuant;
  }
/**
* @return this order Amount.
*/
  public final int getordAmnt() {
    return ordAmnt;
  }
/**
* @return this order Time.
*/
  public final Time getordTime() {
    return ordTime;
  }
/**
* @return this Estimated time.
*/
  public final Time getestTime() {
    return estTime;
  }
/**
* @return this order Status.
*/
  public final String getordStatus() {
    return ordStatus;
  }
/**
* @return this order Message.
*/
  public final String getordMsg() {
    return ordMsg;
  }
/**
* @return this order Rating.
*/
  public final int getordRating() {
    return ordRating;
  }
/**
*  @param argOrdId gets the order id.
*/
  public final void setordId(final int argOrdId) {
    this.ordId = argOrdId;
  }
/**
*  @param argEmpId gets the employee id.
*/
  public final void setempId(final int argEmpId) {
    this.empId = argEmpId;
  }
/**
* @param argFdId gets the food id.
*/
  public final void setfdId(final int argFdId) {
    this.fdId = argFdId;
  }
/**
*  @param argOrdQuant gets the Order Quantity.
*/
  public final void setordQuant(final int argOrdQuant) {
    this.ordQuant = argOrdQuant;
  }
/**
*  @param argOrdAmnt gets the Order amount.
*/
  public final void setordAmnt(final int argOrdAmnt) {
    this.ordAmnt = argOrdAmnt;
  }
/**
*  @param argOrdTime gets the order time.
*/
  public final void setordTime(final Time argOrdTime) {
    this.ordTime = argOrdTime;
  }
/**
*  @param argEstTime gets the estimation time.
*/
  public final void setestTime(final Time argEstTime) {
    this.estTime = argEstTime;
  }
/**
*  @param argOrdStatus gets the order status.
*/
  public final void setordStatus(final String argOrdStatus) {
    this.ordStatus = argOrdStatus;
  }
/**
* @param argOrdMsg gets the order message.
*/
  public final void setordMsg(final String argOrdMsg) {
    this.ordMsg = argOrdMsg;
  }
/**
*  @param argOrdRating gets the order rating.
*/
  public final void setordRating(final int argOrdRating) {
    this.ordRating = argOrdRating;
  }
  @Override
  public final String toString() {
    return "Orders [empId=" + empId + ", estTime=" + estTime + ", fdId=" + fdId + ", ordAmnt=" + ordAmnt + ", ordId="
        + ordId + ", ordMsg=" + ordMsg + ", ordQuant=" + ordQuant + ", ordRating=" + ordRating + ", ordStatus="
        + ordStatus + ", ordTime=" + ordTime + "]";
  }
}
