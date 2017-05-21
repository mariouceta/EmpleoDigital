//JQUERY
var imgV = ['#auto', '#avi', '#moto'];
var cont = 1;
var seccion = "";
var precio = 0;

$(document).ready(function(){
$("input:submit").click(function() { return false; });
	$(imgV[0]).removeClass('oculta').addClass('imgVisible');
	$('#izq').click(function(){
		$(imgV[cont - 1]).fadeOut('fast').removeClass('imgVisible').addClass('oculta');
			if(cont == imgV.length){
			cont = 0;
		}
		$(imgV[cont]).delay('100').fadeIn('slow').removeClass('oculta').addClass('imgVisible');
		cont++;
	});

	$('#dch').click(function(){
		$(imgV[cont - 1]).fadeOut('fast').removeClass('imgVisible').addClass('oculta');
			if(cont == imgV.length){
			cont = 0;
		}
		$(imgV[cont]).delay('100').fadeIn('slow').removeClass('oculta').addClass('imgVisible');
		cont++;
	});

	$('#cierre').click(function(){
		$('.modal').fadeOut('slow');
		$('.velo').fadeOut('slow');
	});
		$('#cierre2').click(function(){
		$('.modal2').fadeOut('slow');
		$('.modal').fadeIn('slow');
	});

	$('#auto').click(function(){
		$('.velo').fadeIn('slow');
		$('.modal').fadeIn('slow');
		seccion = "Automóviles de lujo";
		precio = 120000;
	});
	$('#avi').click(function(){
		$('.velo').fadeIn('slow');
		$('.modal').fadeIn('slow');
		seccion = "Aviación";
		precio = 500000;
	});
	$('#moto').click(function(){
		$('.velo').fadeIn('slow');
		$('.modal').fadeIn('slow');
		seccion = "Motocicletas de lujo";
		precio = 60000;
	});

	$('#reservar').click(function(){
		$('.modal').delay('300').fadeOut('slow');
		$('.modal2').delay('300').fadeIn('slow');
		document.getElementById("titulo").innerHTML = seccion;		
	});


	$('#comprar').click(function(){
		$('.modal').delay('300').fadeOut('slow');
		$('.modal3').delay('300').fadeIn('slow');
		document.getElementById("precios").innerHTML = 
		seccion + ": " + precio + " €"; 

	});

		$('#cierre3').click(function(){
		$('.modal3').fadeOut('slow');
		$('.modal').fadeIn('slow');
	});
});