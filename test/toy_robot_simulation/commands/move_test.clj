(ns toy-robot-simulation.commands.move-test(:require [clojure.test :refer [deftest testing are is] ]
                                                     [toy-robot-simulation.commands.move :as move]))

(deftest moveCommand
  
  (testing "allowed move from different placements"
    (are [expected start-coordinates] (= expected (move/execute start-coordinates))
     { :x 0 :y 1 :direction "NORTH" } {:x 0 :y 0 :direction "NORTH"}))
  

  (testing "unallowed move"
    (are [expected start-coordinates] (= expected (move/execute start-coordinates))
      {:x 5 :y 5 :direction "NORTH"} {:x 5 :y 5 :direction "NORTH"}))
  
  (testing "not setted"
    (is (empty? (move/execute {})))
    )
  )