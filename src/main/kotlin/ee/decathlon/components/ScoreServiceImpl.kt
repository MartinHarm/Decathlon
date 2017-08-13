package ee.decathlon.components

import ee.decathlon.models.DecathlonEvent
import ee.decathlon.models.DecathlonEvent.*
import org.springframework.stereotype.Service
import javax.inject.Inject

@Service
open class ScoreServiceImpl @Inject constructor(): ScoreService {

    override fun calculatePointsBasedOnResult(event: DecathlonEvent, result: Double): String {

        if (result <= 0.0)
            return "0"

        var scoredPoints: Int = 0

        val a: Double = event.a
        val b: Double = event.b
        val c: Double = event.c

        when(event) {

            EVENT_100M,
            EVENT_110M_HURDLES,
            EVENT_400M,
            EVENT_1500M ->
                scoredPoints = (a * (Math.pow((b - result), c))).toInt()
            EVENT_HIGH_JUMP,
            EVENT_LONG_JUMP,
            EVENT_POLE_VAULT ->
                scoredPoints = (a * (Math.pow((result -b), c))).toInt()

            EVENT_DISCUS_THROW,
            EVENT_JAVELIN_THROW,
            EVENT_SHOT_PUT ->
                scoredPoints = (a * Math.pow((result - b), c)).toInt()

        }

        return scoredPoints.toString()

    }


    override fun calculateResultBasedOnPoints(event: DecathlonEvent, points: Double): String {

        if (points <= 0.0)
            return "0"

        var result: Double = 0.0

        val a: Double = event.a
        val b: Double = event.b
        val c: Double = event.c

        when(event) {

            EVENT_100M,
            EVENT_110M_HURDLES,
            EVENT_400M,
            EVENT_1500M ->
                result = (b - Math.pow((points/a), 1/c))
            EVENT_HIGH_JUMP,
            EVENT_LONG_JUMP,
            EVENT_POLE_VAULT ->
                result = (Math.pow((points/a), 1/c) + b)
            EVENT_DISCUS_THROW,
            EVENT_JAVELIN_THROW,
            EVENT_SHOT_PUT ->
                result = (Math.pow((points/a), 1/c) + b)

        }

        return result.toString()

    }

}