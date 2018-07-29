import Controller.Service.QuestionnaireService;
import Controller.Servlet.QuestionnaireServlet;
import Model.Dao.BaseDao;
import Model.Entity.Person;
import Model.DB.JdbcPool;
import net.sf.json.JSONArray;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;


import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ORMtest {
    private static JdbcPool jdbcPool = new JdbcPool();

    public static void main(String[] args) throws ClassNotFoundException, IOException, InstantiationException, IllegalAccessException, URISyntaxException {
//        Person person = new Person();

      //String sql = BaseDao.updateObj(person, "personName", "小明","personID", "111");
      //String sql = BaseDao.addObj(person, "'114', 'ABC','2018-05-09',2");
      //String sql = BaseDao.deleteObj(person, "personID", "114");

       // ResultSet result = BaseDao.queryObj(person, "password", "personID", "111");

//        try {
//            while(result.next()){
//                String id = result.getString("personID");
//                String name = result.getString("personName");
//                String password = result.getString("password");
//                System.out.println(password);
//                Date date = result.getDate("birthday");
//                int sex = result.getInt("sex");
//                System.out.println("id:"+id+" 姓名："+name+" 性别："+sex +" 时间："+date);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

//        try {
//            QuestionnaireService.queryAllQstnrTitles();
//        } catch (URISyntaxException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (InstantiationException e) {
//            e.printStackTrace();
//        }
////
        String targetQstnrName ="环境调查表";
        JSONArray jsonArray = null;
        try {
            jsonArray = QuestionnaireService.queryAssignQstnr(targetQstnrName);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (IOException e) {
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
//
        System.out.println(jsonArray);

//        String targetQstnrName = "环境调查结果";
//        String IP = "192.168.1.1";
//        String time ="2018-01-02";
//        String st = "{'10000':'A','10001':'B','10002':'D','10003':'C','10004':'A','10005':'A','10006':'A'}";
//        JSONObject result = JSONObject.fromObject(st);
//        QuestionnaireService.submitQstnr(targetQstnrName, IP, time, result);
    }
}
