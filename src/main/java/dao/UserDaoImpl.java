
package dao;

import model.User;
import DBcontroller.DB;

import java.sql.*;

public class UserDaoImpl implements UserDao {
    Connection conn;
    PreparedStatement ps;
    ResultSet rs;

    @Override
    public User get(String username) {
        String sql = "SELECT * FROM users WHERE username = ?";
        try {
            conn = DB.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            rs = ps.executeQuery();
            if (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setEmail(rs.getString("email"));
                user.setUserName(rs.getString("username"));
                user.setFullName(rs.getString("fullname"));
                user.setPassWord(rs.getString("password"));
                user.setRoleid(rs.getInt("roleid"));
                user.setPhone(rs.getString("phone"));
                user.setCreatedDate(rs.getDate("createdDate"));
                return user;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
