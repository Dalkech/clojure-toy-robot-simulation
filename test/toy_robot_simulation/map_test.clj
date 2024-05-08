(ns toy-robot-simulation.map-test
  (:require [clojure.test :refer [deftest testing are] ]
            [toy-robot-simulation.map :refer [positionIsValid]]))

(deftest outOfBounds
  (testing "out of bounds coordonates"
    (are [x y direction] (not (positionIsValid x y direction))
      -1 0 "NORTH"
      0 -1 "EAST"
      6 5 "SOUTH"
      5 6 "WEST"
      6 6 ""
      -1 -1 ""
      1 1 "NOHRT"
      )
    ) 
  )

(deftest inBounds
  (testing "in bounds coordonates"
    (are [x y direction] (positionIsValid x y direction)
      0 0 "NORTH"
      1 1 "EAST"
      5 5 "SOUTH"
      0 5 "WEST"
      5 0 "NORTH"
      )
    )
  )