/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.helsinki.coderodde.util;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * This class tests <code>TreeList2</code>.
 */
public class MyTreeListTest {

    /**
     * Test of size method, of class MyTreeList.
     */
    @Test
    public void testSize() {
        MyTreeList<String> list = new MyTreeList<String>(2);
        list.add("Hello");
        list.add("World");
        assertEquals(2, list.size());
        assertTrue(list.isHealthy());
    }

    /**
     * Test of isEmpty method, of class MyTreeList.
     */
    @Test
    public void testIsEmpty() {
        MyTreeList<Integer> list = new MyTreeList<Integer>(2);

        assertTrue(list.isEmpty());
        assertTrue(list.isHealthy());

        list.add(1);

        assertFalse(list.isEmpty());
        assertTrue(list.isHealthy());
    }

    /**
     * Test of contains method, of class MyTreeList.
     */
    @Test
    public void testContains() {
        String yo = "Hello, y'all!";
        String sayonara = "Gomen nasai, demoo sayonara, ahondara! ^^";
        MyTreeList<String> list = new MyTreeList<String>(1);
        list.add(yo);
        assertTrue(list.contains(yo));
        assertFalse(list.contains(sayonara));
    }

    /**
     * Test of iterator method, of class MyTreeList.
     */
    @Test
    public void testIterator() {
    }

    /**
     * Test of toArray method, of class MyTreeList.
     */
    @Test
    public void testToArray_0args() {
    }

    /**
     * Test of toArray method, of class MyTreeList.
     */
    @Test
    public void testToArray_GenericType() {
    }

    /**
     * Test of add method, of class MyTreeList.
     */
    @Test
    public void testAdd_GenericType() {
    }

    /**
     * Test of remove method, of class MyTreeList.
     */
    @Test
    public void testRemove_Object() {
        MyTreeList<Integer> list = new MyTreeList<Integer>(2);

        for (int i = 0; i < 6; i++) {
            list.add(i);
        }

        assertTrue(list.isHealthy());
        assertEquals(6, list.size());
        assertTrue(list.remove((Integer) 3));
        assertEquals(5, list.size());
        assertTrue(list.remove((Integer) 2));
        assertEquals(4, list.size());
        assertTrue(list.isHealthy());
        assertFalse(list.remove((Integer) 6));
        assertTrue(list.isHealthy());
        assertTrue(list.remove((Integer) 4));
        assertTrue(list.isHealthy());
        assertTrue(list.remove((Integer) 5));
        assertTrue(list.isHealthy());
        assertTrue(list.remove((Integer) 1));
        assertTrue(list.isHealthy());
        assertTrue(list.remove((Integer) 0));
//        assertTrue(list.isHealthy());
        assertTrue(list.isEmpty());
    }

    @Test
    public void testAddPerformance() {
        final int N = 10000;
        LinkedList<Integer> linkedList = new LinkedList<Integer>();
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        MyTreeList<Integer> treeList = new MyTreeList<Integer>(10);

        long ta = System.currentTimeMillis();
        for (int i = 0; i < N; i++) {
            linkedList.add(i);
        }
        long tb = System.currentTimeMillis();

        System.out.println("LinkedList.add(): " + (tb - ta) + " ms.");

        ta = System.currentTimeMillis();
        for (int i = 0; i < N; i++) {
            arrayList.add(i);
        }
        tb = System.currentTimeMillis();

        System.out.println("ArrayList.add():   " + (tb - ta) + " ms.");

        ta = System.currentTimeMillis();
        for (int i = 0; i < N; i++) {
            treeList.add(i);
        }
        tb = System.currentTimeMillis();

        System.out.println("TreeList.add():    " + (tb - ta) + " ms.");
    }

    @Test
    public void testRemoveObjectPerformance() {
        final int N = 10000;
        LinkedList<Integer> linkedList = new LinkedList<Integer>();
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        MyTreeList<Integer> treeList = new MyTreeList<Integer>(100);

        for (int i = 0; i < N; i++) {
            linkedList.add(i);
            arrayList.add(i);
            treeList.add(i);
        }

        Random r = new Random();
        Integer[] query = new Integer[N];
        for (int i = 0; i < N; i++) {
            query[i] = i;
        }

        for (int i = 0; i < N; i++) {
            int from = r.nextInt(N);
            int to = r.nextInt(N);
            Integer tmp = query[from];
            query[from] = query[to];
            query[to] = tmp;
        }

        long ta = System.currentTimeMillis();
        for (int i = 0; i < N; i++) {
            linkedList.remove((Integer) query[i]);
        }
        long tb = System.currentTimeMillis();
        System.out.println("LinkedList.remove(Object): " + (tb - ta) + " ms.");

        ta = System.currentTimeMillis();
        for (int i = 0; i < N; i++) {
            arrayList.remove((Integer) query[i]);
        }
        tb = System.currentTimeMillis();
        System.out.println("ArrayList.remove(Object):   " + (tb - ta) + " ms.");

        ta = System.currentTimeMillis();
        for (int i = 0; i < N; i++) {
            treeList.remove((Integer) query[i]);
        }
        tb = System.currentTimeMillis();
        System.out.println("TreeList.remove(Object):    " + (tb - ta) + " ms.");

        assertTrue(treeList.isHealthy());
    }

    /**
     * Test of containsAll method, of class MyTreeList.
     */
    @Test
    public void testContainsAll() {
    }

    /**
     * Test of addAll method, of class MyTreeList.
     */
    @Test
    public void testAddAll_Collection() {
    }

    /**
     * Test of addAll method, of class MyTreeList.
     */
    @Test
    public void testAddAll_int_Collection() {
    }

    /**
     * Test of removeAll method, of class MyTreeList.
     */
    @Test
    public void testRemoveAll() {
    }

    /**
     * Test of retainAll method, of class MyTreeList.
     */
    @Test
    public void testRetainAll() {
    }

    /**
     * Test of clear method, of class MyTreeList.
     */
    @Test
    public void testClear() {
        MyTreeList<Integer> list = new MyTreeList<Integer>(1);
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        assertEquals(10, list.size());
        assertTrue(list.isHealthy());
        list.clear();
        assertEquals(0, list.size());
        assertTrue(list.isEmpty());
        assertTrue(list.isHealthy());
    }

    /**
     * Test of get method, of class MyTreeList.
     */
    @Test
    public void testGet() {
        MyTreeList<Integer> list = new MyTreeList<Integer>(2);
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }

        for (int i = 0; i < 10; i++) {
            assertEquals(i, (int) list.get(i));
        }

        MyTreeList<Integer> list2 = new MyTreeList<Integer>(1);
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }

        for (int i = 0; i < 10; i++) {
            assertEquals(i, (int) list.get(i));
        }
    }

    /**
     * Test of set method, of class MyTreeList.
     */
    @Test
    public void testSet() {
    }

    /**
     * Test of add method, of class MyTreeList.
     */
    @Test
    public void testAdd_int_GenericType() {
    }

    /**
     * Test of remove method, of class MyTreeList.
     */
    @Test
    public void testRemove_int() {
    }

    /**
     * Test of lastIndexOf method, of class MyTreeList.
     */
    @Test
    public void testLastIndexOf() {
    }

    /**
     * Test of listIterator method, of class MyTreeList.
     */
    @Test
    public void testListIterator_0args() {
    }

    /**
     * Test of listIterator method, of class MyTreeList.
     */
    @Test
    public void testListIterator_int() {
    }

    /**
     * Test of subList method, of class MyTreeList.
     */
    @Test
    public void testSubList() {
    }

    /**
     * Test of indexOf method, of class MyTreeList.
     */
    @Test
    public void testIndexOf() {

    }
}
