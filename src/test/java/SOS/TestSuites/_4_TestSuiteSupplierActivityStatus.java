package SOS.TestSuites;

import SOS.Tests._4_Supplier_Activity_Status.ApprovedSupplierStatusShouldBeActive;
import SOS.Tests._4_Supplier_Activity_Status.RejectedSupplierStatusShouldBeInActive;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({ApprovedSupplierStatusShouldBeActive.class, RejectedSupplierStatusShouldBeInActive.class})

public class _4_TestSuiteSupplierActivityStatus {

}
