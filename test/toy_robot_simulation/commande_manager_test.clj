(ns toy-robot-simulation.commande-manager-test
  (:require [clojure.test :refer [deftest testing are]]
             [toy-robot-simulation.commande-manager :refer [execute]]))

(deftest ParseWrongCommands
  (testing "multiple wrong command"
    (are [wrong-command] (thrown? Throwable (execute wrong-command {}))
      "WRONGCOMMAND 5 4 1"   
      ""
      "PLACE 2"
      "PLACE 1 2"
      "PLACE NORTH"
     )
    )
  )

(deftest ParseGOODCommands
  (testing "multiple wrong command"
    (are [expected command coordinates] (= expected (execute command coordinates))
      {:x 1 :y 1 :direction "NORTH"} "PLACE 1 1 NORTH" {}  
      {:x 1 :y 0 :direction "SOUTH"} "MOVE" {:x 1 :y 1 :direction "SOUTH"}  
      {:x 1 :y 1 :direction "EAST"} "LEFT" {:x 1 :y 1 :direction "SOUTH"} 
      {:x 5 :y 5 :direction "NORTH"} "RIGHT" {:x 5 :y 5 :direction "WEST"} 
      "0 0 WEST" "REPORT" {:x 0 :y 0 :direction "WEST"})))