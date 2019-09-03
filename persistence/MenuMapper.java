package com.hexaware.MLP154.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.hexaware.MLP154.model.Menu;

import org.skife.jdbi.v2.tweak.ResultSetMapper;
import org.skife.jdbi.v2.StatementContext;
/**
 * MenuMapper class used to fetch menu data from database.
 * @author hexware
 */
public class MenuMapper implements ResultSetMapper<Menu> {
    /**
     * @param idx the index
     * @param rs the resultset
     * @param ctx the context
     * @return the mapped customer object
     * @throws SQLException in case there is an error in fetching data from the resultset
     */
  public final Menu map(final int idx, final ResultSet rs, final StatementContext ctx) throws SQLException {
      /**
       * @return Menu
       */
    int id = rs.getInt("FD_ID");
    String foodName = rs.getString("FD_NAME");
    int price = rs.getInt("FD_PRICE");
    int venId = rs.getInt("VEN_ID");
    Menu mnu = new Menu(id, foodName, price, venId);
    return mnu;
    //return new Menu(rs.getInt("FD_ID"), rs.getInt("FD_NAME"), rs.getInt("FD_PRICE"), rs.getInt("VEN_ID"));
  }
}
