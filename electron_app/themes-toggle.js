// This block of code is responsible for toggling between light/dark modes
document.querySelector('.toggle').addEventListener('click', function () {
    setTimeout(() => {
        this.classList.toggle('active');
        document.querySelector('.wave').classList.toggle('active');
        document.documentElement.classList.toggle('dark-mode');
    }, 150);
});