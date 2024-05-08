(ns toy-robot-simulation.toy-robot-test
  (:require [clojure.string :as string]
            [clojure.test :refer [are deftest is testing]]
            [toy-robot-simulation.commande-manager :as command_manager]
            [toy-robot-simulation.toy-robot :as robot]))

(deftest placement
  (testing "not yet placed"
    (is (string/blank? (robot/toString))))

  (testing "initial placement"
    (are [expected command]
          (= expected (-> (command_manager/parse [command]) 
                          (robot/executeCommand)
                          )
             )
      "0 0 NORTH" "PLACE 0 0 NORTH"
      )
    ) 
  )
