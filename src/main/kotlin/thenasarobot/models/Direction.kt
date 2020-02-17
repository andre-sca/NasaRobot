package thenasarobot.models

enum class Direction(val facingTo: Char, val angle: Int) {
    NORTH('N', 0),
    WEST('W', 90),
    SOUTH('S', 180),
    EAST('E', 270);

    companion object {
        fun getDirectionOfAngle(newAngle: Int): Direction {

            return values().first {
                it.angle == newAngle
            }
        }
    }
}