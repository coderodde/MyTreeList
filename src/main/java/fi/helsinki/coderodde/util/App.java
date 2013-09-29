package fi.helsinki.coderodde.util;

import java.util.ArrayList;
import java.util.LinkedList;
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
    }
}
