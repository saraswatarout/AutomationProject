package Practice;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AssertionTest {
	@Test
	  public void StringTest() {
		 String exp="saraswata";
		 String act="saraswat";

		// Assert.assertEquals(act, exp);
	}
	@Test
	 public void integerTest() {
			 
		 int a=13;
		 int b=13;
		 
		// Assert.assertEquals(a, b);
	}
	@Test
	 public void byteVerification() {
		byte act=110;
		 byte exp=120;
		// Assert.assertEquals( act,exp);
	}
	
	
	 
	 

}
