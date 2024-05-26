document.querySelectorAll('.menu-item').forEach(item => {
    item.addEventListener('mouseover', () => {
        item.classList.add('active');
    });
    item.addEventListener('mouseout', () => {
        item.classList.remove('active');
    });
});

// Función para manejar el evento de click en los elementos del menú
document.querySelectorAll('.menu-item').forEach(item => {
    item.addEventListener('click', () => {
        // Aquí puedes agregar lógica adicional si necesitas realizar acciones específicas al seleccionar un elemento del menú
    });
});

// Carrusel de imágenes
var indiceActual = 0;
var imagenes = document.querySelectorAll('.carrusel.imagen1');

setInterval(function() {
    imagenes[indiceActual].classList.remove('activo');
    indiceActual++;
    if(indiceActual >= imagenes.length) {
        indiceActual = 0;
    }
    imagenes[indiceActual].classList.add('activo');
}, 3000); // Cambia la imagen cada 3 segundos

// Funciones para controlar manualmente el carrusel
function siguienteImagen() {
    indiceActual++;
    if(indiceActual >= imagenes.length) {
        indiceActual = 0;
    }
    imagenes[indiceActual].classList.add('activo');
    imagenes[indiceActual - 1].classList.remove('activo');
}

function anteriorImagen() {
    indiceActual--;
    if(indiceActual < 0) {
        indiceActual = imagenes.length - 1;
    }
    imagenes[indiceActual].classList.add('activo');
    imagenes[indiceActual + 1].classList.remove('activo');
}