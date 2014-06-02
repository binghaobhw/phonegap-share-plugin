package wbh.wilfred.phonegap.plugin.share;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONException;

import android.app.Activity;
import android.content.Intent;
import android.content.ComponentName;
public class SharePlugin extends CordovaPlugin {
    public static final String ACTION_WECHET_FRIEND = "toWeChetFriend";
    public static final String ACTION_WECHET_TIMELINE = "toWeChetFriendTimeline";

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
		if (ACTION_WECHET_FRIEND.equals(action)) { 
		   return toWeChetFriend(args);
		}
		if (ACTION_WECHET_TIMELINE.equals(action)) { 
		   return toWeChetTimeline(args);
		}
		return false;
    }

	private boolean toWeChetFriend(JSONArray args) throws JSONException {
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

	private boolean toWeChetTimeline(JSONArray args) throws JSONException {
		String title = args.getString(0);
		String content = args.getString(1);
		Intent intent = new Intent(Intent.ACTION_SEND);
		ComponentName comp = new ComponentName("com.tencent.mm",  
			"com.tencent.mm.ui.tools.ShareToTimeLineUI");
		intent.setComponent(comp);
		intent.setType("image/*");
		intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_GRANT_READ_URI_PERMISSION);
		intent.putExtra("Kdescription", content);
		this.cordova.getActivity().startActivity(intent);
		return true;
	}	
}
