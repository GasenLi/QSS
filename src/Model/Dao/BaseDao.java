package Model.Dao;

import Model.DB.JdbcPool;

import java.sql.ResultSet;

/**
 * Dao类:封装了数据库操作的方法
 * @author Administrator
 */
public class BaseDao {
    private static JdbcPool jdbcPool = new JdbcPool();

    //添加
    public static ResultSet addObj(Object obj, String value) {
        String sql = SQL.addObj(obj, value);
        ResultSet result = JdbcPool.executeDB(jdbcPool,sql,"execute");

        return result;
    }

    //删除
    public static ResultSet deleteObj(Object obj, String conditionFieldName, String conditionValue) {
        String sql = SQL.deleteObj(obj, conditionFieldName, conditionValue);
        ResultSet result = JdbcPool.executeDB(jdbcPool,sql,"execute");

        return result;
    }

    //查询
    public static ResultSet queryObj(Object obj, String targetFieldName, String conditionFieldName, String conditionValue) {//有条件查询
        String sql = SQL.queryObj(obj, targetFieldName, conditionFieldName, conditionValue);
        ResultSet result = JdbcPool.executeDB(jdbcPool,sql,"executeQuery");

        return result;
    }

    public static ResultSet queryObj(Object obj, String targetFieldName) {//无条件查询
        String sql = SQL.queryObj(obj, targetFieldName);
        ResultSet result = JdbcPool.executeDB(jdbcPool,sql,"executeQuery");

        return result;
    }

    //更新
    public static ResultSet updateObj(Object obj, String targetFieldName, String targetValue, String conditionFieldName, String conditionValue) {
        String sql = SQL.updateObj(obj, targetFieldName, targetValue, conditionFieldName, conditionValue);
        ResultSet result = JdbcPool.executeDB(jdbcPool,sql,"execute");

        return result;
    }
}













