package models;

public class Config {
    //host for mysql
    public String getUrl() {
        return "jdbc:mysql://localhost/contacts_db?serverTimezone=UTC&useSSL=false";
    }



//mysql username

    public String getUsername() {
        return "root";
    }

    //mysql password

    public String getPassword() {
        return "codeup";
    }
}
