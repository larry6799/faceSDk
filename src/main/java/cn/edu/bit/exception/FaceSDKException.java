package cn.edu.bit.exception;

import cn.edu.bit.service.impl.IFaceInternalServiceImplXX;
import org.apache.log4j.Logger;

/**
 * @author zhangrui
 * @date 2020-08-25 18:41
 */

public class FaceSDKException extends RuntimeException {

    private static Logger log = Logger.getLogger(FaceSDKException.class);
    /**
     * serialVersionUID
     *
     */
    private static final long serialVersionUID = -2101056526686965426L;

    private String code;

    private String msg;

    private String data;

    /**
     * <b>E.G.:</b></br>
     * throw new FaceException("01-00-10001", "workstation cannot
     * found");</br>
     * <b>Client get response:</b></br>
     * {"code":01-00-10001,"msg":"workstation cannot found","data":""}
     *
     * @param message define it yourself
     */
    public FaceSDKException(String code, String message) {
        this.code = code;
        this.msg = message;
        this.data = "";
        log.info(this);
        // log.info(this);
    }

    public FaceSDKException(String code, String message, Throwable cause) {
        super(cause);
        this.code = code;
        this.msg = message;
        this.data = "";
    }

    /**
     * FaceException message
     *
     * @return the message
     */
    public String getMsg() {
        return msg;
    }

    /**
     * @param msg the message to set
     */
    public void setMsg(String msg) {
        this.msg = msg;
    }

    /**
     * @return the code
     */
    public String getCode() {
        return code ;
    }

    /**
     * @param code the code to set
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * @return the data
     */
    public String getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "FaceSDKException{" +
                "code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                ", data='" + data + '\'' +
                '}';
    }
}
