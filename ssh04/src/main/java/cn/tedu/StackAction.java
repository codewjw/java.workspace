package cn.tedu;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.util.ValueStack;

@Controller
@Scope("prototype")
public class StackAction {
  
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	} 
	
	public String doStack(){
		System.out.println("StackAction.doStack()");
		ActionContext ctx = ActionContext.getContext();
		ValueStack stack = ctx.getValueStack();
		message = "test";
		Person p = new Person(1,"chen","hello world!");
		//向ValueStack中添加数据
		stack.push(p);
	    ctx.getSession().put("name", "joy");
		return "success";
	}
}
