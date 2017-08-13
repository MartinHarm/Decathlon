package ee.decathlon.score

import ee.decathlon.components.ScoreService
import ee.decathlon.models.ApiException
import ee.decathlon.models.DecathlonEvent
import ee.decathlon.models.Direction
import org.springframework.web.bind.annotation.RequestMethod.GET
import org.springframework.web.bind.annotation.*
import javax.validation.Valid
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import io.swagger.annotations.ApiParam

const val DIRECTION_MISSING_OR_UNSUPPORTED = "DIRECTION UNSPECIFIED OR NOT SUPPORTED"

@RestController
@Api(tags = arrayOf("Score vs Result"), description = "Score and Result operations")
open class ScoreController(open val scoreService: ScoreService) {

    @ApiOperation("Calculate result or score")
    @RequestMapping("/{direction}/calculator", method = arrayOf(GET))
    fun score(@ApiParam("Direction", required = true) @PathVariable @Valid direction: Direction,
              @ApiParam("Value", required = true) @RequestParam @Valid value: String,
              @ApiParam("Event", required = true) @RequestParam @Valid event: DecathlonEvent): String {

        if (direction == Direction.RESULTS)
            return scoreService.calculatePointsBasedOnResult(event, value.toDouble())


        if (direction == Direction.POINTS)
            return scoreService.calculateResultBasedOnPoints(event, value.toDouble())

        throw ApiException(DIRECTION_MISSING_OR_UNSUPPORTED)

    }

}