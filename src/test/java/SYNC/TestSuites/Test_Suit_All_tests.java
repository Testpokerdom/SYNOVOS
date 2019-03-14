package SYNC.TestSuites;

import SYNC.Tests.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({FinanceSiteSettingsPageTests.class, InvoicingStatusTransmissionPageTests.class,
                     ItemsWithoutManufacturerLocators30DaysTests.class, MRLineDetailsWaitingForAQuoteTests.class,
                     MRLineSummaryTests.class, PGTListPriceRequestsTests.class, PGTManufactureFocusedSourcingTests.class, VendorApprovalTests.class})
public class Test_Suit_All_tests {
    public static final Logger logger = LogManager.getLogger(Test_Suite_ItemsWithoutPage_MRLineDetailsWaiting.class);

    public void loggerInfo(){

        logger.info("Test_Suite_ItemsWithoutPage_MRLineDetailsWaiting is running");
    }
}
