package cn.edu.bit.utils;

/**
 * @author zhangrui
 * @date 2020-08-25 19:02
 */
public class ResponseCode {
    /** 系统处理正常 */
    public static final String SUCCESS_CODE = "103-XX-02-10000";
    public static final String SUCCESS_Message = "SUCCESS";

    /** 无法识别图片 **/
    public static final String IMAGE_CODE = "103-XX-02-10002";
    public static final String IMAGE_Message = "IMAGE_ERROR";

    /** 无法识别特征值 **/
    public static final String FEATURE_CODE = "103-XX-02-10003";
    public static final String FEATURE_Message = "FEATURE_ERROR";

    /** 调用接口失败 **/
    public static final String INTERFACE_CODE = "103-XX-02-10004";
    public static final String INTERFACE_Message = "INTERFACE_ERROR";

}
