package fi.helsinki.coderodde.util;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {
        MyTreeList<Integer> list = new MyTreeList<Integer>(2);

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
    }
}
