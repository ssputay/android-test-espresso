package com.example.serhiysputay.espressotest;

import android.app.Instrumentation;
import android.content.Context;
import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.Espresso;
import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.Component;

import static org.junit.Assert.assertEquals;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest
{
    @Inject
    DataService dataService;

    @Singleton
    @Component(modules = MockDataServiceModule.class)
    public interface TestDataServiceComponent extends DataServiceComponent
    {
        void inject(ExampleInstrumentedTest exampleInstrumentedTest);
    }

    @Rule
    public ActivityTestRule mActivityRule = new ActivityTestRule<>(MainActivity.class);

    @Before
    public void setUp()
    {
        Instrumentation instrumentation = InstrumentationRegistry.getInstrumentation();
        MyApplication app
                = (MyApplication) instrumentation.getTargetContext().getApplicationContext();
        TestDataServiceComponent component = (TestDataServiceComponent) app.component();
        component.inject(this);
    }


    @Test
    public void useAppContext() throws Exception
    {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.example.serhiysputay.espressotest", appContext.getPackageName());
    }

    @Test
    public void testLabelsWithMockData() throws Exception
    {
        Mockito.doReturn("01").when(dataService).getMonth();
        mActivityRule.launchActivity(new Intent());
        //use mock month value
        Espresso.onView(ViewMatchers.withId(R.id.monthLabel)).check(ViewAssertions.matches(ViewMatchers.withText("01")));
        //use real year value
        Espresso.onView(ViewMatchers.withId(R.id.yearLabel)).check(ViewAssertions.matches(ViewMatchers.withText("2017")));
    }
}
