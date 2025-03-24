package kr.co.remember.domain

data class LottoMachine(val lottoCount: Int) {
    init {
        require(lottoCount in 1..100) { "로또 개수는 1~100 사이로 구매할 수 있습니다." }
    }

    fun purchase() = (1..lottoCount).map { Lotto(generateRandomNumbers()) }
        .map { LottoTicket(it) }

    private fun generateRandomNumbers(): List<LottoNumber> = (1..Lotto.SIZE).map {
        val numbers = (1..LottoNumber.MAX_NUMBER).shuffled()
            .take(Lotto.SIZE)
            .sorted()

        return numbers.map { LottoNumber.of(it) }
    }
}
