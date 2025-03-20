import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class ManualLottoInputTest {

    private val manualLottoInput = ManualLottoInput()

    @Test
    fun `유효한 로또 번호를 검증한다`() {
        val validInput = "1 2 3 4 5"
        val result = manualLottoInput.validateLottoNumbers(validInput)

        assertNotNull(result)
        assertEquals(listOf(1, 2, 3, 4, 5), result)
    }

    @Test
    fun `로또 번호가 중복되면 검증에 실패해야 한다`() {
        val invalidInput = "1 2 3 5 5"
        val result = manualLottoInput.validateLottoNumbers(invalidInput)

        assertNull(result)
    }

    @Test
    fun `로또 번호가 범위를 벗어나면 검증에 실패해야 한다`() {
        val invalidInput = "0 2 3 4 5"
        val result = manualLottoInput.validateLottoNumbers(invalidInput)

        assertNull(result)
    }

    @Test
    fun `보너스 볼이 유효하면 검증에 성공해야 한다`() {
        val winningNumbers = listOf(1, 2, 3, 4, 5)
        val validBonusBall = "7"

        val result = manualLottoInput.validateBonusBall(validBonusBall, winningNumbers)

        assertNotNull(result)
        assertEquals(7, result)
    }

    @Test
    fun `보너스 볼이 당첨 번호와 중복되면 검증에 실패해야 한다`() {
        val winningNumbers = listOf(1, 2, 3, 4, 5)
        val invalidBonusBall = "5"

        val result = manualLottoInput.validateBonusBall(invalidBonusBall, winningNumbers)

        assertNull(result)
    }
}