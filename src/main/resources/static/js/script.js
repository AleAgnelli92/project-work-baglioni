const navbar = document.querySelector('.navbar');
var confirmDiv = document.getElementById("confirm");
let mediaQuery = window.matchMedia('(min-width: 992px)')

function noScrollMobile(mediaQuery) {
	if (mediaQuery.matches) {
		window.addEventListener('scroll', () => {
		    if (window.scrollY >= 56) {
		        navbar.classList.add('navbar-scrolled');
		    } else if (window.scrollY < 56) {
		        navbar.classList.remove('navbar-scrolled');
		    }
		});
	}
}

mediaQuery.addEventListener('change', noScrollMobile);

noScrollMobile(mediaQuery);

document.querySelector('.navbar-toggler')[
    document.addEventListener ? 'addEventListener' : 'attachEvent'
]('click', function() {
    navbar.style.backgroundColor = navbar.style.backgroundColor === 'rgba(0, 0, 0, 0.85)' ?
        'transparent' : 'rgba(0, 0, 0, 0.85)';
        navbar.style
});

function chiudiAlert() {
    var customAlert = document.getElementById('customAlert');
    customAlert.style.display = 'none';

    window.location.href = "personale";
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
    

 




  

