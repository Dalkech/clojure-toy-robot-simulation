(ns toy-robot-simulation.commands.move 
  (:require [toy-robot-simulation.global-constant :refer [DIRECTION_KEY EAST
                                                          NORTH SOUTH WEST
                                                          X_KEY Y_KEY]]
            [toy-robot-simulation.map :refer [coordinates-are-valid?]]))

(defn- decrement-coordinate [key coordinates] 
  {key (dec (key coordinates))})

(defn- increment-coordinate [key coordinates]
  {key (inc (key coordinates))})

(defn- create-coordinates [new-coordinate coordinates] 
  (conj coordinates new-coordinate))

(defn- validate-coordinates [new-coordinates coordinates] 
  (if (coordinates-are-valid? new-coordinates)
    new-coordinates
    coordinates))

(defn execute [coordinates]
  (when (seq coordinates)
    (let [direction (DIRECTION_KEY coordinates)]
      (-> (cond
            (= direction NORTH) (increment-coordinate Y_KEY coordinates)
            (= direction WEST) (decrement-coordinate X_KEY coordinates)
            (= direction SOUTH) (decrement-coordinate Y_KEY coordinates)
            (= direction EAST) (increment-coordinate X_KEY coordinates))
          (create-coordinates coordinates)
          (validate-coordinates coordinates)))))