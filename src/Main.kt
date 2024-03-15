fun main() {
    val expr = BinOp(Number(5.0), '+', BinOp(Number(3.0), '*', Number(2.0)))
    printAST(expr)
}

fun printAST(expr: Expr, indent: String = "") {
    when (expr) {
        is Number -> println("$indent${expr.value}")
        is BinOp -> {
            println("$indent${expr.op}")
            printAST(expr.left, "$indent  ")
            printAST(expr.right, "$indent  ")
        }
    }
}

sealed class Expr

data class Number(val value: Double) : Expr()

data class BinOp(val left: Expr, val op: Char, val right: Expr) : Expr()