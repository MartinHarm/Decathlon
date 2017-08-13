package ee.decathlon.models

enum class DecathlonEvent(val a: Double,
                          val b: Double,
                          val c: Double) {

    EVENT_100M(25.4347, 18.0, 1.81),
    EVENT_LONG_JUMP(0.14354, 220.0, 1.4),
    EVENT_SHOT_PUT(51.39, 1.5, 1.05),
    EVENT_HIGH_JUMP(0.8465, 75.0, 1.42),
    EVENT_400M(1.53775, 82.0, 1.81),
    EVENT_110M_HURDLES(5.74352, 28.5, 1.92),
    EVENT_DISCUS_THROW(12.91, 4.0, 1.1),
    EVENT_POLE_VAULT(0.2797, 100.0,	1.35),
    EVENT_JAVELIN_THROW(10.14, 7.0, 1.08),
    EVENT_1500M(0.03768, 480.0, 1.85);

}