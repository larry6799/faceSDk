package cn.edu.bit.service.impl;

import cn.edu.bit.entity.FaceDetectInfo;
import cn.edu.bit.exception.FaceSDKException;
import cn.edu.bit.service.IFaceInternalService;
import cn.edu.bit.utils.ImageUtils;
import cn.edu.bit.utils.ResponseCode;
import cn.hutool.core.io.FileUtil;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;


/**
 * @author zhangrui
 * @date 2020-08-25 16:55
 */
public class IFaceInternalServiceImplXX implements IFaceInternalService {
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
    private static Logger log = Logger.getLogger(IFaceInternalServiceImplXX.class);

    // private String apiPath = "http://127.0.0.1:5000/img";

    private String apiPath = "";

    public String getApiPath() {
        return apiPath;
    }

    public boolean init(String apiPath){
        log.info("----init---- set the apiPath : " + apiPath);
        this.apiPath = apiPath;
//        int i = 0;
//        if(i == 0){
//            throw new FaceSDKException(ResponseCode.INTERFACE_CODE, ResponseCode.INTERFACE_Message);
//        }
        return true;
    }

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
//    public FaceDetectInfo[] getFeatureByPersons(byte[] img, String imgType){
//        String str = "11";
//        byte[] strByte = str.getBytes();
//        FaceDetectInfo faceDetectInfo = new FaceDetectInfo(strByte,0.9,0,24);
//        FaceDetectInfo[] ff = new FaceDetectInfo[1];
//        ff[0] = faceDetectInfo;
//        return ff;
//    }

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
    public FaceDetectInfo getFeatureByPerson(byte[] img, String imgType){
        String str = "11";
        byte[] strByte = str.getBytes();
        if("11".equals(str)){
            throw new FaceSDKException(ResponseCode.IMAGE_CODE, ResponseCode.IMAGE_Message);
        }
        FaceDetectInfo faceDetectInfo = new FaceDetectInfo(strByte, (float) 0.9,0,24);
        return faceDetectInfo;
    }


    public FaceDetectInfo getFeatureByImage(File image){
        log.info("get getFeatureByImage begin");
        byte[] imgBytes = ImageUtils.fileToByte(image);

        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("img", image);

        String url = getApiPath();
        String result = HttpUtil.post(url, paramMap);
        log.info(result);

        if(!StringUtils.isEmpty(result)) {

            JSONObject jsonObject = new JSONObject(result);
            String errCode = (String) jsonObject.get("code");

            switch(errCode){
                case "200" :
                    JSONObject characteristic = new JSONObject(jsonObject.get("characteristic"));
                    System.out.println(characteristic);
                    String feature = (String) characteristic.get("feature");
                    String gender = (String) characteristic.get("gender");
                    String age = (String) characteristic.get("age");
                    log.info(("feature : " + feature));
                    log.info(("gender : " + gender));
                    log.info(("age : " + age));

                    FaceDetectInfo faceDetectInfo = new FaceDetectInfo(imgBytes, (float) 0.9,Integer.parseInt(gender),Integer.parseInt(age));
                    return faceDetectInfo;
                case "101" :
                    log.info("there is no human face in the image");
                    throw new FaceSDKException(ResponseCode.IMAGE_CODE, ResponseCode.IMAGE_Message);
                default :
                    log.info("system crashed");
                    throw new FaceSDKException(ResponseCode.INTERFACE_CODE, ResponseCode.INTERFACE_Message);
            }
        }
        return null;
    }
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
    public float compareTwoFeature(byte[] feature1, byte[] feature2){
        log.info("out 666");
        float sim = (float) 0.520;
        log.info("compareTwoFeature finish");

        // 调用flask
        // flask
        // fun1(byte() b1, byte() b2)
        // flask -> python.sim()
        // python.sim() 不是直接读取照片
        // 而是通过 byte（） 还原  图片
        return sim;
    }

    public float compareTwoImage(File file1, File file2){
        log.info("compareTwoImage begin");
        float sim = (float) 0.0;
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("source", file1);
        paramMap.put("target", file2);

        String url = getApiPath();
        String result = HttpUtil.post(url, paramMap);

        if(!StringUtils.isEmpty(result)) {
            JSONObject jsonObject = new JSONObject(result);
            String errCode = (String) jsonObject.get("code");

            switch (errCode) {
                case "200":
                    String simir = (String) jsonObject.get("sim");
                    log.info(simir);

                    return Float.parseFloat(simir);
                case "102":
                    log.info("there is no human face in the image1");
                    throw new FaceSDKException(ResponseCode.IMAGE_CODE, ResponseCode.IMAGE_Message);
                case "103":
                    log.info("there is no human face in the image2");
                    throw new FaceSDKException(ResponseCode.IMAGE_CODE, ResponseCode.IMAGE_Message);
                default:
                    log.info("system crashed");
                    throw new FaceSDKException(ResponseCode.INTERFACE_CODE, ResponseCode.INTERFACE_Message);
            }
        }
        return sim;
    }

    /**
     *
     * unInit:释放资源 <br/>
     *
     * @return <code>true</code> if face sdk unInit success; <code>false</code>
     *         otherwise.
     */
    public boolean unInit(){
        log.info("unInit...");
        this.apiPath = "";
        return true;
    }
}
