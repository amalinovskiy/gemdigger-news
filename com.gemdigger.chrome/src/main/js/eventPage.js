chrome.extension.onRequest.addListener(
    function(request, sender, sendResponse) {
        jQuery.get("http://gemdiggernews.appspot.com/info/record", { userId: request.userId, action: request.action, url : encodeURIComponent(request.url)}, function(data){
            sendResponse(data);
        });
    }
);
