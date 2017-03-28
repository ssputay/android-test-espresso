package com.example.serhiysputay.espressotest;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Data service interface
 */
@Singleton
@Component(modules = DataServiceModule.class)
public interface DataServiceComponent
{
    void inject(MainActivity mainActivity);
}
