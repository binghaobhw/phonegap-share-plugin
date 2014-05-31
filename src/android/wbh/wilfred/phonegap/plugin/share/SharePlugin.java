package wbh.wilfred.phonegap.plugin.share;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONException;

import android.app.Activity;
import android.content.Intent;
public class SharePlugin extends CordovaPlugin {
    public static final String ACTION_WECHET = "toWeChet";

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
		try {
			if (ACTION_WECHET.equals(action)) { 
			   return toWeChet(args);
			}
		} catch(Exception e) {
			callbackContext.error(e.getMessage());
			return false;
		} 
    }

	private boolean toWeChet(JSONArray args) {
		String title = args.getString(0);
		String content = args.getString(1);
		Intent intent = new Intent(Intent.ACTION_SEND);
		intent.setPackage("com.tencent.mm");
		intent.putExtra(Intent.EXTRA_SUBJECT, title);
		intent.putExtra(Intent.EXTRA_TEXT, content);
		intent.setType("text/plain");
		this.cordova.getActivity().startActivity(intent);
		return true;
	}
}
