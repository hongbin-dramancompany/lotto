package kotlin

class LottoGenerator {
    fun generate(count: Int): List<List<Int>> {
        val results = mutableListOf<List<Int>>()

        repeat(count) {
            val lotto_numbers = (1..45).shuffled().take(6).sorted()
            results.add(lotto_numbers)
        }

        return results
    }
}