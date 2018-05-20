package cn.ligiarui.designpattern.abstractfactory;

import cn.ligiarui.designpattern.bean.Maotai;
import cn.ligiarui.designpattern.bean.Wine;
import cn.ligiarui.designpattern.bean.Wuliangye;

public class WineFactory extends AbstactFactory {
    @Override
    public Wine getMaotai() {
        return new Maotai();
    }

    @Override
    public Wine getWuliangye() {
        return new Wuliangye();
    }
}
