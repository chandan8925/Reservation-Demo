(function(){
	"use strict";
	
	$('#getAll_btn').click(function(){
		$.ajax({
			type: 'GET',
		url:'api/emp/all',
		success :function(data){
			console.log(data);
			for(var i=0 ; i<data.payload.length;i++)
				{
				var pE1 = $('<p></p>');
				pE1.text(data.payload[i].firstName + "" +data.payload[i].lastName);
				$('body').append(pE1);
				}
		},
		error: function(error){
			console.log(error);
		}
		});
	});
	
	
	$('#getEmp_btn').click(function(){
		var empId= new Number($('#empId_input').val());
		
		if(!isNaN(empId)){
			$.ajax({
			type: 'GET',
		url:'api/emp/get/' +empId,
		success :function(data){
			console.log(data);
			
				var pE1=$('<p></p>');
				pE1.text(data.payload.firstName+" "+data.payload.lastName);
				$('body').append(pE1)
			
		},
		error: function(error){
			console.log(error); 
		}
		});
		}
	else {
		alert("Employee Id must be numeric");
	}
	});
	
	$('form').submit(function(){
		var emp = {
				firstName: $('#firstName').val(),
		lastName: $('#lastName').val(),
		email: $('#email').val(),
		address1: $('#address1').val(),
		address2: $('#address2').val(),
		phone: $('#phone').val(),
		city: $('#city').val(),
		zip: $('#zip').val(),
	};
		
		$.ajax({
			type: 'POST',
		url:'api/emp/add',
		data: JSON.stringify(emp),
		contentType:'application/json',
		success :function(data){
			console.log(data);
			
				
			
		},
		error: function(error){
			console.log(error); 
		}
		});
		
		console.log(emp);
		return false;
	});
})();