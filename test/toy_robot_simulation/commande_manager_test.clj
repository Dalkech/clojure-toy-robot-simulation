(ns toy-robot-simulation.commande-manager-test
  (:require [clojure.test :refer [deftest testing are is]]
             [toy-robot-simulation.commande-manager :refer [parse]]))

(deftest ParseWrongCommands
  (testing "multiple wrong command"
    (are [wrong-command] (thrown? Throwable (parse wrong-command {}))
      "WRONGCOMMAND 5 4 1"   
      ""
      "PLACE 2"
      "PLACE 1 2"
      "PLACE NORTH"
     )
    )
  )