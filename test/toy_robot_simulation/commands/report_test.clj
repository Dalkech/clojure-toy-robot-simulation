(ns toy-robot-simulation.commands.report-test
  (:require [clojure.test :refer [deftest testing are]] 
            [toy-robot-simulation.commands.report :refer [execute]]))

(deftest placeCommand
  (testing "multiple wrong placements"
    (are [expected coordinates] (= expected (execute coordinates))
      "1 2 NORTH" {:x 1 :y 2 :direction "NORTH"}
      "5 5 EAST" {:x 5 :y 5 :direction "EAST"} 
      )))