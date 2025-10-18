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

if (str) {
  console.log(str);
}

if (false == "false") {
  // -> false
  console.log("?");
}

// false (booleano) -> 0
//   0 == "false"
//   0 == NaN (Not a Number)
//    false

// OPERADORES LÓGICOS

// and (y)         -> &&
// or (o)          -> ||
// not (negacion)  -> !

// Álgebra de Boole -> tablas de verdad.

console.log("AND: ");

console.log("- true AND true: ", true && true); // true
console.log("- true AND false: ", true && false); // false
console.log("- false AND true: ", false && true); // false
console.log("- false AND false: ", false && false); // false

console.log("OR: ");

console.log("- true OR true: ", true || true); // true
console.log("- true OR false: ", true || false); // true
console.log("- false OR true: ", false || true); // true
console.log("- false OR false: ", false || false); // false

console.log("NOT: ");

console.log("- NOT true: ", !true); // false
console.log("- NOT false: ", !false); // true

// EJEMPLOS

let nombre = "";

//  false  &&    true    &&    true      ->
//        false          &&    true      -> false
if (nombre && esMenorA10 && numero == 5) {
  console.log("primer IF");
}

//  false  ||    true    ||    true      ->
//        true           ||    true      -> true
if (nombre || esMenorA10 || numero == 5) {
  console.log("segundo IF");
}

//  false  || (    true   &&    true    ) ->
//  false  ||            true             -> true
if (nombre || (esMenorA10 && numero == 5)) {
  console.log("tercer IF");
}
