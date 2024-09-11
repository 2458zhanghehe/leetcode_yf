package com.company.Shousi.GoF23.decorator;

public class DecoratorPattern {
    public static void main(String[] args) {
        new RobotDecorator(new FirstRobot()).doMoreThing();
    }
}

interface Robot{
    void doSomething();
}

class FirstRobot implements Robot{
    @Override
    public void doSomething() {
        System.out.println("唱歌");
        System.out.println("跳舞");
    }
}

class RobotDecorator implements Robot{
    private Robot robot;
    public RobotDecorator(Robot robot){
        this.robot = robot;
    }

    @Override
    public void doSomething() {
        robot.doSomething();
    }

    public void doMoreThing(){
        robot.doSomething();
        System.out.println("拖地");
    }
}
