(ns toy-robot-simulation.commande-manager
  (:require [clojure.string :as str]
           [toy-robot-simulation.commands.place :as place] ))


(defn- throwWrongCommandException [command]
  (throw (Exception. (str "wrong command : " command)))
  )

(defn- isValidCommand [splitted-command]
  (contains? #{"PLACE" "MOVE" "LEFT" "RIGHT" "REPORT"} (first splitted-command))
  )

(defn- isValidPLACECOMMAND [splitted-command]
  (and (= "PLACE" (first splitted-command)) (<= 4 (count splitted-command)))
  )

(defn parse [command]
  (if (str/blank? command)
    (throwWrongCommandException command)
    ())

  (let [splitted-command (str/split command #" ")]
      (if (isValidCommand splitted-command)
       (if (isValidPLACECOMMAND splitted-command)
         (apply place/execute (subvec splitted-command 1))
         (throwWrongCommandException command))
         
       (throwWrongCommandException command))
    )
 )

(parse "PLACE 1 2 NORTH")