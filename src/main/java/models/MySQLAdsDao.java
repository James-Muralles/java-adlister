package models;

import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLAdsDao implements Ads {
    //set up DB connection
    private Connection conn;

    public MySQLAdsDao() throws SQLException {
        //instantiate Config object
        Config config = new Config();

//set up DB driver and make a connection
        DriverManager.registerDriver(new Driver());

        //get a connection object
        this.conn = DriverManager.getConnection(
                config.getUrl(),
                config.getUsername(),
                config.getPassword()
        );//this makes a connection to the mysql database

    }

    @Override
    public List<Ad> all() {
        List<Ad> output = new ArrayList<>();

        //query the DB ads
        String query = "SELECT * FROM ads";

        //sql exception needs to be handled

        try {
            //create a statement object
            Statement stat = conn.createStatement();
            ResultSet rs = stat.executeQuery(query);

            //iterate through rs and add each add to our 'Ad' bean

            while(rs.next()) {
                output.add(
                        new Ad(
                                rs.getLong("id"),
                                rs.getLong("user_id"),
                                rs.getString("title"),
                                rs.getString("description")
                        )
                );
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return output;

    }

    // insert a new ad and return the new ad's id
    @Override
    public Long insert(Ad ad){
        long newUserId = 0;

        String insertNewAddQuery = String.format("INSERT INTO ads (user_id, title, description) VALUES ('%d','%s','%s')",
                ad.getUserId(),
                ad.getTitle(),
                ad.getDescription());

        try {
            Statement stat = conn.createStatement();

            stat.executeUpdate(insertNewAddQuery, Statement.RETURN_GENERATED_KEYS);

            ResultSet ks = stat.getGeneratedKeys();
            if(ks.next()){
                newUserId = ks.getLong(1);
            }
            if (newUserId != 0){
                ad.setId(newUserId);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }

        return newUserId;

    }


}
