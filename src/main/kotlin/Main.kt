fun main() {

    val operator = getAndValidateOperator()

    val firstNumber = getAndValidateNumber("Please enter the first number.")
    val secondNumber = getAndValidateNumber("Please enter the second number.")

    performCalculation(operator, firstNumber, secondNumber)
}

fun getUserInput(inputRequest: String): String {
    println(inputRequest)
    return readln()
}

fun getAndValidateOperator(): String {
    var userInput = getUserInput("What operation would you like to perform? ( + , - , * , / )")
    val acceptableOperators = listOf(
        "+", "-", "*", "/"
    )
    while (!acceptableOperators.contains(userInput)) {
        userInput = getUserInput("That is not a valid operator. Please enter a valid operator. ( + , - , * , / )")
    }
    return userInput

}

fun getAndValidateNumber(numberRequest: String): Double {
    var userNumber = getUserInput("Please enter the first number.")
    var isNumberValid = isInputANumber(userNumber)
    while (!isNumberValid) {
        userNumber = getUserInput("That is not a number. Please enter a valid number.")
        isNumberValid = isInputANumber(userNumber)
    }
    return userNumber.toDouble()
}

fun isInputANumber(numberToCheck: String): Boolean {
    return when(numberToCheck.toDoubleOrNull())
    {
        null -> false
        else -> true
    }
}

fun performCalculation(operator: String, firstNumber: Double, secondNumber: Double) {
    var result: Double = 0.0
    when(operator) {
        "+" -> result = firstNumber + secondNumber
        "-" -> result = firstNumber - secondNumber
        "*" -> result = firstNumber * secondNumber
        "/" -> result = firstNumber / secondNumber
    }
    println("$firstNumber $operator $secondNumber = $result")
}