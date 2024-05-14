(ns toy-robot-simulation.toy-robot-test
  (:require [clojure.test :refer [deftest is testing]]
            [toy-robot-simulation.toy-robot :as robot]))

;; we reload to reset robot's coordinates
(defn reloadRobot []
  (use 'toy-robot-simulation.toy-robot :reload))

(defn commandThenPosition [command]
 (robot/execute-command command)
 (robot/execute-command "REPORT"))

(deftest emptyPosition
  (testing
   (reloadRobot) 
   (is (nil? (robot/execute-command "REPORT")))))

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
  (robot/execute-command "PLACE 0 0 NORTH")
  (robot/execute-command "MOVE")

  (is (= "0 1 NORTH" (robot/execute-command "REPORT")))
)

(deftest scenario-b
  (reloadRobot)
  (robot/execute-command "PLACE 0 0 NORTH")
  (robot/execute-command "LEFT")
  (robot/execute-command "MOVE")

  (is (= "0 0 WEST" (robot/execute-command "REPORT"))))

(deftest scenario-c
  (reloadRobot)
  (robot/execute-command "PLACE 1 2 EAST")
  (robot/execute-command "MOVE")
  (robot/execute-command "MOVE")
  (robot/execute-command "LEFT")
  (robot/execute-command "MOVE")

  (is (= "3 3 NORTH" (robot/execute-command "REPORT"))))