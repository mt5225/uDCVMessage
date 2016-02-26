package uDCVMessage;

import com.uinv.util.AmqQueueProducer;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class AssetSender {
	
	public static void main(String[] args)

	{
		String assetProp = "{'ID':'cli001','name':'cli001','belongTo':'575','CPU':'4 Core','Memory':'32G','OS':'WinServer 2008 R2 (64-bit)','site':'36-37','layout': '','deviceModelNumber':'IBM_system_x3550_m4'}";
		try {
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("_operation_", "add");
			jsonObject.put("_sc_", "ECC");
			jsonObject.put("_pool_", "rackDevice");
			jsonObject.put("_id_", "cli001");
			jsonObject.put("_data_", JSONObject.fromObject(assetProp));

			JSONArray jsArr = new JSONArray();
			jsArr.add(jsonObject);
			AmqQueueProducer.send("tcp://127.0.0.1:61616", "asset", jsArr);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}