package form;

/**
 * Created by Виктор on 09.11.2014.
 */


import java.util.HashMap;
import java.util.Map;


public class Mapper {

    public Map getMap(Object key, Object value){
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put(key,value);
        return map;
    }
}
