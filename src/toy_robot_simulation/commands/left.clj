(ns toy-robot-simulation.commands.left
  (:require [toy-robot-simulation.global-constant :refer [DIRECTION_KEY EAST
                                                          NORTH SOUTH WEST]]))

(defn newDirection [coordinates direction] 
  (conj coordinates {DIRECTION_KEY direction} )
)

(defn execute [coordinates]
  (let [direction (DIRECTION_KEY coordinates)]
    (cond
      (= direction NORTH) (newDirection coordinates WEST)
      (= direction WEST) (newDirection coordinates SOUTH)
      (= direction SOUTH) (newDirection coordinates EAST)
      (= direction EAST) (newDirection coordinates NORTH)
      )
    ))