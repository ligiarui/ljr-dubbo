package cn.ligiarui.designpattern.test;

import cn.ligiarui.designpattern.abstractfactory.WineFactory;
import cn.ligiarui.designpattern.bean.Maotai;
import cn.ligiarui.designpattern.bean.Wine;
import cn.ligiarui.designpattern.factory.Factory;
import cn.ligiarui.designpattern.factory.MaotaiFactory;
import cn.ligiarui.designpattern.simplefactory.SimpleFactory;

public class Test {

    public static void main(String[] args) {
        Wine wine = new Maotai();
        //不使用工厂模式
        System.out.println(wine.getName());
        //使用简单工厂模式
        SimpleFactory factory = new SimpleFactory();
        System.out.println(factory.getWine("茅台"));
        //工厂方法模式
        Factory factoryMethod = new MaotaiFactory();
        System.out.println(factoryMethod.getWine());
        //抽象工厂
        WineFactory wineFactory = new WineFactory();
        System.out.println(wineFactory.getWuliangye());

    }
}
