package cn.edu.bit.entity;

/**
 * @author zhangrui
 * @date 2020-08-25 16:43
 */
public class FaceSdkReqBean {

    /**
     * 特征值序列号
     */
    public String seqNum;
    /**
     * 特征值
     */
    public byte[] feature;

    public FaceSdkReqBean(String seqNum, byte[] feature) {
        this.seqNum = seqNum;
        this.feature = feature;
    }

    public String getSeqNum() {
        return seqNum;
    }

    public void setSeqNum(String seqNum) {
        this.seqNum = seqNum;
    }

    public byte[] getFeature() {
        return feature;
    }

    public void setFeature(byte[] feature) {
        this.feature = feature;
    }

}