function validarLogin() {
    var username = document.getElementById('username').value;
    var password = document.getElementById('password').value;

    // Verificar los datos del usuario (puedes simular la autenticación aquí)
    if (username === 'Abel' && password === '123456') {
        return true; // Envía el formulario
    } else {
        alert('Nombre de usuario o contraseña incorrectos');
        return false; // No envía el formulario
    }
}
