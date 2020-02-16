package Config;

import org.junit.jupiter.api.TestReporter;
import org.junit.platform.engine.TestExecutionResult;
import org.junit.platform.engine.reporting.ReportEntry;
import org.junit.platform.launcher.TestExecutionListener;
import org.junit.platform.launcher.TestIdentifier;
import org.junit.platform.launcher.TestPlan;

import java.util.Map;

public  class ReportManager extends TestBase implements TestExecutionListener ,TestReporter  {

    @Override
    public void publishEntry(Map<String, String> map) {

    }

    @Override
    public void publishEntry(String key, String value) {

    }

    @Override
    public void publishEntry(String value) {

    }

    @Override
    public void testPlanExecutionStarted(TestPlan testPlan) {

    }

    @Override
    public void testPlanExecutionFinished(TestPlan testPlan) {

    }

    @Override
    public void dynamicTestRegistered(TestIdentifier testIdentifier) {

    }

    @Override
    public void executionSkipped(TestIdentifier testIdentifier, String reason) {

    }

    @Override
    public void executionStarted(TestIdentifier testIdentifier) {

    }

    @Override
    public void executionFinished(TestIdentifier testIdentifier, TestExecutionResult testExecutionResult) {

    }

    @Override
    public void reportingEntryPublished(TestIdentifier testIdentifier, ReportEntry entry) {

    }
}
