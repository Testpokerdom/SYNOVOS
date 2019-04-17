package SYNOVOSJUnitTests.TestSuites;

import SYNOVOSJUnitTests.Tests.Supplier_Create_Save_Reject_Emergancy.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({Create_Supplier_Status_New.class, Create_Supplier_Status_New_Pending_Approval.class
        , Create_Supplier_Status_Emergancy.class, Create_Supplier_Status_Approve.class, Create_Supplier_Status_Reject.class})

public class Test_Suite_Create_Supplier_New_NewPendingApproval_Emergency_Rejected_Approved {
}
