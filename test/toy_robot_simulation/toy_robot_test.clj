(ns toy-robot-simulation.toy-robot-test
  (:require [clojure.string :as string]
            [clojure.test :refer [are deftest is testing with-test]]
            [toy-robot-simulation.toy-robot :as robot]))

;; we reload due to private coordonate reset
(defn reloadRobot []
  (use 'toy-robot-simulation.toy-robot :reload))

(defn commandThenPosition [command]
 (robot/executeCommand command)
 (robot/toString))

(deftest emptyPosition
  (testing
   (reloadRobot) 
   (is (string/blank? (robot/toString)))))
  

(deftest multiplePlacement
  (testing 
   (reloadRobot)
   (is (="0 0 NORTH" (commandThenPosition "PLACE 0 0 NORTH")))
   (reloadRobot)
   (is (= "1 1 WEST" (commandThenPosition "PLACE 1 1 WEST")))
   (reloadRobot)
   (is (= "1 5 SOUTH" (commandThenPosition "PLACE 1 5 SOUTH")))))
  
