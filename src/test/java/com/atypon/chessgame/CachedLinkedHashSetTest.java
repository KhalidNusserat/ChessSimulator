package com.atypon.chessgame;

import com.atypon.chessgame.utils.CachedLinkedHashSet;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CachedLinkedHashSetTest {
    @Test
    void lastElementCheck() {
        CachedLinkedHashSet<Integer> set = new CachedLinkedHashSet<>();
        set.add(1);
        assertEquals(set.getLast(), 1);
        set.add(2);
        set.add(3);
        assertEquals(set.getLast(), 3);
        set.remove(3);
        assertEquals(set.getLast(), 2);
    }
}
