(function($) {

	$("#entries").on('click', function(e) {
	    var entryAction = new EntryAction($($(e.target).parents("#current-entry")[0]));
	    chrome.extension.sendRequest({userId: "anton", action: "CHECK", url: entryAction.entry.url},
         function(response) {
            //DO NOTHING
        });
	});

	$(".entry-title-link").on('click', function(e) {
	    var entryAction = new EntryAction($(e.target).parent());
	    chrome.extension.sendRequest({userId: "anton", action: "CLICK", url: entryAction.entry.url},
         function(response) {
            //DO NOTHING
        });
	});

	var EntryAction = function(element) {
	    this.element = element;
	    var url = $(element).find(".entry-title-link").attr('href');
	    this.entry = {
	        "url" : url
	    };
	};

})(jQuery);
