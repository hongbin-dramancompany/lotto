fun main() {
    val consoleUI = LottoConsole()
    val lottoCount = consoleUI.getLottoCount()
    println("로또 번호를 $lottoCount 개 생성합니다.")

    val selectMode = consoleUI.selectInputMode()
    val lottoNumbers: List<List<Int>>

    if (selectMode) {
        lottoNumbers = LottoGenerator().generate(lottoCount)
    } else {
        val manualNumbers = mutableListOf<List<Int>>()
        repeat(lottoCount) {
            manualNumbers.add(ManualLottoInput().inputNumber())
        }
        lottoNumbers = manualNumbers
    }

    consoleUI.printLottoNumbers(lottoNumbers)
}