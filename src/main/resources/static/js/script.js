const navHome = document.querySelector('.navbar');

var confirmDiv = document.getElementById("confirm");



window.addEventListener('scroll', () => {
    if (window.scrollY >= 56) {
        navHome.classList.add('navbar-scrolled')
    } else if (window.scrollY < 56) {
        navHome.classList.remove('navbar-scrolled')
    }
})

document.querySelector('.navbar')[
    document.addEventListener ? 'addEventListener' : 'attachEvent'
]('click', function() {
    this.style.backgroundColor = this.style.backgroundColor === 'rgba(0, 0, 0, 0.85)' ?
        'transparent' : 'rgba(0, 0, 0, 0.85)';
 
});


function mostraAlert() {
    var customAlert = document.getElementById('customAlert');
    customAlert.style.display = 'block';
}

function chiudiAlert() {
    var customAlert = document.getElementById('customAlert');
    customAlert.style.display = 'none';

    window.location.href = "personale";
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
    
    
 




  

