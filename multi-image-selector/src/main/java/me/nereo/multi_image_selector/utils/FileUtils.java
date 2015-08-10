package me.nereo.multi_image_selector.utils;

import android.content.Context;
import android.os.Environment;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * 文件操作类
 * Created by Nereo on 2015/4/8.
 */
public class FileUtils {

    public static File createTmpFile(Context context){

        String state = Environment.getExternalStorageState();
        File tmpFile;
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.CHINA).format(new Date());
        String fileName = "journi_original_"+timeStamp+"";

        if(state.equals(Environment.MEDIA_MOUNTED)){
            // 已挂载
            File pic = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).getPath() + File.separator + "journi");
            pic.mkdirs();
            tmpFile = new File(pic, fileName+".jpg");
        }else{
            File cacheDir = context.getCacheDir();
            tmpFile = new File(cacheDir, fileName+".jpg");
        }
        return tmpFile;
    }

}
