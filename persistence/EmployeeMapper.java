package com.hexaware.MLP154.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.hexaware.MLP154.model.Employee;

import org.skife.jdbi.v2.tweak.ResultSetMapper;
import org.skife.jdbi.v2.StatementContext;
/**
 * EmployeeMapper class used to fetch employee data from database.
 * @author hexware
 */
public class EmployeeMapper implements ResultSetMapper<Employee> {
    /**
     * @param idx the index.
     * @param rs the resultset.
     * @param ctx the context.
     * @return the mapped customer object.
     * @throws SQLException in case there is an error in fetching data from the resultset.
     */
  public final Employee map(final int idx, final ResultSet rs, final StatementContext ctx) throws SQLException {
      /**
       * @return Employee
       */
    int empId = rs.getInt("EMP_ID");
    String empName = rs.getString("EMP_NAME");
    String empPwd = rs.getString("EMP_PWD");
    int walletBalance = rs.getInt("EMP_WBAL");
    String contactNumber = rs.getString("EMP_CNO");
    Employee emp = new Employee(empId, empName, empPwd, walletBalance, contactNumber);
    return emp;
    //return new Employee(rs.getInt("emp_id"));
  }
}
