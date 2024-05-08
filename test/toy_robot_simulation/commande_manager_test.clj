(ns toy-robot-simulation.commande-manager-test
  (:require [clojure.test :refer [deftest testing are is]]
             [toy-robot-simulation.commande-manager :refer [parse]]))


(deftest ParseCommand
  (testing "wrong command"
    ;; (are [command] (thrown? parse command)
    ;;   "WRONGCOMMAND 5 4 1"
    ;;   "PLACE 5")
    ;; )
    (is (thrown? Throwable (parse "WRONGCOMMAND 5 4 1")) )
   )
  )

  
