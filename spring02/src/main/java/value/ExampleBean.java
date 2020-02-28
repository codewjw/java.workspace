package value;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class ExampleBean {
   private List<String> list;
   private Set<String> set;
   private Map<String,Double> map;
   private Properties pt;
   
	public ExampleBean() {
		System.out.println("ExampleBean()");
	}

	public List<String> getList() {
		return list;
	}

	public void setList(List<String> list) {
		this.list = list;
	}

	public Set<String> getSet() {
		return set;
	}

	public void setSet(Set<String> set) {
		this.set = set;
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
		return "ExampleBean [list=" + list + ", set=" + set + ", map=" + map + ", pt=" + pt + "]";
	}
   
}
