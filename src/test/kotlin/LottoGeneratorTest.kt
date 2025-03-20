import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class LottoGeneratorTest {

    @Test
    fun `로또 번호는 6개여야 한다`() {
        val lottoGenerator = LottoGenerator()
        val generatedLotto = lottoGenerator.generate(1)

        assertEquals(6, generatedLotto[0].size)
    }

    @Test
    fun `로또 번호는 중복되지 않아야 한다`() {
        val lottoGenerator = LottoGenerator()
        val generatedLotto = lottoGenerator.generate(1)

        assertEquals(6, generatedLotto[0].toSet().size)
    }

    @Test
    fun `로또 번호는 1에서 45 범위 내에 있어야 한다`() {
        val lottoGenerator = LottoGenerator()
        val generatedLotto = lottoGenerator.generate(1)

        assertTrue(generatedLotto[0].all { it in 1..45 })
    }

    @Test
    fun `입력받은 개수만큼 로또를 생성해야 한다`() {
        val lottoGenerator = LottoGenerator()
        val generatedLottoNumbers = lottoGenerator.generate(5)

        assertEquals(5, generatedLottoNumbers.size)
    }
}