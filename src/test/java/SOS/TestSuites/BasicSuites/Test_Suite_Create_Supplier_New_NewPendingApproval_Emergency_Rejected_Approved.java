package SOS.TestSuites.BasicSuites;

import SOS.Tests._1_Create_Supplier_New_NewPendingApproval_Emergency_Approved_Reject.Demo_Agro_Farma_Site_Without_AutoApproval.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({Create_Supplier_Status_New.class, Create_Supplier_Status_New_Pending_Approval.class
        , Create_Supplier_Status_Emergancy.class, Create_Supplier_Status_Approve.class, Create_Supplier_Status_Reject.class})

public class Test_Suite_Create_Supplier_New_NewPendingApproval_Emergency_Rejected_Approved {
}
