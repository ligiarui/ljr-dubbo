package cn.ligiarui.designpattern.simplefactory;

import cn.ligiarui.designpattern.bean.Maotai;
import cn.ligiarui.designpattern.bean.Wine;
import cn.ligiarui.designpattern.bean.Wuliangye;

/**
 * 简单工厂模式
 */
public class SimpleFactory {

    public Wine getWine(String name){
        if("茅台".equals(name)){
            return new Maotai();
        }
        if("五粮液".equals(name)){
            return new Wuliangye();
        }

        return null;
    }
}
