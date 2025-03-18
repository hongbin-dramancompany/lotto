package domain

data class Lotto(val winningNumbers: List<Int>, val bonusBall: Int? = null) {
    init {
        require(winningNumbers.size == 6) { "당첨 번호는 6개여야 합니다." }
        require(winningNumbers.distinct().size == 6) { "당첨 번호는 중복될 수 없습니다." }
        require(winningNumbers.all { it in 1..45 }) { "당첨 번호는 1에서 45 범위 내에 있어야 합니다." }
        if (bonusBall != null) {
            require(bonusBall in 1..45) { "보너스 볼 번호는 1에서 45 범위 내에 있어야 합니다." }
            require(bonusBall !in winningNumbers) { "보너스 볼 번호는 당첨 번호와 중복될 수 없습니다." }
        }
    }
}
