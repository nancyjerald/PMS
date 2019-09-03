package com.hexaware.MLP154.factory;

import com.hexaware.MLP154.persistence.MenuDAO;
import com.hexaware.MLP154.persistence.DbConnection;
import java.util.List;

import com.hexaware.MLP154.model.Menu;
/**
 * MenuFactory class used to fetch menu data from database.
 * @author hexware
 */
public class MenuFactory {
  /**
   *  Protected constructor.
   */
  protected MenuFactory() {

  }
  /**
   * Call the data base connection.
   * @return the connection object.
   */
  private static MenuDAO dao() {
    DbConnection db = new DbConnection();
    return db.getConnect().onDemand(MenuDAO.class);
  }
  /**
   * Call the data base connection.
   * @return the array of menu object.
   */
  public static Menu[] showMenu() {
    List<Menu> menu = dao().show();
    return menu.toArray(new Menu[menu.size()]);
  }
    /**
   * @param fId gets the food Id
   * @return return the fdId
   */
  public static Menu validateGivenFoodId(final int fId) {
    MenuDAO mDAO = dao();
    Menu val = mDAO.validateFoodId(fId);
    return val;
  }
}
