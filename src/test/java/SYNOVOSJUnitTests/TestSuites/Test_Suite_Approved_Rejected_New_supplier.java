package SYNOVOSJUnitTests.TestSuites;

import SYNOVOSJUnitTests.Tests.Supplier_Create_Save_Reject_Emergancy.SupplierCreateAndApprove;
import SYNOVOSJUnitTests.Tests.Supplier_Create_Save_Reject_Emergancy.Create_Supplier_Status_Reject;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({SupplierCreateAndApprove.class, Create_Supplier_Status_Reject.class})

public class Test_Suite_Approved_Rejected_New_supplier {
}
