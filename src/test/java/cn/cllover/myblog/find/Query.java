package cn.cllover.myblog.find;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Query {
    static List<Map<String, Object>> childCategoryList = new ArrayList<Map<String, Object>>();

    public static void main(String[] args) {
        List<Map<String, Object>> allCategoryList = new ArrayList<Map<String,Object>>();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("auId", "0");
        map.put("parentId", "-1");
        Map<String, Object> map1 = new HashMap<String, Object>();
        map1.put("auId", "1");
        map1.put("parentId", "0");
        Map<String, Object> map2 = new HashMap<String, Object>();
        map2.put("auId", "2");
        map2.put("parentId", "1");
        Map<String, Object> map3 = new HashMap<String, Object>();
        map3.put("auId", "3");
        map3.put("parentId", "2");
        Map<String, Object> map4 = new HashMap<String, Object>();
        map4.put("auId", "4");
        map4.put("parentId", "3");
        Map<String, Object> map5  = new HashMap<String, Object>();
        map5.put("auId", "44");
        map5.put("parentId", "3");
        Map<String, Object> map6  = new HashMap<String, Object>();
        map6.put("auId", "55");
        map6.put("parentId", "4");
        map6.put("parentId", "5555");
        allCategoryList.add(map);
        allCategoryList.add(map1);
        allCategoryList.add(map2);
        allCategoryList.add(map3);
        allCategoryList.add(map4);
        allCategoryList.add(map5);
        allCategoryList.add(map6);
        String categoryAuId = "0";
        childCategoryList = new ArrayList<Map<String,Object>>();
        List<Map<String, Object>> rMap = getChildCategory(allCategoryList, categoryAuId);
        System.out.println("rMap=" + rMap);
    }

    public static List<Map<String, Object>> getChildCategory(List<Map<String, Object>> allCategoryList, String categoryAuId){
        for (Map<String, Object> category : allCategoryList) {
            // 判断是否存在子节点
            if (category.get("parentId").toString().equals(categoryAuId)) {
                // 递归遍历下一级
                Object list  = category.get("parentId");
                getChildCategory(allCategoryList, category.get("auId").toString());
                childCategoryList.add(category);
                System.out.println(list);

            }
        }
        System.out.println("childCategoryList=" + childCategoryList);
        return childCategoryList;
    }


}
