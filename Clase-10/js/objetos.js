// OBJETOS
let persona = {
  nombre: "Candela",
  apellido: "Yarossi",
  id: 39111111,
  mostrarDatos: function () {
    return this.nombre + " " + this.apellido;
  },
  verObjeto: function () {
    return this;
  },
};

console.log(persona.mostrarDatos());
console.log(persona.verObjeto());

// THIS
console.log(this);
console.log(global);

// Acceder a info
console.log(persona.nombre);
console.log(persona["apellido"]);

// Modificar info
persona.nombre = "Cande";
console.log(persona);

// Agregar info
persona.colorFav = "Violeta";
console.log(persona);

persona["bootcamp"] = "FS Java - Banco Chile 10/25";
console.log(persona);

// OPERADOR IN
if ("id" in persona) {
  console.log("Esta persona tiene su nro de ID.");
}

if ("edad" in persona) {
  console.log("Esta persona tiene su edad definida.");
} else {
  persona.edad = 20;
}

console.log(persona);

// FOR ... IN
for (const nombreProp in persona) {
  console.log(nombreProp, ": ", persona[nombreProp]);
  console.log(nombreProp, ": ", persona.nombreProp);
}

// ARRAY DE OBJETOS
let user1 = { nombre: "User 1", email: "user1@mail.com", id: 1234 };
let user2 = { nombre: "User 2", email: "user2@mail.com", id: 5678 };
let user3 = { nombre: "User 3", email: "user3@mail.com", id: 9012 };

let users = [user1, user2, user3];
console.log(users);

let user4 = { nombre: "User 4", email: "user4@mail.com", id: 3456 };
users.push(user4);
console.log(users);

// FOR ... OF
for (const user of users) {
  console.log("Mail: ", user.email);
}
