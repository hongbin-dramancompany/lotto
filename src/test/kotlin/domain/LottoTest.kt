package domain

import generateLottoNumbers
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoTest {

    @Test
    fun `유효한 당첨 번호`() {
        val validNumbers = listOf(1, 2, 3, 4, 5, 6)
        val lotto = Lotto(validNumbers, 7)
        assertEquals(validNumbers, lotto.winningNumbers)
        assertEquals(7, lotto.bonusBall)
    }

    @Test
    fun `유효하지 않은 당첨 번호 - 중복`() {
        val invalidNumbers = listOf(1, 2, 3, 4, 5, 5)
        assertThrows<IllegalArgumentException> {
            Lotto(invalidNumbers, 7)
        }
    }

    @Test
    fun `유효하지 않은 당첨 번호 - 범위 초과`() {
        val invalidNumbers = listOf(1, 2, 3, 4, 5, 46)
        assertThrows<IllegalArgumentException> {
            Lotto(invalidNumbers, 7)
        }
    }

    @Test
    fun `유효하지 않은 보너스 볼 - 중복`() {
        val validNumbers = listOf(1, 2, 3, 4, 5, 6)
        assertThrows<IllegalArgumentException> {
            Lotto(validNumbers, 6)
        }
    }

    @Test
    fun `유효하지 않은 보너스 볼 - 범위 초과`() {
        val validNumbers = listOf(1, 2, 3, 4, 5, 6)
        assertThrows<IllegalArgumentException> {
            Lotto(validNumbers, 46)
        }
    }
}
