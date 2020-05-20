package jdbc;

import java.sql.*;

public class JdbcTest {
    public static void main(String[] args) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");//加载驱动
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Mybatis?useSSL=false","root","123456");//获取连接
            preparedStatement =connection.prepareStatement("select * from tb_user");//
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                System.out.println(resultSet.getString("user_name"));

            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(resultSet!=null)
                resultSet.close();
            if(preparedStatement!=null)
                preparedStatement.close();
            if(connection!=null)
                connection.close();
        }

    }
}
