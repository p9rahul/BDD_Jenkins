package com.test.MyRunner;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.Map;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(glue ={"StepDefination"},format = { "json:target/cucumber.json",
		"html:target/Reports" })
public class TestNGTestRunner extends AbstractTestNGCucumberTests {

	@Parameters({ "featureFile", "tags"})
	@BeforeTest
	public void setUpTest(String featurePath,String tags)
			throws Exception {
		System.out.println("---------------@BeforeTest----------------------");
		Class<?> testClass = this.getClass();
		featurePath="src/test/resources/"+featurePath;
		changeCucumberAnnotation(testClass, "features", new String[] { featurePath });
		changeCucumberAnnotation(testClass, "tags", new String[] { tags });
		
	}

	private static void changeCucumberAnnotation(Class<?> clazz, String key, Object newValue)
			throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		Annotation options = clazz.getAnnotation(CucumberOptions.class); 
		InvocationHandler proxyHandler = Proxy.getInvocationHandler(options); 																				
		Field f = proxyHandler.getClass().getDeclaredField("memberValues"); 
		f.setAccessible(true); // suppress any access issues when looking at f
		Map<String, Object> memberValues = (Map<String, Object>) f.get(proxyHandler); 
		memberValues.remove(key); 
		memberValues.put(key, newValue); 
	}
}
