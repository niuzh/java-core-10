package ch09;

import java.util.*;

/**
 * This program sorts a set of item by comparing their descriptions.
 * @version 1.12 2015-06-21
 * @author Cay Horstmann
 */
public class TreeSetTest
{
   public static void main(String[] args)
   {
      SortedSet<Item> parts = new TreeSet<>();
      parts.add(new Item("Toaster", 1234));
      parts.add(new Item("Widget", 4562));
      parts.add(new Item("Modem", 9912));
      System.out.println(parts);
//第二个通过使用一个定制的比较器来按照描述信息排序 。
      NavigableSet<Item> sortByDescription = new TreeSet<>(
            Comparator.comparing(Item::getDescription));

      sortByDescription.addAll(parts);
      System.out.println(sortByDescription);
   }
}