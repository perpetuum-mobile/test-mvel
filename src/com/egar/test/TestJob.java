package com.egar.test;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * User: nchebykina
 * Date: 27.08.12
 * Time: 14:48
 */
public class TestJob extends QuartzJobBean {
    private TestMVEL testMVEL;

    public void setTestMVEL(TestMVEL testMVEL) {
        this.testMVEL = testMVEL;
    }

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        testMVEL.test();
    }
}
