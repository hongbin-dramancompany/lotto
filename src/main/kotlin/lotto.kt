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