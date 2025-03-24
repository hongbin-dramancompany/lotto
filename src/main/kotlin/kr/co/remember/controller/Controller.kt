package kr.co.remember.controller

import kr.co.remember.domain.*
import java.util.*

class Controller(val scanner: Scanner) {
    fun run() {
        val lottoCount = readLottoCount()
        val lottoTickets = LottoMachine(lottoCount).purchase()

        val manualLottoCount = readManualLottoCount()
        val wroteLottos = writeLottos(manualLottoCount)
        val manualLottoTickets = ManualLottoMachine(wroteLottos).purchase()

        printAutoLottos(lottoTickets)
        printManualLottos(manualLottoTickets)
    }

    private fun readLottoCount(): Int {
        println("로또 번호를 입력해주세요.")
        return scanner.nextInt()
    }

    private fun readManualLottoCount(): Int {
        println("수동로또 개수를 입력해주세요.")
        return scanner.nextInt()
    }

    private fun writeLottos(manualLottoCount: Int) = (1..manualLottoCount).map { writeLotto() }

private fun writeLotto(): Lotto {
    println("수동 번호를 입력해주세요.")
    val numbers = scanner.next()
        .split(",")
        .mapNotNull { it.trim().toIntOrNull() }
        .map { LottoNumber.of(it) }

    return Lotto(numbers)
}
    private fun printAutoLottos(lottos: List<LottoTicket>) {
        println("구매한 자동 로또")
        lottos.forEach {
            println(it.lotto.numbers.joinToString { lottoNumber -> lottoNumber.number.toString() })
        }
    }

    private fun printManualLottos(lottos: List<LottoTicket>) {
        println("구매한 수동 로또")
        lottos.forEach {
            println(it.lotto.numbers.joinToString { lottoNumber -> lottoNumber.number.toString() })
        }
    }
}