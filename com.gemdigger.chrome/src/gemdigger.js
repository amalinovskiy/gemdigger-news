(function($) {

	$("#entries").on('click', function(e) {
	    var entryAction = new EntryAction($($(e.target).parents("#current-entry")[0]));
	    alert(entryAction.entry.url)
	});

	$(".entry-title-link").on('click', function(e) {
	    var entryAction = new EntryAction($(e.target).parent());
	    alert(entryAction.entry.url)
	});

	var EntryAction = function(element) {
	    this.element = element;
	    var url = $(element).find(".entry-title-link").attr('href');
	    this.entry = {
	        "url" : url
	    };
	};

})(jQuery);
