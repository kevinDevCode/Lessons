const todos = [];
window.onload = () => { 
    const form = document.getElementById("todo-form");
    form.onsubmit = (e) => //especifica una función de controlador de eventos que se invoca cuando el usuario envía un formulario haciendo clic en el botón Enviar en el formulario.
    {
        e.preventDefault(); //Previene el refrescado de la página
        const todo = document.getElementById('todo');
        const todoText = todo.value;
        todo.value = ''; //Después de obtener la información, cambiamos el valor del todo por un vacío para que desaparezca el valor en pantalla
        todos.push(todoText); //Agregamos el valor que se puso en la página en el arreglo.
        const todoList = document.getElementById('todo-list')
        todoList.innerHTML = ''; //Hace que no esté agregando repetidas veces el mismo valor, sino eliminar la lista para agregar más
        for(let i=0; i < todos.length;i++)
        {
            todoList.innerHTML +=  '<li>' + todos[i] + '</li>'
        }
    }
}
