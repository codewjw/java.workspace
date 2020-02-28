package value;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class DemoBean {
	   private List<String> names;
	   private Set<String> cities;
	   private Map<String,Double> score;
	   private Properties props;
	   
	public DemoBean() {
		System.out.println("DemoBean()");
	}

	public List<String> getNames() {
		return names;
	}

	public void setNames(List<String> names) {
		this.names = names;
	}

	public Set<String> getCities() {
		return cities;
	}

	public void setCities(Set<String> cities) {
		this.cities = cities;
	}

	public Map<String, Double> getScore() {
		return score;
	}

	public void setScore(Map<String, Double> score) {
		this.score = score;
	}

	public Properties getProps() {
		return props;
	}

	public void setProps(Properties props) {
		this.props = props;
	}

	@Override
	public String toString() {
		return "DemoBean [names=" + names + ", cities=" + cities + ", score=" + score + ", props=" + props + "]";
	}

	
	
       
}
