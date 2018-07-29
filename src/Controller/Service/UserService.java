package Controller.Service;

import Controller.Service.Implements.IUserService;
import Model.DB.JdbcPool;
import Model.Dao.BaseDao;
import Model.Entity.Person;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class UserService implements IUserService {

    @Override
    public boolean findLogin(Person person) {
        ResultSet result = BaseDao.queryObj(person, "password", "personID", person.getPersonID());

        String password = "";
        try {
            result.next();                  //将指针移到结果第一行
            password = result.getString("password");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if(password.equals(person.getPassword())){
            return true;
        }else {
            return false;
        }
    }

}
