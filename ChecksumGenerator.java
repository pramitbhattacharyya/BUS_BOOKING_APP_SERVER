package busserver;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author PRAMIT
 */
import java.util.TreeMap;
import com.paytm.pg.merchant.*;

public class ChecksumGenerator {
	String EMAIL = "pramitb@iitbhilai.ac.in";
        String MID="merchant_id";
        String ORDER_ID="orderId";
        String CHANNEL_ID="WAP";
        String CUST_ID="CUST_ID";
        String MOBILE_NO="7777777777";
        
	String TXN_AMOUNT = "100.12";
	String WEBSITE = "WEBSTAGING";
	// This is the staging value. Production value is available in your dashboard
	String INDUSTRY_TYPE_ID = "Retail";
	// This is the staging value. Production value is available in your dashboard
//	String CALLBACK_URL = "https://securegw-stage.paytm.in/theia/paytmCallback?ORDER_ID=order1";
        String CALLBACK_URL = "https://pguat.paytm.com/paytmchecksum/paytmCallback.jsp";
        ChecksumGenerator(String MID,String ORDER_ID,String CHANNEL_ID,String CUST_ID,String MOBILE_NO,
                String EMAIL,String TXN_AMOUNT,String WEBSITE,String INDUSTRY_TYPE_ID)
        {
            this.MID=MID;
            this.ORDER_ID=ORDER_ID;
            this.CHANNEL_ID=CHANNEL_ID;
            this.CUST_ID=CUST_ID;
            this.MOBILE_NO=MOBILE_NO;
            this.EMAIL=EMAIL;
            this.TXN_AMOUNT=TXN_AMOUNT;
            this.WEBSITE=WEBSITE;
            this.INDUSTRY_TYPE_ID=INDUSTRY_TYPE_ID;                     
        }
	public String generate() {
		TreeMap<String, String> paytmParams = new TreeMap<String, String>();

		paytmParams.put("MID",MID);
		paytmParams.put("ORDER_ID",ORDER_ID);
		paytmParams.put("CHANNEL_ID",CHANNEL_ID);
		paytmParams.put("CUST_ID",CUST_ID);
//		paytmParams.put("MOBILE_NO",MOBILE_NO);
//		paytmParams.put("EMAIL",EMAIL);
		paytmParams.put("TXN_AMOUNT",TXN_AMOUNT);
		paytmParams.put("WEBSITE",WEBSITE);
		paytmParams.put("INDUSTRY_TYPE_ID",INDUSTRY_TYPE_ID);
		paytmParams.put("CALLBACK_URL", CALLBACK_URL);
                System.out.println("CHECK SUM GENERATOR");
                System.out.println(MID);
                System.out.println(ORDER_ID);
                System.out.println(CHANNEL_ID);
                System.out.println(CUST_ID);
                System.out.println(MOBILE_NO);
                System.out.println(EMAIL);
                System.out.println(TXN_AMOUNT);
                System.out.println(WEBSITE);
                System.out.println(INDUSTRY_TYPE_ID);
                System.out.println(CALLBACK_URL);                                                
	try {
		String paytmChecksum = CheckSumServiceHelper.getCheckSumServiceHelper().genrateCheckSum("merchant_key", paytmParams);
		System.out.println("The checksum = " + paytmChecksum);
                return paytmChecksum;
	}catch(Exception e) {}
        return "-1";
    }
}
