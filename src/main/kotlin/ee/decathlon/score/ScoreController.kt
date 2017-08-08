package ee.decathlon.score

import ee.decathlon.components.ScoreService
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
open class ScoreController(open val scoreService: ScoreService) {

    @RequestMapping("score")
    fun score(): String {

        return scoreService.getScore(0)

    }

}