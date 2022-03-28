fun main() {

    val operator = getAndValidateOperator()
    println(operator)

    val firstNumber = getAndValidateNumber("Please enter the first number.")
    println(firstNumber)
    val secondNumber = getAndValidateNumber("Please enter the second number.")
    println(secondNumber)

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

fun getAndValidateNumber(numberRequest: String): Int {
    var userNumber = getUserInput("Please enter the first number.")
    var isNumberValid = isInputANumber(userNumber)
    while (!isNumberValid) {
        userNumber = getUserInput("That is not a number. Please enter a valid number.")
        isNumberValid = isInputANumber(userNumber)
    }
    return userNumber.toInt()
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