package com.xixun.appchangsha;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Dmgd {
    public String wd;
    public String sd;
    public String fs;
    public String fx;
    public String qy;
    public String js;
    public String njd;
    public String time;
    private SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日 E HH:mm", Locale.CHINA);
    private SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.CHINA);
    public Dmgd(String wd, String sd, String fs, String fx, String qy, String js, String njd, String time) {
        this.wd = wd;
        this.sd = sd;
        this.fs = fs;
        this.fx = fx;
        this.qy = qy;
        this.js = js;
        this.njd = njd;
        try {
            Date date  = format1.parse(time);
           this.time = format.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }


    }

    public Dmgd(String wd, String sd, String fs, String fx, String qy, String js, String njd) {
        this.wd = wd;
        this.sd = sd;
        this.fs = fs;
        this.fx = fx;
        this.qy = qy;
        this.js = js;
        this.njd = njd;

    }

    @Override
    public String toString() {
        return "Dmgd{" +
                "wd='" + wd + '\'' +
                ", sd='" + sd + '\'' +
                ", fs='" + fs + '\'' +
                ", fx='" + fx + '\'' +
                ", qy='" + qy + '\'' +
                ", js='" + js + '\'' +
                ", njd='" + njd + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
