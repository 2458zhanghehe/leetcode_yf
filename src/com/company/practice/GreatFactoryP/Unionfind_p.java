package com.company.practice.GreatFactoryP;

import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class Unionfind_p {
    public class Element<V> {
        V value;

        public Element(V v) {
            value = v;
        }
    }

    public class unionf<V> {
        private HashMap<V, Element<V>> elementmap;
        private HashMap<Element<V>, Element<V>> fathermap;
        private HashMap<Element<V>, Integer> sizemap;

        public unionf(List<V> list) {
            elementmap = new HashMap<>();
            fathermap = new HashMap<>();
            sizemap = new HashMap<>();
            for (V tmp : list) {
                elementmap.put(tmp, new Element<>(tmp));
                fathermap.put(new Element<>(tmp), new Element<>(tmp));
                sizemap.put(new Element<>(tmp), 1);
            }
        }

        public boolean isSameSet(V a, V b) {
            if (!elementmap.containsKey(a) || !elementmap.containsKey(b)) {
                return false;
            }
            Element<V> ae = elementmap.get(a);
            Element<V> be = elementmap.get(b);
            Element<V> ae_f = findHeadFather(ae);
            Element<V> be_f = findHeadFather(be);
            return ae_f == be_f;
        }

        public Element<V> findHeadFather(Element<V> cur) {
            if (!elementmap.containsKey(cur)) {
                return null;
            }
            Stack<Element<V>> stack = new Stack<>();
            while (cur != fathermap.get(cur)) {
                stack.push(cur);
                cur = fathermap.get(cur);
            }
            while (!stack.isEmpty()) {
                fathermap.put(stack.pop(), cur);
            }
            return cur;
        }

        public void union(V a, V b) {
            if (!elementmap.containsKey(a) || !elementmap.containsKey(b)) {
                return;
            }
            Element<V> ae = elementmap.get(a);
            Element<V> be = elementmap.get(b);
            Element<V> ae_f = fathermap.get(ae);
            Element<V> be_f = fathermap.get(be);
            if (ae_f == be_f) {
                return;
            }
            int a_length = sizemap.get(ae_f);
            int b_length = sizemap.get(be_f);
            Element<V> longer = a_length >= b_length ? ae_f : be_f;
            Element<V> shorter = longer == ae_f ? be_f : ae_f;
            fathermap.put(shorter, longer);
            sizemap.put(longer, a_length + b_length);
            sizemap.remove(shorter);
        }


    }

}
