(ns toy-robot-simulation.global-constant)

;; cardinals (not the believers)
(def ^:const NORTH "NORTH")
(def ^:const WEST  "WEST" )
(def ^:const SOUTH "SOUTH")
(def ^:const EAST  "EAST" )
(def ^:const CARDINALS #{ NORTH WEST SOUTH EAST })
;; keyWords
(def ^:const X_KEY :x)
(def ^:const Y_KEY :y)
(def ^:const DIRECTION_KEY :direction)
;; map bounds
(def ^:const MIN_EXCLUDED -1)
(def ^:const MAX_EXCLUDED 6)

