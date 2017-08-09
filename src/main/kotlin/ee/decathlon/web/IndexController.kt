package ee.decathlon.web

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.servlet.ModelAndView

@Controller
@RequestMapping("/")
open class IndexController {

    @RequestMapping
    fun index(): ModelAndView {

        return ModelAndView("index")
    }

}