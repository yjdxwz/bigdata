package com.it18zhang.eshop.test;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.junit.Test;

import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * 测试饼图
 */
public class TestJfreechart {

    @Test
    public void pie() throws Exception {
        File f = new File("d:/pie.png");

        //数据集
        DefaultPieDataset ds = new DefaultPieDataset();
        ds.setValue("HuaWei",3000);
        ds.setValue("Apple",5000);
        ds.setValue("Mi",1890);

        JFreeChart chart = ChartFactory.createPieChart("饼图演示", ds, false, false, false);

        Font font = new Font("宋体",Font.BOLD,15);
        chart.getTitle().setFont(font);
        //背景透明

        ((PiePlot)chart.getPlot()).setForegroundAlpha(0.2f);
        ((PiePlot)chart.getPlot()).setExplodePercent("Apple",0.1f);
        ((PiePlot)chart.getPlot()).setExplodePercent("HuaWei",0.2f);
        ((PiePlot)chart.getPlot()).setExplodePercent("Mi",0.3f);


        //创建3D饼图
        ChartUtilities.saveChartAsJPEG(f, chart,400,300);
    }
}
