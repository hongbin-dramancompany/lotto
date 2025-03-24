package kr.co.remember.domain

data class Lotto(val numbers: List<LottoNumber>, val bonusNumber: LottoNumber) {
    companion object {
        const val SIZE = 6
    }

    init {
        require(numbers.size == SIZE) { "로또 번호는 ${SIZE}개여야 합니다." }
        require(numbers.distinct().size == SIZE) { "로또 번호는 중복되지 않아야 합니다." }
        require(bonusNumber.number in numbers.map { it.number }) { "보너스 번호는 로또 번호와 중복되지 않아야 합니다." }
    }
}
