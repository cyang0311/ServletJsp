package Dao;

import Pojo.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao{
    @Override
    public User checkUserLoginDao(String uname, String pwd) {
        Connection conn = JDBCUtil.getMySQLConnect();
        PreparedStatement ps = null;
        ResultSet rs = null;
        User u = null;

        try {
            String sql = "select * from user where uname=? and pwd=?";
            ps = conn.prepareStatement(sql);
            ps.setObject(1,uname);
            ps.setObject(2,pwd);

            rs = ps.executeQuery();

            while (rs.next()){
                u = new User();
                u.setId(rs.getInt("id"));
                u.setUname(rs.getString("uname"));
                u.setPwd(rs.getString("pwd"));
                u.setSex(rs.getString("sex"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.stop(rs,ps,conn);
        }

        return u;
    }
}
