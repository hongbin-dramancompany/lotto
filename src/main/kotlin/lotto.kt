fun main() {
    val consoleUI = LottoConsole()
    val lottoCount = consoleUI.getLottoCount()
    println("로또 번호를 $lottoCount 개 생성합니다.")

    val selectMode = consoleUI.selectInputMode()
    val lottoNumbers: List<List<Int>>

    if (selectMode) {
        lottoNumbers = LottoGenerator().generate(lottoCount)
    } else {
        lottoNumbers = LottoGenerator().generate(lottoCount)
    }

    consoleUI.printLottoNumbers(lottoNumbers)
}