/*
 * Created on 11-Jul-2004
 * 
 * (c) 2003-2004 ThoughtWorks Ltd
 *
 * See license.txt for license details
 */
package jbehave.framework;

import java.util.ArrayList;
import java.util.List;

import jbehave.listeners.NullListener;


/** Listener that captures criteria verification results */
class RecordingListener extends NullListener {
    public Class startedSpec = null;
    public Class endedSpec = null;
    public List verifications = new ArrayList(); // all verifications
    public CriteriaVerification lastVerification = null; // latest one
    
    public CriteriaVerification criteriaVerificationEnding(CriteriaVerification verification, Object specInstance) {
        verifications.add(verification);
        lastVerification = verification;
		return verification;
    }

    public void specVerificationStarting(Class spec) {
        startedSpec = spec;
    }
    
    public void specVerificationEnding(Class spec) {
        endedSpec = spec;
    }
    
    public CriteriaVerification verification(int i) {
        return (CriteriaVerification) verifications.get(i);
    }
}