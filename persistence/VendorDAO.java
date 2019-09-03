package com.hexaware.MLP154.persistence;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;
import java.util.List;
import com.hexaware.MLP154.model.Vendor;

/**
 * VendorDAO class used to fetch data from data base.
 * @author hexware
 */
public interface VendorDAO {
    /**
     * @return the all the Vendor record.
     */
  @SqlQuery("Select * from Vendor")
    @Mapper(VendorMapper.class)
    List<Vendor> show();
    /**
     * @param id tre
     * @param password yrry
     * @return the all the Menu record.
     */
  @SqlQuery("Select * from Vendor where VEN_ID= :Id && VEN_PWD= :password")
  @Mapper(VendorMapper.class)
  Vendor venValidate(@Bind("Id") int id, @Bind("password") String password);
  /**
     * @return the all the Vendor record.
     * @param vId vendor Id
     */
  @SqlQuery("select * from Vendor where VEN_ID=:vId")
    @Mapper(VendorMapper.class)
    Vendor showVenWalletBalance(@Bind("vId")int vId);
    /**
     * @return the all the Vendor record.
     * @param venId vendor Id
     * @param addedBal added balance
     */
  @SqlUpdate("Update VENDOR set VEN_WBAL = :addedBal WHERE VEN_ID = :id")
  int updateWallet(@Bind("id") int venId, @Bind("addedBal") int addedBal);
}
