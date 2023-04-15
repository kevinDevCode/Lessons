//Indentar con teclado es alt + shift + mayúscula
const todos = JSON.parse(localStorage.getItem('todos')) || [] //Colocaremos en este arreglo variables locales que no se eliminarán aunque refresquemos el explorador
// JSON.parse(localStorage.getItem('todos')) || [] : Te devolverá un arreglo vació si no encuentra nada dentro de su arrreglo con la llave 'todos' en vez de un null.
//JSON.parse: convierte arreglos el string de localStorage

const render = () => { //El indice del arreglo con el que lanza el explorador no son los mismos, no se actualizaron, por eso se necesita que hacer recursividad
    //Simplificando con .map
    const todoList = document.getElementById('todo-list');
    const todosTemplate = todos.map(t => '<li>' + t + '</li>'); //Una función map crea instrucciones para un arreglo que se creó y te las devuelve en otro arreglo con las instrucciones en ves de un for
    todoList.innerHTML = todosTemplate.join(''); //Genera en cada uno de los espacios llenos del arreglo un salto para que se una uno a uno lo que se coloque en el input

    //Eliminar valores de la página web que entraron por el formulario (LO HIZO EN LA PÁGINA WEB EN LA CONSOLA).
    //Se utiliza la función "Array.splice" para eliminar los valores. Array.splice(primer valor representa desde que valor empezando desde el 0 va a empezar, el segundo valor representa cantidad de valores a partir del que se puso en el anterior puesto se empezará a eliminar)

    //Buscando valores en la página web con "querySelectorAll" en el array.
    const elementos = document.querySelectorAll('#todo-list li') //Buscar valores ya sea por id como "todo-list" o por etiquetas como "li" o combinadas, document es la página que está siendo diseñada, se hace del más pequeño al más grande
    Array.from(elementos); //Genera un arreglo de los valores que salen de la constante "elementos"

    //Funcionalidad del programa para eliminar elementos de la lista
    elementos.forEach((elemento, i) => {
        elemento.addEventListener('click', () => { // Esta función sirve cuando el elemento que le des click se va a ejecutar la instrucción que le pongas debajo}
            elemento.parentNode.removeChild(elemento) //Llama a la etiqueta padre "todo-list" que si tiene autoridad para eliminar las etiquetas hijos, en este caso la etiqueta hijo es <li>  
            todos.splice(i, 1) //Elimina del array del código el valor que estamos dando click, es necesario porque de esa manera al querer agregar otro valor no volverá a colocar todos los valores de nuevo
            actualizaTodos(todos)
            render() //Esto es recursividad, es cuando una función se llama a sí misma, esto sirve en ocasiones que queremos actualizar los datos que se descartaron o agregar.
        })
    })
}
const actualizaTodos = (todos) => {
    const todoStrings = JSON.stringify(todos)
    localStorage.setItem('todos', todoStrings)
}
window.onload = () => {
    render()
    const form = document.getElementById("todo-form");
    form.onsubmit = (e) => //especifica una función de controlador de eventos que se invoca cuando el usuario envía un formulario haciendo clic en el botón Enviar en el formulario.
    {
        e.preventDefault(); //Previene el refrescado de la página
        const todo = document.getElementById('todo');
        const todoText = todo.value;
        todo.value = ''; //Después de obtener la información, cambiamos el valor del todo por un vacío para que desaparezca el valor en pantalla

        //Agregando valores de un formulario
        todos.push(todoText); //Agregamos el valor que se puso en la página en el arreglo.
        actualizaTodos(todos)
        render()
    }
}
