function SharePlugin() {
}

SharePlugin.prototype.toWeChetFriend = function(title, content, successCallback, errorCallback) {
	cordova.exec(successCallback, errorCallback, 'SharePlugin', 'toWeChetFriend', [title, content]);
};
SharePlugin.prototype.toWeChetTimeline = function(title, content, successCallback, errorCallback) {
	cordova.exec(successCallback, errorCallback, 'SharePlugin', 'toWeChetTimeline', [title, content]);
};

SharePlugin.install = function() {
	if (!window.plugins) {
		window.plugins = {};
	}

	window.plugins.sharePlugin = new SharePlugin();
	return window.plugins.SharePlugin;
};

cordova.addConstructor(SharePlugin.install);
