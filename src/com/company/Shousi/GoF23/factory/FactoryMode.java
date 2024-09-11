package com.company.Shousi.GoF23.factory;

//工厂模式可以将对象的创建与具体实现解耦，从而实现更好的灵活性和可维护性。
public class FactoryMode {
    public static void main(String[] args) {
        Factory circleFactory = new Factory();
        Shape circle = circleFactory.get("circle");
        circle.draw();
    }
}

interface Shape{
    void draw();
}

//定义具体实现类
class Circle implements Shape{
    @Override
    public void draw() {
        System.out.println("draw a circle");
    }
}

class Rectangle implements Shape{
    @Override
    public void draw() {
        System.out.println("draw a rectangle");
    }
}

class Factory{
    public Shape get(String shapeType){
        if("circle".equals(shapeType)){
            return new Circle();
        }else if("rectangle".equals(shapeType)){
            return new Rectangle();
        }else {
            return null;
        }
    }
}
