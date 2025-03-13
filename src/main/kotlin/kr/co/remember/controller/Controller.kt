package kr.co.remember.controller

import kr.co.remember.domain.Lotto
import kr.co.remember.domain.LottoMachine
import java.util.*

class Controller(val scanner: Scanner) {
    fun run() {
        val lottoCount = readLottoCount()

        val lottos = LottoMachine(lottoCount).purchase()

        printLottos(lottos)
    }

    private fun readLottoCount(): Int {
        println("로또 번호를 입력해주세요.")
        return scanner.nextInt()
    }

    private fun printLottos(lottos: List<Lotto>) {
        lottos.forEach {
            println(it.numbers.joinToString { lottoNumber -> lottoNumber.number.toString() })
        }
    }
}