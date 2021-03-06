package fi.helsinki.coderodde.util;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import org.apache.commons.collections.list.TreeList;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {
        MyTreeList<Integer> list = new MyTreeList<Integer>(1);

        System.out.println(list.isEmpty());
        boolean b = list.isHealthy();
        System.out.println(list.isHealthy());

        list.add(1);

        System.out.println(list.isEmpty());
        System.out.println(list.isHealthy());

        list.clear();

        System.out.println(list.isEmpty());
        System.out.println(list.isHealthy());

        String yo = "Hello, y'all!";
        String sayonara = "Gomen nasai, demoo sayonara, ahondara! ^^";
        MyTreeList<String> list2 = new MyTreeList<String>(1);
        list2.add(yo);
        System.out.println(list2.contains(yo));
        System.out.println(list2.contains(sayonara));

        System.out.println("clear and size()");
        list2.clear();
        System.out.println(list2.isEmpty());
        System.out.println(list2.isHealthy());
        System.out.println(list2.size());

        System.out.println("---");
        MyTreeList<Integer> list3 = new MyTreeList<Integer>(1);
        for (int i = 0; i < 10; i++) {
            list3.add(i);
        }
        System.out.println(list3.size());
        list.clear();
        System.out.println(list3.size());
        System.out.println(list3.isEmpty());
        System.out.println("get()");
        MyTreeList<Integer> list4 = new MyTreeList<Integer>(2);
        for (int i = 0; i < 10; i++) {
            list4.add(i);
        }
        System.out.println(list4.isHealthy());
        for (int i = 0; i < 10; i++) {
            System.out.println(list4.get(i));
        }
        System.out.println(list4.isHealthy());

        System.out.println("remove(Object)");
        MyTreeList<Integer> list5 = new MyTreeList<Integer>(2);

        for (int i = 0; i < 6; i++) {
            list5.add(i);
        }

        list5.remove((Integer) 2);
        list5.remove((Integer) 3);
        list5.remove((Integer) 5);
        list5.remove((Integer) 4);
        list5.remove((Integer) 1);
        list5.remove((Integer) 0);
        System.out.println(list5.isHealthy());

        System.out.println("removeAll():");

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

            if (add = true) {
                c.add(i);
                add = false;
            } else {
                add = true;
            }
        }

        System.out.println(treeList.isHealthy());
        System.out.println(treeList.size());
        System.out.println(treeList.isEmpty());

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

        System.out.println("Healthy: " + treeList.isHealthy());
        System.out.println("size: " + treeList.size());

        c = new LinkedList<Integer>();
        long seed = System.currentTimeMillis();
        System.out.println("Seed: " + seed);
        Random r = new Random(seed);
        MyTreeList<Integer> list6 = new MyTreeList<Integer>(3);
        for (int i = 0; i < 32; i++) {
            int number = r.nextInt();
            list6.add(number);
            list6.add(number + 1);
        }
        list.removeAll(c);
        list.isHealthy();

        System.out.println("testRemoveObjectPerformance():");
        final int N = 10000;
        LinkedList<Integer> linkedList2 = new LinkedList<Integer>();
        ArrayList<Integer> arrayList2 = new ArrayList<Integer>();
        MyTreeList<Integer> treeList2 = new MyTreeList<Integer>(100);
        TreeList enemyList2 = new TreeList();

        for (int i = 0; i < N; i++) {
            linkedList2.add(i);
            arrayList2.add(i);
            treeList2.add(i);
            enemyList2.add(i);
        }

        seed = System.currentTimeMillis();
        System.out.println("Seed: " + seed);
        /*
         * 1380383696220L
         */
        r = new Random(1380430164014L);
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

        ta = System.currentTimeMillis();
        for (int i = 0; i < N; i++) {
            linkedList2.remove((Integer) query[i]);
        }
        tb = System.currentTimeMillis();
        System.out.println("LinkedList.remove(Object): " + (tb - ta) + " ms.");

        ta = System.currentTimeMillis();
        for (int i = 0; i < N; i++) {
            arrayList2.remove((Integer) query[i]);
        }
        tb = System.currentTimeMillis();
        System.out.println("ArrayList.remove(Object):   " + (tb - ta) + " ms.");

        ta = System.currentTimeMillis();
        for (int i = 0; i < N; i++) {
            treeList2.remove((Integer) query[i]);
        }
        tb = System.currentTimeMillis();

        System.out.println("MyTreeList.remove(Object):  " + (tb - ta) + " ms.");
        System.out.println("Healthy: " + treeList2.isHealthy());

        ta = System.currentTimeMillis();
        for (int i = 0; i < N; i++) {
            enemyList2.remove((Integer) query[i]);
        }
        tb = System.currentTimeMillis();
        System.out.println("TreeList.remove(Object):  " + (tb - ta) + " ms.");

        System.out.println(treeList.isHealthy());
    }
}
