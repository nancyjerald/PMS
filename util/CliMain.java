package com.hexaware.MLP154.util;

import java.util.Scanner;
import com.hexaware.MLP154.factory.EmployeeFactory;
import com.hexaware.MLP154.factory.MenuFactory;
import com.hexaware.MLP154.factory.OrdersFactory;
import com.hexaware.MLP154.factory.VendorFactory;
import com.hexaware.MLP154.model.Employee;
import com.hexaware.MLP154.model.Menu;
import com.hexaware.MLP154.model.Orders;
import com.hexaware.MLP154.model.Vendor;

/**
 * CliMain used as Client interface for java coading.
 * @author hexware.
 */
class CliMain {
  private Scanner option = new Scanner(System.in, "UTF-8");

  /**
   * mainMenu method used to display the option we had in the application.
   */
  private void mainMenu() {
    System.out.println("Canteen Management System");
    System.out.println("-----------------------");
    System.out.println("1.Show Full Menu ");
    System.out.println("2.Employee Login");
    System.out.println("3.Vendor Login");
    System.out.println("4.Exit");
    mainMenuDetails();
  }

  /**
   * mainMenuDetails method process the option selected from main menu.
   */
  private void mainMenuDetails() {
    try {
      System.out.println("Enter your choice:");
      int menuOption = option.nextInt();
      switch (menuOption) {
        case 1:
          showMenu();
          break;
        case 2:
          doEmpLogin();
          break;
        case 3:
          doVenLogin();
          break;
        case 4:
          Runtime.getRuntime().halt(0);
        default:
          System.out.println("Choose between 1 - 4");
      }
    } catch (Exception e) {
      e.printStackTrace();
      System.out.println("Enter a valid value");
    }
    option.nextLine();
    mainMenu();
  }

  /**
   * showFullMenu method display the menu item stored in database.
   */
  private void showMenu() {
    Menu[] mnu = MenuFactory.showMenu();
    System.out.println("Menu_Id \t Food_Name \t Food_Price");
    System.out.println("----------------------------------------------");
    for (Menu m : mnu) {
      System.out.println(m.getFoodId() + "\t\t" + m.getfdName() + "\t\t" + m.getfdPrice());
    }
  }
  private void doEmpLogin() {
    System.out.println("Enter Employee ID and Password");
    int eId = option.nextInt();
    String ePassword = option.next();
    Employee emp = EmployeeFactory.empValidate(eId, ePassword);
    if (emp != null) {
      empMenu(eId);
    } else {
      System.out.println("Please enter a valid Employee Id and Password");
    }
  }

  private void empMenu(final int eId) {
    System.out.println("Employee Page");
    System.out.println("-----------------------");
    System.out.println("1.Wallet ");
    System.out.println("2.Order History");
    System.out.println("3.Place Order");
    System.out.println("4.Exit");
    empMenuDetails(eId);
  }

  /**
   * mainMenuDetails method process the option selected from main menu.
   */
  private void empMenuDetails(final int eId) {
    try {
      System.out.println("Enter your choice:");
      int empOption = option.nextInt();
      switch (empOption) {
        case 1:
          showWallet(eId);
          break;
        case 2:
          showOrdersForCustomers(eId);
          break;
        case 3:
          placeOrder(eId);
          break;
        case 4:
          mainMenu();
        default:
          System.out.println("Choose between 1 - 4 ");
      }
    } catch (Exception e) {
      e.printStackTrace();
      System.out.println("Enter a valid value");
    }
    option.nextLine();
    empMenu(eId);
  }
  private void showWallet(final int eId) {
    Employee emp = EmployeeFactory.showEmpWalletBalance(eId);
    System.out.println("Your wallet balance is " + emp.getwalletBalance());
    empMenu(eId);
  }
  private void showOrdersForCustomers(final int a) {
    Orders[] emp = OrdersFactory.employeeorderhistory(a);
    System.out.println("OrderId \t FoodID \t Quantity \t Amount \t Status");
    for (Orders o :emp) {
      System.out.println(o.getordId() + "\t\t" + o.getfdId() + "\t\t" + o.getordQuant() + "\t\t" + o.getordAmnt() + "\t\t" + o.getordStatus());
    }
  }
  private void placeOrder(final int eId) {
    showFullMenu(eId);
  }
  private void showFullMenu(final int eId) {
    Menu[] mnu = MenuFactory.showMenu();
    System.out.println("Menu_Id \t Food_Name \t Food_Price");
    System.out.println("_________ \t _________ \t _________");
    for (Menu m : mnu) {
      System.out.println(m.getFoodId() + "\t\t" + m.getfdName() + "\t\t" + m.getfdPrice());
    }
    System.out.println("Enter Food Id ");
    int foodIdGet = option.nextInt();
    Menu mVal = MenuFactory.validateGivenFoodId(foodIdGet);
    int fdid = mVal.getFoodId();
    if (mVal == null) {
      System.out.println("Invalid menu item");
      showFullMenu(eId);
    } else {
      System.out.println("Enter the Quantity");
      int qty = option.nextInt();
      if (qty <= 0) {
        System.out.println("Invalid Quantity");
        empMenu(eId);
      } else {
        int price = mVal.getfdPrice();
        int tamnt = price * qty;
        System.out.println(tamnt);
        Employee emp = EmployeeFactory.showEmpWalletBalance(eId);
        int empBal = emp.getwalletBalance();
        if (empBal >= tamnt) {
          String ordstat = "Placed";
          String ordmsg = "Order placed Successfully!";
          OrdersFactory.insertord(eId, fdid, qty, tamnt, ordstat, ordmsg);
          deductEmpWal(eId, tamnt);
        } else {
          System.out.println("Insufficient Wallet Balance!");
          empMenu(eId);
        }
      }
    }
  }
  //Vendor login function
  private void doVenLogin() {
    System.out.println("Enter Vendor ID and Password");
    int vId = option.nextInt();
    String vPassword = option.next();
    Vendor ven = VendorFactory.venValidate(vId, vPassword);
    if (ven == null) {
      System.out.println("Wrong User Name and Password!!");
    } else {
      vensubMenu(ven.getvenId());
    }
  }
  private void vensubMenu(final int venId) {
    System.out.println("Vendor's Nest");
    System.out.println("-----------------------");
    System.out.println("1. Status");
    System.out.println("2. View Order History");
    System.out.println("3. Wallet");
    System.out.println("4. Exit");
    submenuDetails(venId);
  }
  private void submenuDetails(final int venId) {
    try {
      System.out.println("Enter your choice:");
      int menuOption = option.nextInt();
      switch (menuOption) {
        case 1:
          status(venId);
          break;
        case 2:
          vendororderhistory(venId);
          break;
        case 3:
          showVenBal(venId);
          break;
        case 4:
          mainMenu();
          break;
        default:
          System.out.println("Choose between 1 - 4");
      }
    } catch (Exception e) {
      e.printStackTrace();
      System.out.println("Enter a valid value");
    }
    option.nextLine();
    mainMenu();
  }
  private void status(final int vid) {
    System.out.println("1.Accept Order");
    System.out.println("2.Reject Order");
    statuscheck(vid);
  }
  private void statuscheck(final int vid) {
    try {
      System.out.println("Enter your choice:");
      int x = option.nextInt();
      switch (x) {
        case 1:
          statusaccept(vid);
          break;
        case 2:
          statusreject(vid);
          break;
        default:
          System.out.println("Choose either 1 or 2");
      }
    } catch (Exception e) {
      e.printStackTrace();
      System.out.println("Enter a valid value");
    }
  }
  private void placedOrders(final int vid) {
    Orders[] ord = OrdersFactory.getplacedOrders(vid);
    System.out.println("Placed orders: ");
    System.out.println("-----------------------");
    System.out.println("OrderId \t FoodId \t OrderStatus");
    for (Orders o : ord) {
      System.out.println(o.getordId() + "\t\t" + o.getfdId() + "\t\t" + o.getordStatus());
    }
  }
  /**
   * accepting the order status.
   * @param vid vendorid.
   * @return whether the order is accepted or not.
   */
  public int statusaccept(final int vid) {
    placedOrders(vid);
    System.out.println("Enter order ID:");
    int ordid = option.nextInt();
    int val = OrdersFactory.acceptOrder(ordid);
    System.out.println("Order Accepted!");
    System.out.println("Success value is : " + val);
    addVenWal(ordid);
    return val;
  }
  //deducting and update amnt from emp wallet
  /**
   * deducting employee wallet.
   * @param eId employee id.
   * @param tamnt total amount.
   */
  public void deductEmpWal(final int eId, final int tamnt) {
    Employee emp = EmployeeFactory.showEmpWalletBalance(eId);
    String eName = emp.getEmpName();
    int deductedBal = emp.getwalletBalance() - tamnt;
    System.out.println("Deducted amount is : " + tamnt);
    int val = EmployeeFactory.updateWalletGivenEmpId(eId, deductedBal);
    if (val == 1) {
      System.out.println("Your transaction is Successful....");
      System.out.println("Dear customer : " + eName  + "\n" + "Your wallet is debited for Rs: "
                      + tamnt + "\n");
      Employee empup = EmployeeFactory.showEmpWalletBalance(eId);
      System.out.println("Your current wallet balance is: " + empup.getwalletBalance());
      empMenu(eId);
    } else {
      System.out.println("Transaction failed...!");
    }
  }
  /**
   * add vendor wallet.
   * @param ordid order id.
   */
  public void addVenWal(final int ordid) {
    Orders ord = OrdersFactory.showOrderAmount(ordid);
    int fid = ord.getfdId();
    int ordTamt = ord.getordAmnt();
    Menu menu = MenuFactory.validateGivenFoodId(fid);
    int venId = menu.getvenId();
    Vendor ven = VendorFactory.showVenWalletBalance(venId);
    int addedBal = ven.getvenWbal() + ordTamt;
    String venName = ven.getvenName();
    int val1 = VendorFactory.updateWalletGivenVenId(venId, addedBal);
    System.out.println("val " + val1);
    if (val1 == 1) {
      System.out.println("Your transaction is Successful....");
      System.out.println("Dear Vendor : " + venName + "\n" + "Your wallet is credited for Rs: "
                      + ordTamt + "\n");
      Vendor ven1 = VendorFactory.showVenWalletBalance(venId);
      System.out.println("Your current wallet balance is: " + ven1.getvenWbal());
      vensubMenu(venId);
    } else {
      System.out.println("Transaction failed...!");
    }
  }
  /**
   * show vendor balance.
   * @param venId vendor id.
   */
  public void showVenBal(final int venId) {
    Vendor ven = VendorFactory.showVenWalletBalance(venId);
    int updBal = ven.getvenWbal();
    System.out.println("Current balance is:" + updBal);
  }
  /**
   * Rejecting orders.
   * @param vid vendor id.
   * @return value.
   */
  int statusreject(final int vid) {
    placedOrders(vid);
    System.out.println("Enter order ID:");
    int ordid = option.nextInt();
    int val = OrdersFactory.rejectOrder(ordid);
    System.out.println("Order Cancelled!");
    System.out.println("Success value is : " + val);
    onCancelWallet(ordid);
    return val;
  }
  /**
   * Refund to employee.
   * @param ordid order id.
   */
  public void onCancelWallet(final int ordid) {
    Orders ord = OrdersFactory.showOrderAmount(ordid);
    int ordTamt = ord.getordAmnt();
    int eId = ord.getempId();
    int fId = ord.getfdId();
    Employee emp = EmployeeFactory.showEmpWalletBalance(eId);
    int addedBal = emp.getwalletBalance() + ordTamt;
    System.out.println("Added amount is : " + ordTamt);
    int val = EmployeeFactory.updateWalletGivenEmpId(eId, addedBal);
    System.out.println(val);
    Menu menu = MenuFactory.validateGivenFoodId(fId);
    int venId = menu.getvenId();
    Vendor ven1 = VendorFactory.showVenWalletBalance(venId);
    System.out.println("Your current wallet balance is: " + ven1.getvenWbal());
    vensubMenu(venId);
    //showVenBal(vid);
  }
  /**
   * vendor history.
   * @param b vendorid.
   */
  private void vendororderhistory(final int b) {
    Orders[] ven = OrdersFactory.vendororderhistory(b);
    System.out.println("OrderId \t FoodID \t Quantity \t Amount \t Status");
    for (Orders o : ven) {
      System.out.println(o.getordId() + "\t\t" + o.getfdId() + "\t\t" + o.getordQuant() + "\t\t" + o.getordAmnt() + "\t\t" + o.getordStatus());
    }
  }
   /** main method is the basic entry point for the application.
   * @param args used to get the user input.
   */
  public static void main(final String[] args) {
    final CliMain mainObj = new CliMain();
    mainObj.mainMenu();
  }
}
