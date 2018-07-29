package Model.Entity.Result;

import Model.Dao.Column;

import java.util.Date;

public class Result {
    @Column(columnName="ResponderIP",type="String")
    private String ResponderIP;

    @Column(columnName="Time",type="Date")
    private Date Time;

    public String getResponderIP() {
        return ResponderIP;
    }

    public void setResponderIP(String responderIP) {
        ResponderIP = responderIP;
    }

    public Date getTime() {
        return Time;
    }

    public void setTime(Date time) {
        Time = time;
    }
}
