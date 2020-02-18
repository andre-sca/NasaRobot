package thenasarobot.controller

import org.springframework.web.bind.annotation.*
import thenasarobot.models.RobotRequest
import thenasarobot.service.RobotService


@RestController
@RequestMapping("robot")
class RobotController(private val robotService: RobotService) {

    @PostMapping("/action")
    fun robotAction(@RequestBody commandReceived: RobotRequest): String{
       return robotService.action(commandReceived.command)
    }

    @GetMapping("/finalPosition")
    fun getRobotPosition() : String{
       return robotService.getLastPosition()
    }

}



