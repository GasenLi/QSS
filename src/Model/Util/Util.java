package Model.Util;

import Model.Dao.BaseDao;
import Model.Dao.SQL;
import Model.Entity.Questionnaire.Questionnaire;

import java.io.IOException;
import java.net.URISyntaxException;

public class Util {

    //得到指定中文名所属的类
    public static Class getClassByChineseDescribe(String targetQstnrName, Class superClazz) throws URISyntaxException, IOException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        for (Class<?> clazz : ClassUtil.getAllAssignedClass(superClazz)) {
            if (targetQstnrName.equals(SQL.getChineseDescribe(clazz.newInstance()))) {
                return clazz;
            }
        }

        return null;
    }
}
