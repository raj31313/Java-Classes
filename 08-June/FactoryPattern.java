package designpattern;

interface Nature {
	void green();
}

class Birds implements Nature{
	public void green() {
		System.out.println("Birds are in various colors");
	}
}

class Mountain implements Nature{
	public void green() {
		System.out.println("Mountains makes the nature beautiful");
	}
}

class Flowers implements Nature{
	public void green() {
		System.out.println("Flowers gives you more happiness and good smell");
	}
}

class NatureFactory{
	public Nature getCategory(String nature)
	{
		if(nature == null)
		{
			return null;
		}
		if(nature.equalsIgnoreCase("Birds"))
		{
			return new Birds();
		}
		else if(nature.equalsIgnoreCase("Mountain"))
		{
			return new Mountain();
		}
		else if(nature.equalsIgnoreCase("Flowers"))
		{
			return new Flowers();
		}
		return null;
	}
}

public class FactoryPattern {

	public static void main(String[] args)
	{
		NatureFactory naturefactory = new NatureFactory();
		
		Nature category1 = naturefactory.getCategory("Birds");
		category1.green();
		
		Nature category2 = naturefactory.getCategory("Mountain");
		category2.green();
		
		Nature category3 = naturefactory.getCategory("Flowers");
		category3.green();
	}

}
