package com.company.Bishi.zhongan;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

//将users根据name去重
public class Distinct {
    public List<User> distinct(List<User> users){
        List<User> ans = users.stream().distinct().collect(Collectors.toList());
        return ans;
    }

    public static void main(String[] args) {
        User user1 = new User(1, "张4");
        User user2 = new User(2, "张4");
        System.out.println(user1.hashCode());
        System.out.println(user2.hashCode());
    }
}

class User{
    public int id;
    public String name;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public int hashCode() {
        //里面就是调用name.hasCode()
        //Objects.hashCode(name);
        return name.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null || getClass() != obj.getClass()){
            return false;
        }
        return name.equals(((User) obj).name);
    }
}
