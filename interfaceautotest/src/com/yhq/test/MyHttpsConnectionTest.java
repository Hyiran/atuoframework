package com.yhq.test;

import org.testng.annotations.Test;

import com.yhq.http.MyHttpsConnection;

public class MyHttpsConnectionTest {
  @Test
  public void test() {
	  String url ="https://vip.dccnet.com.cn:452/OFSTSTOREAPP/appLogin/getLogin.action";
	  String parm = "rylCode=2153337903&pwd=57D4DCD415DF3403B1A2DECDC045DBD854591700899B61C536BC0F8F170898189C2A6AEB64B4B4DDAA64E68F8B3C94229A6862783C9195A484D648C4C298BD11D904FF332A01FC697082B5A1222AAB3F2452DB3F9F9A15A0B09983F4AEB68FA514E2F733EB0D918BE1BE5D341801055844B4720CFF3B23A6D5B9BEBD55F5BF3B%7C%7C11C88AE04CEC1BA554D03D5B5970333A83585826C2A985DE5520D9E934389EFB84B52D344FB21AA8EA38A4940C8332692B8D4DA2393549212EAFDC0F11CA5C9CE416120C3AD9F0A63BA563AC864476B91B212EC0A0E96ECDDC2EF0E322453FC613BC1F5F3D7AEBFDFF9EF569F6CB3EB8612CDA1AC26E&custMac=867993020603468&passwdChangeRule=1280%230&userName=31000151833&userAgent=elife_mobile_android&passwdRule=113261125234135216141154259162282172290226323721242792251";
	  MyHttpsConnection  myHttpsConn = new MyHttpsConnection();
	  System.out.println(myHttpsConn.myPost(url, parm));
	  
	  String url2 ="https://vip.dccnet.com.cn:452/OFSTSTOREAPP/appLogin/getLogin.action";
	  String parm2 = "rylCode=2153337903&pwd=57D4DCD415DF3403B1A2DECDC045DBD854591700899B61C536BC0F8F170898189C2A6AEB64B4B4DDAA64E68F8B3C94229A6862783C9195A484D648C4C298BD11D904FF332A01FC697082B5A1222AAB3F2452DB3F9F9A15A0B09983F4AEB68FA514E2F733EB0D918BE1BE5D341801055844B4720CFF3B23A6D5B9BEBD55F5BF3B%7C%7C11C88AE04CEC1BA554D03D5B5970333A83585826C2A985DE5520D9E934389EFB84B52D344FB21AA8EA38A4940C8332692B8D4DA2393549212EAFDC0F11CA5C9CE416120C3AD9F0A63BA563AC864476B91B212EC0A0E96ECDDC2EF0E322453FC613BC1F5F3D7AEBFDFF9EF569F6CB3EB8612CDA1AC26E&custMac=867993020603468&passwdChangeRule=1280%230&userName=31000151833456789&userAgent=elife_mobile_android&passwdRule=113261125234135216141154259162282172290226323721242792251";
	  MyHttpsConnection  myHttpsConn2 = new MyHttpsConnection();
	  System.out.println(myHttpsConn2.myPost(url2, parm2));
	  
	  String url3 ="https://vip.dccnet.com.cn:452/OFSTSTOREAPP/appLogin/getLogin.action";
	  String parm3 = "rylCode=2153337903&pwd=57D4DCD415DF3403B1A2DECDC045DBD854591700899B61C536BC0F8F170898189C2A6AEB64B4B4DDAA64E68F8B3C94229A6862783C9195A484D648C4C298BD11D904FF332A01FC697082B5A1222AAB3F2452DB3F9F9A15A0B09983F4AEB68FA514E2F733EB0D918BE1BE5D341801055844B4720CFF3B23A6D5B9BEBD55F5BF3B%7C%7C11C88AE04CEC1BA554D03D5B5970333A83585826C2A985DE5520D9E934389EFB84B52D344FB21AA8EA38A4940C8332692B8D4DA2393549212EAFDC0F11CA5C9CE416120C3AD9F0A63BA563AC864476B91B212EC0A0E96ECDDC2EF0E322453FC613BC1F5F3D7AEBFDFF9EF569F6CB3EB8612CDA1AC26E&custMac=867993020603468&passwdChangeRule=1280%230&userName=31000151833&userAgent=elife_mobile_android&passwdRule=113261125234135216141154259162282172290226323721242792251";
	  MyHttpsConnection  myHttpsConn3 = new MyHttpsConnection();
	  System.out.println(myHttpsConn3.myPost(url3, parm3));

  }
}
