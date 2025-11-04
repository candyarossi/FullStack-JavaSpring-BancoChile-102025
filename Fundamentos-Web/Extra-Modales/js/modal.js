async function abrirModal(card) {
  let name = card.children[1].innerText.toLowerCase();
  let info = await getByURL("https://pokeapi.co/api/v2/pokemon/" + name);

  document.getElementById("modal-content").innerHTML = `
        <img src="${info.sprites.front_default}" alt="">
        <div id="modal-text">
          <h2>${info.name.toUpperCase()}</h2>
          <h4>Types:</h4>
          <ul id="typesList">
            ${info.types
              .map((element) => `<li>${capitalize(element.type.name)}<li>`)
              .join("")}
          </ul>
          <h4>Stats:</h4>
          <ul id="statsList">
            ${info.stats
              .map(
                (element) =>
                  `<li><b>${element.stat.name.toUpperCase()}:</b> ${
                    element.base_stat
                  }<li>`
              )
              .join("")}
          </ul>
        </div>
        <span onclick="cerrarModal()">x</span>
    `;

  document.getElementById("modal").style.display = "flex";
}

function cerrarModal() {
  document.getElementById("modal-content").innerHTML = "";
  document.getElementById("modal").style.display = "none";
}
