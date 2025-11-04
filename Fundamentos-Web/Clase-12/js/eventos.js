// EVENTOS

//------------------------------------------------------------------------
// OPCION 1 -> addEventListener();
let btn1 = document.getElementById("btn1");

// Con funcion flecha (=>)
btn1.addEventListener("click", () => console.log("Click opcion 1"));

// Con funcion anonima
btn1.addEventListener("click", function () {
  console.log("Click opcion 1");
});

// Con funcion externa
btn1.addEventListener("click", rtaClick);

function rtaClick() {
  console.log("Click opcion 1");
}

//------------------------------------------------------------------------
// OPCION 2 -> propiedades "on-"
let btn2 = document.getElementById("btn2");

// Con funcion anonima
btn2.onclick = function () {
  console.log("Click con opcion 2");
  this.style.backgroundColor = "deeppink";
};

// Con funcion flecha (=>)
btn2.onclick = () => console.log("Click con opcion 2");

//------------------------------------------------------------------------
// OPCION 3 -> atributo de etiqueta (HTML) "on-" -> EN BTN3

//------------------------------------------------------------------------
// EVENTOS DEL MOUSE

//onclick, onmousedown/onmouseup, onmouseover/onmouseout, onmousemove
let input1 = document.getElementById("texto1");

input1.onclick = () => console.log("Estoy haciendo CLICK");
input1.addEventListener("mousemove", () => console.log("Me muevo en el input"));

//------------------------------------------------------------------------
// EVENTOS DEL TECLADO

// onkeydown, onkeyup
let input2 = document.getElementById("numero1");

input2.addEventListener("keydown", function () {
  console.log("Presiono una tecla");
});
input2.addEventListener("keyup", () => console.log("Suelto una tecla"));

//------------------------------------------------------------------------
// EVENTO change/input
let input3 = document.getElementById("texto2");

input3.onchange = function (event) {
  console.log("Change");
  console.dir(event);
  console.dir(event.target);
  console.dir(event.target.value);
};

input3.oninput = function () {
  console.log("Input");
};

//------------------------------------------------------------------------
// EVENTO submit
let form = document.getElementById("formulario");

form.addEventListener("submit", validarFormulario);

function validarFormulario(e) {
  e.preventDefault();

  //console.dir(e.target);
  let formulario = e.target.children;
  let objInfo = {};

  for (const input of formulario) {
    console.dir(input);
    if (input.tagName === "INPUT") {
      console.log(input.id + ":" + input.value);
      objInfo[input.id] = input.value;
    }
  }

  console.log(objInfo);

  let reset = document.getElementById("resetBtn");
  reset.click();
}
