package cn.edu.bit.service.impl;

import cn.edu.bit.entity.FaceDetectInfo;
import cn.edu.bit.entity.FaceSdkReqBean;
import cn.edu.bit.entity.FaceSdkRespBean;
import cn.edu.bit.exception.FaceSDKException;
import cn.edu.bit.service.IFaceInternalService;
import cn.edu.bit.service.IFaceInternalServiceV2;
import cn.edu.bit.utils.ImageUtils;
import cn.edu.bit.utils.ResponseCode;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import java.io.File;
import java.util.HashMap;

/**
 * @author zhangrui
 * @date 2020-08-25 16:55
 */
public class IFaceInternalServiceImplXXV2 extends IFaceInternalServiceImplXX implements IFaceInternalServiceV2 {

    private static Logger log = Logger.getLogger(IFaceInternalServiceImplXXV2.class);
    /**
     * compareMoreFeature:比对多个特征值(1:N)<br/>
     *
     * @param feature           特征值
     * @param ftrCentralLibList 特征值中心库列表
     * @return 相似度特征值对象数组
     */
    public FaceSdkRespBean[] compareMoreFeature(byte[] feature, FaceSdkReqBean[] ftrCentralLibList){
        FaceSdkRespBean[] ff = new FaceSdkRespBean[1];
        String str = "11";
        byte[] strByte = str.getBytes();
        if("11".equals(str)){
            throw new FaceSDKException(ResponseCode.FEATURE_CODE, ResponseCode.FEATURE_Message);
        }
        FaceSdkRespBean f0 = new FaceSdkRespBean("001", (float) 0.87);
        ff[0] = f0;
        return ff;
    }


    public String compareMoreImage(File image){
        log.info("compareMoreImage begin");
        String name = "";
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("source", image);

        String url = getApiPath();
        String result = HttpUtil.post(url, paramMap);

        // log.info(result);
        if(!StringUtils.isEmpty(result)){
            JSONObject jsonObject = new JSONObject(result);
            String errCode = (String) jsonObject.get("code");
            switch(errCode){
                case "200" :
                    String maxName = (String) jsonObject.get("max_name");
                    String maxSim = (String) jsonObject.get("max_sim");
                    log.info("maxName : " + maxName);
                    log.info("maxSim : " + maxSim);
                    return maxName;
                case "104" :
                    log.info("This person don\'t belong to our library");
                    throw new FaceSDKException(ResponseCode.IMAGE_CODE, ResponseCode.IMAGE_Message);
                case "102" :
                    log.info("there is no human face in the image");
                    throw new FaceSDKException(ResponseCode.IMAGE_CODE, ResponseCode.IMAGE_Message);
                default :
                    throw new FaceSDKException(ResponseCode.INTERFACE_CODE, ResponseCode.INTERFACE_Message);
            }
        }
        return name;
    }
    /**
     * compareMoreImage:比对多张图片(1:N)<br/>
     *
     * @param img               图片
     * @param imgCentralLibList 图片中心库列表
     * @return 图片相似度对象数组
     */
//    public FaceSdkRespBean[] compareMoreImage(byte[] img, FaceSdkReqBean[] imgCentralLibList){
//        FaceSdkRespBean[] ff = new FaceSdkRespBean[1];
//        String str = "11";
//        byte[] strByte = str.getBytes();
//        FaceSdkRespBean f0 = new FaceSdkRespBean("001", (float) 0.87);
//        ff[0] = f0;
//        return ff;
//    }
}