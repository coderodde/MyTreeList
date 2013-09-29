/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.helsinki.coderodde.util;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import org.apache.commons.collections.list.TreeList;
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
        printLine();
        System.out.println("testSize():");
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
        printLine();
        System.out.println("testIsEmpty():");
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
        printLine();
        System.out.println("testContains():");
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
        printLine();
        System.out.println("testRemove_Object():");
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
        assertTrue(list.isHealthy());
        assertTrue(list.isEmpty());
    }

    /**
     * Demonstrates the performance of the add(E e) method.
     */
    @Test
    public void testAddPerformance() {
        printLine();
        System.out.println("testAddPerformance():");
        final int N = 10000;
        LinkedList<Integer> linkedList = new LinkedList<Integer>();
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        MyTreeList<Integer> treeList = new MyTreeList<Integer>(10);
        TreeList enemyList = new TreeList();

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

        System.out.println("MyTreeList.add():    " + (tb - ta) + " ms.");

        ta = System.currentTimeMillis();
        for (int i = 0; i < N; i++) {
            enemyList.add(i);
        }
        tb = System.currentTimeMillis();

        System.out.println("TreeList.add():      " + (tb - ta) + " ms.");
    }


    @Test
    public void testRemoveObjectPerformance() {
        printLine();
        System.out.println("testRemoveObjectPerformance():");
        final int N = 10000;
        LinkedList<Integer> linkedList = new LinkedList<Integer>();
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        MyTreeList<Integer> treeList = new MyTreeList<Integer>(100);
        TreeList enemyList = new TreeList();

        for (int i = 0; i < N; i++) {
            linkedList.add(i);
            arrayList.add(i);
            treeList.add(i);
            enemyList.add(i);
        }

        long seed = System.currentTimeMillis();
        System.out.println("Seed: " + seed);
        /*
         * 1380383696220L
         */
        Random r = new Random(1380430164014L);
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
        System.out.println("MyTreeList.remove(Object):  " + (tb - ta) + " ms.");

        assertTrue(treeList.isHealthy());

        ta = System.currentTimeMillis();
        for (int i = 0; i < N; i++) {
            enemyList.remove((Integer) query[i]);
        }
        tb = System.currentTimeMillis();
        System.out.println("TreeList.remove(Object):    " + (tb - ta) + " ms.");

        assertTrue(treeList.isEmpty());
        assertTrue(treeList.isHealthy());
    }

    /**
     * Performance test of contains method, of class MyTreeList
     */
    @Test
    public void testContainsPerformance() {
        printLine();
        System.out.println("testCointainsPerformance():");
        LinkedList<Integer> linkedList = new LinkedList<Integer>();
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        MyTreeList<Integer> treeList = new MyTreeList<Integer>(100);
        TreeList enemyList = new TreeList();

        for (int i = 0; i < 10000; i++) {
            linkedList.add(i);
            arrayList.add(i);
            treeList.add(i);
            enemyList.add(i);
        }

        long seed = System.currentTimeMillis();
        System.out.println("Seed: " + seed);
        Random r = new Random(seed);

        long ta = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            int j = r.nextInt(10000);
            assertTrue(linkedList.contains(j));
        }
        long tb = System.currentTimeMillis();

        System.out.println("LinkedList.contains(): " + (tb - ta) + " ms.");

        r = new Random(seed);

        ta = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            int j = r.nextInt(10000);
            assertTrue(arrayList.contains(j));
        }
        tb = System.currentTimeMillis();

        System.out.println("ArrayList.contains():  " + (tb - ta) + " ms.");

        r = new Random(seed);

        ta = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            int j = r.nextInt(10000);
            assertTrue(treeList.contains(j));
        }
        tb = System.currentTimeMillis();

        System.out.println("MyTreeList.contains():  " + (tb - ta) + " ms.");

        r = new Random(seed);

        ta = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            int j = r.nextInt(10000);
            assertTrue(enemyList.contains(j));
        }
        tb = System.currentTimeMillis();

        System.out.println("TreeList.contains():    " + (tb - ta) + " ms.");
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
    public void testRemoveAllPerformance() {
        printLine();
        System.out.println("testRemoveAllPerformance():");
        LinkedList<Integer> linkedList = new LinkedList<Integer>();
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        MyTreeList<Integer> treeList = new MyTreeList<Integer>(100);
        TreeList enemyList = new TreeList();

        LinkedList<Integer> c = new LinkedList<Integer>();
        boolean add = true;
        for (int i = 0; i < 10000; i++) {
            linkedList.add(i);
            arrayList.add(i);
            treeList.add(i);
            enemyList.add(i);

            if (add == true) {
                c.add(i);
                add = false;
            } else {
                add = true;
            }
        }

        assertTrue(treeList.isHealthy());
        assertEquals(10000, treeList.size());
        assertFalse(treeList.isEmpty());

        long ta = System.currentTimeMillis();
        linkedList.removeAll(c);
        long tb = System.currentTimeMillis();
        System.out.println("LinkedList.removeAll(): " + (tb - ta) + " ms.");

        ta = System.currentTimeMillis();
        arrayList.removeAll(c);
        tb = System.currentTimeMillis();
        System.out.println("ArrayList.removeAll():  " + (tb - ta) + " ms.");

        ta = System.currentTimeMillis();
        treeList.removeAll(c);
        tb = System.currentTimeMillis();
        System.out.println("MyTreeList.removeAll():   " + (tb - ta) + " ms.");

        ta = System.currentTimeMillis();
        enemyList.removeAll(c);
        tb = System.currentTimeMillis();
        System.out.println("TreeList.removeAll():   " + (tb - ta) + " ms.");

        assertEquals(5000, treeList.size());
        assertTrue(treeList.isHealthy());
    }

    /**
     * Tests the <code>removeAll()</code> method.
     */
    @Test
    public void testRemoveAll() {
        printLine();
        System.out.println("testRemoveAll():");
        List<Integer> c = new LinkedList<Integer>();
        long seed = System.currentTimeMillis();
        Random r = new Random(seed);
        MyTreeList<Integer> list = new MyTreeList<Integer>(3);
        for (int i = 0; i < 32; i++) {
            int number = r.nextInt();
            list.add(number);
            list.add(number + 1);
            c.add(number);
        }
        assertTrue(list.removeAll(c));
        assertTrue(list.isHealthy());
        assertTrue(list.size() < 64);
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
        printLine();
        System.out.println("testClear():");
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
        printLine();
        System.out.println("testGet():");
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

    public static void printLine() {
        System.out.println(
                "----------------------------------------" +
                "----------------------------------------");
    }
}
