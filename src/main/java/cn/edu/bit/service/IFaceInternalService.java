package cn.edu.bit.service;

import cn.edu.bit.entity.FaceDetectInfo;

import java.io.File;

/**
 * @author zhangrui
 * @date 2020-08-25 16:48
 */
public interface IFaceInternalService {

    /**
     * init:初始化引擎和参数 <br/>
     *
     * @param logPath
     *            日志路径
     * @param dllPath
     *            加载dll文件全路径
     * @param osBit
     *            加载的jdk位数（32/64 bit）
     * @param modelPath
     *            和算法相关的其他加载路径
     * @param cocurrentNum
     *            并发数 <br/>
     * @return <code>true</code> if face sdk init success; <code>false</code>
     *         otherwise.
     */
    boolean init(String apiPath);

    /**
     *
     * getFeatureByPersons:获取图片中人脸特征信息 <br/>
     *
     * @param img
     * @param imgType
     *            图片类型，“JPG”，“PNG”，“BMP”
     *
     * @return 人脸特征值信息 <br/>
     */
    // FaceDetectInfo[] getFeatureByPersons(byte[] img, String imgType);

    /**
     *
     * getFeatureByPerson:获取图片中最大人脸特征信息 <br/>
     *
     * @param img
     * @param imgType
     *            图片类型，“JPG”，“PNG”，“BMP”
     *
     * @return 人脸特征值信息 <br/>
     */
    FaceDetectInfo getFeatureByPerson(byte[] img, String imgType);

    FaceDetectInfo getFeatureByImage(File img);

    /**
     *
     * compareTwoFeature:比较两张图片特征值 <br/>
     *
     * @param feature1
     *            特征值1
     * @param feature2
     *            特征值2
     * @return 相似度，精确到小数点后3位，例如：0.952<br/>
     */
    float compareTwoFeature(byte[] feature1, byte[] feature2);

    float compareTwoImage(File file1, File file2);
    /**
     *
     * unInit:释放资源 <br/>
     *
     * @return <code>true</code> if face sdk unInit success; <code>false</code>
     *         otherwise.
     */
    boolean unInit();
}
