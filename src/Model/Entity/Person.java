package Model.Entity;

import Model.Dao.Column;
import Model.Dao.Table;

import java.util.Date;

@Table(tableName="person")
public class Person {
    @Column(columnName="personID",type="String",isKey=true)
    private String personID;

    @Column(columnName="password",type="String")
    private String password;

    @Column(columnName="personName",type="String")
    private String personName;

    @Column(columnName="birthDay",type="Date")
    private Date birthDay;

    @Column(columnName="sex",type="Short")
    private short sex = 1;//1-男，2-女



    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public short getSex() {
        return sex;
    }

    public void setSex(short sex) {
        this.sex = sex;
    }

    public String getPersonID() {
        return personID;
    }

    public void setPersonID(String personID) {
        this.personID = personID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
