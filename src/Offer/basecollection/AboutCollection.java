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
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                // 里面写排序规则
                return o1 - o2;
            }
        });

        int[] arr = new int[5];
        Arrays.sort(arr); // 排序
    }

}
