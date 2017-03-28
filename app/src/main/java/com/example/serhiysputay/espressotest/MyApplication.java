package com.example.serhiysputay.espressotest;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Main application class
 */

public class MyApplication extends Application
{
    /**
     * Initialize the Dagger module. Mock modules can be used for testing.
     */
    @Singleton
    @Component(modules = DataServiceModule.class)
    public interface ApplicationComponent extends DataServiceComponent
    {
    }

    private final DataServiceComponent component = createComponent();

    protected DataServiceComponent createComponent()
    {
        return DaggerDataServiceComponent.builder().build();
    }

    public DataServiceComponent component()
    {
        return component;
    }
}
