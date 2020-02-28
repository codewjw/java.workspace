package cn.tedu;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller
@Scope("prototype")
public class SwitchAction {
    private Integer num;
    
	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public String doSwitch(){
		return num.toString();
	}
}
