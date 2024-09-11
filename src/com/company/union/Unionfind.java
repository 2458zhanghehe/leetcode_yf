package com.company.union;

import org.omg.CORBA.INTERNAL;

import javax.jws.Oneway;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class Unionfind {
    public class Element<V> {
        V value;
        public Element(V v) {
            value = v;
        }
    }

    public class unionfind<V> {
        private HashMap<V, Element<V>> onetoOnemap;
        //key：子  val：父
        private HashMap<Element<V>, Element<V>> fathermap;
        private HashMap<Element<V>, Integer> sizemap;

        public unionfind(List<V> vlist) {
            onetoOnemap = new HashMap<>();
            fathermap = new HashMap<>();
            sizemap = new HashMap<>();
            for (V tmp : vlist) {
                onetoOnemap.put(tmp, new Element<V>(tmp));
                fathermap.put(new Element<>(tmp), new Element<V>(tmp));
                sizemap.put(new Element<V>(tmp), 1);
            }
        }

        public Element<V> getHeadFather(Element<V> element) {
            Stack<Element<V>> stack = new Stack<>();
            while (element != fathermap.get(element)) {
                stack.push(element);
                element = fathermap.get(element);
            }
            while (!stack.isEmpty()) {
                fathermap.put(stack.pop(), element);
            }
            return element;
        }

        public boolean isSameSet(V v1, V v2) {
            if (!onetoOnemap.containsKey(v1) || !onetoOnemap.containsKey(v2)) {
                return false;
            }
            return getHeadFather(onetoOnemap.get(v1)) == getHeadFather(onetoOnemap.get(v2));
        }

        public void union(V a, V b) {
            if (!onetoOnemap.containsKey(a) || !onetoOnemap.containsKey(b)) {
                return;
            }
            Element<V> a_father = getHeadFather(onetoOnemap.get(a));
            Element<V> b_father = getHeadFather(onetoOnemap.get(b));
            if (a_father == b_father) {
                return;
            }
            int lengtha = sizemap.get(a_father);
            int lengthb = sizemap.get(b_father);
            Element<V> longer = lengtha >= lengthb ? a_father : b_father;
            Element<V> shorter = longer == a_father ? b_father : a_father;
            fathermap.put(shorter, longer);
            sizemap.put(longer, lengtha + lengthb);
            sizemap.remove(shorter);
        }
    }
}
