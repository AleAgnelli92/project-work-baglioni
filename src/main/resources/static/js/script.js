const navbar = document.querySelector('.navbar');
var confirmDiv = document.getElementById("confirm");
//let mediaQuery = window.matchMedia('(min-width: 992px)')

//function noScrollMobile(mediaQuery) {
	//if (mediaQuery.matches) {
		window.addEventListener('scroll', () => {
		    if (window.scrollY >= 56) {
		        navbar.classList.add('navbar-scrolled');
		    } else if (window.scrollY < 56) {
		        navbar.classList.remove('navbar-scrolled');
		    }
		});
	//}
//}
//mediaQuery.addEventListener('change', noScrollMobile);
//noScrollMobile(mediaQuery);

document.querySelector('.navbar-toggler')[
    document.addEventListener ? 'addEventListener' : 'attachEvent'
]('click', function() {
	
    navbar.style.backgroundColor = navbar.style.backgroundColor === 'RGBA(10,42,54,0.65)' ?
        'transparent' : 'RGBA(10,42,54,0.65)';
        navbar.style
});

function mostraAlertLog() {
	var customAlert = document.getElementById('customAlertLogged');
	customAlert.style.display = 'block';
	
						}
						

						
function mostraAlertNotLog() {
	var log = document.getElementById('customAlertNotLogged');
	log.style.display = 'block';
						}
						
function chiudiAlertLog() {
    var customAlert = document.getElementById('customAlertLogged');
    customAlert.style.display = 'none';

    window.location.href = "/ordine/registraordine";
}

function chiudiAlertNotLog() {
    var customAlertNL = document.getElementById('customAlertNotLogged');
    customAlertNL.style.display = 'none';

    window.location.href = "login";
}

function mostraAlertOrdini() {
    var customAlert = document.getElementById('customAlert');
    customAlert.style.display = 'block';
}

function chiudiAlertAccesso() {
    var customAlert = document.getElementById('customAlert');
    customAlert.style.display = 'none';

    window.location.href = "login";
}

function chiudiAlertOrdini() {
    var customAlert = document.getElementById('customAlert');
    customAlert.style.display = 'none';
}

function confermaEliminazione(albumId) {
        window.location.href = "/carrello/rimuovi?id=" + albumId;
}
    
function showConfirm() {
         confirmDiv.style.display = "block";
}
function closeConfirm() {
         confirmDiv.style.display = "none";
}
 
window.addEventListener("click", function(){
  document.getElementById("demo").innerHTML = "Hello World!";
});



  

