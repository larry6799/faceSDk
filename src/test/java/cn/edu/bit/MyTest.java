package cn.edu.bit;

import cn.edu.bit.exception.FaceSDKException;
import cn.edu.bit.service.impl.IFaceInternalServiceImplXX;

import cn.edu.bit.service.impl.IFaceInternalServiceImplXXV2;
import cn.edu.bit.utils.ImageUtils;
import cn.edu.bit.utils.ResponseCode;
import cn.hutool.json.JSONObject;
import org.junit.Test;

import java.io.File;
import java.util.Arrays;

/**
 * @author zhangrui
 * @date 2020-08-25 17:20
 */
public class MyTest {

    // 测试Json解析
    @Test
    public void JsonTest(){
        String ss = "{\n" +
                "\t\"characteristic\": {\n" +
                "\t\t\"age\": 22,\n" +
                "\t\t\"feature\": \"11,22\",\n" +
                "\t\t\"gender\": 1\n" +
                "\t},\n" +
                "\t\"code\": \"200\",\n" +
                "\t\"message\": \"success\"\n" +
                "}";
        JSONObject jsonObject = new JSONObject(ss);
        System.out.println(jsonObject);
        JSONObject a = new JSONObject(jsonObject.get("characteristic")) ;
        System.out.println(a);
        System.out.println(a.get("feature"));
    }

    // 测试代码正常
//    @Test
//    public void test1(){
//        String str = "11";
//        byte[] strByte = str.getBytes();
//        System.out.println(strByte);
//        String str2 = "12";
//        byte[] strByte2 = str.getBytes();
//
//        IFaceInternalServiceImplXX im = new IFaceInternalServiceImplXX();
//
//        float result = im.compareTwoFeature(strByte, strByte2);
//        System.out.println(result);
//    }
//
//
//    // 测试抛出自定义异常
//    @Test
//    public void testException(){
//        String str = "11";
//        byte[] strByte = str.getBytes();
//        if("11".equals(str)){
//            throw new FaceSDKException(ResponseCode.IMAGE_CODE, ResponseCode.IMAGE_Message);
//        }
//    }
//
//    //测试图片encode
//    @Test
//    public void encodeImage() throws Exception {
//        File image = new File("/Users/fiona/Desktop/t1.png");
//        byte[] imgBytes = ImageUtils.fileToByte(image);
//        System.out.println(Arrays.toString(imgBytes).length());
//        ImageUtils.ByteToFile(imgBytes, "png");
//    }
//
//    // 测试获取人脸特征
//    @Test
//    public void getImageFeature() throws Exception {
//        File image = new File("C:\\Users\\susu\\Desktop\\face_recognition\\MeiXi001.jpg");
//        IFaceInternalServiceImplXX im = new IFaceInternalServiceImplXX();
//        im.init("10.1.114.66:5000/feature_extract");
//        im.getFeatureByImage(image);
//    }
//
//    // 测试人脸验证
//    @Test
//    public void compareImage() throws Exception {
//        File image1 = new File("C:\\Users\\susu\\Desktop\\face_recognition\\MeiXi001.jpg");
//        File image2 = new File("C:\\Users\\susu\\Desktop\\face_recognition\\MeiXi002.jpg");
//        IFaceInternalServiceImplXX im = new IFaceInternalServiceImplXX();
//        im.init("10.1.114.66:5000/ver");
//        float sim = im.compareTwoImage(image1, image2);
//        System.out.println("相似度 ：" + sim);
//    }
//
//    // 测试人脸识别
//    @Test
//    public void compareMoreImage() throws Exception {
//        File image = new File("/Users/fiona/Desktop/t1.png");
//        IFaceInternalServiceImplXXV2 imV2 = new IFaceInternalServiceImplXXV2();
//        imV2.init("10.1.114.66:5000/nver");
//        String name = imV2.compareMoreImage(image);
//        System.out.println("此人是 ：" + name);
//    }



}
