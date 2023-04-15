/*"A tutorial introduction to the programming language B Brian Kernighan" es donde se puso pro primera vez un hola mundo*/
console.log('Hola mundo')

/*TIPOS DE VARIABLES*/
//Tipos de datos en JS
//String: cadena de caracteres. 'a', 'hola mundo maravilloso'
// Boolean: true false.
//Null: nulo.
//Number : 12345532
//"123" es un string, es distinto a 123 en Number
//Undefined. una variable que aún no ha sido definida,para después poder ser definida.
//NOTA: Undefined es distinto a Null porque Null ya se definió la variable como nulo y Undefined no se ha designado valor a la variable.
//Object: Objeto. Puedes agregar cualquier de las anteriores variables, pero lo que tiene es que puedes organizar distintas de las anteriores variables en una sola variable.

/*DESIGNAR VARIABLE*/
//Definición de variables
//var: Cuando se asigna variable con esta función, coloca la variable que se acaba de definir hasta al principio del código.
//let: La mejor opción para asignar vairbale
//const

//var miPrimerVariable = 'lala'; no se recomienda usar var
let miPrimerVariable = 'Mi primera variable en Javascript'
console.log(miPrimerVariable)
//Mutabilidad: Modificar el valor que ya tenía una variable
miPrimerVariable = "Esto ha cambiado a mejor"
console.log(miPrimerVariable)
//Boolean
let miBoolean = true
let miOtroBoolean = false

let miNumero = 0 //Cuando definamos una variable empezar con una letra del alfabeto y un nombre adecuado
let miNumero2 = 12
let miNumero3 = -2
//console.log(miNumero,miNumero2,miNumero3,miBoolean,miPrimerVariable)
let undef
console.log(undef)
let nulo = null
console.log(nulo)

//Objeto Vacío
const miPrimerObjeto = {}

//Objeto
const miObjeto = 
{
    unNumero: 12,
    unString: "Esta cadena de caracteres",
    unaCondicion: true,
}
console.log(miObjeto)
console.log(miObjeto.unString)

//Arreglo
const arrVacio = []
const arr = [1,2,"hola","mund",miObjeto]
//console.log(arrVacio,arr)
arrVacio.push(5)
arrVacio.push(miPrimerObjeto)
arrVacio.push(miPrimerVariable)
console.log(arrVacio)

//Operadores Matemáticos.

const suma = 1 + 2
const restar = 1 - 2
const multplicar = 2 * 3
const division =  9 / 3

//console.log(suma,restar,multplicar, division)

const modulo = 10 % 3
//console.log(modulo)

let num = 5
/*num ++ 
console.log(num)
num--
num--
console.log(num)
num += 6
console.log(num)*/
num += 5 
num -= 5 
num *= 5
num /= 2
console.log(num)

//Operadores Comparativos

//Igualdad estricta
const resultado1 = 5===6 //Comparación
// Igualdad no estricta, strings pueden ser iguales a números si el valor es el mismo
const resultado2 = 5==='5'

const resultado3 = 5 < 6
const resultado4 = 5 < 5
const resultado5 = 5 > 6
const resultado6 = 5 > 4
const resultado7 = 5 >= 5
const resultado8 = 5 <= 6
const resultado9 = 5 >= 5
const resultado10 = 5 >= 6

const resultado11 = 5!== '5' //Es true porque son distintos tipos de valores y es estricto por los 3 símbolos
const resultado12 = 5 !='5'

//console.log(resultado11,resultado12)

//Comparadores Lógicos
// or (||), and (&&), not (!)
// Nota: El "shorcircuit" es la evalucación que se hace al programa y hasta donde vea un true si es un or se corta o en un and un false

const resultadoOr = false || false || 'Pepe el grillo' || true //Si colocas strings o números se evalúa como "true" y te da el valor que pusiste, excepto el 0, lo identifica como "false"

const resultadoAnd = true && true

const resultadoNot = !true

console.log(resultadoOr)


//Control de Flujo IF
/*const edad = 5
if(edad > 5 && edad < 18)
{
    console.log("tiene la edad permitida")
}
else
{
    console.log("no tiene la edad permitida")
}*/

//Control de flujo WHILE
let x = true
while(x)
{
    //console.log(x)
    x = false
}

//Control de flujo - switch
/*
let y = 2;
switch(y) 
{
    case 1:
        {
            console.log("Yo soy el caso  1");
            break;
        }
    case 2:
        {
            console.log("chanchito feliz");
            break;
        }
    default:
    {
        console.log("no hay chanchito");
        break;
    }
}
*/

//Control de flujp - for
/*
for(let i = 0; i < 10; i++)
{
    console.log(i);
}
*/



//Introducción a Funciones

/*function iterar(arg1)
{
    for(let i = 0; i < arg1.length; i++)
    {
        console.log(arg1[i]);
    }
}
const numeros = [1, 2, 3, 4, 5,"live"]
const nombres = ['pedro','Juan','Chanchit']
iterar(nombres)
iterar(numeros)
*/

/*
function Suma(a,b)
{
    console.log(a+b)
    return a + b
}
const resultadoSuma1 = Suma(1,2)
const resultadoSuma2 = Suma(5,6)
const resultadoSuma3= Suma(resultadoSuma1,resultadoSuma2)
console.log("Resultado " + resultadoSuma3)
*/

function sumar(a,b,cb)
{
    const r = a + b
    cb(r)
}

function callback(result)
{
    console.log('resultado', result)
}
//sumar(2,3,callback)


//FAT ARROW FUNCTION.

const miFarArrowFunction = (a,b) => a + b //se utiliza cuando solo se tiene una línea de código y que te regrese el valor sin el return
const otraFAF = (a,b) =>  //Si hay más de una línea de código a ejecutar en el FAF se le debe colocar return para obtener valor
{
    return a + b
}
const r1 = miFarArrowFunction(1,2)
const r2 = otraFAF(1,2)
console.log(r1);
console.log(r2);


//FUNCIONES ANÓNIMAS
sumar(2,3,function(r) //Aunque es útil, no se recomienda porque no se puede volver a utilizar el código
{
    console.log("soy una función anónima ", r)
})