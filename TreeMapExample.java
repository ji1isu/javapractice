import java.util.Map;
import java.util.TreeMap;
import java.util.Arrays;

public class TreeMapExample {
    static Double[] m_revenues = {1.0, 2.0, 3.0, 1.0};


    public static void main(String[] args) {
        // TreeMap 생성
        Map<String, Double> treeMap = new TreeMap<>();

        Map<String, Double> resultTreeMap = new TreeMap<>();

        // 데이터 추가
        treeMap.put("D", 1.0);
        treeMap.put("C", 2.0);
        treeMap.put("B", 3.0);
        treeMap.put("A", 1.0);

        // TreeMap은 자동으로 키를 알파벳 순으로 정렬합니다
        System.out.println("Sorted TreeMap:");
        for (Map.Entry<String, Double> entry : treeMap.entrySet()) {
            // System.out.println(entry.getKey() + ": " + entry.getValue());
            if (entry.getValue() <= 2.0)
            {
                resultTreeMap.put(entry.getKey(), entry.getValue());
            }
        }

        for (Map.Entry<String, Double> entry : resultTreeMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        Arrays.sort(m_revenues);
        for (Double num : m_revenues) {
            System.out.println(num);
        }
    }
}
//ca;lculate revenue first
