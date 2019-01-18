package cn.ligiarui.reflect;

import lombok.Data;

import java.io.Serializable;

/**
 * @description:
 * @author: lijiarui
 * @create: 2019-01-18 14:57
 **/
@AnnoSimple
public class Info extends Thread implements Serializable {

    private Integer mid;

    private String mname;

    public Info(Integer iid,String name) {
        this.mid = iid;
        this.mname = name;
    }

    public Info(){

    }

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public String getMname() {
        return mname;
    }

    @AnnoSimple
    public void setMname(String mname) {
        this.mname = mname;
    }

    private void getTName(String aaa){
        System.out.println(aaa);
    }
}
