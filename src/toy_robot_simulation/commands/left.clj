(ns toy-robot-simulation.commands.left
  (:require [toy-robot-simulation.global-constant :refer [NORTH EAST SOUTH WEST]]))

(defn newDirection [coordinates direction] 
  (conj coordinates {:direction direction} )
)

(defn execute [coordinates]
  (let [direction (:direction coordinates)]
    (cond
      (= direction NORTH) (newDirection coordinates WEST)
      (= direction WEST) (newDirection coordinates SOUTH)
      (= direction SOUTH) (newDirection coordinates EAST)
      (= direction EAST) (newDirection coordinates NORTH)
      )
    ))