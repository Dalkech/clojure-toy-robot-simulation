(ns toy-robot-simulation.commands.report)

(defn execute [toy-robot-coordonate]
  (str (:x toy-robot-coordonate "") \space
       (:y toy-robot-coordonate "") \space
       (:direction toy-robot-coordonate "")
       )
  )