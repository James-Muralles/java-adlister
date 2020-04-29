package models;

//import java.sql.Driver;
import java.sql.*;

import com.mysql.cj.jdbc.Driver;

public class JDBCLecture {
    public static void main(String[] args) throws SQLException{
//set up our database driver, and make a connection
        DriverManager.registerDriver(new Driver());

        //instantiate a config object
        Config config = new Config();

        //get connection object
        Connection conn = DriverManager.getConnection(
                config.getUrl(),
                config.getUsername(),
                config.getPassword()
        );// we now have a connection to our mysql DB

        //****create a statement object****
        Statement stat = conn.createStatement();

        //****execute some sort of query****
        //create a query string to get everything in the contacts table
        String contactsQuery = "SELECT * FROM contacts";

        ResultSet rs = stat.executeQuery(contactsQuery);

        while(rs.next()){
        //display everything in the result set (rs) above
        System.out.println(rs.getString("first_name") + " " + rs.getString("last_name") + " " + rs.getString("phone_number"));
        }

        //if we want to add a row  to our database we'll
        //1: create a contact object (bean)
        //3: to add to our Dao - instantiate ContactListDao and use the saveContact() method
        //2: create a sql query  to insert that contact object into out database as a new row

        Contacts clDao = DaoFactory.getContactsDao();

        //instantiate a new contact object
        Contact casey = new Contact("Casey", "Friday", "2105557777");

        long newContactId = clDao.saveContact(casey);
Contact newlyCreatedContact = clDao.getContactById(newContactId);
        //using SQL this is how to insert---> INSERT INTO contacts (first_name, last_name, phone_number) VALUES ('casey', 'friday', '2105557777');

        String addContactQuery = String.format("INSERT contacts SET first_name, last_name, phone_number) VALUES (%s, %s, %s)",
               newlyCreatedContact.getFirstName(),
               newlyCreatedContact.getLastName(),
               newlyCreatedContact.getPhoneNumber(),
                newlyCreatedContact.getId()
        );

        System.out.println("this is the query string we'll be sending to MYSQL:\n");
        System.out.println(addContactQuery);

//now lets execute this SQL query to add a new contact to our DB
int numRows = stat.executeUpdate(addContactQuery);
        System.out.println("number of rows affected:" + numRows);
    }
}
