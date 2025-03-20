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

    fun selectInputMode(): Boolean {
        while (true) {
            print("자동 생성(1) 또는 수동 입력(2)을 선택해주세요: ")
            val choice = readln().toInt()

            return when (choice) {
                1 -> true
                2 -> false
                else -> {
                    println("잘못된 선택입니다. 다시 시도해주세요.")
                    false // 기본값 설정
                }
            }
        }
    }

    fun printLottoNumbers(numbers: List<List<Int>>) {
        numbers.forEachIndexed { index, lotto ->
            println("티켓 ${index + 1}: ${lotto.joinToString(" ")}")
        }
    }

    private fun validateLottoCount(inputCount: Int?): Int? {
        return if (inputCount in 1..10) inputCount else null
    }
}