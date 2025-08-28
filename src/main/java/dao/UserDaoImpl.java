package dao;

import model.User;
import DBcontroller.DB;

import java.sql.*;

public class UserDaoImpl implements UserDao {
    Connection conn;
    PreparedStatement ps;
    ResultSet rs;

    @Override
    public User login(String username, String password) {
        String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
        try {
            conn = DB.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            rs = ps.executeQuery();
            if (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setUserName(rs.getString("username"));
                user.setPassWord(rs.getString("password"));
                user.setFullName(rs.getString("fullname"));
                user.setEmail(rs.getString("email"));
                user.setRoleid(rs.getInt("roleid"));
                return user;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try { if(rs != null) rs.close(); } catch(Exception ignored) {}
            try { if(ps != null) ps.close(); } catch(Exception ignored) {}
            try { if(conn != null) conn.close(); } catch(Exception ignored) {}
        }
        return null;
    }
}
