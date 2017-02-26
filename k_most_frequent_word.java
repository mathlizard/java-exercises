
import java.util.Comparator;
import java.util.Queue;
import java.util.PriorityQueue;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

class k_most_frequent_word {

// prints the k most frequent words from corpus

  public static void k_most_frequent_words(List<String> corpus, int K) {
    Map<String,Integer> table = new HashMap<String,Integer>();
    for(String s : corpus)
      table.put(s,table.getOrDefault(s, 0) + 1);
    Queue<Map.Entry<String,Integer>> pri_que = new PriorityQueue<Map.Entry<String,Integer>>(
                                                                                            table.size(),
                                                                                            (x,y) -> y.getValue().compareTo(x.getValue())
                                                                                            );
    for(Map.Entry<String,Integer> a : table.entrySet())
      pri_que.add(a);
    try{
      for(int i = 0; i < K; ++i)
        System.out.println(pri_que.remove().getKey());
    }catch(Exception e){
      System.out.println("No more words!");
    }
  }

 public static void test() {
    List<String> my_list = new ArrayList<>();
    my_list.add("a");
    my_list.add("b");
    my_list.add("C");
    my_list.add("a");
    my_list.add("b");
    my_list.add("a");
    k_most_frequent_words(my_list,4);
  }

}
