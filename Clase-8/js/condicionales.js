// Condicionales -> Estructura IF
let valor = false;

if (valor) {
  console.log("Hola chicas!");
}

// Operadores de Comparación

// ==               -> Es igual (compara solo el valor)
// ===              -> Es estrictamente igual (compara valor y también el tipo de dato)
// !=               -> No es igual / Es distinto
// !==              -> Es estrictamente distinto (compara valor y también el tipo de dato)
// <, <=, >, >=     -> Menor, menor o igual, mayor, mayor o igual

let numero = 5;

if (numero == 5) {
  console.log("El numero es igual a 5");
}

if (numero == 4) {
  console.log("El numero es igual a 4");
}

if (numero == 4) {
  console.log("El numero es igual a 4");
} else {
  console.log("El numero NO es igual a 4");
}

if (numero == 5) {
  console.log("A");
} else if (numero > 5) {
  console.log("B");
} else if (numero < 5) {
  console.log("C");
} else {
  console.log("D");
}

let esMenorA10 = numero < 10;

if (esMenorA10) {
  console.log("Es menor a 10.");
}

let str = "Hola";
// let nombre = '';

if (str) {
  console.log(str);
}

if (false == "false") {
  console.log("?");
}
