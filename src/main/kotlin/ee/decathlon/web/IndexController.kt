package ee.decathlon.web

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping

@Controller
open class IndexController {

    @RequestMapping
    fun index(): String {

        return "index"
    }

}