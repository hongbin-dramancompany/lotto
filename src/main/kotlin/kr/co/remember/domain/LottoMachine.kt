package kr.co.remember.domain

data class LottoMachine(val lottoCount: Int) {
    init {
        require(lottoCount in 1..100) { "로또 개수는 1~100 사이로 구매할 수 있습니다." }
    }

    fun purchase() = (1..lottoCount).map { purchaseOne() }
        .map { LottoTicket(it) }

    private fun purchaseOne(): Lotto {
        val randomNumbers = (1..LottoNumber.MAX_NUMBER).shuffled()
            .take(6)
            .sorted()
        val lottoNumbers = randomNumbers.map { LottoNumber.of(it) }

        val bonusNumber = (1..LottoNumber.MAX_NUMBER)
            .filter { it !in randomNumbers }
            .shuffled()
            .first()
            .let { LottoNumber.of(it) }

        return Lotto(lottoNumbers, bonusNumber)
    }
}
