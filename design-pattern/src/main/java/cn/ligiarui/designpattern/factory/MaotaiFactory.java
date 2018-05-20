package cn.ligiarui.designpattern.factory;

import cn.ligiarui.designpattern.bean.Maotai;
import cn.ligiarui.designpattern.bean.Wine;

public class MaotaiFactory implements Factory {
    @Override
    public Wine getWine() {
        return new Maotai();
    }
}
