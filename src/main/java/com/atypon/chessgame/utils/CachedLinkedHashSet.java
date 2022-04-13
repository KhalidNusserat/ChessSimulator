package com.atypon.chessgame.utils;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Stack;

public class CachedLinkedHashSet<E> extends LinkedHashSet<E> {
    private final Stack<E> elements = new Stack<>();

    @Override
    public boolean add(E e) {
        boolean added = super.add(e);

        if (added) {
            elements.push(e);
        }
        return added;
    }

    @Override
    public boolean remove(Object o) {
        boolean removed = super.remove(o);
        if (removed && Objects.equals(o, elements.peek())) {
            elements.pop();
        }
        return removed;
    }

    public E getLast() {
        return elements.peek();
    }
}
