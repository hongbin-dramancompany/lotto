class ManualLottoInput {
    fun inputNumber(): List<Int> {
        val winningNumbers = mutableListOf<Int>()

        while (true) {
            print("당첨 번호 6개를 입력해주세요 (예: 1 2 3 4 5): ")
            val input = readln()
            val numbers = validateLottoNumbers(input)

            if (numbers != null) {
                winningNumbers.addAll(numbers)
                break
            } else {
                println("유효하지 않은 입력입니다. 다시 시도해주세요.")
            }
        }

        while (true) {
            print("보너스 볼 번호를 입력해주세요 (예: 7): ")
            val bonusInput = readln()
            val bonusBall = validateBonusBall(bonusInput, winningNumbers)

            if (bonusBall != null) {
                winningNumbers.add(bonusBall)
                break
            } else {
                println("유효하지 않은 입력입니다. 다시 시도해주세요.")
            }
        }

        return winningNumbers
    }

    private fun validateLottoNumbers(input: String): List<Int>? {
        return try {
            val numbers = input.split(" ").map { it.toInt() }
            if (numbers.size == 5 && numbers.toSet().size == 5 && numbers.all { it in 1..45 }) numbers else null
        } catch (e: NumberFormatException) {
            null
        }
    }

    private fun validateBonusBall(input: String, winningNumbers: List<Int>): Int? {
        return try {
            val bonusBall = input.toInt()
            if (bonusBall in 1..45 && !winningNumbers.contains(bonusBall)) bonusBall else null
        } catch (e: NumberFormatException) {
            null
        }
    }
}