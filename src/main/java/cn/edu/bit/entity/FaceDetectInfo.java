package cn.edu.bit.entity;

/**
 * @author zhangrui
 * @date 2020-08-25 16:42
 */
public class FaceDetectInfo {

    /**
     * 特征
     */
    public byte[] feature;

    /**
     * 质量
     */
    public float quality;

    /**
     * 性别
     */
    public int gender;

    /**
     * 年龄
     */
    public int age;

    public FaceDetectInfo(byte[] feature, float quality, int gender, int age) {
        this.feature = feature;
        this.quality = quality;
        this.gender = gender;
        this.age = age;
    }

    public byte[] getFeature() {
        return feature;
    }

    public void setFeature(byte[] feature) {
        this.feature = feature;
    }

    public float getQuality() {
        return quality;
    }

    public void setQuality(float quality) {
        this.quality = quality;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}
