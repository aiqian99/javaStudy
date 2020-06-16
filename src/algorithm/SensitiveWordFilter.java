package algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description DFA算法实现敏感词过滤
 * @Author huangjw
 * @Date 2020/5/12 11:22
 */
public class SensitiveWordFilter {

    public static void main(String[] args) {
        String sensitiveWord = "中国人民:::操:::中国";
        long beginTime = System.currentTimeMillis();
        Map<String, Object> sensitiveWordMap = addSensitiveWordToHashMap(sensitiveWord);
        long endTime = System.currentTimeMillis();
        System.out.println("总共消耗时间为：" + (endTime - beginTime) + "ms");
        System.out.println(sensitiveWordMap);
        String text = "中国人民万岁啊操";
        text = filterSensitiveWord(text, sensitiveWordMap);
        System.out.println(text);
    }

    private static Map<String, Object> addSensitiveWordToHashMap(String keyWordSet) {
        String[] wordArr = keyWordSet.split(":::");
        Map<String, Object> sensitiveWordMap = new HashMap(wordArr.length);
        Map nowMap;
        Map<String, String> map;
        for (String word : wordArr) {
            nowMap = sensitiveWordMap;
            for (int i = 0; i < word.length(); i++) {
                char wordChar = word.charAt(i);
                Object wordMap = nowMap.get(wordChar);
                if (wordMap != null) {
                    nowMap = (Map) wordMap;
                } else {
                    map = new HashMap<>();
                    map.put("isEnd", "0");
                    nowMap.put(wordChar, map);
                    nowMap = map;
                }
                if (i == word.length() - 1) {
                    nowMap.put("isEnd", "1");
                }
            }
        }
        return sensitiveWordMap;
    }

    private static String filterSensitiveWord(String text, Map<String, Object> sensitiveWordMap) {
        ArrayList<String> strList = new ArrayList<>();
        String str = "";
        Map nowMap = sensitiveWordMap;
        text = text.replaceAll(" ", "");
        for (int i = 0; i < text.length(); i++) {
            char word = text.charAt(i);
            str += word;
            nowMap = (Map) nowMap.get(word);
            if (nowMap != null) {
                //  map 中存在该字
                if ("1".equals(nowMap.get("isEnd"))) {
                    // 词语结束 匹配到的词语加入列表
                    strList.add(str);
                }
            } else {
                //  不存在，判断下一个字
                nowMap = sensitiveWordMap;
                str = "";
                continue;
            }
        }
        // 将词语按字替换成 * 字符
        for (String s : strList) {
            int len = s.length();
            String replaceStr = "";
            for (int i = 0; i < len; i++) {
                replaceStr += "*";
            }
            text = text.replace(s, replaceStr);
        }
        return text;
    }

}
