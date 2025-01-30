document.addEventListener("DOMContentLoaded", () => {
  const form = document.querySelector("form");
  const usernameInput = document.getElementById("username");
  const passwordInput = document.getElementById("password");
  const mensajeUsername = document.querySelectorAll("#mensaje")[0]; // Div para el username
  const mensajePassword = document.querySelectorAll("#mensaje")[1]; // Div para el password

  form.addEventListener("submit", (event) => {
    let isValid = true;

    // Limpiar los mensajes previos
    mensajeUsername.innerHTML = "";
    mensajePassword.innerHTML = "";

    // Validar campo de usuario
    const usernameValue = usernameInput.value.trim();
    if (usernameValue === "") {
      isValid = false;
      mensajeUsername.innerHTML += `<p class="text-danger">El nombre de usuario no puede estar vacío.</p>`;
    } else if (!/^[a-zA-Z0-9]+$/.test(usernameValue)) {
      isValid = false;
      mensajeUsername.innerHTML += `<p class="text-danger">El nombre de usuario solo puede contener letras y números.</p>`;
    }

    // Validar campo de contraseña
    const passwordValue = passwordInput.value.trim();
    if (passwordValue === "") {
      isValid = false;
      mensajePassword.innerHTML += `<p class="text-danger">La contraseña no puede estar vacía.</p>`;
    } else if (passwordValue.length < 8) {
      isValid = false;
      mensajePassword.innerHTML += `<p class="text-danger">La contraseña debe tener al menos 8 caracteres.</p>`;
    }

    // Evitar envío del formulario si no es válido
    if (!isValid) {
      event.preventDefault();
    }
  });
});
