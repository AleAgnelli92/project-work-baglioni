const navHome = document.querySelector('.navbar')

window.addEventListener('scroll', () => {
    if (window.scrollY >= 56) {
        navHome.classList.add('navbar-scrolled')
    } else if (window.scrollY < 56) {
        navHome.classList.remove('navbar-scrolled')
    }
})