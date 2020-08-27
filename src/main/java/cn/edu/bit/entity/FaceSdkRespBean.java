package cn.edu.bit.entity;

/**
 * @author zhangrui
 * @date 2020-08-25 16:45
 */
public class FaceSdkRespBean {

    /**
     * 特征值序列号
     */
    public String seqNum;
    /**
     * 特征值相似度
     */
    public float similarValue;

    public FaceSdkRespBean(String seqNum, float similarValue) {
        this.seqNum = seqNum;
        this.similarValue = similarValue;
    }

    public String getSeqNum() {
        return seqNum;
    }

    public void setSeqNum(String seqNum) {
        this.seqNum = seqNum;
    }

    public float getSimilarValue() {
        return similarValue;
    }

    public void setSimilarValue(float similarValue) {
        this.similarValue = similarValue;
    }

}
