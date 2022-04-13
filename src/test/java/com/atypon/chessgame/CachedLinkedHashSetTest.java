package com.atypon.chessgame;

import com.atypon.chessgame.utils.CachedLinkedHashSet;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CachedLinkedHashSetTest {
    @Test
    public void lastElementCheck() {
        CachedLinkedHashSet<Integer> set = new CachedLinkedHashSet<>();
        set.add(1);
        assertEquals((long) set.getLast(), 1);
        set.add(2);
        set.add(3);
        assertEquals((long) set.getLast(), 3);
        set.remove(3);
        assertEquals((long) set.getLast(), 2);
    }
}
