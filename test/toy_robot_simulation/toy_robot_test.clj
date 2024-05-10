(ns toy-robot-simulation.toy-robot-test
  (:require [clojure.test :refer [deftest is testing]]
            [toy-robot-simulation.toy-robot :as robot]))

;; we reload to reset robot's coordinates
(defn reloadRobot []
  (use 'toy-robot-simulation.toy-robot :reload))

(defn commandThenPosition [command]
 (robot/executeCommand command)
 (robot/executeCommand "REPORT"))

(deftest emptyPosition
  (testing
   (reloadRobot) 
   (is (nil? (robot/executeCommand "REPORT")))))

(deftest multiplePlacement
  (testing 
   (reloadRobot)
   (is (="0 0 NORTH" (commandThenPosition "PLACE 0 0 NORTH")))
   (reloadRobot)
   (is (= "1 1 WEST" (commandThenPosition "PLACE 1 1 WEST")))
   (reloadRobot)
   (is (= "1 5 SOUTH" (commandThenPosition "PLACE 1 5 SOUTH")))))

(deftest scenario-a 
  (reloadRobot)
  (robot/executeCommand "PLACE 0 0 NORTH")
  (robot/executeCommand "MOVE")

  (is (= "0 1 NORTH" (robot/executeCommand "REPORT")))
)

(deftest scenario-b
  (reloadRobot)
  (robot/executeCommand "PLACE 0 0 NORTH")
  (robot/executeCommand "LEFT")
  (robot/executeCommand "MOVE")

  (is (= "0 0 WEST" (robot/executeCommand "REPORT"))))

(deftest scenario-c
  (reloadRobot)
  (robot/executeCommand "PLACE 1 2 EAST")
  (robot/executeCommand "MOVE")
  (robot/executeCommand "MOVE")
  (robot/executeCommand "LEFT")
  (robot/executeCommand "MOVE")

  (is (= "3 3 NORTH" (robot/executeCommand "REPORT"))))