package com.hexaware.MLP154.persistence;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;
import java.util.List;
import com.hexaware.MLP154.model.Orders;
/**
 * OrdersDAO class used to fetch data from data base.
 * @author hexware
 */
public interface OrdersDAO {
    /**
     * @return the all the Orders record.
     */
  @SqlQuery("Select * from Orders")
    @Mapper(OrdersMapper.class)
    List<Orders> show();
    /**
     * order status acceptance and cancellation.
     * @param ordid order Id.
     * @return updation.
     */
  @SqlUpdate("update ORDERS set ORD_STATUS='Accepted' where ORD_ID=:ordid")
  int acceptOrder(@Bind("ordid")int ordid);
  /**
   *
   * @param ordid orderid is passed.
   * @return rejected order status.
   */
  @SqlUpdate("update ORDERS set ORD_STATUS='Cancelled' where ORD_ID=:ordid")
  int rejectOrder(@Bind("ordid")int ordid);
  /**
     * @param id the all the history.
     * @return the all the Orders record.
     */
  @SqlQuery("select * from Orders where EMP_ID= :empID ")
      @Mapper(OrdersMapper.class)
      List<Orders> employeeorderhistory(@Bind("empID") int id);
       /**
         * @param id the all the history.
         * @return the all the Orders record.
         */
  @SqlQuery("select o.* from orders o join menu m on o.fd_id=m.fd_id where m.ven_id = :venID")
      @Mapper(OrdersMapper.class)
      List<Orders> vendororderhistory(@Bind("venID") int id);
      /**
       * Order insertion.
       * @param eId empid.
       * @param fId foodid.
       * @param ordQuant orderquantity.
       * @param tamnt total amount.
       * @param ordstat order status.
       * @param ordmsg order message.
       * @return inserted value.
       */
  @SqlUpdate("insert into Orders(EMP_ID,FD_ID, ORD_QUANT, ORD_AMNT,ORD_STATUS,ORD_MSG)" + "values(:eId,:fId,:ordQuant,:tamnt,:ordstat,:ordmsg)")
      int insertoneord(@Bind("eId") int eId,
         @Bind("fId") int fId,
         @Bind("ordQuant") int ordQuant,
         @Bind("tamnt") int tamnt,
         @Bind("ordstat") String ordstat,
         @Bind("ordmsg") String ordmsg);
  /**
     * @return the order amount.
     * @param oId order id.
     */
  @SqlQuery("select * from ORDERS where ORD_ID=:oId")
      @Mapper(OrdersMapper.class)
      Orders showOrderAmount(@Bind("oId")int oId);
   /**
     * @return the order amount.
     * @param vid vendor id.
     */
  @SqlQuery("select * from Orders o, Menu m where o.FD_ID=m.FD_ID and ORD_STATUS='Placed'and VEN_ID=:vid")
      @Mapper(OrdersMapper.class)
      List<Orders> getplacedOrders(@Bind("vid") int vid);
}
