import static org.junit.Assert.assertEquals;

import com.sqli.challenge.OsFacade;
import org.junit.Test;

public class OsTest {
    @Test
    public void testrun() {
        OsFacade osFacade = new OsFacade();
        osFacade.createProcess("process1", "op1;op2;op2;op1");
        osFacade.run();
        assertEquals("<<process1>>op1<<process1>>op2<<process1>>op2<<process1>>op1", osFacade.getExecutionResult());
    }

    @Test
    public void testExecuteTwoProcess() {
        OsFacade osFacade = new OsFacade();
        osFacade.createProcess("process1", "op1;op2;op2;op1");
        osFacade.createProcess("process2", "op1;op1");
        osFacade.run();
        assertEquals("<<process1>>op1<<process1>>op2<<process1>>op2<<process1>>op1<<process2>>op1<<process2>>op1", osFacade.getExecutionResult());
    }

    @Test
    public void testExecuteTwoProcessWithRoundRobinWithQuantumOne() {
        OsFacade osFacade = new OsFacade();
        osFacade.useRoundRobin(1);
        osFacade.createProcess("process1", "op1;op2;op2;op1");
        osFacade.createProcess("process2", "op1;op1");
        osFacade.run();
        assertEquals("<<process1>>op1<<process2>>op1<<process1>>op2<<process2>>op1<<process1>>op2<<process1>>op1", osFacade.getExecutionResult());
    }

    @Test
    public void testExecuteTwoProcessWithRoundRobinWithQuantumTwo() {
        OsFacade osFacade = new OsFacade();
        osFacade.useRoundRobin(2);
        osFacade.createProcess("process1", "op1;op2;op2;op1");
        osFacade.createProcess("process2", "op1;op1");
        osFacade.run();
        assertEquals("<<process1>>op1<<process1>>op2<<process2>>op1<<process2>>op1<<process1>>op2<<process1>>op1", osFacade.getExecutionResult());
    }
}
