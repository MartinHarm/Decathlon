import com.nhaarman.mockito_kotlin.doReturn
import com.nhaarman.mockito_kotlin.whenever
import org.junit.Test
import org.junit.runner.RunWith
import org.powermock.modules.junit4.PowerMockRunner;
import ee.decathlon.components.ScoreServiceImpl
import ee.decathlon.models.DecathlonEvent
import java.math.BigDecimal
import org.assertj.core.api.Assertions.assertThat
@RunWith(PowerMockRunner::class)
class ScoreServiceTest {

    private val resultForHundredMeters = "10.002126154396656"
    private val resultForHighJump = "149.967857231543"
    private val resultForDiscusThrow = "4.935709228003751"

    private val service = ScoreServiceImpl()

    @Test
    fun shouldReturnCorrectPoints() {
        assertThat(service.calculatePointsBasedOnResult(DecathlonEvent.EVENT_100M, 10.00)).isEqualTo("1096")
        assertThat(service.calculatePointsBasedOnResult(DecathlonEvent.EVENT_HIGH_JUMP, 200.00)).isEqualTo("803")
        assertThat(service.calculatePointsBasedOnResult(DecathlonEvent.EVENT_DISCUS_THROW, 100.00)).isEqualTo("1956")
    }

    @Test
    fun shouldReturnCorrectResult() {
        assertThat(service.calculateResultBasedOnPoints(DecathlonEvent.EVENT_100M, 1096.00)).isEqualTo(resultForHundredMeters)
        assertThat(service.calculateResultBasedOnPoints(DecathlonEvent.EVENT_HIGH_JUMP, 389.00)).isEqualTo(resultForHighJump)
        assertThat(service.calculateResultBasedOnPoints(DecathlonEvent.EVENT_DISCUS_THROW, 12.00)).isEqualTo(resultForDiscusThrow)

    }
}