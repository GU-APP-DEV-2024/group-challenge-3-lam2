package memorygame

class Board( ) {
    //Constructor to create board of different sizes.
    // Assign
    private var cards: Array<Card> = emptyArray<Card>()

    init {

    }

    fun getValueAt(index:Int): Card {
        return cards[index]
    }

    data class Card(val suit: Char, val rank: String) {

    }
}