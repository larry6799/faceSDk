package cn.edu.bit.utils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

/**
 * @author zhangrui
 * @date 2020-08-26 15:08
 */
public class ImageUtils {

    public static byte[] fileToByte(File img){
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            String imgName = img.getName();
            String suffix = imgName.substring(imgName.indexOf(".")+1, imgName.length());
            System.out.println(suffix);
            BufferedImage bi;
            bi = ImageIO.read(img);
            ImageIO.write(bi, suffix, baos);
            byte[] bt = baos.toByteArray();
//            System.err.println(bytes);
            return bt;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void ByteToFile(byte[] bytes, String suffix)throws Exception{
        ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
        BufferedImage bi1 =ImageIO.read(bais);
        try {
            File w2 = new File("7." + suffix );//可以是jpg,png,gif格式
            ImageIO.write(bi1, suffix, w2);//不管输出什么格式图片，此处不需改动
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            bais.close();
        }
    }
}
