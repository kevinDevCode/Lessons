window.onload = () => { /*window.onload: se utiliza cuando se quiere esperar a que se cargue toda la pága HTML y después cargar la parte de javascript*/
    const parrafo = document.getElementById("text")
    parrafo.innerText = 'Texto Actualizado por Java Script' //Sirve para modificar Texto dentro de Javascript
    parrafo.innerHTML = '<li>Elemento 1</li><li>elemento 2</li>' //Sirve para agregar estructuras de HTML desde JavaScript
}
