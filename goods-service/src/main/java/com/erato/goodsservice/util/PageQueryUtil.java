package com.erato.goodsservice.util;

import lombok.Data;
import lombok.ToString;

import java.util.LinkedHashMap;
import java.util.Map;

@Data
@ToString
public class PageQueryUtil extends LinkedHashMap<String, Object> {

    int page;
    int limit;

    public PageQueryUtil(Map<String, Object> params) {

        this.putAll(params);

        this.page = (Integer) params.get("page");
        this.limit = (Integer) params.get("limit");
//        this.page = Integer.parseInt(params.get("page").toString());
//        this.limit = Integer.parseInt(params.get("limit").toString());

        this.put("page", page);
        this.put("limit", limit);
        this.put("start", (page-1)*limit);
    }
}
