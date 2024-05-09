(ns toy-robot-simulation.commands.report)

(defn execute [toy-robot-coordonate]
  (when ()   
  (str (:x toy-robot-coordonate "") \space
       (:y toy-robot-coordonate "") \space
       (:direction toy-robot-coordonate "")
       )
    )
  )