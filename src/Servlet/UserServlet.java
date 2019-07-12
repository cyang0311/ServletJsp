package Servlet;
import Pojo.User;
import Service.UserService;
import Service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.http.HttpResponse;

@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet{
    UserService us = new UserServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //请求编码格式
        req.setCharacterEncoding("utf-8");
        //响应编码格式
        resp.setContentType("text/html;charset=utf-8");

        //获取操作符
        String oper = req.getParameter("oper");
        if ("login".equals(oper)){
            checkUserLogin(req,resp);
        }else if ("reg".equals(oper)){

        }
    }

    //处理登录
    private void checkUserLogin(HttpServletRequest req, HttpServletResponse resp){
        String uname = req.getParameter("uname");
        String pwd = req.getParameter("pwd");

        User u = us.checkUserLoginService(uname,pwd);
        if (u!=null){
            HttpSession session = req.getSession();
            session.setAttribute("user",u);
            try {
                resp.sendRedirect("index.jsp");
                System.out.println(u.getUname()+"  "+u.getPwd());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {
            try {
                resp.sendRedirect("index.jsp");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
