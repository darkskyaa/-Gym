/**================================================================================================
 									custom filter by Date/Time									  
===================================================================================================
 @Version: 1.0
 @Author: 
 @LastUpdate:
===================================================================================================
=================================================================================================*/
eApp.filter('parseDate', function() {
    return function (valueString) {
    	arrFullTime = valueString.split(' ');
 		strDate = arrFullTime[0].replace(/[-\/\\]/, '-');
 		
 		var date = new Date(strDate);
 		
		try{
			arrtime = arrFullTime[1].split(':');
			date.setHours(arrtime[0], arrtime[1], arrtime[2], 0);
		}
		catch(e){
			date.setHours(0, 0, 0, 0);
		}

		return date;
    }
});