package Controller.Servlet;

import Controller.Service.QuestionnaireService;
import net.sf.json.JSONArray;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;


@WebServlet("/QuestionnaireServlet")
public class QuestionnaireServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码格式
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        //数据初始化
        String get = request.getParameter("get");
        PrintWriter out = response.getWriter();

        if (get.equals("queryAllQstnrTitles")) {
            int i = 0;
            JSONObject responseJson = new JSONObject();
            String responseKey = "";
            String responseValue = "";

            try {
                for (String describe : QuestionnaireService.queryAllQstnrTitles()) {
                    responseKey = "describes" + i;
                    responseValue = describe;
                    responseJson.put(responseKey, responseValue);

                    i++;
                }
            } catch (URISyntaxException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }

            out.println(responseJson);

        } else if (get.equals("queryAssignQstnr")) {
            String targetQstnrName = request.getParameter("name");
            JSONArray jsonArray = null;

            try {
                jsonArray = QuestionnaireService.queryAssignQstnr(targetQstnrName);
            } catch (URISyntaxException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }

            out.println(jsonArray);
        }else if (get.equals("submitQstnr")) {
            String targetQstnrName = request.getParameter("name");
            String IP = request.getParameter("IP");
            String time = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
            String s = request.getParameter("result");
            JSONObject result = JSONObject.fromObject( request.getParameter("result"));

            try {
                QuestionnaireService.submitQstnr(targetQstnrName, IP, time, result);
            } catch (URISyntaxException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            }

            JSONObject info = new JSONObject();
            info.put("info","success");
            out.println(info);
        }else if (get.equals("queryAssignResult")) {
            String targetQstnrName = request.getParameter("name");

            JSONArray jsonArray = null;

            try {
                jsonArray = QuestionnaireService.queryAssignResult(targetQstnrName);
            } catch (URISyntaxException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }

            out.println(jsonArray);
        }

    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
