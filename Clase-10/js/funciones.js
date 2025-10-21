// FUNCION SIN PARAMETROS
function suma2numeros() {
  let numero1 = 5;
  let numero2 = 4;
  let suma = numero1 + numero2;
  console.log("SUMA2NUMEROS -> El resultado es: ", suma);
}

suma2numeros();

if (false) {
  suma2numeros();
}

// FUNCION CON PARAMETROS
function sumar(num1, num2) {
  let suma = num1 + num2;
  console.log("SUMAR -> El resultado es: ", suma);
}

//console.log(suma);
sumar(2, 5);
sumar(7, 1);

// FUNCION CON PARAMETROS Y RETORNO
function rtaSuma(num1, num2) {
  let suma = num1 + num2;
  return suma;
}

let rta = rtaSuma(4, 3);
console.log(rta);
console.log("RTASUMA -> El resultado es: ", rta);

// FUNCION CON PARAMETROS Y RETORNO
function saludar(nombre) {
  let str = "Hola, " + nombre + "!";
  return str;
}

console.log(saludar("Constanza"));
console.log(saludar("Valeria"));
console.log(saludar("Alondra"));

let input = "Alejandra";
let saludo = saludar(input);

console.log(saludo);
//alert(saludo);

// Cálculo de perímetro y área de un rectángulo
let altura = 4;
let ancho = 5;

// Función Anónima
const calcularArea = function (par1, par2) {
  return par1 * par2;
};
console.log("AREA -> ", calcularArea(altura, ancho));

// Función Flecha (=>)
const calcularPerimetro = (par1, par2) => (par1 + par2) * 2;
console.log("PERIMETRO -> ", calcularPerimetro(altura, ancho));

const calcularPerimetroDeCuadrado = (par1) => par1 * 4;
console.log("PERIMETRO DE UN CUADRADO -> ", calcularPerimetroDeCuadrado(9));
