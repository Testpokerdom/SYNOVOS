package SYNC.TestSuites;

import SYNC.Tests.FinanceSiteSettingsPageTests;
import SYNC.Tests.InvoicingStatusTransmissionPageTests;
import SYNC.Tests.ItemsWithoutManufacturer30DaysTests;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({FinanceSiteSettingsPageTests.class, InvoicingStatusTransmissionPageTests.class, ItemsWithoutManufacturer30DaysTests.class})

public class Test_Suite_FinancePage_InvoicingPage_ItemsWithoutPage {

}
