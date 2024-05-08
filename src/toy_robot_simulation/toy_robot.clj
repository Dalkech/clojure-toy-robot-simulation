(ns toy-robot-simulation.toy-robot
  (:require [toy-robot-simulation.commande-manager :as commande-manager]))

(def ^{:private true} coordonate
  {})

(defn toString []
  (str (:x coordonate "")
       (:y coordonate "")
       (:direction coordonate ""))
  )

(defn alreadyPlaced [coordonate]
  (not(= {} coordonate))
  ) 
  
(defn executeCommand [command]
  (let [newPosition (commande-manager/parse command coordonate)]
    (when (not (nil? newPosition))
          (conj coordonate newPosition)))
  )



