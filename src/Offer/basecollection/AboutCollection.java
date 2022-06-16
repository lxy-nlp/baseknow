package Offer.basecollection;

import java.util.*;

/*集合框架在java中使用场景颇多*/
public class AboutCollection {

    /*
    * List
    * Set
    * Queue
    * SortedSet
    * */
    //Collection接口中的抽象函数
    // public boolean add()
    // {}
//    public boolean addAll(Collection);
//    public void clear();
//    public boolean contains();
//    TreeSet<>
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(3);
        list.add(1);
        list.add(6);
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                // 里面写排序规则
                return o1 - o2;
            }
        });
        for(Integer t : list)
        {
            System.out.println(t);
        }

//        int[] arr = new int[5];
//        Arrays.sort(arr); // 排序
////        Arrays.fill(arr,1);
//        HashMap<Integer,String> map = new HashMap<>();
//        map.put(1,"111");
//        map.put(2,"222");
//        map.put(3,"333");
//        String s = map.getOrDefault(4,"-----");
//        System.out.println(s);
//        // HashMap的遍历方式
//        // HashMap中的键值对存储在entrySet中
//        Set<Map.Entry<Integer,String>> allset = map.entrySet();
//        for(Map.Entry<Integer,String> tmp : map.entrySet())
//        {
//            System.out.println(tmp.getKey() + " " + tmp.getValue());
//        }
//
//        // map.keySet(); 获取所有的key map.values();  获取所有的values
//
//
//        // Iterator 迭代  这种方法是通用的
//        Iterator<Map.Entry<Integer,String>> entryIterator = map.entrySet().iterator();
//        while(entryIterator.hasNext())
//        {
//            Map.Entry<Integer,String> tmp = entryIterator.next();
//
//            System.out.println(tmp.getKey() + " " + tmp.getValue());
//        }

    }

}
