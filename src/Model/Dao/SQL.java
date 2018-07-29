package Model.Dao;

import java.lang.reflect.Field;

public class SQL {

    public static String getTableName(Object obj) {
        Table table = obj.getClass().getAnnotation(Table.class);
        String tableName = table.tableName();

        return tableName;
    }

    public static String getChineseDescribe(Object obj) {
        Table table = obj.getClass().getAnnotation(Table.class);
        String ChineseDescribe = table.ChineseDescribe();

        return ChineseDescribe;
    }

    public static String getColumn(Object obj, String fieldName) {
        String column = null;
        Field field = null;

        if (fieldName == "*") {
            column = "*";
        } else {
            try {
                field= obj.getClass().getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                try {
                    field= obj.getClass().getSuperclass().getDeclaredField(fieldName);
                } catch (NoSuchFieldException e1) {
                    e1.printStackTrace();
                }
            }

            column = field.getAnnotation(Column.class).columnName();
        }

        return column;
    }

    //添加
    public static String addObj(Object obj, String value) {
        String tableName = getTableName(obj);

        String sql = "insert into " + tableName + " values(" + value + ");";
        return sql;
    }

    //删除
    public static  String deleteObj(Object obj, String conditionFieldName, String conditionValue) {
        String tableName = getTableName(obj);                                                    //获得表名
        String conditionColumn = getColumn(obj, conditionFieldName);                             //获得目标列名

        String sql = "delete from " + tableName + " where " + conditionColumn + " = '" + conditionValue + "'";

        return sql;
    }

    //查询
    public static String queryObj(Object obj, String targetFieldName, String conditionFieldName, String conditionValue) {//有条件查询
        String tableName = getTableName(obj);
        String targetColumn = getColumn(obj, targetFieldName);
        String conditionColumn = getColumn(obj, conditionFieldName);


        String sql = "select " + targetColumn + " from " + tableName + " where "
                + conditionColumn + " = '" + conditionValue + "'";
        return sql;
    }

    public static String queryObj(Object obj, String targetFieldName) {//无条件查询
        String tableName = getTableName(obj);
        String targetColumn = getColumn(obj, targetFieldName);

        String sql = "select " + targetColumn + " from " + tableName;

        return sql;
    }

    //更新
    public static String updateObj(Object obj, String targetFieldName, String targetValue, String conditionFieldName, String conditionValue) {
        String tableName = getTableName(obj);
        String targetColumn = getColumn(obj, targetFieldName);
        String conditionColumn = getColumn(obj, conditionFieldName);


        String sql = "update " + tableName + " set " + targetColumn + " = '" + targetValue +
                "' where " + conditionColumn + " = '" + conditionValue + "'";
        return sql;
    }

}
