package SOS.TestSuites;

import SOS.Tests._8_Supplier_Activation.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({Test_1_Activate_Supplier_With_Status_New.class, Test_2_Activate_Supplier_With_Status_Approved.class, Test_3_Activate_Supplier_With_Status_Rejected.class,
        Test_4_Activate_Supplier_With_Status_Emergency.class, Test_5_ActivateSupplierWithStatusRejectedAsEmergency.class, Test_6_ActivateSupplierWithStatusNewSupplierPendingApplier.class
        })
public class _8_Test_Suite_Supplier_Activation {
}
