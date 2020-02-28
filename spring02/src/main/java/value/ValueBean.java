package value;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class ValueBean {
    private String name;
    private int age;
    private List<String> list;
    private Set<String> city;
    private Map<String,Double> map;
    private Properties pt;
    
    public ValueBean(){
    	System.out.println("ValueBean()");
    }
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public List<String> getList() {
		return list;
	}
	public void setList(List<String> list) {
		this.list = list;
	}
	public Set<String> getCity() {
		return city;
	}
	public void setCity(Set<String> city) {
		this.city = city;
	}
	
	public Map<String, Double> getMap() {
		return map;
	}
	public void setMap(Map<String, Double> map) {
		this.map = map;
	}
	public Properties getPt() {
		return pt;
	}
	public void setPt(Properties pt) {
		this.pt = pt;
	}
	@Override
	public String toString() {
		return "ValueBean [name=" + name + ", age=" + age + ", list=" + list + ", city=" + city + ", map=" + map
				+ ", pt=" + pt + "]";
	}
	
}
