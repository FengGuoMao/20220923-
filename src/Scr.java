package src;//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.sql.*;
public class Scr {
    String databaseName = "easyv";
    String user = "easyusr";
    String pwd = "sxV5@Ha666";
    String URL;
    String DRIVER;

    String query;
    String query2;

    public Scr() {
        this.URL = "jdbc:mysql://10.86.146.115:3306/" + this.databaseName + "?useSSL=false&serverTimezone=UTC";
        this.DRIVER = "com.mysql.cj.jdbc.Driver";
    }
    //获取sql的值
    public void setquery(String src){
        query = src;
    }
    public String getquery(){
        return  query;
    }
    public static void main(String[] args) {
        Scr JdbcDemo = new Scr();
        JdbcDemo.connect();
    }
    public void connect() {
        Connection connection = null;
        Statement statement = null;
        try {
            Class.forName(this.DRIVER);
            connection = DriverManager.getConnection(this.URL, this.user, this.pwd);
            statement = connection.createStatement();
            System.out.println("sql连接成功，开始执行sql");
//            String query = "SELECT * from test1;";
            int resultSet2 = statement.executeUpdate(getquery2());
            ResultSet resultSet = statement.executeQuery(getquery());
            System.out.println("sql执行成功，开始读写实体类....");
            while(resultSet.next()) {
                String id_p = resultSet.getString("id_p");
                String LastName = resultSet.getString("LastName");
                String FirstName = resultSet.getString("FirstName");
                System.out.println("id_p: " + id_p +",LastName: " + LastName + ",FirstName: " + FirstName);
            }
            resultSet.close();
            System.out.println("连接关闭中...，");
            statement.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException var16) {
            var16.printStackTrace();
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException var15) {
                var15.printStackTrace();
            }
        }
    }
    public void setquery2(String src){
        query2 = src;
    }
    private String getquery2() {
        return query2;
    }
}
