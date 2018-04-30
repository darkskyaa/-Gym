/**================================================================================================
 									custom filter by data										  
===================================================================================================
 @Version: 1.0
 @Author: 
 @LastUpdate: 2018/04/30 Johnson
===================================================================================================
=================================================================================================*/
eApp.filter('mapping', ['$q', function($q) {
	
	return function(input, mappingObj, style) {
		if(!input)return;
		if(!mappingObj)return input;
		var inValue = input.toString().trim(), outValue = false;
		  	angular.forEach(mappingObj, function(obj) {
		  		if(angular.isDefined(obj.DATA)){
		  			if (obj.DATA.toString().trim() === inValue) {
		  				outValue = obj.LABEL.toString().trim();
		  				if(angular.isDefined(style)){
		  					switch(style.toString().trim()) {
								case "F1":
									outValue = obj.DATA.toString().trim() + '-' + obj.LABEL.toString().trim();
									break;
								case "F2":
									outValue = obj.DATA.toString().trim();
									break;
								case "F3":
									outValue = obj.LABEL.toString().trim();
									break;
								default:
									outValue = obj.LABEL.toString().trim();
									break;
							}
		  				}else{
		  					outValue = obj.LABEL.toString().trim();
		  				}
			        }
		  		}
		    });
		if(!outValue)outValue = inValue;
	    return outValue;
	};
	
}]);