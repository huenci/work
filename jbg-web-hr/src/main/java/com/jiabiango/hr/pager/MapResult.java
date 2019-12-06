package com.jiabiango.hr.pager;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class MapResult<K,V> extends PageParam {
    private int total;
    private Map<K,V> map = Collections.emptyMap();
    
    public int getTotal() {
        return total;
    }
    public void setTotal(int total) {
        this.total = total;
    }
    public Map<K,V> getMap() {
        return map;
    }
    public void setMap(Map<K,V> map) {
        this.map = map;
    }

}
