(ns toy-robot-simulation.toy-robot 
  (:require [toy-robot-simulation.commande-manager :as commande-manager]))

(def ^{:private true} coordinates
  {})

(defn- set-coordinates [newCoordinates]
  (println newCoordinates)
  (def ^{:private true} coordinates (conj coordinates newCoordinates)))

(defn- are-coordinates? [command-result]
  (and (seq command-result) (not(string? command-result)) ))
  
(defn execute-command [command]
  (let [command-result (commande-manager/execute command coordinates)]
    (if (are-coordinates? command-result) (set-coordinates command-result) command-result )))