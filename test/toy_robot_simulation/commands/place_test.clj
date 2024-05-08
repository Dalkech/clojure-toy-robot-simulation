(ns toy-robot-simulation.commands.place-test
  (:require [clojure.test :refer [deftest testing are]]
            [toy-robot-simulation.commands.place :refer [execute]]))

(deftest placeCommand
  (testing "multiple wrong placements"
    (are [x y direction] (empty? (execute x y direction {}))
      "-1" "-1" "NORTH"
      "0" "0" "NOPE"
      "6" "6" "KO"))

  (testing "good placements"
  (are [expected x y direction] (= expected (execute x y direction {})) 
    {:x 1 :y 1 :direction "NORTH"} "1" "1" "NORTH"
    {:x 2 :y 0 :direction "EAST"} "2" "0" "EAST"
    {:x 0 :y 1 :direction "SOUTH"} "0" "1" "SOUTH"
    {:x 5 :y 5 :direction "WEST"} "5" "5" "WEST"
    ))
  )

(deftest ignore
  (testing "already placed robot"
    (are [x y direction] (empty? (execute x y direction { :x 1 :y 2 :direction "NORTH"}))
      "0" "0" "NORTH"
      "0" "0" "EAST"
      "5" "5" "WEST"))
)