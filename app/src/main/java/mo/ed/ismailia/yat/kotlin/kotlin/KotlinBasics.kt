package mo.ed.ismailia.yat.kotlin.kotlin

import java.util.Arrays
import java.util.SimpleTimeZone

// interview question
// compile time
const val PI = 3.14

//runtime
/*
val -> cannot be reassigned
var -> can be changed
 */

data class Fruit(var name: String? = null, var color: String? = null, var age: Int? = null)

data class Animal(var name: String? = null, var legs: Int? = null)

fun getName() {}

fun getResponseCode(responseCode: Int): Int = responseCode

class KotlinBasics {
}

fun printHello(name: String? = "mohamed", age: Int, salary: Double): Unit {
    println("Hi name: $name, age: $age, salary: $salary")
}

// compact function
fun sum(x: Int, y: Int) : Int {
    return x + y
}
// single-expression function
fun sum(x: Double, y: Int) : Double = x * y

fun decoding(jsonResponse: String, decode: (String)-> String) : String{
    return decode(jsonResponse)
}

fun messageRetrieval(message: String, func: (String)->String) : String{
    return func(message)
}

/*
{ message:String -> message.uppercase() }
 */

fun str(message: String) : String{
    return message.uppercase()
}

fun enc2(input:String): String = input.reversed()


fun main() {
    /*
    set
     */

    val numbers = setOf(1, 5, 9)
    println(numbers.map { it / 2 })

    val myListOfSets = listOf(setOf(1,2), setOf(4,8), setOf(12,18))
    println(myListOfSets.flatten())

    /*
    filters in kotlin
     */
    val myStrs = listOf("Cairo", "Capital", "Camel", "Lion", "Giza")
    val cList = myStrs.filter { it[0] == 'C' && it[1] == 'a' && it[2] == 'm' }
    println(cList)
    val ints = listOf(1,2,3,-1,-2, 5)
    val integrs = ints.filter { it < 0 }
    println(integrs)

    /*
    using :: operator
     */


    println( messageRetrieval("Mohamed", ::enc2))

    /*
    High-Order Functions
     */

    val decodingFun : (String) -> String = { msg-> msg.lowercase() }
    println( decoding("MOHAMED", decodingFun))

    println(messageRetrieval("CAIRO", decodingFun))

    /*
    Lambda functions
     */

    val myStringLambda = { message:String -> message.uppercase() }
    println(myStringLambda("abc"))
    println(str("oiu"))

    val myValue = 80
    val myLambdaFunction = { myValue :Int -> myValue + 5}
    println(myLambdaFunction(myValue))




    /*
    Functions
     */


    printHello(age = 8, salary = 8000.0)


    /*
    Null Safety
     */

    val fruit = Fruit("Apple", null, 2)
    val printValue = fruit.color?.length ?: "Hi, I am instead of null value"
    println("Color Length: $printValue")


    val animal = Animal(name = null, legs = 4)
    val giraphMessage = animal.name?.length ?: "Giraph length = 6"
    println("Giraph message: $giraphMessage")
//    vehicle?.wheels = 5  // safe to be null
//    vehicle!!.wheels = 5  // non-null type --> NullPointer Exception


    /*
    lists
     */

//    val musicalInstruments = listOf("trumpet", "piano", "violin")
//    val computerAccessories = listOf("Mouse", "Hard Disk Drive", "Monitor", "Keyboard")
//    println(musicalInstruments)
//    println(computerAccessories)
//
//    val mutableMusicalInstruments = mutableListOf("trumpet", "piano", "violin")
//    println("Mutable List v1: $mutableMusicalInstruments")
//
//    mutableMusicalInstruments.removeAt(1)
//    println("Mutable List v2[after remove]: $mutableMusicalInstruments")
//
//    val daysArray = arrayOf("Saturday", "Sunday", "Monday")
//    println(Arrays.toString(daysArray))
//
//    val arrNumbers = arrayOf(1, 2, 5, 8, 12)
//    println(Arrays.toString(arrNumbers))
//
//    val mixedArray = arrayOf(1, 2, "Mo", "Ahmed", false, 8, 2.5, 3.6f, true)
//    println(Arrays.toString(mixedArray))
//
//    val myIntArr =  intArrayOf(1, 56, 8, 7, 6, 3, 12)
//    val anotherIntArr = intArrayOf(2, 5, 8, 14)
//    println(Arrays.toString(myIntArr))
//
//    // combining 2 arrays
//
//    val combinedArray = anotherIntArr + myIntArr
//    println("Combined Array :" + Arrays.toString(combinedArray))


    /*
    Control Flow Statements
     */

    // for loop with ranges
    var numberOfBook = 80
    for (number in numberOfBook..90) {
        print("$number, ")
    }
    println()
    for (i in 1..50) {
        print("$i, ")
    }
    // down To
    println("\nDown To\n--------")
    for (i in 100 downTo 20 step 10) print("$i, ")
    println("\nRange Of Characters\n----------")
    for (i in 'a'..'z') print("$i, ")

    repeat(5) {
        print("Hi")
    }


    // if statement with range
//    var numberOfBook = 80
//    if (numberOfBook in 70 .. 90){
//        println("Books between 70:90 and exactly = 80")
//    }else{
//        println("Inapplicable")
//    }

    // when statement with ranges

//    var responseCode = getResponseCode(499)
//    when(responseCode){
//        200 -> println("Success Response")
//        in 300..500 -> println("Server Error or Not Reachable")
//        else -> println("Invalid Error Code")
//    }


    /*
    range
     */


    // while and Do while statements
//    var isPlaying = true
//    var x = 8
//    var y = 12
//
//    do {
//        if (x < y){
//            x++
//            println("isPlaying : $isPlaying and X is = $x")
//        }
//        if (x == 12){
//            isPlaying = false
//            println("isPlaying : $isPlaying")
//        }
//    }while (isPlaying)


    // if else statement
//    var x = 8
//    var y = 42
//    if (x > y ){
//
//    }else if(x < y){
//
//    }else if(x == y){
//
//    }else{
//
//    }


//    val numberOfDogs = 8
//    val numberOfCats = 10
//    println("Total number of Animals is ${numberOfDogs +numberOfCats}")


//    val name = "Mohamed Atef"
//    println("Length of My Name = ${name.length}")


//    println("\n\nMohamed Atef\n\n")
//    println("""
//
//
//        Mohamed Atef
//
//
//    """.trimIndent())

    /*
    type casting
     */
    println()
    val i: Int = 6
    val b: Byte = i.toByte() // type casting

    /*
    using underscore in long numbers
     */
//    Int oneMillion = 100000000000

    val oneMillion = 1_000_000_000
    println(oneMillion)
    println(oneMillion + 2)
    println(oneMillion / 2)


    /*
    operators
    mathematical operators
    + - / *  %
     */


//    var x = 10
//    var y = 10.3


//    x.div
//    println("Division $x / $y = ${x/y}")
//    println("Multiplication $x * $y = ${x*y}")


    /*
    comparison operators
     */
//    if (x == y){  /// Is -- yes / no  -  true / false
//        println("X is Equal Y")
//    }else{
//        println("Y is greater than X")
//    }
//    if (x < y){
//        println("X is greater than Y")
//    }else{
//        println("X is equal Y")
//    }
//    if (x >= y){
//        println("X is greater than Y")
//    }else{
//        println("Y is greater than X")
//    }
    /*
    increment operators
     */

//    x++
//    println(x)
//    y--
//    println(y)
//
//    println("Minus of $x - $y = ${x-y}")
//    println("Division of $x / $y = ${x/y}")
//    println("Multiplication of $x * $y = ${x*y}")
//    println("Sum of $x + $y = ${x+y}")


//    System.out.println("Sum Of " + x + " + " + y + " = " + (x+y))
//    println("Sum of $x + $y = ${x+y}")


//    var number = 8
//    number = 9
//    number = 10
//    println(number)
//    val num = 6

    /*
    difference between const an val
     */


//    val name = getName()


    println("Hello Ismailia - Yat 191")
    /*
    how to define variables and constants in kotlin
     */

////    Int x = 5;
//    var x = 5.5
////    boolean isPlaying = false;
//
//    // runtime
//    var isPlaying = false
//    var y: Int = 6
//
//    var z: Float = 8.2f
//    var name: String = "Mohamed"
//    var character: Char = '8'
    /*
    difference between var and val
     */
    // operation starts from compile time


}