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

fun main() {
    var lottoCount: Int? = null

    while (lottoCount == null || lottoCount !in 1..10) { // 1~10 범위로 제한
        try {
            print("구매하실 로또의 갯수를 입력해주세요 (최대 10개): ")
            val input = readln().toIntOrNull() // 안전하게 문자열을 숫자로 변환
            if (input != null && input in 1..10) {
                lottoCount = input // 유효한 값일 경우 저장
            } else {
                println("1에서 10 사이의 숫자를 입력해주세요.")
            }
        } catch (e: Exception) {
            println("유효하지 않은 입력입니다. 다시 시도해주세요.")
        }
    }

    println("로또 번호를 $lottoCount 개 생성합니다.")
    val lottoGenerator = LottoGenerator()
    val lottoNumbers = lottoGenerator.generate(lottoCount)

    lottoNumbers.forEachIndexed { index, numbers ->
        println("티켓 ${index + 1}: ${numbers.joinToString(" ")}")
    }
}