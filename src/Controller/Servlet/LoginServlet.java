package Controller.Servlet;

import Controller.Service.UserService;
import Model.Entity.Person;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet{
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码格式
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        //数据初始化
        String personID = request.getParameter("personID");
        String password = request.getParameter("password");
        JSONObject responseJson=new JSONObject();
        String responseKey = "info";
        String responseValue = "";


        //空值验证
        if(personID==null || "".equals(personID)){
            responseValue = "nameNull";
        }else if(password==null || "".equals(password)){
            responseValue = "passwordNull";
        }else{
        //密码验证
            Person person = new Person();
            person.setPersonID(personID);
            person.setPassword(password);

            try{
                UserService userService= new UserService();
                if(userService.findLogin(person)){
                    request.getSession();
                    responseValue = "loginSuccess";
                }else {
                    responseValue = "loginFailed";
            }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        //向前台的页面输出结果
        PrintWriter out=response.getWriter();
        try {
            responseJson.put(responseKey,responseValue);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        out.println(responseJson);
}

    public void doPost(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException{
        this.doGet(req,resp) ;
    }
}
