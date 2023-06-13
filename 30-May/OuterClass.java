package newpack;

abstract class AbstractClass{
	public abstract void abstractMethod();
}


class OuterClass
{
	static int i =10;
	int instanceVariable = 20;
	
	public void method()
	{
		System.out.println("i == " + ++i);
	}
	
	
	static class InnerClass extends AbstractClass
	{
		public void display()
		{
			System.out.println("i == " + i);
		}
		
		@Override
		public void abstractMethod() {
			System.out.println("Abstract method implementation");
		}
	}
	
	
	public static void main(String[] a)
        {
	OuterClass.InnerClass ic = new OuterClass.InnerClass();
	ic.display();

	OuterClass oc = new OuterClass();
	oc.method();
	}
}
