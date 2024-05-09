(ns toy-robot-simulation.commande-manager
  (:require [clojure.string :as str]
            [toy-robot-simulation.commands.place :as place]
            [toy-robot-simulation.commands.report :as report]))

(defn- splitCommand[command] 
  (str/split command #" ")
  )

(defn- throwWrongCommandException [command]
  (throw (Exception. (str "wrong command : " command))))

(defn- isValidCommand? [command-name]
  (contains? #{"PLACE" "MOVE" "LEFT" "RIGHT" "REPORT"} command-name))

(defn- isValidPLACECOMMAND? [splitted-command]
  (and (= "PLACE" (first splitted-command)) (>= 3 (count splitted-command))))

(defn parse [command toy-robot-coordonate]
  (when (str/blank? command)
    (throwWrongCommandException command))

  (let [splitted-command (splitCommand command) 
        command-name (first splitted-command)]
    (if (isValidCommand? command-name)
      (if (isValidPLACECOMMAND? splitted-command)
        ;; special case PLACE, ignore the command name and pass the coordinates
        (apply place/execute (conj (subvec splitted-command 1) toy-robot-coordonate))
        (case command-name
          "REPORT" (report/execute toy-robot-coordonate) )
        )
      (throwWrongCommandException command)
      )
    ) 
  )

