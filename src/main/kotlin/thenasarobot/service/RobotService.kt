package thenasarobot.service

import org.springframework.stereotype.Service
import thenasarobot.invalidCommand
import thenasarobot.invalidPosition
import thenasarobot.models.Direction
import thenasarobot.models.Position
import thenasarobot.models.Robot

@Service
class RobotService() {

    companion object{
        var robot = Robot(Position(0,0), Direction.NORTH)
    }

    fun action(s: String): String{
        robot = Robot(Position(0,0), Direction.NORTH)
        val listOfCharForAction = s.toCharArray()

        try{
            commandIsValid(s)
        }catch(e: invalidCommand){
            return e.message!!
        }

        listOfCharForAction.map {
            if(it == 'R' || it == 'L'){
                robot.rotate(it)
            }
            else if(it == 'M'){
                try {
                    robot.move()
                } catch(e: invalidPosition){
                   return e.message!!
                }
            }
        }
        return  robot.toString()

    }

    fun commandIsValid(s: String){
        val listOfCharForAction = s.toCharArray()


        listOfCharForAction.map {
            if(it != 'R' || it != 'L' || it != 'M'){
                throw invalidCommand("Invalid command")
            }
        }


    }

    fun getLastPosition(): String{

        return robot.toString()
    }
}