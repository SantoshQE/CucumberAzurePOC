package Config;

import Utils.TestUtil;
import junit.framework.AssertionFailedError;
import junit.framework.Test;
import junit.framework.TestListener;
import org.apache.commons.logging.Log;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestReporter;
import org.junit.jupiter.api.extension.*;
import org.junit.platform.engine.TestExecutionResult;
import org.junit.platform.engine.reporting.ReportEntry;
import org.junit.platform.launcher.TestExecutionListener;
import org.junit.platform.launcher.TestIdentifier;
import org.junit.platform.launcher.TestPlan;

import javax.naming.Context;
import java.awt.*;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TestResultLoggerExtension extends TestBase  implements TestWatcher, AfterAllCallback
{
    private List<TestResultStatus> testResultsStatus = new ArrayList<>();
    public static String screenshotPath;

    private enum TestResultStatus
    {
        SUCCESSFUL, ABORTED, FAILED, DISABLED;
    }

    @Override
    public void afterAll(ExtensionContext extensionContext) throws Exception
    {
        Map<TestResultStatus, Long> summary = testResultsStatus.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        //LOG.info("Test result summary for {} {}", context.getDisplayName(), summary.toString());

    }
    @Override
    public void testDisabled(ExtensionContext extensionContext, Optional<String> optional)
    {
        //LOG.info("Test Disabled for test {}: with reason :- {}", context.getDisplayName(), reason.orElse("No reason"));
        testResultsStatus.add(TestResultStatus.DISABLED);
    }
    @Override
    public void testSuccessful(ExtensionContext extensionContext)
    {
        testResultsStatus.add(TestResultStatus.SUCCESSFUL);
        try
        {
            //screenshotPath = TestUtil.captureScreenshotBASE64(arg0.getName().toLowerCase().toString());
            System.out.println("Inside testSuccessful block in ResultLogger Base Class...");
            screenshotPath = TestUtil.captureScreenshotBASE64(extensionContext.getDisplayName().toLowerCase().toString());
            System.out.println(extensionContext.getTestInstance());

        } catch (IOException | InterruptedException e)
        {
            e.printStackTrace();
        }
    }
    @Override
    public void testAborted(ExtensionContext extensionContext, Throwable throwable)
    {
        testResultsStatus.add(TestResultStatus.ABORTED);
    }
    @Override
    public void testFailed(ExtensionContext extensionContext, Throwable throwable)
    {
        testResultsStatus.add(TestResultStatus.FAILED);
        try
        {
            //screenshotPath = TestUtil.captureScreenshotBASE64(arg0.getName().toLowerCase().toString());
            System.out.println("Inside testFailed block in ResultLogger Base Class...");
            screenshotPath = TestUtil.captureScreenshotBASE64(extensionContext.getDisplayName().toLowerCase().toString());
        } catch (IOException | InterruptedException e)
        {
            e.printStackTrace();
        }
    }

}
