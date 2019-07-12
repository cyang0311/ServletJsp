package Servlet;

import Dao.UserDaoImpl;
import Pojo.User;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/UserServlet2")
public class UserServlet2 extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        doPost(req,response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        String uname = req.getParameter("uname");
        String pwd = req.getParameter("pwd");

        UserDaoImpl userDao = new UserDaoImpl();
        User user = userDao.checkUserLoginDao(uname,pwd);

        if (user!=null){
            HttpSession session = req.getSession();
            session.setAttribute("user",user);

            response.sendRedirect("index.jsp");
            System.out.println(user.getUname()+"  "+user.getPwd());
        }else {
            response.sendRedirect("index.jsp");
        }
    }
}
