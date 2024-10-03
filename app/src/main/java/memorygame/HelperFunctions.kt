package memorygame

class HelperFunctions {
    fun shuffleCards(cards:List<String>): List <String> {
        return cards.shuffled()
    }
    fun isMatch(card1: String, card2: String): Boolean {
        return card1 == card2
    }
    fun generateCardPairs(cardTypes: List<String>): List<String> {
        return cardTypes.flatMap { listOf(it, it) }
    }
    fun isGameComplete(matchedCards: Set<String>, totalPairs: Int): Boolean {
        return matchedCards.size == totalPairs
    }
}