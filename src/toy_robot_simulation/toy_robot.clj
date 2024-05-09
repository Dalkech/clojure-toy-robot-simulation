(ns toy-robot-simulation.toy-robot
  (:require [toy-robot-simulation.commande-manager :as commande-manager :refer [REPORT]]
            [toy-robot-simulation.global-constant :refer [DIRECTION_KEY X_KEY
                                                          Y_KEY]]))

(def ^{:private true} coordinates
  {})

(defn- setCoordinates [newCoordinates] 
  (def ^{:private true} coordinates (conj coordinates newCoordinates))
  )

(defn toString []
  (if (= {} coordinates) ""
     (str (X_KEY coordinates) \space
          (Y_KEY coordinates) \space
          (DIRECTION_KEY coordinates)))
  )
  
(defn executeCommand [command]

  ;; unique case to avoir useless parsing and process for REPORT COMMAND
  (when (= command REPORT) 
    (toString)) 

  (let [newPosition (commande-manager/parse command coordinates)]
    (println newPosition)
    (when (not (empty? newPosition))
      ;; keeping the position as a private internal state; see later to avoid mutability
      (setCoordinates newPosition))))