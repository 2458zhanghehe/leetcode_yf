package com.company.Shousi.GoF23.observer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Observer {
    public static void main(String[] args) {
        Center center = new Center();
        Securitor s1 = new Securitor(1, center);
        Securitor s2 = new Securitor(2, center);
        Securitor s3 = new Securitor(3, center);
        center.fire(2);
    }
}

class Securitor {
    private int floor;
    private Center center;
    public Securitor(int floor, Center center) {
        this.floor = floor;
        this.center = center;
        center.registerSecuritor(this);
    }
    public void process(){
        System.out.println(floor + "层的保安正在灭火");
    }

    public void hasfire(int floor){
        if(floor == this.floor){
            process();
        }
    }
}

class Center {
    List<Securitor> ss = new ArrayList<Securitor>();

    public boolean registerSecuritor(Securitor securitor){
        if(ss.contains(securitor)){
            return false;
        }
        ss.add(securitor);
        return true;
    }

    public void fire(int floor){
        notifyS(floor);
    }

    private void notifyS(int floor) {
        for (Securitor s : ss) {
            s.hasfire(floor);
        }
    }
}
