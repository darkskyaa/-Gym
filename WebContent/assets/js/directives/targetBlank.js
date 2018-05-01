//<h3>Apply Directive at Container Level:<h3>
//<div target-blank>
//	<a href="foo">Foo</a>
//    <a href="bar">Bar</a>
//    <a href="baz">Baz</a>
//</div>
//
//<h3>Apply Directive at Anchor Level:<h3>
//<div>
//  <a target-blank href="foo">Opens in New Window</a>
//</div>
//
//<h3>Don't apply the Directive</h3>
//<div>
//  <a href="foo">Opens in Current Window</a>
//</div>

eApp.directive('targetBlank', function() {
	return {
		compile: function(element) {
			var elems = (element.prop("tagName") === 'A') ? element : element.find('a');
			elems.attr("target", "_blank");
		}
	};
});