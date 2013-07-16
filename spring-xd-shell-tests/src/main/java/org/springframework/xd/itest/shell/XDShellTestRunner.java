package org.springframework.xd.itest.shell;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.springframework.shell.AbstractShellTest;
import org.springframework.shell.CommandResult;
import org.springframework.test.context.ContextConfiguration;

/**
 * Integration test runner
 * 
 * @author Ilayaperumal Gopinathan
 * 
 */
@ContextConfiguration({ "classpath:/META-INF/itest/shell/xd-shell-path-test-context.xml" })
public class XDShellTestRunner extends AbstractShellTest {
	
	@Test
	public void runShellTest(){
		String command = "stream create";
		CommandResult cr = shell.exec(command);
        
        String outputText = cr.getOutputText();

        assertNotNull("Output text for '" + command + "' command shouldn't be null.", outputText);
        assertTrue(outputText.contains(command));
        verifySuccess(cr);
	}

}
