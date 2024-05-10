(ns toy-robot-simulation.commande-manager
  (:require [clojure.string :as str]
            [toy-robot-simulation.commands.place :as place]
            [toy-robot-simulation.commands.report :as report]
            [toy-robot-simulation.commands.move :as move]
            [toy-robot-simulation.commands.right :as right]
            [toy-robot-simulation.commands.left :as left]))

(def ^:const PLACE "PLACE")
(def ^:const MOVE "MOVE")
(def ^:const LEFT "LEFT")
(def ^:const RIGHT "RIGHT")
(def ^:const REPORT "REPORT")
(def ^:const ALLOWED_COMMANDS #{"PLACE" "MOVE" "LEFT" "RIGHT" "REPORT"})
(def ^:const PLACE_ARGUMENTS_LENGTH 4)

(defn- splitCommand [command]
  (str/split command #" "))

(defn- throwWrongCommandException [command]
  (throw (Exception. (str "wrong command : " command))))

(defn- isValidCommand? [name]
  (contains? ALLOWED_COMMANDS name))

(defn- isValidPLACECOMMAND? [split]
  (and (= PLACE (first split)) (= PLACE_ARGUMENTS_LENGTH (count split))))

(defn parse [command coordinates]
  (when (str/blank? command)
    (throwWrongCommandException command))

  (let [split (splitCommand command) name (first split)]
    (if (isValidCommand? name)
      (if (isValidPLACECOMMAND? split)
        ;; special case PLACE, ignore the command name and pass the coordinates
        (apply place/execute (conj (subvec split 1) coordinates))
        (cond
          (= name RIGHT) (right/execute coordinates)
          (= name LEFT)  (left/execute coordinates)
          (= name MOVE)  (move/execute coordinates)
          (= name REPORT) (report/execute coordinates)
          :else (throwWrongCommandException command)))
      (throwWrongCommandException command))))