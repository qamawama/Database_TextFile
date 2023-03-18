import java.sql.*;
import java.util.*;
public class Database {

    // Database attributes
    private static String driver = "com.mysql.cj.jdbc.Driver";
    private String url;
    private String portNum;
    private String dbName;
    private String username;
    private String password;
    private Connection con;

    // Database constructor
    public Database(String url, String portNum, String dbName, String username, String password){
        this.url = url;
        this.portNum = portNum;
        this.dbName = dbName;
        this.username = username;
        this.password = password;
    }

    // Method: connect database
    public void connect(){
        try{
            Class.forName(driver);
            this.con = DriverManager.getConnection("jdbc:mysql://" + this.url + ":" + this.portNum + "/" + this.dbName, this.username, this.password);
        } catch (Exception e){      //"jdbc:mysql://db4free.net:3306/dawnsdatabase","username","password"
            System.out.println(e);
        }
    }

    // Method: run query
    public void runQuery(String statement){
        String sqlStatement = statement;
        try {
            Statement statementObj = con.createStatement();
            ResultSet resultSet = statementObj.executeQuery(sqlStatement);
            while (resultSet.next()){
                System.out.println(resultSet.getString("name"));
                System.out.println(resultSet.getString("ic"));
            }
        } catch (Exception e){
            System.out.println(e);
        }
    }

    // Method: close connection
    public void close(){
        try{
            con.close();
        } catch (Exception e){
            System.out.println(e);
        }
    }
}
