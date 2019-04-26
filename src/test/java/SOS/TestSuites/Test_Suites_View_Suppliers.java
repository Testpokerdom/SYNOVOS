package SOS.TestSuites;

import SOS.Tests._3_Supplier_View_Page_Tests.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({View_Supplier_Status_New.class, View_Supplier_Status_New_Pending_Approval.class, View_Supplier_Status_Approved.class, View_Supplier_Status_Emergency.class, View_Supplier_Status_Rejected.class,})

public class Test_Suites_View_Suppliers {
}
