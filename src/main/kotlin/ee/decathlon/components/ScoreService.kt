package ee.decathlon.components

import ee.decathlon.models.DecathlonEvent

interface ScoreService {

    fun calculatePointsBasedOnResult(event: DecathlonEvent, result: Double): String

    fun calculateResultBasedOnPoints(event: DecathlonEvent, points: Double): String

}