package thenasarobot.models

class Robot(private val position: Position, var direction: Direction) {

    fun rotate(towards: Char) {
        var newAngle = 0

        if (towards == 'R') {
            newAngle = direction.angle - 90
        }
        else if(towards == 'L'){
            newAngle = direction.angle + 90
        }
        //change angle value so it will always be between 0 and 360 degree
        if(newAngle < 0) {
            newAngle = 270
        }
        else if(newAngle >= 360){
            newAngle = 0
        }
        direction = Direction.getDirectionOfAngle(newAngle)
    }

    fun move(){

        when(direction.facingTo){
            'N' -> position.nextPosition(position.x, position.y + 1)
            'E' -> position.nextPosition(position.x + 1, position.y)
            'S' -> position.nextPosition(position.x, position.y - 1)
            'W' -> position.nextPosition(position.x - 1, position.y)
        }
        position.isValid(position)
    }

    override fun toString(): String {
        return "(X:${position.x}, Y:${position.y}, Direction: ${direction.name}"
    }
}