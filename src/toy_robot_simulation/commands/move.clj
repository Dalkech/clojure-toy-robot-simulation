(ns toy-robot-simulation.commands.move 
  (:require [toy-robot-simulation.global-constant :refer [DIRECTION_KEY EAST
                                                          NORTH SOUTH WEST
                                                          X_KEY Y_KEY]]
            [toy-robot-simulation.map :refer [coordinatesAreValid?]]))

(defn- decrementCoordinate [key coordinates] 
  {key (dec (key coordinates))}
  )

(defn- incrementCoordinate [key coordinates]
  {key (inc (key coordinates))})

(defn- updateCoordinates [new-coordinate coordinates] 
  (conj coordinates new-coordinate))

(defn- validatePosition [new-coordinate coordinates] 
  (if (coordinatesAreValid? new-coordinate)
    new-coordinate
    coordinates))

(defn execute [coordinates]
  (when (seq coordinates)
    (let [direction (DIRECTION_KEY coordinates)]
      (-> (cond
            (= direction NORTH) (incrementCoordinate Y_KEY coordinates)
            (= direction WEST) (decrementCoordinate X_KEY coordinates)
            (= direction SOUTH) (decrementCoordinate Y_KEY coordinates)
            (= direction EAST) (incrementCoordinate X_KEY coordinates))
          (updateCoordinates coordinates)
          (validatePosition coordinates)))))