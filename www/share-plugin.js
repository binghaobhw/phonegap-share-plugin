function SharePlugin() {
}

SharePlugin.prototype.toWeChet = function(title, content, successCallback, errorCallback) {
	cordova.exec(successCallback, errorCallback, 'SharePlugin', 'toWeChet', [title, content]);
};

SharePlugin.install = function() {
	if (!window.plugins) {
		window.plugins = {};
	}

	window.plugins.sharePlugin = new SharePlugin();
	return window.plugins.SharePlugin;
};

cordova.addConstructor(SharePlugin.install);
