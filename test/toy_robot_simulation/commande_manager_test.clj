(ns toy-robot-simulation.commande-manager-test
  (:require [clojure.test :refer [deftest testing are is]]
             [toy-robot-simulation.commande-manager :refer [parse]]))


(deftest ParseWrongCommands
  (testing "multiple wrong command"
    (are [wrong-command] (thrown? Throwable (parse wrong-command))
      "WRONGCOMMAND 5 4 1"
      ""
      "PLACE 2"
      "PLACE 1 2"
      "PLACE NORTH"
     )
    )
  )

(deftest ParseCorrectCommands
  (are [expected correct-command] (= expected (parse correct-command))
    {:x 1 :y 2 :direction "NORTH"} "PLACE 1 2 NORTH"
    {:x 5 :y 5 :direction "SOUTH"} "PLACE 5 5 SOUTH"
    {:x 4 :y 4 :direction "EAST"} "PLACE 4 4 EAST"
    {:x 3 :y 3 :direction "WEST"} "PLACE 3 3 WEST"
    {:x -1 :y 3 :direction "WEST"} "PLACE -1 3 WEST"
    )
  )
