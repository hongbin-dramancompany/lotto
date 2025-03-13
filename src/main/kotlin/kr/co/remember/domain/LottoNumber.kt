package kr.co.remember.domain

data class LottoNumber(val number: Int) {
    companion object {
        const val MAX_NUMBER = 45
        private val CACHE = (1..MAX_NUMBER).map { LottoNumber(it) }

        fun of(number: Int): LottoNumber {
            require(number in 1..MAX_NUMBER) { "로또 번호는 1부터 45까지 가능합니다." }
            return CACHE[number - 1]
        }
    }
}