package autowire;

public class Boo {
    
	//������foo
	private Foo foo;
	
	public Boo() {
		System.out.println("Boo()");
	}
	
	public void setFoo(Foo foo){
		System.out.println("setFoo(foo)");
		this.foo = foo;
	}

	@Override
	public String toString() {
		return "Boo [foo=" + foo + "]";
	}
	
	
}
