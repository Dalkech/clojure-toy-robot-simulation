(ns toy-robot-simulation.core
  (:gen-class) 
  (:require [toy-robot-simulation.commande-manager :as commande-manager]
            [toy-robot-simulation.toy-robot :as robot]))



(defn print-summary[]
  (println
  "\nOnly the following commands are accepted :"
   "\n1) PLACE x y direction"
   "\n2) LEFT"
   "\n3) RIGHT"
   "\n4) MOVE"
   "\n5) REPORT"
   "\n\tenter \"exit\" to leave the program\n"
  ))
  
(defn user-input []
  (println "Choose a new command")
  (let [input (read-line)]
    (when (not (= "exit" input))
     (try (-> (robot/executeCommand input) (println )) 
       (catch Exception e (println (.getMessage e))))
     (user-input))))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (print-summary)
  (user-input)
  (println "end"))
  
