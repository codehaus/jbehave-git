/*
 * Created on 19-Jul-2004
 * 
 * (c) 2003-2004 ThoughtWorks
 * 
 * See license.txt for licence details
 */
package jbehave.extensions;

import jbehave.listeners.CompositeListener;
import jbehave.listeners.TextListener;
import jbehave.extensions.jmock.listener.JMockListener;
import jbehave.framework.SpecVerifier;

import java.io.OutputStreamWriter;

/**
 * @author <a href="mailto:damian.guy@thoughtworks.com">Damian Guy</a>
 *         Date: 19-Jul-2004
 */
public class JMockSpecVerifier {
	public static void main(String [] args) throws Exception {
		CompositeListener listener = new CompositeListener();
		listener.add(new JMockListener());
		listener.add(new TextListener(new OutputStreamWriter(System.out)));
		new SpecVerifier(Class.forName(args[0])).verifySpec(listener);
	}
}