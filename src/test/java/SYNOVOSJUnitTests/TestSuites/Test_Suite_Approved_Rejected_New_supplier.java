package SYNOVOSJUnitTests.TestSuites;

import SYNOVOSJUnitTests.Tests.Supplier_Create_Save_Reject_Emergancy.SupplierCreateAndApprove;
import SYNOVOSJUnitTests.Tests.Supplier_Create_Save_Reject_Emergancy.SupplierCreateAndReject;
import SYNOVOSJUnitTests.Tests.Supplier_Create_Save_Reject_Emergancy.SupplierCreateAndSave;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({SupplierCreateAndApprove.class, SupplierCreateAndReject.class, SupplierCreateAndSave.class})

public class Test_Suite_Approved_Rejected_New_supplier {
}
