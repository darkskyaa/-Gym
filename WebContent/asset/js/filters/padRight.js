/**================================================================================================
 									custom filter by data										  
===================================================================================================
 @Version: 1.0
 @Author: 
 @LastUpdate:
===================================================================================================
=================================================================================================*/
eApp.filter('padRight', function() {
    return function (value, count, char) {
//    	console.log('value=' + value + ', count=' + count + ', char='
//				+ char);

		while (value.length < count) {
			value = value + char;
		}
		return value;
    }
});