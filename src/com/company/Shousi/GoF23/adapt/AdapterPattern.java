package com.company.Shousi.GoF23.adapt;

public class AdapterPattern {
    public static void main(String[] args) {
        new Adapter(new Speaker()).translate();
    }
}

class Speaker{
    public String speak(){
        return "balabala";
    }
}

interface Translator{
    public String translate();
}

class Adapter implements Translator{
    //这种把原对象作为属性来进行功能的拓展、适配的方法称为关联方式
    private Speaker speaker;
    public Adapter(Speaker speaker){
        this.speaker = speaker;
    }

    @Override
    public String translate() {
        String result = speaker.speak();
        // 做某些转换，例如翻译
        return result;
    }
}

//适配器和装饰器实现很像，但二者是不同的，适配器的目的是原接口无法直接使用，所以需要适配。
// 就像收集手机无法直接冲220V交流电，所以需要充电器。
//而装饰器模式更多的是对原有功能进行封装以拓展功能。


