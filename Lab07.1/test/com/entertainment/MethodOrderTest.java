/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.entertainment;

import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

/**
 * TODO: use an annotation(s) in this class to apply some control over the order of test execution.
 */
@FixMethodOrder(MethodSorters.JVM)
public class MethodOrderTest {
  @Rule
  public TestName name= new TestName();
  
  @Test
  public void shouldIOrderTheExecutionOfMyTests() {
    System.out.println(name.getMethodName());
  }
  
  @Test
  public void testSomething() {
    System.out.println(name.getMethodName());
  }

  @Test
  public void businessMethodShouldWorkCorrectly() {
    System.out.println(name.getMethodName());
  }
  
  @Test
  public void throwsExceptionIfUserDoesNotHaveSufficientPrivileges() {
    System.out.println(name.getMethodName());
  }
}