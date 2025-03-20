import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.io.ByteArrayOutputStream
import java.io.PrintStream
import java.util.Scanner

class MainTest {

    @Test
    fun `로또 티켓 수 처리 - 유효한 입력`() {
        val scanner = Scanner("1\n1\n1\n2\n3\n4\n5\n6\n7\n")
        processLottoTickets(1, scanner)
    }

    @Test
    fun `로또 티켓 수 처리 - 유효하지 않은 입력`() {
        val scanner = Scanner("11\n")
        processLottoTickets(11, scanner)
    }

    @Test
    fun `당첨 번호 입력 - 유효한 입력`() {
        val scanner = Scanner("1\n2\n3\n4\n5\n6\n")
        val winningNumbers = inputWinningNumbers(scanner)
        assertEquals(listOf(1, 2, 3, 4, 5, 6), winningNumbers)
    }

    @Test
    fun `당첨 번호 입력 - 유효하지 않은 입력`() {
        val scanner = Scanner("1\n2\n3\n4\n5\n5\n6\n")
        val outputStream = ByteArrayOutputStream()
        val printStream = PrintStream(outputStream)
        val originalOut = System.out
        System.setOut(printStream)

        inputWinningNumbers(scanner)

        System.setOut(originalOut)
        val output = outputStream.toString()
        assertTrue(output.contains("잘못된 번호입니다. 다시 입력해주세요."))
    }

    @Test
    fun `보너스 볼 입력 - 유효한 입력`() {
        val scanner = Scanner("7\n")
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        val bonusBall = inputBonusBall(scanner, winningNumbers)
        assertEquals(7, bonusBall)
    }

    @Test
    fun `보너스 볼 입력 - 유효하지 않은 입력`() {
        val scanner = Scanner("6\n9\n")
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        val outputStream = ByteArrayOutputStream()
        val printStream = PrintStream(outputStream)
        val originalOut = System.out
        System.setOut(printStream)

        inputBonusBall(scanner, winningNumbers)

        System.setOut(originalOut)
        val output = outputStream.toString()
        assertTrue(output.contains("잘못된 번호입니다. 다시 입력해주세요."))
    }

    @Test
    fun `로또 번호 생성`() {
        val lottoNumbers = generateLottoNumbers()
        assertEquals(6, lottoNumbers.size)
        assertEquals(lottoNumbers.distinct().size, lottoNumbers.size)
        assertTrue(lottoNumbers.all { it in 1..45 })
    }
}
