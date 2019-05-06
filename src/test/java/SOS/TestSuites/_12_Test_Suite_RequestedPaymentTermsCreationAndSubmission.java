package SOS.TestSuites;


import SOS.Tests._12_PaymentTermsApprovalinitiation.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({Test_1_ApprovePaymentTermForSupplierStatusNew.class, Test_2_ApprovePaymentTermForSupplierStatusApproved.class, Test_3_ApprovepaymentTermForSupplierStatusRejected.class,
        Test_4_ApprovePaymentTermForSupplierStatusEmergency.class, Test_5_ApprovePaymentTermsForSupplierStatusNewSupplierPendingApproval.class
})
public class _12_Test_Suite_RequestedPaymentTermsCreationAndSubmission {
}
