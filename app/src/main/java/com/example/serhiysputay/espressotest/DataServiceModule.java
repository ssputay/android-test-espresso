package com.example.serhiysputay.espressotest;

import dagger.Module;
import dagger.Provides;

/**
 * Data service module to be injected
 */
@Module
public class DataServiceModule
{
    @Provides
    DataService provideDataService()
    {
        return DataService.getInstance();
    }
}
