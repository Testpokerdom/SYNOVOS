package SOS.TestSuites;

import SOS.Tests._7_Supplier_Deletion_Deactivation.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({Test_1_Delete_Supplier_Status_New_No_PO.class, Test_2_Deactivate_Supplier_Status_New_No_PO.class, Test_3_Delete_Supplier_Status_New_Pending_Approval_No_PO.class,
        Test_4_Deactivate_Supplier_Status_New_Pending_Approval_No_PO.class, Test_5_Delete_Supplier_Status_Approved_No_PO.class, Test_6_Deactivate_Supplier_Status_Approved_No_PO.class,
        Test_7_Delete_Supplier_Status_Emergency_No_PO.class, Test_8_Deactivate_Supplier_Status_Emergency_No_PO.class})

public class _7_Test_Suite_Supplier_Deletion_Deactivation {
}
