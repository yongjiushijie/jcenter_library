package com.ejjx.library.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by sk on 2017/4/21.
 */

public class FolderBean implements Parcelable {

    public String filename;
    public ArrayList<String> filecontent = new ArrayList<String>();

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public ArrayList<String> getFilecontent() {
        return filecontent;
    }

    public void setFilecontent(ArrayList<String> filecontent) {
        this.filecontent = filecontent;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(filename);
        parcel.writeList(filecontent);
    }


    public static final Creator<FolderBean> CREATOR = new Creator<FolderBean>() {
        @Override
        public FolderBean createFromParcel(Parcel in) {
            FolderBean fileBean = new FolderBean();
            fileBean.setFilename(in.readString());
            fileBean.setFilecontent(in.readArrayList(FolderBean.class.getClassLoader()));
            return fileBean;
        }

        @Override
        public FolderBean[] newArray(int size) {
            return null;
        }
    };
}
