package ee.decathlon.components

import org.springframework.stereotype.Service
import javax.inject.Inject

@Service
open class ScoreServiceImpl @Inject constructor(): ScoreService {

    override fun getScore(id: Int): String {

        return "Result from service"
    }


}