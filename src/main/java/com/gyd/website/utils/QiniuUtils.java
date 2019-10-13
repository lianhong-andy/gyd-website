package com.gyd.website.utils;

import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;

public class QiniuUtils {
    /**基本配置-从七牛管理后台拿到账号的ACCESS_KEY和SECRET_KEY*/
    String ACCESS_KEY = "QJFmQkOrWirudQQkxAHEORjktP2HO4LdXT6tqaHo";
    String SECRET_KEY = "Ne9MS0LeN0PPdCl4Z6r5V_UFrpfj6Pb4FnV4AJqw";
    //上传文件建立的空间名
    String bucketname = "andy-lian";

    //上传文件的路径（本地文件）
    String FilePath ="C:\\Users\\Administrator\\Desktop\\666.jpg";

    //上传到七牛后保存的文件名
    String key = "hh.jpg";

    //密钥配置
    Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);
    //创建上传对象
    UploadManager uploadManager =new UploadManager(new Configuration());


    //简单上传，使用默认策略，只需要设置上传的空间名就可以了
    public String getUpToken(){
        return auth.uploadToken(bucketname);
    }



    public void uploadPic() {
        try {
            //调用put方法上传
            //第一个参数为文件路径，第二个参数为文件上传名称，第三个参数是上文件的空间
            Response res = uploadManager.put(FilePath, key, getUpToken());

            //打印返回的信息
            System.out.println("上传后状态码"+res.statusCode);//200为上传成功


        } catch (QiniuException e) {

            // 请求失败时打印的异常的信息
            System.out.println("上传异常"+e);

        }
    }

    public static void main(String[] args) {
        QiniuUtils qiniu = new QiniuUtils();
        qiniu.uploadPic();
        System.out.println("\"http://pzao3zhni.bkt.clouddn.com\"+key = " + "http://pzao3zhni.bkt.clouddn.com" + qiniu.key);
    }
}
