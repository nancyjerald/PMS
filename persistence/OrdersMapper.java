package com.hexaware.MLP154.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;

//import com.hexaware.MLP154.model.Menu;
import com.hexaware.MLP154.model.Orders;

import org.skife.jdbi.v2.tweak.ResultSetMapper;
import org.skife.jdbi.v2.StatementContext;

/**
 * OrdersMapper class used to fetch orders data from database.
 *
 * @author hexware
 */

public class OrdersMapper implements ResultSetMapper<Orders> {
  /**
   * @param idx the index
   * @param rs  the resultset
   * @param ctx the context
   * @return the mapped customer object
   * @throws SQLException in case there is an error in fetching data from the
   *                      resultset
   */
  public final Orders map(final int idx, final ResultSet rs, final StatementContext ctx) throws SQLException {
    /**
     * @return Orders
     */
    int ordid = rs.getInt("ORD_ID");
    int empid = rs.getInt("EMP_ID");
    int fdid = rs.getInt("FD_ID");
    int ordquant = rs.getInt("ORD_QUANT");
    int ordamnt = rs.getInt("ORD_AMNT");
    Time ordtime = rs.getTime("ORD_TIME");
    Time esttime = rs.getTime("EST_TIME");
    String ordstatus = rs.getString("ORD_STATUS");
    String ordmsg = rs.getString("ORD_MSG");
    int ordrating = rs.getInt("ORD_RATING");
    Orders ord = new Orders(ordid, empid, fdid, ordquant, ordamnt, ordtime, esttime, ordstatus, ordmsg, ordrating);
    return ord;
  }
}
