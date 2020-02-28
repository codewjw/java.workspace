package controller;

import java.io.Serializable;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

public class Foo implements Serializable {
	   private Integer age;
	   private String name;
	   private Double price;
	   
		public Foo() {	
		}
		
		public Foo(Integer age, String name, Double price) {
			super();
			this.age = age;
			this.name = name;
			this.price = price;
		}

		public Integer getAge() {
			return age;
		}
		public void setAge(Integer age) {
			this.age = age;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public Double getPrice() {
			return price;
		}
		public void setPrice(Double price) {
			this.price = price;
		}
		
		@Override
		public String toString() {
			return "Foo [age=" + age + ", name=" + name + ", price=" + price + "]";
		}
	   
		
	   
}
