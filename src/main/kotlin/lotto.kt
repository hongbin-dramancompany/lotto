class LottoConsole {
    fun getLottoCount(): Int {
        while (true) {
            print("구매하실 로또의 갯수를 입력해주세요 (최대 10개): ")
            val inputCount = readln().toIntOrNull()
            val lottoCount = validateLottoCount(inputCount)

            if (lottoCount != null) {
                return lottoCount
            } else {
                println("1에서 10 사이의 숫자를 입력해주세요.")
            }
        }
    }

    private fun validateLottoCount(inputCount: Int?): Int? {
        return if (inputCount in 1..10) inputCount else null
    }
}

fun main() {
    val consoleUI = LottoConsole()
    val lottoCount = consoleUI.getLottoCount()
    println("로또 번호를 $lottoCount 개 생성합니다.")

    val lottoGenerator = LottoGenerator()
    val lottoNumbers = lottoGenerator.generate(lottoCount)

    lottoNumbers.forEachIndexed { index, numbers ->
        println("티켓 ${index + 1}: ${numbers.joinToString(" ")}")
    }
}