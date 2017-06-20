package com.ejjx.library.utils.file;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;

import com.ejjx.library.bean.FolderBean;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;


/**
 * 本地图片文件工具类
 */
public class ImageFileUtil {

    Context context;

    public ImageFileUtil(Context context) {
        this.context = context;
    }

    /**
     * 获取全部图片地址
     *
     * @return
     */
    public ArrayList<String> getAlldir() {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        Uri uri = intent.getData();
        ArrayList<String> list = new ArrayList<String>();
        String[] proj = {MediaStore.Images.Media.DATA};
        Cursor cursor = context.getContentResolver().query(uri, proj, null, null, null);//managedQuery(uri, proj, null, null, null);
        while (cursor.moveToNext()) {
            String path = cursor.getString(0);
            File file = new File(path).getAbsoluteFile();
            if (file.exists() && file.isFile() && file.length() > 0) {
                list.add(new File(path).getAbsolutePath());
            }
        }
        Collections.reverse(list);
        return list;
    }

    /**
     * 获取本地图片文件夹
     *
     * @return
     */
    public List<FolderBean> getImgFolder() {
        List<FolderBean> data = new ArrayList<FolderBean>();
        String filename = "";
        List<String> allimglist = getAlldir();
        List<String> retulist = new ArrayList<String>();
        if (allimglist != null && !allimglist.isEmpty()) {
            Set set = new TreeSet();
            String[] str;
            for (int i = 0; i < allimglist.size(); i++) {
                retulist.add(getfileinfo(allimglist.get(i)));
            }
            for (int i = 0; i < retulist.size(); i++) {
                set.add(retulist.get(i));
            }
            str = (String[]) set.toArray(new String[0]);
            for (int i = 0; i < str.length; i++) {
                filename = str[i];
                FolderBean ftl = new FolderBean();
                ftl.filename = filename;
                data.add(ftl);
            }

            for (int i = 0; i < data.size(); i++) {
                for (int j = 0; j < allimglist.size(); j++) {
                    if (data.get(i).filename.equals(getfileinfo(allimglist.get(j)))) {
                        data.get(i).filecontent.add(allimglist.get(j));
                    }
                }
            }
        }
        return data;
    }


    /**
     * 获取某一相册的图片文件
     *
     * @return
     * @throws FileNotFoundException
     */
    public FolderBean getFolder() throws FileNotFoundException {
        FolderBean data = new FolderBean();
        List<String> allimglist = getAlldir();
        List<String> retulist = new ArrayList<String>();
        if (allimglist != null && !allimglist.isEmpty()) {
            for (int i = 0; i < allimglist.size(); i++) {
                String name = getfileinfo(allimglist.get(i));
                if (name.equals("DCIM")) {
                    retulist.add(allimglist.get(i));
                    data.filecontent.add(allimglist.get(i));

                    data.filename = name;
                    for (int j = 0; j < allimglist.size(); j++) {
                        if (data.filename.equals(getfileinfo(allimglist.get(j)))) {
                            data.filecontent.add(allimglist.get(j));
                        }
                    }

                    return data;
                }
            }
        }
        return data;
    }


    /**
     * 获取图片的信息
     *
     * @param data
     * @return
     */
    private String getfileinfo(String data) {
        String filename[] = data.split("/");
        if (filename != null) {
            return filename[filename.length - 2];
        }
        return null;
    }
}
