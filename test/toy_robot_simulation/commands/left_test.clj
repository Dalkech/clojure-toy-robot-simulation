(ns toy-robot-simulation.commands.left-test
  (:require [clojure.test :refer :all]
            [toy-robot-simulation.commands.left :as left]))

(deftest rotate
  (testing
    (are [expected startCoordinates] (= expected (left/execute startCoordinates))
      nil {} 
      {:x 1 :y 1 :direction "WEST"}  {:x 1 :y 1 :direction "NORTH"}
      {:x 0 :y 0 :direction "SOUTH"} {:x 0 :y 0 :direction "WEST"}
      {:x 2 :y 3 :direction "EAST"}  {:x 2 :y 3 :direction "SOUTH"}
      {:x 5 :y 2 :direction "NORTH"} {:x 5 :y 2 :direction "EAST"}
      )))