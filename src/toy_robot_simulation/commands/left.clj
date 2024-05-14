(ns toy-robot-simulation.commands.left
  (:require [toy-robot-simulation.global-constant :refer [DIRECTION_KEY EAST
                                                          NORTH SOUTH WEST]]))

(defn set-direction [coordinates direction] 
  (conj coordinates {DIRECTION_KEY direction} )
)

(defn execute [coordinates]
  (let [direction (DIRECTION_KEY coordinates)]
    (cond
      (= direction NORTH) (set-direction coordinates WEST)
      (= direction WEST) (set-direction coordinates SOUTH)
      (= direction SOUTH) (set-direction coordinates EAST)
      (= direction EAST) (set-direction coordinates NORTH)
      )
    ))