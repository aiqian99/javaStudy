package algorithm;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Description 基于物品的协同过滤算法
 * @Author snail
 */
public class ItemCF {

    public static void main(String[] args) {
        // 测试数据
        Map<String, Map<String, Integer>> trainData = new HashMap<String, Map<String, Integer>>(8) {{
            put("A", new HashMap<String, Integer>(8) {{
                put("i1", 5);
                put("i2", 5);
                put("i4", 5);
            }});
            put("B", new HashMap<String, Integer>() {{
                put("i1", 5);
                put("i4", 5);
            }});
            put("C", new HashMap<String, Integer>() {{
                put("i1", 5);
                put("i2", 5);
                put("i5", 5);
            }});
            put("D", new HashMap<String, Integer>() {{
                put("i2", 5);
                put("i3", 5);
            }});
            put("E", new HashMap<String, Integer>() {{
                put("i3", 5);
                put("i5", 5);
            }});
            put("F", new HashMap<String, Integer>() {{
                put("i2", 5);
                put("i4", 5);
            }});
        }};

        double alpha = 0.3;
        Map<String, Map<String, Double>> W = itemSimilarityCos(trainData);
        System.out.println("相似度:");
        W.forEach((key, value) -> {
            System.out.println(key + "：" + value);
        });
        String userId = "C";
        int K = 3;
        Map<String, Double> rank = recommend(trainData, userId, W, K);
        System.out.println("待推荐物品:");
        rank.forEach((key, value) -> {
            System.out.println(key + "：" + value);
        });
    }

    /**
     * @param trainData
     * @description: 基于共同喜欢物品的用户列表计算 ItemCF算法
     * @return: void
     */
    private static void itemSimilarity(Map<String, Map<String, Integer>> trainData) {
        // 物品对同时被喜欢的次数
        Map<String, Map<String, Integer>> C = new HashMap<>();
        // 物品被喜欢用户数
        Map<String, Integer> N = new HashMap<>();
        trainData.forEach((key1, value1) -> {
            value1.forEach((key2, value2) -> {
                if (!N.containsKey(key2)) {
                    N.put(key2, 0);
                }
                N.put(key2, N.get(key2) + 1);
                value1.forEach((key3, value3) -> {
                    if (!key2.equals(key3)) {
                        if (!C.containsKey(key2) || !C.get(key2).containsKey(key3)) {
                            Map<String, Integer> map = C.get(key2);
                            if (map == null) {
                                map = new HashMap<>();
                            }
                            map.put(key3, 0);
                            C.put(key2, map);
                        }
                        Map<String, Integer> map = C.get(key2);
                        map.put(key3, map.get(key3) + 1);
                        C.put(key2, map);
                    }
                });
            });
        });
        // 书本对相似分数
        Map<String, Map<String, Double>> W = new HashMap<>();
        C.forEach((key, value) -> {
            value.forEach((key2, value2) -> {
                Map<String, Double> map = W.get(key);
                if (map == null) {
                    map = new HashMap<>();
                }
                map.put(key2, value2 / Math.sqrt(N.get(key) * N.get(key2)));
                W.put(key, map);
            });
        });
    }

    /**
     * @param trainData
     * @description: 基于余弦的相似度计算  ItemCF-余弦算法
     * @return: void
     */
    private static Map<String, Map<String, Double>> itemSimilarityCos(Map<String, Map<String, Integer>> trainData) {
        // 物品对同时被喜欢的次数
        Map<String, Map<String, Integer>> C = new HashMap<>();
        // 物品被喜欢用户数
        Map<String, Integer> N = new HashMap<>();
        trainData.forEach((key1, value1) -> {
            value1.forEach((key2, value2) -> {
                if (!N.containsKey(key2)) {
                    N.put(key2, 0);
                }
                N.put(key2, N.get(key2) + value2 * value2);
                value1.forEach((key3, value3) -> {
                    if (!key2.equals(key3)) {
                        if (!C.containsKey(key2) || !C.get(key2).containsKey(key3)) {
                            Map<String, Integer> map = C.get(key2);
                            if (map == null) {
                                map = new HashMap<>();
                            }
                            map.put(key3, 0);
                            C.put(key2, map);
                        }
                        Map<String, Integer> map = C.get(key2);
                        map.put(key3, map.get(key3) + value2 * value3);
                        C.put(key2, map);
                    }
                });
            });
        });
        // 书本对相似分数
        Map<String, Map<String, Double>> W = new HashMap<>();
        C.forEach((key, value) -> {
            value.forEach((key2, value2) -> {
                Map<String, Double> map = W.get(key);
                if (map == null) {
                    map = new HashMap<>();
                }
                map.put(key2, value2 / (Math.sqrt(N.get(key)) * Math.sqrt(N.get(key2))));
                W.put(key, map);
            });
        });
        return W;
    }

    /**
     * @param trainData
     * @param alpha     当alpha在[0，0.5]中，N(i)越小，惩罚越厉害
     * @description: 热门物品的惩罚 改进算法
     * @return: void
     */
    private static Map<String, Map<String, Double>> itemSimilarityAlpha(Map<String, Map<String, Integer>> trainData, double alpha) {
        // 物品对同时被喜欢的次数
        Map<String, Map<String, Integer>> C = new HashMap<>();
        // 物品被喜欢用户数
        Map<String, Integer> N = new HashMap<>();
        trainData.forEach((key1, value1) -> {
            value1.forEach((key2, value2) -> {
                if (!N.containsKey(key2)) {
                    N.put(key2, 0);
                }
                N.put(key2, N.get(key2) + 1);
                value1.forEach((key3, value3) -> {
                    if (!key2.equals(key3)) {
                        if (!C.containsKey(key2) || !C.get(key2).containsKey(key3)) {
                            Map<String, Integer> map = C.get(key2);
                            if (map == null) {
                                map = new HashMap<>();
                            }
                            map.put(key3, 0);
                            C.put(key2, map);
                        }
                        Map<String, Integer> map = C.get(key2);
                        map.put(key3, map.get(key3) + 1);
                        C.put(key2, map);
                    }
                });
            });
        });
        // 书本对相似分数
        Map<String, Map<String, Double>> W = new HashMap<>();
        C.forEach((key, value) -> {
            value.forEach((key2, value2) -> {
                Map<String, Double> map = W.get(key);
                if (map == null) {
                    map = new HashMap<>();
                }
                map.put(key2, value2 / (Math.pow(N.get(key), alpha) * Math.pow(N.get(key2), 1 - alpha)));
                W.put(key, map);
            });
        });
        return W;
    }

    /**
     * @param trainData
     * @param userId    用户
     * @param w         相似度矩阵
     * @param k         选取相似度最高的K个
     * @description: 结合用户喜好对物品排序
     * @return: void
     */
    private static Map<String, Double> recommend(Map<String, Map<String, Integer>> trainData, String userId, Map<String, Map<String, Double>> w, int k) {
        // 待推荐物品
        Map<String, Double> rank = new HashMap<>();
        // userId用户喜欢的物品
        Map<String, Integer> ru = trainData.get(userId);
        ru.forEach((key, value) -> {
            // 待推荐物品相似度集合
            Map<String, Double> tmp = w.get(key).entrySet().stream()
                    .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                    .collect(Collectors.toMap(x -> x.getKey(), x -> x.getValue(), (x1, x2) -> x2, LinkedHashMap::new));
            int count = 1;
            for (String key2 : tmp.keySet()) {
                if (count > k) {
                    break;
                }
                count++;
                if (ru.containsKey(key2)) {
                    continue;
                }
                if (!rank.containsKey(key2)) {
                    rank.put(key2, Double.valueOf(0));
                }
                rank.put(key2, rank.get(key2) + tmp.get(key2) * value);
            }
        });
        return rank.entrySet().stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .collect(Collectors.toMap(x -> x.getKey(), x -> x.getValue(), (x1, x2) -> x2, LinkedHashMap::new));

    }
}
