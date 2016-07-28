import com.qcloud.Common.Request;
import com.qcloud.Module.Live;
import com.qcloud.Module.Vod;
import com.qcloud.QcloudApiModuleCenter;
import com.qcloud.Utilities.Json.JSONObject;

import java.util.TreeMap;

public class ListDemo {
	public static void main(String[] args) {
		DescribeVodInfo();
		CreateLVBChannel();
	}

	public static void DescribeVodInfo(){
		QcloudApiModuleCenter module = new QcloudApiModuleCenter(new Vod(), Request.config);
		try{
			System.out.println("starting...");
			TreeMap<String, Object> params = new TreeMap<>();
			String result = module.call("DescribeVodInfo", params);
			System.out.println(new JSONObject(result));
			System.out.println("end...");
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("error..."+e.getMessage());
		}
	}

	public static void CreateLVBChannel(){
		QcloudApiModuleCenter module = new QcloudApiModuleCenter(new Live(), Request.config);
		try{
			System.out.println("starting...");
			TreeMap<String, Object> params = new TreeMap<>();
			params.put("channelName","test2");
//			params.put("channelDescribe","test2");
			params.put("outputSourceType",2);
//			params.put("playerPassword","");
			params.put("sourceList.1.name","video-2");
			params.put("sourceList.1.type",1);
//			params.put("sourceList.1.address","http://200023597.vod.myqcloud.com/200023597_3fe834e24fb111e6ac03cd5f3198e8b9.f0.wmv");
//			params.put("watermarkId","");
//			params.put("outputRate.1",10);
			String result = module.call("CreateLVBChannel", params);
			System.out.println(module.generateUrl("CreateLVBChannel",params));
			System.out.println(new JSONObject(result));
			System.out.println("end...");
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("error..."+e.getMessage());
		}
	}
}
