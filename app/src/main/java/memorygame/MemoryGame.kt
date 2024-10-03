package memorygame

class MemoryGame(private val size: Int) {

    private val board: Array<Array<String?>> = Array(size) { arrayOfNulls<String>(size) }
    private val revealedPositions: MutableList<Pair<Int, Int>> = mutableListOf()

    init {
        val cards = ('A' until 'A' + size * size / 2).toList() + ('A' until 'A' + size * size / 2).toList()
        val shuffledCards = cards.shuffled()
        var index = 0
        for (i in 0 until size) {
            for (j in 0 until size) {
                board[i][j] = shuffledCards[index].toString()
                index++
            }
        }
    }

    fun displayBoard() {
        for (i in 0 until size) {
            for (j in 0 until size) {
                if (revealedPositions.contains(Pair(i, j))) {
                    print("${board[i][j]} ")
                } else {
                    print("* ")
                }
            }
            println()
        }
    }

    fun revealCard(row: Int, col: Int): Boolean {
        if (row < 0 || row >= size || col < 0 || col >= size || revealedPositions.contains(Pair(row, col))) {
            println("Invalid move or already revealed position.")
            return false
        }
        revealedPositions.add(Pair(row, col))
        return true
    }

    fun isMatch(): Boolean {
        if (revealedPositions.size != 2) return false
        val first = revealedPositions[0]
        val second = revealedPositions[1]
        return board[first.first][first.second] == board[second.first][second.second]
    }

    fun resetUnmatched() {
        if (!isMatch()) {
            revealedPositions.clear()
        }
    }

    fun isGameOver(): Boolean {
        return revealedPositions.size == size * size
    }

    fun getRevealedCount(): Int {
        return revealedPositions.size
    }
}

fun main() {
    val game = MemoryGame(4)
    game.displayBoard()

    while (!game.isGameOver()) {
        println("Enter row and column to reveal a card (e.g., 0 1): ")
        val (row, col) = readLine()?.split(" ")?.map { it.toInt() } ?: continue

        if (game.revealCard(row, col)) {
            game.displayBoard()
            if (game.getRevealedCount() == 2) {
                if (game.isMatch()) {
                    println("It's a match!")
                } else {
                    println("No match, try again.")
                    game.resetUnmatched()
                }
            }
        }
    }

    println("Congratulations! You've completed the Memory Game!")
}