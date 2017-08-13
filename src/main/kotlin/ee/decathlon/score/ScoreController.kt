package ee.decathlon.score

import ee.decathlon.components.ScoreService
import ee.decathlon.models.ApiException
import ee.decathlon.models.DecathlonEvent
import ee.decathlon.models.Direction
import org.springframework.web.bind.annotation.RequestMethod.GET
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

const val DIRECTION_MISSING_OR_UNSUPPORTED = "DIRECTION UNSPECIFIED OR NOT SUPPORTED"

@RestController
open class ScoreController(open val scoreService: ScoreService) {

    @RequestMapping("/{direction}/calculator", method = arrayOf(GET))
    fun score(@PathVariable @Valid direction: Direction,
              @RequestParam @Valid value: String,
              @RequestParam @Valid event: DecathlonEvent): String {

        if (direction == Direction.POINTS)
            return scoreService.calculateResultBasedOnPoints(event, value.toDouble())

        if (direction == Direction.RESULTS)
            return scoreService.calculatePointsBasedOnResult(event, value.toDouble())

        throw ApiException(DIRECTION_MISSING_OR_UNSUPPORTED)

    }

}