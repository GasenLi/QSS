package Model.Entity.Result;

import Model.Dao.Column;
import Model.Dao.Table;

@Table(tableName="environmentalresult", ChineseDescribe = "环境调查结果")
public class ResultEnv extends Result{
    @Column(columnName="10000",type="char")
    private int ToID10000;

    @Column(columnName="10001",type="char")
    private int ToID10001;

    @Column(columnName="10002",type="char")
    private int ToID10002;

    @Column(columnName="10003",type="char")
    private int ToID10003;

    @Column(columnName="10004",type="char")
    private int ToID10004;

    @Column(columnName="10005",type="char")
    private int ToID10005;

    @Column(columnName="10006",type="char")
    private int ToID10006;

    public int getToID10000() {
        return ToID10000;
    }

    public void setToID10000(int toID10000) {
        ToID10000 = toID10000;
    }

    public int getToID10001() {
        return ToID10001;
    }

    public void setToID10001(int toID10001) {
        ToID10001 = toID10001;
    }

    public int getToID10002() {
        return ToID10002;
    }

    public void setToID10002(int toID10002) {
        ToID10002 = toID10002;
    }

    public int getToID10003() {
        return ToID10003;
    }

    public void setToID10003(int toID10003) {
        ToID10003 = toID10003;
    }

    public int getToID10004() {
        return ToID10004;
    }

    public void setToID10004(int toID10004) {
        ToID10004 = toID10004;
    }

    public int getToID10005() {
        return ToID10005;
    }

    public void setToID10005(int toID10005) {
        ToID10005 = toID10005;
    }

    public int getToID10006() {
        return ToID10006;
    }

    public void setToID10006(int toID10006) {
        ToID10006 = toID10006;
    }
}
