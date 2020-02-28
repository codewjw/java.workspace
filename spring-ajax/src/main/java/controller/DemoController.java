package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/demo")
public class DemoController {

   @RequestMapping("/array.do")
   @ResponseBody
   //@ResponseBody会自动的将返回结果中的javabean转换为
   //JSON字符串发送到浏览器客户端,底层用了jackson的API
   public Object test(){
	   String[] args = {"李红和","熊大","熊二"};
	   return args;
   }
   
   @RequestMapping("/foo.do")
   @ResponseBody
   public Foo test2(){
	   Foo  foo = new Foo(14,"tony",1000.8);
	   return foo;
   }
   
   @RequestMapping("/foolist.do")
   @ResponseBody
   public List<Foo> test3(){
	   List<Foo> foos = new ArrayList<Foo>();
	   Foo  foo = new Foo(14,"tony",1000.8);
	   foos.add(foo);
	   Foo fo = new Foo(30,"jack",8000.9);
	   foos.add(fo);
	   return foos;
   }
   
   @RequestMapping("/mapfoo.do")
   @ResponseBody
   public Map test4(){
	   Map<String,Foo> foos = new LinkedHashMap<String,Foo>();
	   Foo  foo = new Foo(14,"tony",1000.8);
	   foos.put("foo1", foo);
	   Foo fo = new Foo(30,"jack",8000.9);
	   foos.put("foo2", fo);
	   return foos;
   }
   
   @RequestMapping("/mapfoo5.do")
   @ResponseBody
   public Map test5(){
	   Map<String,Object> foomap = new HashMap<String,Object>();
	   Foo  foo = new Foo(14,"tony",1000.8);
	   foomap.put("age", foo.getAge());
	   foomap.put("name", foo.getName());
	   foomap.put("price", foo.getPrice());
	   return foomap;
   }
   
   @RequestMapping("/listMap.do")
   @ResponseBody
   public Object test6(){
	   List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
	   Map<String,Object> map1 = new LinkedHashMap<String,Object>();
	   map1.put("age", 5);
	   map1.put("name", "chen");
	   map1.put("price", 18.8);
	   list.add(map1);
	   map1 = new LinkedHashMap<String,Object>();
	   map1.put("age", 7);
	   map1.put("name", "huang");
	   map1.put("price", 190.9);
	   list.add(map1);
	   map1 = new LinkedHashMap<String,Object>();
	   map1.put("age", 19);
	   map1.put("name", "zhang");
	   map1.put("price", 200.8);
	   list.add(map1);
	   return list;
	   
   }
}
