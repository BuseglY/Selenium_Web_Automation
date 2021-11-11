import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;

import java.util.Optional;

public class TestLogger implements TestWatcher {

    Log log=new Log();

    @Override
    public void testDisabled(ExtensionContext context, Optional<String> reason) {

    }

    @Override
    public void testSuccessful(ExtensionContext context) {
        String testMethodName=context.getDisplayName();
        log.info(testMethodName+" Successfully");
    }

    @Override
    public void testAborted(ExtensionContext context, Throwable cause) {

    }

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        String testMethodName=context.getDisplayName();
        String testFailMessage=cause.getMessage();
        log.error(testMethodName+" Failed with cause : " + testFailMessage);
    }
}
