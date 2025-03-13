import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)
    println("로또 몇 장을 사실건가요? (최대 10장):")
    val numberOfTickets = scanner.nextInt()

    if (numberOfTickets in 1..10) {
        // 입력받은 횟수는 고정값이므로 repeat 함수를 사용하여 반복
        repeat(numberOfTickets) {
            val lottoNumbers = generateLottoNumbers()
            println("로또 번호 : $lottoNumbers")
        }
    } else {
        println("잘못 입력하셨습니다. 1~10 사이의 숫자를 입력해주세요.")
    }
}

fun generateLottoNumbers(): List<Int> {
    return (1..45).shuffled().take(6).sorted()
}
