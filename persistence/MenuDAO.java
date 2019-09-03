package com.hexaware.MLP154.persistence;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;
import java.util.List;
import com.hexaware.MLP154.model.Menu;
/**
 * MenuDAO class used to fetch data from data base.
 * @author hexware
 */
public interface MenuDAO {
    /**
     * @return the all the Menu record.
     */
  @SqlQuery("Select * from Menu")
    @Mapper(MenuMapper.class)
    List<Menu> show();
    /**
     * @return the all the foodID from Menu record.
     * @param fId foodid is passed.
     */
  @SqlQuery("Select * from Menu where FD_ID = :fId")
    @Mapper(MenuMapper.class)
    Menu validateFoodId(@Bind("fId") int fId);
}
