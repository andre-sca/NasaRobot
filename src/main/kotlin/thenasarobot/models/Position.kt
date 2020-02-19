package thenasarobot.models

import thenasarobot.service.InvalidPositionException

data class Position(var x: Int, var y: Int) {

    companion object{
        const val maxX = 5
        const val maxY = 5
    }

    fun nextPosition(newX: Int, newY: Int){
        x = newX
        y = newY
    }

    fun isValid(position: Position){
        if(position.y > maxY || position.x > maxX){
            throw InvalidPositionException("You fell into a pit and broke")
        }
    }
}