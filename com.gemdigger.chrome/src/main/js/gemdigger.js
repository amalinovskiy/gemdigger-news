(function($) {

	$("#entries").on('click', function(e) {
	    var entryAction = new EntryAction($($(e.target).parents("#current-entry")[0]));
        switch (e.which) {
            case 1:
                chrome.extension.sendRequest({userId: "anton", action: "CHECK", url: entryAction.entry.url},
                 function(response) {
                    //DO NOTHING
                });
            case 3:
                if ($(e.target).attr('href') != 'undefined') {
                    chrome.extension.sendRequest({userId: "anton", action: "READ", url: entryAction.entry.url},
                     function(response) {
                        //DO NOTHING
                    });
                }
        }

        return true;
	});

	$("#entries").on('contextmenu', function(e) {
	    var entryAction = new EntryAction($(e.target).parent());
	    if (typeof $(e.target).attr('href') != 'undefined') {
            chrome.extension.sendRequest({userId: "anton", action: "READ", url: entryAction.entry.url},
                function(response) {
                    //DO NOTHING
            });
        }

        return true;
	});


	var EntryAction = function(element) {
	    this.element = element;
	    var url = $(element).find(".entry-title-link").attr('href');
	    this.entry = {
	        "url" : url
	    };
	};

})(jQuery);
