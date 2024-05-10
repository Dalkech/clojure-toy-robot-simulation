(ns toy-robot-simulation.toy-robot 
  (:require [toy-robot-simulation.commande-manager :as commande-manager]))

(def ^{:private true} coordinates
  {})

(defn- setCoordinates [newCoordinates]
  (println newCoordinates)
  (def ^{:private true} coordinates (conj coordinates newCoordinates)))

(defn- areCoordinates? [command-result]
  (and (seq command-result) (not(string? command-result)) ))
  
(defn executeCommand [command]
  (let [command-result (commande-manager/parse command coordinates)]
    (if (areCoordinates? command-result) (setCoordinates command-result) command-result )))