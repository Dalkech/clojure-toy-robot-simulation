(ns toy-robot-simulation.commands.right-test
    (:require [clojure.test :refer [deftest testing are]]
             [toy-robot-simulation.commands.right :as right]))
  
  (deftest rotate
    (testing
     (are [expected startCoordinates] (= expected (right/execute startCoordinates))
       nil {} 
       {:x 1 :y 1 :direction "EAST"}  {:x 1 :y 1 :direction "NORTH"}
       {:x 0 :y 0 :direction "SOUTH"} {:x 0 :y 0 :direction "EAST"}
       {:x 2 :y 3 :direction "WEST"}  {:x 2 :y 3 :direction "SOUTH"}
       {:x 5 :y 2 :direction "NORTH"} {:x 5 :y 2 :direction "WEST"})))