package Model.Entity.Questionnaire;

import Model.Dao.Column;

public class Questionnaire {
    @Column(columnName="TopicID",type="int",isKey=true)
    private int TopicID;

    @Column(columnName="TopicDescribe",type="String")
    private String TopicDescribe;

    @Column(columnName="OptionA",type="char")
    private String OptionA;

    @Column(columnName="OptionB",type="char")
    private String OptionB;

    @Column(columnName="OptionC",type="char")
    private String OptionC;

    @Column(columnName="OptionD",type="char")
    private String OptionD;

    public int getTopicID() {
        return TopicID;
    }

    public void setTopicID(int topicID) {
        TopicID = topicID;
    }

    public String getTopicDescribe() {
        return TopicDescribe;
    }

    public void setTopicDescribe(String topicDescribe) {
        TopicDescribe = topicDescribe;
    }

    public String getOptionA() {
        return OptionA;
    }

    public void setOptionA(String optionA) {
        OptionA = optionA;
    }

    public String getOptionB() {
        return OptionB;
    }

    public void setOptionB(String optionB) {
        OptionB = optionB;
    }

    public String getOptionC() {
        return OptionC;
    }

    public void setOptionC(String optionC) {
        OptionC = optionC;
    }

    public String getOptionD() {
        return OptionD;
    }

    public void setOptionD(String optionD) {
        OptionD = optionD;
    }
}
