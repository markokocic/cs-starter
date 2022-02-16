(ns cs-starter.core
  (:require react
            [reagent.core :as reagent]
            [reagent.dom :as rdom]
            ["@ionic/react" :as ir]
            ["@ionic/react-router" :as irr]
            ["react-router-dom" :as rrd]))     

(defn home []
  [:> ir/IonPage
    [:> ir/IonHeader
      [:> ir/IonToolbar
        [:> ir/IonTitle "Home Title"]]]
    [:> ir/IonContent {:fullscreen true}
      [:> ir/IonHeader {:collapse "condense"}
        [:> ir/IonToolbar
          [:> ir/IonTitle {:size "large"} "Blank Content"]]]
      "Some text"]])

(defn app-root []
  [:> ir/IonApp
    [:> irr/IonReactRouter
      [:> ir/IonRouterOutlet
        [:> rrd/Route {:exact true :path "/home"}
          [home]]
        [:> rrd/Route {:exact true :path "/"}
          [home]]]]])

(defn init []
  (println "init started")
  (ir/setupIonicReact)
  (rdom/render app-root (.getElementById js/document"root")) 
  (println "init done"))