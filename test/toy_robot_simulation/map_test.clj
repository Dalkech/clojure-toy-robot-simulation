(ns toy-robot-simulation.map-test
  (:require [clojure.test :refer [deftest testing are] ]
            [toy-robot-simulation.map :refer [positionIsValid]]))

(deftest outOfBounds
  (testing "out of bounds coordonates"
    (are [x y] (not (positionIsValid x y))
      -1 0
      0 -1
      6 5
      5 6
      6 6 
      -1 -1
      )
    ) 
  )

(deftest inBounds
  (testing "in bounds coordonates"
    (are [x y] (positionIsValid x y)
      0 0
      1 1
      5 5
      0 5
      5 0
      )
    )
  )