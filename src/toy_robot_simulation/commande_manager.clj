(ns toy-robot-simulation.commande-manager
  (:require [clojure.string :as str]
            [toy-robot-simulation.commands.place :as place]
            [toy-robot-simulation.commands.report :as report]))

(defn- throwWrongCommandException [command]
  (throw (Exception. (str "wrong command : " command))))

(defn- isValidCommand? [command-name]
  (contains? #{"PLACE" "MOVE" "LEFT" "RIGHT" "REPORT"} command-name))

(defn- isValidPLACECOMMAND? [splitted-command]
  (and (= "PLACE" (first splitted-command)) (<= 4 (count splitted-command))))

(defn- isValidREPORTCOMMAND? [command-name]
  (= "REPORT" command-name)
  )

(defn parse [command toy-robot-coordonate]
  (when (str/blank? command)
    (throwWrongCommandException command))

  (let [splitted-command (str/split command #" ") 
        command-name (first splitted-command)]
    (when (isValidCommand? command-name) 
      (when (isValidPLACECOMMAND? splitted-command)
        ;; we ignore the command name and add to the vector the coordinates
        (apply place/execute (conj (subvec splitted-command 1) toy-robot-coordonate))
       )
      (when (isValidREPORTCOMMAND? splitted-command)
        (report/execute toy-robot-coordonate)
      )
    )
  )
  (throwWrongCommandException command)
  )