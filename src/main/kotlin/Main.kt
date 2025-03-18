import domain.Lotto
import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)
    println("로또 몇 장을 사실건가요? (최대 10장):")
    val numberOfTickets = scanner.nextInt()

    processLottoTickets(numberOfTickets, scanner)
}

fun processLottoTickets(numberOfTickets: Int, scanner: Scanner) {
    if (numberOfTickets in 1..10) {
        // 입력받은 횟수는 고정값이므로 repeat 함수를 사용하여 반복
        repeat(numberOfTickets) {
            println("수동 입력을 원하시면 1, 자동 입력을 원하시면 2를 입력하세요:")
            val inputType = scanner.nextInt()
            val lotto = if (inputType == 1) {
                val winningNumbers = inputWinningNumbers(scanner)
                val bonusBall = inputBonusBall(scanner, winningNumbers)
                Lotto(winningNumbers, bonusBall)
            } else {
                Lotto(generateLottoNumbers())
            }
            println("로또 번호 : ${lotto.winningNumbers}, 보너스 볼 : ${lotto.bonusBall}")
        }
    } else {
        println("잘못 입력하셨습니다. 1~10 사이의 숫자를 입력해주세요.")
    }
}

fun inputWinningNumbers(scanner: Scanner): List<Int> {
    println("당첨 번호 6개를 입력하세요 (1~45, 중복 불가):")

    val winningNumbers = mutableListOf<Int>()

    while (winningNumbers.size < 6) {
        val number = scanner.nextInt()
        if (number in 1..45 && number !in winningNumbers) {
            winningNumbers.add(number)
        } else {
            println("잘못된 번호입니다. 다시 입력해주세요.")
        }
    }

    return winningNumbers
}

fun inputBonusBall(scanner: Scanner, winningNumbers: List<Int>): Int {
    println("보너스 볼 번호를 입력하세요 (1~45, 당첨 번호와 중복 불가):")

    while (true) {
        val bonusBall = scanner.nextInt()
        if (bonusBall in 1..45 && bonusBall !in winningNumbers) {
            return bonusBall
        } else {
            println("잘못된 번호입니다. 다시 입력해주세요.")
        }
    }
}

fun generateLottoNumbers(): List<Int> {
    return (1..45).shuffled().take(6).sorted()
}
