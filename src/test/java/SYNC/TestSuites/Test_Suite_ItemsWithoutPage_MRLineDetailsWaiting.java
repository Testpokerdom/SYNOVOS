package SYNC.TestSuites;

import SYNC.Tests.System_Tests.ItemsWithoutManufacturerLocators30DaysTests;
import SYNC.Tests.System_Tests.MRLineDetailsWaitingForAQuoteTests;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

    @RunWith(Suite.class)
    @Suite.SuiteClasses({ItemsWithoutManufacturerLocators30DaysTests.class, MRLineDetailsWaitingForAQuoteTests.class})

    public class Test_Suite_ItemsWithoutPage_MRLineDetailsWaiting {
        public static final Logger logger = LogManager.getLogger(Test_Suite_ItemsWithoutPage_MRLineDetailsWaiting.class);

        public void loggerInfo(){

            logger.info("Test_Suite_ItemsWithoutPage_MRLineDetailsWaiting is running");
        }

    }

