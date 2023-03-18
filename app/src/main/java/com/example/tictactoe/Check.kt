package com.example.tictactoe

class Check {
    companion object{
         fun checkForX(boxes: Array<IntArray>): Boolean{
            var valid: Int
            for(row in 0..2){
                valid = 0
                for(column in 0..2){
                    if(boxes[row][column] == 1){
                        valid++
                    }
                }
                if(valid == 3){
                    return true
                }
            }
            for(column in 0..2){
                valid = 0
                for(row in 0..2){
                    if(boxes[row][column] == 1){
                        valid++
                    }
                }
                if(valid == 3){
                    return true
                }
            }
            valid = 0
            for(index in 0..2){
                if(boxes[index][index] == 1){
                    valid++
                }
            }
            if(valid == 3){
                return true
            }
            valid = 0
            for(index in 0..2){
                if(boxes[index][2 - index] == 1){
                    valid++
                }
            }
            if(valid == 3){
                return true
            }
            return false
        }
        fun checkForY(boxes: Array<IntArray>): Boolean{
            var valid: Int
            for(row in 0..2){
                valid = 0
                for(column in 0..2){
                    if(boxes[row][column] == 0){
                        valid++
                    }
                }
                if(valid == 3){
                    return true
                }
            }
            for(column in 0..2){
                valid = 0
                for(row in 0..2){
                    if(boxes[row][column] == 0){
                        valid++
                    }
                }
                if(valid == 3){
                    return true
                }
            }
            valid = 0
            for(index in 0..2){
                if(boxes[index][index] == 0){
                    valid++
                }
            }
            if(valid == 3){
                return true
            }
            valid = 0
            for(index in 0..2){
                if(boxes[index][2 - index] == 0){
                    valid++
                }
            }
            if(valid == 3){
                return true
            }
            return false
        }

        fun draw(boxes: Array<IntArray>): Boolean{
            for(row in 0..2){
                for(column in 0..2){
                    if(boxes[row][column] == -1){
                        return false
                    }
                }
            }
            return true
        }
    }
}