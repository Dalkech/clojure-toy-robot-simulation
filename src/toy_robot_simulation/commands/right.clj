(ns toy-robot-simulation.commands.right
   (:require [toy-robot-simulation.global-constant :refer [NORTH
                                                          EAST
                                                          SOUTH WEST]]))

(defn newDirection [coordinates direction]
  (conj coordinates {:direction direction})
  )

(defn execute [coordinates]
  (let [direction (:direction coordinates)]
    (cond 
      (= direction NORTH ) (newDirection coordinates EAST)
      (= direction EAST ) (newDirection coordinates SOUTH)
      (= direction SOUTH)  (newDirection coordinates WEST)
      (= direction WEST ) (newDirection coordinates NORTH)
      )))