package Controller.Service;

import Model.Dao.BaseDao;
import Model.Dao.Column;
import Model.Dao.SQL;
import Model.Entity.Questionnaire.Questionnaire;
import Model.Entity.Result.Result;
import Model.Util.ClassUtil;
import Model.Util.Util;
import net.sf.json.JSONArray;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;

import java.io.IOException;
import java.lang.reflect.Field;
import java.net.URISyntaxException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class QuestionnaireService {

    //查询指定问卷结的结果
    public static JSONArray queryAssignResult(String targetQstnrName) throws ClassNotFoundException, IOException, InstantiationException, IllegalAccessException, URISyntaxException, SQLException {
        Class targetClass = Util.getClassByChineseDescribe(targetQstnrName, Result.class);
        ResultSet resultSet = BaseDao.queryObj(targetClass.newInstance(), "*");

        JSONArray jsonArray = resultToJson(resultSet, targetClass);

        return jsonArray;
    }

    //用户提交问卷
    public static void submitQstnr(String targetQstnrName, String IP, String time, JSONObject result) throws URISyntaxException, IOException, ClassNotFoundException, IllegalAccessException, InstantiationException, JSONException {
        Class targetClass = Util.getClassByChineseDescribe(targetQstnrName, Result.class);
        String value = "'" + IP + "', '" + time + "'";

        Field[] fields = targetClass.getDeclaredFields();
        for (Field field : fields) {
            String des = field.getAnnotation(Column.class).columnName();
            System.out.println(des);
            value += ", '" + result.get(des) + "'";
        }

        System.out.println(value);
        BaseDao.addObj(targetClass.newInstance(), value);

    }

    //查询所有问卷的名字
    public static ArrayList<String> queryAllQstnrTitles() throws URISyntaxException, IOException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        ArrayList<String> describes = new ArrayList<>();

        for (Class<?> clazz : ClassUtil.getAllAssignedClass(Questionnaire.class)) {
            describes.add(SQL.getChineseDescribe(clazz.newInstance()));
        }

        return describes;
    }


    //查询指定问卷的所有内容
    public static JSONArray queryAssignQstnr(String targetQstnrName) throws URISyntaxException, IOException, ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException, JSONException {
        Class targetClass = Util.getClassByChineseDescribe(targetQstnrName, Questionnaire.class);
        ResultSet resultSet = BaseDao.queryObj(targetClass.newInstance(), "*");

        JSONArray jsonArray = resultToJson(resultSet, targetClass);

        return jsonArray;
    }


    public static JSONArray resultToJson(ResultSet resultSet, Class targetClass) throws SQLException, JSONException {              //将结果转换为JSON格式
        ArrayList<String> fieldNames = new ArrayList<>();
        JSONObject jsonObject;
        JSONArray jsonArray = new JSONArray();

        for (Field field : targetClass.getDeclaredFields()) {                                  //找出子类的所有属性名
            fieldNames.add(field.getAnnotation(Column.class).columnName());
        }

        for (Field field : targetClass.getSuperclass().getDeclaredFields()) {                  //找出父类的所有属性名
            fieldNames.add(field.getAnnotation(Column.class).columnName());
        }

        while (resultSet.next()) {
            jsonObject = new JSONObject();

            for (String fieldName : fieldNames) {
                System.out.println(resultSet.getString(fieldName));
                jsonObject.put(fieldName, resultSet.getString(fieldName));
            }

            jsonArray.add(jsonObject);
        }

        return jsonArray;
    }
}
