import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.mysql.cj.protocol.x.SyncFlushDeflaterOutputStream;
import com.vtiger.Genericutility.BaseClass;
@Listeners(com.vtiger.Genericutility.ExtentReportImp.class)

public class ReportTest extends BaseClass {
	@Test
	public void createOrg() {
		System.out.println("passed"); 
		
	}
	@Test
	public void createcontact() {
		System.out.println("failed");
		Assert.fail();
	}
	@Test
	public void cteatelead() {
		System.out.println("skipped"); 
		 
	}

}
