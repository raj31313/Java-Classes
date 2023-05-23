package com.dal;

public class MyClass {

	private int variable1;
    private String variable2;
    
    public void setVariables(int var1, String var2) {
        variable1 = var1;
        variable2 = var2;
    }

    public void printVariables() {
        System.out.println("Variable 1: " + variable1);
        System.out.println("Variable 2: " + variable2);
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 MyClass instance1 = new MyClass();
	        MyClass instance2 = new MyClass();

	        instance1.setVariables(10, "Hello");
	        instance2.setVariables(20, "World");

	        instance1.printVariables();
	        instance2.printVariables();
	    

	}

}
