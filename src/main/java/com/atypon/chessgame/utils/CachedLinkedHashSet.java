package com.atypon.chessgame.utils;

import java.util.LinkedHashSet;

public class CachedLinkedHashSet<E> extends LinkedHashSet<E> {
    private E last;

    @Override
    public boolean add(E e) {
        boolean added = super.add(e);
        if (added) {
            last = e;
        }
        return added;
    }

    public E getLast() {
        return last;
    }
}
