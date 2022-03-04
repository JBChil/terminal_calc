import com.sun.org.apache.xpath.internal.operations.Bool
import javafx.beans.binding.When
import java.util.logging.Handler

fun main() {

    println("What operation would you like to perform? ( + , - , * , / )")
    val userInput = readln()
    var validOperator: String = ""
    if (validateOperator(userInput)) {
        validOperator = userInput
    } else {
        print("This is not a valid operation.")
    }

    println("Please enter the first number: ")
    val firstNumber = getUserNumberInput()

    println("Please enter the second number: ")
    val secondNumber = getUserNumberInput()

    performCalculation(validOperator, firstNumber, secondNumber)
}

fun validateOperator(userInput: String): Boolean {

    val acceptableOperators = listOf<String>(
        "+", "-", "*", "/"
    )
    return acceptableOperators.contains(userInput)
}

fun getUserNumberInput(): Int {
    val number = readln()

    var isNumberValid = false
    while (!isNumberValid) {
        if (isInputANumber(number)) {
            isNumberValid = true
        } else {
            println("This is not a valid number Please enter a valid number.")
        }
    }
    return number.toInt()
}

fun isInputANumber(numberToCheck: String): Boolean {
    return when(numberToCheck.toIntOrNull())
    {
        null -> false
        else -> true
    }
}

fun performCalculation(operator: String, firstNumber: Int, secondNumber: Int) {
    var result: Int = 0
    when(operator) {
        "+" -> result = firstNumber + secondNumber
        "-" -> result = firstNumber - secondNumber
        "*" -> result = firstNumber * secondNumber
        "/" -> result = firstNumber / secondNumber
    }

    println("$firstNumber $operator $secondNumber = $result")
}