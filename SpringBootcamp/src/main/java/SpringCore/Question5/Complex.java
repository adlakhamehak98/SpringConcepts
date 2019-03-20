package SpringCore.Question5;

//Create Class Complex as follows: class complex {    List list;
//           Set set;
//
//          Map map;
//
//          } Initialize all the instance variables of the complex class using Spring XML.
// Give bean name as complexBean.
// Get the bean and display the properties.

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Complex {
    List list;
    Set set;
    Map map;

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

    public Set getSet() {
        return set;
    }

    public void setSet(Set set) {
        this.set = set;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }
}
