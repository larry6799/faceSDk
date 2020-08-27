package cn.edu.bit.service;

import cn.edu.bit.entity.FaceSdkReqBean;
import cn.edu.bit.entity.FaceSdkRespBean;

import java.io.File;

/**
 * @author zhangrui
 * @date 2020-08-25 18:33
 */

public interface IFaceInternalServiceV2 extends IFaceInternalService {

    /**
     *
     * compareMoreFeature:比对多个特征值(1:N)<br/>
     *
     * @param feature
     *            特征值
     * @param ftrCentralLibList
     *            特征值中心库列表
     *
     * @return 相似度特征值对象数组
     */
    FaceSdkRespBean[] compareMoreFeature(byte[] feature, FaceSdkReqBean[] ftrCentralLibList);

    String compareMoreImage(File file);
    /**
     *
     * compareMoreImage:比对多张图片(1:N)<br/>
     *
     * @param img
     *            图片
     * @param imgCentralLibList
     *            图片中心库列表
     * @return 图片相似度对象数组
     */
    // FaceSdkRespBean[] compareMoreImage(byte[] img, FaceSdkReqBean[] imgCentralLibList);
}