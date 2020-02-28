package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Bmi {
    
	
	@RequestMapping("toIndex.do")
	public String toIndex(){
		return "index";
	}
	
	@RequestMapping("deal.do")
	public String bmiIndex(IndexNum user,ModelMap mm){
		double bmi = (user.getWeight()/user.getHeight())/user.getHeight();
		String status;
		if(bmi>35){
			status = "过重";
		}else if(bmi>24){
			status = "微重";
		}else if(bmi>18){
			status = "正常";
		}else{
			status = "偏瘦";
		}
		mm.addAttribute("bmi", bmi);
		mm.addAttribute("status",status);
		return "result";
	}
}
