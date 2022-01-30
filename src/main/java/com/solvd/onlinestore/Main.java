package com.solvd.onlinestore;

import com.solvd.onlinestore.dao.jdbcmySQLImpl.*;
import com.solvd.onlinestore.model.checkout.CheckoutCart;
import com.solvd.onlinestore.model.checkout.ItemsInCart;
import com.solvd.onlinestore.model.labor.Departments;
import com.solvd.onlinestore.model.labor.Employees;
import com.solvd.onlinestore.model.labor.Jobs;
import com.solvd.onlinestore.model.location.Address;
import com.solvd.onlinestore.model.location.City;
import com.solvd.onlinestore.model.location.Country;
import com.solvd.onlinestore.model.location.State;
import com.solvd.onlinestore.model.product.*;
import com.solvd.onlinestore.model.purchase.Order;
import com.solvd.onlinestore.model.purchase.OrderItem;
import com.solvd.onlinestore.model.purchase.Transaction;
import com.solvd.onlinestore.model.user.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    private static final Logger LOGGER = LogManager.getLogger(Main.class);
    private static final String USER_XML_FILE = "src/main/resources/xmlFiles/entityXMLS/user.xml";
    private static final String USER_JSON_FILE = "src/main/java/com/solvd/onlineshop/model/user/User.java";




    public static void main(String[] args) throws Exception {

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://52.59.193.212:3306/onlinestoredb", "root", "devintern");
            /*------------------------------------------------------------------------ */
            EmployeesDao employeesDao = new EmployeesDao(connection);
            Employees employees = employeesDao.findById(2);
            LOGGER.info(employees.getId());
            /*------------------------------------------------------------------------ */
            ProductCategoryDao productCategoryDao = new ProductCategoryDao(connection);
            ProductCategory productCategory = productCategoryDao.findById(1);
            LOGGER.info(productCategory.getId());
            /*------------------------------------------------------------------------ */
            CityDao cityDao = new CityDao(connection);
            City city = cityDao.findById(1);
            LOGGER.info(city.getId());
            /*------------------------------------------------------------------------ */
            CheckoutCartDao checkoutCartDao = new CheckoutCartDao(connection);
            CheckoutCart checkoutCart = checkoutCartDao.findById(1);
            System.out.println(checkoutCart.getId());
            /*------------------------------------------------------------------------ */
            AddressDao addressDao = new AddressDao(connection);
            Address address = addressDao.findById(1);
            LOGGER.info(address.getId());
            /*------------------------------------------------------------------------ */
            CountryDao countryDao = new CountryDao(connection);
            Country country = countryDao.findById(1);
            LOGGER.info(country.getId());
            /*------------------------------------------------------------------------ */
            DepartmentsDao departmentsDao = new DepartmentsDao(connection);
            Departments departments = departmentsDao.findById(1);
            LOGGER.info(departments.getId());
            /*------------------------------------------------------------------------ */
            InventoryDao inventoryDao = new InventoryDao(connection);
            Inventory inventory = inventoryDao.findById(1);
            LOGGER.info(inventory.getId());
            /*------------------------------------------------------------------------ */
            ItemsInCartDao itemsInCartDao = new ItemsInCartDao(connection);
            ItemsInCart itemsInCart = itemsInCartDao.findById(1);
            LOGGER.info(itemsInCart.getId());
            /*------------------------------------------------------------------------ */
            JobsDao jobsDao = new JobsDao(connection);
            Jobs jobs = jobsDao.findById(1);
            LOGGER.info(jobs.getId());
            /*------------------------------------------------------------------------ */
            OrderDao orderDao = new OrderDao(connection);
            Order order = orderDao.findById(1);
            LOGGER.info(order.getId());
            //check the manual that corresponds to your MySQL server version for the right syntax to use near 'order WHERE id = 1' at line 1
            /*------------------------------------------------------------------------ */
            OrderItemDao orderItemDao = new OrderItemDao(connection);
            OrderItem orderItem = orderItemDao.findById(1);
            LOGGER.info(orderItem.getId());
            /*------------------------------------------------------------------------ */
            ProductDao productDao = new ProductDao(connection);
            Product product = productDao.findById(1);
            LOGGER.info(product.getId());
            /*------------------------------------------------------------------------ */
            ProductReviewDao productReviewDao = new ProductReviewDao(connection);
            ProductReview productReview = productReviewDao.findById(1);
            LOGGER.info(productReview.getId());
            /*------------------------------------------------------------------------ */
            ProductSupplierDao productSupplierDao = new ProductSupplierDao(connection);
            ProductSupplier productSupplier = productSupplierDao.findById(1);
            LOGGER.info(productSupplier.getId());
            /*------------------------------------------------------------------------ */
            StateDao stateDao = new StateDao(connection);
            State state = stateDao.findById(1);
            LOGGER.info(state.getId());
            /*------------------------------------------------------------------------ */
            TransactionDao transactionDao = new TransactionDao(connection);
            Transaction transaction = transactionDao.findById(1);
            LOGGER.info(transaction.getId());
            /*------------------------------------------------------------------------ */
            UserDao userDao = new UserDao(connection);
            User user = userDao.findById(1);
            LOGGER.info(user.getId());
        } catch (SQLException e) {
            LOGGER.error(e);
        }
    }
}
