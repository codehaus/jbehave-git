/*
 * Created on 27-Dec-2003
 * 
 * (c) 2003-2004 ThoughtWorks
 * 
 * See license.txt for license details
 */
package jbehave.evaluate.listener;

import jbehave.evaluate.Evaluator;
import jbehave.framework.CriteriaVerifier;
import jbehave.framework.Result;


/**
 * As we were driving through a mountain pass in the middle of the Karoo,
 * it occurred to me that the <tt>BehaviourRunner</tt> shouldn't really
 * have its own <tt>Writer</tt>. Then I thought about modelling the
 * run in terms of events, and suddenly everything fell into place.<br>
 * <br>
 * Of course, I could have worked it out much easier by looking at the JUnit
 * code, but I wanted to develop this in the spirit of BDD to see how it
 * evolved. In the words of Dr Frank N Furter, I removed the cause, but not
 * the sympoms.
 * 
 * @author <a href="mailto:dan@jbehave.org">Dan North</a>
 */
public interface Listener {
    void runStarted(Evaluator runner);
    void runEnded(Evaluator runner);
    void behaviourEvaluationStarted(Class behaviourClass);
    void behaviourEvaluationEnded(Class behaviourClass);
    void beforeCriterionEvaluationStarts(CriteriaVerifier behaviour);
    void afterCriterionEvaluationEnds(Result behaviourResult);
}