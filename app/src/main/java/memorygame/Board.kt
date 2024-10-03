package memorygame

class Board( ) {
    //Constructor to create board of different sizes.
    // Assign
    private var cards: Array<Card> = emptyArray<Card>()

    init {
        cards = arrayOf(
            Card('H', "2"),
            Card('H', "2"),
            Card('S', "4"),
            Card('S', "4"),
            Card('D', "6"),
            Card('D', "6")
        )
    }

    fun getValueAt(index:Int): Card {
        return cards[index]
    }

    data class Card(val suit: Char, val rank: String) {

    }
}