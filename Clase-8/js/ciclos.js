// BUCLES o CICLOS

// Tipos de ciclos
// Ciclos por conteo -> FOR
// Ciclos condicionales -> WHILE, DO-WHILE

// FOR
for (desde; hasta; actualizacion) {
  // Código a repetir
}

// factorial -> 4! = 4*3*2*1
let num = 4;
let factorial = 1;

for (let i = 1; i <= num; i++) {
  // i++ -> i = i + 1
  // i-- -> i = i - 1
  factorial = factorial * i;
}

console.log("RESULTADO 4! = ", factorial);

// WHILE
while (condicion) {
  // Código a repetir
}

let i = 1;

while (i <= num) {
  factorial = factorial * i;
  i++;
}

console.log("RESULTADO 4! = ", factorial);

// ARRAYS (Arreglos)

let alumnas = ["Joselyn", "Camila", "Emilia", "Maciel", "Lorena"];
//     i    =      0          1         2         3         4

console.log(alumnas[2]);
console.log(alumnas[0]);
console.log(alumnas[10]);

console.log(alumnas);

for (let i = 0; i <= 4; i++) {
  console.log(alumnas[i]);
}

console.log("AGREGAMOS ELEMENTOS");

// Agregar al final
alumnas.push("Susana");

// Agregar al principio
alumnas.unshift("Constanza");

// Conocer tamaño del Array
let tamano = alumnas.length;
console.log("Cantidad de elementos: ", tamano);

for (let i = 0; i < tamano; i++) {
  console.log(alumnas[i]);
}

console.log("QUITAMOS ELEMENTOS");

// Quitar del final
let ultimoElemento = alumnas.pop();

// Quitar del principio
let primerElemento = alumnas.shift();

for (let i = 0; i < alumnas.length; i++) {
  console.log(alumnas[i]);
}

console.log("Ultimo elemento eliminado: ", ultimoElemento);
console.log("Primer elemento eliminado: ", primerElemento);
