package SYNOVOSJUnitTests.TestSuites;

import SYNOVOSJUnitTests.Tests.Supplier_Create_Save_Reject_Emergancy.Create_Supplier_Status_Approve;
import SYNOVOSJUnitTests.Tests.Supplier_Create_Save_Reject_Emergancy.Create_Supplier_Status_Reject;
import SYNOVOSJUnitTests.Tests.Supplier_Create_Save_Reject_Emergancy.Create_Supplier_Status_Emergancy;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;


@RunWith(Suite.class)
@Suite.SuiteClasses({Create_Supplier_Status_Approve.class, Create_Supplier_Status_Reject.class, Create_Supplier_Status_Emergancy.class})

public class Test_Suite_Create_Approve_Reject_Save_Supplier {

}
