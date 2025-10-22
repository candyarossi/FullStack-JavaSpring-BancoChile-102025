const imgSkillnest =
  "https://learning.skillnest.com/wp-content/uploads/2023/11/LOGO-CORREO_x.png";

// DOM -> Document Object Model (Modelo de Objetos del Documento)
console.dir(document);
console.dir(document.head);
console.dir(document.body);

// getElementsByTagName(); -> Devuelve todos los elementos que coincidan con un nombre de etiqueta (tag).
let itemXtagname = document.getElementsByTagName("li");

console.dir(itemXtagname);

for (const item of itemXtagname) {
  console.log(item);
  console.dir(item);
}

// getElementsByClassName(); -> Devuelve todos los elementos que coincidan con un nombre de clase (class).
let enlacesXclass = document.getElementsByClassName("enlaces");

console.dir(enlacesXclass);

for (const enlace of enlacesXclass) {
  console.log(enlace);
  console.dir(enlace);
}

// getElementById(); -> Devuelve el elemento que coincida con un nombre de id (id).
let item3 = document.getElementById("item3");

console.log(item3);
console.dir(item3);

// MODIFICAR UN NODO
// innerText
console.log(item3.innerText);

if (item3.innerText === "Item 3") console.log("123");
else console.log("456");

item3.innerText = "Nuevo Item 3";

// innerHTML
console.log(item3.innerHTML);

item3.innerHTML = '<img src="' + imgSkillnest + '" width="20%">';

console.log(item3.innerHTML);

// className / classList - id
let segundoEnlace = enlacesXclass[1];

segundoEnlace.className = "otraClase";

segundoEnlace.className += " nuevaClase";

segundoEnlace.id = "enlace2";

console.log(segundoEnlace.classList);
console.log(segundoEnlace.className);

console.log(segundoEnlace);

// AGREGAR O QUITAR NODOS
let lista = document.getElementById("lista");

// Crear
let nuevoItem = document.createElement("li");
nuevoItem.innerText = "Nuevo Item nro 4";
nuevoItem.className = "otraClase";

// Agregar
lista.append(nuevoItem);

// Quitar
item3.remove();

// querySelector(); -> Devuelve el primer elemento que coincida con un nombre de etiqueta, class o id.
// Hay que agregarle el '.' si es una class o el '#' si es un id.
let listaXquery = document.querySelector("#lista");
console.log(listaXquery);

let enlacesXquery = document.querySelector(".enlaces");
console.log(enlacesXquery);

let liXquery = document.querySelector("li");
console.log(liXquery);

// querySelectorAll(); -> Devuelve todos los elementos que coincidan con un nombre de etiqueta, class o id.
// Hay que agregarle el '.' si es una class o el '#' si es un id.
let liXqueryAll = document.querySelectorAll("li");
console.log(liXqueryAll);

let enlacesXqueryAll = document.querySelectorAll(".enlaces");
console.log(enlacesXqueryAll);

for (const enlace of enlacesXqueryAll) {
  enlace.innerText += " ABC";
}
