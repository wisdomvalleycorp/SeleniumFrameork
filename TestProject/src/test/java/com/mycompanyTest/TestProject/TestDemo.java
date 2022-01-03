package com.mycompanyTest.TestProject;

import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;

@Listeners(listner.Listners.class)
public class TestDemo {
	
	@Test()
	public void test1(){
		System.out.println("in test1");
	}
	
	@Test()
	public void test2(){
		System.out.println("in test2");
		//SoftAssert asert = new SoftAssert() ;
		//asert.assertTrue(false);
		//Assert.assertTrue(0>1);
		//Assert.fail();
		//System.out.println("Test2 failed");
	}
	
	@Test()
	public void test3(){
		System.out.println("in test3");
	}
	
	@Test()
	public void test4(){
		System.out.println("in test4");
	}

}
