# CSS GRIDS

## Introducción

En la clase anterior vimos **`Flexbox`**, un método de diseño de página unidimensional para organizar elementos en filas o columnas, pero en ocasiones podemos notar que este método es insuficiente para poder llevar a cabo ciertos diseños más complejos.

Ahora hablaremos sobre **`CSS Grids`** o **`Grillas`**, un nuevo método de diseño, creado a partir de Flexbox pero más potente que él, ya que se pensó para el diseño bidimensional, en varias filas y columnas al mismo tiempo.

### Código inicial del EJEMPLO:

```html
<!-- HTML -->

<div id="grilla">
  <header class="border">Header</header>
  <section id="productos" class="border">
    <div>Producto 1</div>
    <div>Producto 2</div>
    <div>Producto 3</div>
    <div>Producto 4</div>
  </section>
  <section id="servicios" class="border">
    <div class="serv1">Servicio 1</div>
    <div>Servicio 2</div>
    <div>Servicio 3</div>
    <div>Servicio 4</div>
  </section>
  <nav class="border">Navegacion</nav>
  <aside class="border">Aside</aside>
  <footer class="border">Pie de pagina</footer>
</div>
```

```css
/* CSS */

#productos div,
#servicios div {
  border: solid 1px;
  padding: 5px;
  background-color: bisque;
}

.border {
  border: 1px solid black;
}
```

## Implementar Grids

Activamos la cuadrícula Grid utilizando, sobre el elemento contenedor, la propiedad `display` con el valor `grid`.

```css
#grilla {
  display: grid;
}
```

### Filas y columnas explícitas

Es posible crear cuadrículas con un tamaño definido. Para ello, sólo tenemos que usar las propiedades CSS `grid-template-columns` y `grid-template-rows`, sirven para indicar las dimensiones de cada celda de la cuadrícula, diferenciando entre columnas y filas.

- **Propiedad `grid-template-columns`:** Establece el tamaño de las columnas (eje horizontal). Puedes probar su funcionamiento [aquí](https://developer.mozilla.org/en-US/docs/Web/CSS/grid-template-columns).
- **Propiedad `grid-template-rows`:** Establece el tamaño de las filas (eje vertical). Puedes probar su funcionamiento [aquí](https://developer.mozilla.org/en-US/docs/Web/CSS/grid-template-rows).

- Sus posibles valores son: - numéricos - (acompañados de la unidad de medida y combinables entre sí), y `auto` (obtiene el tamaño restante de la columna o fila y lo divide en partes iguales según cuántas veces ha sido utilizado).

```css
#grilla {
  display: grid;
  grid-template-columns: 20% auto 20%;
  grid-template-rows: 100px auto auto 75px;
}
```

## Grid por áreas

Es posible indicar el nombre y la posición concreta de cada área de la cuadrícula utilizando la propiedad `grid-template-areas`, donde debemos especificar el orden de las áreas, y luego, en cada ítem hijo, utilizamos la propiedad `grid-area` para indicar el nombre del área del que se trata. Cada conjunto de palabras escritas entre comillas (`“ ”`) en la propiedad `grid-template-areas` representará una fila en la grilla, indicando en cada una de las celdas de esa fila que elemento la ocupará.

De esta forma, es muy sencillo crear una cuadrícula altamente personalizada en apenas unas cuantas líneas de CSS.

En la propiedad `grid-template-areas` también podemos indicar una palabra clave especial:

- **La palabra clave `none`:** Indica que no se colocará ninguna celda en esta posición.
- **Uno o más puntos (`.`):** Indica que se colocará una celda vacía en esta posición.

```css
#grilla {
  display: grid;
  grid-template-columns: 20% auto 20%;
  grid-template-rows: 100px auto auto 75px;
  grid-template-areas: "header header header" "menuNav productos publicidad" "menuNav servicios ." "contacto contacto contacto";
}

header {
  grid-area: header;
}

nav {
  grid-area: menuNav;
}

#productos {
  grid-area: productos;
}

#servicios {
  grid-area: servicios;
}

aside {
  grid-area: publicidad;
}

footer {
  grid-area: contacto;
}
```

> Puedes probar su funcionamiento [aquí](https://developer.mozilla.org/en-US/docs/Web/CSS/grid-template-areas).

## Grid espacios o gap

La cuadrícula tiene todas sus celdas una a continuación de la otra. Aunque sería posible darle un margen a las celdas dentro del contenedor, existe una forma más apropiada, evitando los problemas clásicos de los modelos de caja: los huecos (`gutters`).

- **Propiedad `column-gap`:** Establece el tamaño de los espacios entre columnas (eje horizontal). Puedes probar su funcionamiento [aquí](https://developer.mozilla.org/en-US/docs/Web/CSS/column-gap).
- **Propiedad `row-gap`:** Establece el tamaño de los espacios entre filas (eje vertical). Puedes probar su funcionamiento [aquí](https://developer.mozilla.org/en-US/docs/Web/CSS/row-gap).

```css
#grilla {
  display: grid;
  grid-template-columns: 20% auto 20%;
  grid-template-rows: 100px auto auto 75px;
  grid-template-areas: "header header header" "menuNav productos publicidad" "menuNav servicios ." "contacto contacto contacto";
  gap: 10px;
  column-gap: 15px;
  row-gap: 20px;
}
```

## Posición de elementos

Existen propiedades que se pueden utilizar para colocar los ítems dentro de la cuadrícula en ciertas posiciones específicas.

Podemos distribuir los elementos de una forma muy sencilla y cómoda, utilizando `justify-ítems` y `align-items`, que ya conocemos de la clase anterior: **Flexbox**.

Por otro lado, también podemos utilizar las propiedades `justify-content` o `align-content` para cambiar la distribución de todo el contenido en su conjunto.

### Propiedad justify-items

Distribuye los elementos en el eje horizontal dentro de cada una de sus celdas.

- Sus posibles valores son: `start`, `end`, `center`, `stretch`.

<div align="center">
	<img src="./images/grid-justify-items.png" alt="justify-items" title="justify-items">
</div>

```css
#productos,
#servicios {
  display: grid;
  grid-template-columns: auto auto;
  grid-template-rows: auto auto;
  gap: 10px;
  height: 250px;
}

#productos {
  justify-items: stretch;
}
```

> Puedes probar su funcionamiento [aquí](https://developer.mozilla.org/en-US/docs/Web/CSS/justify-items).

### Propiedad align-items

Distribuye los elementos en el eje vertical dentro de cada una de sus celdas.

- Sus posibles valores son: `start`, `end`, `center`, `stretch`.

<div align="center">
	<img src="./images/grid-align-items.png" alt="align-items" title="align-items">
</div>

```css
#productos {
  justify-items: stretch;
  align-items: stretch;
}
```

> Puedes probar su funcionamiento [aquí](https://developer.mozilla.org/en-US/docs/Web/CSS/align-items).

### Propiedad justify-content

Distribuye los elementos en conjunto en el eje horizontal dentro del grid container.

- Sus posibles valores son: `start`, `end`, `center`, `stretch`, `space-around`, `space-between`, `space-evenly`.

<div align="center">
	<img src="./images/grid-justify-content.png" alt="justify-content" title="justify-content">
</div>

```css
#servicios {
  justify-content: space-evenly;
}
```

> Puedes probar su funcionamiento [aquí](https://developer.mozilla.org/en-US/docs/Web/CSS/justify-content).

### Propiedad align-content

Distribuye los elementos en conjunto en el eje vertical dentro del grid container.

- Sus posibles valores son: `start`, `end`, `center`, `stretch`, `space-around`, `space-between`, `space-evenly`.

<div align="center">
	<img src="./images/grid-align-content.png" alt="align-content" title="align-content">
</div>

```css
#servicios {
  justify-content: space-evenly;
  align-content: space-evenly;
}
```

> Puedes probar su funcionamiento [aquí](https://developer.mozilla.org/en-US/docs/Web/CSS/align-content).

## Propiedades de ítems

Hasta ahora hemos visto propiedades CSS que se aplican solamente al contenedor padre de una cuadrícula. Ahora vamos a ver ciertas propiedades que se aplican a cada ítem hijo de la cuadrícula, para alterar o cambiar el comportamiento específico de dicho elemento.

### Propiedad justify-self

Altera la justificación del ítem hijo en el eje horizontal.

- Sus posibles valores son: `start`, `end`, `center`, `stretch`.

<div align="center">
	<img src="./images/grid-justify-self.png" alt="justify-self" title="justify-self">
</div>

```css
.serv1 {
  justify-self: center;
}
```

> Puedes probar su funcionamiento [aquí](https://developer.mozilla.org/en-US/docs/Web/CSS/justify-self).

### Propiedad align-self

Altera la alineación del ítem hijo en el eje vertical.

- Sus posibles valores son: `start`, `end`, `center`, `stretch`.

<div align="center">
	<img src="./images/grid-align-self.png" alt="align-self" title="align-self">
</div>

```css
.serv1 {
  justify-self: center;
  align-self: center;
}
```

> Puedes probar su funcionamiento [aquí](https://developer.mozilla.org/en-US/docs/Web/CSS/align-self).
