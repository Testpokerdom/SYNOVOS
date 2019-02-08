package SYNOVOSJUnitTests.TestSuites;

import SYNOVOSJUnitTests.Tests.Supplier_Create_Save_Reject_Emergancy.SupplierCreateAndApprove;
import SYNOVOSJUnitTests.Tests.Supplier_Create_Save_Reject_Emergancy.SupplierCreateAndReject;
import SYNOVOSJUnitTests.Tests.Supplier_Create_Save_Reject_Emergancy.SupplierCreateAndSave;
import SYNOVOSJUnitTests.Tests.Supplier_Create_Save_Reject_Emergancy.SupplierCreateEmergancy;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;


@RunWith(Suite.class)
@Suite.SuiteClasses({SupplierCreateAndApprove.class, SupplierCreateAndReject.class, SupplierCreateAndSave.class, SupplierCreateEmergancy.class})

public class Test_Suite_Create_Approve_Reject_Save_Supplier {

}
