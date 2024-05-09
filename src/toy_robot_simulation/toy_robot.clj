(ns toy-robot-simulation.toy-robot
  (:require [toy-robot-simulation.commande-manager :as commande-manager]
            ))

(def ^{:private true} coordinates
  {})

(defn- setCoordinates [newCoordinates] 
  (def ^{:private true} coordinates (conj coordinates newCoordinates))
  )

(defn toString []
  (if (= {} coordinates) ""
     (str (:x coordinates) \space
          (:y coordinates) \space
          (:direction coordinates)))
  )

(toString)
  
(defn executeCommand [command]
  (let [newPosition (commande-manager/parse command coordinates)] 
    (println newPosition)
    (when (not (nil? newPosition))
      ;; keeping the position as a private internal state; see later to avoid mutability
          (setCoordinates newPosition)))
  )