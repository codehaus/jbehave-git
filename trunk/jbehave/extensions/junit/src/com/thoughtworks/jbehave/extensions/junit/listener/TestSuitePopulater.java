/*
 * Created on 12-Aug-2004
 * 
 * (c) 2003-2004 ThoughtWorks Ltd
 *
 * See license.txt for license details
 */
package com.thoughtworks.jbehave.extensions.junit.listener;

import java.lang.reflect.Method;

import junit.framework.TestSuite;

import com.thoughtworks.jbehave.core.exception.JBehaveFrameworkError;
import com.thoughtworks.jbehave.core.listeners.ListenerSupport;
import com.thoughtworks.jbehave.extensions.junit.JUnitMethodAdapter;

/**
 * @author <a href="mailto:dan.north@thoughtworks.com">Dan North</a>
 */
public class TestSuitePopulater extends ListenerSupport {
    private final TestSuite[] suiteRef;
    private TestSuite currentSuite = null;
    private Class currentBehaviourClass;

    public TestSuitePopulater(TestSuite[] suiteRef) {
        this.suiteRef = suiteRef;
    }

    public void behaviourClassVerificationStarting(Class behaviourClass) {
        currentSuite = new TestSuite(behaviourClass.getName());
        if (suiteRef[0] == null) {
            suiteRef[0] = currentSuite;
        }
        else {
            suiteRef[0].addTest(currentSuite);
        }
        currentBehaviourClass = behaviourClass;
    }
    
    public void responsibilityVerificationStarting(Method responsibilityMethod) {
        try {
            Object instance = currentBehaviourClass.newInstance();
            currentSuite.addTest(new JUnitMethodAdapter(responsibilityMethod,
                    instance));
        } catch (Exception e) {
            String message = "Problem adding test for "
                + currentBehaviourClass.getName() + "." + responsibilityMethod.getName();
            throw new JBehaveFrameworkError(message, e);
        }
    }
}