/*
 * Created on 29-Jan-2004
 * 
 * (c) 2003-2004 ThoughtWorks
 * 
 * See license.txt for licence details
 */
package jbehave.runner.listener;

import jbehave.framework.Verify;


/**
 * @author <a href="mailto:dan@jbehave.org">Dan North</a>
 * @author <a href="mailto:geoff@jbehave.org">Geoff Oliphant</a>
 */
public class TimerBehaviours {
    public void shouldMeasureAPeriodOfTime() throws Exception {
        Timer timer = new Timer();
        long startTime = System.currentTimeMillis();
        timer.start();
        
        // Wait a bit
        Thread.sleep(5);
        
        timer.stop();
        long elapsed = System.currentTimeMillis() - startTime;
        Verify.equal(elapsed, timer.getElapsedTime(), 1.0);
        
    }
}