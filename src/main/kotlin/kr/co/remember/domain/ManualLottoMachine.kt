package kr.co.remember.domain

data class ManualLottoMachine(val manualLottos: List<Lotto>) {
    fun purchase() = manualLottos.map { LottoTicket(it) }
}
