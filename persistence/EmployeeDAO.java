package com.hexaware.MLP154.persistence;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;
import java.util.List;
import com.hexaware.MLP154.model.Employee;
/**
 * MenuDAO class used to fetch data from data base.
 * @author hexware
 */
public interface EmployeeDAO {
    /**
     * @return the all the Menu record.
     */
  @SqlQuery("Select * from Employee")
    @Mapper(EmployeeMapper.class)
    List<Employee> show();
    /**
     * @param id fdf.
     * @param password fsd.
     * @return the all the Menu record.
     */
  @SqlQuery("Select * from  Employee where EMP_ID= :Id && EMP_PWD = :password")
    @Mapper(EmployeeMapper.class)
  Employee empValidate(@Bind("Id") int id, @Bind("password") String password);
   /**
     * @return the employee balance.
     * @param eId employee id of the employee object
     */
  @SqlQuery("select * from EMPLOYEE where EMP_ID=:eId")
    @Mapper(EmployeeMapper.class)
    Employee showEmpWalletBalance(@Bind("eId")int eId);
  /**
     * @return the employee balance.
     * @param empId employee id of the employee object
     * @param deductedBal modified balance
     */
  @SqlUpdate("Update EMPLOYEE set EMP_WBAL = :deductedBal WHERE EMP_ID = :id")
  int updateWallet(@Bind("id") int empId, @Bind("deductedBal") int deductedBal);
}
