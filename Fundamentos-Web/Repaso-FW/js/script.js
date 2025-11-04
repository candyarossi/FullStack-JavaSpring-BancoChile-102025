window.onload = () => {
  alert("Cargando Reporte del Clima");
};

alert("Cargando Reporte del Clima");

let btnAceptar = document.querySelector("#aceptar");

btnAceptar.addEventListener("click", function () {
  document.getElementById("cookies").style.display = "none";
});

let climas = [
  {
    img: '<ion-icon name="rainy"></ion-icon>',
    temperatura: "3°C - 14°C",
    estado: "Tormentas",
  },
  {
    img: '<ion-icon name="cloudy"></ion-icon>',
    temperatura: "5°C - 12°C",
    estado: "Nublado",
  },
  {
    img: '<ion-icon name="partly-sunny"></ion-icon>',
    temperatura: "9°C - 18°C",
    estado: "Parcialmente Nublado",
  },
  {
    img: '<ion-icon name="sunny"></ion-icon>',
    temperatura: "15°C - 23°C",
    estado: "Soleado",
  },
];

document.querySelectorAll("li").forEach(function (element) {
  element.onclick = () => cargarClima(element.innerText);
});

function cargarClima(ciudad) {
  document.querySelector("#ciudad").innerText = ciudad;

  let cards = document.querySelectorAll(".card");

  for (const card of cards) {
    let indice = Math.floor(Math.random() * 4);
    let clima = climas[indice];
    let cardChildren = card.children;
    cardChildren[0].innerHTML = clima.img;
    cardChildren[2].innerText = clima.estado;
    cardChildren[3].innerText = clima.temperatura;
  }

  document.querySelector("section").style.display = "block";
}
